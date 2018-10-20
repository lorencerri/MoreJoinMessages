package me.truexpixels.morejoinmessages.join;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.truexpixels.morejoinmessages.Main;
import me.truexpixels.morejoinmessages.utils.Utils;

public class JoinListener implements Listener {

	private static Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		// Disable Default Join Message
		e.setJoinMessage("");
		
		// Fetch Messages
		List<String> joinMessages = plugin.getConfig().getStringList("messages");
		
		// Select Message
		String random = joinMessages.get(new Random().nextInt(joinMessages.size()));
		
		// Apply Colors
		String usernameColor = plugin.getConfig().getString("username");
		String textColor = plugin.getConfig().getString("text");
		
		random = textColor + random.replace("<player>", usernameColor + player.getName() + textColor);
		
		// Send Message
		Bukkit.broadcastMessage(
				Utils.chat(random));
		
	}
	
}