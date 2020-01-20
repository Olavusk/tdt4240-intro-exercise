package com.maattss.intro.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.intro.exercise.IntroExercise
import com.maattss.intro.exercise.sprites.BackButton
import com.maattss.intro.exercise.sprites.Helicopter

class Task1State(gsm: GameStateManager?) : State(gsm) {
    private val heli: Helicopter = Helicopter(0, 0)
    private val backBtn: BackButton = BackButton(false)
    override fun handleInput() {
        if (Gdx.input.justTouched()) {
            val touch = Rectangle(Gdx.input.x.toFloat(),
                    (IntroExercise.HEIGHT - Gdx.input.y).toFloat(), 1f, 1f)
            if (touch.overlaps(backBtn.bounds)) { // User pushed back button
                gsm.set(MenuState(gsm))
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
        heli.update(dt)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(1f, 0f, 0.996f, 1f)
        sb.draw(backBtn.texture, backBtn.x, backBtn.y)
        sb.draw(heli.helicopterSprite, heli.position.x, heli.position.y)
        sb.end()
    }

    override fun dispose() {
        heli.dispose()
    }
}