package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
public final class d4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Function<? super Throwable, ? extends Throwable> c;

    public static final class a<T> extends BasicFuseableSubscriber<T, T> {
        public final Function<? super Throwable, ? extends Throwable> a;

        public a(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Throwable> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Throwable th2;
            try {
                th2 = (Throwable) ObjectHelper.requireNonNull(this.a.apply(th), "The errorMapper returned a null Throwable");
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th, th3);
            }
            super.onError(th2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.qs.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                return queueSubscription.requestFusion(i);
            }
            return 0;
        }
    }

    public d4(Solo<T> solo, Function<? super Throwable, ? extends Throwable> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
