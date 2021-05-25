package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
public final class l1<T> extends Perhaps<T> {
    public final MaybeOnSubscribe<T> b;

    public static final class a<T> extends DeferredScalarSubscription<T> implements MaybeEmitter<T> {
        private static final long serialVersionUID = -7149477775653368644L;
        public final AtomicReference<Disposable> a = new AtomicReference<>();

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.MaybeEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.a.get());
        }

        @Override // io.reactivex.MaybeEmitter
        public void onComplete() {
            AtomicReference<Disposable> atomicReference = this.a;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = atomicReference.getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.actual.onComplete();
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.MaybeEmitter
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

        @Override // io.reactivex.MaybeEmitter
        public void setCancellable(Cancellable cancellable) {
            DisposableHelper.set(this.a, new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.MaybeEmitter
        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this.a, disposable);
        }

        @Override // io.reactivex.MaybeEmitter
        public boolean tryOnError(Throwable th) {
            AtomicReference<Disposable> atomicReference = this.a;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = atomicReference.getAndSet(disposableHelper);
            if (andSet == disposableHelper) {
                return false;
            }
            this.actual.onError(th);
            if (andSet == null) {
                return true;
            }
            andSet.dispose();
            return true;
        }
    }

    public l1(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.b = maybeOnSubscribe;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            this.b.subscribe(aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!aVar.tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
