package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.maattss.intro.exercise.IntroExercise;
import com.maattss.intro.exercise.sprites.BackButton;
import com.maattss.intro.exercise.sprites.Ball;
import com.maattss.intro.exercise.sprites.LeftPaddle;
import com.maattss.intro.exercise.sprites.RightPaddle;


public class Task4State extends State {
    private LeftPaddle paddleLeft;
    private RightPaddle paddleRight;
    private Ball ball;
    private BackButton backBtn;
    private int scoreLeft;
    private int scoreRight;
    private String winnerStr;
    private BitmapFont font;

    public Task4State(GameStateManager gsm) {
        super(gsm);
        paddleLeft = new LeftPaddle(100,30);
        paddleRight = new RightPaddle(1700,30);
        ball = new Ball();
        font = new BitmapFont(Gdx.files.internal("fonts/krungthep.fnt"));
        backBtn = new BackButton(true);
        scoreRight = 0;
        scoreLeft = 0;
        winnerStr = "";
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
        if (winnerStr != "") {
            // Draw scoreboard
            font.getData().setScale(0.9f);
            font.setColor(Color.WHITE);
            font.draw(sb,  winnerStr,
                    300,IntroExercise.HEIGHT / 2 + 100);
        } else {
            // Update paddle position
            sb.draw(paddleRight.getTexture(),paddleRight.getPosition().x,paddleRight.getPosition().y);
            sb.draw(paddleLeft.getTexture(),paddleLeft.getPosition().x,paddleLeft.getPosition().y);
            sb.draw(ball.getTexture(),ball.getPosition().x,ball.getPosition().y,20,20);

            // Draw scoreboard
            font.getData().setScale(0.9f);
            font.setColor(Color.WHITE);
            font.draw(sb, scoreLeft + " : " + scoreRight,
                    IntroExercise.WIDTH / 2 - 100,IntroExercise.HEIGHT - 50);
        }

        sb.end();
    }

    public void incRightScore() {
        scoreRight++;
        if(scoreRight >= 21) {
            winnerStr = "Right player won!";
        }
    }

    public void incLeftScore() {
        scoreLeft++;
        if(scoreLeft >= 21) {
            winnerStr = "Left player won!";
        }
    }

    @Override
    public void dispose() {

    }
}
