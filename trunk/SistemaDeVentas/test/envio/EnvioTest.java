package envio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnvioTest {

	private Envio env;
	private Envio env2; 
	@Before
	public void setUp() throws Exception {
		
		env = new Envio();
		env2 = new Envio();	
	}

	@Test 
	public void testEnviar(){
		
		
	}
	@Test
	public void testEquals(){
		
		assertTrue(env.equals(env));
		assertTrue(env.equals(env2));
		assertFalse(env.equals(null));
		assertFalse(env.equals(10d));
		
	}

}
