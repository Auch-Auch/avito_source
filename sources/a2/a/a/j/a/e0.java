package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
public final class e0<T, R> implements Function<LocalMessage, CompletableSource> {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ MessageSendingTracker b;
    public final /* synthetic */ AtomicInteger c;

    public e0(PendingMessageHandlerImpl pendingMessageHandlerImpl, MessageSendingTracker messageSendingTracker, AtomicInteger atomicInteger) {
        this.a = pendingMessageHandlerImpl;
        this.b = messageSendingTracker;
        this.c = atomicInteger;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        Intrinsics.checkNotNullParameter(localMessage2, "sentMessage");
        return this.a.d.updateMessage(localMessage2).doFinally(new d0(this, localMessage2));
    }
}
