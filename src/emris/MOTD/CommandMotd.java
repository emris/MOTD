/**
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/MOTD
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package emris.MOTD;

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
