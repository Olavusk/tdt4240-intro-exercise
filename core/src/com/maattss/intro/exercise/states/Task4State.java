package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.sprites.BackButton;
import com.maattss.intro.exercise.sprites.Ball;
import com.maattss.intro.exercise.sprites.PaddleLeft;
import com.maattss.intro.exercise.sprites.PaddleRight;


public class Task4State extends State {
    private PaddleLeft paddleLeft;
    private PaddleRight paddleRight;
    private Ball ball;
    private BackButton backBtn;
    private int scoreLeft;
    private int scoreRight;
    private boolean winner;
    private BitmapFont font;

    public Task4State(GameStateManager gsm) {
        super(gsm);
        paddleLeft = new PaddleLeft(64,30);
        paddleRight = new PaddleRight(1700,30);
        ball = new Ball();
        font = new BitmapFont(Gdx.files.internal("fonts/krungthep.fnt"));
        backBtn = new BackButton(true);
        scoreRight = 0;
        scoreLeft = 0;
        winner = false;
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Rectangle touch = new Rectangle(Gdx.input.getX(),
                    IntroExercise.HEIGHT - Gdx.input.getY(), 1, 1);
            if (touch.overlaps(backBtn.getBounds())) { // User pushed back button
                gsm.set(new MenuState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        paddleLeft.update();
        paddleRight.update();
        ball.update(dt,this, paddleLeft, paddleRight);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        sb.draw(backBtn.getTexture(), backBtn.getX(), backBtn.getY());
        sb.draw(paddleRight.getTexture(),paddleRight.getPosition().x,paddleRight.getPosition().y);
        sb.draw(paddleLeft.getTexture(),paddleLeft.getPosition().x,paddleLeft.getPosition().y);
        sb.draw(ball.getTexture(),ball.getPosition().x,ball.getPosition().y,20,20);

        // Draw scoreboard
        font.getData().setScale(0.9f);
        font.setColor(Color.WHITE);
        font.draw(sb, scoreLeft + " : " + scoreRight,
                IntroExercise.WIDTH / 2 - 100,IntroExercise.HEIGHT - 50);
        sb.end();
    }

    public void incRightScore() {
        // TODO: Check winner
        scoreRight++;
    }
    public void incLeftScore() {
        // TODO: Check winner
        scoreLeft++;
    }

    @Override
    public void dispose() {

    }
}
