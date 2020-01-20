package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.sprites.BackButton;
import com.maattss.intro.exercise.sprites.Helicopter;

public class Task1State extends State {
    private Helicopter heli;
    private BackButton backBtn;

    public Task1State(GameStateManager gsm) {
        super(gsm);
        heli = new Helicopter(0, 0);
        backBtn = new BackButton();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            Rectangle touch = new Rectangle(Gdx.input.getX(), IntroExercise.HEIGHT - Gdx.input.getY(),1,1);
            if(touch.overlaps(backBtn.getBounds())) { // User pushed back button
                gsm.set(new MenuState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        Gdx.gl.glClearColor(1, 0, 0.996f, 1);
        sb.draw(backBtn.getTexture(), backBtn.getX(), backBtn.getY());
        sb.draw(heli.getHelicopterSprite(),heli.getPosition().x, heli.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        heli.dispose();
    }
}
