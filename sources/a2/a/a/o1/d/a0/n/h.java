package a2.a.a.o1.d.a0.n;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.MessageSyncException;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.event.ChatEvent;
import t6.n.r;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ i a;
    public final /* synthetic */ ChatEvent b;

    public h(i iVar, ChatEvent chatEvent) {
        this.a = iVar;
        this.b = chatEvent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        MessengerErrorTracker messengerErrorTracker = this.a.a.a;
        MessageSyncException messageSyncException = new MessageSyncException("Event handling failed", th);
        MessageSyncAgentImpl messageSyncAgentImpl = this.a.a;
        ChatEvent chatEvent = this.b;
        Intrinsics.checkNotNullExpressionValue(chatEvent, "event");
        ErrorTracker.DefaultImpls.track$default(messengerErrorTracker, messageSyncException, null, r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, ChannelContext.Item.USER_ID), TuplesKt.to("eventType", MessageSyncAgentImpl.access$getType$p(messageSyncAgentImpl, chatEvent))), 2, null);
    }
}
