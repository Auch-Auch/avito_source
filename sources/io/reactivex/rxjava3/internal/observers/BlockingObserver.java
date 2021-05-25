package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> a;

    public BlockingObserver(Queue<Object> queue) {
        this.a = queue;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.a.offer(TERMINATED);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.a.offer(NotificationLite.complete());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.a.offer(NotificationLite.error(th));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.a.offer(NotificationLite.next(t));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
