package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EndClassSelectionTask extends BukkitRunnable {
    private int timeLeft;
    private final GameManager manager;

    public EndClassSelectionTask(GameManager manager, int timeLeft){
        this.manager = manager;
        this.timeLeft = timeLeft;
    }

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0){
            cancel();
            manager.setGameState(GameState.SIEGE);
            manager.forceClasses();
            return;
        }

        switch (timeLeft) {
            case 10 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }

            case 5 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.sendTitle(ChatColor.YELLOW + "5", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 4 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "4", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 3 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "3", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 2 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.sendTitle(ChatColor.GOLD + "2", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
            case 1 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.GREEN + "The siege begins in " + timeLeft);
                    player.sendTitle(ChatColor.RED + "1", ChatColor.RED + "", 5, 10, 5);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }
        }
    }
}
