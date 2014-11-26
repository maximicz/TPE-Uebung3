package hsmannheim.ws2014.tpe.uib1.aufgabe3;

import java.util.function.*;

public class AssociativeArrayTree<K, V> implements
		AssociativeArray<K, V> {

	protected Node<K, V> root;

	public AssociativeArrayTree(K key, V value) {
		this.root = new Node<K, V>(key, value);
	}

	public static class Node<K, V> {

		protected K key;
		protected V value;
		protected Node<K, V> left, right, parent;
		protected int hashKey = key.hashCode();

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		protected K getKey() {
			return key;
		}

		protected V getValue() {
			return value;
		}

		protected void setKey(K key) {
			this.key = key;
		}

		protected void setValue(V value) {
			this.value = value;
		}

		protected Node<K, V> getLeft() {
			return left;
		}

		protected void setLeft(Node<K, V> left) {
			this.left = left;
		}

		protected Node<K, V> getRight() {
			return right;
		}

		protected void setRight(Node<K, V> right) {
			this.right = right;
		}

		protected Node<K, V> getParent() {
			return parent;
		}

		protected void setParent(Node<K, V> parent) {
			this.parent = parent;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
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
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private AssociativeArrayTree<K, V> getOuterType() {
			return AssociativeArrayTree.this;
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
	public void putAll(AssociativeArrayTree<K, V> tree) {
		if (tree != null) {
			extractAll(tree.root, this.root);
		}

	}

	@Override
	public V remove(K key) {

	}

	@Override
	public int size() {
		return size(this.root);
	}

	public int size(Node<K, V> node) {
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
	public void forEach(BiConsumer<?, ?> lambda) {
		forEach(consumer, root);

	}

	public void forEach(BiConsumer<K, V> consumer, Node n) {
		if (n != null) {
			consumer.accept(n.key, n.value);
			forEach(consumer, n.left);
			forEach(consumer, n.right);
		}
	}

	@Override
	public void extractAll(AssociativeArrayTree<K, V> tree) {
		if (this.root != null) {
			extractAll(this.root, tree.root);
		}

	}

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

	@Override
	public void map() {
		// TODO Auto-generated method stub

	}

	@Override
	public void forEach(BiConsumer<?, ?> lambda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AssociativeArrayTree<?, ?> map(BiFunction<?, ?, ?> lambda) {
		// TODO Auto-generated method stub
		return null;
	}

}