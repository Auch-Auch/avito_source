package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ9\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\bH'¢\u0006\u0004\b\u001f\u0010 J7\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "", "", "localUserId", "channelId", "localMessageId", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "getMessageMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "localMessageIds", "getMetaInfoForMessages", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "", "progressInBytes", "Lru/avito/android/persistence/messenger/TransferStatus;", "transferStatus", "Lio/reactivex/Completable;", "updateProgressAndStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/TransferStatus;)Lio/reactivex/Completable;", "internalPath", "updateProgressAndStatusAndInternalPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/TransferStatus;Ljava/lang/String;)Lio/reactivex/Completable;", "updateInternalPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", MessageMetaInfo.COLUMN_PATH, "updateProgressAndStatusAndPath", "messageMetaInfo", "insertOrReplace", "(Lru/avito/android/persistence/messenger/MessageMetaInfo;)Lio/reactivex/Completable;", "insertIfDoesNotExist", "(Lru/avito/android/persistence/messenger/MessageMetaInfo;)J", "", "updateOrInsertProgressAndStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/TransferStatus;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageMetaInfoDao {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Transaction
        public static void updateOrInsertProgressAndStatus(@NotNull MessageMetaInfoDao messageMetaInfoDao, @NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull TransferStatus transferStatus) {
            Intrinsics.checkNotNullParameter(str, "localUserId");
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str3, "localMessageId");
            Intrinsics.checkNotNullParameter(transferStatus, "transferStatus");
            if (messageMetaInfoDao.insertIfDoesNotExist(new MessageMetaInfo(str, str2, str3, null, null, j, transferStatus)) < 0) {
                messageMetaInfoDao.updateProgressAndStatus(str, str2, str3, j, transferStatus).blockingAwait();
            }
        }
    }

    @Query("\n            SELECT * FROM message_meta_info\n            WHERE\n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id = :localMessageId\n        ")
    @NotNull
    Observable<List<MessageMetaInfo>> getMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("\n            SELECT * FROM message_meta_info\n            WHERE\n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id IN (:localMessageIds)\n        ")
    @NotNull
    Observable<List<MessageMetaInfo>> getMetaInfoForMessages(@NotNull String str, @NotNull String str2, @NotNull List<String> list);

    @Insert(onConflict = 5)
    long insertIfDoesNotExist(@NotNull MessageMetaInfo messageMetaInfo);

    @Insert(onConflict = 1)
    @NotNull
    Completable insertOrReplace(@NotNull MessageMetaInfo messageMetaInfo);

    @Query("\n            UPDATE message_meta_info\n                SET internal_path = :internalPath\n            WHERE \n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id = :localMessageId\n            \n        ")
    @NotNull
    Completable updateInternalPath(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4);

    @Transaction
    void updateOrInsertProgressAndStatus(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull TransferStatus transferStatus);

    @Query("\n            UPDATE message_meta_info\n                SET progress = :progressInBytes,\n                transfer_status = :transferStatus\n            WHERE \n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id = :localMessageId\n        ")
    @NotNull
    Completable updateProgressAndStatus(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull TransferStatus transferStatus);

    @Query("\n            UPDATE message_meta_info\n                SET progress = :progressInBytes,\n                transfer_status = :transferStatus,\n                internal_path = :internalPath\n            WHERE \n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id = :localMessageId\n        ")
    @NotNull
    Completable updateProgressAndStatusAndInternalPath(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull TransferStatus transferStatus, @Nullable String str4);

    @Query("\n            UPDATE message_meta_info\n                SET progress = :progressInBytes,\n                    transfer_status = :transferStatus,\n                    path = :path\n            WHERE \n                local_user_id = :localUserId AND\n                channel_id = :channelId AND\n                local_message_id = :localMessageId\n            \n        ")
    @NotNull
    Completable updateProgressAndStatusAndPath(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull TransferStatus transferStatus, @NotNull String str4);
}
