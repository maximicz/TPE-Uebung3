package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 *
 * Interface, dass ein generisches assoziatives Array beschreibt. Dabei wird
 * jedem Schl�ssel vom Datentyp <code>K</code> ein Wert des Datentyps <code>V
 * </code> zugeordnet.
 *
 * @author
 *
 *
 * @param <K>
 *            Datentyp des Schl�ssels (key), nach dem die Schl�ssel-Wert-Paare
 *            sortiert werden
 * @param <V>
 *            Datentyp des Wertes (value)
 */
public interface AssociativeArray<K, V> {
	
	/**
	 * L�scht alle Elemente des assoziativen Arrays
	 */
	
	public void clear();

	/**
	 * Gibt zur�ck, ob ein �bergebener Wert im Array gespeichert ist
	 *
	 * @param value
	 *            Der �bergebene Wert
	 * @return <code>true</code>, wenn <code>value</code> im Array enthalten
	 *         ist, <code>false</code>, wenn nicht
	 */
	
	public boolean containsValue(V value);

	/**
	 * Gibt zur�ck, ob ein �bergebener Schl�ssel im Array gespeichert ist
	 *
	 * @param key
	 *            Der �bergebene Schl�ssel
	 * @return <code>true</code>, wenn <code>key</code> im Array enthalten ist,
	 *         <code>false</code>, wenn nicht
	 */
	
	public boolean containsKey(K key);

	/**
	 * Gibt den passenden Wert <code>value</code> zum �bergebenen Schl�ssel
	 * <code>key</code>
	 *
	 * @param key
	 *            Der �bergebene Schl�ssel
	 * @return Der passende Wert
	 */
	
	public V get(K key);

	/**
	 * �berpr�ft ob das assoziative Array leer ist.
	 *
	 * @return <code>true</code> wenn das Array leer ist, <code>false</code>
	 *         wenn im Array Elemente enthalten sind.
	 */
	
	public boolean isEmpty();

	/**
	 * Speichert den �bergebenen Schl�ssel <code>key</code> und den Wert
	 * <code>value</code> im assoziativen Array
	 *
	 * @param key
	 *            Der �bergebene Schl�ssel
	 * @param value
	 *            Der �bergebene Wert
	 */
	
	public void put(K key, V value);

	
	public void putAll(AssociativeArray<K, V> other);

	/**
	 * Enfernt ein Schl�ssel-Wert-Paar aus dem momentanen assoziativen Array und
	 * gibt den Wert zur�ck.
	 *
	 * @param key
	 *            Der �bergebene Schl�ssel
	 * @return Der entsprechende Wert
	 */
	
	public V remove(K key);

	/**
	 * Gibt die Anzahl der Schl�ssel-Wert-Paare zur�ck.
	 *
	 * @return Anzahl der Paare
	 */
	
	public int size();

	/**
	 * Aktualisiert den Wert des gesuchten Schl�ssel-Wert-Paares mit dem neuen
	 * Wert.
	 *
	 * @param key
	 *            Schl�ssel, dessen Wert ge�ndert werden soll.
	 * @param value
	 *            der neue �bergebne Wert.
	 */
	
	public void update(K key, V value);

	/**
	 * F�hrt den �bergebenen <code>BiConsumer</code> bei allen
	 * Schl�ssel-Wert-Paaren des momentanen assoziativen Arrays aus.
	 *
	 * @param lambda
	 *            Der �bergebene BiConsumer.
	 */
	
	public void forEach(BiConsumer<K, V> lambda);

	/**
	 * f�gt alle Schl�ssel-Wert-Paare des momentanen associativen Arrays einem
	 * �bergebenen associativen Arrays hinzu.
	 *
	 * @param other
	 *            �bergebenes assoziatives Array.
	 */
	
	public void extractAll(AssociativeArray<K, V> other);

	/**
	 * F�hrt die �bergebene <code>BiFunction</code> bei allen
	 * Schl�ssel-Wert-Paaren des momentanen assoziativen Arrays aus, erzeugt
	 * damit ein neues assoziatives Array.
	 *
	 * @param lambda
	 *            Die �bergebene BiFunction.
	 * @return Das neue assoziative Array.
	 */
	
	public AssociativeArray<K, V> map(BiFunction lambda);
}