package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: org.reactivestreams.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                try {
                    this.actual.onNext(ObjectHelper.requireNonNull(this.a.apply(t), "The mapper returned a null value"));
                } catch (Throwable th) {
                    fail(th);
                }
            } else {
                this.actual.onNext(null);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (R) ObjectHelper.requireNonNull(this.a.apply(poll), "The mapper returned a null value");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public c4(Solo<T> solo, Function<? super T, ? extends R> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
