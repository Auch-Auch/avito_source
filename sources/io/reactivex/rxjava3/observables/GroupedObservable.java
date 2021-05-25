package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
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
