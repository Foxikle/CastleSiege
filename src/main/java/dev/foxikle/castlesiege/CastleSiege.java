package dev.foxikle.castlesiege;

import dev.foxikle.castlesiege.managers.GameManager;
import dev.foxikle.castlesiege.managers.ScoreboardUtils;
import dev.foxikle.castlesiege.managers.WorldManager;
import dev.foxikle.castlesiege.managers.testCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class CastleSiege extends JavaPlugin implements Listener {

    private GameManager gameManager;
    private WorldManager worldManager;
    private static CastleSiege instance;
    private ScoreboardUtils scoreboardUtils;

    @Override
    public void onEnable() {
        gameManager = new GameManager(this);
        worldManager = new WorldManager(this);
        instance = this;
        scoreboardUtils = new ScoreboardUtils(this);
        getCommand("test").setExecutor(new testCommand());
        this.saveResource("config.yml", false);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getPluginManager().registerEvents(getInstance(), getInstance());
                Bukkit.getPluginManager().registerEvents(new Listeners(), getInstance());
            }
        }.runTaskLater(this, 1);
    }

    public static CastleSiege getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        try {
            this.getServer().getScoreboardManager().getMainScoreboard().getObjective("health").unregister();
        } catch (NullPointerException ignored){
        }

    }



    public GameManager getGameManager() {
        return gameManager;
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }

    public ScoreboardUtils getScoreboardUtils(){
        return scoreboardUtils;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(gameManager.getGameState() == GameState.PREWAITING)
            gameManager.setGameState(GameState.WAITING);
        gameManager.addPlayer(e.getPlayer());
        scoreboardUtils.updateScoreboard(e.getPlayer());
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().teleport(new Location(Bukkit.getWorld(this.getConfig().getString("worldName")), this.getConfig().getDouble("SpawnPlatformCenterX"), this.getConfig().getDouble("SpawnPlatformCenterY") + 3.5, this.getConfig().getDouble("SpawnPlatformCenterZ")));
        if(Bukkit.getOnlinePlayers().size() >= 10) gameManager.setGameState(GameState.WAITING);
        e.getPlayer().setPlayerListHeader(ChatColor.translateAlternateColorCodes('&', "&b You are playing on &e&lALPHA.FOXIKLE.DEV&b.\n"));
        e.getPlayer().setPlayerListFooter(ChatColor.translateAlternateColorCodes('&', "\n&b Found a bug or exploit? \n &eReport it at &5discord.gg/6YrUX3djex&b!"));
    }
}
