package me.foxikle.gadgets.Listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MenuOpenListeners implements Listener {

    @EventHandler
    public static void StartGame(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.PLAYER) {
            Player target = (Player) event.getRightClicked();
            Player user = event.getPlayer();

            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().getKeys().contains("RPS")){
                TextComponent msg = new TextComponent(user + " has challenged you to a game of Rock Paper Scissors!");
                msg.setColor(ChatColor.GOLD);
                TextComponent Accept = new TextComponent("[ACCEPT]");
                Accept.setColor(ChatColor.DARK_GREEN);
                Accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/RPS ACCEPT"));
                Accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to accept").color(ChatColor.GREEN).create()));

                TextComponent Decline = new TextComponent("[DECLINE]");
                Decline.setColor(ChatColor.DARK_RED);
                Decline.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/RPS DECLINE"));
                Decline.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to decline").color(ChatColor.RED).create()));

                msg.addExtra(Accept);
                msg.addExtra(Decline);
                target.spigot().sendMessage(Accept);
                user.sendMessage(ChatColor.GOLD + "You challenged " + target + " to a game of Rock Paper Scissors!");

            } else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().getKeys().contains("C4")){

                TextComponent msg = new TextComponent(user + " has challenged you to a game of Connect Four!");
                msg.setColor(ChatColor.GOLD);
                TextComponent Accept = new TextComponent("[ACCEPT]");
                Accept.setColor(ChatColor.DARK_GREEN);
                Accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/C4 ACCEPT"));
                Accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to accept").color(ChatColor.GREEN).create()));

                TextComponent Decline = new TextComponent("[DECLINE]");
                Decline.setColor(ChatColor.DARK_RED);
                Decline.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/C4 DECLINE"));
                Decline.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to decline").color(ChatColor.RED).create()));

                msg.addExtra(Accept);
                msg.addExtra(Decline);
                target.spigot().sendMessage(Accept);
                user.sendMessage(ChatColor.GOLD + "You challenged " + target + " to a game of Connect Four!");

            } else if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().getKeys().contains("TTT")){

                TextComponent msg = new TextComponent(user + " has challenged you to a game of Tic Tac Toe!");
                msg.setColor(ChatColor.GOLD);
                TextComponent Accept = new TextComponent("[ACCEPT]");
                Accept.setColor(ChatColor.DARK_GREEN);
                Accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/TTT ACCEPT"));
                Accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to accept").color(ChatColor.GREEN).create()));

                TextComponent Decline = new TextComponent("[DECLINE]");
                Decline.setColor(ChatColor.DARK_RED);
                Decline.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/TTT DECLINE"));
                Decline.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to decline").color(ChatColor.RED).create()));

                msg.addExtra(Accept);
                msg.addExtra(Decline);
                target.spigot().sendMessage(Accept);
                user.sendMessage(ChatColor.GOLD + "You challenged " + target + " to a game of Tic Tac Toe!");

            }
        }
    }

    public static boolean OnCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("TTT") /*| (label.equalsIgnoreCase("C4")) |(label.equalsIgnoreCase("RPS"))*/) {
            if (sender != null) {
                if (args.length < 2) {
                    player.sendMessage(org.bukkit.ChatColor.RED + "Incorrect usage. Don't use this if you don't know what you're doing");
                } else {
                    if (player.hasPermission("Gadgets.DO_NOT_USE")) {
                        if(args[0].equals("ACCEPT")){
                            sender.sendMessage(ChatColor.GREEN + "You accepted the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.GREEN + player.getName() + " Accepted your challenge :)");

                        } else if(args[0].equals("DECLINE")){
                            sender.sendMessage(ChatColor.RED + "You declined the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.RED + player.getName() + " declined your challenge :(");
                        }
                    } else {
                        player.sendMessage(org.bukkit.ChatColor.RED + "You do not have the suitable permissions to use this command.");
                        player.sendMessage(org.bukkit.ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    }
                }
            }
            return true;
        } else if(label.equalsIgnoreCase("C4")){
            if (sender != null) {
                if (args.length < 2) {
                    player.sendMessage(org.bukkit.ChatColor.RED + "Incorrect usage. Don't use this if you don't know what you're doing");
                } else {
                    if (player.hasPermission("Gadgets.DO_NOT_USE")) {
                        if(args[0].equals("ACCEPT")){
                            sender.sendMessage(ChatColor.GREEN + "You accepted the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.GREEN + player.getName() + " Accepted your challenge :)");

                        } else if(args[0].equals("DECLINE")){
                            sender.sendMessage(ChatColor.RED + "You declined the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.RED + player.getName() + " declined your challenge :(");
                        }
                    } else {
                        player.sendMessage(org.bukkit.ChatColor.RED + "You do not have the suitable permissions to use this command.");
                        player.sendMessage(org.bukkit.ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    }
                }
            }
            return true;
        } else if((label.equalsIgnoreCase("RPS"))){
            if (sender != null) {
                if (args.length < 2) {
                    player.sendMessage(org.bukkit.ChatColor.RED + "Incorrect usage. Don't use this if you don't know what you're doing");
                } else {
                    if (player.hasPermission("Gadgets.DO_NOT_USE")) {
                        if(args[0].equals("ACCEPT")){
                            sender.sendMessage(ChatColor.GREEN + "You accepted the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.GREEN + player.getName() + " Accepted your challenge :)");

                        } else if(args[0].equals("DECLINE")){
                            sender.sendMessage(ChatColor.RED + "You declined the challenge.");
                            Player user = Bukkit.getServer().getPlayer(args[1]);
                            assert user != null;
                            user.sendMessage(ChatColor.RED + player.getName() + " declined your challenge :(");
                        }
                    } else {
                        player.sendMessage(org.bukkit.ChatColor.RED + "You do not have the suitable permissions to use this command.");
                        player.sendMessage(org.bukkit.ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    }
                }
            }
            return true;
        }
        return false;
    }
}

