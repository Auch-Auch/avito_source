package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class u<T, R> implements Function<Long, CompletableSource> {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ LocalMessage b;
    public final /* synthetic */ Scheduler c;
    public final /* synthetic */ MessageSendingTracker d;

    public u(PendingMessageHandlerImpl pendingMessageHandlerImpl, LocalMessage localMessage, Scheduler scheduler, MessageSendingTracker messageSendingTracker) {
        this.a = pendingMessageHandlerImpl;
        this.b = localMessage;
        this.c = scheduler;
        this.d = messageSendingTracker;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return this.a.d.markMessagesAsFailed(d.listOf(this.b.localId)).subscribeOn(this.c).observeOn(this.c).doOnSubscribe(new s(this)).doFinally(new t(this));
    }
}
