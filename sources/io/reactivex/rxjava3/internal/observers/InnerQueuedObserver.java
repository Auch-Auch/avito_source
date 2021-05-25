package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    public final InnerQueuedObserverSupport<T> a;
    public final int b;
    public SimpleQueue<T> c;
    public volatile boolean d;
    public int e;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i) {
        this.a = innerQueuedObserverSupport;
        this.b = i;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public boolean isDone() {
        return this.d;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.a.innerComplete(this);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.a.innerError(this, th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.e == 0) {
            this.a.innerNext(this, t);
        } else {
            this.a.drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.e = requestFusion;
                    this.c = queueDisposable;
                    this.d = true;
                    this.a.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.e = requestFusion;
                    this.c = queueDisposable;
                    return;
                }
            }
            this.c = QueueDrainHelper.createQueue(-this.b);
        }
    }

    public SimpleQueue<T> queue() {
        return this.c;
    }

    public void setDone() {
        this.d = true;
    }
}
