package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscriber;
import r6.a.a.d.d;
public final class f<T> extends ConnectableFlowable<T> {
    public final ConnectableFlowable<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public f(ConnectableFlowable<T> connectableFlowable) {
        this.b = connectableFlowable;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        this.b.connect(consumer);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe((FlowableSubscriber) new d.a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe((FlowableSubscriber) new d.b(subscriber, this.c));
        }
    }
}
