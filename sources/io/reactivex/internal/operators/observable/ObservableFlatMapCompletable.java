package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableFlatMapCompletable<T> extends s6.a.c.b.c.a<T, T> {
    public final Function<? super T, ? extends CompletableSource> a;
    public final boolean b;

    public static final class a<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final Observer<? super T> a;
        public final AtomicThrowable b = new AtomicThrowable();
        public final Function<? super T, ? extends CompletableSource> c;
        public final boolean d;
        public final CompositeDisposable e = new CompositeDisposable();
        public Disposable f;
        public volatile boolean g;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableFlatMapCompletable$a$a  reason: collision with other inner class name */
        public final class C0419a extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public C0419a() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a aVar = a.this;
                aVar.e.delete(this);
                aVar.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.e.delete(this);
                aVar.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = observer;
            this.c = function;
            this.d = z;
            lazySet(1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
            this.f.dispose();
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.b.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.b.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.d) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.a.onError(this.b.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.a.onError(this.b.terminate());
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0419a aVar = new C0419a();
                if (!this.g && this.e.add(aVar)) {
                    completableSource.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b));
    }
}
