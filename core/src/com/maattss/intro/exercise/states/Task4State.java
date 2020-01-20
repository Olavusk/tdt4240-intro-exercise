package com.maattss.intro.exercise.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.maattss.intro.exercise.sprites.Ball;
import com.maattss.intro.exercise.sprites.PaddleLeft;
import com.maattss.intro.exercise.sprites.PaddleRight;


public class Task4State extends State {
    private PaddleLeft paddleLeft;
    private PaddleRight paddleRight;
    private Ball ball;
    private Texture bg;

    private Vector2 score;
    private BitmapFont font;


    public Task4State(GameStateManager gsm) {
        super(gsm);
        paddleLeft = new PaddleLeft(30,30);
        paddleRight = new PaddleRight(540,30);
        ball = new Ball(300,150);
        bg = new Texture("pongbg.png");
        font = new BitmapFont();
        score = new Vector2(0,0);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.X)) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        paddleRight.update(dt);
        paddleLeft.update(dt);
        ball.update(dt,this, paddleLeft, paddleRight);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0);
        sb.draw(paddleRight.getTexture(),paddleRight.getPosition().x,paddleRight.getPosition().y);
        sb.draw(paddleLeft.getTexture(),paddleLeft.getPosition().x,paddleLeft.getPosition().y);
        sb.draw(ball.getTexture(),ball.getPosition().x,ball.getPosition().y,20,20);
        font.draw(sb,"LEFT: " + ((int)this.score.x) + " RIGHT: " + ((int)this.score.y)+"\nPress x to go back to menu",230,640);
        sb.end();
    }

    public void setScore(Vector2 score){
        this.score=score;
    }

    public void incRightScore() {
        this.score.y ++;
    }
    public void incLeftScore() {
        this.score.x ++;
    }

    @Override
    public void dispose() {

    }
}
