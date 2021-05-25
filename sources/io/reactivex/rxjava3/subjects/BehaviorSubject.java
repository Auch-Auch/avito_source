package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public final class BehaviorSubject<T> extends Subject<T> {
    public static final a[] h = new a[0];
    public static final a[] i = new a[0];
    public final AtomicReference<Object> a;
    public final AtomicReference<a<T>[]> b = new AtomicReference<>(h);
    public final ReadWriteLock c;
    public final Lock d;
    public final Lock e;
    public final AtomicReference<Throwable> f;
    public long g;

    public static final class a<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        public final Observer<? super T> a;
        public final BehaviorSubject<T> b;
        public boolean c;
        public boolean d;
        public AppendOnlyLinkedArrayList<Object> e;
        public boolean f;
        public volatile boolean g;
        public long h;

        public a(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.a = observer;
            this.b = behaviorSubject;
        }

        public void a(Object obj, long j) {
            if (!this.g) {
                if (!this.f) {
                    synchronized (this) {
                        if (!this.g) {
                            if (this.h != j) {
                                if (this.d) {
                                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                                    if (appendOnlyLinkedArrayList == null) {
                                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                        this.e = appendOnlyLinkedArrayList;
                                    }
                                    appendOnlyLinkedArrayList.add(obj);
                                    return;
                                }
                                this.c = true;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.f = true;
                }
                test(obj);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.g) {
                this.g = true;
                this.b.e(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return this.g || NotificationLite.accept(obj, this.a);
        }
    }

    public BehaviorSubject(T t) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.a = new AtomicReference<>(t);
        this.f = new AtomicReference<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>(null);
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        return new BehaviorSubject<>(t);
    }

    public void e(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = h;
                    } else {
                        a<T>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.b.compareAndSet(aVarArr, aVarArr2));
    }

    public void f(Object obj) {
        this.e.lock();
        this.g++;
        this.a.lazySet(obj);
        this.e.unlock();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.a.get());
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        return this.b.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.a.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.a.get();
        return obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.f.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            f(complete);
            for (a<T> aVar : this.b.getAndSet(i)) {
                aVar.a(complete, this.g);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.f.compareAndSet(null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        f(error);
        for (a<T> aVar : this.b.getAndSet(i)) {
            aVar.a(error, this.g);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.f.get() == null) {
            Object next = NotificationLite.next(t);
            f(next);
            for (a<T> aVar : this.b.get()) {
                aVar.a(next, this.g);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        Object obj;
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.b.get();
            if (aVarArr != i) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.b.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            Throwable th = this.f.get();
            if (th == ExceptionHelper.TERMINATED) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        } else if (aVar.g) {
            e(aVar);
        } else if (!aVar.g) {
            synchronized (aVar) {
                if (!aVar.g) {
                    if (!aVar.c) {
                        BehaviorSubject<T> behaviorSubject = aVar.b;
                        Lock lock = behaviorSubject.d;
                        lock.lock();
                        aVar.h = behaviorSubject.g;
                        obj = behaviorSubject.a.get();
                        lock.unlock();
                        aVar.d = obj != null;
                        aVar.c = true;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (obj != null && !aVar.test(obj)) {
                while (!aVar.g) {
                    synchronized (aVar) {
                        appendOnlyLinkedArrayList = aVar.e;
                        if (appendOnlyLinkedArrayList == null) {
                            aVar.d = false;
                            return;
                        }
                        aVar.e = null;
                    }
                    appendOnlyLinkedArrayList.forEachWhile(aVar);
                }
            }
        }
    }
}
