package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
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

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(this.a.appendLast(th));
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
            if (queueSubscription == null) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            this.sourceMode = requestFusion;
            return requestFusion;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            return this.downstream.tryOnNext(t);
        }
    }

    public static final class b<T> extends BasicFuseableSubscriber<T, T> {
        public final RxJavaAssemblyException a;

        public b(Subscriber<? super T> subscriber, RxJavaAssemblyException rxJavaAssemblyException) {
            super(subscriber);
            this.a = rxJavaAssemblyException;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(this.a.appendLast(th));
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

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new b(subscriber, this.c));
        }
    }
}
