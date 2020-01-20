package com.maattss.intro.exercise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maattss.intro.exercise.states.GameStateManager;
import com.maattss.intro.exercise.states.MenuState;

public class IntroExercise extends ApplicationAdapter {
    public static int WIDTH;
    public static int HEIGHT;
    private GameStateManager gsm;
    private SpriteBatch batch;


	@Override
	public void create () {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}

    @Override
    public void dispose() {
        super.dispose();
    }

}
