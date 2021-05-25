package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Action;
public final class i0 implements Action {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ MessageSendingTracker b;
    public final /* synthetic */ LocalMessage c;

    public i0(PendingMessageHandlerImpl pendingMessageHandlerImpl, MessageSendingTracker messageSendingTracker, LocalMessage localMessage) {
        this.a = pendingMessageHandlerImpl;
        this.b = messageSendingTracker;
        this.c = localMessage;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.a(this.b, this.c, 0, null);
    }
}
