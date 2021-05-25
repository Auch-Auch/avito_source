package r6.a.b.l;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public final class b<T> extends Observable<Response<T>> {
    public final Call<T> a;

    public static final class a<T> implements Disposable, Callback<T> {
        public final Call<?> a;
        public final Observer<? super Response<T>> b;
        public volatile boolean c;
        public boolean d = false;

        public a(Call<?> call, Observer<? super Response<T>> observer) {
            this.a = call;
            this.b = observer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.a.cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (!call.isCanceled()) {
                try {
                    this.b.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (!this.c) {
                try {
                    this.b.onNext(response);
                    if (!this.c) {
                        this.d = true;
                        this.b.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(th, th));
                }
            }
        }
    }

    public b(Call<T> call) {
        this.a = call;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        Call<T> clone = this.a.clone();
        a aVar = new a(clone, observer);
        observer.onSubscribe(aVar);
        if (!aVar.c) {
            clone.enqueue(aVar);
        }
    }
}
