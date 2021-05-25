package com.avito.android.remote.model.advert_badge_bar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadge;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeStyle;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeStyle;", "getStyle", "()Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeStyle;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "I", "getId", "description", "getDescription", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeStyle;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadge implements Parcelable {
    public static final Parcelable.Creator<AdvertBadge> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("id")
    private final int id;
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @Nullable
    private final AdvertBadgeStyle style;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertBadge> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadge createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertBadge(parcel.readInt(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(AdvertBadge.class.getClassLoader()), parcel.readInt() != 0 ? AdvertBadgeStyle.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadge[] newArray(int i) {
            return new AdvertBadge[i];
        }
    }

    public AdvertBadge(int i, @NotNull String str, @Nullable String str2, @Nullable DeepLink deepLink, @Nullable AdvertBadgeStyle advertBadgeStyle) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.id = i;
        this.title = str;
        this.description = str2;
        this.uri = deepLink;
        this.style = advertBadgeStyle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final AdvertBadgeStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final DeepLink getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.uri, i);
        AdvertBadgeStyle advertBadgeStyle = this.style;
        if (advertBadgeStyle != null) {
            parcel.writeInt(1);
            advertBadgeStyle.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
