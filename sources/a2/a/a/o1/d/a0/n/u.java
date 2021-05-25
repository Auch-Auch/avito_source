package a2.a.a.o1.d.a0.n;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class u implements Action {
    public final /* synthetic */ ChatMessage a;

    public u(ChatMessage chatMessage) {
        this.a = chatMessage;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        StringBuilder sb = new StringBuilder();
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        sb.append(I.toString());
        sb.append(" Message saved to database: ");
        sb.append("channelId=");
        sb.append(this.a.getChannelId());
        sb.append(", remoteId=");
        sb.append(this.a.getId());
        Logs.verbose$default("MessageSyncAgent", sb.toString(), null, 4, null);
    }
}
