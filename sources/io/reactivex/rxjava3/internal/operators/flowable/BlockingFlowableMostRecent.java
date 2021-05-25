package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    public final Flowable<T> a;
    public final T b;

    public static final class a<T> extends DefaultSubscriber<T> {
        public volatile Object b;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableMostRecent$a$a  reason: collision with other inner class name */
        public final class C0440a implements Iterator<T> {
            public Object a;

            public C0440a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = a.this.b;
                this.a = obj;
                return !NotificationLite.isComplete(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                Object obj = null;
                try {
                    if (this.a == null) {
                        Object obj2 = a.this.b;
                    }
                    if (NotificationLite.isComplete(this.a)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.a)) {
                        T t = (T) NotificationLite.getValue(this.a);
                        this.a = null;
                        return t;
                    } else {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.a));
                    }
                } finally {
                    this.a = obj;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public a(T t) {
            this.b = NotificationLite.next(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.b = NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.b = NotificationLite.next(t);
        }
    }

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.a = flowable;
        this.b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.b);
        this.a.subscribe((FlowableSubscriber) aVar);
        return new a.C0440a();
    }
}
