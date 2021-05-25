package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class z extends Nono implements Supplier<Void> {
    public final Supplier<? extends Throwable> b;

    public z(Supplier<? extends Throwable> supplier) {
        this.b = supplier;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Supplier
    public Void get() throws Throwable {
        try {
            Throwable th = (Throwable) this.b.get();
            Objects.requireNonNull(th, "The errorSupplier returned a null Throwable");
            throw th;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            throw th2;
        }
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
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
