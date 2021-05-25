package hu.akarnokd.rxjava2.math;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarObserver;
import r6.a.a.g.k;
public class ObservableSumLong extends k<Long, Long> {

    public static final class a extends DeferredScalarObserver<Long, Long> {
        private static final long serialVersionUID = 8645575082613773782L;
        public long a;
        public boolean b;

        public a(Observer<? super Long> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.b) {
                complete(Long.valueOf(this.a));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Long l = (Long) obj;
            if (!this.b) {
                this.b = true;
            }
            this.a = l.longValue() + this.a;
        }
    }

    public ObservableSumLong(ObservableSource<Long> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new a(observer));
    }
}
