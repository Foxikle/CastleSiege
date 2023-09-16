package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {
    private final GameManager manager;
    private int timeLeft;

    public GameStartCountdownTask(GameManager manager, int seconds){
        this.manager = manager;
        this.timeLeft = seconds;
    }

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0){
            cancel();
            manager.setGameState(GameState.VOTING);
            CastleSiege.getInstance().getWorldManager().summonClassNPCs();
            return;
        }

        CastleSiege.getInstance().getScoreboardUtils().setTime(timeLeft);

        switch (timeLeft) {
            case 10 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }

            case 5 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.sendTitle(ChatColor.YELLOW + "5", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 4 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "4", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 3 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "3", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 2 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "2", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 1 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "Starting in " + timeLeft);
                    player.sendTitle(ChatColor.RED + "1", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
        }
    }
}
