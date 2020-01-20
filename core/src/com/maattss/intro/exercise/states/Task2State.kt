package com.maattss.intro.exercise.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.maattss.intro.exercise.IntroExercise
import com.maattss.intro.exercise.sprites.BackButton
import com.maattss.intro.exercise.sprites.HelicopterControlled
import com.maattss.intro.exercise.sprites.MoveButton

class Task2State(gsm: GameStateManager?) : State(gsm) {
    private val heli: HelicopterControlled =
            HelicopterControlled(0, 0)
    private val font: BitmapFont =
            BitmapFont(Gdx.files.internal("fonts/arial.fnt"))
    private val backBtn: BackButton =
            BackButton(false)
    private val moveLeft: MoveButton =
            MoveButton(IntroExercise.WIDTH - 450, 50, "controls/left.png")
    private val moveRight: MoveButton =
            MoveButton(IntroExercise.WIDTH - 150, 50, "controls/right.png")
    private val moveUp: MoveButton =
            MoveButton(IntroExercise.WIDTH - 300, 200, "controls/up.png")
    private val moveDown: MoveButton =
            MoveButton(IntroExercise.WIDTH - 300, 50, "controls/down.png")

    override fun handleInput() {
        // Input from onscreen controls
        val touch = Rectangle(Gdx.input.x.toFloat(),
                (IntroExercise.HEIGHT - Gdx.input.y).toFloat(), 1f, 1f)
        if (Gdx.input.justTouched()) {

            if (touch.overlaps(backBtn.bounds)) { // User pushed back button
                gsm.set(MenuState(gsm))
            }
        }
        if (touch.overlaps(moveLeft.bounds)) {
            heli.update(HelicopterControlled.MoveDirection.LEFT)
        }
        if (touch.overlaps(moveRight.bounds)) {
            heli.update(HelicopterControlled.MoveDirection.RIGHT)
        }
        if (touch.overlaps(moveUp.bounds)) {
            heli.update(HelicopterControlled.MoveDirection.UP)
        }
        if (touch.overlaps(moveDown.bounds)) {
            heli.update(HelicopterControlled.MoveDirection.DOWN)
        }

        // Input from keyboard
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            heli.update(HelicopterControlled.MoveDirection.LEFT)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            heli.update(HelicopterControlled.MoveDirection.RIGHT)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            heli.update(HelicopterControlled.MoveDirection.UP)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            heli.update(HelicopterControlled.MoveDirection.DOWN)
        }
    }

    override fun update(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        Gdx.gl.glClearColor(1f, 0f, 0.996f, 1f)
        sb.draw(heli.helicopterSprite, heli.position.x, heli.position.y)

        // Sprite position
        font.data.setScale(0.3f)
        font.color = Color.BLACK
        sb.draw(backBtn.texture, backBtn.x, backBtn.y)
        font.draw(sb, "[" + heli.position.x + "," + heli.position.y +
                "]\n", 150f, IntroExercise.HEIGHT - 50.toFloat())
        // Control buttons
        sb.draw(moveLeft.texture, moveLeft.x, moveLeft.y)
        sb.draw(moveRight.texture, moveRight.x, moveRight.y)
        sb.draw(moveUp.texture, moveUp.x, moveUp.y)
        sb.draw(moveDown.texture, moveDown.x, moveDown.y)
        sb.end()
    }

    override fun dispose() {
        heli.dispose()
    }
}