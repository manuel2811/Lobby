package main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class hide implements Listener{
	private lobby instance = lobby.getInstance();
	
	List<String> hidden = new ArrayList<String>();

	public hide() {
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getMaterial().equals(Material.SLIME_BALL));
			
			for(Player players : Bukkit.getOnlinePlayers()){
				
				if(hidden.contains(p.getName())) {
					hidden.remove(p.getName());
					p.showPlayer(players);
					p.sendMessage("Alle Spieler sind wieder sichtbar!");
				}else
					if(hidden.contains(p.getName())){
						hidden.add(p.getName());
						p.hidePlayer(players);
						p.sendMessage("Alle Spieler sind versteckt!");
					}

			}
			
		}
	}
	
}
