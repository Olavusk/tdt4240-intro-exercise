package com.maattss.intro.exercise

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.maattss.intro.exercise.states.GameStateManager
import com.maattss.intro.exercise.states.MenuState

class IntroExercise : ApplicationAdapter() {
    private var gsm: GameStateManager? = null
    private var batch: SpriteBatch? = null
    override fun create() {
        WIDTH = Gdx.graphics.width
        HEIGHT = Gdx.graphics.height
        batch = SpriteBatch()
        gsm = GameStateManager()
        gsm!!.push(MenuState(gsm))
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm!!.update(Gdx.graphics.deltaTime)
        gsm!!.render(batch)
    }

    override fun dispose() {
        super.dispose()
    }

    companion object {
        @JvmField
        var WIDTH = 0
        @JvmField
        var HEIGHT = 0
    }
}