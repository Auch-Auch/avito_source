package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSwitchMapCompletable<T> extends Completable {
    public final Observable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final boolean c;

    public static final class a<T> implements Observer<T>, Disposable {
        public static final C0474a h = new C0474a(null);
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0474a> e = new AtomicReference<>();
        public volatile boolean f;
        public Disposable g;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0474a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final a<?> a;

            public C0474a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<?> aVar = this.a;
                if (aVar.e.compareAndSet(this, null) && aVar.f) {
                    aVar.d.tryTerminateConsumer(aVar.a);
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null)) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.d.tryAddThrowableOrReport(th)) {
                } else {
                    if (!aVar.c) {
                        aVar.g.dispose();
                        aVar.a();
                        aVar.d.tryTerminateConsumer(aVar.a);
                    } else if (aVar.f) {
                        aVar.d.tryTerminateConsumer(aVar.a);
                    }
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = completableObserver;
            this.b = function;
            this.c = z;
        }

        public void a() {
            AtomicReference<C0474a> atomicReference = this.e;
            C0474a aVar = h;
            C0474a andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                DisposableHelper.dispose(andSet);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.g.dispose();
            a();
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.get() == h;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                this.d.tryTerminateConsumer(this.a);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (!this.d.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.c) {
                onComplete();
                return;
            }
            a();
            this.d.tryTerminateConsumer(this.a);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            C0474a aVar;
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                C0474a aVar2 = new C0474a(this);
                do {
                    aVar = this.e.get();
                    if (aVar == h) {
                        return;
                    }
                } while (!this.e.compareAndSet(aVar, aVar2));
                if (aVar != null) {
                    DisposableHelper.dispose(aVar);
                }
                completableSource.subscribe(aVar2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.a = observable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        if (!AppCompatDelegateImpl.i.e2(this.a, this.b, completableObserver)) {
            this.a.subscribe(new a(completableObserver, this.b, this.c));
        }
    }
}
