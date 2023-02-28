package dev.foxikle.castlesiege.managers;

import dev.foxikle.castlesiege.CastleSiege;
import dev.foxikle.castlesiege.GameState;
import dev.foxikle.castlesiege.tasks.GameStartCountdownTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class testCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (player.getName().equalsIgnoreCase("Foxikle") || player.getName().equalsIgnoreCase("Oxikle")) {
                if (label.equalsIgnoreCase("test")) {
                    if (args.length >= 1) {
                        if (args[0].equalsIgnoreCase("paste")) {
                            sender.sendMessage(ChatColor.GREEN + "Pasting!");
                            CastleSiege.getInstance().getWorldManager().createSpawnPlatform();
                        } else if (args[0].equalsIgnoreCase("remove")) {
                            sender.sendMessage(ChatColor.GREEN + "Removing!");
                            CastleSiege.getInstance().getWorldManager().removeSpawnPlatform();
                        } else if (args[0].equalsIgnoreCase("waiting")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.WAITING);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.WAITING);
                        } else if (args[0].equalsIgnoreCase("presiege")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.PRESIEGE);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.PRESIEGE);
                        } else if (args[0].equalsIgnoreCase("siege")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.SIEGE);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.SIEGE);
                        } else if (args[0].equalsIgnoreCase("victory")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.VICTORY);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.VICTORY);
                        } else if (args[0].equalsIgnoreCase("voting")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.VOTING);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.VOTING);
                        } else if (args[0].equalsIgnoreCase("prewaiting")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.PREWAITING);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.PREWAITING);
                        } else if (args[0].equalsIgnoreCase("cleanup")) {
                            CastleSiege.getInstance().getGameManager().setGameState(GameState.CLEANUP);
                            player.sendMessage(ChatColor.GREEN + "The game state is now " + GameState.CLEANUP);
                        } else if (args[0].equalsIgnoreCase("start")) {
                            GameStartCountdownTask task = new GameStartCountdownTask(CastleSiege.getInstance().getGameManager(), 11);
                            player.sendMessage(ChatColor.GREEN + "Starting the game!");
                            task.runTaskTimer(CastleSiege.getInstance(), 1, 20);
                        } else if (args[0].equalsIgnoreCase("fangs")) {
                            World world = Bukkit.getWorld(CastleSiege.getInstance().getConfig().getString("worldName"));
                            world.spawnEntity(new Location(world, 37.5, 25, -55), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 25, -55), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 25, -55), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 25, -56), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 25, -56), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 25, -56), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 24.5, -57), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 24.5, -57), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 24.5, -57), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 24.5, -58), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 24.5, -58), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 24.5, -58), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 24.5, -59), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 24.5, -59), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 24.5, -59), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 25, -60), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 25, -60), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 25, -60), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 37.5, 25, -60), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 36.5, 25, -60), EntityType.EVOKER_FANGS);
                            world.spawnEntity(new Location(world, 35.5, 25, -60), EntityType.EVOKER_FANGS);
                        } else if (args[0].equalsIgnoreCase("stands")) {
                            player.sendMessage(ChatColor.GREEN + "Summoning Stands!");
                            CastleSiege.getInstance().getWorldManager().summonClassStands();
                        } else if (args[0].equalsIgnoreCase("removestands")) {
                            CastleSiege.getInstance().getWorldManager().removeRedHitbox();
                            CastleSiege.getInstance().getWorldManager().removeBlueHitbox();
                        } else if (args[0].equalsIgnoreCase("hitbox")) {
                            if(!(args.length < 2)) {
                                if(args[1].equals("R")) {
                                    CastleSiege.getInstance().getWorldManager().addRedHitbox();
                                } else if (args[1].equals("B")) {
                                    CastleSiege.getInstance().getWorldManager().addBlueHitbox();
                                } else if (args[1].equalsIgnoreCase("BOTH")) {
                                    CastleSiege.getInstance().getWorldManager().addBlueHitbox();
                                    CastleSiege.getInstance().getWorldManager().addRedHitbox();
                                }
                            } else {
                                player.sendMessage(ChatColor.RED + "You need a 2nd argument! <R/B/Both>");
                            }
                        } else if (args[0].equalsIgnoreCase("gateHolograms")) {
                           CastleSiege.getInstance().getWorldManager().addRedGateHologram();
                           CastleSiege.getInstance().getWorldManager().addBlueGateHologram();
                        } else if (args[0].equalsIgnoreCase("bGateFall")) {
                            CastleSiege.getInstance().getWorldManager().knockDownBlueGate();
                        } else if (args[0].equalsIgnoreCase("rGateFall")) {
                            CastleSiege.getInstance().getWorldManager().knockDownRedGate();
                        } else if (args[0].equalsIgnoreCase("bGatePaste")) {
                            CastleSiege.getInstance().getWorldManager().pasteBGate();
                        } else if (args[0].equalsIgnoreCase("rGatePaste")) {
                            CastleSiege.getInstance().getWorldManager().pasteRGate();
                        } else if (args[0].equalsIgnoreCase("blueteam")) {
                            CastleSiege.getInstance().getGameManager().addBlueTeamMember(player);
                        } else if (args[0].equalsIgnoreCase("redTeam")) {
                            CastleSiege.getInstance().getGameManager().addRedTeamMember(player);
                        } else if (args[0].equalsIgnoreCase("gamestate")) {
                            player.sendMessage(CastleSiege.getInstance().getGameManager().getGameState() + " is the current game state");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Invalid Argument! /test <task>");
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
        sender.sendMessage("No!");
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> completions = new ArrayList<>();
            completions.add("paste");
            completions.add("remove");
            completions.add("waiting");
            completions.add("presiege");
            completions.add("siege");
            completions.add("victory");
            completions.add("cleanup");
            completions.add("prewating");
            completions.add("voting");
            completions.add("start");
            completions.add("fangs");
            completions.add("stands");
            completions.add("hitbox");
            completions.add("gateHolograms");
            completions.add("bGateFall");
            completions.add("rGateFall");
            completions.add("rGatePaste");
            completions.add("bGatePaste");
            completions.add("redteam");
            completions.add("blueteam");
            completions.add("removestands");
            completions.add("gamestate");

            return completions;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("hitbox")) {
            List<String> completions = new ArrayList<>();
            completions.add("B");
            completions.add("R");
            completions.add("BOTH");
            return completions;
        }
        return new ArrayList<>();
    }
}
