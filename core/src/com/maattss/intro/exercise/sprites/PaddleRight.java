package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;

public class PaddleRight {
    private Vector2 position;
    private Texture paddle;

    private Rectangle bounds;

    public PaddleRight(int x, int y){
        position=new Vector2(x,y);
        paddle = new Texture("paddle.png");
        bounds = new Rectangle(position.x, position.y, paddle.getWidth(), paddle.getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update() {
        bounds.setPosition(position.x, position.y);

        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > IntroExercise.HEIGHT - paddle.getHeight()) {
            position.y = IntroExercise.HEIGHT - paddle.getHeight();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) position.y += 20;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) position.y -= 20;
    }

    public Vector2 getPosition() { return position; }
    public Texture getTexture() { return paddle; }
}
