package ansatz;

public interface AssociativeArray<K,V> {

	public void clear();
	public boolean conatiansValue(V value);
	public boolean containsKey(K key);
	public V get(K key);
	public boolean isEmpty();
	public void put(K key, V value);
	public void putAll(K[] array);
	public V remove(K key);
	public K size();
	public K update(int amount, K key);
	public void forEach();
	public void extractAll(K[]array);
	public void map();
	
}
