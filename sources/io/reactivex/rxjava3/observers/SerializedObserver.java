package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f = true;
        this.c.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Observer
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

    @Override // io.reactivex.rxjava3.core.Observer
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

    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: io.reactivex.rxjava3.core.Observer<? super T>, io.reactivex.rxjava3.core.Observer<? super U> */
    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(@NonNull T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (!this.f) {
            if (t == null) {
                this.c.dispose();
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
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

    @Override // io.reactivex.rxjava3.core.Observer
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
