/*
 * 
 */
package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.function.*;

/**
 * Die Klasse AssociativeArrayTree, welches die Interfacemethoden aus der
 * Interfaceklasse implementiert, bietet Funktionen an, um ein assoziatives
 * Array zu erzeugen. Diewe wird in einer binären baum-Datenstruktur
 * festgehalten.
 * 
 *
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 */

public class AssociativeArrayTree<K, V> implements AssociativeArray<K, V> {

	/**
	 * Ein multiples generisches Attribut, welches die Wurzel des Baumes
	 * symbolisieren soll.
	 */

	protected Node<K, V> root;

	/**
	 * Mit diesem Konstruktor AssociativeArrayTree wird die Wurzel erzeugt und
	 * einen Schlüssel, sowie einen Wert zugewiesen. Somit ist die Wurzel der
	 * erste Knoten des binären Baumes.
	 *
	 * @param key
	 *            the key, welcher den schlüssel die Wurzel symbolisiert
	 * @param value
	 *            the value, welches einen Zuweisungswert für die Wurzel erzeugt
	 */

	public AssociativeArrayTree(K key, V value) {
		this.root = new Node<K, V>(key, value);
	}

	public AssociativeArrayTree() {
	}
	
	public AssociativeArrayTree(Node<K,V> root) {
		this.root = root;
	}

	/**
	 * Die innere Klasse Node dient zur Erzeugung der äußeren Klasse
	 * AssociativeArrayTree. Die innere Klasse hat darüber hinaus die Funktion,
	 * dass sie die Knoten des baumes erzeugt.
	 *
	 * @param <K>
	 *            Der generische Schlüsseltyp der einzelnen Knoten
	 * @param <V>
	 *            Der generische Wert der einzelnen Knoten
	 */

	public static class Node<K, V> {

		/** Das Attribut Schlüssel */
		private K key;

		/** Das Attribut Wert */
		private V value;

		/** Elternknotenattribut. */
		private Node<K, V> left, right, parent;

		/**
		 * Ein Attribut, welches mit einer hashKey()-Methode deklariert wurde.
		 * Sie gibt also von jedem Knoten den jeweiligen hashwert aus.
		 */

		private int hashKey = key.hashCode();

		/**
		 * Mit dem Konstruktor Node werden Knoten für diesen Baum erzeugt. Der
		 * Knoten besitzt ebenfalls einen wert und einen dazugehörigen
		 * Schlüssel.
		 *
		 * @param key
		 *            Der Schlüssel des Knotens
		 * @param value
		 *            Der Wert des Knotens
		 */

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * In dieser Methode wird der Schlüssel eines Knotens ausgelesen.
		 *
		 * @return key Den Schlüssel eines Knotens
		 */

		protected K getKey() {
			return key;
		}

		/**
		 * In dieser Methode wird der Wert eines Knotens ausgelesen.
		 *
		 * @return the value Den Wert eines Knotens
		 */

		protected V getValue() {
			return value;
		}

		/**
		 * In dieser Methode wird der Schlüssel eines Knotens gesetzt.
		 *
		 * @param key
		 *            den gesetzten Schlüssel
		 */

		protected void setKey(K key) {
			this.key = key;
		}

		/**
		 * In dieser Methode wird der Wert eines Knotens ausgelesen.
		 *
		 * @param value
		 *            Den gesetzten Wert
		 */

		protected void setValue(V value) {
			this.value = value;
		}

		/**
		 * In dieser Methode wird der linke Knoten ausgelesen.
		 *
		 * @return the left linken Knoten des Elternknotens
		 */

		protected Node<K, V> getLeft() {
			return left;
		}

		/**
		 * In dieser Methode wird der linke Knoten gesetzt.
		 *
		 * @param left
		 *            the left linken Knoten des Elternknotens
		 */

		protected void setLeft(Node<K, V> left) {
			this.left = left;
		}

		/**
		 * In dieser Methode wird der rechte Knoten ausgelesen.
		 *
		 * @return the right den rechten Knoten des Elternknotens
		 */

		protected Node<K, V> getRight() {
			return right;
		}

		/**
		 * In dieser Methode wird der rechteKnoten gesetzt.
		 *
		 * @param right
		 *            the right den neuen rechten Knoten des Elternsknotens
		 */

		protected void setRight(Node<K, V> right) {
			this.right = right;
		}

		/**
		 * In dieser Methode wird der Elternknoten ausgelesen, welcher Eltern
		 * zweier anderen knoten ist.
		 *
		 * @return the parent den Elternknoten auslesen
		 */

		protected Node<K, V> getParent() {
			return parent;
		}

		/**
		 * In dieser Methode wird der Elternknoten gesetzt, welcher Eltern
		 * zweier anderen Knoten ist.
		 *
		 * @param parent
		 *            the parent den neuen Elternknoten
		 */

		protected void setParent(Node<K, V> parent) {
			this.parent = parent;
		}

	}

	@Override
	public void clear() {
		root = null;

	}

	@Override
	public boolean containsValue(V value) {
		Node<K, V> node = this.root;
		return containsValue(value, node);
	}

	/**
	 * In dieser Methode wird überprüft, ob sich der gegebene Schlüsselwert im
	 * Baum befindet.
	 *
	 * @param value
	 *            den Wert eines Knotens
	 * @param node
	 *            den Knoten
	 * @return true, if successful
	 */

	public boolean containsValue(V value, Node<K, V> node) {
		if (node == null) {
			return false;
		} else {
			if (node.value == value) {
				return true;
			}
			return containsValue(value, node.left)
					&& containsValue(value, node.right);
		}
	}

	@Override
	public boolean containsKey(K key) {
		return containsKey(key.hashCode(), root);
	}

	/**
	 * In dieser Methode wird überprüft, ob sich der gegebene Schlüssel im Baum
	 * befindet.
	 *
	 * @param hashKey
	 *            Hashwert des Schlüssel
	 * @param node
	 *            the node
	 * @return true, if successful
	 */

	public boolean containsKey(int hashKey, Node<K, V> node) {
		if (node == null) {
			return false;
		} else {
			if (node.hashKey == hashKey) {
				return true;
			} else if (hashKey < node.hashKey) {
				return containsKey(hashKey, node.left);
			} else {
				return containsKey(hashKey, node.right);
			}
		}
	}

	@Override
	public V get(K key) {
		return get(key.hashCode(), root);
	}

	/**
	 * Gibt den Wert eines Gebenen Knoten raus. Der gesuchte Schlüssel wird
	 * eingegeben.
	 *
	 * @param hashKey
	 *            the hash key
	 * @param node
	 *            the node
	 * @return the v
	 */

	public V get(int hashKey, Node<K, V> node) {

		if (node == null) {
			return null;

		} else {
			if (node.hashCode() == (hashKey)) {
				return node.value;
			} else if (hashCode() < node.key.hashCode()) {
				return get(hashKey, node.left);
			} else {
				return get(hashKey, node.right);
			}
		}
	}

	/**
	 * Methode überprüft ob der baum leer ist
	 *
	 * 
	 * @return true, wenn leer
	 */

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void put(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		if (newNode.key.hashCode() < root.key.hashCode()) {
			if (root.left == null)
				root.left = newNode;
			else
				put(root.left, newNode);
		} else {
			if (root.right == null)
				root.right = newNode;
			else
				put(root.right, newNode);
		}
	}

	/**
	 * Mit dieser Methode wird ein neuer Knoten erzeugt und dem baum
	 * hinzugefügt.
	 *
	 * @param node
	 *            the node
	 * @param newNode
	 *            the new node
	 */

	public void put(Node<K, V> node, Node<K, V> newNode) {
		if (newNode.key.hashCode() < node.key.hashCode()) {
			if (node.left == null)
				node.left = newNode;
			else
				put(node.left, newNode);
		} else {
			if (node.right == null)
				node.right = newNode;
			else
				put(node.right, newNode);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#putAll(hsmannheim
	 * .ws2014.tpe.uib1.aufgabe3.AssociativeArrayTree)
	 */

	@Override
	public void putAll(AssociativeArrayTree<K, V> tree) {
		if (tree != null) {
			extractAll(tree.root, this.root);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#remove(java.lang
	 * .Object)
	 */

	@Override
	public void remove(K key) {
		if (containsKey(key)) {
			Node<K,V> node = getNode(key);
			Node<K,V> parentNode = node.parent;
			if (parentNode.left == node) {
				parentNode.setLeft(null);
			} else {
				parentNode.setRight(null);
			}
			putAll(new AssociativeArrayTree<K, V>(node.right));
			putAll(new AssociativeArrayTree<K, V>(node.left));
		}

		
	}
	
	public Node<K,V> getNode(K key) {
			return getNode(key, root);
	}
	
	
	private Node<K,V> getNode(K key, Node<K,V> node) {
		if (node != null) {
			if (node.key.hashCode() == key.hashCode()) {
				return node;
			} else if (node.key.hashCode() > key.hashCode()) {
				return getNode(key, node.left);
			} else {
				return getNode(key, node.right);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#size()
	 */

	@Override
	public int size() {
		return size(this.root);
	}

	/**
	 * Gibt die Größe des baumes aus.
	 *
	 * @param node
	 *            die Knoten
	 * @return the int die Anzahl der Knoten
	 */

	public int size(Node<K, V> node) {
		if (node == null) {
			return 0;
		}

		else
			return 1 + size(node.left) + size(node.right);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#update(java.lang
	 * .Object, java.lang.Object)
	 */

	@Override
	public void update(K key, V value) {
		if (containsKey(key) == true)
			update(root, key, value);
	}

	/**
	 * In dieser methode wird der Wert mit einem neuen Wert aktualisiert.
	 *
	 * @param node
	 *            the node
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */

	private void update(Node<K, V> node, K key, V value) {
		if (node.getKey() == key) {
			node.setValue(value);
		} else if (node.getKey().hashCode() < key.hashCode()) {
			update(node.getRight(), key, value);
		} else {
			update(node.getLeft(), key, value);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#forEach(java.util
	 * .function.BiConsumer)
	 */

	/*
	 * @Override public void forEach(BiConsumer<?, ?> lambda) {
	 * forEach(consumer, root);
	 * 
	 * }
	 * 
	 * /** Diese Methode führt den BiConsumer in allen Knoten aus.
	 * 
	 * @param consumer the consumer
	 * 
	 * @param n the n
	 */
	/*
	 * public void forEach(BiConsumer<K, V> consumer, Node n) { if (n != null) {
	 * consumer.accept(n.key, n.value); forEach(consumer, n.left);
	 * forEach(consumer, n.right); } }\ /* (non-Javadoc)
	 * 
	 * @see
	 * hsmannheim.ws2014.tpe.uib1.aufgabe3.AssociativeArray#extractAll(hsmannheim
	 * .ws2014.tpe.uib1.aufgabe3.AssociativeArrayTree)
	 */

	@Override
	public void extractAll(AssociativeArrayTree<K, V> tree) {
		if (this.root != null) {
			extractAll(this.root, tree.root);
		}

	}

	/**
	 * Extract all.
	 *
	 * @param extractThis
	 *            the extract this
	 * @param tree
	 *            the tree
	 */

	private void extractAll(Node<K, V> extractThis, Node<K, V> tree) {
		if (extractThis == null) {

		} else {

			Node<K, V> temp = new Node<K, V>(extractThis.getKey(),
					extractThis.getValue());

			put(temp, tree);

			extractAll(extractThis.getLeft(), tree);
			extractAll(extractThis.getRight(), tree);
		}

		this.root = null;
	}

	/**
	 * Map.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		AssociativeArrayTree other = (AssociativeArrayTree) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

	@Override
	public AssociativeArrayTree<?, ?> map(BiFunction<?, ?, ?> lambda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(BiConsumer<?, ?> lambda) {
		// TODO Auto-generated method stub

	}

}