package com.maattss.intro.exercise.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.maattss.intro.exercise.IntroExercise

class RightPaddle(x: Int, y: Int) {
    val position: Vector2
    val texture: Texture
    val bounds: Rectangle

    fun update() {
        bounds.setPosition(position.x, position.y)
        if (position.y < 0) {
            position.y = 0f
        }
        if (position.y > IntroExercise.HEIGHT - texture.height) {
            position.y = IntroExercise.HEIGHT - texture.height.toFloat()
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) position.y += 20f
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) position.y -= 20f
    }

    init {
        position = Vector2(x.toFloat(), y.toFloat())
        texture = Texture("pong/paddle.png")
        bounds = Rectangle(position.x, position.y, texture.width.toFloat(), texture.height.toFloat())
    }
}