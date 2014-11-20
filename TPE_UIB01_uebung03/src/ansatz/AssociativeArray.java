package ansatz;

public interface AssociativeArray<K,V, Node> {

	public void clear();
	public boolean containsValue(V value , Node node);
	public boolean containsKey(int hashKey, Node node);
	public V get(K key, Node node);
	public boolean isEmpty();
	public void put(K key, V value);
	public void putAll(K[] array);
	public V remove(K key);
	public K size();
	public K update(int amount, K key);
	public void forEach();
	public void extractAll(K[]array);
	public void map();
	boolean containsKey(int hashKey, BinärHashBaum<K, V, Node>.Node node);
	boolean containsValue(V value, BinärHashBaum<K, V, Node>.Node node);
	
}
