package dev.foxikle.castlesiege;

import dev.foxikle.castlesiege.commands.ClassCommand;
import dev.foxikle.castlesiege.commands.TestCommand;
import dev.foxikle.castlesiege.managers.GameManager;
import dev.foxikle.castlesiege.managers.MusicManager;
import dev.foxikle.castlesiege.managers.ScoreboardUtils;
import dev.foxikle.castlesiege.managers.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class CastleSiege extends JavaPlugin implements Listener {

    private GameManager gameManager;
    private WorldManager worldManager;
    private MusicManager musicManager;
    private static CastleSiege instance;
    private ScoreboardUtils scoreboardUtils;

    @Override
    public void onEnable() {
        this.saveResource("config.yml", false);
        this.saveResource("lobbymusic.nbs", false);
        gameManager = new GameManager(this);
        worldManager = new WorldManager(this);
        musicManager = new MusicManager(this);
        musicManager.setup("lobbymusic.nbs");
        instance = this;
        scoreboardUtils = new ScoreboardUtils(this);
        getCommand("test").setExecutor(new TestCommand());
        getCommand("class").setExecutor(new ClassCommand(this));
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

    public MusicManager getMusicManager() {
        return musicManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(gameManager.getGameState() == GameState.PREWAITING)
            gameManager.setGameState(GameState.WAITING);
        gameManager.addPlayer(e.getPlayer());
        scoreboardUtils.updateScoreboard(e.getPlayer());
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().teleport(getConfig().getLocation("SpawnPlatformCenter").add(0, 6, 0));
        if(Bukkit.getOnlinePlayers().size() >= 10) gameManager.setGameState(GameState.WAITING);
        e.getPlayer().setPlayerListHeader(ChatColor.translateAlternateColorCodes('&', "&b You are playing on &e&lALPHA.FOXIKLE.DEV&b.\n"));
        e.getPlayer().setPlayerListFooter(ChatColor.translateAlternateColorCodes('&', "\n&b Found a bug or exploit? \n &eReport it at &5discord.gg/6YrUX3djex&b!"));
    }


}
