/*
 * 
 */
package hsmannheim.ws2014.tpe.uib1.aufgabe3;

/**
 * The Class IntegerAssociativeArray.
 *
 * @param <K>
 *            the key type
 */
public class IntegerAssociativeArray<K> extends
		AssociativeArrayTree<K, Integer> {

	/**
	 * Initialisiert ein neues integer associative array.
	 *
	 * @param key
	 *            der Schlüssel
	 * @param value
	 *            der Wert
	 */
	public IntegerAssociativeArray(K key, Integer value) {
		super(key, value);
	}

}
