package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import r6.a.b.e.d;
public final class o<T> extends ParallelFlowable<T> {
    public final ParallelFlowable<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public o(ParallelFlowable<T> parallelFlowable) {
        this.a = parallelFlowable;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
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
