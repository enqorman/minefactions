package io.github.enqorman.minefactions.timers;

import org.bukkit.scheduler.BukkitRunnable;

import io.github.enqorman.minefactions.MineFactionsPlugin;
import io.github.enqorman.minefactions.manager.Faction;
import io.github.enqorman.minefactions.manager.FactionManager;

public class DTRTimer extends BukkitRunnable {
    private int currentTick = 0;

    @Override
    public void run() {
        MineFactionsPlugin plugin = MineFactionsPlugin.getInstance();
        FactionManager factionManager = plugin.getFactionManager();

        // code
        for (Faction faction : factionManager.getFactions()) {
            int dtr = faction.getDTR();
            if (dtr < 5)
                faction.setDTR(faction.getDTR() + 1);
        }

        // 72000 = 1 irl hour
        if (currentTick == 72_000) {
            currentTick = 0;
            return;
        }

        currentTick++;
    }
}
