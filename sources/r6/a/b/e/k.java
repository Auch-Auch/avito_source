package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
public final class k<T> extends Observable<T> {
    public final ObservableSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public static final class a<T> extends BasicFuseableObserver<T, T> {
        public final RxJavaAssemblyException a;

        public a(Observer<? super T> observer, RxJavaAssemblyException rxJavaAssemblyException) {
            super(observer);
            this.a = rxJavaAssemblyException;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.downstream.onError(this.a.appendLast(th));
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            return this.qd.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            QueueDisposable<T> queueDisposable = this.qd;
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

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
