package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;
public final class ObservableMap<T, U> extends s6.a.e.d.c.c.a<T, U> {
    public final Function<? super T, ? extends U> a;

    public static final class a<T, U> extends BasicFuseableObserver<T, U> {
        public final Function<? super T, ? extends U> a;

        public a(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    Object apply = this.a.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() throws Throwable {
            T poll = this.qd.poll();
            if (poll == null) {
                return null;
            }
            U u = (U) this.a.apply(poll);
            Objects.requireNonNull(u, "The mapper function returned a null value.");
            return u;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new a(observer, this.a));
    }
}
