package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.util.Logs;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class q<T, R> implements Function<Throwable, Publisher<Long>> {
    public final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Publisher<Long> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        int i = this.a.b.get();
        if (i >= 6 || (th2 instanceof NoRetryException)) {
            return Flowable.error(th2);
        }
        long j = 1 << i;
        StringBuilder O = a.O("Retry after ", j, " seconds: ");
        O.append(this.a.c.localId);
        Logs.verbose$default("PendingMessageHandler", O.toString(), null, 4, null);
        return Flowable.timer(j, TimeUnit.SECONDS, this.a.a.i.computation());
    }
}
