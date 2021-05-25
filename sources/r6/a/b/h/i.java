package r6.a.b.h;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
import java.util.Comparator;
public final class i<T> extends k<T, T> {
    public final Comparator<? super T> a;
    public final int b;

    public static final class a<T> extends DeferredScalarObserver<T, T> {
        private static final long serialVersionUID = -4484454790848904397L;
        public final Comparator<? super T> a;
        public final int b;

        public a(Observer<? super T> observer, Comparator<? super T> comparator, int i) {
            super(observer);
            this.a = comparator;
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                } else if (this.a.compare(t2, t) * this.b > 0) {
                    this.value = t;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                this.downstream.onError(th);
            }
        }
    }

    public i(ObservableSource<T> observableSource, Comparator<? super T> comparator, int i) {
        super(observableSource);
        this.a = comparator;
        this.b = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b));
    }
}
