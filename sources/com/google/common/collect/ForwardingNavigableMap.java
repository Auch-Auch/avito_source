package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    public class StandardDescendingMap extends Maps.g<K, V> {

        public class a implements Iterator<Map.Entry<K, V>> {
            public Map.Entry<K, V> a = null;
            public Map.Entry<K, V> b;

            public a() {
                this.b = ForwardingNavigableMap.this.lastEntry();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b != null;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (hasNext()) {
                    try {
                        Map.Entry<K, V> entry = this.b;
                        this.a = entry;
                        this.b = ForwardingNavigableMap.this.lowerEntry(entry.getKey());
                        return entry;
                    } catch (Throwable th) {
                        this.a = this.b;
                        this.b = ForwardingNavigableMap.this.lowerEntry(this.b.getKey());
                        throw th;
                    }
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
                ForwardingNavigableMap.this.remove(this.a.getKey());
                this.a = null;
            }
        }

        public StandardDescendingMap() {
        }

        @Override // com.google.common.collect.Maps.g
        public NavigableMap<K, V> d() {
            return ForwardingNavigableMap.this;
        }

        @Override // com.google.common.collect.Maps.g
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new a();
        }
    }

    @Beta
    public class StandardNavigableKeySet extends Maps.t<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return mo147delegate().ceilingEntry(k);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return mo147delegate().ceilingKey(k);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract NavigableMap<K, V> mo147delegate();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return mo147delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return mo147delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return mo147delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return mo147delegate().floorEntry(k);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return mo147delegate().floorKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k, boolean z) {
        return mo147delegate().headMap(k, z);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return mo147delegate().higherEntry(k);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return mo147delegate().higherKey(k);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return mo147delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return mo147delegate().lowerEntry(k);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return mo147delegate().lowerKey(k);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return mo147delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return mo147delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return mo147delegate().pollLastEntry();
    }

    public Map.Entry<K, V> standardCeilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    public K standardCeilingKey(K k) {
        return (K) Maps.i(ceilingEntry(k));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardFloorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    public K standardFloorKey(K k) {
        return (K) Maps.i(floorEntry(k));
    }

    public SortedMap<K, V> standardHeadMap(K k) {
        return headMap(k, false);
    }

    public Map.Entry<K, V> standardHigherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K standardHigherKey(K k) {
        return (K) Maps.i(higherEntry(k));
    }

    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardLowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    public K standardLowerKey(K k) {
        return (K) Maps.i(lowerEntry(k));
    }

    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.c(entrySet().iterator());
    }

    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.c(descendingMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    public SortedMap<K, V> standardSubMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> standardTailMap(K k) {
        return tailMap(k, true);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return mo147delegate().subMap(k, z, k2, z2);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k, boolean z) {
        return mo147delegate().tailMap(k, z);
    }
}
