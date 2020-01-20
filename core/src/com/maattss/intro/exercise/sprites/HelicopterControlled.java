package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;

public class HelicopterControlled {
    private Texture heli;
    private Vector2 position;
    private Sprite heliSprite;
    private int movement;
    private boolean isFlipped;
    public enum MoveDirection {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public HelicopterControlled(int x, int y) {
        position = new Vector2(x,y);
        heli = new Texture("heli/heli.png");
        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);
        movement = 10;
        isFlipped=false;
    }

    public void update(MoveDirection moveDir) {
        if (moveDir == MoveDirection.RIGHT) {
            if(!(position.x > IntroExercise.WIDTH-heli.getWidth())) {
                position.x += movement;
                if(isFlipped) {
                    isFlipped = false;
                    heliSprite.flip(true, false);
                }
            }
        } else if (moveDir == MoveDirection.LEFT) {
            if(!(position.x <= 0)) {
                position.x -= movement;
                if(!isFlipped) {
                    isFlipped = true;
                    heliSprite.flip(true, false);
                }
            }
        } else if (moveDir == MoveDirection.DOWN) {
            if(!(position.y <= 0)) {
                position.y -= movement;
            }
        } else if (moveDir == MoveDirection.UP) {
            if(!(position.y > IntroExercise.HEIGHT - heli.getHeight())) {
                position.y += movement;
            }
        }
    }

    public Sprite getHelicopterSprite() {
        return heliSprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void dispose(){
        heli.dispose();
    }
}
