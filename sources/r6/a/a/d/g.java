package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.ScalarCallable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import r6.a.a.d.d;
public final class g<T> extends Flowable<T> implements ScalarCallable<T> {
    public final Publisher<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public g(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return (T) ((ScalarCallable) this.b).call();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new d.a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new d.b(subscriber, this.c));
        }
    }
}
