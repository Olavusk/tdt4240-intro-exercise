package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise
import java.util.*

class HelicopterAnimated(x: Int, y: Int) {
    private val heliAnimation: Animation
    val bounds: Rectangle
    private val position: Vector2
    private val rand: Random
    private var up: Boolean
    private var right: Boolean
    private val speed: Int
    private val heliWidth: Float
    private val heliHeight: Float
    fun update(dt: Float, h2: HelicopterAnimated, h3: HelicopterAnimated) {
        heliAnimation.update(dt)
        bounds.setPosition(position.x, position.y)
        if (bounds.overlaps(h2.bounds) || bounds.overlaps(h3.bounds)) {
            up = !up
            right = !right
        }
        moveX(speed * dt)
        moveY(speed * dt)
    }

    fun moveX(speed: Float) {
        if (right) {
            position.x += speed
        } else {
            position.x -= speed
        }
        if (right && position.x > IntroExercise.WIDTH - heliWidth) right = false
        if (!right && position.x < 0) right = true
    }

    fun moveY(speed: Float) {
        if (up) {
            position.y += speed
        } else {
            position.y -= speed
        }
        if (up && position.y > IntroExercise.HEIGHT - heliHeight) up = false
        if (!up && position.y < 0) up = true
    }

    val x: Float
        get() = position.x

    val y: Float
        get() = position.y

    val texture: TextureRegion?
        get() = heliAnimation.getFrame()

    init {
        val texture = Texture("heli/helianimation.png")
        heliAnimation = Animation(TextureRegion(texture), 4, 0.1f)
        position = Vector2(x.toFloat(), y.toFloat())
        rand = Random()
        val heli = Texture("heli/heli.png")
        heliHeight = heli.height.toFloat()
        heliWidth = heli.width.toFloat()
        heli.dispose()
        // Assign random speed and direction to heli
        speed = 40 * rand.nextInt(20) + 1
        up = rand.nextBoolean()
        right = rand.nextBoolean()
        bounds = Rectangle(position.x, position.y, heli.width.toFloat(), heli.height.toFloat())
    }
}