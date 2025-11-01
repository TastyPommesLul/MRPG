package net.tastypommeslul.mRPG.items

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.tastypommeslul.mRPG.utils.colored
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

@Suppress("unused")
class Weapon(
  name: Component,
  element: WeaponElement,
  material: Material,
  val addedLore: MutableList<Component> = mutableListOf()
) : ItemStack(material) {

  init {
    addedLore.add(0, colored("Element: ", TextColor.color(150, 150, 150))
      .append(colored(element.toString(), element.getColor())))
    this.itemMeta = this.itemMeta.apply {
      this.displayName(name)
      this.lore(addedLore)
    }
  }

  fun addLore(lore: Component) {
    addedLore.add(lore)
  }
}