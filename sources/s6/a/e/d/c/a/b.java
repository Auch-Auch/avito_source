package s6.a.e.d.c.a;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
public final class b<T> extends Flowable<T> {
    public final FlowableProcessor<T> b;
    public final AtomicBoolean c = new AtomicBoolean();

    public b(FlowableProcessor<T> flowableProcessor) {
        this.b = flowableProcessor;
    }

    public boolean f() {
        return !this.c.get() && this.c.compareAndSet(false, true);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
        this.c.set(true);
    }
}
