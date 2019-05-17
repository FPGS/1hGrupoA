package p014arcanoid;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.omg.CORBA.TypeCodePackage.BadKind;
import org.omg.CORBA.portable.InputStream;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

class MockitoExamenTest {
	@Mock
	AddressHelper helper;

	@Test
	void test() throws BadKind {
		MockitoExamen examen = new MockitoExamen();
		InputStream stream = Mockito.mock(InputStream.class);
		examen.mockitoEj1(helper, stream);
	}

}
