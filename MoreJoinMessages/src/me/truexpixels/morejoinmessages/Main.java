package me.truexpixels.morejoinmessages;

import org.bukkit.plugin.java.JavaPlugin;

import me.truexpixels.morejoinmessages.join.JoinListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		new JoinListener(this);
	}
	
}
