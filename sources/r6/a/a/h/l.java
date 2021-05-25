package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class l<T> extends Flowable<Long> implements FlowableTransformer<T, Long> {
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

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: r6.a.a.h.l$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.c) {
                complete(-1L);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: r6.a.a.h.l$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                long j = this.b;
                if (this.a.test(t)) {
                    this.c = true;
                    this.s.cancel();
                    complete(Long.valueOf(j));
                    return;
                }
                this.b = j + 1;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.c = true;
                this.s.cancel();
                onError(th);
            }
        }
    }

    public l(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.b = flowable;
        this.c = predicate;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<Long> apply(Flowable<T> flowable) {
        return new l(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c));
    }
}
