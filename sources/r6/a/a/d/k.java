package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicFuseableObserver;
public final class k<T> extends Observable<T> {
    public final ObservableSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public static final class a<T> extends BasicFuseableObserver<T, T> {
        public final RxJavaAssemblyException a;

        public a(Observer<? super T> observer, RxJavaAssemblyException rxJavaAssemblyException) {
            super(observer);
            this.a = rxJavaAssemblyException;
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(this.a.appendLast(th));
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return (T) this.qs.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            QueueDisposable queueDisposable = this.qs;
            if (queueDisposable == null) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i);
            this.sourceMode = requestFusion;
            return requestFusion;
        }
    }

    public k(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
