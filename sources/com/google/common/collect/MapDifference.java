package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public interface MapDifference<K, V> {

    public interface ValueDifference<V> {
        boolean equals(@NullableDecl Object obj);

        int hashCode();

        V leftValue();

        V rightValue();
    }

    boolean areEqual();

    /* renamed from: entriesDiffering */
    Map<K, ValueDifference<V>> mo103entriesDiffering();

    /* renamed from: entriesInCommon */
    Map<K, V> mo104entriesInCommon();

    /* renamed from: entriesOnlyOnLeft */
    Map<K, V> mo105entriesOnlyOnLeft();

    /* renamed from: entriesOnlyOnRight */
    Map<K, V> mo106entriesOnlyOnRight();

    boolean equals(@NullableDecl Object obj);

    int hashCode();
}
