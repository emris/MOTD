/*
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

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="Motd", name="Message of the Day", version="1.2")
@NetworkMod(clientSideRequired=false, serverSideRequired=false)
public class Motd {

	@Instance("Motd")
	public static Motd instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		MotdUtil.loadFile();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){

	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// CommandBn can be changed into any name, as long as it is the same
		// as the name of the class that contains the code for your command.
		event.registerServerCommand(new CommandMotd());
		
		GameRegistry.registerPlayerTracker(new PlayerTracker());
	}
}
