package com.avito.android.remote.model;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsAlert;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/ShopSettingsAlert$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/ShopSettingsAlert$Style;", "getStyle", "()Lcom/avito/android/remote/model/ShopSettingsAlert$Style;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ShopSettingsAlert$Style;)V", "Style", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsAlert {
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @NotNull
    private final Style style;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsAlert$Style;", "", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Alert", "Message", "Confirmation", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public enum Style {
        Alert("alert"),
        Message("message"),
        Confirmation("confirmation");
        
        @NotNull
        private final String style;

        private Style(String str) {
            this.style = str;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }
    }

    public ShopSettingsAlert(@NotNull String str, @Nullable String str2, @NotNull Style style2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(style2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.title = str;
        this.subtitle = str2;
        this.style = style2;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
