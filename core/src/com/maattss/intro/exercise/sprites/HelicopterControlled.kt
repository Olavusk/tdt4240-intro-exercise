package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise

class HelicopterControlled(x: Int, y: Int) {
    private val heli: Texture
    val position: Vector2
    val helicopterSprite: Sprite
    private val movement: Int
    private var isFlipped: Boolean

    enum class MoveDirection {
        LEFT, RIGHT, UP, DOWN
    }

    fun update(moveDir: MoveDirection) {
        if (moveDir == MoveDirection.RIGHT) {
            if (position.x <= IntroExercise.WIDTH - heli.width) {
                position.x += movement.toFloat()
                if (isFlipped) {
                    isFlipped = false
                    helicopterSprite.flip(true, false)
                }
            }
        } else if (moveDir == MoveDirection.LEFT) {
            if (position.x > 0) {
                position.x -= movement.toFloat()
                if (!isFlipped) {
                    isFlipped = true
                    helicopterSprite.flip(true, false)
                }
            }
        } else if (moveDir == MoveDirection.DOWN) {
            if (position.y > 0) {
                position.y -= movement.toFloat()
            }
        } else if (moveDir == MoveDirection.UP) {
            if (position.y <= IntroExercise.HEIGHT - heli.height) {
                position.y += movement.toFloat()
            }
        }
    }

    fun dispose() {
        heli.dispose()
    }

    init {
        position = Vector2(x.toFloat(), y.toFloat())
        heli = Texture("heli/heli.png")
        helicopterSprite = Sprite(heli)
        helicopterSprite.flip(true, false)
        movement = 10
        isFlipped = false
    }
}