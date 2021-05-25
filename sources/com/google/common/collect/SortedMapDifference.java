package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.MapDifference;
import java.util.SortedMap;
@GwtCompatible
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    @Override // com.google.common.collect.MapDifference
    /* renamed from: entriesDiffering */
    SortedMap<K, MapDifference.ValueDifference<V>> mo103entriesDiffering();

    @Override // com.google.common.collect.MapDifference
    /* renamed from: entriesInCommon */
    SortedMap<K, V> mo104entriesInCommon();

    @Override // com.google.common.collect.MapDifference
    /* renamed from: entriesOnlyOnLeft */
    SortedMap<K, V> mo105entriesOnlyOnLeft();

    @Override // com.google.common.collect.MapDifference
    /* renamed from: entriesOnlyOnRight */
    SortedMap<K, V> mo106entriesOnlyOnRight();
}
