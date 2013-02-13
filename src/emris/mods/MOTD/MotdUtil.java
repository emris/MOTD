package emris.mods.MOTD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class MotdUtil {

	private static ArrayList<String> msgList = new ArrayList<String>();

	public static void sendMotd (ICommandSender sender) {
		Date now = new Date();
		if (sender instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) sender;
			String onlinePlayers = "" + player.worldObj.playerEntities.size();
			
			for (int l = 0; l < msgList.size(); l++) {
				player.sendChatToPlayer(
					msgList.get(l)
						.replaceAll("&", ChatFormatCodes.CODE.toString())
						.replaceAll("%playername%", player.username)
						.replaceAll("%players%", onlinePlayers)
						.replaceAll("%time%", now.toString()));
			}
		} else {
			for (int l = 0; l < msgList.size(); l++) {
				sender.sendChatToPlayer(msgList.get(l));
			}

		}
	}

	public static void loadFile() {
		msgList.clear();
		File file = new File(".", "MOTD.txt");
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while (br.ready()) {
					String line = br.readLine().trim();
					if (!(line.startsWith("#") || line.isEmpty())) {
						msgList.add(line);
					}
				}
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
				PrintWriter pw = new PrintWriter(file);
				
				pw.println("# This file contains the message sent to the player on login.");
				pw.println("# Lines starting with # are not read.");
				pw.println("# There are several codes that can be used to format the text.");
				pw.println("# If you want to use color, use this symbol & (ALT code 21) to indicate a color.");
				pw.println("# Handy link: http://www.minecraftwiki.net/wiki/Formatting_codes");
				pw.println("# Other codes:");
				pw.println("# %playername% => The name of the player the message is send to");
				pw.println("# %players% => Amount of players online.");
				pw.println("# %time% => Local server time. All in one string.");
				pw.println("# ");
				pw.println("");
				pw.println("&4################################################");
				pw.println("Welcome %playername%, to My Server.");
				pw.println("There are currently %players% players online.");
				pw.println("Server time: %time%.");
				pw.println("&4################################################");
				pw.close();
				
				msgList.add("&4################################################");
				msgList.add("Welcome %playername%, to My Server.");
				msgList.add("There are currently %players% players online.");
				msgList.add("Server time: %time%.");
				msgList.add("&4################################################");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
