package a2.a.a.f1.f;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class p<T, R> implements Function<Throwable, Publisher<? extends Unit>> {
    public final /* synthetic */ q a;

    public p(q qVar) {
        this.a = qVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Publisher<? extends Unit> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        if (th2 instanceof IOException) {
            return Flowable.just(Unit.INSTANCE).delay(3000, TimeUnit.MILLISECONDS, this.a.a.e.computation());
        }
        return Flowable.error(th2);
    }
}
