package dev.foxikle.castlesiege.managers;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.Items;
import dev.foxikle.customnpcs.api.Action;
import dev.foxikle.customnpcs.api.ActionType;
import dev.foxikle.customnpcs.api.NPCApi;
import dev.foxikle.customnpcs.api.conditions.Conditional;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Transformation;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.*;

public class WorldManager {
    private final CastleSiege plugin;

    public WorldManager(CastleSiege plugin) {
        this.plugin = plugin;
    }

    public void createSpawnPlatform() {
        FileConfiguration config = plugin.getConfig();
        Location loc = config.getLocation("SpawnPlatformCenter");
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
        Location loc = config.getLocation("SpawnPlatformCenter");
        int x = (int) loc.getX();
        int y = (int) loc.getY();
        int z = (int) loc.getZ();
        World world = loc.getWorld();

        Bukkit.getScheduler().runTask(plugin, () -> {
            world.getBlockAt(x, y, z).setType(AIR);
            world.getBlockAt(x + 1, y, z).setType(AIR);
            world.getBlockAt(x + 2, y, z).setType(AIR);
            world.getBlockAt(x + 3, y, z).setType(AIR);
            world.getBlockAt(x + 4, y, z).setType(AIR);
            world.getBlockAt(x + 5, y, z).setType(AIR);
            world.getBlockAt(x - 1, y, z).setType(AIR);
            world.getBlockAt(x - 2, y, z).setType(AIR);
            world.getBlockAt(x - 3, y, z).setType(AIR);
            world.getBlockAt(x - 4, y, z).setType(AIR);
            world.getBlockAt(x - 5, y, z).setType(AIR);
            world.getBlockAt(x, y, z + 1).setType(AIR);
            world.getBlockAt(x + 1, y, z + 1).setType(AIR);
            world.getBlockAt(x + 2, y, z + 1).setType(AIR);
            world.getBlockAt(x + 3, y, z + 1).setType(AIR);
            world.getBlockAt(x + 4, y, z + 1).setType(AIR);
            world.getBlockAt(x + 5, y, z + 1).setType(AIR);
            world.getBlockAt(x - 1, y, z + 1).setType(AIR);
            world.getBlockAt(x - 2, y, z + 1).setType(AIR);
            world.getBlockAt(x - 3, y, z + 1).setType(AIR);
            world.getBlockAt(x - 4, y, z + 1).setType(AIR);
            world.getBlockAt(x - 5, y, z + 1).setType(AIR);
            world.getBlockAt(x, y, z - 1).setType(AIR);
            world.getBlockAt(x + 1, y, z - 1).setType(AIR);
            world.getBlockAt(x + 2, y, z - 1).setType(AIR);
            world.getBlockAt(x + 3, y, z - 1).setType(AIR);
            world.getBlockAt(x + 4, y, z - 1).setType(AIR);
            world.getBlockAt(x + 5, y, z - 1).setType(AIR);
            world.getBlockAt(x - 1, y, z - 1).setType(AIR);
            world.getBlockAt(x - 2, y, z - 1).setType(AIR);
            world.getBlockAt(x - 3, y, z - 1).setType(AIR);
            world.getBlockAt(x - 4, y, z - 1).setType(AIR);
            world.getBlockAt(x - 5, y, z - 1).setType(AIR);
            world.getBlockAt(x, y, z - 2).setType(AIR);
            world.getBlockAt(x + 1, y, z - 2).setType(AIR);
            world.getBlockAt(x + 2, y, z - 2).setType(AIR);
            world.getBlockAt(x + 3, y, z - 2).setType(AIR);
            world.getBlockAt(x + 4, y, z - 2).setType(AIR);
            world.getBlockAt(x - 1, y, z - 2).setType(AIR);
            world.getBlockAt(x - 2, y, z - 2).setType(AIR);
            world.getBlockAt(x - 3, y, z - 2).setType(AIR);
            world.getBlockAt(x - 4, y, z - 2).setType(AIR);
            world.getBlockAt(x, y, z - 3).setType(AIR);
            world.getBlockAt(x + 1, y, z - 3).setType(AIR);
            world.getBlockAt(x + 2, y, z - 3).setType(AIR);
            world.getBlockAt(x + 3, y, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y, z - 3).setType(AIR);
            world.getBlockAt(x - 1, y, z - 3).setType(AIR);
            world.getBlockAt(x - 2, y, z - 3).setType(AIR);
            world.getBlockAt(x - 3, y, z - 3).setType(AIR);
            world.getBlockAt(x - 4, y, z - 3).setType(AIR);
            world.getBlockAt(x, y, z + 2).setType(AIR);
            world.getBlockAt(x + 1, y, z + 2).setType(AIR);
            world.getBlockAt(x + 2, y, z + 2).setType(AIR);
            world.getBlockAt(x + 3, y, z + 2).setType(AIR);
            world.getBlockAt(x + 4, y, z + 2).setType(AIR);
            world.getBlockAt(x - 1, y, z + 2).setType(AIR);
            world.getBlockAt(x - 2, y, z + 2).setType(AIR);
            world.getBlockAt(x - 3, y, z + 2).setType(AIR);
            world.getBlockAt(x - 4, y, z + 2).setType(AIR);
            world.getBlockAt(x, y, z + 3).setType(AIR);
            world.getBlockAt(x + 1, y, z + 3).setType(AIR);
            world.getBlockAt(x + 2, y, z + 3).setType(AIR);
            world.getBlockAt(x + 3, y, z + 3).setType(AIR);
            world.getBlockAt(x + 4, y, z + 3).setType(AIR);
            world.getBlockAt(x - 1, y, z + 3).setType(AIR);
            world.getBlockAt(x - 2, y, z + 3).setType(AIR);
            world.getBlockAt(x - 3, y, z + 3).setType(AIR);
            world.getBlockAt(x - 4, y, z + 3).setType(AIR);
            world.getBlockAt(x, y, z - 4).setType(AIR);
            world.getBlockAt(x + 1, y, z - 4).setType(AIR);
            world.getBlockAt(x + 2, y, z - 4).setType(AIR);
            world.getBlockAt(x + 3, y, z - 4).setType(AIR);
            world.getBlockAt(x - 1, y, z - 4).setType(AIR);
            world.getBlockAt(x - 2, y, z - 4).setType(AIR);
            world.getBlockAt(x - 3, y, z - 4).setType(AIR);
            world.getBlockAt(x, y, z + 4).setType(AIR);
            world.getBlockAt(x + 1, y, z + 4).setType(AIR);
            world.getBlockAt(x + 2, y, z + 4).setType(AIR);
            world.getBlockAt(x + 3, y, z + 4).setType(AIR);
            world.getBlockAt(x - 1, y, z + 4).setType(AIR);
            world.getBlockAt(x - 2, y, z + 4).setType(AIR);
            world.getBlockAt(x - 3, y, z + 4).setType(AIR);
            world.getBlockAt(x, y, z - 5).setType(AIR);
            world.getBlockAt(x + 1, y, z - 5).setType(AIR);
            world.getBlockAt(x - 1, y, z - 5).setType(AIR);
            world.getBlockAt(x, y, z + 5).setType(AIR);
            world.getBlockAt(x + 1, y, z + 5).setType(AIR);
            world.getBlockAt(x - 1, y, z + 5).setType(AIR);
            world.getBlockAt(x + 1, y + 1, z - 5).setType(AIR); // WALLS V LAYER 1
            world.getBlockAt(x + 1, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x + 2, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x + 3, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x + 3, y + 1, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z - 2).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z - 1).setType(AIR);
            world.getBlockAt(x + 5, y + 1, z - 1).setType(AIR);
            world.getBlockAt(x - 1, y + 1, z - 5).setType(AIR);
            world.getBlockAt(x - 1, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x - 2, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x - 3, y + 1, z - 4).setType(AIR);
            world.getBlockAt(x - 3, y + 1, z - 3).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z - 3).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z - 2).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z - 1).setType(AIR);
            world.getBlockAt(x - 5, y + 1, z - 1).setType(AIR);
            world.getBlockAt(x + 1, y + 1, z + 5).setType(AIR);
            world.getBlockAt(x + 1, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x + 2, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x + 3, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x + 3, y + 1, z + 3).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z + 3).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z + 2).setType(AIR);
            world.getBlockAt(x + 4, y + 1, z + 1).setType(AIR);
            world.getBlockAt(x + 5, y + 1, z + 1).setType(AIR);
            world.getBlockAt(x - 1, y + 1, z + 5).setType(AIR);
            world.getBlockAt(x - 1, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x - 2, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x - 3, y + 1, z + 4).setType(AIR);
            world.getBlockAt(x - 3, y + 1, z + 3).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z + 3).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z + 2).setType(AIR);
            world.getBlockAt(x - 4, y + 1, z + 1).setType(AIR);
            world.getBlockAt(x - 5, y + 1, z + 1).setType(AIR);
            world.getBlockAt(x - 5, y + 1, z).setType(AIR, true);
            world.getBlockAt(x + 5, y + 1, z).setType(AIR, true);
            world.getBlockAt(x, y + 1, z + 5).setType(AIR, true);
            world.getBlockAt(x, y + 1, z - 5).setType(AIR, true);
            world.getBlockAt(x + 1, y + 2, z - 5).setType(AIR); // WALLS LAYER 2 V
            world.getBlockAt(x + 1, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x + 2, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x + 3, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x + 3, y + 2, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z - 2).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z - 1).setType(AIR);
            world.getBlockAt(x + 5, y + 2, z - 1).setType(AIR);
            world.getBlockAt(x - 1, y + 2, z - 5).setType(AIR);
            world.getBlockAt(x - 1, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x - 2, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x - 3, y + 2, z - 4).setType(AIR);
            world.getBlockAt(x - 3, y + 2, z - 3).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z - 3).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z - 2).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z - 1).setType(AIR);
            world.getBlockAt(x - 5, y + 2, z - 1).setType(AIR);
            world.getBlockAt(x + 1, y + 2, z + 5).setType(AIR);
            world.getBlockAt(x + 1, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x + 2, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x + 3, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x + 3, y + 2, z + 3).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z + 3).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z + 2).setType(AIR);
            world.getBlockAt(x + 4, y + 2, z + 1).setType(AIR);
            world.getBlockAt(x + 5, y + 2, z + 1).setType(AIR);
            world.getBlockAt(x - 1, y + 2, z + 5).setType(AIR);
            world.getBlockAt(x - 1, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x - 2, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x - 3, y + 2, z + 4).setType(AIR);
            world.getBlockAt(x - 3, y + 2, z + 3).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z + 3).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z + 2).setType(AIR);
            world.getBlockAt(x - 4, y + 2, z + 1).setType(AIR);
            world.getBlockAt(x - 5, y + 2, z + 1).setType(AIR);
            world.getBlockAt(x - 5, y + 2, z).setType(AIR, true);
            world.getBlockAt(x + 5, y + 2, z).setType(AIR, true);
            world.getBlockAt(x, y + 2, z + 5).setType(AIR, true);
            world.getBlockAt(x, y + 2, z - 5).setType(AIR, true);
            world.getBlockAt(x - 3, y + 3, z + 2).setType(AIR);// ROOF V
            world.getBlockAt(x - 3, y + 3, z + 1).setType(AIR);
            world.getBlockAt(x - 2, y + 3, z + 3).setType(AIR);
            world.getBlockAt(x - 1, y + 3, z + 3).setType(AIR);
            world.getBlockAt(x - 3, y + 3, z - 2).setType(AIR);
            world.getBlockAt(x - 3, y + 3, z - 1).setType(AIR);
            world.getBlockAt(x - 2, y + 3, z - 3).setType(AIR);
            world.getBlockAt(x - 1, y + 3, z - 3).setType(AIR);
            world.getBlockAt(x + 3, y + 3, z + 2).setType(AIR);
            world.getBlockAt(x + 3, y + 3, z + 1).setType(AIR);
            world.getBlockAt(x + 2, y + 3, z + 3).setType(AIR);
            world.getBlockAt(x + 1, y + 3, z + 3).setType(AIR);
            world.getBlockAt(x + 3, y + 3, z - 2).setType(AIR);
            world.getBlockAt(x + 3, y + 3, z - 1).setType(AIR);
            world.getBlockAt(x + 2, y + 3, z - 3).setType(AIR);
            world.getBlockAt(x + 1, y + 3, z - 3).setType(AIR);
            world.getBlockAt(x + 4, y + 3, z).setType(AIR);
            world.getBlockAt(x - 4, y + 3, z).setType(AIR);
            world.getBlockAt(x, y + 3, z + 4).setType(AIR);
            world.getBlockAt(x, y + 3, z - 4).setType(AIR);
        });
    }

    public void summonClassNPCs() {
        FileConfiguration config = plugin.getConfig();

        // BLUE

        Location bWarriorLoc = config.getLocation("BBWarrior");
        NPCApi.NPC bWarrior = new NPCApi.NPC(bWarriorLoc.getWorld())
                .setName("&e&lWarrior Class")
                .setSkin("Warrior", "OvAyLCJkcPC7jF/tfByWUF9hSM4KDA103z0iOBP53wV848W6jdk1oo5vFTpxEpoXej6J9G3cqXkcmNu488NO8x8hGskECQYg4ozqe5lRJnPHKlw3hO+PXvivjrySR6vHvUiWap+HTADPQJ21GtrZ973RoaKhF9/OH3AtikemO4uOSlkFToF++OxMIXNXnTU7rS9xMX5umj7HCb1W+fjBSozY0GwOpi73lQCNhDPzc/9XdaONfjoneNNo+2OZ0PBTdE6wWKRHqxRtDtj/pUu4L8iyVaDLubGYFswvnFIRBxICwh0l1Gd3VhStrA+sJ3FYsedJb2grj33YxDUe8uGnIbBw4uZFG75jlMBNRPN3KCD5NTQhTVYCwta6+AOQYjDlHvmMI8mSrFnPbX4TIh25dnpWivj0Kf2AghyGXnGjfeE/tTlyKxDUo8Zo1gY5b1gFUqRyHGOty0nKhtpbXHCF0rgiUYDCHKiNJ5DSIW+JQdHlmY6Bxd3WMkSgAEvyZ8aIe23ZL1/I8tqNU3/xQHX7vwc637syZ1L1GljwFPaWwrCWcwfvSv0EkLCqQJrIfPPjdXZEHkLMmD3yCQ/93KbbKOcVWkXl7mTFRL9cOdZkwPKYaBlUVP5VREMH33XF+OOD0uA1aj7BTLgop00UAPt5kVl5WwepLQuxf1Kv0+Srh9s=", "ewogICJ0aW1lc3RhbXAiIDogMTYyMDIwNjI5NTY3MywKICAicHJvZmlsZUlkIiA6ICJmZWYxMzE2MjA3Njk0M2Y2YWMyMDdkOTI4MGQzYmIzOSIsCiAgInByb2ZpbGVOYW1lIiA6ICIwMFBob25peDAwIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzRhYWVlNjhkM2I0OThlYjc1M2Y3NTM0NTgxMjQ5NThmMTdhODk3NzAzYTIzZDg3ZWJhM2QzNDcxYTU4NTQ1NDQiCiAgICB9CiAgfQp9")
                .setBoots(Items.getBlueBoots())
                .setHelmet(Items.getBlueHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(Material.STONE_SWORD))
                .setOffhandItem(new ItemStack(Material.WOODEN_AXE))
                .setPostion(bWarriorLoc)
                .setHeading(bWarriorLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "warrior")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        bWarrior.create();

        Location bTankLoc = config.getLocation("BBTank");
        NPCApi.NPC bTank = new NPCApi.NPC(bTankLoc.getWorld())
                .setName("&e&lTank Class")
                .setSkin("Tank", "mOerAUvda77UBVLHVhJO4mXWjz7Iuzd2Xk1vmUpnsl20oVmMse6iAoTiImoNHu8/wTKJVgBkuANvvwmvImgL0t2QCQsxJURPgZq/dRy3WAVWviigR5s+9gnmd+wEZ88js5aonMk20xk5QMZecM/Y2WEMf4CtH7Pt8LQ3izMxNGm4LLptFcf443XElhIXpluDdKSDeqJI227QXNqtuj0J8+rxNUQyhg01Jr1SQ9mGTHjxSOsQAKr27NlCxvxmY1p2jdHHFJczn4FUCXWj7tU8GNPKVdaGCIDIYp9LOsGwMpgK9+R3YOId0Wk3CxtrkjhPto8+ajNhb9vfvJ8Jp4kApxP6w6vgl2BT+XHNG6+C9QskAIBDarc7IlvCuQTZ4ixKupuBXrXDkLLGMYjgTBHLYcJwveQJe1pnmunnRiI6HXAEUg37mkCfOsb7rLXMCkRbzaMd5wvDRlKaG9wfWnjTR9OkO0WtCbM1Rl+gd0ZHTSEtiMmyhPH9ycyyFvA6ztehnFpeH+d1Su/D5eBOiOsCBgpw4++Sc7ecGMPrQzBpM3UKuD/rwTr92/uCsbz+l65uvYg5sQKbDmQYgP5PDHRGTInQ45GPC0VQl+QJfjf0jg21dw5EcBTSJMUenZfaHqG6oj7XFTj7RrSPk+DNJfJF57I+xlnEhviE9uqK5+DFwvM=", "ewogICJ0aW1lc3RhbXAiIDogMTYyMjcwMDYwODkyOSwKICAicHJvZmlsZUlkIiA6ICI1N2IzZGZiNWY4YTY0OWUyOGI1NDRlNGZmYzYzMjU2ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJYaWthcm8iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWY4YmMyYzI4MjU0ZDY2NDRjODkwYjMxZTRiZWExM2E5YTVhMjg1YTM1Y2M4MDhhNjFmYzBhNGE0NDhkOGVhNyIKICAgIH0KICB9Cn0=")
                .setBoots(Items.getBlueBoots())
                .setHelmet(Items.getBlueHelmet())
                .setChestplate(new ItemStack(IRON_CHESTPLATE))
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(WOODEN_SWORD))
                .setOffhandItem(new ItemStack(SHIELD))
                .setPostion(bTankLoc)
                .setHeading(bTankLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "tank")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        bTank.create();

        Location bArcherLoc = config.getLocation("BBArcher");
        NPCApi.NPC bArcher = new NPCApi.NPC(bArcherLoc.getWorld())
                .setName("&e&lArcher Class")
                .setSkin("Archer", "ctq1P97oI9OyXRlTRwPVANmt8Y4PpL3WJnh4qp4CwajqHuzqzy5iLlKNWfJ9sWupKa/s8rv8ToDlbJGvNI6RsH/eQwoQoCUJCFCw91fWSiQNDEk2hYMzqSZJIZ3IaiCDvnVE2r4CC+rpe7mnkooZfymp7tiY35tDf7/+TfvGypVH1TZ+c6efYCiwvqtzAfmq43ntahDhDd/An7UWAsux3pUcZP+s8SSE5td0OR7m+/5IRQ4AgZ+seRp5N5fJjzp78LsFw/jXOKS0j2bhZNqjX0Agfd1TcqkgI6jw1AEzwsRrMiDqupYVPa7pmoxpKHIC9mcqOF+Zz/3Vqr6kYXMGS/Sl0VyOmsZZNTN8dKm8ngGWaqPN7xtwcWpO1ndctdSvO7VShLQvrWutEPfGB5iIZ6snJ3zQSu8cCHFfVV8uG56A05i71E6rMFGKNUn2bGFftVr85TIfXgMKJEB1D4D8wVrLPU6UN5y3QV6PIrAueOcwTr6Onmr9kwt/SZ0fvEFjOu+f8Ky6aiWfc4jM9mYcqjhIlyRNI5ay+jTC2Djz3O4aTXDrkM9k+LY70pEsPlLYW99J2yK/eq8+HGXYqbo/rhmHVFdCN+uPIllXWvdal49QoQ6sou0IMeIxSmMUhFNvfhR7/9fbXrL176wx57CM5H19UVktghK0HgrOAdMM3AU=", "eyJ0aW1lc3RhbXAiOjE1ODU1MzE3NzAyNzYsInByb2ZpbGVJZCI6IjkxZmUxOTY4N2M5MDQ2NTZhYTFmYzA1OTg2ZGQzZmU3IiwicHJvZmlsZU5hbWUiOiJoaGphYnJpcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M2NTg2MTQwODY1ZGMyODc0ZGFiMDc3NmI4YmZkNTUzMjZmMWExYzgwNWZjOWZjZTA1NjhjY2U5OWE4Nzk2NSJ9fX0=")
                .setBoots(Items.getBlueBoots())
                .setHelmet(Items.getBlueHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(BOW))
                .setOffhandItem(new ItemStack(ARROW))
                .setPostion(bArcherLoc)
                .setHeading(bArcherLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "archer")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())                ));

        bArcher.create();

        Location bWizardLoc = config.getLocation("BBWizard");
        NPCApi.NPC bWizard = new NPCApi.NPC(bWizardLoc.getWorld())
                .setName("&e&lWizard Class")
                .setSkin("Wizard", "WIoFNCz5KaCh0xCxnK/+hVOE11kiWkLu5kE+Opqb5sEJQlOjQa5KKKTbeeOEyvmV/S+lKGJfAEg1RAUdH8VG1CKA/wZnjL/Kboii0u8ZVcpqFgvgan6yCd+Fu9d0aZ5xlFoKVSpjWsxYoSej/w7gvxjQn7ugCun2VZhBB6gzM/Gq/WgIrHF8XyDmOmUyMyjZQRGDwUZXcLT0ZL2/i+HiGdOEnuC5lURml/98/H5ONZAMZWg6IG8ZRgEbSgxgCVh/du1JslhgSk8EIGeNLG7ggtrn6EQygxLyqSSUFtLcOrp+QwnlWCGc39HfwoRFJfBnPAfNBBl/gPqtiEHNm0aEBkejbImBg5PTSD/wGwHDIOsR+NgzWlWXWk3OlzhO3jvHkELTN6wf9VLVZHDwDxzp4qMwFIw7fM0tUqO2YFLgUvg0Eqw6QPmC0RP9AwmOVgKzXS6SEu/IVxN8pX2az0sje4zjdQl2OtFEnq19LLVXhZzsOhIPr5+cX+MzN+ZJ+mEuYcscdTFJtfYX2rn5wc4DnCR+o3bD/lFKKueydQphprq61oEqeTLU9OAKR7baUC4/fgLJUF/kc7WH5KuqSDxcSNTw03ow7kyGhvZDNQVLzVJQUaX1lB42HKMfHWtupohHTD8Sx/iuUU6VGzBkR77JMnOUlI27UNYcEJiYm2PZxcA=", "ewogICJ0aW1lc3RhbXAiIDogMTYxNjA5NDExNDQ3MCwKICAicHJvZmlsZUlkIiA6ICIzOTg5OGFiODFmMjU0NmQxOGIyY2ExMTE1MDRkZGU1MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJNeVV1aWRJcyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xZWViZGFkMDY5NDRmMDEzMWVlNzA3MjZkMzUzNDJkMzhmNDUzZTBkZTk2NGEyOTk5YjE2YTA1YzM4ZTFjMjkiCiAgICB9CiAgfQp9")
                .setBoots(Items.getBlueBoots())
                .setHelmet(Items.getBlueHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(STICK))
                .setOffhandItem(new ItemStack(ALLIUM))
                .setPostion(bWizardLoc)
                .setHeading(bWizardLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "wizzard")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())                ));

        bWizard.create();

        // RED

        Location rWarriorLoc = config.getLocation("RBWarrior");
        NPCApi.NPC rWarrior = new NPCApi.NPC(rWarriorLoc.getWorld())
                .setName("&e&lWarrior Class")
                .setSkin("Warrior", "OvAyLCJkcPC7jF/tfByWUF9hSM4KDA103z0iOBP53wV848W6jdk1oo5vFTpxEpoXej6J9G3cqXkcmNu488NO8x8hGskECQYg4ozqe5lRJnPHKlw3hO+PXvivjrySR6vHvUiWap+HTADPQJ21GtrZ973RoaKhF9/OH3AtikemO4uOSlkFToF++OxMIXNXnTU7rS9xMX5umj7HCb1W+fjBSozY0GwOpi73lQCNhDPzc/9XdaONfjoneNNo+2OZ0PBTdE6wWKRHqxRtDtj/pUu4L8iyVaDLubGYFswvnFIRBxICwh0l1Gd3VhStrA+sJ3FYsedJb2grj33YxDUe8uGnIbBw4uZFG75jlMBNRPN3KCD5NTQhTVYCwta6+AOQYjDlHvmMI8mSrFnPbX4TIh25dnpWivj0Kf2AghyGXnGjfeE/tTlyKxDUo8Zo1gY5b1gFUqRyHGOty0nKhtpbXHCF0rgiUYDCHKiNJ5DSIW+JQdHlmY6Bxd3WMkSgAEvyZ8aIe23ZL1/I8tqNU3/xQHX7vwc637syZ1L1GljwFPaWwrCWcwfvSv0EkLCqQJrIfPPjdXZEHkLMmD3yCQ/93KbbKOcVWkXl7mTFRL9cOdZkwPKYaBlUVP5VREMH33XF+OOD0uA1aj7BTLgop00UAPt5kVl5WwepLQuxf1Kv0+Srh9s=", "ewogICJ0aW1lc3RhbXAiIDogMTYyMDIwNjI5NTY3MywKICAicHJvZmlsZUlkIiA6ICJmZWYxMzE2MjA3Njk0M2Y2YWMyMDdkOTI4MGQzYmIzOSIsCiAgInByb2ZpbGVOYW1lIiA6ICIwMFBob25peDAwIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzRhYWVlNjhkM2I0OThlYjc1M2Y3NTM0NTgxMjQ5NThmMTdhODk3NzAzYTIzZDg3ZWJhM2QzNDcxYTU4NTQ1NDQiCiAgICB9CiAgfQp9")
                .setBoots(Items.getRedBoots())
                .setHelmet(Items.getRedHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(Material.STONE_SWORD))
                .setOffhandItem(new ItemStack(Material.WOODEN_AXE))
                .setPostion(rWarriorLoc)
                .setHeading(rWarriorLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "warrior")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        rWarrior.create();

        Location rTankLoc = config.getLocation("RBTank");
        NPCApi.NPC rTank = new NPCApi.NPC(rTankLoc.getWorld())
                .setName("&e&lTank Class")
                .setSkin("Tank", "mOerAUvda77UBVLHVhJO4mXWjz7Iuzd2Xk1vmUpnsl20oVmMse6iAoTiImoNHu8/wTKJVgBkuANvvwmvImgL0t2QCQsxJURPgZq/dRy3WAVWviigR5s+9gnmd+wEZ88js5aonMk20xk5QMZecM/Y2WEMf4CtH7Pt8LQ3izMxNGm4LLptFcf443XElhIXpluDdKSDeqJI227QXNqtuj0J8+rxNUQyhg01Jr1SQ9mGTHjxSOsQAKr27NlCxvxmY1p2jdHHFJczn4FUCXWj7tU8GNPKVdaGCIDIYp9LOsGwMpgK9+R3YOId0Wk3CxtrkjhPto8+ajNhb9vfvJ8Jp4kApxP6w6vgl2BT+XHNG6+C9QskAIBDarc7IlvCuQTZ4ixKupuBXrXDkLLGMYjgTBHLYcJwveQJe1pnmunnRiI6HXAEUg37mkCfOsb7rLXMCkRbzaMd5wvDRlKaG9wfWnjTR9OkO0WtCbM1Rl+gd0ZHTSEtiMmyhPH9ycyyFvA6ztehnFpeH+d1Su/D5eBOiOsCBgpw4++Sc7ecGMPrQzBpM3UKuD/rwTr92/uCsbz+l65uvYg5sQKbDmQYgP5PDHRGTInQ45GPC0VQl+QJfjf0jg21dw5EcBTSJMUenZfaHqG6oj7XFTj7RrSPk+DNJfJF57I+xlnEhviE9uqK5+DFwvM=", "ewogICJ0aW1lc3RhbXAiIDogMTYyMjcwMDYwODkyOSwKICAicHJvZmlsZUlkIiA6ICI1N2IzZGZiNWY4YTY0OWUyOGI1NDRlNGZmYzYzMjU2ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJYaWthcm8iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWY4YmMyYzI4MjU0ZDY2NDRjODkwYjMxZTRiZWExM2E5YTVhMjg1YTM1Y2M4MDhhNjFmYzBhNGE0NDhkOGVhNyIKICAgIH0KICB9Cn0=")
                .setBoots(Items.getRedBoots())
                .setHelmet(Items.getRedHelmet())
                .setChestplate(new ItemStack(IRON_CHESTPLATE))
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(WOODEN_SWORD))
                .setOffhandItem(new ItemStack(SHIELD))
                .setPostion(rTankLoc)
                .setHeading(rTankLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "tank")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        rTank.create();

        Location rArcherLoc = config.getLocation("RBArcher");
        NPCApi.NPC rArcher = new NPCApi.NPC(rArcherLoc.getWorld())
                .setName("&e&lArcher Class")
                .setSkin("Archer", "ctq1P97oI9OyXRlTRwPVANmt8Y4PpL3WJnh4qp4CwajqHuzqzy5iLlKNWfJ9sWupKa/s8rv8ToDlbJGvNI6RsH/eQwoQoCUJCFCw91fWSiQNDEk2hYMzqSZJIZ3IaiCDvnVE2r4CC+rpe7mnkooZfymp7tiY35tDf7/+TfvGypVH1TZ+c6efYCiwvqtzAfmq43ntahDhDd/An7UWAsux3pUcZP+s8SSE5td0OR7m+/5IRQ4AgZ+seRp5N5fJjzp78LsFw/jXOKS0j2bhZNqjX0Agfd1TcqkgI6jw1AEzwsRrMiDqupYVPa7pmoxpKHIC9mcqOF+Zz/3Vqr6kYXMGS/Sl0VyOmsZZNTN8dKm8ngGWaqPN7xtwcWpO1ndctdSvO7VShLQvrWutEPfGB5iIZ6snJ3zQSu8cCHFfVV8uG56A05i71E6rMFGKNUn2bGFftVr85TIfXgMKJEB1D4D8wVrLPU6UN5y3QV6PIrAueOcwTr6Onmr9kwt/SZ0fvEFjOu+f8Ky6aiWfc4jM9mYcqjhIlyRNI5ay+jTC2Djz3O4aTXDrkM9k+LY70pEsPlLYW99J2yK/eq8+HGXYqbo/rhmHVFdCN+uPIllXWvdal49QoQ6sou0IMeIxSmMUhFNvfhR7/9fbXrL176wx57CM5H19UVktghK0HgrOAdMM3AU=", "eyJ0aW1lc3RhbXAiOjE1ODU1MzE3NzAyNzYsInByb2ZpbGVJZCI6IjkxZmUxOTY4N2M5MDQ2NTZhYTFmYzA1OTg2ZGQzZmU3IiwicHJvZmlsZU5hbWUiOiJoaGphYnJpcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M2NTg2MTQwODY1ZGMyODc0ZGFiMDc3NmI4YmZkNTUzMjZmMWExYzgwNWZjOWZjZTA1NjhjY2U5OWE4Nzk2NSJ9fX0=")
                .setBoots(Items.getRedBoots())
                .setHelmet(Items.getRedHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(BOW))
                .setOffhandItem(new ItemStack(ARROW))
                .setPostion(rArcherLoc)
                .setHeading(rArcherLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "archer")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        rArcher.create();

        Location rWizardLoc = config.getLocation("RBWizard");
        NPCApi.NPC rWizard = new NPCApi.NPC(rWizardLoc.getWorld())
                .setName("&e&lWizard Class")
                .setSkin("Wizard", "WIoFNCz5KaCh0xCxnK/+hVOE11kiWkLu5kE+Opqb5sEJQlOjQa5KKKTbeeOEyvmV/S+lKGJfAEg1RAUdH8VG1CKA/wZnjL/Kboii0u8ZVcpqFgvgan6yCd+Fu9d0aZ5xlFoKVSpjWsxYoSej/w7gvxjQn7ugCun2VZhBB6gzM/Gq/WgIrHF8XyDmOmUyMyjZQRGDwUZXcLT0ZL2/i+HiGdOEnuC5lURml/98/H5ONZAMZWg6IG8ZRgEbSgxgCVh/du1JslhgSk8EIGeNLG7ggtrn6EQygxLyqSSUFtLcOrp+QwnlWCGc39HfwoRFJfBnPAfNBBl/gPqtiEHNm0aEBkejbImBg5PTSD/wGwHDIOsR+NgzWlWXWk3OlzhO3jvHkELTN6wf9VLVZHDwDxzp4qMwFIw7fM0tUqO2YFLgUvg0Eqw6QPmC0RP9AwmOVgKzXS6SEu/IVxN8pX2az0sje4zjdQl2OtFEnq19LLVXhZzsOhIPr5+cX+MzN+ZJ+mEuYcscdTFJtfYX2rn5wc4DnCR+o3bD/lFKKueydQphprq61oEqeTLU9OAKR7baUC4/fgLJUF/kc7WH5KuqSDxcSNTw03ow7kyGhvZDNQVLzVJQUaX1lB42HKMfHWtupohHTD8Sx/iuUU6VGzBkR77JMnOUlI27UNYcEJiYm2PZxcA=", "ewogICJ0aW1lc3RhbXAiIDogMTYxNjA5NDExNDQ3MCwKICAicHJvZmlsZUlkIiA6ICIzOTg5OGFiODFmMjU0NmQxOGIyY2ExMTE1MDRkZGU1MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJNeVV1aWRJcyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xZWViZGFkMDY5NDRmMDEzMWVlNzA3MjZkMzUzNDJkMzhmNDUzZTBkZTk2NGEyOTk5YjE2YTA1YzM4ZTFjMjkiCiAgICB9CiAgfQp9")
                .setBoots(Items.getRedBoots())
                .setHelmet(Items.getRedHelmet())
                .setResilient(false)
                .setInteractable(true)
                .setHandItem(new ItemStack(STICK))
                .setOffhandItem(new ItemStack(ALLIUM))
                .setPostion(rWizardLoc)
                .setHeading(rWarriorLoc.getYaw())
                .setActions(List.of(
                        new Action(ActionType.RUN_COMMAND, new ArrayList<>(List.of("class", "wizzard")), 1, Conditional.SelectionMode.ONE, new ArrayList<>())
                ));

        rWizard.create();
    }

    public void knockDownBlueGate() {
        removeBlueHitbox();
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location top = config.getLocation("BBGateTop");
        Location bottom = config.getLocation("BBGateBottom");
        int minX = Math.min(top.getBlockX(), bottom.getBlockX());
        int minY = Math.min(top.getBlockY(), bottom.getBlockY());
        int minZ = Math.min(top.getBlockZ(), bottom.getBlockZ());
        int maxX = Math.max(top.getBlockX(), bottom.getBlockX());
        int maxY = Math.max(top.getBlockY(), bottom.getBlockY());
        int maxZ = Math.max(top.getBlockZ(), bottom.getBlockZ());

        World world = top.getWorld();

        BlockDisplay dp = (BlockDisplay) world.spawnEntity(new Location(world, minX, minY, minZ), EntityType.BLOCK_DISPLAY);
        dp.setBlock(DEEPSLATE_TILE_WALL.createBlockData());
        dp.addScoreboardTag("blueWallAnimationDisplay");
        dp.setBillboard(Display.Billboard.FIXED);

        Transformation t = dp.getTransformation();
        t.getScale().add((maxX-minX)*2, maxY-minY, 0); // was 26, 4
        t.getTranslation().add(-((maxX - minX)/2f),0,0); // was 7.5
        dp.setTransformation(t);

        new BukkitRunnable(){

            @Override
            public void run() {
                dp.teleport(dp.getLocation().add(0, -.1, 0));
                if(dp.getLocation().getBlockY() < 10) {
                    dp.remove();
                    cancel();
                    for (int x = minX; x <= maxX; x++) {
                        for (int y = minY; y <= maxY; y++) {
                            for (int z = minZ; z <= maxZ; z++) {
                                Block block = world.getBlockAt(x, y, z);
                                if (block.getType() == BARRIER) {
                                    block.setType(AIR, true); // Change to your desired block
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 10, 1);

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == DEEPSLATE_TILE_WALL) {
                        block.setType(BARRIER, true); // Change to your desired block
                    }
                }
            }
        }
    }

    public void knockDownRedGate() {
        removeRedHitbox();
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location top = config.getLocation("RBGateTop");
        Location bottom = config.getLocation("RBGateBottom");
        int minX = Math.min(top.getBlockX(), bottom.getBlockX());
        int minY = Math.min(top.getBlockY(), bottom.getBlockY());
        int minZ = Math.min(top.getBlockZ(), bottom.getBlockZ());
        int maxX = Math.max(top.getBlockX(), bottom.getBlockX());
        int maxY = Math.max(top.getBlockY(), bottom.getBlockY());
        int maxZ = Math.max(top.getBlockZ(), bottom.getBlockZ());

        World world = top.getWorld();

        BlockDisplay dp = (BlockDisplay) world.spawnEntity(new Location(world, minX, minY, minZ), EntityType.BLOCK_DISPLAY);
        dp.setBlock(DEEPSLATE_TILE_WALL.createBlockData());
        dp.addScoreboardTag("blueWallAnimationDisplay");
        dp.setBillboard(Display.Billboard.FIXED);

        Transformation t = dp.getTransformation();
        t.getScale().add((maxX-minX)*2, maxY-minY, 0); // was 26, 4
        t.getTranslation().add(-((maxX - minX)/2f),0,0); // was 7.5
        dp.setTransformation(t);

        new BukkitRunnable(){

            @Override
            public void run() {
                dp.teleport(dp.getLocation().add(0, -.1, 0));
                if(dp.getLocation().getBlockY() < 10) {
                    dp.remove();
                    cancel();
                    for (int x = minX; x <= maxX; x++) {
                        for (int y = minY; y <= maxY; y++) {
                            for (int z = minZ; z <= maxZ; z++) {
                                Block block = world.getBlockAt(x, y, z);
                                if (block.getType() == BARRIER) {
                                    block.setType(AIR, true); // Change to your desired block
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 10, 1);
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == DEEPSLATE_TILE_WALL) {
                        block.setType(BARRIER, true); // Change to your desired block
                    }
                }
            }
        }
    }

    public void pasteRGate() {
        addRedHitbox();
        FileConfiguration config = CastleSiege.getInstance().getConfig();

        Location loc1 = config.getLocation("RBGateTop");
        Location loc2 = config.getLocation("RBGateBottom");

        World world = loc1.getWorld();

        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        int maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == Material.AIR) {
                        block.setType(Material.DEEPSLATE_TILE_WALL, true); // Change to your desired block
                    }
                }
            }
        }
    }

    public void pasteBGate() {
        addBlueHitbox();
        FileConfiguration config = CastleSiege.getInstance().getConfig();

        Location loc1 = config.getLocation("BBGateTop");
        Location loc2 = config.getLocation("BBGateBottom");

        World world = loc1.getWorld();

        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        int maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == Material.AIR) {
                        block.setType(Material.DEEPSLATE_TILE_WALL, true); // Change to your desired block
                    }
                }
            }
        }
    }

    public void addBlueHitbox() {
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location loc1 = config.getLocation("BBGateTop");
        Location loc2 = config.getLocation("BBGateBottom");

        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        int maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Location armorStandLoc1 = new Location(loc1.getWorld(), x + 0.25, y, z + 0.5);
                    Location armorStandLoc2 = new Location(loc1.getWorld(), x + 0.75, y, z + 0.5);

                    ArmorStand armorStand1 = loc1.getWorld().spawn(armorStandLoc1, ArmorStand.class);
                    ArmorStand armorStand2 = loc1.getWorld().spawn(armorStandLoc2, ArmorStand.class);

                    armorStand1.setInvisible(true);
                    armorStand2.setInvisible(true);

                    armorStand1.addScoreboardTag("BBGate");
                    armorStand2.addScoreboardTag("BBGate");

                    armorStand1.setGravity(false);
                    armorStand2.setGravity(false);

                }
            }
        }
    }

    public void addRedHitbox() {
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location loc1 = config.getLocation("RBGateTop");
        Location loc2 = config.getLocation("RBGateBottom");

        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        int maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Location armorStandLoc1 = new Location(loc1.getWorld(), x + 0.25, y, z + 0.5);
                    Location armorStandLoc2 = new Location(loc1.getWorld(), x + 0.75, y, z + 0.5);

                    ArmorStand armorStand1 = loc1.getWorld().spawn(armorStandLoc1, ArmorStand.class);
                    ArmorStand armorStand2 = loc1.getWorld().spawn(armorStandLoc2, ArmorStand.class);

                    armorStand1.setInvisible(true);
                    armorStand2.setInvisible(true);

                    armorStand1.addScoreboardTag("RBGate");
                    armorStand2.addScoreboardTag("RBGate");

                    armorStand1.setGravity(false);
                    armorStand2.setGravity(false);

                }
            }
        }
    }

    public void addBlueGateHologram() {
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location bLoc = config.getLocation("BBGateHologram");
        TextDisplay hologram = bLoc.getWorld().spawn(bLoc, TextDisplay.class);
        hologram.addScoreboardTag("BBGateHologram");
        hologram.setGravity(false);
        hologram.setText(ChatColor.BLUE + "" + ChatColor.BOLD + "Blue Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + "%Health%" + ChatColor.GRAY + "/" + ChatColor.GREEN + config.getInt("BBGateHealth") + ChatColor.GRAY + ")");
        hologram.setBillboard(Display.Billboard.CENTER);

        GameManager manager = CastleSiege.getInstance().getGameManager();
        manager.setbBHHoloGram(hologram);
        manager.updateBlueGateHologram();
    }

    public void addRedGateHologram() {
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        Location bLoc = config.getLocation("RBGateHologram");
        TextDisplay hologram = bLoc.getWorld().spawn(bLoc, TextDisplay.class);
        hologram.addScoreboardTag("RBGateHologram");
        hologram.setGravity(false);
        hologram.setText(ChatColor.RED + "" + ChatColor.BOLD + "Red Gate " + ChatColor.RESET + "" + ChatColor.GRAY + "(" + ChatColor.GREEN + "%Health%" + ChatColor.GRAY + "/" + ChatColor.GREEN + config.getInt("BBGateHealth") + ChatColor.GRAY + ")");
        hologram.setBillboard(Display.Billboard.CENTER);

        GameManager manager = CastleSiege.getInstance().getGameManager();
        manager.setrBHHoloGram(hologram);
        manager.updateBlueGateHologram();
    }

    public void removeBlueHitbox() {
        World world = Bukkit.getWorlds().get(0);
        world.getEntities().forEach(entity -> {
            if (entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("BBGate")) {
                entity.remove();
            }
        });
    }

    public void removeRedHitbox() {
        World world = Bukkit.getWorlds().get(0);
        world.getEntities().forEach(entity -> {
            if (entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("RBGate")) {
                entity.remove();
            }
        });
    }

    public void addBlueCatapultStand() {

        World world = Bukkit.getWorlds().get(0);
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        double x = config.getDouble("BBCatapultNPCX");
        double y = config.getDouble("BBCatapultNPCY");
        double z = config.getDouble("BBCatapultNPCZ");
        Location loc = new Location(world, x, y, z);

        ArmorStand bCataStand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        bCataStand.setArms(true);
        bCataStand.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Catapult Operator");
        bCataStand.setCustomNameVisible(true);
        bCataStand.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        bCataStand.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        bCataStand.setInvulnerable(true);
        bCataStand.setBasePlate(false);
        bCataStand.getEquipment().setBoots(Items.getBlueBoots());
        bCataStand.getEquipment().setHelmet(Items.getBlueHelmet());
        bCataStand.setRotation(-45, 0);
        bCataStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bCataStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        bCataStand.addScoreboardTag("bCatapult");
        bCataStand.addScoreboardTag("interactable");
    }

    public void addRedCatapultStand() {

        World world = Bukkit.getWorlds().get(0);
        FileConfiguration config = CastleSiege.getInstance().getConfig();
        double x = config.getDouble("RBCatapultNPCX");
        double y = config.getDouble("RBCatapultNPCY");
        double z = config.getDouble("RBCatapultNPCZ");
        Location loc = new Location(world, x, y, z);

        ArmorStand rCataStand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        rCataStand.setArms(true);
        rCataStand.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Catapult Operator");
        rCataStand.setCustomNameVisible(true);
        rCataStand.setLeftLegPose(new EulerAngle(0, 0, 6.07375));
        rCataStand.setRightLegPose(new EulerAngle(0, 0, 0.15708));
        rCataStand.setInvulnerable(true);
        rCataStand.setBasePlate(false);
        rCataStand.getEquipment().setBoots(Items.getRedBoots());
        rCataStand.getEquipment().setHelmet(Items.getRedHelmet());
        rCataStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rCataStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        rCataStand.setRotation(-45, 0);
        rCataStand.addScoreboardTag("rCatapult");
        rCataStand.addScoreboardTag("interactable");
    }

    public void removeInteractables() {
        World world = Bukkit.getWorlds().get(0);
        world.getEntities().forEach(entity -> {
            if (entity.getType() == EntityType.ARMOR_STAND && entity.getScoreboardTags().contains("interactable")) {
                entity.remove();
            }
        });
    }

    public Location bezierPoint(float t, Location p0, Location p1, Location p2) {
        float a = (1 - t) * (1 - t);
        float b = 2 * (1 - t) * t;
        float c = t * t;

        Location p = p0.clone().multiply(a).add(p1.clone().multiply(b)).add(p2.clone().multiply(c));
        return p;
    }

    public List<Location> bezierCurve(int segmentCount, Location p0, Location p1, Location p2) {
        List<Location> points = new ArrayList<>();
        for (int i = 1; i < segmentCount; i++) {
            float t = i / (float) segmentCount;
            points.add(bezierPoint(t, p0, p1, p2));
        }
        return points;
    }
}
