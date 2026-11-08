package me.grassmp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class GrassMP extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        for (Player p : Bukkit.getOnlinePlayers()) {
            setup(p);
        }
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        setup(e.getPlayer());
    }

    public void setup(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective(
            "grassmp", "dummy",
            ChatColor.RED + "" + ChatColor.BOLD + "GRASSMP"
        );

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore(ChatColor.GRAY + "---------------").setScore(3);
        obj.getScore(ChatColor.WHITE + "Player: " + ChatColor.RED + p.getName()).setScore(2);
        obj.getScore(ChatColor.DARK_RED + "Have fun!").setScore(1);

        p.setScoreboard(board);
    }
}
