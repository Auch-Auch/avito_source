package ru.avito.messenger.api.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.event.UserChatEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/api/entity/ChatMessageUpdate;", "Lru/avito/messenger/api/entity/event/UserChatEvent;", "", "getChannelId", "()Ljava/lang/String;", "channelId", "getFromId", "fromId", "Lru/avito/messenger/api/entity/ChatMessage;", "message", "Lru/avito/messenger/api/entity/ChatMessage;", "getMessage", "()Lru/avito/messenger/api/entity/ChatMessage;", "<init>", "(Lru/avito/messenger/api/entity/ChatMessage;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatMessageUpdate implements UserChatEvent {
    @NotNull
    public final ChatMessage message;

    public ChatMessageUpdate(@NotNull ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(chatMessage, "message");
        this.message = chatMessage;
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent, ru.avito.messenger.api.entity.event.ChatEvent
    @NotNull
    public String getChannelId() {
        return this.message.getChannelId();
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent
    @NotNull
    public String getFromId() {
        return this.message.getFromId();
    }

    @NotNull
    public final ChatMessage getMessage() {
        return this.message;
    }
}
