package hu.akarnokd.rxjava3.math;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
import r6.a.b.h.k;
public class ObservableAverageFloat extends k<Number, Float> {

    public static final class a extends DeferredScalarObserver<Number, Float> {
        private static final long serialVersionUID = -4845767048730060914L;
        public float a;
        public int b;

        public a(Observer<? super Float> observer) {
            super(observer);
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            int i = this.b;
            if (i != 0) {
                complete(Float.valueOf(this.a / ((float) i)));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            this.b++;
            this.a = ((Number) obj).floatValue() + this.a;
        }
    }

    public ObservableAverageFloat(ObservableSource<Number> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Float> observer) {
        this.source.subscribe(new a(observer));
    }
}
