package com.avito.android.remote.model.badge_bar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "type", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "getType", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;", "", "shouldShowOnboarding", "Z", "getShouldShowOnboarding", "()Z", "setShouldShowOnboarding", "(Z)V", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/badge_bar/SerpBadgeStyle;", "getStyle", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeStyle;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/badge_bar/SerpBadgeType;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/badge_bar/SerpBadgeStyle;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SerpBadge implements Parcelable {
    public static final Parcelable.Creator<SerpBadge> CREATOR = new Creator();
    @SerializedName("tooltipUri")
    @Nullable
    private final DeepLink deeplink;
    private boolean shouldShowOnboarding;
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @Nullable
    private final SerpBadgeStyle style;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @Nullable
    private final SerpBadgeType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpBadge> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpBadge createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            SerpBadgeStyle serpBadgeStyle = null;
            SerpBadgeType serpBadgeType = parcel.readInt() != 0 ? (SerpBadgeType) Enum.valueOf(SerpBadgeType.class, parcel.readString()) : null;
            DeepLink deepLink = (DeepLink) parcel.readParcelable(SerpBadge.class.getClassLoader());
            if (parcel.readInt() != 0) {
                serpBadgeStyle = SerpBadgeStyle.CREATOR.createFromParcel(parcel);
            }
            return new SerpBadge(readString, serpBadgeType, deepLink, serpBadgeStyle);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpBadge[] newArray(int i) {
            return new SerpBadge[i];
        }
    }

    public SerpBadge(@NotNull String str, @Nullable SerpBadgeType serpBadgeType, @Nullable DeepLink deepLink, @Nullable SerpBadgeStyle serpBadgeStyle) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.type = serpBadgeType;
        this.deeplink = deepLink;
        this.style = serpBadgeStyle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    public final boolean getShouldShowOnboarding() {
        return this.shouldShowOnboarding;
    }

    @Nullable
    public final SerpBadgeStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final SerpBadgeType getType() {
        return this.type;
    }

    public final void setShouldShowOnboarding(boolean z) {
        this.shouldShowOnboarding = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        SerpBadgeType serpBadgeType = this.type;
        if (serpBadgeType != null) {
            parcel.writeInt(1);
            parcel.writeString(serpBadgeType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.deeplink, i);
        SerpBadgeStyle serpBadgeStyle = this.style;
        if (serpBadgeStyle != null) {
            parcel.writeInt(1);
            serpBadgeStyle.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
