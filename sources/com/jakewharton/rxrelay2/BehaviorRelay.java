package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public final class BehaviorRelay<T> extends Relay<T> {
    public static final Object[] f = new Object[0];
    public static final a[] g = new a[0];
    public final AtomicReference<T> a = new AtomicReference<>();
    public final AtomicReference<a<T>[]> b = new AtomicReference<>(g);
    public final Lock c;
    public final Lock d;
    public long e;

    public static final class a<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<T> {
        public final Observer<? super T> a;
        public final BehaviorRelay<T> b;
        public boolean c;
        public boolean d;
        public AppendOnlyLinkedArrayList<T> e;
        public boolean f;
        public volatile boolean g;
        public long h;

        public a(Observer<? super T> observer, BehaviorRelay<T> behaviorRelay) {
            this.a = observer;
            this.b = behaviorRelay;
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

        @Override // com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(T t) {
            if (this.g) {
                return false;
            }
            this.a.onNext(t);
            return false;
        }
    }

    public BehaviorRelay() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock.readLock();
        this.d = reentrantReadWriteLock.writeLock();
    }

    public static <T> BehaviorRelay<T> create() {
        return new BehaviorRelay<>();
    }

    public static <T> BehaviorRelay<T> createDefault(T t) {
        BehaviorRelay<T> behaviorRelay = new BehaviorRelay<>();
        Objects.requireNonNull(t, "defaultValue == null");
        behaviorRelay.a.lazySet(t);
        return behaviorRelay;
    }

    public void a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.b.get();
            if (aVarArr != g) {
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = g;
                    } else {
                        a<T>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
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

    /* JADX INFO: finally extract failed */
    @Override // com.jakewharton.rxrelay2.Relay, io.reactivex.functions.Consumer
    public void accept(T t) {
        Objects.requireNonNull(t, "value == null");
        this.d.lock();
        try {
            this.e++;
            this.a.lazySet(t);
            this.d.unlock();
            a<T>[] aVarArr = this.b.get();
            for (a<T> aVar : aVarArr) {
                long j = this.e;
                if (!aVar.g) {
                    if (!aVar.f) {
                        synchronized (aVar) {
                            if (!aVar.g) {
                                if (aVar.h != j) {
                                    if (aVar.d) {
                                        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = aVar.e;
                                        if (appendOnlyLinkedArrayList == null) {
                                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                            aVar.e = appendOnlyLinkedArrayList;
                                        }
                                        appendOnlyLinkedArrayList.a(t);
                                    } else {
                                        aVar.c = true;
                                        aVar.f = true;
                                    }
                                }
                            }
                        }
                    }
                    if (!aVar.g) {
                        aVar.a.onNext(t);
                    }
                }
            }
        } catch (Throwable th) {
            this.d.unlock();
            throw th;
        }
    }

    public T getValue() {
        return this.a.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.jakewharton.rxrelay2.BehaviorRelay<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = f;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.b.get().length != 0;
    }

    public boolean hasValue() {
        return this.a.get() != null;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        T t;
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        a<T> aVar = new a<>(observer, this);
        observer.onSubscribe(aVar);
        do {
            aVarArr = this.b.get();
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.b.compareAndSet(aVarArr, aVarArr2));
        if (aVar.g) {
            a(aVar);
        } else if (!aVar.g) {
            synchronized (aVar) {
                if (aVar.g) {
                    return;
                }
                if (!aVar.c) {
                    BehaviorRelay<T> behaviorRelay = aVar.b;
                    Lock lock = behaviorRelay.c;
                    lock.lock();
                    aVar.h = behaviorRelay.e;
                    t = behaviorRelay.a.get();
                    lock.unlock();
                    aVar.d = t != null;
                    aVar.c = true;
                } else {
                    return;
                }
            }
            if (t != null) {
                if (!aVar.g) {
                    aVar.a.onNext(t);
                }
                while (!aVar.g) {
                    synchronized (aVar) {
                        appendOnlyLinkedArrayList = aVar.e;
                        if (appendOnlyLinkedArrayList == null) {
                            aVar.d = false;
                            return;
                        }
                        aVar.e = null;
                    }
                    for (Object[] objArr = appendOnlyLinkedArrayList.a; objArr != null; objArr = objArr[4]) {
                        for (int i = 0; i < 4; i++) {
                            Object[] objArr2 = objArr[i];
                            if (objArr2 == null) {
                                break;
                            }
                            if (!aVar.g) {
                                aVar.a.onNext(objArr2);
                            }
                        }
                    }
                }
            }
        }
    }

    public T[] getValues(T[] tArr) {
        T t = this.a.get();
        if (t == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        } else if (tArr.length != 0) {
            tArr[0] = t;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        } else {
            T[] tArr2 = (T[]) ((Object[]) a2.b.a.a.a.k2(tArr, 1));
            tArr2[0] = t;
            return tArr2;
        }
    }
}
