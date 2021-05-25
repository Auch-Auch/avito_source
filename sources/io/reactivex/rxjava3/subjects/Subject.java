package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import s6.a.e.g.a;
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    @CheckReturnValue
    @Nullable
    public abstract Throwable getThrowable();

    @CheckReturnValue
    public abstract boolean hasComplete();

    @CheckReturnValue
    public abstract boolean hasObservers();

    @CheckReturnValue
    public abstract boolean hasThrowable();

    @CheckReturnValue
    @NonNull
    public final Subject<T> toSerialized() {
        if (this instanceof a) {
            return this;
        }
        return new a(this);
    }
}
