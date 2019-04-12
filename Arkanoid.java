package p014arcanoid;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.applet.*;

public class Arkanoid extends Applet implements Runnable{
	int numVidas = 5;
	int puntuacionMax;
	Bloque[] vidas = new Bloque[numVidas];
	int puntuacion = 0;
	Image imagen;
	Graphics noseve;
	Thread animacion;
	Bloque[][] bloques = new Bloque[10][5];
	Pelota pelota;
	Bloque raqueta;
	Color colores[] = {Color.blue, Color.orange, Color.green, Color.magenta, Color.red};
	int ratX, ratY;
	
	public void init() {
		setSize(300,300);
		imagen = this.createImage(300,300);  //es de la clase applet
		noseve = imagen.getGraphics();
		pelota = new Pelota(150, 190, 15, 15, Color.white);
		raqueta = new Bloque(ratX, 210, 50, 5, Color.white);
		for(int f = 0; f < bloques.length; f++ )
			for (int c = 0; c < bloques[f].length; c++)
				bloques[f][c] = new Bloque(f*30, c*12+10, 28, 10, colores[c]);
		for(int i = 0; i < vidas.length; i++ )
			vidas[i] = new Bloque(270+(4*i), 260, 2, 10, Color.red);
	}
	
	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 400, 400);
		pelota.dibujar(noseve);
		raqueta.dibujar(noseve);
		noseve.setColor(Color.WHITE);
		noseve.drawLine(0, 230, 300, 230);
		for(int f = 0; f < bloques.length; f++ )
			for (int c = 0; c < bloques[f].length; c++) {
				if(bloques[f][c].visible)
					bloques[f][c].dibujar(noseve);	
			}
		noseve.setColor(Color.red);
		for(int i = 0; i < vidas.length; i++ )
			if(vidas[i].visible)
				vidas[i].dibujar(noseve);
		noseve.drawString("Puntuacion: " + puntuacion, 10, 270);
		if(puntuacion == 6500) {
			noseve.setColor(Color.GREEN);
			if(puntuacion > puntuacionMax)
				puntuacionMax = puntuacion;
			noseve.drawString("ENHORABUENA CRRRRRRACK", 60, 100);
			pelota.color = Color.black;
		}
		noseve.drawString("Puntuación Máxima: " + puntuacionMax, 120, 270);
		if(numVidas == 0) {
			noseve.setColor(Color.red);
			noseve.drawString("GAME OVER! LOOSER", 80, 100);
			pelota.color = Color.black;
		}
		g.drawImage(imagen, 0, 0, this);
	}
	public void update(Graphics g) {	//El metodo update se ejecuta al llamar repaint y consiste en borrar y pintar, si lo sobreescribimos ya no borra
		paint(g);
	}
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}
	public void run() {
		do {
			pelota.mover();
			raqueta.x = ratX;
			for(int f = 0; f < bloques.length; f++ )
				for (int c = 0; c < bloques[f].length; c++) {
					if(bloques[f][c].contains(pelota.x, pelota.y) && bloques[f][c].visible == true && bloques[f][c].color == colores[4]) {
						pelota.velY = -pelota.velY;
						bloques[f][c].visible = false;
						puntuacion += 100;
					}
					if(bloques[f][c].contains(pelota.x, pelota.y) && bloques[f][c].visible == true && bloques[f][c].color == colores[3]) {
						pelota.velY = -pelota.velY;
						bloques[f][c].visible = false;
						puntuacion += 115;
					}
					if(bloques[f][c].contains(pelota.x, pelota.y) && bloques[f][c].visible == true && bloques[f][c].color == colores[2]) {
						pelota.velY = -pelota.velY;
						bloques[f][c].visible = false;
						puntuacion += 130;
					}
					if(bloques[f][c].contains(pelota.x, pelota.y) && bloques[f][c].visible == true && bloques[f][c].color == colores[1]) {
						pelota.velY = -pelota.velY;
						bloques[f][c].visible = false;
						puntuacion += 145;
					}
					if(bloques[f][c].contains(pelota.x, pelota.y) && bloques[f][c].visible == true && bloques[f][c].color == colores[0]) {
						pelota.velY = -pelota.velY;
						bloques[f][c].visible = false;
						puntuacion += 160;
					}
				}
			if(raqueta.intersects(pelota) && ratX+25 < pelota.x) {
				pelota.velY = -pelota.velY;
				pelota.velX = 2;
			}else if(raqueta.intersects(pelota) && ratX+25 == pelota.x) {
				pelota.velY = -pelota.velY;
				pelota.velX = 0;
			}
			else if(raqueta.intersects(pelota) && ratX+25 > pelota.x) {
				pelota.velY = -pelota.velY;
				pelota.velX = -2;
			}
			if(pelota.y > 300) {
				pelota.y = 195;
				pelota.x = 150;
				pelota.velX = 0;
				pelota.velY = 0;
				numVidas--;
				vidas[numVidas].visible = false;
			}if(numVidas == 0) {
				if(puntuacion > puntuacionMax)
					puntuacionMax = puntuacion;
				puntuacion = 0;
			}
			repaint();
				try {
					Thread.sleep(35);
				}catch(InterruptedException e){}
			
		}while(true);
	}
	
	public boolean mouseMove(Event e, int x, int y) {
		if(ratX<=290) {
			ratX = x-25;
			return true;
		}else 
			ratX = 289;
		return false;
	}
	
	public boolean mouseDown(Event e, int x, int y) {
		if(pelota.velX == 0 && pelota.velY == 0) {
			pelota.velX = 0;
			pelota.velY = -6;
		}
		if (numVidas == 0) {
			init();
			numVidas = 5;
		}
		if (puntuacion == 6500) {
			init();
			numVidas = 5;
		}
		return false;
	}
	
}