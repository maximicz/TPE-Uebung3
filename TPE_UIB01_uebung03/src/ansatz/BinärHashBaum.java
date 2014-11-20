package ansatz;

import java.util.Iterator;


	public class BinärHashBaum <K, V, Node> implements AssociativeArray<K, V, Node> {
		
		

		private Node root;
		
		public class Node {
			
			K key;
			V value;
			Node left, right;
			int hashKey;
			Node node = root;

			public Node(K key, V value, int hashKey) {
				this.key = key;
				this.value = value;
				this.hashKey = key.hashCode();
			}
		}

		
		@Override
		public void clear() {
			root = null;
			
		}

		@Override
		public boolean containsValue(V value, Node node) {
			if (node == null) {
				return false;
			}
			else {
				if (node.value == value) {
					return true;
				}
				else if (value < node.value) {
					return containsValue(value, node.left);
				}
				else {
					return containsValue(value, node.right);
				}
			}	
		}
		
		
		@Override
		public boolean containsKey(int hashKey, Node node) {
			if (node == null) {
				return false;
			}
			else {
				if (node.hashKey == hashKey) {
					return true;
				}
				else if (hashKey < node.hashKey) {
					return containsKey(hashKey, node.left);
				}
				else {
					return containsKey(hashKey, node.right);
				}
			}	
		}

		@Override
		public V get(K key, Node node) {
			if (node == null) {
				return null;
			}
			else {
				if (node.hashKey == hashKey) {
					return true;
				}
				else if (hashKey < node.hashKey) {
					return containsKey(hashKey, node.left);
				}
				else {
					return containsKey(hashKey, node.right);
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
					x.left  = put(x.left,  key, value);
				}	
					else if (cmp > 0) { 
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
			// TODO Auto-generated method stub
			return ;
		}

		@Override
		public K size() {
			// TODO Auto-generated method stub
			return 0;
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
