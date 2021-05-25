package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class l0 extends Nono {
    public final Nono b;
    public final Function<? super Throwable, ? extends Throwable> c;

    public static final class a extends c {
        public final Function<? super Throwable, ? extends Throwable> c;

        public a(Subscriber<? super Void> subscriber, Function<? super Throwable, ? extends Throwable> function) {
            super(subscriber);
            this.c = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Throwable th2;
            try {
                Throwable th3 = (Throwable) this.c.apply(th);
                Objects.requireNonNull(th3, "The mapper returned a null Throwable");
                th2 = th3;
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                th2 = new CompositeException(th, th4);
            }
            this.a.onError(th2);
        }
    }

    public l0(Nono nono, Function<? super Throwable, ? extends Throwable> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
