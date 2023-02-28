package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EndVotingTask extends BukkitRunnable {
    private final GameManager gm;
    private int delay;

    public EndVotingTask(int delay, GameManager gm){
        this.delay = delay;
        this.gm = gm;
    }

    @Override
    public void run() {
        delay--;
        if(delay <= 0){
            cancel();
            gm.setGameState(GameState.PRESIEGE);
            gm.announceKings();
            EndClassSelectionTask task = new EndClassSelectionTask(gm, 20);
            task.runTaskTimer(CastleSiege.getInstance(), 0, 20);
            return;
        }

        switch (delay) {
            case 10 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting Ends in 10 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1f, 1f);
                }
            }

            case 5 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.GREEN + "5", "", 5, 10, 5);
                    player.sendMessage(ChatColor.YELLOW + "Voting ends in 5 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.8f, 1f);
                }
            }
            case 4 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting ends in 4 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.7f, 1f);
                }
            }
            case 3 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting ends in 3 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.6f, 1f);
                }
            }
            case 2 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting ends in 2 seconds!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.5f, 1f);
                }
            }
            case 1 -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage(ChatColor.YELLOW + "Voting ends in 1 second!");
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,.4f, 1f);
                }
            }
        }
    }
}
