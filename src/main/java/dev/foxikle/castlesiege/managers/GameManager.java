package dev.foxikle.castlesiege.managers;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.songplayer.Fade;
import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.Class;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.Items;
import dev.foxikle.castlesiege.tasks.ScheduleCleanupTask;
import dev.foxikle.castlesiege.tasks.VotingMenuTask;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Team;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;

public class GameManager {
    private final Map<Player, Integer> kills = new HashMap<>();
    private final Map<Player, Integer> deaths = new HashMap<>();
    private final Map<Player, Class> classes = new HashMap<>();
    private final Map<UUID, Integer> blueVotes = new HashMap<>();
    private final Map<UUID, Integer> redVotes = new HashMap<>();
    private final List<Player> blueTeamPlayers = new ArrayList<>();
    private final List<Player> redTeamPlayers = new ArrayList<>();
    private final List<Player> spectators = new ArrayList<>();
    private boolean bGate = true;
    private boolean rGate = true;
    private CastleSiege plugin;
    private Team red;
    private boolean pvp = false;
    private Team blue;
    private TextDisplay bBHHoloGram;
    private TextDisplay rBHHoloGram;
    private Player blueKing;
    private Player redKing;
    private ItemStack crown;
    private GameState gameState = GameState.PREWAITING;
    private int bGateHealth = -1;
    private int rGateHealth = -1;
    public GameManager(CastleSiege plugin) {
        this.plugin = plugin;
    }

    public void addPlayer(Player player) {
        kills.put(player, 0);
        deaths.put(player, 0);
        plugin.getScoreboardUtils().updateScoreboard(player);
    }

    public void addKill(Player player) {
        if(!kills.containsKey(player)){
            kills.put(player, 1);
        }
        int k = kills.get(player) + 1;
        kills.remove(player);
        kills.put(player, k);
    }

    public void addDeath(Player player) {
        if(!deaths.containsKey(player)){
            deaths.put(player, 1);
        }
        int d = deaths.get(player) + 1;
        deaths.remove(player);
        deaths.put(player, d);
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gs) {
        if (gs == GameState.VICTORY && gameState != GameState.SIEGE) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                plugin.getScoreboardUtils().updateScoreboard(player);
                player.sendTitle(ChatColor.GOLD + "GAME ENDED", ChatColor.RED + " by an ADMIN", 30, 100, 30);
                player.sendMessage(ChatColor.RED + "Since this game was ended abrubtly, your stats were not affected!");
            }
            return;
        }
        // Trying to go to a previous game state.
        if ((gs.getOrder() <= gameState.getOrder()) && gs != GameState.PREWAITING) return;
        if (gs == gameState) return;
        gameState = gs;
        switch (gs) {
            case PREWAITING -> {
                plugin.getWorldManager().createSpawnPlatform();
                plugin.getWorldManager().summonClassNPCs();
            }
            case WAITING -> pvp = false;
            case VOTING -> {
                plugin.getMusicManager().globalPlayer.setPlaying(false, new Fade(FadeType.LINEAR, 60));
                setupTeams();
                Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().clear());
                List<Player> lobbyPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
                List<Team> teams = Arrays.asList(blue, red);
                int numTeams = teams.size();
                for (int i = 0; i < lobbyPlayers.size(); i++) {
                    Team t = teams.get(i % numTeams);
                    t.addEntry(lobbyPlayers.get(i).getName());
                    if (t == blue) {
                        blueTeamPlayers.add(lobbyPlayers.get(i));
                    } else if (t == red) {
                        redTeamPlayers.add(lobbyPlayers.get(i));
                    }
                }
                lobbyPlayers.clear();
                for (Player p : redTeamPlayers) {
                    tabName(ChatColor.RED + "" + ChatColor.BOLD + "R " + ChatColor.RESET + "" + ChatColor.RED + p.getName(), p);
                    p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "R " + ChatColor.RESET + "" + ChatColor.RED + p.getName());
                    red.addEntry(p.getName());

                }
                for (Player p : blueTeamPlayers) {
                    tabName(ChatColor.BLUE + "" + ChatColor.BOLD + "B " + ChatColor.RESET + "" + ChatColor.BLUE + p.getName(), p);
                    p.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "B " + ChatColor.RESET + "" + ChatColor.BLUE + p.getName());
                    blue.addEntry(p.getName());
                }
                teleportToBase();
                plugin.getWorldManager().removeSpawnPlatform();
                VotingMenuTask task = new VotingMenuTask(10, this);
                task.runTaskTimer(plugin, 10, 20);
            }
            case PRESIEGE -> {
                plugin.getWorldManager().addBlueGateHologram();
                plugin.getWorldManager().addRedGateHologram();
            }
            case SIEGE -> this.pvp = true;
            case VICTORY -> {
                this.pvp = false;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    plugin.getScoreboardUtils().updateScoreboard(player);
                    player.sendTitle(ChatColor.GOLD + "GAME ENDED", "", 15, 50, 15);
                }
                ScheduleCleanupTask cleanupTask = new ScheduleCleanupTask();
                cleanupTask.runTaskLater(plugin, 100);
                sendEndingMessage();
            }
            case CLEANUP -> {
                if(Bukkit.getScoreboardManager().getMainScoreboard().getObjective("health") != null)
                    Bukkit.getScoreboardManager().getMainScoreboard().getObjective("health").unregister();
                if(red != null)
                    red.getEntries().forEach(entry -> red.removeEntry(entry));
                if(blue != null)
                    blue.getEntries().forEach(entry -> blue.removeEntry(entry));
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setPlayerListName(player.getName());
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                });
                Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("Server is restarting"));
                removeGateHolograms();
                plugin.getWorldManager().removeInteractables();
                plugin.getWorldManager().pasteBGate();
                plugin.getWorldManager().pasteRGate();
                plugin.getWorldManager().addRedCatapultStand();
                plugin.getWorldManager().addBlueCatapultStand();
                setGameState(GameState.PREWAITING);
            }
        }
        Bukkit.getOnlinePlayers().forEach(player -> plugin.getScoreboardUtils().updateScoreboard(player));
    }


    private void setupTeams() {
        Team blue;
        Team red;
        try {
            red = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("red");
            red.setColor(ChatColor.RED);
            red.setCanSeeFriendlyInvisibles(true);
            red.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "R ");
        } catch (IllegalArgumentException ignored) {
            red = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("red");
            red.setColor(ChatColor.RED);
            red.setCanSeeFriendlyInvisibles(true);
            red.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "R ");
        }

        try {
            blue = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("blue");
            blue.setColor(ChatColor.BLUE);
            blue.setCanSeeFriendlyInvisibles(true);
            blue.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "B ");
        } catch (IllegalArgumentException ignored) {
            blue = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("blue");
            blue.setColor(ChatColor.BLUE);
            blue.setCanSeeFriendlyInvisibles(true);
            blue.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "B ");
        }

        this.blue = blue;
        this.red = red;
    }

    private void tabName(String name, Player player) {
        Bukkit.getScheduler().runTask(plugin, () -> player.setPlayerListName(name));
    }

    private void teleportToBase() {
        FileConfiguration config = plugin.getConfig();
        Location red = config.getLocation("RBSpawn");
        Location blue = config.getLocation("BBSpawn");

        for (Player p : redTeamPlayers) {
            p.sendMessage(ChatColor.YELLOW + "You are on the" + ChatColor.RED + " RED " + ChatColor.YELLOW + "team.");
            p.setPlayerListName(ChatColor.RED + p.getName());
            p.teleport(red);
        }
        for (Player p : blueTeamPlayers) {
            p.sendMessage(ChatColor.YELLOW + "You are on the" + ChatColor.BLUE + " BLUE " + ChatColor.YELLOW + "team.");
            p.setPlayerListName(ChatColor.BLUE + p.getName());
            p.teleport(blue);
        }
    }

    public void teleportToBase(Player player, ChatColor team) {
        FileConfiguration config = plugin.getConfig();
        Location red = config.getLocation("RBSpawn");
        Location blue = config.getLocation("BBSpawn");

        if (team == ChatColor.RED) player.teleport(red);
        if (team == ChatColor.BLUE) player.teleport(blue);
    }

    public void giveKit(Player player, Class kit) {
        player.getInventory().clear();
        PlayerInventory inv = player.getInventory();
        if (kit == Class.TANK) {
            inv.addItem(Items.getWoodSword());
            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
            inv.setItemInOffHand(Items.getShield());
            if (getTeamColor(player) == ChatColor.BLUE) {
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
            } else {
                inv.setHelmet(Items.getRedHelmet());
                inv.setBoots(Items.getRedBoots());
            }
            inv.setChestplate(Items.getChestplate());
            classes.put(player, Class.TANK);
        } else if (kit == Class.WARRIOR) {
            inv.addItem(Items.getStoneSword());
            inv.addItem(Items.getWoodenAxe());
            if (getTeamColor(player) == ChatColor.BLUE) {
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
            } else {
                inv.setHelmet(Items.getRedHelmet());
                inv.setBoots(Items.getRedBoots());
            }
            classes.put(player, Class.WARRIOR);
        } else if (kit == Class.ARCHER) {
            inv.addItem(Items.getWoodSword());
            inv.addItem(Items.getBow());
            inv.addItem(new ItemStack(Material.ARROW, 64));
            if (getTeamColor(player) == ChatColor.BLUE) {
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
            } else {
                inv.setHelmet(Items.getRedHelmet());
                inv.setBoots(Items.getRedBoots());
            }
            classes.put(player, Class.ARCHER);
        } else if (kit == Class.WIZARD) {
            inv.addItem(Items.getWoodSword());
            inv.addItem(Items.getBow());
            inv.addItem(new ItemStack(Material.ARROW, 64));
            if (getTeamColor(player) == ChatColor.BLUE) {
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
            } else {
                inv.setHelmet(Items.getRedHelmet());
                inv.setBoots(Items.getRedBoots());
            }
            classes.put(player, Class.WIZARD);
        }
        if (player == this.blueKing || player == this.redKing) {
            inv.setHelmet(crown);
        }
    }

    public void makeVotingInventories() {

        redTeamPlayers.forEach(player -> {
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Pick your " + ChatColor.BOLD + "KING" + ChatColor.RED + ".");
            redTeamPlayers.forEach(p -> inv.addItem(createHead(p)));
            player.openInventory(inv);
        });
        blueTeamPlayers.forEach(player -> {
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Pick your " + ChatColor.BOLD + "KING" + ChatColor.BLUE + ".");
            blueTeamPlayers.forEach(p -> inv.addItem(createHead(p)));
            player.openInventory(inv);
        });
    }

    private ItemStack createHead(Player player) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        ItemMeta headMeta = head.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, "VotingHead");
        headMeta.getCustomTagContainer().setCustomTag(key, ItemTagType.STRING, player.getUniqueId().toString());
        headMeta.setDisplayName(player.getName());

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        ServerPlayer cp = ((CraftPlayer) player).getHandle();
        GameProfile gameProfile = cp.getBukkitEntity().getProfile();
        Property property = gameProfile.getProperties().get("textures").iterator().next();
        profile.getProperties().put("textures", new Property("textures", property.getValue()));
        Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ignored) {

        }
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "Click to vote for " + player.getName());
        headMeta.setLore(lore);
        head.setItemMeta(headMeta);

        return head;
    }

    public void announceKings() {
        UUID rKing = null;
        int rVotes = 0;
        for (UUID uuid : redVotes.keySet()) {

            try {
                rVotes = redVotes.get(uuid);
            } catch (NullPointerException ignore) {
            }
            if (redVotes.get(uuid) >= rVotes) {
                rVotes = redVotes.get(uuid);
                rKing = uuid;
            }
        }
        if(redVotes.isEmpty()){
            rKing = getRedTeamPlayers().get(0).getUniqueId();
        }


        UUID bKing = null;
        int bVotes = 0;

        for (UUID uuid : blueVotes.keySet()) {

            try {
                bVotes = blueVotes.get(uuid);
            } catch (NullPointerException ignore) {
            }
            if (blueVotes.get(uuid) >= bVotes) {
                bVotes = blueVotes.get(uuid);
                bKing = uuid;
            }
        }
        if(blueVotes.isEmpty()){
            bKing = getBlueTeamPlayers().get(0).getUniqueId();
        }


        blueKing = Bukkit.getPlayer(bKing);
        redKing = Bukkit.getPlayer(rKing);

        ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Crown");
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + "Some say this crown");
        lore.add(ChatColor.DARK_GRAY + "brings nothing but");
        lore.add(ChatColor.DARK_GRAY + "greed and conflict.");
        meta.setLore(lore);
        item.setItemMeta(meta);

        crown = item;

        Bukkit.getOnlinePlayers().forEach(player -> player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0));

        blueKing.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
        redKing.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);

        blueKing.setHealth(40);
        redKing.setHealth(40);

        blueKing.sendTitle(ChatColor.YELLOW + "You were chosen to be", ChatColor.GOLD + "" + ChatColor.BOLD + "KING");
        redKing.sendTitle(ChatColor.YELLOW + "You were chosen to be", ChatColor.GOLD + "" + ChatColor.BOLD + "KING");

        blueKing.getInventory().setHelmet(item);
        redKing.getInventory().setHelmet(item);

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('§', "§eThe kings are §c§l" + redKing.getName() + "§r§e and §9§l" + blueKing.getName()));
        Objective obj = Bukkit.getScoreboardManager().getMainScoreboard().registerNewObjective("health", "health", "health", RenderType.INTEGER);
        obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
    }


    public void forceClasses() {
        for (Player player : blueTeamPlayers) {
            if (!classes.containsKey(player)) {
                player.getInventory().clear();
                PlayerInventory inv = player.getInventory();
                inv.addItem(Items.getStoneSword());
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
                if (player == this.blueKing) {
                    inv.setHelmet(crown);
                }
                classes.put(player, Class.WARRIOR);
                player.sendMessage(ChatColor.RED + "You didn't select a class!");
                player.sendMessage(ChatColor.GREEN + "You've been assigned the WARRIOR class :-D");
            }
        }
        for (Player player : redTeamPlayers) {
            if (!classes.containsKey(player)) {
                player.getInventory().clear();
                PlayerInventory inv = player.getInventory();
                inv.addItem(Items.getStoneSword());
                inv.setHelmet(Items.getBlueHelmet());
                inv.setBoots(Items.getBlueBoots());
                if (player == this.redKing) {
                    inv.setHelmet(crown);
                }
                classes.put(player, Class.WARRIOR);
                player.sendMessage(ChatColor.RED + "You didn't select class!");
                player.sendMessage(ChatColor.GREEN + "You've been assigned the WARRIOR class :-D");
            }
        }
    }


    public ChatColor getTeamColor(Player player) {
        if (blueTeamPlayers.contains(player)) return ChatColor.BLUE;
        if (redTeamPlayers.contains(player)) return ChatColor.RED;
        else return ChatColor.GRAY;
    }

    public Class getClass(Player player) {
        return classes.getOrDefault(player, Class.WARRIOR);
    }

    public TextDisplay getbBHHoloGram() {
        return bBHHoloGram;
    }

    public void setbBHHoloGram(TextDisplay bBHHoloGram) {
        this.bBHHoloGram = bBHHoloGram;
    }

    public TextDisplay getrBHHoloGram() {
        return rBHHoloGram;
    }

    public void setrBHHoloGram(TextDisplay rBHHoloGram) {
        this.rBHHoloGram = rBHHoloGram;
    }

    public void updateBlueGateHologram() {
        if (bGateHealth == -1) {
            int max = plugin.getConfig().getInt("GateHealth");
            bGateHealth = max;
            bBHHoloGram.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + max + ChatColor.GRAY + "/" + ChatColor.GREEN + plugin.getConfig().getInt("GateHealth") + ChatColor.GRAY + ")");
            return;
        }
        bBHHoloGram.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + bGateHealth + ChatColor.GRAY + "/" + ChatColor.GREEN + plugin.getConfig().getInt("GateHealth") + ChatColor.GRAY + ")");
    }

    public void updateRedGateHologram() {
        if (rGateHealth == -1) {
            int max = plugin.getConfig().getInt("GateHealth");
            rGateHealth = max;
            rBHHoloGram.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Red Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + max + ChatColor.GRAY + "/" + ChatColor.GREEN + plugin.getConfig().getInt("GateHealth") + ChatColor.GRAY + ")");
            return;
        }
        rBHHoloGram.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Red Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + rGateHealth + ChatColor.GRAY + "/" + ChatColor.GREEN + plugin.getConfig().getInt("GateHealth") + ChatColor.GRAY + ")");
    }

    public void addSpectator(Player player) {
        spectators.add(player);
    }

    public void removeSpectator(Player player) {
        spectators.remove(player);
    }

    public void addBlueTeamMember(Player player) {
        blueTeamPlayers.add(player);
        tabName(ChatColor.BLUE + "" + ChatColor.BOLD + "B " + ChatColor.RESET + "" + ChatColor.BLUE + player.getName(), player);
        player.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "B " + ChatColor.RESET + "" + ChatColor.BLUE + player.getName());
        blue.addEntry(player.getName());
    }

    public void addRedTeamMember(Player player) {
        redTeamPlayers.add(player);
        tabName(ChatColor.RED + "" + ChatColor.BOLD + "R " + ChatColor.RESET + "" + ChatColor.RED + player.getName(), player);
        player.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "R " + ChatColor.RESET + "" + ChatColor.RED + player.getName());
        red.addEntry(player.getName());
    }

    public Map<UUID, Integer> getBlueVotes() {
        return blueVotes;
    }

    public Map<UUID, Integer> getRedVotes() {
        return redVotes;
    }

    public Map<Player, Class> getClasses() {
        return classes;
    }

    public List<Player> getSpectators() {
        return spectators;
    }

    public int getbGateHealth() {
        return bGateHealth;
    }

    public int getrGateHealth() {
        return rGateHealth;
    }

    public List<Player> getBlueTeamPlayers() {
        return blueTeamPlayers;
    }

    public List<Player> getRedTeamPlayers() {
        return redTeamPlayers;
    }

    public void setbGateHealth(int bGateHealth) {
        if(bGateHealth < 0) {
            this.bGateHealth = 0;
            return;
        }
        this.bGateHealth = bGateHealth;
    }

    public void setrGateHealth(int rGateHealth) {
        if(rGateHealth < 0) {
            this.rGateHealth = 0;
            return;
        }
        this.rGateHealth = rGateHealth;
    }

    public boolean isPvp() {
        return pvp;
    }
    public void removeGateHolograms(){
        if(bBHHoloGram != null)
            bBHHoloGram.remove();
        if(rBHHoloGram != null)
            rBHHoloGram.remove();
    }

    public Player getBlueKing() {
        return blueKing;
    }

    public Player getRedKing() {
        return redKing;
    }

    public void sendEndingMessage() {
        Player[] top = new Player[3];
        int[] topint = new int[3];
        for (Player player : kills.keySet()) {
            if (kills.get(player) > topint[0]) {
                topint[2] = topint[1];
                topint[1] = topint[0];
                topint[0] = kills.get(player);

                top[2] = top[1];
                top[1] = top[0];
                top[0] = player;
            }
        }
        try {
            String border = ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + "                                                                   " + ChatColor.RESET;
            String first = ChatColor.GOLD + "" + ChatColor.BOLD + "FIRST" + ChatColor.RESET + " - " + getTeamColor(top[0]) + top[0].getName() + ChatColor.RESET + " - " + ChatColor.GOLD + topint[0];
            int spaces1 = 28 - (first.length() / 2);
            first = StringUtils.repeat(" ", spaces1) + first;

            String second = ChatColor.YELLOW + "" + ChatColor.BOLD + "SECOND" + ChatColor.RESET + " - " + getTeamColor(top[0]) + top[0].getName() + ChatColor.RESET + " - " + ChatColor.YELLOW + topint[0];

            int spaces2 = 28 - (second.length() / 2);
            second = StringUtils.repeat(" ", spaces2) + second;
            String third = ChatColor.RED + "" + ChatColor.BOLD + "THIRD" + ChatColor.RESET + " - " + getTeamColor(top[0]) + top[0].getName() + ChatColor.RESET + " - " + ChatColor.RED + topint[0];
            int spaces3 = 28 - (third.length() / 2);
            third = StringUtils.repeat(" ", spaces3) + third;

            Bukkit.broadcastMessage(border + "\n" + first + "\n" + second + "\n" + third + "\n" + border);
        } catch (NullPointerException ignored){
            Bukkit.getLogger().log(Level.SEVERE, "There was an error printing the end stats.");
        }
    }
    public int getKills(Player player){
        if(kills.containsKey(player)){
            return kills.get(player);
        }
        return 0;
    }

    public int getDeaths(Player player){
        if(deaths.containsKey(player)){
            return deaths.get(player);
        }
        return 0;
    }

    public boolean isbGate() {
        return bGate;
    }

    public boolean isrGate() {
        return rGate;
    }

    public void setbGate(boolean bGate) {
        this.bGate = bGate;
        Bukkit.getOnlinePlayers().forEach(player -> plugin.getScoreboardUtils().updateScoreboard(player));
    }
    public void setrGate(boolean rGate){
        this.rGate = rGate;
        Bukkit.getOnlinePlayers().forEach(player -> plugin.getScoreboardUtils().updateScoreboard(player));
    }
}
