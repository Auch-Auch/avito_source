package r6.a.b.e.s;

import hu.akarnokd.rxjava3.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava3.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava3.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava3.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava3.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava3.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava3.functions.PlainConsumer;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
public final class a extends Completable {
    public final Completable a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    /* renamed from: r6.a.b.e.s.a$a  reason: collision with other inner class name */
    public static final class C0637a implements CompletableObserver, Disposable {
        public final CompletableObserver a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Disposable c;
        public boolean d;

        public C0637a(CompletableObserver completableObserver, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = completableObserver;
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new C0637a(completableObserver, this.b));
    }
}
