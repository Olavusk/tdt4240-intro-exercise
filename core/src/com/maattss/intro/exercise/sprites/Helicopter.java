package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;

public class Helicopter {
    private Texture heli;
    private Vector2 position;
    private Sprite heliSprite;
    private boolean up;
    private boolean right;
    private int speed;

    public Helicopter(int x, int y) {
        position = new Vector2(x,y);
        heli = new Texture("heli.png");
        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);
        up = true;
        right = true;
        speed = 300;
    }

    public void update(float dt) {
        this.moveX(speed*dt);
        this.moveY(speed*dt);
    }


    public void moveX(float movement) {
        if(right) {
            position.x += movement;
        }
        else {
            position.x -= movement;
        }


        if(right && (position.x > IntroExercise.WIDTH-heli.getWidth())) {
            right=false;
            heliSprite.flip(true, false);
        }

        if(!right && (position.x < 0)) {
            right = true;
            heliSprite.flip(true, false);
        }
    }

    public void moveY(float movement) {
        if(up) {
            position.y += movement;
        }
        else {
            position.y -= movement;
        }

        if(up && (position.y > IntroExercise.HEIGHT-heli.getHeight())) up=false;
        if(!up && (position.y < 0)) up=true;
    }

    public Sprite getHelicopterSprite() { return heliSprite; }
    public Vector2 getPosition() { return position; }
    public void dispose(){ heli.dispose(); }
}
