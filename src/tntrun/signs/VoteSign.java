/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 */

package tntrun.signs;

import org.bukkit.ChatColor;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import tntrun.TNTRun;
import tntrun.arena.Arena;

public class VoteSign {

	private TNTRun plugin;
	public VoteSign(TNTRun plugin)
	{
		this.plugin = plugin;
	}

	
	protected void handleCreation(SignChangeEvent e)
	{
		e.setLine(0, ChatColor.BLUE+"[TNTRun]");
		e.getPlayer().sendMessage("Sign succesfully created");
	}
	
	protected void handleClick(PlayerInteractEvent e)
	{
		Arena arena = plugin.pdata.getPlayerArena(e.getPlayer().getName());
		if (arena!=null)
		{
			arena.arenaph.vote(e.getPlayer());
			e.setCancelled(true);
		} else
		{
			e.getPlayer().sendMessage("You are not in arena");
		}
	}
	
}
