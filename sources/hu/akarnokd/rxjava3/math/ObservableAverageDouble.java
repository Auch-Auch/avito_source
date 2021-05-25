package hu.akarnokd.rxjava3.math;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
import r6.a.b.h.k;
public class ObservableAverageDouble extends k<Number, Double> {

    public static final class a extends DeferredScalarObserver<Number, Double> {
        private static final long serialVersionUID = 6990557227019180008L;
        public double a;
        public long b;

        public a(Observer<? super Double> observer) {
            super(observer);
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            long j = this.b;
            if (j != 0) {
                complete(Double.valueOf(this.a / ((double) j)));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            this.b++;
            this.a = ((Number) obj).doubleValue() + this.a;
        }
    }

    public ObservableAverageDouble(ObservableSource<Number> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Double> observer) {
        this.source.subscribe(new a(observer));
    }
}
