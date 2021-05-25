package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH'¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00030\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\tH'¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\tH'¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u001d\u0010\u001eJ9\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030 2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\tH'¢\u0006\u0004\b!\u0010\"J#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\tH'¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0004H'¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\u00020*2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0017¢\u0006\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lru/avito/android/persistence/messenger/UserDao;", "", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/UserEntity;", "getAllUsers", "()Lio/reactivex/Observable;", "", "localUserId", "", "channelIds", "getUsersForChannels", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", "channelId", "getUsersForChannel", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "userIds", "Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "getUserLastActionTimes", "(Ljava/util/Collection;)Lio/reactivex/Observable;", "", "cutoffTime", "limitToIdsIn", "getIdsOfUsersWithLastActionTimeOlderOrEqualTo", "(JLjava/util/Collection;)Lio/reactivex/Observable;", ChannelContext.Item.USER_ID, "lastActionTime", "timeDiff", "Lio/reactivex/Completable;", "updateUserLastActionTime", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Completable;", "currentUserId", "Lio/reactivex/Single;", "getUsersExistedInDbFromGivenIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Single;", "users", "insertUsers", "(Ljava/util/Collection;)Ljava/util/List;", "user", "insertUser", "(Lru/avito/android/persistence/messenger/UserEntity;)J", "userIdAndLastActionTimes", "", "updateUserLastActionTimes", "(Ljava/util/Collection;)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class UserDao {
    @Query("\n        SELECT * FROM user\n    ")
    @NotNull
    public abstract Observable<List<UserEntity>> getAllUsers();

    @Query("\n            SELECT user_id\n            FROM user\n            WHERE \n                ((last_action_time IS NULL) OR\n                (last_action_time <= :cutoffTime)) AND\n                user_id IN (:limitToIdsIn)\n        ")
    @NotNull
    public abstract Observable<List<String>> getIdsOfUsersWithLastActionTimeOlderOrEqualTo(long j, @NotNull Collection<String> collection);

    @Query("\n            SELECT user_id, MAX(last_action_time)\n            FROM user\n            WHERE user_id IN (:userIds)\n            GROUP BY user_id\n        ")
    @NotNull
    public abstract Observable<List<UserIdAndLastActionTime>> getUserLastActionTimes(@NotNull Collection<String> collection);

    @Query("\n            SELECT * \n            FROM user\n            WHERE user_id IN (:userIds) \n            AND channel_id = :channelId\n            AND local_user_id = :currentUserId\n        ")
    @NotNull
    public abstract Single<List<UserEntity>> getUsersExistedInDbFromGivenIds(@NotNull String str, @NotNull String str2, @NotNull Collection<String> collection);

    @Query("\n            SELECT user.* \n            FROM user\n            WHERE\n                user.local_user_id = :localUserId\n                AND user.channel_id = :channelId\n        ")
    @NotNull
    public abstract Observable<List<UserEntity>> getUsersForChannel(@NotNull String str, @NotNull String str2);

    @Query("\n        SELECT * FROM user\n        WHERE\n            local_user_id = :localUserId\n            AND channel_id IN (:channelIds)\n    ")
    @NotNull
    public abstract Observable<List<UserEntity>> getUsersForChannels(@NotNull String str, @NotNull Collection<String> collection);

    @Insert(onConflict = 1)
    public abstract long insertUser(@NotNull UserEntity userEntity);

    @Insert(onConflict = 1)
    @NotNull
    public abstract List<Long> insertUsers(@NotNull Collection<UserEntity> collection);

    @Query("\n            UPDATE user\n                SET last_action_time = :lastActionTime,\n                    time_diff = :timeDiff\n            WHERE user_id = :userId\n        ")
    @NotNull
    public abstract Completable updateUserLastActionTime(@NotNull String str, @Nullable Long l, @Nullable Long l2);

    @Transaction
    public void updateUserLastActionTimes(@NotNull Collection<UserIdAndLastActionTime> collection) {
        Intrinsics.checkNotNullParameter(collection, "userIdAndLastActionTimes");
        for (T t : collection) {
            updateUserLastActionTime(t.component1(), t.component2(), t.component3()).blockingAwait();
        }
    }
}
