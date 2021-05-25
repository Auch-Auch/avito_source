package com.avito.android.messenger.channels.mvi.interactor;

import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "p1", "Lio/reactivex/Completable;", "invoke", "(Lru/avito/messenger/api/entity/event/ChatTypingEvent;)Lio/reactivex/Completable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelsListInteractorImpl$subscribeToChatTypingEvents$1 extends FunctionReferenceImpl implements Function1<ChatTypingEvent, Completable> {
    public ChannelsListInteractorImpl$subscribeToChatTypingEvents$1(ChannelsListInteractorImpl channelsListInteractorImpl) {
        super(1, channelsListInteractorImpl, ChannelsListInteractorImpl.class, "handleChatTypingEvent", "handleChatTypingEvent(Lru/avito/messenger/api/entity/event/ChatTypingEvent;)Lio/reactivex/Completable;", 0);
    }

    @NotNull
    public final Completable invoke(@NotNull ChatTypingEvent chatTypingEvent) {
        Intrinsics.checkNotNullParameter(chatTypingEvent, "p1");
        return ChannelsListInteractorImpl.access$handleChatTypingEvent((ChannelsListInteractorImpl) this.receiver, chatTypingEvent);
    }
}
