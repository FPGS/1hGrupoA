package p014arcanoid;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PotenciaTest {

	Potencia potencia;

	@BeforeEach
	public void setup() {
		potencia = new Potencia();
	}

	@Test
	void testWithZero() {
		assertEquals("0", potencia.povOf2(0));
	}

//	@Test
//	void testWithMillion() {
//		assertEquals("0", potencia.povOf2(1000000));
//	}

	@Test
	void testWithTwo() {
		assertEquals("4", potencia.povOf2(2));
	}

	@Test
	void testWithFive() {
		assertEquals("32", potencia.povOf2(5));
	}

	@Test
	void testWithSix() {
		Potencia potencia = new Potencia();
		assertEquals("64", potencia.povOf2(6));
	}


}
