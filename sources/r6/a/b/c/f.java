package r6.a.b.c;

import io.reactivex.FlowableConverter;
import io.reactivex.FlowableSubscriber;
import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;
public final class f<T> extends Flowable<T> implements FlowableConverter<T, Flowable<T>> {
    public static final f<Object> c = new f<>(null);
    public final io.reactivex.Flowable<T> b;

    public f(io.reactivex.Flowable<T> flowable) {
        this.b = flowable;
    }

    @Override // io.reactivex.FlowableConverter
    public Object apply(io.reactivex.Flowable flowable) {
        return new f(flowable);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new e(subscriber));
    }
}
