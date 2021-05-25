package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
@GwtCompatible
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {
    @Override // com.google.common.collect.Table
    /* renamed from: rowKeySet */
    SortedSet<R> mo128rowKeySet();

    @Override // com.google.common.collect.Table
    /* renamed from: rowMap */
    SortedMap<R, Map<C, V>> mo129rowMap();
}
