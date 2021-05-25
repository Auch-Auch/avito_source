package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import r6.a.b.e.d;
public final class f<T> extends Flowable<T> implements ScalarSupplier<T> {
    public final Publisher<T> b;
    public final RxJavaAssemblyException c = new RxJavaAssemblyException();

    public f(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.ScalarSupplier, io.reactivex.rxjava3.functions.Supplier
    public T get() {
        return (T) ((ScalarSupplier) this.b).get();
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
