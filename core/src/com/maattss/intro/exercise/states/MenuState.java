package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.sprites.MenuButton;
import com.maattss.intro.exercise.IntroExercise;

public class MenuState extends State{
    private MenuButton taskOne;
    private MenuButton taskTwo;
    private MenuButton taskThree;
    private MenuButton taskFour;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        taskOne = new MenuButton(350, IntroExercise.HEIGHT / 2 - 128, "menu/one.png");
        taskTwo = new MenuButton(650, IntroExercise.HEIGHT / 2 - 128,"menu/two.png");
        taskThree = new MenuButton(950, IntroExercise.HEIGHT / 2 - 128,"menu/three.png");
        taskFour = new MenuButton(1250, IntroExercise.HEIGHT  / 2 - 128,"menu/four.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            // Decide which exercise user has selected
            Rectangle touch = new Rectangle(Gdx.input.getX(), Gdx.input.getY(),1,1);
            if(touch.overlaps(taskOne.getBounds())) {
                gsm.set(new Task1State(gsm));
            } else if(touch.overlaps(taskTwo.getBounds())) {
                gsm.set(new Task2State(gsm));
            } else if(touch.overlaps(taskThree.getBounds())) {
                gsm.set(new Task3State(gsm));
            } else if(touch.overlaps(taskFour.getBounds())) {
                gsm.set(new Task4State(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        Gdx.gl.glClearColor(0.871f, 0.945f, 1, 1);

        // Draw exercise pick menu
        sb.draw(taskOne.getTexture(),  taskOne.getX() , IntroExercise.HEIGHT - taskOne.getY());
        sb.draw(taskTwo.getTexture(),  taskTwo.getX() , IntroExercise.HEIGHT - taskTwo.getY());
        sb.draw(taskThree.getTexture(),  taskThree.getX() , IntroExercise.HEIGHT - taskThree.getY());
        sb.draw(taskFour.getTexture(),  taskFour.getX() , IntroExercise.HEIGHT - taskFour.getY());
        sb.end();
    }

    @Override
    public void dispose() {
        taskOne.dispose();
        taskTwo.dispose();
        taskThree.dispose();
        taskFour.dispose();
    }
}
