package com.maattss.intro.exercise.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MoveButton {
    private Texture button;
    private Vector2 position;
    private Rectangle bounds;

    public MoveButton(int x, int y, String texturePath) {
        button = new Texture(texturePath);
        position = new Vector2(x,y);
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