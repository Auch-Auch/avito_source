package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
public final class ObservableBuffer<T, U extends Collection<? super T>> extends s6.a.e.d.c.c.a<T, U> {
    public final int a;
    public final int b;
    public final Supplier<U> c;

    public static final class a<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        public final Observer<? super U> a;
        public final int b;
        public final Supplier<U> c;
        public U d;
        public int e;
        public Disposable f;

        public a(Observer<? super U> observer, int i, Supplier<U> supplier) {
            this.a = observer;
            this.b = i;
            this.c = supplier;
        }

        public boolean a() {
            try {
                U u = this.c.get();
                Objects.requireNonNull(u, "Empty buffer supplied");
                this.d = u;
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.d = null;
                Disposable disposable = this.f;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.a);
                    return false;
                }
                disposable.dispose();
                this.a.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            U u = this.d;
            if (u != null) {
                this.d = null;
                if (!u.isEmpty()) {
                    this.a.onNext(u);
                }
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.d = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            U u = this.d;
            if (u != null) {
                u.add(t);
                int i = this.e + 1;
                this.e = i;
                if (i >= this.b) {
                    this.a.onNext(u);
                    this.e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        public final Observer<? super U> a;
        public final int b;
        public final int c;
        public final Supplier<U> d;
        public Disposable e;
        public final ArrayDeque<U> f = new ArrayDeque<>();
        public long g;

        public b(Observer<? super U> observer, int i, int i2, Supplier<U> supplier) {
            this.a = observer;
            this.b = i;
            this.c = i2;
            this.d = supplier;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            while (!this.f.isEmpty()) {
                this.a.onNext(this.f.poll());
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.f.clear();
            this.a.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.ArrayDeque<U extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            long j = this.g;
            this.g = 1 + j;
            if (j % ((long) this.c) == 0) {
                try {
                    this.f.offer((Collection) ExceptionHelper.nullCheck(this.d.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f.clear();
                    this.e.dispose();
                    this.a.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.f.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.b <= next.size()) {
                    it.remove();
                    this.a.onNext(next);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Supplier<U> supplier) {
        super(observableSource);
        this.a = i;
        this.b = i2;
        this.c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        int i = this.b;
        int i2 = this.a;
        if (i == i2) {
            a aVar = new a(observer, i2, this.c);
            if (aVar.a()) {
                this.source.subscribe(aVar);
                return;
            }
            return;
        }
        this.source.subscribe(new b(observer, this.a, this.b, this.c));
    }
}
