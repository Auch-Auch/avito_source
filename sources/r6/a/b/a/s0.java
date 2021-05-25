package r6.a.b.a;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
public final class s0<T> extends Observable<T> implements Supplier<T> {
    public final Supplier<? extends T> a;

    public static final class a<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = -7088349936918117528L;

        public a(Observer<? super T> observer) {
            super(observer);
        }
    }

    public s0(Supplier<? extends T> supplier) {
        this.a = supplier;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return (T) this.a.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: r6.a.b.a.s0$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        if (!aVar.isDisposed()) {
            try {
                Object obj = this.a.get();
                if (aVar.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    observer.onComplete();
                } else {
                    aVar.complete(obj);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!aVar.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
