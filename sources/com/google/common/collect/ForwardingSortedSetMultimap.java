package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract SortedSetMultimap<K, V> mo147delegate();

    @Override // com.google.common.collect.SortedSetMultimap
    public Comparator<? super V> valueComparator() {
        return mo147delegate().valueComparator();
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public SortedSet<V> mo118get(@NullableDecl K k) {
        return mo147delegate().mo118get((SortedSetMultimap<K, V>) k);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public SortedSet<V> mo119removeAll(@NullableDecl Object obj) {
        return mo147delegate().mo119removeAll(obj);
    }

    @Override // com.google.common.collect.ForwardingSetMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public SortedSet<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        return mo147delegate().mo120replaceValues((SortedSetMultimap<K, V>) k, (Iterable) iterable);
    }
}
