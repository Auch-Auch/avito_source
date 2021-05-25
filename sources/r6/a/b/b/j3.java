package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
public final class j3<T> extends Solo<T> {
    public final SingleOnSubscribe<T> b;

    public static final class a<T> extends DeferredScalarSubscription<T> implements SingleEmitter<T> {
        private static final long serialVersionUID = -7149477775653368644L;
        public final AtomicReference<Disposable> a = new AtomicReference<>();

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter, io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.a.get());
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter
        public void onError(Throwable th) {
            boolean z;
            AtomicReference<Disposable> atomicReference = this.a;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = atomicReference.getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.downstream.onError(th);
                if (andSet != null) {
                    andSet.dispose();
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter
        public void onSuccess(T t) {
            AtomicReference<Disposable> atomicReference = this.a;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = atomicReference.getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                complete(t);
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter
        public void setCancellable(Cancellable cancellable) {
            DisposableHelper.set(this.a, new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter
        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this.a, disposable);
        }

        @Override // io.reactivex.rxjava3.core.SingleEmitter
        public boolean tryOnError(Throwable th) {
            AtomicReference<Disposable> atomicReference = this.a;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = atomicReference.getAndSet(disposableHelper);
            if (andSet == disposableHelper) {
                return false;
            }
            this.downstream.onError(th);
            if (andSet == null) {
                return true;
            }
            andSet.dispose();
            return true;
        }
    }

    public j3(SingleOnSubscribe<T> singleOnSubscribe) {
        this.b = singleOnSubscribe;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            this.b.subscribe(aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
