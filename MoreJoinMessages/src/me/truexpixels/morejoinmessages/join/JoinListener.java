package me.truexpixels.morejoinmessages.join;

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
		
		// Join Messages Array
		String[] joinMessages = {
				// Random
				"&f<player> &7just joined the server - glhf!",
				"&7Ha! &f<player> &7has joined! You activated my trap card!",
				"&7A &f<player> &7has spawned in the server.",
				"&f<player> &7has arrived. Party's over.",
				"&7Hello. Is it &f<player> &7you're looking for?",
				"&7It's a bird! It's a plane! Nevermind, it's just &f<player>&7.",
				"&f<player> &7just slid into the server.",
				"&7A wild &f<player> &7appeared!",
				"&7Who's that?! Oh it's just &f<player>&7.",
				"&7Okay who left the door open? &f<player> &7just walked in.",
				"&7Party's over, &f<player> &7just joined.",
				"&7Where is the music coming from? Oh it's just &f<player>&7.",
				"&7Run! &f<player> &7just came through the portal!",
				"&7Welcome &f<player>&7, are you the new merchant?",
				"&f<player> &7just joined. Can I get a heal?",
				// Hide Your Objects
				"&f<player> &7just joined. Hide your diamonds.",
				"&f<player> &7just joined. Hide your gold.",
				"&f<player> &7just joined. Hide your ender perals.",
				"&f<player> &7just joined. Hide your valuables.",
				// Call To Actions
				"&f<player> &7just joined. Everyone, look busy!",
				"&f<player> &7just joined, press F in chat.",
				"&7Someone grab some water! &f<player> &7just dropped in with their mixtape!",
				"&f<player> &7has arrived. Someone close the gate!",
				// Mysterious
				"&7Uh oh. &f<player> &7is here.",
				"&f<player> &7is here, as the prophecy foretold.",
				"&7We've been expecting you &f<player>&7.",
				"&f<player> &7just joined, hopefully they don't notice their missing items."
				};
		
		// Select Message
		String message = joinMessages[new Random().nextInt(joinMessages.length)];
		
		// Send Message
		Bukkit.broadcastMessage(
				Utils.chat(message).replace("<player>", player.getName()));
		
	}
	
}