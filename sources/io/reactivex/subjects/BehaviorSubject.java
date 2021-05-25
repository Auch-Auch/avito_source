package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public final class BehaviorSubject<T> extends Subject<T> {
    public static final Object[] h = new Object[0];
    public static final a[] i = new a[0];
    public static final a[] j = new a[0];
    public final AtomicReference<Object> a = new AtomicReference<>();
    public final AtomicReference<a<T>[]> b = new AtomicReference<>(i);
    public final ReadWriteLock c;
    public final Lock d;
    public final Lock e;
    public final AtomicReference<Throwable> f = new AtomicReference<>();
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.g) {
                this.g = true;
                this.b.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.g || NotificationLite.accept(obj, this.a);
        }
    }

    public BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> createDefault(T t) {
        BehaviorSubject<T> behaviorSubject = new BehaviorSubject<>();
        behaviorSubject.a.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
        return behaviorSubject;
    }

    public void a(a<T> aVar) {
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
                        aVarArr2 = i;
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

    public void b(Object obj) {
        this.e.lock();
        this.g++;
        this.a.lazySet(obj);
        this.e.unlock();
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.subjects.BehaviorSubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] getValues() {
        Object[] objArr = h;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.a.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.b.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.a.get());
    }

    public boolean hasValue() {
        Object obj = this.a.get();
        return obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            AtomicReference<a<T>[]> atomicReference = this.b;
            a<T>[] aVarArr = j;
            a<T>[] andSet = atomicReference.getAndSet(aVarArr);
            if (andSet != aVarArr) {
                b(complete);
            }
            for (a<T> aVar : andSet) {
                aVar.a(complete, this.g);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f.compareAndSet(null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        AtomicReference<a<T>[]> atomicReference = this.b;
        a<T>[] aVarArr = j;
        a<T>[] andSet = atomicReference.getAndSet(aVarArr);
        if (andSet != aVarArr) {
            b(error);
        }
        for (a<T> aVar : andSet) {
            aVar.a(error, this.g);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f.get() == null) {
            Object next = NotificationLite.next(t);
            b(next);
            for (a<T> aVar : this.b.get()) {
                aVar.a(next, this.g);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        Object obj;
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.b.get();
            if (aVarArr != j) {
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
            a(aVar);
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

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.a.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = NotificationLite.getValue(obj);
        if (tArr.length != 0) {
            tArr[0] = value;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = 0;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, 1));
        tArr2[0] = value;
        return tArr2;
    }
}
