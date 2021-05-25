package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.processors.AsyncProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class b<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final AsyncProcessor<T> c = AsyncProcessor.create();
    public final AtomicBoolean d = new AtomicBoolean();

    public b(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new b(flowable);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.c.subscribe(subscriber);
        AtomicBoolean atomicBoolean = this.d;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            this.b.subscribe(this.c);
        }
    }
}
