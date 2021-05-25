package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class g0<T, R> implements Function<Throwable, CompletableSource> {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ LocalMessage b;
    public final /* synthetic */ MessageSendingTracker c;
    public final /* synthetic */ AtomicInteger d;
    public final /* synthetic */ Scheduler e;

    public g0(PendingMessageHandlerImpl pendingMessageHandlerImpl, LocalMessage localMessage, MessageSendingTracker messageSendingTracker, AtomicInteger atomicInteger, Scheduler scheduler) {
        this.a = pendingMessageHandlerImpl;
        this.b = localMessage;
        this.c = messageSendingTracker;
        this.d = atomicInteger;
        this.e = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return this.a.d.markMessagesAsFailed(d.listOf(this.b.localId)).doFinally(new f0(this, th2)).subscribeOn(this.e);
    }
}
