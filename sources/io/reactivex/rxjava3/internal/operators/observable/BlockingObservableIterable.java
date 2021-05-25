package io.reactivex.rxjava3.internal.operators.observable;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public final class BlockingObservableIterable<T> implements Iterable<T> {
    public final ObservableSource<? extends T> a;
    public final int b;

    public static final class a<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        public final SpscLinkedArrayQueue<T> a;
        public final Lock b;
        public final Condition c;
        public volatile boolean d;
        public volatile Throwable e;

        public a(int i) {
            this.a = new SpscLinkedArrayQueue<>(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.b = reentrantLock;
            this.c = reentrantLock.newCondition();
        }

        public void a() {
            this.b.lock();
            try {
                this.c.signalAll();
            } finally {
                this.b.unlock();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z = this.d;
                boolean isEmpty = this.a.isEmpty();
                if (z) {
                    Throwable th = this.e;
                    if (th != null) {
                        throw ExceptionHelper.wrapOrThrow(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.b.lock();
                    while (!this.d && this.a.isEmpty() && !isDisposed()) {
                        try {
                            this.c.await();
                        } finally {
                            this.b.unlock();
                        }
                    }
                } catch (InterruptedException e2) {
                    DisposableHelper.dispose(this);
                    a();
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            Throwable th2 = this.e;
            if (th2 == null) {
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(th2);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.a.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.d = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.e = th;
            this.d = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.a.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i) {
        this.a = observableSource;
        this.b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.b);
        this.a.subscribe(aVar);
        return aVar;
    }
}
