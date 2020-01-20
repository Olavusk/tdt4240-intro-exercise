package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise

class BackButton(white: Boolean) {
    var texture: Texture? = null
    private val position: Vector2
    val bounds: Rectangle

    val x: Float
        get() = position.x

    val y: Float
        get() = position.y

    fun dispose() {
        texture!!.dispose()
    }

    init {
        if (white) {
            texture = Texture("buttons/backWhite.png")
        } else {
            texture = Texture("buttons/back.png")
        }
        position = Vector2(50f, (IntroExercise.HEIGHT - 100).toFloat())
        bounds = Rectangle(position.x, position.y, 100f, 100f)
    }
}