package com.github.woxloi.loginbonus;

import com.github.woxloi.loginbonus.commands.LoginBonusCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;

public final class Main extends JavaPlugin implements Listener {

    public static final String prefix = "§6[§e§lLoginBonus§6]§f";
    public static final String author = "woxloi";

    @Override
    public void onEnable() {
        // イベント登録
        getServer().getPluginManager().registerEvents(this, this);
        // コマンド登録
        this.getCommand("loginbonus").setExecutor(new LoginBonusCommand(this));
        getLogger().info(prefix + "プラグインが有効になりました！");
    }

    @Override
    public void onDisable() {
        getLogger().info(prefix + "プラグインが無効になりました！");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(prefix + "ようこそ " + p.getName() + " さん！ログインボーナスを受け取れます。");
    }

    public static void sendPrefixMessage(CommandSender sender, String msg) {
        sender.sendMessage(prefix + msg);
    }
}
