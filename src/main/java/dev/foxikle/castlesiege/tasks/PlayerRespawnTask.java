package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerRespawnTask extends BukkitRunnable {
    private int timeLeft;
    private final GameManager gm;
    private final ChatColor team;
    private final CastleSiege plugin;
    private final Player player;
    public PlayerRespawnTask(Player player, ChatColor team, GameManager gm, CastleSiege plugin, int seconds){
        this.timeLeft = seconds;
        this.gm = gm;
        this.plugin = plugin;
        this.team = team;
        this.player = player;
    }

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0){
            cancel();
            gm.teleportToBase(player, team);
            player.setAllowFlight(false);
            player.setFlying(false);
            Bukkit.getOnlinePlayers().forEach(player1 -> player1.showPlayer(plugin, player));
            gm.giveKit(player, gm.getClass(player));
            gm.removeSpectator(player);
            return;
        }

        switch (timeLeft) {
            case 5, 1, 2, 3, 4 -> {
                player.sendTitle(ChatColor.YELLOW + "Respawning in " + timeLeft, "", 5, 5, 5);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.8f, 1f);
            }
        }
    }
}
