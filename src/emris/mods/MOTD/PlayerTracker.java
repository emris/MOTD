package emris.mods.MOTD;

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
