package hu.akarnokd.rxjava3.math;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarObserver;
import r6.a.b.h.k;
public class ObservableSumLong extends k<Long, Long> {

    public static final class a extends DeferredScalarObserver<Long, Long> {
        private static final long serialVersionUID = 8645575082613773782L;
        public long a;
        public boolean b;

        public a(Observer<? super Long> observer) {
            super(observer);
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.b) {
                complete(Long.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
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

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new a(observer));
    }
}
