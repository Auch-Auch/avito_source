package com.avito.android.messenger.conversation.mvi.data;

import arrow.core.Option;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J=\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0013\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0014JE\u0010\u0016\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0017J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\fJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010 JE\u0010\"\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n0\u00190!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010#J+\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\fJ+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010'J+\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b(\u0010\fJ+\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010\fJ#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010\u001cJ%\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b,\u0010\fJ+\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010'J+\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010'JI\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010/\u001a\u00020+2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00101\u001a\u000200H&¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b4\u00105J%\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b4\u0010'J-\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b6\u00107J%\u00108\u001a\b\u0012\u0004\u0012\u0002000\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b8\u0010\fJ3\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b9\u0010#J3\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b:\u0010 ¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getAllMessagesAndMetaInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getAllMessages", "getAllPendingMessages", "()Lio/reactivex/Observable;", "", Sort.DATE, "limit", "getMessagesAndMetaInfoBefore", "(JLjava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "getMessagesBefore", "getMessagesAndMetaInfoAfter", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getMessagesAfter", "Larrow/core/Option;", "getLastMessage", "observeFirstPendingMessage", "(Ljava/lang/String;)Lio/reactivex/Observable;", "localUserId", "localMessageId", "getMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "getMessageAndMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "remoteId", "getMessageWithRemoteId", "getMessagesWithIncompleteBodies", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "getUnsentMessages", "getLatestLocallyReadTimestamp", "getLatestReadLocallyMessage", "", "getUnreadMessagesCount", "getLastSyncedMessageTimestamp", "getOldestMessageTimestampInChannel", "ordinal", "", "ensureHasMessage", "getFirstPageTimestamp", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Lio/reactivex/Single;", "getMessageCount", "(Ljava/lang/String;)Lio/reactivex/Single;", "getMessageCountBefore", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "hasIncomingMessages", "getMessageMetaInfo", "observeMessageMetaInfo", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageRepoReader {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single getFirstPageTimestamp$default(MessageRepoReader messageRepoReader, String str, String str2, int i, String str3, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str3 = null;
                }
                return messageRepoReader.getFirstPageTimestamp(str, str2, i, str3, (i2 & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFirstPageTimestamp");
        }

        public static /* synthetic */ Observable getMessagesAndMetaInfoBefore$default(MessageRepoReader messageRepoReader, long j, String str, String str2, long j2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    j2 = Long.MAX_VALUE;
                }
                return messageRepoReader.getMessagesAndMetaInfoBefore(j, str, str2, j2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessagesAndMetaInfoBefore");
        }

        public static /* synthetic */ Observable getMessagesBefore$default(MessageRepoReader messageRepoReader, long j, String str, String str2, long j2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    j2 = Long.MAX_VALUE;
                }
                return messageRepoReader.getMessagesBefore(j, str, str2, j2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessagesBefore");
        }
    }

    @NotNull
    Observable<List<LocalMessage>> getAllMessages(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getAllMessagesAndMetaInfo(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<LocalMessage>> getAllPendingMessages();

    @NotNull
    Single<Option<Long>> getFirstPageTimestamp(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, boolean z);

    @NotNull
    Observable<Option<LocalMessage>> getLastMessage(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<Option<Long>> getLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Option<Long>> getLatestLocallyReadTimestamp(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Option<LocalMessage>> getLatestReadLocallyMessage(@NotNull String str);

    @NotNull
    Observable<Option<LocalMessage>> getMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<Option<Pair<LocalMessage, MessageMetaInfo>>> getMessageAndMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<Long> getMessageCount(@NotNull String str);

    @NotNull
    Single<Long> getMessageCount(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<Long> getMessageCountBefore(long j, @NotNull String str, @NotNull String str2);

    @NotNull
    Single<Option<MessageMetaInfo>> getMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Observable<Option<LocalMessage>> getMessageWithRemoteId(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<LocalMessage>> getMessagesAfter(long j, @NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getMessagesAndMetaInfoAfter(long j, @NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getMessagesAndMetaInfoBefore(long j, @NotNull String str, @NotNull String str2, long j2);

    @NotNull
    Observable<List<LocalMessage>> getMessagesBefore(long j, @NotNull String str, @NotNull String str2, long j2);

    @NotNull
    Single<List<LocalMessage>> getMessagesWithIncompleteBodies(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<Option<Long>> getOldestMessageTimestampInChannel(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Integer> getUnreadMessagesCount(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<List<LocalMessage>> getUnsentMessages(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Boolean> hasIncomingMessages(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Option<LocalMessage>> observeFirstPendingMessage(@NotNull String str);

    @NotNull
    Observable<Option<MessageMetaInfo>> observeMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
