package r6.a.b.e.s;

import hu.akarnokd.rxjava3.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava3.functions.PlainConsumer;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import org.reactivestreams.Subscriber;
import r6.a.b.e.s.d;
public final class b<T> extends ConnectableFlowable<T> {
    public final ConnectableFlowable<T> b;
    public final PlainConsumer<ProtocolNonConformanceException> c;

    public b(ConnectableFlowable<T> connectableFlowable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.b = connectableFlowable;
        this.c = plainConsumer;
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        this.b.connect(consumer);
    }

    @Override // io.reactivex.rxjava3.flowables.ConnectableFlowable
    public void reset() {
        this.b.reset();
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new d.a(subscriber, this.c));
    }
}
