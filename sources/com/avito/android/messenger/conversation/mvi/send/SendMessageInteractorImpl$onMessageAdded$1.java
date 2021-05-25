package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "kotlin.jvm.PlatformType", "it", "", "accept", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SendMessageInteractorImpl$onMessageAdded$1<T> implements Consumer<LocalMessage> {
    public final /* synthetic */ SendMessageInteractorImpl a;

    public SendMessageInteractorImpl$onMessageAdded$1(SendMessageInteractorImpl sendMessageInteractorImpl) {
        this.a = sendMessageInteractorImpl;
    }

    public final void accept(LocalMessage localMessage) {
        this.a.getMessageSendAttemptsStream().accept(Unit.INSTANCE);
    }
}
