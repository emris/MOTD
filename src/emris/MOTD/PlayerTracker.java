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

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerTracker implements IPlayerTracker {

	@Override
	public void onPlayerLogin(final EntityPlayer player) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				MotdUtil.sendMotd(player);
			}
		}, 5000);
		
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		return;

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		return;

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		return;

	}

}
