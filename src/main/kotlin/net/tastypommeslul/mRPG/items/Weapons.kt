package net.tastypommeslul.mRPG.items

import net.tastypommeslul.mRPG.utils.colored
import org.bukkit.Material

object Weapons {
  val iceBlade = Weapon(colored("Ice Blade", WeaponElement.ICE.getColor()), WeaponElement.ICE,
    Material.IRON_SWORD
  )

  val weapons: List<Weapon> = listOf(iceBlade)
}
