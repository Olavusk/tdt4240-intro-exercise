package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise

class Helicopter(x: Int, y: Int) {
    private val heli: Texture = Texture("heli/heli.png")
    val position: Vector2 = Vector2(x.toFloat(), y.toFloat())
    val helicopterSprite: Sprite = Sprite(heli)
    private var up: Boolean = true
    private var right: Boolean = true
    private val speed: Int = 300

    fun update(dt: Float) {
        moveX(speed * dt)
        moveY(speed * dt)
    }

    fun moveX(movement: Float) {
        if (right) {
            position.x += movement
        } else {
            position.x -= movement
        }
        if (right && position.x > IntroExercise.WIDTH - heli.width) {
            right = false
            helicopterSprite.flip(true, false)
        }
        if (!right && position.x < 0) {
            right = true
            helicopterSprite.flip(true, false)
        }
    }

    fun moveY(movement: Float) {
        if (up) {
            position.y += movement
        } else {
            position.y -= movement
        }
        if (up && position.y > IntroExercise.HEIGHT - heli.height) up = false
        if (!up && position.y < 0) up = true
    }

    fun dispose() {
        heli.dispose()
    }

    init {
        helicopterSprite.flip(true, false)
    }
}