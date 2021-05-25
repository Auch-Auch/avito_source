package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;
import r6.a.a.d.s.d;
public final class b<T> extends ConnectableFlowable<T> {
    public final ConnectableFlowable<T> b;
    public final PlainConsumer<ProtocolNonConformanceException> c;

    public b(ConnectableFlowable<T> connectableFlowable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.b = connectableFlowable;
        this.c = plainConsumer;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        this.b.connect(consumer);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new d.a(subscriber, this.c));
    }
}
