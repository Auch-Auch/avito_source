package com.avito.android.messenger.conversation.mvi.send;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\nJ=\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\t\u0010\u0010J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\t\u0010\u0015J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\t\u0010\u0018J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\rJ\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H'¢\u0006\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessageInteractor;", "", "", "currentUserId", "text", "", "templates", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "createMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "createMessages", "createReactionMessage", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "(Ljava/lang/String;Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "file", "Landroid/net/Uri;", "contentUri", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;Landroid/net/Uri;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "location", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Lio/reactivex/Single;", "operationId", "createImageMessages", "userIds", "Lio/reactivex/Completable;", "sendTypingEvent", "(Ljava/util/List;)Lio/reactivex/Completable;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "convertTextToMessageBodies", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "Lio/reactivex/Observable;", "", "getMessageSendAttemptsStream", "()Lio/reactivex/Observable;", "messageSendAttemptsStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SendMessageInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single createMessage$default(SendMessageInteractor sendMessageInteractor, String str, String str2, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    list = null;
                }
                return sendMessageInteractor.createMessage(str, str2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMessage");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single createMessages$default(SendMessageInteractor sendMessageInteractor, String str, String str2, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    list = null;
                }
                return sendMessageInteractor.createMessages(str, str2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMessages");
        }
    }

    @VisibleForTesting(otherwise = 2)
    @NotNull
    List<MessageBody> convertTextToMessageBodies(@NotNull String str, @Nullable List<String> list);

    @NotNull
    Single<List<LocalMessage>> createImageMessages(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<LocalMessage> createMessage(@NotNull String str, @NotNull FeedbackAdvertItem feedbackAdvertItem);

    @NotNull
    Single<LocalMessage> createMessage(@NotNull String str, @NotNull MessageBody.File file, @NotNull Uri uri);

    @NotNull
    Single<LocalMessage> createMessage(@NotNull String str, @NotNull MessageBody.Location location);

    @NotNull
    Single<LocalMessage> createMessage(@NotNull String str, @NotNull String str2, @Nullable List<String> list);

    @NotNull
    Single<List<LocalMessage>> createMessages(@NotNull String str, @NotNull String str2, @Nullable List<String> list);

    @NotNull
    Single<LocalMessage> createReactionMessage(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<Unit> getMessageSendAttemptsStream();

    @NotNull
    Completable sendTypingEvent(@NotNull List<String> list);
}
