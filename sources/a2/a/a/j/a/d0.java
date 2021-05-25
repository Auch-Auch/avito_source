package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class d0 implements Action {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ LocalMessage b;

    public d0(e0 e0Var, LocalMessage localMessage) {
        this.a = e0Var;
        this.b = localMessage;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        e0 e0Var = this.a;
        PendingMessageHandlerImpl pendingMessageHandlerImpl = e0Var.a;
        MessageSendingTracker messageSendingTracker = e0Var.b;
        LocalMessage localMessage = this.b;
        Intrinsics.checkNotNullExpressionValue(localMessage, "sentMessage");
        PendingMessageHandlerImpl.access$trackSendingSuccess(pendingMessageHandlerImpl, messageSendingTracker, localMessage, this.a.c.get());
    }
}
