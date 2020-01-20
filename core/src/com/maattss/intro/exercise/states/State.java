package com.maattss.intro.exercise.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
    public GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
