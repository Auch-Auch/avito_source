package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
public final class BlockingObservableLatest<T> implements Iterable<T> {
    public final ObservableSource<T> a;

    public static final class a<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        public Notification<T> b;
        public final Semaphore c = new Semaphore(0);
        public final AtomicReference<Notification<T>> d = new AtomicReference<>();

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.b;
            if (notification == null || !notification.isOnError()) {
                if (this.b == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.c.acquire();
                        Notification<T> andSet = this.d.getAndSet(null);
                        this.b = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.b = Notification.createOnError(e);
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                }
                return this.b.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.b.getError());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T value = this.b.getValue();
                this.b = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            if (this.d.getAndSet((Notification) obj) == null) {
                this.c.release();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        Observable.wrap(this.a).materialize().subscribe(aVar);
        return aVar;
    }
}
