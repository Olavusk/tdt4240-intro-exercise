package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.states.Task4State;

public class Ball {
    private Texture ball;
    private Vector2 position;
    private boolean up;
    private boolean right;
    private int speed;
    private Rectangle bounds;

    public Ball() {
        position = new Vector2(IntroExercise.WIDTH / 2,IntroExercise.HEIGHT / 2);
        ball = new Texture("pong/ball.png");
        up = true;
        right = true;
        speed = 400;
        bounds = new Rectangle(position.x,position.y,20,20);
    }

    public void update(float dt, Task4State state, PaddleLeft pl, PaddleRight pr) {
        bounds.setPosition(position.x,position.y);

        if(bounds.overlaps(pl.getBounds()) || bounds.overlaps(pr.getBounds())){
            this.right=!this.right;
        }

        this.moveY(speed*dt);
        this.moveX(speed*dt, state);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void moveX(float speed, Task4State state) {

        if(right) {
            position.x += speed;
        } else {
            position.x -= speed;
        }

        if(position.x > IntroExercise.WIDTH - 100) {
            System.out.println("Ball pos: " + position.x + "," + position.y);
            System.out.println("Boundaries x: " + IntroExercise.HEIGHT + ", 0");
            position.x = IntroExercise.WIDTH / 2;
            position.y = IntroExercise.HEIGHT / 2;
            right=false;
            up=!up;
            state.incLeftScore();
        }
        if(position.x < 0) {
            System.out.println("Ball pos: " + position.x + "," + position.y);
            System.out.println("Boundaries x: " + IntroExercise.HEIGHT + ", 0");
            position.x = IntroExercise.WIDTH / 2;
            position.y = IntroExercise.HEIGHT / 2;
            right=true;
            up=!up;
            state.incRightScore();
        }

    }

    public void moveY(float speed) {
        if(up) {
            position.y += speed;
        } else {
            position.y -= speed;
        }

        if(up && (position.y > IntroExercise.HEIGHT)) up=false;
        if(!up && (position.y < 0)) up=true;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return ball;
    }
}