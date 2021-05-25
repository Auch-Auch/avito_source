package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    @Beta
    public class StandardKeySet extends Maps.v<K, V> {
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return mo147delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract SortedMap<K, V> mo147delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return mo147delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        return mo147delegate().headMap(k);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return mo147delegate().lastKey();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    @Beta
    public boolean standardContainsKey(@NullableDecl Object obj) {
        int i;
        try {
            K firstKey = tailMap(obj).firstKey();
            Comparator<? super K> comparator = comparator();
            if (comparator == null) {
                i = firstKey.compareTo(obj);
            } else {
                i = comparator.compare(firstKey, obj);
            }
            return i == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
        }
    }

    @Beta
    public SortedMap<K, V> standardSubMap(K k, K k2) {
        int i;
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            i = k.compareTo(k2);
        } else {
            i = comparator.compare(k, k2);
        }
        Preconditions.checkArgument(i <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        return mo147delegate().subMap(k, k2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        return mo147delegate().tailMap(k);
    }
}
