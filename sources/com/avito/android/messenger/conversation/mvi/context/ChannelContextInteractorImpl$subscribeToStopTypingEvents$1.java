package com.avito.android.messenger.conversation.mvi.context;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "currentUserId", "Lio/reactivex/ObservableSource;", "Lru/avito/messenger/api/entity/ChatMessage;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/String;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToStopTypingEvents$1<T, R> implements Function<String, ObservableSource<? extends ChatMessage>> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$subscribeToStopTypingEvents$1(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final ObservableSource<? extends ChatMessage> apply(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        return this.a.y.observeMessages().filter(new Predicate<ChatMessage>(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToStopTypingEvents$1.1
            public final /* synthetic */ ChannelContextInteractorImpl$subscribeToStopTypingEvents$1 a;

            {
                this.a = r1;
            }

            public final boolean test(@NotNull ChatMessage chatMessage) {
                Intrinsics.checkNotNullParameter(chatMessage, "message");
                return Intrinsics.areEqual(chatMessage.getChannelId(), this.a.a.w) && (Intrinsics.areEqual(chatMessage.getFromId(), str) ^ true);
            }
        });
    }
}
