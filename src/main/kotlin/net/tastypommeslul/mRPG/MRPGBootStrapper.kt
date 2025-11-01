package net.tastypommeslul.mRPG

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import io.papermc.paper.plugin.bootstrap.PluginProviderContext
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import net.tastypommeslul.mRPG.commands.ItemsCommand
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class MRPGBootStrapper : PluginBootstrap {
  override fun bootstrap(context: BootstrapContext) {
    context.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) {
      it.registrar().register("items", ItemsCommand())
    }
  }

  override fun createPlugin(context: PluginProviderContext): JavaPlugin {
    return MRPG()
  }
}