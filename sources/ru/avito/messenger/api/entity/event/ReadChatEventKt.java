package ru.avito.messenger.api.entity.event;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/avito/messenger/api/entity/event/ReadChatEvent;", "", ChannelContext.Item.USER_ID, "", "isMyOwn", "(Lru/avito/messenger/api/entity/event/ReadChatEvent;Ljava/lang/String;)Z", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ReadChatEventKt {
    public static final boolean isMyOwn(@NotNull ReadChatEvent readChatEvent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(readChatEvent, "$this$isMyOwn");
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return Intrinsics.areEqual(readChatEvent.getFromId(), str);
    }
}
