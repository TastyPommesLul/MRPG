package net.tastypommeslul.mRPG.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration

fun colored(text: String, color: TextColor): Component {
  return Component.text(text).style {
    it.color(color)
    it.decoration(TextDecoration.ITALIC, false)
  }
}