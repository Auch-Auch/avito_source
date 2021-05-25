package a2.a.a.j.a;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkType;
import com.avito.android.app.task.MessageSendingTracker;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.messenger.analytics.SendMessageAttemptEvent;
import com.avito.android.messenger.analytics.ServerConnectionType;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.MessengerState;
public final class c0<T> implements Consumer<Disposable> {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ MessageSendingTracker c;
    public final /* synthetic */ LocalMessage d;

    public c0(PendingMessageHandlerImpl pendingMessageHandlerImpl, AtomicInteger atomicInteger, MessageSendingTracker messageSendingTracker, LocalMessage localMessage) {
        this.a = pendingMessageHandlerImpl;
        this.b = atomicInteger;
        this.c = messageSendingTracker;
        this.d = localMessage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        MessageType messageType;
        ServerConnectionType serverConnectionType;
        PendingMessageHandlerImpl.access$trackSendingStart(this.a, this.c, this.d, this.b.incrementAndGet());
        PendingMessageHandlerImpl pendingMessageHandlerImpl = this.a;
        LocalMessage localMessage = this.d;
        String networkType = pendingMessageHandlerImpl.k.networkType();
        Analytics analytics = pendingMessageHandlerImpl.j;
        String str = localMessage.channelId;
        MessageBody messageBody = localMessage.body;
        if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item)) {
            messageType = MessageType.ITEM;
        } else if ((messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody)) {
            messageType = MessageType.IMAGE;
        } else if (messageBody instanceof MessageBody.Link) {
            messageType = MessageType.LINK;
        } else if (messageBody instanceof MessageBody.Location) {
            messageType = MessageType.GEO;
        } else if (messageBody instanceof MessageBody.Text.Regular) {
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
            if (((MessageBody.Text.Regular) messageBody).getSuggestedTemplates() != null) {
                messageType = MessageType.SUGGEST;
            } else {
                messageType = MessageType.TEXT;
            }
        } else if (messageBody instanceof MessageBody.File) {
            messageType = MessageType.FILE;
        } else if (!(messageBody instanceof MessageBody.Text.Reaction) && !(messageBody instanceof MessageBody.Call) && !(messageBody instanceof MessageBody.AppCall) && !(messageBody instanceof MessageBody.Deleted) && !(messageBody instanceof MessageBody.Unknown) && !(messageBody instanceof MessageBody.SystemMessageBody.Platform) && !(messageBody instanceof MessageBody.SystemMessageBody.Text) && !(messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
            throw new NoWhenBranchMatchedException();
        } else {
            messageType = MessageType.TEXT;
        }
        String str2 = localMessage.localId;
        boolean z = !Intrinsics.areEqual(networkType, NetworkType.CLASS_NONE.getStr());
        MessengerState blockingFirst = pendingMessageHandlerImpl.b.state().blockingFirst();
        if (Intrinsics.areEqual(blockingFirst, MessengerState.Connected.INSTANCE)) {
            serverConnectionType = ServerConnectionType.SOCKET;
        } else if (!(blockingFirst instanceof MessengerState.Connecting) && !(blockingFirst instanceof MessengerState.Disconnected)) {
            throw new NoWhenBranchMatchedException();
        } else {
            serverConnectionType = ServerConnectionType.NONE;
        }
        analytics.track(new SendMessageAttemptEvent(str, messageType, str2, z, networkType, serverConnectionType));
    }
}
