package ansatz;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 *
 * Interface, dass ein generisches assoziatives Array beschreibt. Dabei wird
 * jedem Schlüssel vom Datentyp <code>K</code> ein Wert des Datentyps <code>V
 * </code> zugeordnet.
 *
 * @author
 *
 *
 * @param <K>
 *            Datentyp des Schlüssels (key), nach dem die Schlüssel-Wert-Paare
 *            sortiert werden
 * @param <V>
 *            Datentyp des Wertes (value)
 */
public interface AssociativeArray<K, V> {
	
	/**
	 * Löscht alle Elemente des assoziativen Arrays
	 */
	
	public void clear();

	/**
	 * Gibt zurück, ob ein übergebener Wert im Array gespeichert ist
	 *
	 * @param value
	 *            Der übergebene Wert
	 * @return <code>true</code>, wenn <code>value</code> im Array enthalten
	 *         ist, <code>false</code>, wenn nicht
	 */
	
	public boolean containsValue(V value);

	/**
	 * Gibt zurück, ob ein übergebener Schlüssel im Array gespeichert ist
	 *
	 * @param key
	 *            Der übergebene Schlüssel
	 * @return <code>true</code>, wenn <code>key</code> im Array enthalten ist,
	 *         <code>false</code>, wenn nicht
	 */
	
	public boolean containsKey(K key);

	/**
	 * Gibt den passenden Wert <code>value</code> zum übergebenen Schlüssel
	 * <code>key</code>
	 *
	 * @param key
	 *            Der übergebene Schlüssel
	 * @return Der passende Wert
	 */
	
	public V get(K key);

	/**
	 * Überprüft ob das assoziative Array leer ist.
	 *
	 * @return <code>true</code> wenn das Array leer ist, <code>false</code>
	 *         wenn im Array Elemente enthalten sind.
	 */
	
	public boolean isEmpty();

	/**
	 * Speichert den übergebenen Schlüssel <code>key</code> und den Wert
	 * <code>value</code> im assoziativen Array
	 *
	 * @param key
	 *            Der übergebene Schlüssel
	 * @param value
	 *            Der übergebene Wert
	 */
	
	public void put(K key, V value);

	/**
	 * Fügt das übergebene assoziative Array dem aktuellen assoziativen Array
	 * hinzu
	 *
	 * @param other
	 *            Das übergebene AssociativeArray
	 */
	
	public void putAll(AssociativeArray<K, V> other);

	/**
	 * Enfernt ein Schlüssel-Wert-Paar aus dem momentanen assoziativen Array und
	 * gibt den Wert zurück.
	 *
	 * @param key
	 *            Der übergebene Schlüssel
	 * @return Der entsprechende Wert
	 */
	
	public V remove(K key);

	/**
	 * Gibt die Anzahl der Schlüssel-Wert-Paare zurück.
	 *
	 * @return Anzahl der Paare
	 */
	
	public int size();

	/**
	 * Aktualisiert den Wert des gesuchten Schlüssel-Wert-Paares mit dem neuen
	 * Wert.
	 *
	 * @param key
	 *            Schlüssel, dessen Wert geändert werden soll.
	 * @param value
	 *            der neue übergebne Wert.
	 */
	
	public void update(K key, V value);

	/**
	 * Führt den übergebenen <code>BiConsumer</code> bei allen
	 * Schlüssel-Wert-Paaren des momentanen assoziativen Arrays aus.
	 *
	 * @param lambda
	 *            Der übergebene BiConsumer.
	 */
	
	public void forEach(BiConsumer<K, V> lambda);

	/**
	 * fügt alle Schlüssel-Wert-Paare des momentanen associativen Arrays einem
	 * übergebenen associativen Arrays hinzu.
	 *
	 * @param other
	 *            übergebenes assoziatives Array.
	 */
	
	public void extractAll(AssociativeArray<K, V> other);

	/**
	 * Führt die übergebene <code>BiFunction</code> bei allen
	 * Schlüssel-Wert-Paaren des momentanen assoziativen Arrays aus, erzeugt
	 * damit ein neues assoziatives Array.
	 *
	 * @param lambda
	 *            Die übergebene BiFunction.
	 * @return Das neue assoziative Array.
	 */
	
	public AssociativeArray<K, V> map(BiFunction lambda);
}