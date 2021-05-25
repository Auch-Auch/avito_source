package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import r6.a.b.b.u4;
public final class c3<T, R> extends Perhaps<T> {
    public final Supplier<R> b;
    public final Function<? super R, ? extends Perhaps<? extends T>> c;
    public final Consumer<? super R> d;
    public final boolean e;

    public c3(Supplier<R> supplier, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer, boolean z) {
        this.b = supplier;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            R r = this.b.get();
            try {
                Perhaps perhaps = (Perhaps) this.c.apply(r);
                Objects.requireNonNull(perhaps, "The sourceSupplier returned a null Nono");
                perhaps.subscribe(new u4.a(subscriber, r, this.d, this.e));
                return;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                return;
            }
            EmptySubscription.error(th, subscriber);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
