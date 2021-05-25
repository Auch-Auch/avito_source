package com.avito.android.messenger.service;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import ru.avito.messenger.api.entity.event.ReadMessageEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "event", "", "test", "(Ljava/lang/Object;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UnreadChatsCounterSyncAgentImpl$handleEvents$1<T> implements Predicate<Object> {
    public final /* synthetic */ UnreadChatsCounterSyncAgentImpl a;
    public final /* synthetic */ String b;

    public UnreadChatsCounterSyncAgentImpl$handleEvents$1(UnreadChatsCounterSyncAgentImpl unreadChatsCounterSyncAgentImpl, String str) {
        this.a = unreadChatsCounterSyncAgentImpl;
        this.b = str;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        String str = this.b;
        if (obj instanceof ChatMessage) {
            return true ^ Intrinsics.areEqual(((ChatMessage) obj).getFromId(), str);
        }
        if (!(obj instanceof ReadChatEvent) && !(obj instanceof ReadMessageEvent) && !(obj instanceof ChatClearEvent) && !(obj instanceof BlacklistInfo) && !(obj instanceof BlacklistRemoveEvent)) {
            return false;
        }
        return true;
    }
}
