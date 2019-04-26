package p014arcanoid;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PelotaTest {

	@Mock
	Graphics g;
	Pelota pelota = new Pelota(0, 0, 0, 0, null);

	@Test
	void testPelotaConstructor() {
		int posX = 100;
		int posY = 200;
		int anchura = 640;
		int altura = 480;
		Color color = Color.BLACK;
		Pelota pelota2 = new Pelota(posX, posY, anchura, altura, color);
		assertEquals(posX, pelota2.x);
		assertEquals(posY, pelota2.y);
		assertEquals(altura, pelota2.height);
		assertEquals(anchura, pelota2.width);
		assertEquals(color, pelota2.getColor());

	}

	@Test
	void testMover() {
		Pelota pelota2 = new Pelota(0, 0, 0, 0, Color.BLACK);
		pelota2.velX = 10;
		pelota2.velY = 20;
		pelota2.mover();
		assertEquals(10.0, pelota2.getX(), 0);
		assertEquals(20.0, pelota2.getY(), 0);
		assertEquals(10, pelota2.velX);
		assertEquals(20, pelota2.velY);

	}

	@Test
	void testMover2() {
		Pelota pelota2 = new Pelota(0, 0, 0, 0, Color.BLACK);
		int velX = GameConstants.SCREEN_LIMIT + 10;
		pelota2.velX = velX;
		pelota2.mover();
		assertEquals(-velX, pelota2.velX);

	}

	@Test
	void testDibujar() {
		pelota.dibujar(g);
		verify(g, times(1)).setColor(any());
		verify(g, times(1)).fillOval(anyInt(), anyInt(), anyInt(), anyInt());
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Antes del Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Despues del Test");
	}
}
