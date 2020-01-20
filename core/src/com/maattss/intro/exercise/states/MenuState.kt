package com.maattss.intro.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.intro.exercise.IntroExercise
import com.maattss.intro.exercise.sprites.MenuButton

class MenuState(gsm: GameStateManager?) : State(gsm) {
    private val taskOne: MenuButton = MenuButton(350,
            IntroExercise.HEIGHT / 2 - 128, "menu/one.png")
    private val taskTwo: MenuButton = MenuButton(650,
            IntroExercise.HEIGHT / 2 - 128, "menu/two.png")
    private val taskThree: MenuButton = MenuButton(950,
            IntroExercise.HEIGHT / 2 - 128, "menu/three.png")
    private val taskFour: MenuButton = MenuButton(1250,
            IntroExercise.HEIGHT / 2 - 128, "menu/four.png")

    override fun handleInput() {
        if (Gdx.input.justTouched()) { // Decide which exercise user has selected
            val touch = Rectangle(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 1f, 1f)
            if (touch.overlaps(taskOne.bounds)) {
                gsm.set(Task1State(gsm))
            } else if (touch.overlaps(taskTwo.bounds)) {
                gsm.set(Task2State(gsm))
            } else if (touch.overlaps(taskThree.bounds)) {
                gsm.set(Task3State(gsm))
            } else if (touch.overlaps(taskFour.bounds)) {
                gsm.set(Task4State(gsm))
            }
        }
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(0.871f, 0.945f, 1f, 1f)
        // Draw exercise pick menu
        sb.draw(taskOne.texture, taskOne.x, IntroExercise.HEIGHT - taskOne.y)
        sb.draw(taskTwo.texture, taskTwo.x, IntroExercise.HEIGHT - taskTwo.y)
        sb.draw(taskThree.texture, taskThree.x, IntroExercise.HEIGHT - taskThree.y)
        sb.draw(taskFour.texture, taskFour.x, IntroExercise.HEIGHT - taskFour.y)
        sb.end()
    }

    override fun dispose() {
        taskOne.dispose()
        taskTwo.dispose()
        taskThree.dispose()
        taskFour.dispose()
    }
}