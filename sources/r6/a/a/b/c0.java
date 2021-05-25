package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
public final class c0 extends Nono {
    public final CompletableSource b;

    public static final class a extends a implements CompletableObserver {
        public final Subscriber<? super Void> a;
        public Disposable b;

        public a(Subscriber<? super Void> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.dispose();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public c0(CompletableSource completableSource) {
        this.b = completableSource;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
