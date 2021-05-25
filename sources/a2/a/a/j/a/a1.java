package a2.a.a.j.a;

import com.avito.android.app.task.SendPendingMessagesTask;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a1<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ SendPendingMessagesTask a;
    public final /* synthetic */ Scheduler b;

    public a1(SendPendingMessagesTask sendPendingMessagesTask, Scheduler scheduler) {
        this.a = sendPendingMessagesTask;
        this.b = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "isForeground");
        if (bool2.booleanValue()) {
            return SendPendingMessagesTask.access$startForegroundHandling(this.a, this.b).doOnSubscribe(y0.a);
        }
        return Completable.fromAction(z0.a);
    }
}
