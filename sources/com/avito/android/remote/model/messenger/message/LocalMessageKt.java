package com.avito.android.remote.model.messenger.message;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001e\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\b\u001a\u00020\u0002*\u00020\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00020\t*\u00020\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u00020\t*\u00020\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0018\u0010\r\u001a\u00020\t*\u00020\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "", "getLongStr", "(Ljava/util/Collection;)Ljava/lang/String;", "longStr", "getShortStr", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Ljava/lang/String;", "shortStr", "", "isFromUser", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Z", "isNotRead", "isMine", "models_release"}, k = 2, mv = {1, 4, 2})
public final class LocalMessageKt {
    @NotNull
    public static final String getLongStr(@NotNull Collection<LocalMessage> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$longStr");
        StringBuilder sb = new StringBuilder((collection.size() * 3) + 1);
        StringBuilder L = a.L("(size=");
        L.append(collection.size());
        L.append(")[");
        sb.append(L.toString());
        int i = 0;
        for (T t : collection) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb.append("\n\t");
            sb.append((Object) t);
            if (i < collection.size() - 1) {
                sb.append(",");
            }
            i = i2;
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public static final String getShortStr(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "$this$shortStr");
        StringBuilder sb = new StringBuilder();
        sb.append("LocalMessage(localId='");
        sb.append(localMessage.localId);
        sb.append("', remoteId='");
        sb.append(localMessage.remoteId);
        sb.append("', channelId='");
        sb.append(localMessage.channelId);
        sb.append("', fromId='");
        return a.t(sb, localMessage.fromId, "')");
    }

    public static final boolean isFromUser(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "$this$isFromUser");
        MessageBody messageBody = localMessage.body;
        if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item) || (messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody) || (messageBody instanceof MessageBody.Link) || (messageBody instanceof MessageBody.Location) || (messageBody instanceof MessageBody.Text.Regular) || (messageBody instanceof MessageBody.File) || (messageBody instanceof MessageBody.Text.Reaction) || (messageBody instanceof MessageBody.Call) || (messageBody instanceof MessageBody.AppCall) || (messageBody instanceof MessageBody.Deleted) || (messageBody instanceof MessageBody.Unknown) || (messageBody instanceof MessageBody.SystemMessageBody.Platform.FromUser)) {
            return true;
        }
        if ((messageBody instanceof MessageBody.SystemMessageBody.Platform.FromAvito) || (messageBody instanceof MessageBody.SystemMessageBody.Platform.Bubble) || (messageBody instanceof MessageBody.SystemMessageBody.Text) || (messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isMine(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "$this$isMine");
        return Intrinsics.areEqual(localMessage.fromId, localMessage.userId);
    }

    public static final boolean isNotRead(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "$this$isNotRead");
        return !localMessage.isRead;
    }
}
