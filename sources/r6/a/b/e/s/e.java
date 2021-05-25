package r6.a.b.e.s;

import hu.akarnokd.rxjava3.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava3.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava3.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava3.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava3.debug.validator.NullOnSuccessParameterException;
import hu.akarnokd.rxjava3.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava3.debug.validator.OnSuccessAfterTerminationException;
import hu.akarnokd.rxjava3.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava3.functions.PlainConsumer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
public final class e<T> extends Maybe<T> {
    public final Maybe<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public static final class a<T> implements MaybeObserver<T>, Disposable {
        public final MaybeObserver<? super T> a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Disposable c;
        public boolean d;

        public a(MaybeObserver<? super T> maybeObserver, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = maybeObserver;
            this.b = plainConsumer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException());
            }
            if (this.d) {
                this.b.accept(new MultipleTerminationsException());
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
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

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
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

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
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

    public e(Maybe<T> maybe, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = maybe;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver, this.b));
    }
}
