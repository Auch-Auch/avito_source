package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0013\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\tJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\r\u0010\u0006J+\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b\u000f\u0010\fJ;\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b\u0017\u0010\fJ1\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001c\u0010\tJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001e\u0010\tJ5\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0010H'¢\u0006\u0004\b\u001f\u0010 J+\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b!\u0010\fJ/\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J3\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\"H'¢\u0006\u0004\b'\u0010%J+\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\"H'¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b*\u0010+J!\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b,\u0010+J)\u0010.\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001dH'¢\u0006\u0004\b.\u0010/J)\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H'¢\u0006\u0004\b1\u00102J3\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H'¢\u0006\u0004\b4\u00105J+\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H'¢\u0006\u0004\b6\u0010\fJ\u0017\u00107\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b7\u00108J\u001f\u00107\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b7\u00109J%\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b:\u0010\fJ'\u0010;\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H'¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0004H'¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H'¢\u0006\u0004\bB\u0010CJ\u001f\u0010E\u001a\u00020D2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0017¢\u0006\u0004\bE\u0010FJ#\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0017¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u0004H'¢\u0006\u0004\bJ\u0010KJ'\u0010L\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H'¢\u0006\u0004\bL\u0010MJ'\u0010O\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H'¢\u0006\u0004\bO\u0010MJ'\u0010P\u001a\u00020D2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0017¢\u0006\u0004\bP\u0010QJ%\u0010R\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H'¢\u0006\u0004\bR\u0010SJ#\u0010V\u001a\u00020\u001d2\u0012\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070T\"\u00020\u0007H'¢\u0006\u0004\bV\u0010WJ+\u0010Y\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\u00102\u0012\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070T\"\u00020\u0007H'¢\u0006\u0004\bY\u0010ZJ5\u0010]\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\\\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\"H'¢\u0006\u0004\b]\u0010^J/\u0010_\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\"H'¢\u0006\u0004\b_\u0010`J/\u0010a\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\"H'¢\u0006\u0004\ba\u0010`J9\u0010e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\"2\u0006\u0010c\u001a\u00020\"2\b\u0010d\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0004\be\u0010f¨\u0006g"}, d2 = {"Lru/avito/android/persistence/messenger/MessageDao;", "", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/MessageEntity;", "getAllMessages", "()Lio/reactivex/Observable;", "", ChannelContext.Item.USER_ID, "(Ljava/lang/String;)Lio/reactivex/Observable;", "channelId", "getAllMessagesSortedByIsPendingAndCreatedDesc", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getAllPendingMessages", "localUserId", "getLastMessageForChannel", "", Sort.DATE, "limit", "getMessagesBeforeSortedByIsPendingAndCreatedDesc", "(JLjava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "getMessagesAfterSortedByIsPendingAndCreatedDesc", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getLastMessageSortedByIsPendingAndCreatedDesc", "", "channelIds", "getLastMesssagesForChannels", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", "getFirstPendingMessage", "", "pendingMessageCount", "getMessagesWithIncompleteBodies", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "getUnsentMessages", "Lru/avito/android/persistence/messenger/IsReadStatus;", "status", "getUnreadMessagesCount", "(Ljava/lang/String;Ljava/lang/String;Lru/avito/android/persistence/messenger/IsReadStatus;)Lio/reactivex/Observable;", "isReadStatus", "getTimestampOfLatestIncomingMessageWithLocalReadStatus", "getLatestIncomingMessageWithLocalReadStatus", "(Ljava/lang/String;Lru/avito/android/persistence/messenger/IsReadStatus;)Lio/reactivex/Observable;", "getLastSyncTimestamp", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getOldestMessageTimestampInChannel", "ordinal", "getFirstPageTimestamp", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Long;", "remoteId", "getMessageCreationTimestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "localId", "getMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "findByRemoteId", "getMessageCount", "(Ljava/lang/String;)J", "(Ljava/lang/String;Ljava/lang/String;)J", "getIncomingMessageCount", "getMessageCountBefore", "(JLjava/lang/String;Ljava/lang/String;)J", "message", "insertMessage", "(Lru/avito/android/persistence/messenger/MessageEntity;)J", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "messageMetaInfo", "insertMessageMetaInfo", "(Lru/avito/android/persistence/messenger/MessageMetaInfo;)J", "", "insertFileMessage", "(Lru/avito/android/persistence/messenger/MessageEntity;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "messages", "insertMessages", "(Ljava/util/List;)Ljava/util/List;", "updateMessage", "(Lru/avito/android/persistence/messenger/MessageEntity;)I", "deleteMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", "localMessageId", "deleteMessageMetaInfo", "deleteMessageAndMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "deleteMessagesWithChannelIds", "(Ljava/lang/String;Ljava/util/List;)I", "", "localIds", "markMessagesAsFailed", "([Ljava/lang/String;)I", "newTimestamp", "resetFailedFlagForMessages", "(J[Ljava/lang/String;)I", "remoteIds", "timestamp", "markMessagesAsRead", "(Ljava/lang/String;Ljava/util/List;JLru/avito/android/persistence/messenger/IsReadStatus;)I", "markOutgoingMessagesAsReadInChannel", "(Ljava/lang/String;Ljava/lang/String;JLru/avito/android/persistence/messenger/IsReadStatus;)I", "markIncomingMessagesAsReadInChannel", "oldIsReadStatus", "newIsReadStatus", "readLocallyTimestamp", "setNewIsReadStatusForMessagesInChannel", "(Ljava/lang/String;Ljava/lang/String;Lru/avito/android/persistence/messenger/IsReadStatus;Lru/avito/android/persistence/messenger/IsReadStatus;Ljava/lang/Long;)I", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageDao {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Transaction
        public static void deleteMessageAndMetaInfo(@NotNull MessageDao messageDao, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str3, "localId");
            messageDao.deleteMessage(str, str2, str3);
            messageDao.deleteMessageMetaInfo(str, str2, str3);
        }

        public static /* synthetic */ Observable getMessagesWithIncompleteBodies$default(MessageDao messageDao, String str, String str2, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    j = 100;
                }
                return messageDao.getMessagesWithIncompleteBodies(str, str2, j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessagesWithIncompleteBodies");
        }

        public static /* synthetic */ Observable getUnreadMessagesCount$default(MessageDao messageDao, String str, String str2, IsReadStatus isReadStatus, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    isReadStatus = IsReadStatus.IS_NOT_READ;
                }
                return messageDao.getUnreadMessagesCount(str, str2, isReadStatus);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUnreadMessagesCount");
        }

        @Transaction
        public static void insertFileMessage(@NotNull MessageDao messageDao, @NotNull MessageEntity messageEntity, @NotNull MessageMetaInfo messageMetaInfo) {
            Intrinsics.checkNotNullParameter(messageEntity, "message");
            Intrinsics.checkNotNullParameter(messageMetaInfo, "messageMetaInfo");
            messageDao.insertMessage(messageEntity);
            messageDao.insertMessageMetaInfo(messageMetaInfo);
        }

        @Transaction
        @NotNull
        public static List<Long> insertMessages(@NotNull MessageDao messageDao, @NotNull List<MessageEntity> list) {
            Intrinsics.checkNotNullParameter(list, "messages");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(messageDao.insertMessage(it.next())));
            }
            return arrayList;
        }
    }

    @Query("\n        DELETE FROM message \n        WHERE \n            user_id = :userId AND\n            channel_id = :channelId AND\n            local_id = :localId\n        ")
    int deleteMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Transaction
    void deleteMessageAndMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("\n        DELETE FROM message_meta_info\n        WHERE \n            local_user_id = :localUserId AND\n            channel_id = :channelId AND\n            local_message_id = :localMessageId\n        ")
    int deleteMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("\n            DELETE FROM message\n            WHERE \n                user_id = :userId\n                AND channel_id IN (:channelIds)\n        ")
    int deleteMessagesWithChannelIds(@NotNull String str, @NotNull List<String> list);

    @Query("\n        SELECT * FROM message\n        WHERE \n            user_id = :userId\n            AND remote_id = :remoteId\n    ")
    @NotNull
    Observable<List<MessageEntity>> findByRemoteId(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT * FROM message\n        ")
    @NotNull
    Observable<List<MessageEntity>> getAllMessages();

    @Query("\n            SELECT * FROM message\n            WHERE\n                user_id = :userId\n        ")
    @NotNull
    Observable<List<MessageEntity>> getAllMessages(@NotNull String str);

    @Query("\n        select *\n        from message\n        where\n            user_id = :userId\n            and channel_id = :channelId\n        order by (remote_id is null and is_failed == 0) desc, created desc\n        ")
    @NotNull
    Observable<List<MessageEntity>> getAllMessagesSortedByIsPendingAndCreatedDesc(@NotNull String str, @NotNull String str2);

    @Query("\n        select *\n        from message\n        where remote_id is null and is_failed = 0\n        order by created\n        ")
    @NotNull
    Observable<List<MessageEntity>> getAllPendingMessages();

    @Query("\n        select min(created) from (\n            select created from message\n            where\n                user_id = :userId\n                and channel_id = :channelId\n            order by created desc\n            limit :ordinal\n        )\n        ")
    @Nullable
    Long getFirstPageTimestamp(@NotNull String str, @NotNull String str2, int i);

    @Query("\n            select * from message\n            where\n                user_id = :userId\n                and remote_id is null\n                and is_failed = 0\n            order by created asc\n            limit 1\n        ")
    @NotNull
    Observable<List<MessageEntity>> getFirstPendingMessage(@NotNull String str);

    @Query("\n        select count(*)\n        from message\n        where\n            user_id = :userId\n            and channel_id = :channelId\n            and from_id not in (:userId, '0')\n        ")
    @NotNull
    Observable<Long> getIncomingMessageCount(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT * FROM message\n            WHERE\n                message.user_id = :localUserId\n                AND message.channel_id = :channelId\n            ORDER BY message.created DESC\n            LIMIT 1\n        ")
    @NotNull
    Observable<List<MessageEntity>> getLastMessageForChannel(@NotNull String str, @NotNull String str2);

    @Query("\n            select * from message\n            where\n                user_id = :userId\n                and channel_id = :channelId\n            order by (remote_id is null and is_failed == 0) desc, created desc\n            limit 1\n        ")
    @NotNull
    Observable<List<MessageEntity>> getLastMessageSortedByIsPendingAndCreatedDesc(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT msg.*\n            FROM message AS msg\n            INNER JOIN\n                (\n                    SELECT \n                        m.user_id,\n                        m.channel_id,\n                        max(m.created) AS max_created\n                    FROM message AS m\n                    WHERE \n                        user_id = :userId\n                        AND channel_id IN (:channelIds)\n                    GROUP BY m.channel_id\n                ) AS t\n            ON \n                msg.user_id = t.user_id\n                AND msg.channel_id = t.channel_id\n                AND msg.created = t.max_created\n        ")
    @NotNull
    Observable<List<MessageEntity>> getLastMesssagesForChannels(@NotNull String str, @NotNull Collection<String> collection);

    @Query("\n        select\n            ifnull(\n                first_unread_outgoing_message.timestamp - 1,\n                last_message.timestamp\n            )\n        from\n            (   -- First UNREAD outgoing message\n                select min(created) as timestamp\n                from message\n                where\n                    user_id = :userId\n                    and channel_id = :channelId\n                    and from_id = :userId\n                    and remote_id is not null\n                    and read_timestamp is null\n            ) as first_unread_outgoing_message,\n\n            (   -- Last message\n                select max(created) as timestamp\n                from message\n                where\n                    user_id = :userId\n                    and channel_id = :channelId\n                    and remote_id is not null\n            ) as last_message\n        ")
    @Nullable
    Long getLastSyncTimestamp(@NotNull String str, @NotNull String str2);

    @Query("\n            select *\n            from message\n            where\n                user_id = :userId\n                and from_id != :userId\n                and is_read_status = :isReadStatus\n            order by created desc\n            limit 1\n            ")
    @NotNull
    Observable<List<MessageEntity>> getLatestIncomingMessageWithLocalReadStatus(@NotNull String str, @NotNull IsReadStatus isReadStatus);

    @Query("\n        SELECT * FROM message\n        WHERE\n            user_id = :userId AND\n            channel_id = :channelId AND\n            local_id = :localId\n        ")
    @NotNull
    Observable<List<MessageEntity>> getMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("select count(*) from message where user_id = :userId")
    long getMessageCount(@NotNull String str);

    @Query("select count(*) from message where user_id = :userId and channel_id = :channelId")
    long getMessageCount(@NotNull String str, @NotNull String str2);

    @Query("\n        select count(*)\n        from message\n        where\n            user_id = :userId\n            and channel_id = :channelId\n            and created < :date\n        ")
    long getMessageCountBefore(long j, @NotNull String str, @NotNull String str2);

    @Query("\n        select created as timestamp\n        from message \n        where user_id = :userId \n            and channel_id = :channelId \n            and remote_id = :remoteId\n        limit 1\n        ")
    @Nullable
    Long getMessageCreationTimestamp(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("\n        select * from message\n        where\n            created > :date\n            and user_id = :userId\n            and channel_id = :channelId\n        order by (remote_id is null and is_failed == 0) desc, created desc\n        ")
    @NotNull
    Observable<List<MessageEntity>> getMessagesAfterSortedByIsPendingAndCreatedDesc(long j, @NotNull String str, @NotNull String str2);

    @Query("\n        select * from message\n        where\n            created < :date\n            and user_id = :userId\n            and channel_id = :channelId\n         order by (remote_id is null and is_failed == 0) desc, created desc\n         limit :limit\n        ")
    @NotNull
    Observable<List<MessageEntity>> getMessagesBeforeSortedByIsPendingAndCreatedDesc(long j, @NotNull String str, @NotNull String str2, long j2);

    @Query("\n        select * from message\n        where\n            user_id = :userId\n            and channel_id = :channelId\n            and is_complete = 0\n        order by created desc\n        limit :limit\n        ")
    @NotNull
    Observable<List<MessageEntity>> getMessagesWithIncompleteBodies(@NotNull String str, @NotNull String str2, long j);

    @Query("\n            select min(created)\n            from message\n            where\n                user_id = :userId\n                and channel_id = :channelId\n        ")
    @Nullable
    Long getOldestMessageTimestampInChannel(@NotNull String str, @NotNull String str2);

    @Query("\n            select max(created)\n            from message\n            where\n                user_id = :userId\n                and channel_id = :channelId\n                and from_id != :userId\n                and is_read_status = :isReadStatus\n            ")
    @NotNull
    Observable<List<Long>> getTimestampOfLatestIncomingMessageWithLocalReadStatus(@NotNull String str, @NotNull String str2, @NotNull IsReadStatus isReadStatus);

    @Query("\n            select count(*)\n            from message\n            where\n                user_id = :userId\n                and channel_id = :channelId\n                and from_id != :userId\n                and is_read_status = :status\n            ")
    @NotNull
    Observable<Integer> getUnreadMessagesCount(@NotNull String str, @NotNull String str2, @NotNull IsReadStatus isReadStatus);

    @Query("\n        select * from message\n        where\n            user_id = :userId\n            and channel_id = :channelId\n            and remote_id is null\n            and not is_failed\n        order by created asc\n        ")
    @NotNull
    Observable<List<MessageEntity>> getUnsentMessages(@NotNull String str, @NotNull String str2);

    @Transaction
    void insertFileMessage(@NotNull MessageEntity messageEntity, @NotNull MessageMetaInfo messageMetaInfo);

    @Insert(onConflict = 1)
    long insertMessage(@NotNull MessageEntity messageEntity);

    @Insert(onConflict = 1)
    long insertMessageMetaInfo(@NotNull MessageMetaInfo messageMetaInfo);

    @Transaction
    @NotNull
    List<Long> insertMessages(@NotNull List<MessageEntity> list);

    @Query("\n            update message\n            set\n                read_timestamp = :timestamp,\n                is_read = 1,\n                is_read_status = :isReadStatus\n            where\n                user_id = :userId\n                and channel_id = :channelId\n                and from_id != :userId\n                and (is_read = 0 or read_timestamp is null)\n            ")
    int markIncomingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j, @NotNull IsReadStatus isReadStatus);

    @Query("\n        update message\n        set is_failed = 1\n        where remote_id is null and local_id in (:localIds)\n        ")
    int markMessagesAsFailed(@NotNull String... strArr);

    @Query("\n        update message\n        set\n            read_timestamp = :timestamp,\n            is_read = 1,\n            is_read_status = :isReadStatus\n        where\n            user_id = :userId\n            and remote_id in (:remoteIds)\n        ")
    int markMessagesAsRead(@NotNull String str, @NotNull List<String> list, long j, @NotNull IsReadStatus isReadStatus);

    @Query("\n            update message\n            set\n                read_timestamp = :timestamp,\n                is_read = 1,\n                is_read_status = :isReadStatus\n            where\n                user_id = :userId\n                and channel_id = :channelId\n                and from_id = :userId\n                and read_timestamp is null\n            ")
    int markOutgoingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j, @NotNull IsReadStatus isReadStatus);

    @Query("\n            select count(*) from message\n            where\n                user_id = :userId\n                and remote_id is null\n                and is_failed = 0\n            order by created asc\n        ")
    @NotNull
    Observable<Integer> pendingMessageCount(@NotNull String str);

    @Query("\n        update message\n        set is_failed = 0, created = :newTimestamp\n        where remote_id is null and local_id in (:localIds)\n        ")
    int resetFailedFlagForMessages(long j, @NotNull String... strArr);

    @Query("\n        update message\n        set\n            is_read = 1,\n            is_read_status = :newIsReadStatus,\n            read_locally_timestamp = :readLocallyTimestamp\n        where\n            user_id = :userId\n            and channel_id = :channelId\n            and is_read_status = :oldIsReadStatus\n        ")
    int setNewIsReadStatusForMessagesInChannel(@NotNull String str, @NotNull String str2, @NotNull IsReadStatus isReadStatus, @NotNull IsReadStatus isReadStatus2, @Nullable Long l);

    @Update(onConflict = 1)
    int updateMessage(@NotNull MessageEntity messageEntity);
}
