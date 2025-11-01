package net.tastypommeslul.mRPG.inventories

import io.papermc.paper.datacomponent.DataComponentTypes
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.tastypommeslul.mRPG.items.Weapons
import net.tastypommeslul.mRPG.utils.colored
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

class ItemsInventory : InventoryHolder, Listener {
  private val inventory: Inventory

  init {
    inventory = org.bukkit.Bukkit.createInventory(this, 54, colored("All Items from MRPG", TextColor.color(0, 200, 0)))
    for (item in Weapons.weapons) {
      inventory.addItem(item)
    }
    for (i in inventory.contents.indices) {
      if (inventory.getItem(i) != null) continue
      inventory.setItem(i, ItemStack(Material.BARRIER).apply {
        this.setData(DataComponentTypes.ITEM_NAME) {
          colored(
            "Empty Slot",
            TextColor.color(255, 0, 0)).decoration(TextDecoration.BOLD, true)
        }
        this.setData(DataComponentTypes.MAX_STACK_SIZE) { 1 }
      })
    }
  }

  override fun getInventory(): Inventory {
    return inventory
  }

  @EventHandler
  fun onInventoryClick(event: InventoryClickEvent) {
    if ((event.clickedInventory ?: return).holder !is ItemsInventory) return
    event.isCancelled = true
    if (!Weapons.weapons.contains(event.currentItem)) return
    when (event.click) {
      ClickType.SHIFT_LEFT -> event.whoClicked.inventory.addItem(event.currentItem ?: return)
      ClickType.LEFT -> event.whoClicked.setItemOnCursor(event.currentItem ?: return)
      else -> return
    }
  }
}