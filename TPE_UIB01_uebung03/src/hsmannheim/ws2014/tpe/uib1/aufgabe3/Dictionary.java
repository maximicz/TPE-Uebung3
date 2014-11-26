package hsmannheim.ws2014.tpe.uib1.aufgabe3;

public class Dictionary extends AssociativeArrayTree<String, String> {

	public Dictionary(String key, String value) {
		super(key, value);
		
	}

	/**
	 * keys() läuft das Dictionary in Preorder ab und speichert alle Schlüssel
	 * der Knoten in ein Array ab
	 * 
	 * @return String[]
	 */
	public String[] keys() {

	
		String keyArray[] = new String[size() - 1];

		keysRek(keyArray, this.root, 0);

		return keyArray;
	}

	private void keysRek(String[] keyArray, Node<String, String> node, int count) {

		if (node == null) {

		} else {
		
			keyArray[count] = node.getKey();

			
			keysRek(keyArray, node.getLeft(), count + 1);
			keysRek(keyArray, node.getRight(), count + 1);
		}
	}

	/**
	 * values() läuft das Dictionary in Preorder ab und speichert alle Werte der
	 * Knoten in ein Array ab
	 * 
	 * @return String[]
	 */
	public String[] values() {

	
		String valueArray[] = new String[size() - 1];

		valuesRek(valueArray, this.root, 0);

		return valueArray;
	}

	private void valuesRek(String[] valueArray, Node<String, String> node,
			int count) {

		if (node == null) {

		} else {
		
			valueArray[count] = node.getValue();

			
			valuesRek(valueArray, node.getLeft(), count + 1);
			valuesRek(valueArray, node.getRight(), count + 1);
		}
	}
	
}	

	