package r6.a.b.l;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;
public final class c<T> extends Observable<Response<T>> {
    public final Call<T> a;

    public static final class a implements Disposable {
        public final Call<?> a;
        public volatile boolean b;

        public a(Call<?> call) {
            this.a = call;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b = true;
            this.a.cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b;
        }
    }

    public c(Call<T> call) {
        this.a = call;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z;
        Throwable th;
        Call<T> clone = this.a.clone();
        a aVar = new a(clone);
        observer.onSubscribe(aVar);
        if (!aVar.b) {
            try {
                Response<T> execute = clone.execute();
                if (!aVar.b) {
                    observer.onNext(execute);
                }
                if (!aVar.b) {
                    try {
                        observer.onComplete();
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                Exceptions.throwIfFatal(th);
                if (z) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.b) {
                    try {
                        observer.onError(th);
                    } catch (Throwable th4) {
                        Exceptions.throwIfFatal(th4);
                        RxJavaPlugins.onError(new CompositeException(th, th4));
                    }
                }
            }
        }
    }
}
