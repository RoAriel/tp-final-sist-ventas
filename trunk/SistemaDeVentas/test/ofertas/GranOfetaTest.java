package ofertas;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GranOfetaTest {
	GranOferta oferta;
	Double porcentajeDescuento;
	Oferta o1;
	Oferta o2;
	Oferta o3;
	
	@Before
	public void setUp() throws Exception {
		oferta = new GranOferta(this.inicializarListaOfertas(), 50d);
	}

	private List<Oferta> inicializarListaOfertas(){
		o1 = mock(Oferta.class);
		o2 = mock(Oferta.class);
		o3 = mock(Oferta.class);
		when(o1.precioNormal()).thenReturn(100d);
		when(o1.precioOferta()).thenReturn(100d);
		when(o2.precioNormal()).thenReturn(200d);
		when(o2.precioOferta()).thenReturn(150d);
		when(o3.precioNormal()).thenReturn(300d);
		when(o3.precioOferta()).thenReturn(150d);
		
		List<Oferta> ret = new ArrayList<Oferta>();
		ret.add(o1);
		ret.add(o2);
		ret.add(o3);
		
		return ret;
	}
	
	@Test
	public void precioNormal() {
		assertEquals((Double)600d,oferta.precioNormal());
	}
	
	@Test
	public void precioOferta(){
		assertEquals((Double)200d,oferta.precioOferta());
	}

}
