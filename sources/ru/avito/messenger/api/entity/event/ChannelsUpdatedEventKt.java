package ru.avito.messenger.api.entity.event;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;", "", "", "getUpdatedChannelIds", "(Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;)Ljava/util/Set;", "updatedChannelIds", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelsUpdatedEventKt {
    @NotNull
    public static final Set<String> getUpdatedChannelIds(@NotNull ChannelsUpdatedEvent channelsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(channelsUpdatedEvent, "$this$updatedChannelIds");
        return channelsUpdatedEvent.channels.keySet();
    }
}
