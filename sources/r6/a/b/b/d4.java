package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
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

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Throwable th2;
            try {
                Throwable th3 = (Throwable) this.a.apply(th);
                Objects.requireNonNull(th3, "The errorMapper returned a null Throwable");
                th2 = th3;
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                th2 = new CompositeException(th, th4);
            }
            super.onError(th2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            return this.qs.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
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

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
