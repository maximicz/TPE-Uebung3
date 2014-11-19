package ansatz;

import java.util.Iterator;


	public class BST <K extends Comparable<K>, V> implements Iterable<K>, AssociativeArray<K, V> {
		
		private Node root;
		
		private class Node {
			
			K key;
			V value;
			Node left, right;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		@Override
		public Iterator<K> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void clear() {
			root = null;
			
		}

		@Override
		public boolean conatiansValue(V value) {
			Node x = root;
			 while (x != null) {
				 int cmp = value.compareTo(x.value);
				 if (cmp == 0) { 
					 return true;
				 }
				 else if (cmp < 0) { 
					 x = x.left;
				 }
				 else if (cmp > 0)
					 x = x.right;
			 	 }
			 return false;
		}

		@Override
		public boolean containsKey(K key) {
			Node x = root;
			while (x != null) {
				 int cmp = key.compareTo(x.key);
				 if (cmp == 0) { 
					 return true;
				 }
				 else if (cmp < 0) { 
					 x = x.left;
				 }
				 else if (cmp > 0)
					 x = x.right;
			 	 }
			 return false;
		}

		@Override
		public V get(K key) {
			 Node x = root;
			 while (x != null) {
				 int cmp = key.compareTo(x.key);
				 if (cmp == 0) { 
					 return x.value;
				 }
				 else if (cmp < 0) { 
					 x = x.left;
				 }
				 else if (cmp > 0)
					 x = x.right;
			 	 }
			 return null;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void put(K key) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void putAll(K[] array) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public K remove(K key) {
			// TODO Auto-generated method stub
			return 0;
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

		

}
