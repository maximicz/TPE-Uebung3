/*
 * 
 */
package hsmannheim.ws2014.tpe.uib1.aufgabe3;


/**
 * The Class StringAssociativeArray.
 *
 * @param <V> the value type
 */
public class StringAssociativeArray<V> extends AssociativeArrayTree<String, V> {

	/**
	 * Initialisiert ein neues string associative array.
	 *
	 * @param key der Schlüssel
	 * @param value der Wert
	 */
	public StringAssociativeArray(String key, V value) {
		super(key, value);
	}

}
