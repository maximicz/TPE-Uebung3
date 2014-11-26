/*
 * 
 */
package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Hier stehen die Vorlagen zu den Methoden, die in den anderen Klassen genutzt
 * werden sollen. Es handelt sich hierbei um Interface-Methoden, welche leer
 * stehen. Das Ziel ist die Entwicklung eines typsicheren assoziativen Array.
 * 
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 *
 * @param <K>
 *            den Schlüssel des Knotens
 * @param <V>
 * 
 *            Der zugewiesene Wert des Schlüssels
 */

public interface AssociativeArray<K, V> {

	/**
	 * L�scht alle Elemente des assoziativen Arrays.
	 */

	public void clear();

	/**
	 * In dieser Methode wird überprüft, ob sich das gesuchte Element
	 * <code>K</code> mit dem Wert <code>V</code> im assoziativen Array
	 * befindet.
	 * 
	 * @param value
	 *            Wert, der im assoziativen Array vorhanden ist
	 * @return true or false
	 */

	public boolean containsValue(V value);

	/**
	 * Diese Methode überprüft, ob der Knoten eine eingegebene Schlüsselnummer
	 * <code>K</code> besitzt.
	 * 
	 * @param key
	 *            der gesuchte Schlüssel
	 * @return true or false
	 */

	public boolean containsKey(K key);

	/**
	 * Soll zu einem gegebenen Schlüssel <code>K</code> den dazugehörigen Wert
	 * <code>V</code> aus.
	 * 
	 * @param key
	 *            der gesuchte Schlüssel
	 * @return Der Wert des gesuchten Schlüssel
	 */

	public V get(K key);

	/**
	 * Diese simple Methode prüft, ob das assoziative Array leer ist.
	 * 
	 * @return null or assoziate array
	 */

	public boolean isEmpty();

	/**
	 * Mit dieser Methode kann ich einen neuen Knoten zum baum hinzufügen, der
	 * jeweils einen eigenen Wert zugewiesen bekommt.
	 * 
	 * @param key
	 *            neuer Schlüssel zum Einfügen
	 * @param value
	 *            Wert des neu hinzugefügten Schlüssel
	 */

	public void put(K key, V value);

	/**
	 * Mit dieser Methode kann man beliebig viele neue Knoten mit Werten dem
	 * aktuellen assoziativen Array zuordnen.
	 * 
	 * @param tree
	 *            AssociativeArray<K,V>
	 */

	public void putAll(AssociativeArrayTree<K, V> tree);

	/**
	 * Mit dieser Methode erfüllt man 2 verschiedene Funktionen. Zum einen wird
	 * der eingegebene Schlüssel aus dem baum gelöscht, sofern er darin
	 * enthalten ist. Dabei wird der Schlüssel des gelöschten Knoten ausgelesen.
	 * 
	 * @param key
	 *            der Schlüssel, den man im assoisiativen Array löschen will
	 * @return den Wert <code>V</code> des gelöschten Knoten
	 */

	public void remove(K key);

	/**
	 * Mit dieser Methode wird das komplette assoziative Array durchlaufen, und
	 * dabei die Anzahl der Schlüssel-Werz-Paare gezählt.
	 * 
	 * @return anzahl der Schlüssel im assoziativen Array
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
	 * Durchführung des übergebenen <code>BiConsumer</code> bei allen
	 * Schlüssel-Wert-Paaren des aktuellen assoziativen Arrays aus.
	 *
	 * @param lambda
	 *            Der übergebene BiConsumer
	 */

	public void forEach(BiConsumer<?, ?> lambda);

	/**
	 * Alle Werte, die dem aktuellen associativeArray angehören, werden dem
	 * neuen assoziativen Array übergeben.
	 *
	 * @param tree
	 *            übergebenes assoziatives Array.
	 */

	public void extractAll(AssociativeArrayTree<K, V> tree);

	/**
	 * Übergebung des  <code>BiFunction</code> bei allen
	 * Schlüssel-Wert-Paaren des aktuellen assoziativen Arrays aus, erzeugt
	 * damit ein neues assoziatives Array.
	 *
	 * @param lambda
	 *            Die übergebene BiFunction.
	 * @return Das neue assoziative Array.
	 */

	public AssociativeArrayTree<?, ?> map(BiFunction<?, ?, ?> lambda);
}
