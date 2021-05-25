package r6.a.a.f;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class l<T> implements Observer<Notification<T>>, m {
    public Object a;
    public final Observable<T> b;
    public final Consumer<Throwable> c;
    public final List<a> d;
    public final Queue<Notification<T>> e;
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final l<T>.a g;

    public final class a extends AtomicReference<Disposable> implements Observer<Notification<T>> {
        private static final long serialVersionUID = -1466017793444404254L;

        public a() {
        }

        /* renamed from: a */
        public void onNext(Notification<T> notification) {
            synchronized (l.this.a) {
                if (!DisposableHelper.isDisposed((Disposable) get())) {
                    if (notification.isOnError()) {
                        try {
                            l.this.c.accept(notification.getError());
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            RxJavaPlugins.onError(new CompositeException(notification.getError(), th));
                        }
                        return;
                    }
                    l.this.e.add(notification);
                    Iterator it = new ArrayList(l.this.d).iterator();
                    while (it.hasNext()) {
                        try {
                            ((a) it.next()).b();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            RxJavaPlugins.onError(new CompositeException(th, th2));
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public l(Observable<T> observable, Consumer<Throwable> consumer) {
        this.b = observable;
        this.c = consumer;
        this.e = new LinkedList();
        this.d = new ArrayList();
        this.g = new a();
    }

    public void a(a aVar) {
        this.d.remove(aVar);
        if (this.d.isEmpty()) {
            DisposableHelper.dispose(this.g);
        }
    }

    @Override // r6.a.a.f.m
    public void d() {
        this.e.remove();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.g);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) this.g.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Objects.requireNonNull(this.g);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Objects.requireNonNull(this.g);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
        this.g.onNext((Notification) obj);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        l<T>.a aVar = this.g;
        Objects.requireNonNull(aVar);
        DisposableHelper.setOnce(aVar, disposable);
    }

    @Override // r6.a.a.f.m
    public void subscribe(Object obj) {
        if (this.f.compareAndSet(false, true)) {
            this.a = obj;
            this.b.materialize().subscribe(this);
            return;
        }
        throw new IllegalStateException("Can only be subscribed to once.");
    }
}
