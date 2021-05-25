package r6.a.a.a;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;
public final class s0<T> extends Observable<T> implements Callable<T> {
    public final Callable<? extends T> a;

    public static final class a<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = -7088349936918117528L;

        public a(Observer<? super T> observer) {
            super(observer);
        }
    }

    public s0(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.a.call();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: r6.a.a.a.s0$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        if (!aVar.isDisposed()) {
            try {
                Object call = this.a.call();
                if (aVar.isDisposed()) {
                    return;
                }
                if (call == null) {
                    observer.onComplete();
                } else {
                    aVar.complete(call);
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
