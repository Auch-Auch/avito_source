package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.ChannelTag;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "", "", ChannelContext.Item.USER_ID, "Lcom/avito/android/remote/model/messenger/Channel;", "channel", "Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "toChannelDbEntities", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "Lcom/avito/android/messenger/channels/mvi/data/ChannelsDbEntities;", "toChannelsDbEntities", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/messenger/channels/mvi/data/ChannelsDbEntities;", "Lru/avito/android/persistence/messenger/ChannelEntity;", "channelEntity", "Lru/avito/android/persistence/messenger/UserEntity;", "users", "", "Lru/avito/android/persistence/messenger/ChannelTag;", "tags", "Lru/avito/android/persistence/messenger/MessageEntity;", "lastMessage", "toChannel", "(Lru/avito/android/persistence/messenger/ChannelEntity;Ljava/util/List;Ljava/util/Collection;Lru/avito/android/persistence/messenger/MessageEntity;)Lcom/avito/android/remote/model/messenger/Channel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelEntityConverter {
    @NotNull
    Channel toChannel(@NotNull ChannelEntity channelEntity, @NotNull List<UserEntity> list, @NotNull Collection<ChannelTag> collection, @Nullable MessageEntity messageEntity);

    @NotNull
    ChannelDbEntities toChannelDbEntities(@NotNull String str, @NotNull Channel channel);

    @NotNull
    ChannelsDbEntities toChannelsDbEntities(@NotNull String str, @NotNull List<Channel> list);
}
