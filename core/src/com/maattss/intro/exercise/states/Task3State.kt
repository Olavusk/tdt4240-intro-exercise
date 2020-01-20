package com.maattss.intro.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.intro.exercise.IntroExercise
import com.maattss.intro.exercise.sprites.BackButton
import com.maattss.intro.exercise.sprites.HelicopterAnimated

class Task3State(gsm: GameStateManager?) : State(gsm) {
    private val heli1: HelicopterAnimated = HelicopterAnimated(IntroExercise.WIDTH / 2 + 300, IntroExercise.HEIGHT / 2)
    private val heli2: HelicopterAnimated = HelicopterAnimated(IntroExercise.WIDTH / 2, IntroExercise.HEIGHT / 2)
    private val heli3: HelicopterAnimated = HelicopterAnimated(IntroExercise.WIDTH / 2 - 300, IntroExercise.HEIGHT / 2)
    private val backBtn: BackButton = BackButton(false)
    public override fun handleInput() {
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
        heli1.update(dt, heli2, heli3)
        heli2.update(dt, heli1, heli3)
        heli3.update(dt, heli1, heli2)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(1f, 0f, 0.996f, 1f)
        sb.draw(heli1.texture, heli1.x, heli1.y)
        sb.draw(heli2.texture, heli2.x, heli2.y)
        sb.draw(heli3.texture, heli3.x, heli3.y)
        sb.draw(backBtn.texture, backBtn.x, backBtn.y)
        sb.end()
    }

    override fun dispose() {}
}