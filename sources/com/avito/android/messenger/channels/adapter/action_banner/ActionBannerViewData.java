package com.avito.android.messenger.channels.adapter.action_banner;

import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.channels.action_banner.ChannelsBanner;
import com.avito.android.messenger.channels.adapter.ChannelListItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/channels/adapter/action_banner/ActionBannerViewData;", "Lcom/avito/android/messenger/channels/adapter/ChannelListItem;", "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;", "getBanner", "()Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;", "banner", "Lcom/avito/android/image_loader/Picture;", "e", "Lcom/avito/android/image_loader/Picture;", "getImage", "()Lcom/avito/android/image_loader/Picture;", "image", "", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "d", "getActionText", "actionText", "<init>", "(Lcom/avito/android/messenger/channels/action_banner/ChannelsBanner;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ActionBannerViewData implements ChannelListItem {
    public final long a;
    @NotNull
    public final ChannelsBanner b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Picture e;

    public ActionBannerViewData(@NotNull ChannelsBanner channelsBanner, @NotNull String str, @Nullable String str2, @Nullable Picture picture) {
        Intrinsics.checkNotNullParameter(channelsBanner, "banner");
        Intrinsics.checkNotNullParameter(str, "message");
        this.b = channelsBanner;
        this.c = str;
        this.d = str2;
        this.e = picture;
        this.a = (long) channelsBanner.getId();
    }

    @Nullable
    public final String getActionText() {
        return this.d;
    }

    @NotNull
    public final ChannelsBanner getBanner() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final Picture getImage() {
        return this.e;
    }

    @NotNull
    public final String getMessage() {
        return this.c;
    }
}
