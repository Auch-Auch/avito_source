package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import r6.a.a.d.d;
public final class e<T> extends Flowable<T> implements Callable<T> {
    public final Publisher<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public e(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        try {
            return (T) ((Callable) this.b).call();
        } catch (Exception e) {
            Exceptions.throwIfFatal(e);
            throw ((Exception) this.c.appendLast(e));
        }
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
