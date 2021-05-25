package r6.a.b.c;

import io.reactivex.Flowable;
import io.reactivex.rxjava3.core.FlowableConverter;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscriber;
public final class g<T> extends Flowable<T> implements FlowableConverter<T, Flowable<T>> {
    public static final g<Object> c = new g<>(null);
    public final io.reactivex.rxjava3.core.Flowable<T> b;

    public g(io.reactivex.rxjava3.core.Flowable<T> flowable) {
        this.b = flowable;
    }

    @Override // io.reactivex.rxjava3.core.FlowableConverter
    public Object apply(io.reactivex.rxjava3.core.Flowable flowable) {
        return new g(flowable);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new e(subscriber));
    }
}
