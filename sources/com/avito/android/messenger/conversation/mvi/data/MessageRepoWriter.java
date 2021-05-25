package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001a\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0014J%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&¢\u0006\u0004\b\u001c\u0010\u000eJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J-\u0010#\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\"\u001a\u00020\u001dH&¢\u0006\u0004\b#\u0010$J'\u0010%\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001dH&¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001dH&¢\u0006\u0004\b'\u0010&J'\u0010)\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001dH&¢\u0006\u0004\b)\u0010&J'\u0010*\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001dH&¢\u0006\u0004\b*\u0010&J1\u0010,\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u001dH&¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b.\u0010\u0014J1\u00100\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b2\u0010\u0014J/\u00103\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b3\u00101J1\u00104\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u001dH&¢\u0006\u0004\b4\u0010-J'\u00105\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b5\u0010\u0014J'\u00106\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b6\u0010\u0014¨\u00067"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lio/reactivex/Completable;", "createMessage", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lio/reactivex/Completable;", "", MessageMetaInfo.COLUMN_PATH, "createFileMessage", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)Lio/reactivex/Completable;", "", "messages", "createMessages", "(Ljava/util/List;)Lio/reactivex/Completable;", "updateMessage", "localUserId", "channelId", "localMessageId", "deleteMessageMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", ChannelContext.Item.USER_ID, "localId", "deleteMessageAndMetaInfo", "channelIds", "deleteMessagesWithChannelIds", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "localIds", "markMessagesAsFailed", "", "newTimestamp", "resetMessageForResend", "(Ljava/lang/String;J)Lio/reactivex/Completable;", "messageIds", "timestamp", "markMessagesAsRead", "(Ljava/lang/String;Ljava/util/List;J)Lio/reactivex/Completable;", "markIncomingMessagesAsReadInChannel", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Completable;", "markOutgoingMessagesAsReadInChannel", "readLocallyTimeStamp", "setIsReadLocallyForMessagesInChannel", "updateLastSyncedMessageTimestamp", "bytesTransferred", "setFileDownloadProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Completable;", "setFileDownloadStarted", "internalPath", "setFileDownloadInternalPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "setFileDownloadCanceled", "setFileDownloadedSuccessfully", "setFileUploadInProgress", "setFileUploadedSuccessfully", "setFileTransferFailed", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageRepoWriter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable setFileDownloadProgress$default(MessageRepoWriter messageRepoWriter, String str, String str2, String str3, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    j = 0;
                }
                return messageRepoWriter.setFileDownloadProgress(str, str2, str3, j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFileDownloadProgress");
        }

        public static /* synthetic */ Completable setFileUploadInProgress$default(MessageRepoWriter messageRepoWriter, String str, String str2, String str3, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    j = 0;
                }
                return messageRepoWriter.setFileUploadInProgress(str, str2, str3, j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFileUploadInProgress");
        }
    }

    @NotNull
    Completable createFileMessage(@NotNull LocalMessage localMessage, @NotNull String str);

    @NotNull
    Completable createMessage(@NotNull LocalMessage localMessage);

    @NotNull
    Completable createMessages(@NotNull List<LocalMessage> list);

    @NotNull
    Completable deleteMessageAndMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable deleteMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable deleteMessagesWithChannelIds(@NotNull String str, @NotNull List<String> list);

    @NotNull
    Completable markIncomingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j);

    @NotNull
    Completable markMessagesAsFailed(@NotNull List<String> list);

    @NotNull
    Completable markMessagesAsRead(@NotNull String str, @NotNull List<String> list, long j);

    @NotNull
    Completable markOutgoingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j);

    @NotNull
    Completable resetMessageForResend(@NotNull String str, long j);

    @NotNull
    Completable setFileDownloadCanceled(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable setFileDownloadInternalPath(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4);

    @NotNull
    Completable setFileDownloadProgress(@NotNull String str, @NotNull String str2, @NotNull String str3, long j);

    @NotNull
    Completable setFileDownloadStarted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable setFileDownloadedSuccessfully(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    @NotNull
    Completable setFileTransferFailed(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable setFileUploadInProgress(@NotNull String str, @NotNull String str2, @NotNull String str3, long j);

    @NotNull
    Completable setFileUploadedSuccessfully(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable setIsReadLocallyForMessagesInChannel(@NotNull String str, @NotNull String str2, long j);

    @NotNull
    Completable updateLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2, long j);

    @NotNull
    Completable updateMessage(@NotNull LocalMessage localMessage);
}
