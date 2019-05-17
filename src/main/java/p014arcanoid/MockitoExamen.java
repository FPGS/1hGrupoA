package p014arcanoid;

import java.io.InputStream;

import org.omg.CORBA.TypeCodePackage.BadKind;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class MockitoExamen {

	public void mockitoEj1(AddressHelper helper, InputStream stream) throws BadKind {
		
		helper.read((org.omg.CORBA.portable.InputStream) stream);
		if(helper.type().content_type().default_index()==0) {
			return;
		}else {
			throw new RuntimeException();
		}
		
		
	}

}
