package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    public final ObservableSource<T> a;
    public final T b;

    public static final class a<T> extends DefaultObserver<T> {
        public volatile Object b;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.BlockingObservableMostRecent$a$a  reason: collision with other inner class name */
        public final class C0477a implements Iterator<T> {
            public Object a;

            public C0477a() {
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

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.b = NotificationLite.complete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.b = NotificationLite.error(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.b = NotificationLite.next(t);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.a = observableSource;
        this.b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.b);
        this.a.subscribe(aVar);
        return new a.C0477a();
    }
}
