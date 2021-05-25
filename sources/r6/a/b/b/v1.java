package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
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
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null || this.a.test(poll)) {
                return poll;
            }
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public v1(Perhaps<T> perhaps, Predicate<? super T> predicate) {
        this.b = perhaps;
        this.c = predicate;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
