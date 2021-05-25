package org.reactivestreams;

import java.util.Objects;
import java.util.concurrent.Flow;
public final class FlowAdapters {

    public static final class a<T> implements Flow.Publisher<T> {
        public final Publisher<? extends T> a;
    }

    public static final class b<T, U> implements Flow.Processor<T, U> {
        public final Processor<? super T, ? extends U> a;
    }

    public static final class c<T> implements Flow.Subscriber<T> {
        public final Subscriber<? super T> a;

        public c(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }
    }

    public static final class d implements Flow.Subscription {
        public final Subscription a;

        public d(Subscription subscription) {
            this.a = subscription;
        }
    }

    public static final class e<T> implements Publisher<T> {
        public final Flow.Publisher<? extends T> a;

        public e(Flow.Publisher<? extends T> publisher) {
            this.a = publisher;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            this.a.subscribe(subscriber == null ? null : new c(subscriber));
        }
    }

    public static final class f<T, U> implements Processor<T, U> {
        public final Flow.Processor<? super T, ? extends U> a;

        public f(Flow.Processor<? super T, ? extends U> processor) {
            this.a = processor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.a.onSubscribe(subscription == null ? null : new d(subscription));
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super U> subscriber) {
            this.a.subscribe(subscriber == null ? null : new c(subscriber));
        }
    }

    public static final class g<T> implements Subscriber<T> {
        public final Flow.Subscriber<? super T> a;

        public g(Flow.Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.a.onSubscribe(subscription == null ? null : new d(subscription));
        }
    }

    public FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flow.Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> processor) {
        throw null;
    }

    public static <T> Flow.Publisher<T> toFlowPublisher(Publisher<? extends T> publisher) {
        throw null;
    }

    public static <T> Flow.Subscriber<T> toFlowSubscriber(Subscriber<T> subscriber) {
        throw null;
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Processor<? super T, ? extends U>, org.reactivestreams.Processor<T, U> */
    public static <T, U> Processor<T, U> toProcessor(Flow.Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "flowProcessor");
        if (processor instanceof b) {
            return (Processor<? super T, ? extends U>) ((b) processor).a;
        }
        if (processor instanceof Processor) {
            return (Processor) processor;
        }
        return new f(processor);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Publisher<? extends T>, org.reactivestreams.Publisher<T> */
    public static <T> Publisher<T> toPublisher(Flow.Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "flowPublisher");
        if (publisher instanceof a) {
            return (Publisher<? extends T>) ((a) publisher).a;
        }
        if (publisher instanceof Publisher) {
            return (Publisher) publisher;
        }
        return new e(publisher);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Subscriber<? super T>, org.reactivestreams.Subscriber<T> */
    public static <T> Subscriber<T> toSubscriber(Flow.Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "flowSubscriber");
        if (subscriber instanceof c) {
            return (Subscriber<? super T>) ((c) subscriber).a;
        }
        if (subscriber instanceof Subscriber) {
            return (Subscriber) subscriber;
        }
        return new g(subscriber);
    }
}
