package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.Iterator;

public abstract class AssociativeArrayTree<K, V> implements
		AssociativeArray<K, V> {

	private Node<K, V> root;

	public AssociativeArrayTree(K key, V value) {
		this.root = new Node<K, V>(key, value);
	}

	public class Node<K, V> {

		private K key;
		public V value;
		public Node<K, V> left, right, parent;
		private int hashKey = key.hashCode();

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		private Node<K, V> getLeft() {
			return left;
		}

		private void setLeft(Node<K, V> left) {
			this.left = left;
		}

		private Node<K, V> getRight() {
			return right;
		}

		private void setRight(Node<K, V> right) {
			this.right = right;
		}

		private Node<K, V> getParent() {
			return parent;
		}

		private void setParent(Node<K, V> parent) {
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

	@Override
	public void putAll(K[] array) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public V remove(K key) {

	}

	
	@Override
	public int size(Node node) {
		if (node == null) {
			return 0;
		}

		else
			return 1 + size(node.left) + size(node.right);

	}

	
	@Override
	public void update(K key, V value) {
		if (containsKey(key) == true)
			update(root, key, value);
	}

	private void update(Node<K, V> node, K key, V value) {
		if (node.getKey() == key) {
			node.setValue(value);
		} else if (node.getKey().hashCode() < key.hashCode()) {
			update(node.getRight(), key, value);
		} else {
			update(node.getLeft(), key, value);
		}
	}

	
	@Override
	public void forEach(BiConsumer<K, V> lambda) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void extractAll(K[] array) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void map() {
		// TODO Auto-generated method stub

	}

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
		BinärHashBaum other = (BinärHashBaum) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

}