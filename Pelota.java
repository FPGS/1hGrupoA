package p014arcanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Bloque{
	Color color;
	int velX, velY;
	int limiteDe;
	
	public Pelota(int posX, int posY, int anchura, int altura, Color color) {
		super(posX, posY, anchura, altura, color);
		this.color = color;
	}
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	 public void mover() {
		 x += velX;
		 y += velY;
		 limiteDe = 290;
		 if(x > limiteDe)
			velX = -velX;
		if(x < 0)
			velX = -velX;
		if(y < 0)
			velY = -velY;
		
		
	 }
}
