package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.sprites.BackButton;
import com.maattss.intro.exercise.sprites.HelicopterAnimated;

public class Task3State extends State {
    private HelicopterAnimated heli1;
    private HelicopterAnimated heli2;
    private HelicopterAnimated heli3;
    private HelicopterAnimated heli4;
    private BackButton backBtn;


    public Task3State(GameStateManager gsm) {
        super(gsm);
        // 3 helicopters, each starting in their spot on the game screen
        heli1 = new HelicopterAnimated(IntroExercise.WIDTH / 2 + 300, IntroExercise.HEIGHT / 2);
        heli2 = new HelicopterAnimated(IntroExercise.WIDTH / 2,IntroExercise.HEIGHT / 2);
        heli3 = new HelicopterAnimated(IntroExercise.WIDTH / 2 - 300,IntroExercise.HEIGHT / 2);
        backBtn = new BackButton(false);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Rectangle touch = new Rectangle(Gdx.input.getX(),
                    IntroExercise.HEIGHT - Gdx.input.getY(),1,1);
            if(touch.overlaps(backBtn.getBounds())) { // User pushed back button
                gsm.set(new MenuState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        heli1.update(dt, heli2, heli3);
        heli2.update(dt, heli1, heli3);
        heli3.update(dt, heli1, heli2);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        Gdx.gl.glClearColor(1, 0, 0.996f, 1);
        sb.draw(heli1.getTexture(),heli1.getX(), heli1.getY());
        sb.draw(heli2.getTexture(),heli2.getX(), heli2.getY());
        sb.draw(heli3.getTexture(),heli3.getX(), heli3.getY());
        sb.draw(backBtn.getTexture(), backBtn.getX(), backBtn.getY());
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
