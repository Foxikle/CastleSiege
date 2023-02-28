package dev.foxikle.castlesiege.managers;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScoreboardUtils {
    private final CastleSiege plugin;
    private final GameManager manager = CastleSiege.getInstance().getGameManager();
    private int time;
    public ScoreboardUtils(CastleSiege plugin){
        this.plugin = plugin;
    }

    public void updateScoreboard(Player player) {
        Scoreboard board = player.getScoreboard();
        if (!(manager.getGameState() == GameState.WAITING) && !(manager.getGameState() == GameState.PREWAITING)) {
            try {
                Objective obj = board.registerNewObjective("SideBar", "dummy", ChatColor.YELLOW + "" + ChatColor.BOLD + "Castle Siege");
            } catch (IllegalArgumentException ignored) {
                Objective obj1 = board.getObjective("SideBar");
                obj1.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj1.unregister();

                Objective obj = board.registerNewObjective("SideBar", "dummy", ChatColor.YELLOW + "" + ChatColor.BOLD + "Castle Siege");
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                Score date = obj.getScore(ChatColor.GRAY + getDateString());
                date.setScore(9);

                Score filler1 = obj.getScore(ChatColor.translateAlternateColorCodes('&',"&eGame State: &b" + manager.getGameState()));
                filler1.setScore(8);

                Score filler2 = obj.getScore(" ");
                filler2.setScore(7);

                Score playerStat = obj.getScore(ChatColor.translateAlternateColorCodes('&', "&aKills: &f" + manager.getKills(player) + "&0&l | &eDeaths: &r&f " + manager.getDeaths(player)));
                playerStat.setScore(6);

                Score filler4 = obj.getScore(" ");
                filler4.setScore(5);

                Score filler5 = obj.getScore(" ");
                filler5.setScore(4);

                Score blueKing;
                if(manager.isbGate()){
                    blueKing = obj.getScore(ChatColor.BLUE + "" + ChatColor.BOLD + "B" + ChatColor.WHITE + " Blue gate: " + ChatColor.GREEN + "✓");
                } else {
                    blueKing = obj.getScore(ChatColor.BLUE + "" + ChatColor.BOLD + "B" +  ChatColor.WHITE + " Blue gate: " + ChatColor.RED + " ✗");
                }
                blueKing.setScore(3);

                Score redGate;
                if(manager.isrGate()){
                    redGate = obj.getScore(ChatColor.RED + "" + ChatColor.BOLD + "R" + ChatColor.WHITE + " Red  gate: " + ChatColor.GREEN + "✓");
                } else {
                    redGate = obj.getScore(ChatColor.RED + "" + ChatColor.BOLD + "R" + ChatColor.WHITE + " Red  gate: " + ChatColor.RED + " ✗");
                }
                redGate.setScore(3);

                Score filler3 = obj.getScore("       ");
                filler3.setScore(2);

                Score filler6 = obj.getScore(ChatColor.YELLOW + "alpha.foxikle.dev");
                filler6.setScore(1);

                player.setScoreboard(board);
            }
        } else {
            try {
                Objective obj = board.registerNewObjective("SideBar", "dummy", ChatColor.YELLOW + "" + ChatColor.BOLD + "Castle Siege");
            } catch (IllegalArgumentException ignored) {
                Objective obj1 = board.getObjective("SideBar");
                obj1.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj1.unregister();

                Objective obj = board.registerNewObjective("SideBar", "dummy", ChatColor.YELLOW + "" + ChatColor.BOLD + "Castle Siege");
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                Score date = obj.getScore(ChatColor.GRAY + getDateString());
                date.setScore(8);

                Score filler2 = obj.getScore("    ");
                filler2.setScore(7);

                Score players = obj.getScore("Players " + ChatColor.GREEN + " (" + Bukkit.getOnlinePlayers().size() + "/10)");
                players.setScore(6);

                Score filler4 = obj.getScore("      ");
                filler4.setScore(5);

                Score blueKing = obj.getScore("Starting in " + ChatColor.GREEN + time + "s");
                blueKing.setScore(4);

                Score version = obj.getScore("Version: " + ChatColor.GRAY + "v" + plugin.getDescription().getVersion());
                version.setScore(3);

                Score filler5 = obj.getScore(" ");
                filler5.setScore(2);

                Score filler6 = obj.getScore(ChatColor.YELLOW + "alpha.foxikle.dev");
                filler6.setScore(1);

                player.setScoreboard(board);
            }
        }
    }
    private String getDateString() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

        String dateStr = dateFormat.format(date);

        return dateStr;
    }

    public void setTime(int time) {
        this.time = time;
        Bukkit.getOnlinePlayers().forEach(this::updateScoreboard);
    }

}
