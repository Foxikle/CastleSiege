package dev.foxikle.castlesiege.tasks;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import org.bukkit.scheduler.BukkitRunnable;


public class ScheduleCleanupTask extends BukkitRunnable {

    @Override
    public void run() {
        CastleSiege.getInstance().getGameManager().setGameState(GameState.CLEANUP);
    }
}
