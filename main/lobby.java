package main;

import org.bukkit.plugin.java.JavaPlugin;

public class lobby extends JavaPlugin {
	
	private static lobby instance;
	
	public void onEnable(){
		instance = this;
		System.out.println("[MineGames Lobby] aktiviert");
        new teleporter1();
        new hide();
	}

	public void onDisable(){
		System.out.println("[MineGames Lobby] deaktiviert");
	}
	
	public static lobby getInstance() {
		return instance;
	}
}
