package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class s0 extends Nono {
    public final Nono b;
    public final Function<? super Throwable, ? extends Nono> c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = 5344018235737739066L;
        public final Subscriber<? super Void> a;
        public final Function<? super Throwable, ? extends Nono> b;
        public boolean c;

        public a(Subscriber<? super Void> subscriber, Function<? super Throwable, ? extends Nono> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.c) {
                this.c = true;
                try {
                    ((Nono) this.b.apply(th)).subscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(new CompositeException(th, th2));
                }
            } else {
                this.a.onError(th);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.replace(this, subscription);
            if (!this.c) {
                this.a.onSubscribe(this);
            }
        }
    }

    public s0(Nono nono, Function<? super Throwable, ? extends Nono> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
