package at.hofer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Sinus 
{

	private int i;
	private double sin;
	private double pixel;
	private boolean keyPressed = false;
	private boolean secKeyPressed = false;
	private boolean bottom = false;
	private double curPixel;
	private double lastPixel;
	private double perPixel;
	
	public Sinus(int i)
	{
		this.i = i;
	}
	
	public void keyIsPressed()
	{
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
		{
			curPixel = Math.sin(Math.toRadians(i+2)) * 400;
			System.out.println(curPixel);
			
			if(sin > Math.sin(Math.toRadians(i+2)))
			{
				if(keyPressed == true)
					secKeyPressed = true;
				
				System.out.println("Key Pressed");
				keyPressed = true;
			}
		}
		perPixel = curPixel / (400 + lastPixel);
		System.out.println("Prozent:" + perPixel);
		lastPixel = curPixel;
	}
	
	public void sinusberechnung()
	{
		if(keyPressed == true && bottom == true)
		{
			sin = Math.sin(Math.toRadians(i));
			
			i+=2;
			
			if(i == 180)
			{
				i = 2;
				keyPressed = false;
				bottom = false;
			}
				
			
//			pixel = sin * (400+curPixel);
			pixel = sin * 600 * perPixel;
		}
		
		else if(secKeyPressed)
		{
			sin = Math.sin(Math.toRadians(i));
			
			i+=2;
			
			if(i == 180)
			{
				i = 2;
				secKeyPressed = false;
			}
				
			
//			pixel = sin * (400+curPixel);
			pixel = sin * 600 * perPixel;
		}
		
		else
		{
			sin = Math.sin(Math.toRadians(i));
			
			
			i+=2;
			
			
			if(i == 180)
			{
				i = 2;
			}	
			
			pixel = sin * 400;
		}
		
		if(i == 2 && keyPressed == true)
			bottom = true;
	}
	
	
	
	public int getPixel()
	{
		return (int)pixel;
	}
}
