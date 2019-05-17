package p014arcanoid;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.Graphics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ArkanoidTest {

	@Test
	void testBloquesOfInitMethod() {
		Arkanoid arkanoidMock = Mockito.mock(Arkanoid.class);
		Bloque[][] bloques = new Bloque[20][15];
		arkanoidMock.bloques = bloques;
		arkanoidMock.init();

		for (Bloque[] bloque : arkanoidMock.bloques) {
			assertNotNull(bloque);
		}
	}
	@Test
	void testStart() {
		Thread thread = Mockito.mock(Thread.class);
		Arkanoid arkanoidMock = Mockito.spy(Arkanoid.class);
		doNothing().when(arkanoidMock).run();
		arkanoidMock.animacion = thread;
		arkanoidMock.start();
		verify(thread, times(1)).run();
	}

	@Test
	void testUpdate2() {
		Graphics g= Mockito.mock(Graphics.class);
		arkanoid.update2(g);
	}

	@Test
	void testVidasOfInitMethod() {
		Arkanoid arkanoidMock = Mockito.mock(Arkanoid.class);
		Bloque[] vidas = new Bloque[20];
		arkanoidMock.vidas = vidas;
		arkanoidMock.init();

		for (Bloque vida : arkanoidMock.vidas) {
			assertNotNull(vida);
		}
	}

	Arkanoid arkanoid;

	@BeforeEach
	void setUp() throws Exception {
		arkanoid = new Arkanoid();
	}


}
