package com.avito.android.messenger.analytics;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lcom/avito/android/messenger/analytics/MessageType;", "getType", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lcom/avito/android/messenger/analytics/MessageType;", "type", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessageTypeKt {
    @NotNull
    public static final MessageType getType(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "$this$type");
        MessageBody messageBody = localMessage.body;
        if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item)) {
            return MessageType.ITEM;
        }
        if ((messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody)) {
            return MessageType.IMAGE;
        }
        if (messageBody instanceof MessageBody.Link) {
            return MessageType.LINK;
        }
        if (messageBody instanceof MessageBody.Location) {
            return MessageType.GEO;
        }
        if (messageBody instanceof MessageBody.Text.Regular) {
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
            if (((MessageBody.Text.Regular) messageBody).getSuggestedTemplates() != null) {
                return MessageType.SUGGEST;
            }
            return MessageType.TEXT;
        } else if (messageBody instanceof MessageBody.File) {
            return MessageType.FILE;
        } else {
            if ((messageBody instanceof MessageBody.Text.Reaction) || (messageBody instanceof MessageBody.Call) || (messageBody instanceof MessageBody.AppCall) || (messageBody instanceof MessageBody.Deleted) || (messageBody instanceof MessageBody.Unknown) || (messageBody instanceof MessageBody.SystemMessageBody.Platform) || (messageBody instanceof MessageBody.SystemMessageBody.Text) || (messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
                return MessageType.TEXT;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
