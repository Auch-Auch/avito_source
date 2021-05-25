package a2.a.a.j.a;

import com.avito.android.MessengerWorkFactory;
import com.avito.android.app.task.SendPendingMessagesTask;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
public final class x0<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ SendPendingMessagesTask a;
    public final /* synthetic */ AtomicBoolean b;

    public x0(SendPendingMessagesTask sendPendingMessagesTask, AtomicBoolean atomicBoolean) {
        this.a = sendPendingMessagesTask;
        this.b = atomicBoolean;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "isForeground");
        boolean compareAndSet = this.b.compareAndSet(true, false);
        if (bool2.booleanValue()) {
            return this.a.workFactory.cancelSendPendingMessagesWork().doOnComplete(w2.b).andThen(Single.just(bool2)).doOnError(k0.b).onErrorReturn(i.b);
        }
        if (compareAndSet) {
            return MessengerWorkFactory.DefaultImpls.enqueueSendPendingMessagesWork$default(this.a.workFactory, 0, false, 3, null).doOnComplete(w2.c).doOnError(k0.c).andThen(Single.just(bool2)).onErrorReturn(i.c);
        }
        return this.a.workFactory.enqueueSendPendingMessagesWork(30, true).doOnComplete(w2.d).delay(30, TimeUnit.SECONDS, this.a.schedulers.computation()).andThen(Single.just(bool2)).doOnError(k0.d).onErrorReturn(i.d);
    }
}
