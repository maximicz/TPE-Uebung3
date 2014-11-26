package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssociativeArrayTreeTest {


		

		@Test
		public void testArray() {

			
			AssociativeArrayTree<Object, Object> werte = new AssociativeArrayTree<Object, Object>();
			
			
			werte.put("zehn", 10);
			werte.put("zwanzig", 20);
			werte.put("dreizig", 30);
			werte.put("vierzig", 40);
			werte.put("fünfzig", 50);
			werte.put("sechzig", 60);
			werte.put("siebzig", 70);
			werte.put("achtzig", 80);
			werte.put("neunzig", 90);
			werte.put("hundert", 100);

			// Test Size()
			assertEquals(10, werte.size());

			// Test containsValue()
			assertEquals(true, werte.containsValue(80));
			assertEquals(false, werte.containsValue(99));
			assertEquals(true, werte.containsValue(20));
			assertEquals(false, werte.containsValue(88));

			// Test containsKey()
			assertEquals(true, werte.containsKey("zehn"));
			assertEquals(false, werte.containsKey("zwölf"));
			assertEquals(true, werte.containsKey("zwanzig"));
			assertEquals(false, werte.containsKey("fünfunddreisig"));

			// Test isEmpty()
			assertEquals(false, werte.isEmpty());

			AssociativeArrayTree<Object, Object> werte2 = new AssociativeArrayTree<>();
			
			
			werte2.put("acht", 8);
			werte2.put("vierzehn", 14);
			werte2.put("fünfhundert", 500);

			// Test putAll()
			werte.putAll(werte2);
			assertEquals(13, werte.size());

			// Test remove()
			werte.remove("hundert");
			assertNull(werte.get("hundert"));

		}
	}
