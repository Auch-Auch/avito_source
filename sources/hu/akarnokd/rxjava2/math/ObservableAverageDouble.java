package hu.akarnokd.rxjava2.math;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarObserver;
import r6.a.a.g.k;
public class ObservableAverageDouble extends k<Number, Double> {

    public static final class a extends DeferredScalarObserver<Number, Double> {
        private static final long serialVersionUID = 6990557227019180008L;
        public double a;
        public long b;

        public a(Observer<? super Double> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarObserver, io.reactivex.Observer
        public void onComplete() {
            long j = this.b;
            if (j != 0) {
                complete(Double.valueOf(this.a / ((double) j)));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.b++;
            this.a = ((Number) obj).doubleValue() + this.a;
        }
    }

    public ObservableAverageDouble(ObservableSource<Number> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Double> observer) {
        this.source.subscribe(new a(observer));
    }
}
