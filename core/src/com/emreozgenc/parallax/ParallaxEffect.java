package com.emreozgenc.parallax;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ParallaxEffect {

    private static final float PARALLAX_SPEED = 50;
    private static final float PARALLAX_WIDTH = Gdx.graphics.getWidth();
    private static final float PARALLAX_HEIGHT = Gdx.graphics.getHeight();

    private SpriteBatch batch;
    private Texture[][] textures;
    private Vector2[][] positions;

    public ParallaxEffect() {
        batch = new SpriteBatch();
        textures = new Texture[4][2];
        positions = new Vector2[4][2];

        // initialize parallax textures
        textures[0][0] = new Texture(Gdx.files.internal("parallax_00.png"));
        textures[1][0] = new Texture(Gdx.files.internal("parallax_01.png"));
        textures[2][0] = new Texture(Gdx.files.internal("parallax_02.png"));
        textures[3][0] = new Texture(Gdx.files.internal("parallax_03.png"));

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 2; j++) {
                textures[i][j] = textures[i][0];
            }
        }

        for (int i = 0; i < 4; i++) {
            positions[i][0] = new Vector2(0, 0);
            positions[i][1] = new Vector2(PARALLAX_WIDTH, 0);
        }
    }

    public void update() {

        // control if texture out of bounds
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (positions[i][j].x <= -PARALLAX_WIDTH)
                    positions[i][j].x = PARALLAX_WIDTH;
            }
        }

        // update position of layers
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {

                positions[i][j].x -= PARALLAX_SPEED * (i+1) * Gdx.graphics.getDeltaTime();

            }
        }
    }

    public void render() {
        batch.begin();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                batch.draw(textures[i][j], positions[i][j].x, positions[i][j].y, PARALLAX_WIDTH + 5, PARALLAX_HEIGHT);
            }
        }
        batch.end();
    }

}
