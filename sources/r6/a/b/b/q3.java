package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class q3<T> extends Solo<T> implements Supplier<T> {
    public final Supplier<? extends Throwable> b;

    public q3(Supplier<? extends Throwable> supplier) {
        this.b = supplier;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        Throwable th = (Throwable) this.b.get();
        Objects.requireNonNull(th, "The errorSupplier returned a null Throwable");
        throw th;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        try {
            Throwable th2 = (Throwable) this.b.get();
            Objects.requireNonNull(th2, "The errorSupplier returned a null Throwable");
            th = th2;
        } catch (Throwable th3) {
            th = th3;
            Exceptions.throwIfFatal(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
