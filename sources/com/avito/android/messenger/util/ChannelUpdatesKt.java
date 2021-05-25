package com.avito.android.messenger.util;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.event.ChannelUpdate;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a,\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/messenger/api/entity/event/ChannelUpdate;", "channelUpdate", "Lcom/avito/android/messenger/MessengerEntityConverter;", "converter", "", "mergeContextActions", "applyUpdate", "(Lcom/avito/android/remote/model/messenger/Channel;Lru/avito/messenger/api/entity/event/ChannelUpdate;Lcom/avito/android/messenger/MessengerEntityConverter;Z)Lcom/avito/android/remote/model/messenger/Channel;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelUpdatesKt {
    public static final PlatformActions access$mergeContextActions(ChannelUpdate channelUpdate, PlatformActions platformActions) {
        ChannelContextActions channelContextActions = channelUpdate.contextActions;
        if (channelContextActions == null) {
            return platformActions;
        }
        PlatformActions platformActions2 = null;
        if (!(channelContextActions instanceof PlatformActions)) {
            channelContextActions = null;
        }
        PlatformActions platformActions3 = (PlatformActions) channelContextActions;
        if (platformActions3 == null) {
            return platformActions;
        }
        Long version = platformActions3.getVersion();
        Long version2 = platformActions != null ? platformActions.getVersion() : null;
        if (version == null || version2 == null || version.longValue() > version2.longValue()) {
            platformActions2 = platformActions3;
        }
        return platformActions2 != null ? platformActions2 : platformActions;
    }

    public static final String access$mergeSuspectMessageId(ChannelUpdate channelUpdate, String str) {
        ChannelUpdate.Suspect suspect = channelUpdate.suspect;
        return suspect != null ? suspect.messageId : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011d  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.remote.model.messenger.Channel applyUpdate(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.messenger.Channel r30, @org.jetbrains.annotations.NotNull ru.avito.messenger.api.entity.event.ChannelUpdate r31, @org.jetbrains.annotations.NotNull com.avito.android.messenger.MessengerEntityConverter r32, boolean r33) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.util.ChannelUpdatesKt.applyUpdate(com.avito.android.remote.model.messenger.Channel, ru.avito.messenger.api.entity.event.ChannelUpdate, com.avito.android.messenger.MessengerEntityConverter, boolean):com.avito.android.remote.model.messenger.Channel");
    }
}
