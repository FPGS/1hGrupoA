package p014arcanoid;

import java.awt.*;
import java.util.Random;

public class Bloque extends Rectangle{
	Color color;
	boolean visible;
	
	public Bloque(int posX, int posY, int anchura, int altura, Color color) {
		super(posX, posY, anchura, altura);
		this.color = color;
		visible = true;
	}
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
}