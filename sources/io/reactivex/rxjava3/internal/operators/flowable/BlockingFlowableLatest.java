package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    public final Publisher<? extends T> a;

    public static final class a<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        public final Semaphore b = new Semaphore(0);
        public final AtomicReference<Notification<T>> c = new AtomicReference<>();
        public Notification<T> d;

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.d;
            if (notification == null || !notification.isOnError()) {
                Notification<T> notification2 = this.d;
                if ((notification2 == null || notification2.isOnNext()) && this.d == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.b.acquire();
                        Notification<T> andSet = this.c.getAndSet(null);
                        this.d = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.d = Notification.createOnError(e);
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                }
                return this.d.isOnNext();
            }
            throw ExceptionHelper.wrapOrThrow(this.d.getError());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.d.isOnNext()) {
                throw new NoSuchElementException();
            }
            T value = this.d.getValue();
            this.d = null;
            return value;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (this.c.getAndSet((Notification) obj) == null) {
                this.b.release();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.a = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        Flowable.fromPublisher(this.a).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) aVar);
        return aVar;
    }
}
