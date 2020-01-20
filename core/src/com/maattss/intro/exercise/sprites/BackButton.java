package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.IntroExercise;

public class BackButton {
    private Texture button;
    private Vector2 position;
    private Rectangle bounds;

    public BackButton() {
        button = new Texture("back.png");
        position = new Vector2(50, IntroExercise.HEIGHT - 100);
        bounds = new Rectangle(position.x, position.y,100,100);
    }

    public Rectangle getBounds() { return bounds; }

    public float getX() { return position.x; }

    public float getY() { return position.y; }

    public Texture getTexture() {
        return button;
    }

    public void dispose() { button.dispose(); }
}