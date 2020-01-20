package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise

class Helicopter(x: Int, y: Int) {
    private val heli: Texture
    val position: Vector2
    val helicopterSprite: Sprite
    private var up: Boolean
    private var right: Boolean
    private val speed: Int
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
        position = Vector2(x.toFloat(), y.toFloat())
        heli = Texture("heli/heli.png")
        helicopterSprite = Sprite(heli)
        helicopterSprite.flip(true, false)
        up = true
        right = true
        speed = 300
    }
}