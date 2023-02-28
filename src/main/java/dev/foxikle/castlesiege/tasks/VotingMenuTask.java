package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VotingMenuTask extends BukkitRunnable {

    private final GameManager gm;
    private int delay;
    public VotingMenuTask(int delay, GameManager gm){
        this.delay = delay;
        this.gm = gm;
    }

    @Override
    public void run() {
        delay--;
        if(delay <= 0){
            cancel();
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Vote for your " + ChatColor.GOLD + "" + ChatColor.BOLD + "KING" + ChatColor.RESET + "" + ChatColor.YELLOW + "!");
            gm.makeVotingInventories();
            EndVotingTask task = new EndVotingTask(10, gm);
            task.runTaskTimer(CastleSiege.getInstance(), 20, 20);
            return;
        }

        switch (delay) {
            case 10 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 10 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }

            case 5 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.GREEN + "5", "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 5 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.8f, 1f);
                }
            }
            case 4 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.GREEN + "4", "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 4 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.7f, 1f);
                }
            }
            case 3 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.YELLOW + "3", "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 3 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.6f, 1f);
                }
            }
            case 2 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.GOLD + "2", "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 2 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.5f, 1f);
                }
            }
            case 1 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.RED + "1", ChatColor.RED + "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting begins in 1 second!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.4f, 1f);
                }
            }
        }
    }
}
