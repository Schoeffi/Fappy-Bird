package at.hofer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	private int i = 2;
	private int pixel;
	private Sinus sin = new Sinus(i);
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		sin.keyIsPressed();
		sin.sinusberechnung();
		
		pixel = sin.getPixel();
		//System.out.println(pixel);
		
		batch.draw(img, 0, (float)pixel);
		
		
		
		
		batch.end();
	}
}
