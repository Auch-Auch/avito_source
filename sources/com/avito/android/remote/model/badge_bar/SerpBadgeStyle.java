package com.avito.android.remote.model.badge_bar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.UniversalColor;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/badge_bar/SerpBadgeStyle;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "fontColor", "getFontColor", "<init>", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SerpBadgeStyle implements Parcelable {
    public static final Parcelable.Creator<SerpBadgeStyle> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @Nullable
    private final UniversalColor backgroundColor;
    @SerializedName("fontColor")
    @Nullable
    private final UniversalColor fontColor;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpBadgeStyle> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpBadgeStyle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            UniversalColor universalColor = null;
            UniversalColor createFromParcel = parcel.readInt() != 0 ? UniversalColor.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                universalColor = UniversalColor.CREATOR.createFromParcel(parcel);
            }
            return new SerpBadgeStyle(createFromParcel, universalColor);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpBadgeStyle[] newArray(int i) {
            return new SerpBadgeStyle[i];
        }
    }

    public SerpBadgeStyle(@Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2) {
        this.backgroundColor = universalColor;
        this.fontColor = universalColor2;
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
    public final UniversalColor getFontColor() {
        return this.fontColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        UniversalColor universalColor = this.backgroundColor;
        if (universalColor != null) {
            parcel.writeInt(1);
            universalColor.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        UniversalColor universalColor2 = this.fontColor;
        if (universalColor2 != null) {
            parcel.writeInt(1);
            universalColor2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
