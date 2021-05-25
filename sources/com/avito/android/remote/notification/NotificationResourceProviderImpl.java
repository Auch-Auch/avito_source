package com.avito.android.remote.notification;

import android.content.res.Resources;
import com.avito.android.app.core.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/notification/NotificationResourceProviderImpl;", "Lcom/avito/android/remote/notification/NotificationResourceProvider;", "", "c", "I", "getColor", "()I", "color", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", AuthSource.BOOKING_ORDER, "getDirectReplyLabel", "directReplyLabel", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationResourceProviderImpl implements NotificationResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;

    public NotificationResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.notification_channel_id_default);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ation_channel_id_default)");
        this.a = string;
        String string2 = resources.getString(R.string.notification_direct_reply);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…otification_direct_reply)");
        this.b = string2;
        this.c = resources.getColor(com.avito.android.lib.design.avito.R.color.avito_blue);
    }

    @Override // com.avito.android.remote.notification.NotificationResourceProvider
    @NotNull
    public String getChannelId() {
        return this.a;
    }

    @Override // com.avito.android.remote.notification.NotificationResourceProvider
    public int getColor() {
        return this.c;
    }

    @Override // com.avito.android.remote.notification.NotificationResourceProvider
    @NotNull
    public String getDirectReplyLabel() {
        return this.b;
    }
}
