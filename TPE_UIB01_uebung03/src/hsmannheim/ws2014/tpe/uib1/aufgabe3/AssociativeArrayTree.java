package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.Iterator;

public abstract class AssociativeArrayTree<K, V> implements AssociativeArray<K, V> {

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
			return containsValue(value, node.left) && containsValue(value, node.right);
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
		root = put(root, key, value);
	}

	public Node put(Node x, K key, V value) {
		if (x == null) {
			return new Node(key, value);
		}

		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			x.value = value;
		}

		else if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		}

		return x;

	}

	@Override
	public void putAll(K[] array) {
		// TODO Auto-generated method stub

	}

	@Override
	public V remove(K key) {

		return remove(root, key);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int size(Node node) {
		if (node == null) {
			return 0;
		} 
		if (node.left && node.right =! null){
		return 1 + size(node.left) + size(node.right);

	}

	@Override
	public K update(int amount, K key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void forEach() {
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