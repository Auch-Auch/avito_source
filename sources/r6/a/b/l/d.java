package r6.a.b.l;

import hu.akarnokd.rxjava3.retrofit.Result;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import retrofit2.Response;
public final class d<T> extends Observable<Result<T>> {
    public final Observable<Response<T>> a;

    public static class a<R> implements Observer<Response<R>> {
        public final Observer<? super Result<R>> a;

        public a(Observer<? super Result<R>> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            try {
                this.a.onNext(Result.error(th));
                this.a.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            this.a.onNext(Result.response((Response) obj));
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }
    }

    public d(Observable<Response<T>> observable) {
        this.a = observable;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Result<T>> observer) {
        this.a.subscribe(new a(observer));
    }
}
