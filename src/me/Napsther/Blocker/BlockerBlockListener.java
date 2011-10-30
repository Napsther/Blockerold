package me.Napsther.Blocker;

import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockerBlockListener extends BlockListener {
	public static Blocker plugin;
	
	public BlockerBlockListener (Blocker instance) {
		plugin = instance;
	}
	
	public void onBlockPlace(BlockPlaceEvent event) {
		//Stops player from building
		if (!event.getPlayer().hasPermission("blocker.build")) {
			if (!event.isCancelled()) {
				event.setCancelled(true);
			}
		}
		
		//Stops player from placing fier or tnt
		if (event.getBlock().getTypeId() == 51 || event.getBlock().getTypeId() == 46) {
			if (!event.getPlayer().hasPermission("blocker.burn")) {
				if (!event.isCancelled()) {
					event.setCancelled(true);
				}
			}
		}
		
		//Stops player form placing liquid blocks
		if (event.getBlock().getTypeId() == 8 || event.getBlock().getTypeId() == 9 || event.getBlock().getTypeId() == 10 || event.getBlock().getTypeId() == 11) {
			if (!event.getPlayer().hasPermission("blocker.placeLiquid")) {
				if (!event.isCancelled()) {
					event.setCancelled(true);
				}
			}
		}
	}
}
