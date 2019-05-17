package p014arcanoid;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.TypeCodePackage.BadKind;
import org.omg.CORBA.portable.InputStream;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

class MockitoExamenTest {
	@Mock
	AddressHelper helper;

	@Mock
	private TypeCode typeCode;

	@Mock
	private TypeCode typeCode2;

	@Test
	void test() throws BadKind {
		MockitoExamen examen = new MockitoExamen();
		InputStream stream = Mockito.mock(InputStream.class);
		when(helper.type()).thenReturn(typeCode);
		when(typeCode.content_type()).thenReturn(typeCode2);
		when(typeCode.default_index()).thenReturn(0);

		examen.mockitoEj1(helper, stream);
	}


}
