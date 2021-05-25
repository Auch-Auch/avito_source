package hu.akarnokd.rxjava2.math;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarObserver;
import r6.a.a.g.k;
public class ObservableSumFloat extends k<Float, Float> {

    public static final class a extends DeferredScalarObserver<Float, Float> {
        private static final long serialVersionUID = -6344890278713820111L;
        public float a;
        public boolean b;

        public a(Observer<? super Float> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.b) {
                complete(Float.valueOf(this.a));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Float f = (Float) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = f.floatValue() + this.a;
        }
    }

    public ObservableSumFloat(ObservableSource<Float> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Float> observer) {
        this.source.subscribe(new a(observer));
    }
}
