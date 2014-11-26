/*
 * 
 */
package hsmannheim.ws2014.tpe.uib1.aufgabe3;

/**
 * Diese Klasse wird wie ein Wörterbuch behandelt, ind er Strings abgebildet
 * werden.
 */

public class Dictionary extends AssociativeArrayTree<String, String> {

	/**
	 * In diesem konstruktor wird ein Wörterbuch erzeugt, in der Strings
	 * abgebildet werden..
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */

	public Dictionary(String key, String value) {
		super(key, value);

	}

	/**
	 * keys() läuft das Dictionary in Preorder ab und speichert alle Schlüssel
	 * der Knoten in ein Array ab.
	 *
	 * @return String[]
	 */

	public String[] keys() {

		String keyArray[] = new String[size() - 1];

		keys(keyArray, this.root, 0);

		return keyArray;
	}

	/**
	 * Keys rek.
	 *
	 * @param keyArray
	 *            the key array
	 * @param node
	 *            the node
	 * @param count
	 *            the count
	 */

	private void keys(String[] keyArray, Node<String, String> node, int count) {

		if (node == null) {

		} else {

			keyArray[count] = node.getKey();

			keys(keyArray, node.getLeft(), count + 1);
			keys(keyArray, node.getRight(), count + 1);
		}
	}

	/**
	 * values() läuft das Dictionary in Preorder ab und speichert alle Werte der
	 * Knoten in ein Array ab.
	 *
	 * @return String[]
	 */

	public String[] values() {

		String valueArray[] = new String[size() - 1];

		values(valueArray, this.root, 0);

		return valueArray;
	}

	/**
	 * Values rek.
	 *
	 * @param valueArray
	 *            the value array
	 * @param node
	 *            the node
	 * @param count
	 *            the count
	 */

	private void values(String[] valueArray, Node<String, String> node,
			int count) {

		if (node == null) {

		} else {

			valueArray[count] = node.getValue();

			values(valueArray, node.getLeft(), count + 1);
			values(valueArray, node.getRight(), count + 1);
		}
	}

}
