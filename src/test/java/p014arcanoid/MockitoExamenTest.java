package p014arcanoid;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.TypeCodePackage.BadKind;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

class MockitoExamenTest {


	@Test
	void test() throws BadKind {
		MockitoExamen examen = new MockitoExamen();
		InputStream stream = null;
		AddressHelper helper = null;
		examen.mockitoEj1(helper, stream);
	}

}
