package net.tastypommeslul.mRPG.commands

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.tastypommeslul.mRPG.inventories.ItemsInventory
import org.bukkit.entity.Player

class ItemsCommand : BasicCommand {
  override fun execute(
    commandSourceStack: CommandSourceStack,
    args: Array<out String>
  ) {
    val player: Player = commandSourceStack.sender as Player
    player.openInventory(ItemsInventory().inventory)
  }

  override fun permission(): String {
    return "mrpg.admin"
  }
}