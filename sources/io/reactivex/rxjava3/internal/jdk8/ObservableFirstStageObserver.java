package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import s6.a.e.d.a.b;
public final class ObservableFirstStageObserver<T> extends b<T> {
    public final boolean c;
    public final T d;

    public ObservableFirstStageObserver(boolean z, T t) {
        this.c = z;
        this.d = t;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!isDone()) {
            clear();
            if (this.c) {
                complete(this.d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        complete(t);
    }
}
