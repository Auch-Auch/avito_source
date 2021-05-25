package r6.a.b.n;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class a<T> extends Subject<T> implements Disposable {
    public static final C0672a[] d = new C0672a[0];
    public static final C0672a[] e = new C0672a[0];
    public final Subject<T> a;
    public final AtomicReference<Disposable> b = new AtomicReference<>();
    public final AtomicReference<C0672a<T>[]> c = new AtomicReference<>(d);

    /* renamed from: r6.a.b.n.a$a  reason: collision with other inner class name */
    public static final class C0672a<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4317488092687530631L;
        public final Observer<? super T> a;
        public final a<T> b;
        public Disposable c;

        public C0672a(Observer<? super T> observer, a<T> aVar) {
            this.a = observer;
            this.b = aVar;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            C0672a<T>[] aVarArr;
            C0672a<T>[] aVarArr2;
            lazySet(true);
            this.c.dispose();
            a<T> aVar = this.b;
            do {
                aVarArr = aVar.c.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (this == aVarArr[i]) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = a.e;
                        } else {
                            C0672a<T>[] aVarArr3 = new C0672a[(length - 1)];
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
            } while (!aVar.c.compareAndSet(aVarArr, aVarArr2));
            if (aVarArr2 == a.e) {
                DisposableHelper.dispose(aVar.b);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            this.c = disposable;
            this.a.onSubscribe(this);
        }
    }

    public a(Subject<T> subject) {
        this.a = subject;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.b);
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public Throwable getThrowable() {
        return this.a.getThrowable();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasComplete() {
        return this.a.hasComplete();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasObservers() {
        return this.a.hasObservers();
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasThrowable() {
        return this.a.hasThrowable();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        this.b.lazySet(DisposableHelper.DISPOSED);
        this.a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        this.b.lazySet(DisposableHelper.DISPOSED);
        this.a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.b, disposable)) {
            this.a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        C0672a<T> aVar = new C0672a<>(observer, this);
        while (true) {
            C0672a<T>[] aVarArr = this.c.get();
            z = false;
            if (aVarArr != e) {
                int length = aVarArr.length;
                C0672a<T>[] aVarArr2 = new C0672a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.c.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            EmptyDisposable.error(new IllegalStateException("RefCountSubject terminated"), observer);
        } else {
            this.a.subscribe(aVar);
        }
    }
}
