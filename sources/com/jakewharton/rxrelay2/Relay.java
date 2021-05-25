package com.jakewharton.rxrelay2;

import a2.k.c.a;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    @Override // io.reactivex.functions.Consumer
    public abstract void accept(T t);

    public abstract boolean hasObservers();

    public final Relay<T> toSerialized() {
        if (this instanceof a) {
            return this;
        }
        return new a(this);
    }
}
