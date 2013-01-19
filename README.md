DepableLinkedHashMap
---
同名キーのオブジェクトを保持可能なLinkedHashMap

実装はvalueがListになってるだけ

```Set<Map.Entry<K,V>> entrySet()```で前要素が取得出来ます．

V get(Object key) メソッドは一番目の要素を返します(非推奨)
