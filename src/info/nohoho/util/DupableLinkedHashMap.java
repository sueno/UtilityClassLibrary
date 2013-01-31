package info.nohoho.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DupableLinkedHashMap<K, V> implements Map<K, V>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Duplication list 
	 */
	private final Map<K, List<V>> listMap = new LinkedHashMap<K, List<V>>();
	
	public DupableLinkedHashMap() {
	}
	
	@Override
	public V put (K key, V value) {
		if (!this.containsKey(key)) {
			List<V> list = new LinkedList<V>();
			list.add(value);
			listMap.put(key, list);	
		} else {
			listMap.get(key).add(value);
		}
		return value;
	}
	
	@Override
	public V remove (Object key) {
		return listMap.remove(key) == null ? null: null;
	}
	
	public V getIndex (Object key, int n) {
		return listMap.get(key).get(n);
	}

	@Override
	public void clear() {
		listMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return listMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (Entry<K, List<V>> e : listMap.entrySet()) {
			if (e.getValue().contains(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	@SuppressWarnings("all")
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<java.util.Map.Entry<K, V>> set = new LinkedHashSet<java.util.Map.Entry<K, V>>();
		for (Entry<K,List<V>> e : listMap.entrySet()) {
			for (V v : e.getValue()) {
				set.add(new AbstractMap.SimpleEntry(e.getKey(), v));
			}
		}
		return set;
	}

	@Override
	@Deprecated
	public V get(Object key) {
		return listMap.containsKey(key) ? listMap.get(key).get(0) : null;
	}
	
	public V get(Object key, int index) {
		if (listMap.containsKey(key) && index < listMap.get(key).size()) {
			return listMap.get(key).get(index);
		} else {
			return null;
		}
	}
	
	public List<V> getList(Object key) {
		return listMap.get(key);
	}

	@Override
	public boolean isEmpty() {
		return listMap.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return listMap.keySet();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (java.util.Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
			this.put(e.getKey(), e.getValue());
		}
	}

	@Override
	public int size() {
		return listMap.size();
	}

	
	/**
	 * not implement
	 */
	@Override
	@Deprecated
	public Collection<V> values() {
		return null;
	}
	
	
}
