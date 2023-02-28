package dev.foxikle.castlesiege.managers;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.Items;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;
import java.util.List;

public class WorldManager {
    private final CastleSiege plugin;

    public WorldManager(CastleSiege plugin) {
        this.plugin = plugin;
    }

    public void createSpawnPlatform() {
        FileConfiguration config = plugin.getConfig();
        Location loc = new Location(plugin.getServer().getWorld(config.getString("worldName")), config.getInt("SpawnPlatformCenterX"), config.getInt("SpawnPlatformCenterY"), config.getInt("SpawnPlatformCenterZ"));
        int x = (int) loc.getX();
        int y = (int) loc.getY();
        int z = (int) loc.getZ();
        World world = loc.getWorld();
        world.setSpawnLocation(loc);

        Bukkit.getScheduler().runTask(plugin, () -> {
            world.getBlockAt(x, y, z).setType(Material.BEACON);
            world.getBlockAt(x + 1, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 5, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 5, y, z).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 5, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 5, y, z + 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 5, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 5, y, z - 1).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z - 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z - 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z + 2).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 4, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 4, y, z + 3).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z - 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 2, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 3, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 2, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 3, y, z + 4).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z - 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z - 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z - 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x, y, z + 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y, z + 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x - 1, y, z + 5).setType(Material.GRAY_STAINED_GLASS);
            world.getBlockAt(x + 1, y + 1, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE); // WALLS V LAYER 1
            world.getBlockAt(x + 1, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 2, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 1, z - 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x + 4, y + 1, z - 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 1, z - 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 1, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 5, y + 1, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 1, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 2, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 1, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 1, z - 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x - 4, y + 1, z - 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 1, z - 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 1, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 1, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 1, y + 1, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 1, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 2, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 1, z + 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x + 4, y + 1, z + 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 1, z + 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 1, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 5, y + 1, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 1, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 2, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 1, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 1, z + 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x - 4, y + 1, z + 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 1, z + 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 1, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 1, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 1, z).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x + 5, y + 1, z).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x, y + 1, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x, y + 1, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x + 1, y + 2, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE); // WALLS LAYER 2 V
            world.getBlockAt(x + 1, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 2, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 2, z - 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x + 4, y + 2, z - 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 2, z - 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 2, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 5, y + 2, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 2, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 2, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 2, z - 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 2, z - 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x - 4, y + 2, z - 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 2, z - 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 2, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 2, z - 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 1, y + 2, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 1, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 2, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 3, y + 2, z + 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x + 4, y + 2, z + 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 2, z + 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 4, y + 2, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x + 5, y + 2, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 2, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 1, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 2, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 2, z + 4).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 3, y + 2, z + 3).setType(Material.COBBLED_DEEPSLATE_WALL);
            world.getBlockAt(x - 4, y + 2, z + 3).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 2, z + 2).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 4, y + 2, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 2, z + 1).setType(Material.WHITE_STAINED_GLASS_PANE);
            world.getBlockAt(x - 5, y + 2, z).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x + 5, y + 2, z).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x, y + 2, z + 5).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x, y + 2, z - 5).setType(Material.WHITE_STAINED_GLASS_PANE, true);
            world.getBlockAt(x - 3, y + 3, z + 2).setType(Material.DARK_PRISMARINE_SLAB);// ROOF V
            world.getBlockAt(x - 3, y + 3, z + 1).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 2, y + 3, z + 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 1, y + 3, z + 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 3, y + 3, z - 2).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 3, y + 3, z - 1).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 2, y + 3, z - 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 1, y + 3, z - 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 3, y + 3, z + 2).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 3, y + 3, z + 1).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 2, y + 3, z + 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 1, y + 3, z + 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 3, y + 3, z - 2).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 3, y + 3, z - 1).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 2, y + 3, z - 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 1, y + 3, z - 3).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x + 4, y + 3, z).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x - 4, y + 3, z).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x, y + 3, z + 4).setType(Material.DARK_PRISMARINE_SLAB);
            world.getBlockAt(x, y + 3, z - 4).setType(Material.DARK_PRISMARINE_SLAB);
        });
    }

    public void removeSpawnPlatform() {
        FileConfiguration config = plugin.getConfig();
        Location loc = new Location(plugin.getServer().getWorld(config.getString("worldName")), config.getInt("SpawnPlatformCenterX"), config.getInt("SpawnPlatformCenterY"), config.getInt("SpawnPlatformCenterZ"));
        int x = (int) loc.getX();
        int y = (int) loc.getY();
        int z = (int) loc.getZ();
        World world = loc.getWorld();

        Bukkit.getScheduler().runTask(plugin, () -> {
            world.getBlockAt(x, y, z).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z).setType(Material.AIR);
            world.getBlockAt(x + 5, y, z).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z).setType(Material.AIR);
            world.getBlockAt(x - 5, y, z).setType(Material.AIR);
            world.getBlockAt(x, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y, z + 1).setType(Material.AIR);
            world.getBlockAt(x, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y, z - 1).setType(Material.AIR);
            world.getBlockAt(x, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z - 2).setType(Material.AIR);
            world.getBlockAt(x, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z - 3).setType(Material.AIR);
            world.getBlockAt(x, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z + 2).setType(Material.AIR);
            world.getBlockAt(x, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y, z + 3).setType(Material.AIR);
            world.getBlockAt(x, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z - 4).setType(Material.AIR);
            world.getBlockAt(x, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y, z + 4).setType(Material.AIR);
            world.getBlockAt(x, y, z - 5).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z - 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z - 5).setType(Material.AIR);
            world.getBlockAt(x, y, z + 5).setType(Material.AIR);
            world.getBlockAt(x + 1, y, z + 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y, z + 5).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 1, z - 5).setType(Material.AIR); // WALLS V LAYER 1
            world.getBlockAt(x + 1, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 1, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y + 1, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 1, z - 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 1, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 1, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 1, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 1, z + 5).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 1, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 1, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y + 1, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 1, z + 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 1, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 1, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 1, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 1, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 1, z).setType(Material.AIR, true);
            world.getBlockAt(x + 5, y + 1, z).setType(Material.AIR, true);
            world.getBlockAt(x, y + 1, z + 5).setType(Material.AIR, true);
            world.getBlockAt(x, y + 1, z - 5).setType(Material.AIR, true);
            world.getBlockAt(x + 1, y + 2, z - 5).setType(Material.AIR); // WALLS LAYER 2 V
            world.getBlockAt(x + 1, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 2, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y + 2, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 2, z - 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 2, z - 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 2, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 2, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 2, z + 5).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 2, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 2, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 5, y + 2, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 2, z + 5).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 2, z + 4).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 2, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z + 2).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 2, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 2, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 5, y + 2, z).setType(Material.AIR, true);
            world.getBlockAt(x + 5, y + 2, z).setType(Material.AIR, true);
            world.getBlockAt(x, y + 2, z + 5).setType(Material.AIR, true);
            world.getBlockAt(x, y + 2, z - 5).setType(Material.AIR, true);
            world.getBlockAt(x - 3, y + 3, z + 2).setType(Material.AIR);// ROOF V
            world.getBlockAt(x - 3, y + 3, z + 1).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 3, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 3, z + 3).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 3, z - 2).setType(Material.AIR);
            world.getBlockAt(x - 3, y + 3, z - 1).setType(Material.AIR);
            world.getBlockAt(x - 2, y + 3, z - 3).setType(Material.AIR);
            world.getBlockAt(x - 1, y + 3, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 3, z + 2).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 3, z + 1).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 3, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 3, z + 3).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 3, z - 2).setType(Material.AIR);
            world.getBlockAt(x + 3, y + 3, z - 1).setType(Material.AIR);
            world.getBlockAt(x + 2, y + 3, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 1, y + 3, z - 3).setType(Material.AIR);
            world.getBlockAt(x + 4, y + 3, z).setType(Material.AIR);
            world.getBlockAt(x - 4, y + 3, z).setType(Material.AIR);
            world.getBlockAt(x, y + 3, z + 4).setType(Material.AIR);
            world.getBlockAt(x, y + 3, z - 4).setType(Material.AIR);
        });
    }

    public void summonClassStands() {
        FileConfiguration config = plugin.getConfig();
        World world = plugin.getServer().getWorld(config.getString("worldName"));

        // BLUE

        Location bWarriorLoc = new Location(world, config.getDouble("BBWarriorX"), config.getDouble("BBWarriorY"), config.getDouble("BBWarriorZ"));
        ArmorStand bWarrior = (ArmorStand) world.spawnEntity(bWarriorLoc, EntityType.ARMOR_STAND);
        bWarrior.setArms(true);
        bWarrior.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Warrior Class");
        bWarrior.setCustomNameVisible(true);
        bWarrior.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        bWarrior.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        bWarrior.setLeftArmPose(new EulerAngle(0, 0, 5.39307));
        bWarrior.setInvulnerable(true);
        bWarrior.setBasePlate(false);
        bWarrior.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
        bWarrior.getEquipment().setItemInOffHand(Items.getWoodenAxe());
        bWarrior.getEquipment().setBoots(Items.getBlueBoots());
        bWarrior.getEquipment().setHelmet(Items.getBlueHelmet());
        bWarrior.setRotation(-90, 0);
        bWarrior.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bWarrior.addScoreboardTag("bWarrior");
        bWarrior.addScoreboardTag("ClassStand");

        Location bTankLoc = new Location(world, config.getDouble("BBTankX"), config.getDouble("BBTankY"), config.getDouble("BBTankZ"));

        ArmorStand bTank = (ArmorStand) world.spawnEntity(bTankLoc, EntityType.ARMOR_STAND);
        bTank.setArms(true);
        bTank.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Tank Class");
        bTank.setCustomNameVisible(true);
        bTank.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        bTank.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        bTank.setLeftArmPose(new EulerAngle(4.86947, 0.226893, 6.07375));
        bTank.setRightArmPose(new EulerAngle(5.89921, 5.63741, 0.366519));
        bTank.setInvulnerable(true);
        bTank.setBasePlate(false);
        bTank.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
        bTank.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
        bTank.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        bTank.getEquipment().setBoots(Items.getBlueBoots());
        bTank.getEquipment().setHelmet(Items.getBlueHelmet());
        bTank.setRotation(-90, 0);
        bTank.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bTank.addScoreboardTag("bTank");
        bTank.addScoreboardTag("ClassStand");

        Location bArcherLoc = new Location(world, config.getDouble("BBArcherX"), config.getDouble("BBArcherY"), config.getDouble("BBArcherZ"));

        ArmorStand bArcher = (ArmorStand) world.spawnEntity(bArcherLoc, EntityType.ARMOR_STAND);
        bArcher.setArms(true);
        bArcher.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Archer Class");
        bArcher.setCustomNameVisible(true);
        bArcher.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        bArcher.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        bArcher.setRightArmPose(new EulerAngle(4.97419, 5.74213, 6.28319));      //  285 329 360
        bArcher.setLeftArmPose(new EulerAngle(4.86947, 0.436332, 6.28319));    //  279 25 360
        bArcher.setInvulnerable(true);
        bArcher.setBasePlate(false);
        bArcher.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
        bArcher.getEquipment().setBoots(Items.getBlueBoots());
        bArcher.getEquipment().setHelmet(Items.getBlueHelmet());
        bArcher.setRotation(-90, 0);
        bArcher.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bArcher.addScoreboardTag("bArcher");
        bArcher.addScoreboardTag("ClassStand");
        // RED

        Location rWarriorLoc = new Location(world, config.getDouble("RBWarriorX"), config.getDouble("RBWarriorY"), config.getDouble("RBWarriorZ"));

        ArmorStand rWarrior = (ArmorStand) world.spawnEntity(rWarriorLoc, EntityType.ARMOR_STAND);
        rWarrior.setArms(true);
        rWarrior.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Warrior Class");
        rWarrior.setCustomNameVisible(true);
        rWarrior.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        rWarrior.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        rWarrior.setLeftArmPose(new EulerAngle(0, 0, 5.39307));
        rWarrior.setInvulnerable(true);
        rWarrior.setBasePlate(false);
        rWarrior.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
        rWarrior.getEquipment().setItemInOffHand(Items.getWoodenAxe());
        rWarrior.getEquipment().setBoots(Items.getRedBoots());
        rWarrior.getEquipment().setHelmet(Items.getRedHelmet());
        rWarrior.setRotation(-45, 0);
        rWarrior.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rWarrior.addScoreboardTag("rWarrior");
        rWarrior.addScoreboardTag("ClassStand");

        Location rTankLoc = new Location(world, config.getDouble("RBTankX"), config.getDouble("RBTankY"), config.getDouble("RBTankZ"));

        ArmorStand rTank = (ArmorStand) world.spawnEntity(rTankLoc, EntityType.ARMOR_STAND);
        rTank.setArms(true);
        rTank.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Tank Class");
        rTank.setCustomNameVisible(true);
        rTank.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        rTank.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        rTank.setLeftArmPose(new EulerAngle(4.86947, 0.226893, 6.07375));
        rTank.setRightArmPose(new EulerAngle(5.89921, 5.63741, 0.366519));
        rTank.setInvulnerable(true);
        rTank.setBasePlate(false);
        rTank.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
        rTank.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
        rTank.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        rTank.getEquipment().setBoots(Items.getRedBoots());
        rTank.getEquipment().setHelmet(Items.getRedHelmet());
        rTank.setRotation(-45, 0);
        rTank.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rTank.addScoreboardTag("rTank");
        rTank.addScoreboardTag("ClassStand");

        Location rArcherLoc = new Location(world, config.getDouble("RBArcherX"), config.getDouble("RBArcherY"), config.getDouble("RBArcherZ"));

        ArmorStand rArcher = (ArmorStand) world.spawnEntity(rArcherLoc, EntityType.ARMOR_STAND);
        rArcher.setArms(true);
        rArcher.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Archer Class");
        rArcher.setCustomNameVisible(true);
        rArcher.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        rArcher.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        rArcher.setRightArmPose(new EulerAngle(4.97419, 5.74213, 6.28319));      //  285 329 360
        rArcher.setLeftArmPose(new EulerAngle(4.86947, 0.436332, 6.28319));    //  279 25 360
        rArcher.setInvulnerable(true);
        rArcher.setBasePlate(false);
        rArcher.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
        rArcher.getEquipment().setBoots(Items.getRedBoots());
        rArcher.getEquipment().setHelmet(Items.getRedHelmet());
        rArcher.setRotation(-45, 0);
        rArcher.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rArcher.addScoreboardTag("rArcher");
        rArcher.addScoreboardTag("ClassStand");
    }

    public void knockDownBlueGate() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int stop = config.getInt("BBWidth");
        int stopHeight = config.getInt("BBHeight");
        double x = config.getDouble("BBGateX");
        double y = config.getDouble("BBGateY");
        double z = config.getDouble("BBGateZ");
        List<ArmorStand> armorStands = new ArrayList<>();
        for (int i = 0; i < stopHeight * 2; i++) {
            for (int i1 = 0; i1 < stop; i1++) {
                Location loc = new Location(world, x - i1, y - 2 + i * .5, z);
                ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                as.getEquipment().setHelmet(new ItemStack(Material.ANDESITE_WALL));
                as.setVisible(false);
                as.setGravity(false);
                as.setRotation(0, 0);
                armorStands.add(as);
            }
        }

        for (int i = 0; i < stopHeight; i++) {
            for (int i1 = 0; i1 < stop * 2; i1++) {
                Location loc = new Location(world, x - i1, y + i, z);
                if (loc.getBlock().getType() == Material.IRON_BARS) {
                    loc.getBlock().setType(Material.BARRIER);
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for (ArmorStand sh : armorStands) {
                    sh.teleport(new Location(world, sh.getLocation().getX(), sh.getLocation().getY() - .5, sh.getLocation().getZ()));
                    if (sh.getLocation().getY() <= 5) {
                        armorStands.clear();
                        for (int i = 0; i < stopHeight; i++) {
                            for (int i1 = 0; i1 < stop * 2; i1++) {
                                Location loc = new Location(world, x - i1, y + i, z);
                                if (loc.getBlock().getType() == Material.BARRIER) {
                                    loc.getBlock().setType(Material.AIR, false);
                                }
                            }
                        }
                        cancel();
                    }
                }
            }
        }.runTaskTimer(CastleSiege.getInstance(), 5, 3);
    }

    public void knockDownRedGate() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int stop = config.getInt("RBWidth");
        int stopHeight = config.getInt("RBHeight");
        double x = config.getDouble("RBGateX");
        double y = config.getDouble("RBGateY");
        double z = config.getDouble("RBGateZ");
        List<ArmorStand> armorStands = new ArrayList<>();
        for (int i = 0; i < stopHeight * 2; i++) {
            for (int i1 = 0; i1 < stop; i1++) {
                Location loc = new Location(world, x - i1, y - 2 + i * .5, z);
                ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                as.getEquipment().setHelmet(new ItemStack(Material.POLISHED_DEEPSLATE_WALL));
                as.setVisible(false);
                as.setGravity(false);
                as.setRotation(90, 0);
                armorStands.add(as);
            }
        }

        for (int i = 0; i < stopHeight; i++) {
            for (int i1 = 0; i1 < stop * 2; i1++) {
                Location loc = new Location(world, x - i1, y + i, z);
                if (loc.getBlock().getType() == Material.IRON_BARS || loc.getBlock().getType() == Material.DEEPSLATE_TILE_WALL || loc.getBlock().getType() == Material.NETHER_BRICK_FENCE || loc.getBlock().getType() == Material.POLISHED_DEEPSLATE || loc.getBlock().getType() == Material.ANVIL) {
                    loc.getBlock().setType(Material.BARRIER);
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for (ArmorStand sh : armorStands) {
                    sh.teleport(new Location(world, sh.getLocation().getX(), sh.getLocation().getY() - .5, sh.getLocation().getZ()));
                    if (sh.getLocation().getY() < 6) {
                        for (int i = 0; i < stopHeight; i++) {
                            for (int i1 = 0; i1 < stop * 2; i1++) {
                                Location loc = new Location(world, x - i1, y + i, z);
                                if (loc.getBlock().getType() == Material.BARRIER) {
                                    loc.getBlock().setType(Material.AIR, false);
                                }
                            }
                        }
                        cancel();
                    }
                }
            }
        }.runTaskTimer(CastleSiege.getInstance(), 5, 3);
    }

    public void pasteRGate() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int x = config.getInt("RBGateX");
        int y = config.getInt("RBGateY");
        int z = config.getInt("RBGateZ");

        for (int i = 0; i < 13; i++) {
            world.getBlockAt(x - i, y, z).setType(Material.NETHER_BRICK_FENCE, true);
            world.getBlockAt(x - i, y + 1, z).setType(Material.DEEPSLATE_TILE_WALL, true);
            world.getBlockAt(x - i, y + 2, z).setType(Material.DEEPSLATE_TILE_WALL, true);
            world.getBlockAt(x - i, y + 3, z).setType(Material.DEEPSLATE_TILE_WALL, true);
            world.getBlockAt(x - i, y + 4, z).setType(Material.DEEPSLATE_TILE_WALL, true);
        }

        world.getBlockAt(x - 2, y + 4, z).setType(Material.POLISHED_DEEPSLATE, true);
        world.getBlockAt(x - 1, y + 4, z).setType(Material.POLISHED_DEEPSLATE, true);
        world.getBlockAt(x - 6, y + 4, z).setType(Material.POLISHED_DEEPSLATE, true);
        world.getBlockAt(x - 11, y + 4, z).setType(Material.POLISHED_DEEPSLATE, true);
        world.getBlockAt(x - 10, y + 4, z).setType(Material.POLISHED_DEEPSLATE, true);

        world.getBlockAt(x - 2, y + 5, z).setType(Material.ANVIL, true);
        world.getBlockAt(x - 1, y + 5, z).setType(Material.ANVIL, true);
        world.getBlockAt(x - 6, y + 5, z).setType(Material.ANVIL, true);
        world.getBlockAt(x - 11, y + 5, z).setType(Material.ANVIL, true);
        world.getBlockAt(x - 10, y + 5, z).setType(Material.ANVIL, true);
    }

    public void pasteBGate() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int x = config.getInt("BBGateX");
        int y = config.getInt("BBGateY");
        int z = config.getInt("BBGateZ");

        for (int i = 0; i < 5; i++) {
            world.getBlockAt(x - i, y, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 1, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 2, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 3, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 4, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 5, z - 1).setType(Material.IRON_BARS, true);
            world.getBlockAt(x - i, y + 6, z - 1).setType(Material.IRON_BARS, true);
        }
    }

    public void addBlueHitbox() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int stop = config.getInt("BBWidth");
        int stopHeight = config.getInt("BBHeight") / 2;
        double x = config.getDouble("BBGateX");
        double y = config.getDouble("BBGateY");
        double z = config.getDouble("BBGateZ");
        for (int i = 0; i < stopHeight * 2; i++) {
            for (int i1 = 0; i1 < stop * 2; i1++) {
                Location loc = new Location(world, x - (i1 * .5), y + i, z);
                ArmorStand stand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
                stand.addScoreboardTag("BBGate");
                stand.setInvisible(true);
                stand.setGravity(false);
            }
        }
    }

    public void addRedHitbox() {
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        int stop = config.getInt("RBWidth");
        int stopHeight = config.getInt("RBHeight") / 2;
        double x = config.getDouble("RBGateX");
        double y = config.getDouble("RBGateY");
        double z = config.getDouble("RBGateZ");
        for (int i = 0; i < stopHeight * 2; i++) {
            for (int i1 = 0; i1 < stop * 2; i1++) {
                Location loc = new Location(world, x - (i1 * .5), y + i, z);
                ArmorStand stand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
                stand.addScoreboardTag("RBGate");
                stand.setInvisible(true);
                stand.setGravity(false);
            }
        }
    }
    public void addBlueGateHologram(){
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        double xB = config.getDouble("BBGateHologramX");
        double yB = config.getDouble("BBGateHologramY");
        double zB = config.getDouble("BBGateHologramZ");
        Location bLoc = new Location(world, xB, yB, zB);
        ArmorStand bStand = (ArmorStand) world.spawnEntity(bLoc, EntityType.ARMOR_STAND);
        bStand.addScoreboardTag("BBGateHologram");
        bStand.setInvisible(true);
        bStand.setGravity(false);
        bStand.setMarker(true);
        bStand.setCustomNameVisible(true);
        bStand.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + "%Health%" + ChatColor.GRAY + "/" + ChatColor.GREEN + config.getInt("BBGateHealth") + ChatColor.GRAY + ")");

        GameManager manager = CastleSiege.getInstance().getGameManager();
        manager.setbBHHoloGram(bStand);
        manager.updateBlueGateHologram();



    }

    public void addRedGateHologram(){
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        double xR = config.getDouble("RBGateHologramX");
        double yR = config.getDouble("RBGateHologramY");
        double zR = config.getDouble("RBGateHologramZ");
        Location loc = new Location(world, xR, yR, zR);
        ArmorStand rStand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        rStand.addScoreboardTag("RBGateHologram");
        rStand.setInvisible(true);
        rStand.setGravity(false);
        rStand.setMarker(true);
        rStand.setCustomNameVisible(true);
        rStand.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Red Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + "%Health%" + ChatColor.GRAY + "/" + ChatColor.GREEN + config.getInt("RBGateHealth") + ChatColor.GRAY + ")");
        GameManager manager = CastleSiege.getInstance().getGameManager();
        manager.setrBHHoloGram(rStand);
        manager.updateRedGateHologram();
    }

    public void removeBlueHitbox(){
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        world.getEntities().forEach(entity -> {
            if(entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("BBGate")){
                entity.remove();
            }
        });
    }

    public void removeRedHitbox(){
        World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
        world.getEntities().forEach(entity -> {
            if(entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("RBGate")){
                entity.remove();
            }
        });
    }
}
