package net.tastypommeslul.mRPG

import net.tastypommeslul.mRPG.inventories.ItemsInventory
import org.bukkit.plugin.java.JavaPlugin

class MRPG : JavaPlugin() {

  override fun onEnable() {
//    server.pluginManager.registerEvents(DebugListener(), this)
    server.pluginManager.registerEvents(ItemsInventory(), this)
  }

  override fun onDisable() {

  }
}
