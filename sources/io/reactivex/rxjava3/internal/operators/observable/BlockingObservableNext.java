package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
public final class BlockingObservableNext<T> implements Iterable<T> {
    public final ObservableSource<T> a;

    public static final class a<T> implements Iterator<T> {
        public final b<T> a;
        public final ObservableSource<T> b;
        public T c;
        public boolean d = true;
        public boolean e = true;
        public Throwable f;
        public boolean g;

        public a(ObservableSource<T> observableSource, b<T> bVar) {
            this.b = observableSource;
            this.a = bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z;
            Throwable th = this.f;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (!this.d) {
                return false;
            } else {
                if (this.e) {
                    if (!this.g) {
                        this.g = true;
                        this.a.c.set(1);
                        new ObservableMaterialize(this.b).subscribe(this.a);
                    }
                    try {
                        b<T> bVar = this.a;
                        bVar.c.set(1);
                        BlockingHelper.verifyNonBlocking();
                        Notification<T> take = bVar.b.take();
                        if (take.isOnNext()) {
                            this.e = false;
                            this.c = take.getValue();
                            z = true;
                        } else {
                            this.d = false;
                            if (take.isOnComplete()) {
                                z = false;
                            } else {
                                Throwable error = take.getError();
                                this.f = error;
                                throw ExceptionHelper.wrapOrThrow(error);
                            }
                        }
                        if (!z) {
                            return false;
                        }
                    } catch (InterruptedException e2) {
                        this.a.dispose();
                        this.f = e2;
                        throw ExceptionHelper.wrapOrThrow(e2);
                    }
                }
                return true;
            }
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (hasNext()) {
                this.e = true;
                return this.c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class b<T> extends DisposableObserver<Notification<T>> {
        public final BlockingQueue<Notification<T>> b = new ArrayBlockingQueue(1);
        public final AtomicInteger c = new AtomicInteger();

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Notification<T> notification = (Notification) obj;
            if (this.c.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.b.offer(notification)) {
                    Notification<T> poll = this.b.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
