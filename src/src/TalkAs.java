package src;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class TalkAs extends JavaPlugin
{	 
	public void onEnable()
	{

	}
		 
	public void onDisable()
	{
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("talk"))
		{
			if(args.length == 0)
			{
				sender.sendMessage(ChatColor.GREEN + "Not enough arguments");
			}
			else
			{
				String msg = "";
				for(int i = 1;i < args.length;i++)
				{
					msg = msg + args[i];
					msg = msg + " ";
				}
				if (Bukkit.getServer().getPlayer(args[0]) == null)
				{
			        Player[] playerlist = Bukkit.getServer().getOnlinePlayers();
			        for (int i = 0; i < playerlist.length; i++)
			        {
			        	playerlist[i].sendMessage("<" + args[0] + "> " + msg);
			        }
				}
				else
				{
					Bukkit.getServer().getPlayer(args[0]).chat(msg);
				}
			}
			
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("login"))
		{
			if(args.length == 0)
			{
				sender.sendMessage(ChatColor.GREEN + "Not enough arguments");
			}
			else
			{
		        Player[] playerlist = Bukkit.getServer().getOnlinePlayers();
		        for (int i = 0; i < playerlist.length; i++)
		        {
		          playerlist[i].sendMessage(ChatColor.YELLOW + args[0] + " " + "joined the game.");
		        }
			}
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("logout"))
		{
			if(args.length == 0)
			{
				sender.sendMessage(ChatColor.GREEN + "Not enough arguments");
			}
			else
			{
		        Player[] playerlist = Bukkit.getServer().getOnlinePlayers();
		        for (int i = 0; i < playerlist.length; i++)
		        {
		          playerlist[i].sendMessage(ChatColor.YELLOW + args[0] + " " + "left the game.");
		        }
			}
			
			return true;
		}
		return false;
	}

}
