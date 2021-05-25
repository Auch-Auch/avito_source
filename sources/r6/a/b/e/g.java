package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import r6.a.b.e.d;
public final class g<T> extends Flowable<T> implements Supplier<T> {
    public final Publisher<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public g(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        try {
            return (T) ((Supplier) this.b).get();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw this.c.appendLast(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new d.a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new d.b(subscriber, this.c));
        }
    }
}
