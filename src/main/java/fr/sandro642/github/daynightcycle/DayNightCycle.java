package fr.sandro642.github.daynightcycle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Calendar;
import java.util.logging.Logger;

public class DayNightCycle extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("DayNightCycle");

    @Override
    public void onEnable() {
        logger.info("PLugin lancé !");


        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncRepeatingTask(this, this::updateGameTime, 0L, 20L);
    }

    private void updateGameTime() {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        World world = Bukkit.getWorlds().get(0);

        long time = calculateGameTime(hourOfDay);
    }

    private long calculateGameTime(int hourOfDay) {
        long tickPerHour = 1000;
        long startTimeOfDay = 6000;
        long timeOfDayIncrement = tickPerHour / 24;

        return startTimeOfDay + (hourOfDay *timeOfDayIncrement);
    }
}
