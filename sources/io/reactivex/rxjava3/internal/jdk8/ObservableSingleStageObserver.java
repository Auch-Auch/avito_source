package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import s6.a.e.d.a.b;
public final class ObservableSingleStageObserver<T> extends b<T> {
    public final boolean c;
    public final T d;

    public ObservableSingleStageObserver(boolean z, T t) {
        this.c = z;
        this.d = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!isDone()) {
            T t = this.b;
            clear();
            if (t != null) {
                complete(t);
            } else if (this.c) {
                complete(this.d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.b != null) {
            this.b = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.b = t;
    }
}
