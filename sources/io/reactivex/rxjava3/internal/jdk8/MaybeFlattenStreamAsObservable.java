package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {
    public final Maybe<T> a;
    public final Function<? super T, ? extends Stream<? extends R>> b;

    public static final class a<T, R> extends BasicIntQueueDisposable<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends Stream<? extends R>> b;
        public Disposable c;
        public volatile Iterator<? extends R> d;
        public AutoCloseable e;
        public boolean f;
        public volatile boolean g;
        public boolean h;

        public a(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.a = observer;
            this.b = function;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                Iterator<? extends R> it = this.d;
                int i = 1;
                while (true) {
                    if (this.g) {
                        clear();
                    } else if (this.h) {
                        observer.onNext(null);
                        observer.onComplete();
                    } else {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.g) {
                                observer.onNext(obj);
                                if (!this.g) {
                                    try {
                                        boolean hasNext = it.hasNext();
                                        if (!this.g && !hasNext) {
                                            observer.onComplete();
                                            this.g = true;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        observer.onError(th);
                                        this.g = true;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            observer.onError(th2);
                            this.g = true;
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.d = null;
            AutoCloseable autoCloseable = this.e;
            this.e = null;
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.g = true;
            this.c.dispose();
            if (!this.h) {
                a();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<? extends R> it = this.d;
            if (it == null) {
                return true;
            }
            if (!this.f || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(@NonNull Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(@NonNull T t) {
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream stream = (Stream) apply;
                Iterator<T> it = stream.iterator();
                if (!it.hasNext()) {
                    this.a.onComplete();
                    try {
                        stream.close();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } else {
                    this.d = it;
                    this.e = stream;
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.d;
            if (it == null) {
                return null;
            }
            if (!this.f) {
                this.f = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            return (R) it.next();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.h = true;
            return 2;
        }
    }

    public MaybeFlattenStreamAsObservable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.a = maybe;
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NonNull Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
