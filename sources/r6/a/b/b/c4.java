package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class c4<T, R> extends Solo<R> {
    public final Solo<T> b;
    public final Function<? super T, ? extends R> c;

    public static final class a<T, R> extends BasicFuseableSubscriber<T, R> {
        public final Function<? super T, ? extends R> a;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                try {
                    Object apply = this.a.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            } else {
                this.downstream.onNext(null);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) this.a.apply(poll);
            Objects.requireNonNull(r, "The mapper returned a null value");
            return r;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public c4(Solo<T> solo, Function<? super T, ? extends R> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
