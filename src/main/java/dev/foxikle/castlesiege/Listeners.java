package dev.foxikle.castlesiege;

import dev.foxikle.castlesiege.managers.GameManager;
import dev.foxikle.castlesiege.tasks.PlayerRespawnTask;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;

import java.util.UUID;

import static org.bukkit.Material.AIR;

public class Listeners implements Listener {
    private GameManager manager = CastleSiege.getInstance().getGameManager();
    private CastleSiege plugin = CastleSiege.getInstance();
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        NamespacedKey key = new NamespacedKey(plugin, "VotingHead");
        ItemStack item = e.getCurrentItem();
        CustomItemTagContainer tagContainer = item.getItemMeta().getCustomTagContainer();
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals(ChatColor.GOLD + "Pick your " + ChatColor.BOLD + "KING" + ChatColor.BLUE + ".")) {
            if (tagContainer.getCustomTag(key, ItemTagType.STRING) != null) {
                e.setCancelled(true);
                e.getInventory().setItem(e.getSlot(), e.getCurrentItem());
                e.setCurrentItem(new ItemStack(AIR));
                UUID voted = UUID.fromString(tagContainer.getCustomTag(key, ItemTagType.STRING));
                int votes;
                try {
                    votes = manager.getBlueVotes().get(voted);
                } catch (NullPointerException ignore) {
                    votes = 0;
                }
                manager.getBlueVotes().put(voted, votes + 1);
                player.sendMessage(ChatColor.YELLOW + "You voted for " + ChatColor.RED + Bukkit.getPlayer(voted).getName() + ChatColor.YELLOW + " to be your " + ChatColor.GOLD + "" + ChatColor.BOLD + "KING!");
                player.closeInventory();
            }
        } else if (e.getView().getTitle().equals(ChatColor.GOLD + "Pick your " + ChatColor.BOLD + "KING" + ChatColor.RED + ".")) {
            if (tagContainer.getCustomTag(key, ItemTagType.STRING) != null) {
                e.setCancelled(true);
                e.getInventory().setItem(e.getSlot(), e.getCurrentItem());
                e.setCurrentItem(new ItemStack(AIR));
                UUID voted = UUID.fromString(tagContainer.getCustomTag(key, ItemTagType.STRING));
                int votes;
                try {
                    votes = manager.getRedVotes().get(voted);
                } catch (NullPointerException ignore) {
                    votes = 0;
                }
                manager.getRedVotes().put(voted, votes + 1);
                player.sendMessage(ChatColor.YELLOW + "You voted for " + ChatColor.RED + Bukkit.getPlayer(voted).getName() + ChatColor.YELLOW + " to be your " + ChatColor.GOLD + "" + ChatColor.BOLD + "KING!");
                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onClickEntity(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
            ArmorStand entity = (ArmorStand) e.getRightClicked();
            if (!entity.getScoreboardTags().isEmpty()) {
                if (!manager.getClasses().containsKey(e.getPlayer())) {
                    Player player = e.getPlayer();
                    if (entity.getScoreboardTags().contains("ClassStand")) {
                        if (entity.getScoreboardTags().contains("bTank")) {
                            manager.giveKit(player, Class.TANK);
                            player.sendMessage(ChatColor.GREEN + "You selected the tank class!");
                        } else if (entity.getScoreboardTags().contains("bWarrior")) {
                            manager.giveKit(player, Class.WARRIOR);
                            player.sendMessage(ChatColor.GREEN + "You selected the warrior class!");
                        } else if (entity.getScoreboardTags().contains("bArcher")) {
                            manager.giveKit(player, Class.ARCHER);
                            player.sendMessage(ChatColor.GREEN + "You selected the archer class!");
                        } else if (entity.getScoreboardTags().contains("rTank")) {
                            manager.giveKit(player, Class.TANK);
                            player.sendMessage(ChatColor.GREEN + "You selected the tank class!");
                        } else if (entity.getScoreboardTags().contains("rWarrior")) {
                            manager.giveKit(player, Class.WARRIOR);
                            player.sendMessage(ChatColor.GREEN + "You selected the warrior class!");
                        } else if (entity.getScoreboardTags().contains("rArcher")) {
                            manager.giveKit(player, Class.ARCHER);
                            player.sendMessage(ChatColor.GREEN + "You selected the archer class!");
                        }
                    } else {
                        e.getPlayer().sendMessage(ChatColor.RED + "You've already selected the " + manager.getClasses().get(e.getPlayer()) + " class!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerLoseHunger(FoodLevelChangeEvent e) {
        e.getEntity().setFoodLevel(20);
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent e) {
        if(manager.isPvp()) {
            if (e.getEntity() instanceof Player player) {
                if (e.getDamager() instanceof Player killer) {
                    if (manager.getSpectators().contains(killer)) {
                        e.setCancelled(true);
                        return;
                    }
                    if (manager.getTeamColor(player) == manager.getTeamColor(killer)) {
                        killer.sendMessage(ChatColor.RED + "You cannot attack your team mates!");
                        e.setCancelled(true);
                        return;
                    }
                    if (e.getFinalDamage() >= ((Player) e.getEntity()).getHealth()) {
                        if (killer.getType() == EntityType.PLAYER) {

                            Bukkit.broadcastMessage(manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + " was killed by " + manager.getTeamColor(killer) + killer.getName());
                            player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
                            manager.getClasses().remove(player);
                            manager.addSpectator(player);
                            e.setCancelled(true);
                            player.getInventory().clear();
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                            player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died! ", "", 5, 10, 5);
                            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                            Bukkit.getOnlinePlayers().forEach(player1 -> player1.hidePlayer(plugin, player));
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            if(player == manager.getBlueKing() || player == manager.getRedKing()){
                                manager.setGameState(GameState.VICTORY);
                                return;
                            }
                            manager.addDeath(player);
                            manager.addKill(killer);
                            PlayerRespawnTask task = new PlayerRespawnTask(player, manager.getTeamColor(player), manager, plugin, 6);
                            task.runTaskTimer(plugin, 0, 20);
                        } else if (e.getDamager().getType() == EntityType.ARROW) {
                            Arrow arrow = (Arrow) e.getDamager();
                            if (arrow.getShooter() instanceof Player shooter) {
                                if (manager.getTeamColor(player) == manager.getTeamColor(shooter)) {
                                    shooter.sendMessage(ChatColor.RED + "You cannot shoot your team mates!");
                                }
                                e.setCancelled(true);
                                manager.getClasses().remove(player);
                                manager.addSpectator(player);
                                player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
                                Bukkit.broadcastMessage(manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + " was shot by " + manager.getTeamColor(shooter) + shooter.getName());
                                player.getInventory().clear();

                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                                player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died! ", "", 5, 10, 5);
                                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                                Bukkit.getOnlinePlayers().forEach(player1 -> player1.hidePlayer(plugin, player));
                                player.setAllowFlight(true);
                                player.setFlying(true);
                                if(player == manager.getBlueKing() || player == manager.getRedKing()){
                                    manager.setGameState(GameState.VICTORY);
                                    return;
                                }
                                manager.addDeath(player);
                                manager.addKill(shooter);
                                PlayerRespawnTask task = new PlayerRespawnTask(player, manager.getTeamColor(player), manager, plugin, 6);
                                task.runTaskTimer(plugin, 0, 20);
                            }
                        } else {
                            e.setCancelled(true);
                            manager.getClasses().remove(player);
                            manager.addSpectator(player);
                            player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
                            Bukkit.broadcastMessage(manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + " died.");
                            player.getInventory().clear();

                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                            player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died! ", "", 5, 10, 5);
                            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                            Bukkit.getOnlinePlayers().forEach(player1 -> player1.hidePlayer(plugin, player));
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            if(player == manager.getBlueKing() || player == manager.getRedKing()){
                                manager.setGameState(GameState.VICTORY);
                                return;
                            }
                            manager.addDeath(player);
                            manager.addKill(killer);
                            PlayerRespawnTask task = new PlayerRespawnTask(player, manager.getTeamColor(player), manager, plugin, 6);
                            task.runTaskTimer(plugin, 0, 20);
                        }
                    }
                }
            }
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(EntityDamageEvent e) {
        if (manager.isPvp()) {
            if (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
                e.setCancelled(true);
                return;
            }

            if (e.getEntity() instanceof Player player) {
                if (e.getFinalDamage() >= ((Player) e.getEntity()).getHealth()) {
                    if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
                        e.setCancelled(true);
                        return;
                    }


                    e.setCancelled(true);
                    manager.addSpectator(player);
                    manager.getClasses().remove(player);
                    player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
                    Bukkit.broadcastMessage(manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + " died.");
                    player.getInventory().clear();

                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                    player.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You Died! ", "", 5, 10, 5);
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    Bukkit.getOnlinePlayers().forEach(player1 -> player1.hidePlayer(plugin, player));
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    if(player == manager.getBlueKing() || player == manager.getRedKing()){
                        manager.setGameState(GameState.VICTORY);
                        return;
                    }
                    manager.addDeath(player);
                    PlayerRespawnTask task = new PlayerRespawnTask(player, manager.getTeamColor(player), manager, plugin, 6);
                    task.runTaskTimer(plugin, 0, 20);
                }
            }
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void GateDamageHandler(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.ARMOR_STAND && e.getDamager() instanceof Player player) {
            ArmorStand stand = (ArmorStand) e.getEntity();
            if (!stand.getScoreboardTags().isEmpty()) {
                if (stand.getScoreboardTags().contains("BBGate")) {
                    if(player.getGameMode() == GameMode.CREATIVE){
                        plugin.getWorldManager().knockDownBlueGate();
                        plugin.getWorldManager().removeBlueHitbox();
                        manager.setbGateHealth(0);
                        manager.updateBlueGateHologram();
                        manager.setbGate(false);
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + "!");
                        manager.getBlueTeamPlayers().forEach(player1 -> {
                            player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                            player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                        });
                        return;
                    }
                    e.setCancelled(true);
                    if (manager.getTeamColor(player) == ChatColor.BLUE) {
                        player.sendMessage(ChatColor.RED + "You cannot damage your own gate!");
                    } else {

                        manager.setbGateHealth(manager.getbGateHealth() - (int) e.getDamage());
                        if (manager.getbGateHealth() <= 0) {
                            plugin.getWorldManager().knockDownBlueGate();
                            plugin.getWorldManager().removeBlueHitbox();
                            manager.setbGate(false);
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + "!");
                            manager.getBlueTeamPlayers().forEach(player1 -> {
                                player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                                player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                            });
                        }
                        manager.updateBlueGateHologram();
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRON_GOLEM_REPAIR, .6f, 1);
                    }
                } else if (stand.getScoreboardTags().contains("RBGate")) {
                    if(player.getGameMode() == GameMode.CREATIVE){
                        plugin.getWorldManager().knockDownRedGate();
                        plugin.getWorldManager().removeRedHitbox();
                        manager.setrGateHealth(0);
                        manager.updateRedGateHologram();
                        manager.setrGate(false);
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.RED + "" + ChatColor.BOLD + "RED " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName());
                        manager.getRedTeamPlayers().forEach(player1 -> {
                            player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                            player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                        });
                        return;
                    }
                    e.setCancelled(true);
                    if (manager.getTeamColor(player) == ChatColor.RED) {
                        player.sendMessage(ChatColor.RED + "You cannot damage your own gate!");
                    } else {
                        manager.setrGateHealth(manager.getrGateHealth()-(int) e.getDamage());
                        if (manager.getrGateHealth() <= 0) {
                            plugin.getWorldManager().knockDownRedGate();
                            plugin.getWorldManager().removeRedHitbox();
                            manager.setrGate(false);
                            Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.RED + "" + ChatColor.BOLD + "RED " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName());
                            manager.getRedTeamPlayers().forEach(player1 -> {
                                player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                                player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                            });
                        }
                        manager.updateRedGateHologram();
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRON_GOLEM_REPAIR, .6f, 1);
                    }
                }
            }
        }  else if (e.getDamager().getType() == EntityType.ARROW && e.getEntity().getType() == EntityType.ARMOR_STAND){
            Arrow arrow = (Arrow) e.getDamager();
            if (arrow.getShooter() instanceof Player player) {
                e.setCancelled(true);
                ArmorStand stand = (ArmorStand) e.getEntity();
                if (!stand.getScoreboardTags().isEmpty()) {
                    if (stand.getScoreboardTags().contains("BBGate")) {
                        e.setCancelled(true);
                        if (manager.getTeamColor(player) == ChatColor.BLUE) {
                            player.sendMessage(ChatColor.RED + "You cannot damage your own gate!");
                        } else {
                            manager.setbGateHealth(manager.getbGateHealth()-(int) e.getDamage());
                            if (manager.getbGateHealth() <= 0) {
                                plugin.getWorldManager().knockDownBlueGate();
                                plugin.getWorldManager().removeBlueHitbox();
                                manager.setbGate(false);
                                Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName() + ChatColor.YELLOW + "!");
                                manager.getBlueTeamPlayers().forEach(player1 -> {
                                    player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                                    player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                                });
                            }
                            manager.updateBlueGateHologram();
                            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRON_GOLEM_REPAIR, .6f, 1);
                        }
                    } else if (stand.getScoreboardTags().contains("RBGate")) {
                        e.setCancelled(true);
                        if (manager.getTeamColor(player) == ChatColor.RED) {
                            player.sendMessage(ChatColor.RED + "You cannot damage your own gate!");
                        } else {
                            manager.setrGateHealth(manager.getrGateHealth()-(int) e.getDamage());
                            if (manager.getrGateHealth() <= 0) {
                                plugin.getWorldManager().knockDownRedGate();
                                plugin.getWorldManager().removeRedHitbox();
                                manager.setrGate(false);
                                Bukkit.broadcastMessage(ChatColor.YELLOW + "The " + ChatColor.RED + "" + ChatColor.BOLD + "RED " + ChatColor.RESET + "" + ChatColor.YELLOW + "gate was destroyed by " + manager.getTeamColor(player) + player.getName());
                                manager.getRedTeamPlayers().forEach(player1 -> {
                                    player1.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "GATE DESTROYED", "by " + manager.getTeamColor(player) + player.getName(), 5, 20, 5);
                                    player1.playSound(player1.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                                });
                            }
                            manager.updateRedGateHologram();
                            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRON_GOLEM_REPAIR, .6f, 1);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void Action(PlayerInteractEvent e){
        if(e.getPlayer().getGameMode() == GameMode.ADVENTURE){
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.PHYSICAL || e.getAction() == Action.LEFT_CLICK_BLOCK){
                e.setCancelled(true);
            }
        }
    }
}
