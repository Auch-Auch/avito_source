package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
public final class v1<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Predicate<? super T> c;

    public static final class a<T> extends BasicFuseableSubscriber<T, T> {
        public final Predicate<? super T> a;

        public a(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.a = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                try {
                    if (!this.a.test(t)) {
                        return;
                    }
                } catch (Throwable th) {
                    fail(th);
                    return;
                }
            }
            this.actual.onNext(t);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null || this.a.test(poll)) {
                return poll;
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public v1(Perhaps<T> perhaps, Predicate<? super T> predicate) {
        this.b = perhaps;
        this.c = predicate;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
