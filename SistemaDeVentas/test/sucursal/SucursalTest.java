package sucursal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cliente.Cliente;
import producto.Presentacion;
import venta.Venta;

import org.junit.Before;
import org.junit.Test;

public class SucursalTest {
	
	List<Presentacion> lp;
	Map<Cliente, List<Venta>> reg;
	Sucursal sucursalTest;
	Cliente cliente1 = mock(Cliente.class);
	Cliente cliente2 = mock(Cliente.class);
	Venta venta1 = mock(Venta.class);
	Venta venta2 = mock(Venta.class);
	Presentacion pre1 = mock(Presentacion.class);
	Presentacion pre2 = mock(Presentacion.class);
	
	@Before
	public void SetUp(){
		lp = new ArrayList<Presentacion>();
		sucursalTest= new Sucursal(lp, reg);
		reg = new HashMap<Cliente, List<Venta>>();
	}

	@Test
	public void 
	

}

