package io.reactivex.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSwitchMapCompletable<T> extends Completable {
    public final Observable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final boolean c;

    public static final class a<T> implements Observer<T>, Disposable {
        public static final C0410a h = new C0410a(null);
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0410a> e = new AtomicReference<>();
        public volatile boolean f;
        public Disposable g;

        /* renamed from: io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0410a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final a<?> a;

            public C0410a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a<?> aVar = this.a;
                if (aVar.e.compareAndSet(this, null) && aVar.f) {
                    Throwable terminate = aVar.d.terminate();
                    if (terminate == null) {
                        aVar.a.onComplete();
                    } else {
                        aVar.a.onError(terminate);
                    }
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null) || !aVar.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.c) {
                    aVar.dispose();
                    Throwable terminate = aVar.d.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        aVar.a.onError(terminate);
                    }
                } else if (aVar.f) {
                    aVar.a.onError(aVar.d.terminate());
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = completableObserver;
            this.b = function;
            this.c = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g.dispose();
            AtomicReference<C0410a> atomicReference = this.e;
            C0410a aVar = h;
            C0410a andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                DisposableHelper.dispose(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.get() == h;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.c) {
                onComplete();
            } else {
                AtomicReference<C0410a> atomicReference = this.e;
                C0410a aVar = h;
                C0410a andSet = atomicReference.getAndSet(aVar);
                if (!(andSet == null || andSet == aVar)) {
                    DisposableHelper.dispose(andSet);
                }
                Throwable terminate = this.d.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            C0410a aVar;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null CompletableSource");
                C0410a aVar2 = new C0410a(this);
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

        @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        if (!AppCompatDelegateImpl.i.d2(this.a, this.b, completableObserver)) {
            this.a.subscribe(new a(completableObserver, this.b, this.c));
        }
    }
}
