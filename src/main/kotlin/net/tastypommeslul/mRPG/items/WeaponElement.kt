package net.tastypommeslul.mRPG.items

import net.kyori.adventure.text.format.TextColor

enum class WeaponElement {
  NONE(TextColor.color(125, 125,125)),
  ICE(TextColor.color(0, 125, 255));

  private var color: TextColor = TextColor.color(0, 0, 0)
  constructor(color: TextColor) {
    this.color = color
  }

  override fun toString(): String {
    return when (this) {
      NONE -> "None"
      ICE -> "Ice"
    }
  }

  fun getColor(): TextColor = color
}
