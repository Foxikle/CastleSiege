package dev.foxikle.castlesiege;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack getWoodSword(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Wooden Rapier");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + "A sword made of");
        lore.add(ChatColor.DARK_GRAY + "the... lowest quality.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getStoneSword(){
        ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Stone Falcion");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + "A sword crafted for");
        lore.add(ChatColor.DARK_GRAY + "the most skilled of");
        lore.add(ChatColor.DARK_GRAY + "warriors.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getShield(){
        ItemStack item = new ItemStack(Material.SHIELD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Brass Buckler");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + "A shield fit for");
        lore.add(ChatColor.DARK_GRAY + "the most skilled of");
        lore.add(ChatColor.DARK_GRAY + "panzers.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getBow(){
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Rickety Longbow");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + "A long bow fit for");
        lore.add(ChatColor.DARK_GRAY + "the least skilled of");
        lore.add(ChatColor.DARK_GRAY + "bowman.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getBlueBoots(){
        ItemStack blueBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta blueBootsMeta = (LeatherArmorMeta) blueBoots.getItemMeta();
        blueBootsMeta.setUnbreakable(true);
        blueBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        blueBootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        blueBootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        blueBootsMeta.setColor(Color.fromRGB(74,146,240));
        blueBoots.setItemMeta(blueBootsMeta);
        return blueBoots;
    }

    public static ItemStack getBlueHelmet(){
        ItemStack blueHelmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta blueHelmetMeta = (LeatherArmorMeta) blueHelmet.getItemMeta();
        blueHelmetMeta.setUnbreakable(true);
        blueHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        blueHelmetMeta.addItemFlags(ItemFlag.HIDE_DYE);
        blueHelmetMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        blueHelmetMeta.setColor(Color.fromRGB(74,146,240));
        blueHelmet.setItemMeta(blueHelmetMeta);
        return blueHelmet;
    }

    public static ItemStack getChestplate(){
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.setUnbreakable(true);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        chestplate.setItemMeta(chestplateMeta);
        return chestplate;
    }

    public static ItemStack getRedBoots() {
        ItemStack redBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta redBootsMeta = (LeatherArmorMeta) redBoots.getItemMeta();
        redBootsMeta.setUnbreakable(true);
        redBootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        redBootsMeta.addItemFlags(ItemFlag.HIDE_DYE);
        redBootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        redBootsMeta.setColor(Color.fromRGB(240, 75, 29));
        redBoots.setItemMeta(redBootsMeta);
        return redBoots;
    }

    public static ItemStack getRedHelmet() {
        ItemStack redHelmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta redHelmetMeta = (LeatherArmorMeta) redHelmet.getItemMeta();
        redHelmetMeta.setUnbreakable(true);
        redHelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        redHelmetMeta.addItemFlags(ItemFlag.HIDE_DYE);
        redHelmetMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        redHelmetMeta.setColor(Color.fromRGB(240, 75, 29));
        redHelmet.setItemMeta(redHelmetMeta);
        return redHelmet;
    }

    public static ItemStack getWoodenAxe() {
        ItemStack axe = new ItemStack(Material.WOODEN_AXE);
        ItemMeta axeMeta = axe.getItemMeta();
        axeMeta.setUnbreakable(true);
        axeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        axeMeta.addItemFlags(ItemFlag.HIDE_DYE);
        axeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        axe.setItemMeta(axeMeta);
        return axe;
    }}
