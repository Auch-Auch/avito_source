package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
public final class BlockingFlowableNext<T> implements Iterable<T> {
    public final Publisher<? extends T> a;

    public static final class a<T> implements Iterator<T> {
        public final b<T> a;
        public final Publisher<? extends T> b;
        public T c;
        public boolean d = true;
        public boolean e = true;
        public Throwable f;
        public boolean g;

        public a(Publisher<? extends T> publisher, b<T> bVar) {
            this.b = publisher;
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
                    try {
                        if (!this.g) {
                            this.g = true;
                            this.a.c.set(1);
                            Flowable.fromPublisher(this.b).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) this.a);
                        }
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
                            } else if (take.isOnError()) {
                                Throwable error = take.getError();
                                this.f = error;
                                throw ExceptionHelper.wrapOrThrow(error);
                            } else {
                                throw new IllegalStateException("Should not reach here");
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

    public static final class b<T> extends DisposableSubscriber<Notification<T>> {
        public final BlockingQueue<Notification<T>> b = new ArrayBlockingQueue(1);
        public final AtomicInteger c = new AtomicInteger();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
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

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.a = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
