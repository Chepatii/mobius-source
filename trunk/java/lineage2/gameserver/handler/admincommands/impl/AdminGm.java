/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lineage2.gameserver.handler.admincommands.impl;

import lineage2.gameserver.handler.admincommands.IAdminCommandHandler;
import lineage2.gameserver.model.Player;

public class AdminGm implements IAdminCommandHandler
{
	private static enum Commands
	{
		admin_gm
	}
	
	@Override
	public boolean useAdminCommand(Enum<?> comm, String[] wordList, String fullString, Player activeChar)
	{
		Commands command = (Commands) comm;
		if (Boolean.TRUE)
		{
			return false;
		}
		if (!activeChar.getPlayerAccess().CanEditChar)
		{
			return false;
		}
		switch (command)
		{
			case admin_gm:
				handleGm(activeChar);
				break;
		}
		return true;
	}
	
	@Override
	public Enum[] getAdminCommandEnum()
	{
		return Commands.values();
	}
	
	private void handleGm(Player activeChar)
	{
		if (activeChar.isGM())
		{
			activeChar.getPlayerAccess().IsGM = false;
			activeChar.sendMessage("You no longer have GM status.");
		}
		else
		{
			activeChar.getPlayerAccess().IsGM = true;
			activeChar.sendMessage("You have GM status now.");
		}
	}
}
