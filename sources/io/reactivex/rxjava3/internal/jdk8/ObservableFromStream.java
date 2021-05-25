package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;
public final class ObservableFromStream<T> extends Observable<T> {
    public final Stream<T> a;

    public static final class a<T> implements QueueDisposable<T> {
        public final Observer<? super T> a;
        public Iterator<T> b;
        public AutoCloseable c;
        public volatile boolean d;
        public boolean e;
        public boolean f;

        public a(Observer<? super T> observer, Iterator<T> it, AutoCloseable autoCloseable) {
            this.a = observer;
            this.b = it;
            this.c = autoCloseable;
        }

        public void a() {
            if (!this.f) {
                Iterator<T> it = this.b;
                Observer<? super T> observer = this.a;
                while (!this.d) {
                    try {
                        T next = it.next();
                        Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                        if (!this.d) {
                            observer.onNext(next);
                            if (!this.d) {
                                try {
                                    if (!it.hasNext()) {
                                        observer.onComplete();
                                        this.d = true;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    observer.onError(th);
                                    this.d = true;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        this.d = true;
                    }
                }
                clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.b = null;
            AutoCloseable autoCloseable = this.c;
            this.c = null;
            if (autoCloseable != null) {
                ObservableFromStream.e(autoCloseable);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.d = true;
            a();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<T> it = this.b;
            if (it == null) {
                return true;
            }
            if (!this.e || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(@NonNull T t) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            Iterator<T> it = this.b;
            if (it == null) {
                return null;
            }
            if (!this.e) {
                this.e = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            T next = this.b.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f = true;
            return 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(@NonNull T t, @NonNull T t2) {
            throw new UnsupportedOperationException();
        }
    }

    public ObservableFromStream(Stream<T> stream) {
        this.a = stream;
    }

    public static void e(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public static <T> void subscribeStream(Observer<? super T> observer, Stream<T> stream) {
        try {
            Iterator<T> it = stream.iterator();
            if (!it.hasNext()) {
                EmptyDisposable.complete(observer);
                e(stream);
                return;
            }
            a aVar = new a(observer, it, stream);
            observer.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
            e(stream);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        subscribeStream(observer, this.a);
    }
}
