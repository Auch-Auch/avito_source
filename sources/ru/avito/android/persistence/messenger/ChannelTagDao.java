package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\nH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelTagDao;", "", "", "localUserId", "channelId", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/ChannelTag;", "getChannelTags", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "channelIds", "getChannelsTags", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", "channelTags", "Lio/reactivex/Completable;", "deleteChannelTags", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelTagDao {
    @Delete
    @NotNull
    Completable deleteChannelTags(@NotNull Collection<ChannelTag> collection);

    @Query("\n            SELECT * FROM channel_tag\n            WHERE \n                local_user_id = :localUserId \n                AND channel_id = :channelId\n        ")
    @NotNull
    Observable<List<ChannelTag>> getChannelTags(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT * FROM channel_tag\n            WHERE \n                local_user_id = :localUserId \n                AND channel_id IN (:channelIds)\n        ")
    @NotNull
    Observable<List<ChannelTag>> getChannelsTags(@NotNull String str, @NotNull Collection<String> collection);
}
