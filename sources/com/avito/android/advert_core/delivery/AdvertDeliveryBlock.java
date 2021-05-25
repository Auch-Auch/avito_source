package com.avito.android.advert_core.delivery;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock;", "", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Info;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Info;", "getInfo", "()Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Info;", "info", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Switcher;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Switcher;", "getSwitcher", "()Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Switcher;", "switcher", "<init>", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Info;Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Switcher;)V", "Info", "Switcher", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryBlock {
    @Nullable
    public final Info a;
    @Nullable
    public final Switcher b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Info;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "title", AuthSource.BOOKING_ORDER, "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/net/Uri;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info {
        @NotNull
        public final CharSequence a;
        @Nullable
        public final CharSequence b;
        @Nullable
        public final Uri c;

        public Info(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Uri uri) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.a = charSequence;
            this.b = charSequence2;
            this.c = uri;
        }

        @Nullable
        public final CharSequence getSubtitle() {
            return this.b;
        }

        @NotNull
        public final CharSequence getTitle() {
            return this.a;
        }

        @Nullable
        public final Uri getUri() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock$Switcher;", "", "", "c", "Z", "getValue", "()Z", "setValue", "(Z)V", "value", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getSubtitle", "()Ljava/lang/CharSequence;", MessengerShareContentUtility.SUBTITLE, AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Switcher {
        @NotNull
        public final CharSequence a;
        @Nullable
        public final CharSequence b;
        public boolean c;

        public Switcher(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.a = charSequence;
            this.b = charSequence2;
            this.c = z;
        }

        @Nullable
        public final CharSequence getSubtitle() {
            return this.b;
        }

        @NotNull
        public final CharSequence getTitle() {
            return this.a;
        }

        public final boolean getValue() {
            return this.c;
        }

        public final void setValue(boolean z) {
            this.c = z;
        }
    }

    public AdvertDeliveryBlock(@Nullable Info info, @Nullable Switcher switcher) {
        this.a = info;
        this.b = switcher;
    }

    @Nullable
    public final Info getInfo() {
        return this.a;
    }

    @Nullable
    public final Switcher getSwitcher() {
        return this.b;
    }
}
