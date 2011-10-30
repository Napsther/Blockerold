package me.Napsther.Blocker;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Blocker extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	private final BlockerPlayerListener playerListener = new BlockerPlayerListener(this);
	private final BlockerBlockListener blockListener = new BlockerBlockListener(this);
	
	@Override
	public void onDisable() {
		log.info("Blocker stoped");
	}

	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.PLAYER_BUCKET_EMPTY, playerListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		
		log.info("Blocker V: 1.0 started.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("mode")) {
			ToggelPlayer((Player)sender);
			return true;
		}
		return false;
	}
	
	private void ToggelPlayer(Player player ) {
		if (player.getGameMode().getValue() == 1) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(ChatColor.RED + "You are now in Survival!");
		}else{
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(ChatColor.GOLD + "You are now in Creative!");
		}
	}
}
