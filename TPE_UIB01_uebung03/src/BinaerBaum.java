import java.util.Iterator;


public class BinaerBaum<K extends Comparable<K>> implements Iterable<K> {

	private Binaerknoten<K> kindKnoten;
	
	static private class Binaerknoten<K extends Comparable<K>> implements AssociatetiveArray {
	       private K key;
	       private int val;
	       private Binaerknoten<K> left = null, right = null;

	       public Binaerknoten(K key,int val){   
	    	   this.key = key; this.val=val;
	       }
	       
	       public int compareKeyTo(K k) {
	    	   return (key == null ? -1 : key.compareTo(k));
	       }
	       
	       protected Binaerknoten<K> FindNode (K k) {
	       Binaerknoten<K> n = head.getRight();
	       while (n != nullNode) {
	    	   int cmp = n.compareKeyTo(k);
	    	   if (cmp == 0) {
	    		   return n;
	    	   }   
	    	   else n = (cmp > 0 ? n.getLeft () : n.getRight ());
	       }
	       return null;
	       }

		@Override
		public void clear() {
			
			
		}

		@Override
		public boolean conatiansValue() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsKey(String key) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int get(String key) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void put(String key) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void putAll(String[] array) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int remove(String key) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int update(int amount, String key) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void forEach() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void extractAll(String[] array) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void map() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public BinaerBaum() {
		head = new Binaerknoten<K>(null);
		nullNode = new TreeNode<K>(null);
		nullNode.setLeft(nullNode);
		nullNode.setRight(nullNode);
		head.setRight(nullNode);
	}
	
	
	

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
