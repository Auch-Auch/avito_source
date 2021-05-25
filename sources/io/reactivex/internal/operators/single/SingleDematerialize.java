package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
@Experimental
public final class SingleDematerialize<T, R> extends Maybe<R> {
    public final Single<T> a;
    public final Function<? super T, Notification<R>> b;

    public static final class a<T, R> implements SingleObserver<T>, Disposable {
        public final MaybeObserver<? super R> a;
        public final Function<? super T, Notification<R>> b;
        public Disposable c;

        public a(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.a = maybeObserver;
            this.b = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                Notification notification = (Notification) ObjectHelper.requireNonNull(this.b.apply(t), "The selector returned a null Notification");
                if (notification.isOnNext()) {
                    this.a.onSuccess((Object) notification.getValue());
                } else if (notification.isOnComplete()) {
                    this.a.onComplete();
                } else {
                    this.a.onError(notification.getError());
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }
    }

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.a = single;
        this.b = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.a.subscribe(new a(maybeObserver, this.b));
    }
}
