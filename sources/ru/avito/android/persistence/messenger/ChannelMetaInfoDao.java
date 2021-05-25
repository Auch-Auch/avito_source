package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005H'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H'¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lru/avito/android/persistence/messenger/ChannelMetaInfo;", "getChannelMetaInfo", "(Ljava/lang/String;Ljava/lang/String;)Lru/avito/android/persistence/messenger/ChannelMetaInfo;", "", "getLastSyncedMessageTimestamp", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "timestamp", "", "updateLastSyncedMessageTimestamp", "(Ljava/lang/String;Ljava/lang/String;J)I", "channelMeta", "createChannelMetaInfo", "(Lru/avito/android/persistence/messenger/ChannelMetaInfo;)J", "updateChannelMetaInfo", "(Lru/avito/android/persistence/messenger/ChannelMetaInfo;)I", "deleteChannelMetaInfo", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelMetaInfoDao {
    @Insert(onConflict = 1)
    long createChannelMetaInfo(@NotNull ChannelMetaInfo channelMetaInfo);

    @Delete
    int deleteChannelMetaInfo(@NotNull ChannelMetaInfo channelMetaInfo);

    @Query("\n        select * from channel_meta_data\n        where\n            local_user_id = :userId\n            and channel_id = :channelId\n    ")
    @Nullable
    ChannelMetaInfo getChannelMetaInfo(@NotNull String str, @NotNull String str2);

    @Query("\n        select last_synced_message_timestamp from channel_meta_data\n        where\n            local_user_id = :userId\n            and channel_id = :channelId\n    ")
    @Nullable
    Long getLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2);

    @Update(onConflict = 1)
    int updateChannelMetaInfo(@NotNull ChannelMetaInfo channelMetaInfo);

    @Query("\n            update channel_meta_data\n            set\n                last_synced_message_timestamp = :timestamp\n            where\n                local_user_id = :userId\n                and channel_id = :channelId\n        ")
    int updateLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2, long j);
}
