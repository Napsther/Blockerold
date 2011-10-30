package me.Napsther.Blocker;

import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerListener;

public class BlockerPlayerListener extends PlayerListener {
	public static Blocker plugin;
	
	public BlockerPlayerListener(Blocker instance) {
		plugin = instance;
	}
	
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
		if (!event.getPlayer().hasPermission("blocker.placeLiquid")) {
			if (!event.isCancelled()){
				event.setCancelled(true);
			}
		}
	}
}