package com.jakewharton.rxrelay3;

import a2.k.d.a;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    @Override // io.reactivex.rxjava3.functions.Consumer
    public abstract void accept(@NonNull T t);

    public abstract boolean hasObservers();

    @CheckReturnValue
    @NonNull
    public final Relay<T> toSerialized() {
        if (this instanceof a) {
            return this;
        }
        return new a(this);
    }
}
