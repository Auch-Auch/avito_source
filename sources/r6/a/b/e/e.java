package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import r6.a.b.e.d;
public final class e<T> extends ConnectableFlowable<T> {
    public final ConnectableFlowable<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public e(ConnectableFlowable<T> connectableFlowable) {
        this.b = connectableFlowable;
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
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe((FlowableSubscriber) new d.a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe((FlowableSubscriber) new d.b(subscriber, this.c));
        }
    }
}
