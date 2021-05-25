package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lru/avito/messenger/api/entity/ChatMessage;", "kotlin.jvm.PlatformType", "message", "", "accept", "(Lru/avito/messenger/api/entity/ChatMessage;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToStopTypingEvents$2<T> implements Consumer<ChatMessage> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$subscribeToStopTypingEvents$2(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final void accept(ChatMessage chatMessage) {
        this.a.getReducerQueue().plusAssign(new ChannelContextInteractorImpl.ChatTypingStopMutator(this.a, chatMessage.getFromId()));
    }
}
