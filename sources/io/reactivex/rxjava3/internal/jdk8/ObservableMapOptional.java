package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import java.util.Objects;
import java.util.Optional;
public final class ObservableMapOptional<T, R> extends Observable<R> {
    public final Observable<T> a;
    public final Function<? super T, Optional<? extends R>> b;

    public static final class a<T, R> extends BasicFuseableObserver<T, R> {
        public final Function<? super T, Optional<? extends R>> a;

        public a(Observer<? super R> observer, Function<? super T, Optional<? extends R>> function) {
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
                    Optional<? extends R> apply = this.a.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Optional");
                    Optional<? extends R> optional = apply;
                    if (optional.isPresent()) {
                        this.downstream.onNext((Object) optional.get());
                    }
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            Optional<? extends R> optional;
            do {
                T poll = this.qd.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.a.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                optional = apply;
            } while (!optional.isPresent());
            return (R) optional.get();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableMapOptional(Observable<T> observable, Function<? super T, Optional<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
