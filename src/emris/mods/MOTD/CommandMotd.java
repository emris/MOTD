package emris.mods.MOTD;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;


public class CommandMotd extends CommandBase {

	public String getCommandName() {
		return "motd";
	}

	public String getCommandUsage(ICommandSender var1) {
		return "/" + getCommandName();
	}

	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		if(var2.length > 0 && var2[0].equalsIgnoreCase("reload")) {
			MotdUtil.loadFile();
		}
		
		MotdUtil.sendMotd(var1);
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender var1) {
		return true;
	}

}
