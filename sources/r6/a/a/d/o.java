package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import r6.a.a.d.d;
public final class o<T> extends ParallelFlowable<T> {
    public final ParallelFlowable<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public o(ParallelFlowable<T> parallelFlowable) {
        this.a = parallelFlowable;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new d.a((ConditionalSubscriber) subscriber, this.b);
                } else {
                    subscriberArr2[i] = new d.b(subscriber, this.b);
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
