package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
public abstract class GroupedObservable<K, T> extends Observable<T> {
    public final K a;

    public GroupedObservable(@Nullable K k) {
        this.a = k;
    }

    @Nullable
    public K getKey() {
        return this.a;
    }
}
