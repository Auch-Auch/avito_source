package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
public final class SerializedObserver<T> implements Observer<T>, Disposable {
    public final Observer<? super T> a;
    public final boolean b;
    public Disposable c;
    public boolean d;
    public AppendOnlyLinkedArrayList<Object> e;
    public volatile boolean f;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f) {
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f = true;
                    this.d = true;
                    this.a.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        boolean z;
        if (this.f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.e = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
        }
        if (z) {
            RxJavaPlugins.onError(th);
        } else {
            this.a.onError(th);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: io.reactivex.Observer<? super T>, io.reactivex.Observer<? super U> */
    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (!this.f) {
            if (t == null) {
                this.c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.e;
                        if (appendOnlyLinkedArrayList2 == null) {
                            appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList2;
                        }
                        appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
                        return;
                    }
                    this.d = true;
                } else {
                    return;
                }
            }
            this.a.onNext(t);
            do {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                }
            } while (!appendOnlyLinkedArrayList.accept((Observer<? super T>) this.a));
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.c, disposable)) {
            this.c = disposable;
            this.a.onSubscribe(this);
        }
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z) {
        this.a = observer;
        this.b = z;
    }
}
