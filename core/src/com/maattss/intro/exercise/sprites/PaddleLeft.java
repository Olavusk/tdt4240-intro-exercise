package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PaddleLeft {
    private Vector2 position;
    private Texture paddle;

    private Rectangle bounds;

    public PaddleLeft(int x, int y){
        position=new Vector2(x,y);
        paddle = new Texture("paddle.png");

        bounds = new Rectangle(position.x,position.y,paddle.getWidth(),paddle.getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt) {
        bounds.setPosition(position.x,position.y);

        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > 450) {
            position.y = 450;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += 20;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            position.y -= 20;
        }
    }

    public Vector2 getPosition() {
        return position;
    }
    public Texture getTexture() {
        return paddle;
    }
}
