package ansatz;

import ansatz.BinärHashBaum.Node;

public interface AssociativeArray<K,V> {

	public void clear();
	public boolean containsValue(V value , Node<K,V> node);
	public boolean containsKey(int hashKey, Node node);
	public V get(K key, @SuppressWarnings("rawtypes") Node node);
	public boolean isEmpty();
	public void put(K key, V value);
	public void putAll(K[] array);
	public V remove(K key);
	public int size(Node node);
	public K update(int amount, K key);
	public void forEach();
	public void extractAll(K[]array);
	public void map();
	boolean containsValue(V value, BinärHashBaum<K, V>.Node<K, V> node);
	
}
