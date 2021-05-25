package com.google.android.gms.internal.measurement;

import java.util.Comparator;
public interface zzfx<T> extends Iterable<T> {
    @Override // java.util.SortedSet
    Comparator<? super T> comparator();
}
