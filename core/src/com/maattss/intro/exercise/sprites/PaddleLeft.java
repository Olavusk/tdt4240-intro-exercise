package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;

public class PaddleLeft {
    private Vector2 position;
    private Texture paddle;
    private int speed;
    private boolean up;

    private Rectangle bounds;

    public PaddleLeft(int x, int y){
        position=new Vector2(x,y);
        speed = 20;
        paddle = new Texture("pong/paddle.png");
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

        if(Gdx.input.isTouched()){
            int mousePos = IntroExercise.HEIGHT - Gdx.input.getY();
            if(mousePos - speed > position.y) {
                position.y +=speed;
            } else if (mousePos + speed < position.y) {
                position.y -= speed;
            }
        }
    }

    public Vector2 getPosition() {
        return position;
    }
    public Texture getTexture() {
        return paddle;
    }
}
