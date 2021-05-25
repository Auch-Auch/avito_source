package r6.a.b.i;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
public final class w0<T> extends Observable<Long> implements ObservableTransformer<T, Long> {
    public final Observable<T> a;
    public final Predicate<? super T> b;

    public static final class a<T> extends DeferredScalarObserver<T, Long> {
        private static final long serialVersionUID = 4809092721669178986L;
        public final Predicate<? super T> a;
        public long b;
        public boolean c;

        public a(Observer<? super Long> observer, Predicate<? super T> predicate) {
            super(observer);
            this.a = predicate;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: r6.a.b.i.w0$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.c) {
                complete(-1L);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: r6.a.b.i.w0$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                long j = this.b;
                if (this.a.test(t)) {
                    this.c = true;
                    this.upstream.dispose();
                    complete(Long.valueOf(j));
                    return;
                }
                this.b = j + 1;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c = true;
                this.upstream.dispose();
                onError(th);
            }
        }
    }

    public w0(Observable<T> observable, Predicate<? super T> predicate) {
        this.a = observable;
        this.b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource<Long> apply(Observable<T> observable) {
        return new w0(observable, this.b);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
