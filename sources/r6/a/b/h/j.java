package r6.a.b.h;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
public final class j extends k<Integer, Integer> {

    public static final class a extends DeferredScalarObserver<Integer, Integer> {
        private static final long serialVersionUID = 5434323279399190675L;
        public int a;
        public boolean b;

        public a(Observer<? super Integer> observer) {
            super(observer);
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.b) {
                complete(Integer.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Integer num = (Integer) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = num.intValue() + this.a;
        }
    }

    public j(ObservableSource<Integer> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Integer> observer) {
        this.source.subscribe(new a(observer));
    }
}
