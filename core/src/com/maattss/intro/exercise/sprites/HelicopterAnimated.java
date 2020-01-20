package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;
import java.util.Random;

public class HelicopterAnimated {
    private Animation heliAnimation;
    private Rectangle bounds;
    private Vector2 position;
    private Random rand;
    private boolean up;
    private boolean right;
    private int speed;
    private float heliWidth;
    private float heliHeight;

    public HelicopterAnimated(int x, int y) {
        Texture texture = new Texture("helianimation.png");
        heliAnimation = new Animation(new TextureRegion(texture), 4, 0.1f);
        position = new Vector2(x,y);
        rand = new Random();

        Texture heli = new Texture("heli.png");
        heliHeight = heli.getHeight();
        heliWidth = heli.getWidth();
        heli.dispose();

        // Assign random speed and direction to heli
        speed = 40*rand.nextInt(20) + 1;
        up= rand.nextBoolean();
        right= rand.nextBoolean();
        bounds = new Rectangle(position.x,position.y,heli.getWidth(),heli.getHeight());
    }

    public void update(float dt, HelicopterAnimated h2, HelicopterAnimated h3) {
        heliAnimation.update(dt);
        bounds.setPosition(position.x, position.y);

        if(this.getBounds().overlaps(h2.getBounds()) || this.getBounds().overlaps(h3.getBounds())){
            this.up=!this.up;
            this.right=!this.right;
        }

        this.moveX(speed*dt);
        this.moveY(speed*dt);
    }

    public void moveX(float speed) {
        if(right) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }

        if(right && (position.x > IntroExercise.WIDTH - heliWidth)) right=false;
        if(!right && (position.x < 0)) right = true;
    }

    public void moveY(float speed) {
        if(up) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(up && (position.y > IntroExercise.HEIGHT - heliHeight)) up=false;
        if(!up && (position.y < 0)) up=true;
    }
    public float getX() { return position.x; }
    public float getY() { return position.y; }
    public TextureRegion getTexture() {
        return heliAnimation.getFrame();
    }
    public Rectangle getBounds() {
        return bounds;
    }
}