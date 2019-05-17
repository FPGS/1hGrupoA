package p014arcanoid;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		Arkanoid arkanoidMock = Mockito.mock(Arkanoid.class);
		doNothing().when(arkanoidMock).run();
		arkanoidMock.animacion = thread;
		arkanoidMock.start();
		verify(thread, times(1)).run();
	}

	@Test
	void testVidasOfInitMethod() {
		Arkanoid arkanoidMock = Mockito.mock(Arkanoid.class);
		Bloque[] vidas = new Bloque[20];
		arkanoidMock.setVidas(vidas);
		arkanoidMock.init();

		for (Bloque vida : arkanoidMock.getVidas()) {
			assertNotNull(vida);
		}
	}

	Arkanoid arkanoid;

	@BeforeEach
	void setUp() throws Exception {
		arkanoid = new Arkanoid();
	}


}
