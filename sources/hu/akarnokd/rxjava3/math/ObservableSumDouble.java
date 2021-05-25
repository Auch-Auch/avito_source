package hu.akarnokd.rxjava3.math;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
import r6.a.b.h.k;
public class ObservableSumDouble extends k<Double, Double> {

    public static final class a extends DeferredScalarObserver<Double, Double> {
        private static final long serialVersionUID = -769098775594601087L;
        public double a;
        public boolean b;

        public a(Observer<? super Double> observer) {
            super(observer);
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.b) {
                complete(Double.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Double d = (Double) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = d.doubleValue() + this.a;
        }
    }

    public ObservableSumDouble(ObservableSource<Double> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Double> observer) {
        this.source.subscribe(new a(observer));
    }
}
