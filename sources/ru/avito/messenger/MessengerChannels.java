package ru.avito.messenger;

import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.Channel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JI\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00110\t2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lru/avito/messenger/MessengerChannels;", "", "", "offset", "limit", "", "", "tags", "excludeTags", "Lio/reactivex/Single;", "", "Lru/avito/messenger/api/entity/Channel;", "getChannels", "(ILjava/lang/Integer;Ljava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Single;", "channelId", "getChannel", "(Ljava/lang/String;)Lio/reactivex/Single;", "", "folderWithTags", "getFoldersUnreadCounterByTags", "(Ljava/util/Map;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerChannels {
    @NotNull
    Single<Channel> getChannel(@NotNull String str);

    @NotNull
    Single<List<Channel>> getChannels(int i, @Nullable Integer num, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @NotNull
    Single<Map<String, Integer>> getFoldersUnreadCounterByTags(@NotNull Map<String, ? extends Collection<String>> map);
}
