package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class MaybeEqualSingle<T> extends Single<Boolean> {
    public final MaybeSource<? extends T> a;
    public final MaybeSource<? extends T> b;
    public final BiPredicate<? super T, ? super T> c;

    public static final class a<T> extends AtomicInteger implements Disposable {
        public final SingleObserver<? super Boolean> a;
        public final b<T> b = new b<>(this);
        public final b<T> c = new b<>(this);
        public final BiPredicate<? super T, ? super T> d;

        public a(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.a = singleObserver;
            this.d = biPredicate;
        }

        public void a() {
            if (decrementAndGet() == 0) {
                Object obj = this.b.b;
                Object obj2 = this.c.b;
                if (obj == null || obj2 == null) {
                    this.a.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.a.onSuccess(Boolean.valueOf(this.d.test(obj, obj2)));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            b<T> bVar = this.b;
            Objects.requireNonNull(bVar);
            DisposableHelper.dispose(bVar);
            b<T> bVar2 = this.c;
            Objects.requireNonNull(bVar2);
            DisposableHelper.dispose(bVar2);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.b.get());
        }
    }

    public static final class b<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        public final a<T> a;
        public Object b;

        public b(a<T> aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.a.a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            a<T> aVar = this.a;
            if (aVar.getAndSet(0) > 0) {
                b<T> bVar = aVar.b;
                if (this == bVar) {
                    b<T> bVar2 = aVar.c;
                    Objects.requireNonNull(bVar2);
                    DisposableHelper.dispose(bVar2);
                } else {
                    Objects.requireNonNull(bVar);
                    DisposableHelper.dispose(bVar);
                }
                aVar.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.b = t;
            this.a.a();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.a = maybeSource;
        this.b = maybeSource2;
        this.c = biPredicate;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        a aVar = new a(singleObserver, this.c);
        singleObserver.onSubscribe(aVar);
        MaybeSource<? extends T> maybeSource = this.a;
        MaybeSource<? extends T> maybeSource2 = this.b;
        maybeSource.subscribe(aVar.b);
        maybeSource2.subscribe(aVar.c);
    }
}
