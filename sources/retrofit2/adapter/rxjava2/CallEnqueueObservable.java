package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public final class CallEnqueueObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallCallback<T> implements Disposable, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final Observer<? super Response<T>> observer;
        public boolean terminated = false;

        public CallCallback(Call<?> call2, Observer<? super Response<T>> observer2) {
            this.call = call2;
            this.observer = observer2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call2, Throwable th) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call2, Response<T> response) {
            if (!this.disposed) {
                try {
                    this.observer.onNext(response);
                    if (!this.disposed) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(th, th));
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, observer);
        observer.onSubscribe(callCallback);
        if (!callCallback.isDisposed()) {
            clone.enqueue(callCallback);
        }
    }
}
