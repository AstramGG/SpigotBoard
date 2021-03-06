package me.developer.ypedx.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.developer.ypedx.SpigotBoard;

public class SBCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			
		  if(!(sender instanceof Player)) {
			  
			  sender.sendMessage("�cYou have to be a player to use this command.");
			  
			  return true;
		  }
		  
		  if(args.length == 0) {
			  
			  sender.sendMessage("�cInvalid usage. Help: �7/spigotboard help");
			  
			  return true;
			  
		  } else {
			  
			  if(args[0].equalsIgnoreCase("reload")) {
				  
				  if(!sender.hasPermission("spigotboard.reload")) {
					  
					  sender.sendMessage("�cYou do not have permission to use this command.");
					  
					  return true;
					  
				  } else {
					  
					  SpigotBoard.instance.reloadConfig();
					  
					  sender.sendMessage("�7Config �asuccessfully �7reloaded.");
					  
					  return true;
				  }
				  
			  } else
				  
				  if(args[0].equalsIgnoreCase("help")) {
					  
					  if(!sender.hasPermission("spigotboard.reload")) {
						  
						  sender.sendMessage("�cYou do not have permission to use this command.");
						  
						  return true;
						  
					  } else {
						  
						  sender.sendMessage("�8�m-+-----[�c Spigot�7Board �8�m]-----+-");
						  sender.sendMessage("");
					      sender.sendMessage("�* �7/spigotboard reload");
					      sender.sendMessage("�* �7/"+SpigotBoard.instance.getConfig().getString("Settings.toggleCommand"));
					      sender.sendMessage("");
					      sender.sendMessage("�8�m-+-----------------------+-");
					      
					      return true;
					  }
					  
				  } else {
					  
					  sender.sendMessage("�cInvalid usage. Help: �7/spigotboard help");
					  
					  return true;
				  }
		  }
	}
	
}