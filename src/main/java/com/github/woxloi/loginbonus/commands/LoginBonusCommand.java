package com.github.woxloi.loginbonus.commands;

import com.github.woxloi.loginbonus.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoginBonusCommand implements CommandExecutor {

    private final Main plugin;

    public LoginBonusCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("このコマンドはプレイヤーのみ使用可能です。");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            Main.sendPrefixMessage(player, "使い方: /loginbonus 受け取り");
            return true;
        }

        if (args[0].equalsIgnoreCase("受け取り")) {
            // TODO: 実際のボーナス配布処理
            Main.sendPrefixMessage(player, "ログインボーナスを受け取りました！");
            return true;
        }

        Main.sendPrefixMessage(player, "不明なサブコマンドです。");
        return true;
    }
}
