package r6.a.b.l;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import retrofit2.HttpException;
import retrofit2.Response;
public final class a<T> extends Observable<T> {
    public final Observable<Response<T>> a;

    /* renamed from: r6.a.b.l.a$a  reason: collision with other inner class name */
    public static class C0670a<R> implements Observer<Response<R>> {
        public final Observer<? super R> a;
        public boolean b;

        public C0670a(Observer<? super R> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.b) {
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (!this.b) {
                this.a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.onError(assertionError);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Response response = (Response) obj;
            if (response.isSuccessful()) {
                this.a.onNext((Object) response.body());
                return;
            }
            this.b = true;
            HttpException httpException = new HttpException(response);
            try {
                this.a.onError(httpException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(httpException, th));
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }
    }

    public a(Observable<Response<T>> observable) {
        this.a = observable;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new C0670a(observer));
    }
}
