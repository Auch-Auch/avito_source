package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava2.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava2.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnSuccessParameterException;
import hu.akarnokd.rxjava2.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava2.debug.validator.OnSuccessAfterTerminationException;
import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
public final class h<T> extends Single<T> {
    public final Single<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super T> a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Disposable c;
        public boolean d;

        public a(SingleObserver<? super T> singleObserver, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = singleObserver;
            this.b = plainConsumer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (th == null) {
                this.b.accept(new NullOnErrorParameterException());
            }
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException(th));
            }
            if (this.d) {
                this.b.accept(new MultipleTerminationsException(th));
                return;
            }
            this.d = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (disposable == null) {
                this.b.accept(new NullOnSubscribeParameterException());
            }
            if (this.c != null) {
                this.b.accept(new MultipleOnSubscribeCallsException());
            }
            this.c = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (t == null) {
                this.b.accept(new NullOnSuccessParameterException());
            }
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException());
            }
            if (this.d) {
                this.b.accept(new OnSuccessAfterTerminationException());
                return;
            }
            this.d = true;
            this.a.onSuccess(t);
        }
    }

    public h(Single<T> single, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = single;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }
}
