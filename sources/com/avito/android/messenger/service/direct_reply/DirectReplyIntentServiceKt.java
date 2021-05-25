package com.avito.android.messenger.service.direct_reply;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.notification.NotificationIdentifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a1\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "", "channelId", "text", "", "isRetry", MessageBody.RANDOM_ID, "Landroid/content/Intent;", "createSendMessageServiceIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "directReplyKey", "", "notificationId", "notificationTag", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class DirectReplyIntentServiceKt {
    @NotNull
    public static final Intent createSendMessageServiceIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(context, "$this$createSendMessageServiceIntent");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(str3, MessageBody.RANDOM_ID);
        Intent putExtra = new Intent(context, DirectReplyIntentService.class).putExtra("channel_id", str).putExtra("text", str2).putExtra("is_retry", z).putExtra("random_id", str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(this, DirectReply…ANDOM_ID_EXTRA, randomId)");
        return putExtra;
    }

    public static /* synthetic */ Intent createSendMessageServiceIntent$default(Context context, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return createSendMessageServiceIntent(context, str, str2, i, str3);
    }

    @NotNull
    public static final Intent createSendMessageServiceIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, int i, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "$this$createSendMessageServiceIntent");
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "directReplyKey");
        Intent putExtra = new Intent(context, DirectReplyIntentService.class).putExtra("channel_id", str).putExtra("direct_reply_key", str2).putExtra("notification_id", new NotificationIdentifier(str3, i));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(this, DirectReply…tionTag, notificationId))");
        return putExtra;
    }
}
