package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class q<T> extends Flowable<Long> implements FlowableTransformer<T, Long> {
    public final Flowable<T> b;
    public final Predicate<? super T> c;

    public static final class a<T> extends DeferredScalarSubscriber<T, Long> {
        private static final long serialVersionUID = 4809092721669178986L;
        public final Predicate<? super T> a;
        public long b;
        public boolean c;

        public a(Subscriber<? super Long> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.a = predicate;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: r6.a.b.i.q$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.c) {
                complete(-1L);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: r6.a.b.i.q$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                long j = this.b;
                if (this.a.test(t)) {
                    this.c = true;
                    this.upstream.cancel();
                    complete(Long.valueOf(j));
                    return;
                }
                this.b = j + 1;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c = true;
                this.upstream.cancel();
                onError(th);
            }
        }
    }

    public q(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.b = flowable;
        this.c = predicate;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<Long> apply(Flowable<T> flowable) {
        return new q(flowable, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c));
    }
}
