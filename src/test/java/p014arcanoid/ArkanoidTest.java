package p014arcanoid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;

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
//	@Test
//	void testStart() {
//		Thread thread = Mockito.mock(Thread.class);
//		Arkanoid arkanoidMock = Mockito.spy(Arkanoid.class);
//		doNothing().when(arkanoidMock).run();
//		arkanoidMock.animacion = thread;
//		arkanoidMock.start();
//		verify(thread, times(1)).run();
//	}
	
	@Test
	void testUpdate2() {
		Graphics g= Mockito.mock(Graphics.class);
		when(g.getClipBounds()).thenReturn(new Rectangle(0, 0));
		assertFalse(arkanoid.update2(g));

	}

	@Test
	void testReadFile() {
			File f = Mockito.mock(File.class);
		when(f.canRead()).thenReturn(false);
		assertEquals(3000, arkanoid.readFile(f));

		when(f.canRead()).thenReturn(true);
		assertNotEquals(3000, arkanoid.readFile(f));

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
