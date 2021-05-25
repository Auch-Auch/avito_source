package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import r6.a.a.b.u4;
public final class c3<T, R> extends Perhaps<T> {
    public final Callable<R> b;
    public final Function<? super R, ? extends Perhaps<? extends T>> c;
    public final Consumer<? super R> d;
    public final boolean e;

    public c3(Callable<R> callable, Function<? super R, ? extends Perhaps<? extends T>> function, Consumer<? super R> consumer, boolean z) {
        this.b = callable;
        this.c = function;
        this.d = consumer;
        this.e = z;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            R call = this.b.call();
            try {
                ((Perhaps) ObjectHelper.requireNonNull(this.c.apply(call), "The sourceSupplier returned a null Nono")).subscribe(new u4.a(subscriber, call, this.d, this.e));
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
