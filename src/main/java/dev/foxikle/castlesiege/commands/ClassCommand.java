package dev.foxikle.castlesiege.commands;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.Class;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClassCommand implements CommandExecutor, TabCompleter {

    private final CastleSiege plugin;

    public ClassCommand(CastleSiege plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if(args.length >= 1) {
                if (!plugin.getGameManager().getClasses().containsKey(player)) {
                    String selectedClass = args[0].toLowerCase();
                    if (selectedClass.equalsIgnoreCase("tank")) {
                        plugin.getGameManager().giveKit(player, Class.TANK);
                        player.sendMessage(ChatColor.GREEN + "You selected the tank class!");
                    } else if (selectedClass.equalsIgnoreCase("warrior")) {
                        plugin.getGameManager().giveKit(player, Class.WARRIOR);
                        player.sendMessage(ChatColor.GREEN + "You selected the warrior class!");
                    } else if (selectedClass.equalsIgnoreCase("wizard")) {
                        plugin.getGameManager().giveKit(player, Class.WIZARD);
                        player.sendMessage(ChatColor.GREEN + "You selected the wizard class!");
                    } else if (selectedClass.equalsIgnoreCase("archer")) {
                        plugin.getGameManager().giveKit(player, Class.ARCHER);
                        player.sendMessage(ChatColor.GREEN + "You selected the archer class!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You've already selected the " + plugin.getGameManager().getClasses().get(player) + " class!");
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }
}
