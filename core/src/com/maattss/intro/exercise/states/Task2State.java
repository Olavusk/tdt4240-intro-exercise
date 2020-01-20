package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.sprites.BackButton;
import com.maattss.intro.exercise.sprites.HelicopterControlled;
import com.maattss.intro.exercise.sprites.MoveButton;

public class Task2State extends State {

    private HelicopterControlled heli;
    private BitmapFont font;
    private BackButton backBtn;
    private MoveButton moveLeft;
    private MoveButton moveRight;
    private MoveButton moveUp;
    private MoveButton moveDown;

    public Task2State(GameStateManager gsm) {
        super(gsm);
        heli = new HelicopterControlled(0, 0);
        font = new BitmapFont(Gdx.files.internal("fonts/arial.fnt"));
        backBtn = new BackButton(false);
        moveLeft = new MoveButton(IntroExercise.WIDTH - 450, 50, "controls/left.png");
        moveRight = new MoveButton(IntroExercise.WIDTH - 150, 50, "controls/right.png");
        moveDown = new MoveButton(IntroExercise.WIDTH - 300, 50, "controls/down.png");
        moveUp = new MoveButton(IntroExercise.WIDTH - 300, 200, "controls/up.png");
    }

    @Override
    protected void handleInput() {
        // Input from onscreen controls
        if(Gdx.input.justTouched()){
            Rectangle touch = new Rectangle(Gdx.input.getX(),
                    IntroExercise.HEIGHT - Gdx.input.getY(),1,1);
            if(touch.overlaps(backBtn.getBounds())) { // User pushed back button
                gsm.set(new MenuState(gsm));
            }
            if (touch.overlaps(moveLeft.getBounds())) {
                heli.update(HelicopterControlled.MoveDirection.LEFT);
            }
            if (touch.overlaps(moveRight.getBounds())) {
                heli.update(HelicopterControlled.MoveDirection.RIGHT);
            }
            if (touch.overlaps(moveUp.getBounds())) {
                heli.update(HelicopterControlled.MoveDirection.UP);
            }
            if (touch.overlaps(moveDown.getBounds())) {
                heli.update(HelicopterControlled.MoveDirection.DOWN);
            }
        }

        // Input from keyboard
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            heli.update(HelicopterControlled.MoveDirection.LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            heli.update(HelicopterControlled.MoveDirection.RIGHT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            heli.update(HelicopterControlled.MoveDirection.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            heli.update(HelicopterControlled.MoveDirection.DOWN);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        Gdx.gl.glClearColor(1, 0, 0.996f, 1);
        sb.draw(heli.getHelicopterSprite(),heli.getPosition().x, heli.getPosition().y);

        // Sprite position
        font.getData().setScale(0.3f);
        sb.draw(backBtn.getTexture(), backBtn.getX(), backBtn.getY());
        font.draw(sb,"[" + heli.getPosition().x + "," + heli.getPosition().y +
                "]\n",150,IntroExercise.HEIGHT - 50);

        // Control buttons
        sb.draw(moveLeft.getTexture(), moveLeft.getX(), moveLeft.getY());
        sb.draw(moveRight.getTexture(), moveRight.getX(), moveRight.getY());
        sb.draw(moveUp.getTexture(), moveUp.getX(), moveUp.getY());
        sb.draw(moveDown.getTexture(), moveDown.getX(), moveDown.getY());

        sb.end();
    }

    @Override
    public void dispose() {
        heli.dispose();
    }
}
