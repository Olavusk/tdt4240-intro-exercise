package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class MenuButton(x: Int, y: Int, texturePath: String?) {
    val texture: Texture
    private val position: Vector2
    val bounds: Rectangle

    val x: Float
        get() = position.x

    val y: Float
        get() = position.y + texture.height

    fun dispose() {
        texture.dispose()
    }

    init {
        texture = Texture(texturePath)
        position = Vector2(x.toFloat(), y.toFloat())
        bounds = Rectangle(position.x, position.y, texture.width.toFloat(), texture.height.toFloat())
    }
}