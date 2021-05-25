package com.avito.android.remote.model.advert_badge_bar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeStyle;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundPressedColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundPressedColor", "()Lcom/avito/android/remote/model/UniversalColor;", "fontColor", "getFontColor", "backgroundColor", "getBackgroundColor", "Lcom/avito/android/remote/model/UniversalImage;", "icon", "Lcom/avito/android/remote/model/UniversalImage;", "getIcon", "()Lcom/avito/android/remote/model/UniversalImage;", "<init>", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalImage;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeStyle implements Parcelable {
    public static final Parcelable.Creator<AdvertBadgeStyle> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @Nullable
    private final UniversalColor backgroundColor;
    @SerializedName("backgroundPressedColor")
    @Nullable
    private final UniversalColor backgroundPressedColor;
    @SerializedName("fontColor")
    @Nullable
    private final UniversalColor fontColor;
    @SerializedName("icon")
    @Nullable
    private final UniversalImage icon;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertBadgeStyle> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeStyle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertBadgeStyle((UniversalColor) parcel.readParcelable(AdvertBadgeStyle.class.getClassLoader()), (UniversalColor) parcel.readParcelable(AdvertBadgeStyle.class.getClassLoader()), (UniversalColor) parcel.readParcelable(AdvertBadgeStyle.class.getClassLoader()), (UniversalImage) parcel.readParcelable(AdvertBadgeStyle.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeStyle[] newArray(int i) {
            return new AdvertBadgeStyle[i];
        }
    }

    public AdvertBadgeStyle(@Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable UniversalColor universalColor3, @Nullable UniversalImage universalImage) {
        this.backgroundColor = universalColor;
        this.backgroundPressedColor = universalColor2;
        this.fontColor = universalColor3;
        this.icon = universalImage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final UniversalColor getBackgroundPressedColor() {
        return this.backgroundPressedColor;
    }

    @Nullable
    public final UniversalColor getFontColor() {
        return this.fontColor;
    }

    @Nullable
    public final UniversalImage getIcon() {
        return this.icon;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.backgroundColor, i);
        parcel.writeParcelable(this.backgroundPressedColor, i);
        parcel.writeParcelable(this.fontColor, i);
        parcel.writeParcelable(this.icon, i);
    }
}
