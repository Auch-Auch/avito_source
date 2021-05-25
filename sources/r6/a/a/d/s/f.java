package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava2.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava2.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnNextParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava2.debug.validator.OnNextAfterTerminationException;
import hu.akarnokd.rxjava2.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
public final class f<T> extends Observable<T> {
    public final Observable<T> a;
    public final PlainConsumer<ProtocolNonConformanceException> b;

    public static final class a<T> implements Observer<T>, Disposable {
        public final Observer<? super T> a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Disposable c;
        public boolean d;

        public a(Observer<? super T> observer, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = observer;
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

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (t == null) {
                this.b.accept(new NullOnNextParameterException());
            }
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException());
            }
            if (this.d) {
                this.b.accept(new OnNextAfterTerminationException());
            } else {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
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

    public f(Observable<T> observable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.a = observable;
        this.b = plainConsumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer, this.b));
    }
}
