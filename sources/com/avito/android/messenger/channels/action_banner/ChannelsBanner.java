package com.avito.android.messenger.channels.action_banner;

import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\u0001\u0001\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;", "", "", AuthSource.BOOKING_ORDER, "I", "getMessageId", "()I", "messageId", "d", "getImageId", "imageId", "c", "getActionId", "actionId", AuthSource.SEND_ABUSE, "getId", "id", "NotificationsSettings", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelsBanner {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner$NotificationsSettings;", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotificationsSettings extends ChannelsBanner {
        @NotNull
        public static final NotificationsSettings INSTANCE = new NotificationsSettings();

        public NotificationsSettings() {
            super(-1, R.string.messenger_notifications_banner_message, R.string.messenger_notifications_banner_action, com.avito.android.lib.design.R.attr.img_bannerNotifications, null);
        }
    }

    public ChannelsBanner(int i, int i2, int i3, int i4, j jVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int getActionId() {
        return this.c;
    }

    public final int getId() {
        return this.a;
    }

    public final int getImageId() {
        return this.d;
    }

    public final int getMessageId() {
        return this.b;
    }
}
