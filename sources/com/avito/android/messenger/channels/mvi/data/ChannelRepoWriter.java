package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelTag;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0007J'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0014J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u0016\u0010\u0010J;\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ;\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H&¢\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010!\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019H&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Completable;", "setChannelIsRead", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChannelContextActions", "Lcom/avito/android/remote/model/messenger/Channel;", "channel", "putChannel", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)Lio/reactivex/Completable;", "", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "putChannels", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "deleteChannel", "interlocutorId", "itemId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "channelIds", "deleteChannelsById", "", "timestamp", "", "tags", "excludeTags", "deleteNonEmptyChannelsOlderThanTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Completable;", "deleteNonEmptyChannelsNewerThatTimestamp", "Lru/avito/android/persistence/messenger/ChannelTag;", "channelTags", "deleteChannelTags", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelRepoWriter {
    @NotNull
    Completable deleteChannel(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable deleteChannel(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable deleteChannelContextActions(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable deleteChannelTags(@NotNull Collection<ChannelTag> collection);

    @NotNull
    Completable deleteChannelsById(@NotNull String str, @NotNull List<String> list);

    @NotNull
    Completable deleteNonEmptyChannelsNewerThatTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Completable deleteNonEmptyChannelsOlderThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Completable putChannel(@NotNull String str, @NotNull Channel channel);

    @NotNull
    Completable putChannels(@NotNull String str, @NotNull List<Channel> list);

    @NotNull
    Completable setChannelIsRead(@NotNull String str, @NotNull String str2);
}
