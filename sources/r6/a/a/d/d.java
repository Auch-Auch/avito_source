package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class d<T> extends Flowable<T> {
    public final Publisher<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public static final class a<T> extends BasicFuseableConditionalSubscriber<T, T> {
        public final RxJavaAssemblyException a;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, RxJavaAssemblyException rxJavaAssemblyException) {
            super(conditionalSubscriber);
            this.a = rxJavaAssemblyException;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(this.a.appendLast(th));
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
            if (queueSubscription == null) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            this.sourceMode = requestFusion;
            return requestFusion;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            return this.actual.tryOnNext(t);
        }
    }

    public static final class b<T> extends BasicFuseableSubscriber<T, T> {
        public final RxJavaAssemblyException a;

        public b(Subscriber<? super T> subscriber, RxJavaAssemblyException rxJavaAssemblyException) {
            super(subscriber);
            this.a = rxJavaAssemblyException;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(this.a.appendLast(th));
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
            if (queueSubscription == null) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            this.sourceMode = requestFusion;
            return requestFusion;
        }
    }

    public d(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new b(subscriber, this.c));
        }
    }
}
