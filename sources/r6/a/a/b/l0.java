package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
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
                th2 = (Throwable) ObjectHelper.requireNonNull(this.c.apply(th), "The mapper returned a null Throwable");
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th, th3);
            }
            this.a.onError(th2);
        }
    }

    public l0(Nono nono, Function<? super Throwable, ? extends Throwable> function) {
        this.b = nono;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
