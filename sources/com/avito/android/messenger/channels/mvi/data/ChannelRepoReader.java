package com.avito.android.messenger.channels.mvi.data;

import arrow.core.Option;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\fJ#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\bJU\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00150\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u001a\u0010\u001bJO\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u001f\u0010 JO\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b\u001f\u0010#JG\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b%\u0010&JG\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H&¢\u0006\u0004\b'\u0010\u0018J+\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "", "", ChannelContext.Item.USER_ID, "Lio/reactivex/Observable;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "getAllChannels", "(Ljava/lang/String;)Lio/reactivex/Observable;", "channelId", "Larrow/core/Option;", "getChannel", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "itemId", "getChannelIdByItemId", "getAvitoChannelId", "", "timestamp", "", "tags", "excludeTags", "Lkotlin/Pair;", "Lru/avito/android/persistence/messenger/DraftEntity;", "getChannelsAndDraftsStartingFromTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "channelIds", "getBareChannels", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", "", "offset", "limit", "getNonEmptyChannelIds", "(Ljava/lang/String;IILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "olderOrEqualToTimestamp", "newerOrEqualToTimestamp", "(Ljava/lang/String;JJLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", VKApiConst.POSITION, "getTimestampOfNonEmptyChannelAtPosition", "(Ljava/lang/String;ILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "getEmptyChannelsNewerThanTimestamp", "getIdsOfEmptyChannelsOlderThanTimestamp", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelRepoReader {
    @NotNull
    Observable<List<Channel>> getAllChannels(@NotNull String str);

    @NotNull
    Observable<Option<String>> getAvitoChannelId(@NotNull String str);

    @NotNull
    Observable<List<Channel>> getBareChannels(@NotNull String str, @NotNull Collection<String> collection);

    @NotNull
    Observable<Option<Channel>> getChannel(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Option<String>> getChannelIdByItemId(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<Pair<Channel, DraftEntity>>> getChannelsAndDraftsStartingFromTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Observable<List<Channel>> getEmptyChannelsNewerThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Observable<List<String>> getIdsOfEmptyChannelsOlderThanTimestamp(@NotNull String str, long j);

    @NotNull
    Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, int i, int i2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, long j, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Observable<Option<Long>> getTimestampOfNonEmptyChannelAtPosition(@NotNull String str, int i, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);
}
