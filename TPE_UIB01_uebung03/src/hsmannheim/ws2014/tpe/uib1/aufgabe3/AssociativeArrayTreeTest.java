package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class AssociativeArrayTreeTest {


		int summe = 0;
		int counter = 0;
		int counter2 = 0;
		Integer[] iArr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		IntegerAssociativeArray<String> werte = new IntegerAssociativeArray<>();

		/*
		 * Test der Methoden des assoziativen Arrays
		 */

		@Test
		public void testArray() {

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

			IntegerAssociativeArray<String> werte2 = new IntegerAssociativeArray<>();

			werte2.put("acht", 8);
			werte2.put("vierzehn", 14);
			werte2.put("fünfhundert", 500);

			// Test putAll()
			werte.putAll(werte2);
			assertEquals(13, werte.size());

			// Test remove()
			werte.remove("fünfhundert");
			assertNull(werte.get("fünfhundert"));

		}
	}
