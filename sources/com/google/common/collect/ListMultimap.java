package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.ListMultimap
    boolean equals(@NullableDecl Object obj);

    /* renamed from: get */
    List<V> mo118get(@NullableDecl K k);

    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    List<V> mo119removeAll(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    List<V> mo120replaceValues(K k, Iterable<? extends V> iterable);
}
