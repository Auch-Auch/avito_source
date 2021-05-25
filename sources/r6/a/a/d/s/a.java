package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava2.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava2.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava2.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
public final class a extends Completable {
    public final Completable a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    /* renamed from: r6.a.a.d.s.a$a  reason: collision with other inner class name */
    public static final class C0585a implements CompletableObserver, Disposable {
        public final CompletableObserver a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Disposable c;
        public boolean d;

        public C0585a(CompletableObserver completableObserver, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = completableObserver;
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
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

        @Override // io.reactivex.CompletableObserver
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

        @Override // io.reactivex.CompletableObserver
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
    }

    public a(Completable completable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = completable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new C0585a(completableObserver, this.b));
    }
}
