package ansatz;

public class Binaerbaum<K> implements AssociativeArray<K> {

	public Binaerbaum() {
        root = null;
    }
	
	protected BinaryNode root;
	
	
	public class BinaryNode {
	    
		public Comparable<K> element;
	    public BinaryNode left;
	    public BinaryNode right;
	    
	    BinaryNode(Comparable<K> K) {
	        element = K;
	        left = right = null;
	    }
	    
	   
	    
	}


	
	@Override
	public void clear() {
		root = null;
		
	}


	@Override
	public boolean conatiansValue(K value) {

		while(element != null) { // Or whatever you use to signal that there is no node.
	        switch(value.CompareTo(currentNode.Data)) {
	            case -1:
	                currentNode = currentNode.Right;
	                break;
	            case 1:
	                currentNode = currentNode.Left;
	                break;
	            default: // case 0
	                return true;
	        }
	    }
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
