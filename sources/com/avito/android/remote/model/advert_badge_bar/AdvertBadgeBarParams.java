package com.avito.android.remote.model.advert_badge_bar;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBarParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "preloadCount", "Ljava/lang/Integer;", "getPreloadCount", "()Ljava/lang/Integer;", "", "showMoreTitle", "Ljava/lang/String;", "getShowMoreTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "display", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "getDisplay", "()Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;", "<init>", "(Lcom/avito/android/remote/model/advert_badge_bar/BadgeBarOrientation;Ljava/lang/Integer;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBadgeBarParams implements Parcelable {
    public static final Parcelable.Creator<AdvertBadgeBarParams> CREATOR = new Creator();
    @SerializedName("display")
    @Nullable
    private final BadgeBarOrientation display;
    @SerializedName("preloadCount")
    @Nullable
    private final Integer preloadCount;
    @SerializedName("showMoreTitle")
    @Nullable
    private final String showMoreTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertBadgeBarParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBarParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Integer num = null;
            BadgeBarOrientation badgeBarOrientation = parcel.readInt() != 0 ? (BadgeBarOrientation) Enum.valueOf(BadgeBarOrientation.class, parcel.readString()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new AdvertBadgeBarParams(badgeBarOrientation, num, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertBadgeBarParams[] newArray(int i) {
            return new AdvertBadgeBarParams[i];
        }
    }

    public AdvertBadgeBarParams(@Nullable BadgeBarOrientation badgeBarOrientation, @Nullable Integer num, @Nullable String str) {
        this.display = badgeBarOrientation;
        this.preloadCount = num;
        this.showMoreTitle = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final BadgeBarOrientation getDisplay() {
        return this.display;
    }

    @Nullable
    public final Integer getPreloadCount() {
        return this.preloadCount;
    }

    @Nullable
    public final String getShowMoreTitle() {
        return this.showMoreTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        BadgeBarOrientation badgeBarOrientation = this.display;
        if (badgeBarOrientation != null) {
            parcel.writeInt(1);
            parcel.writeString(badgeBarOrientation.name());
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.preloadCount;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.showMoreTitle);
    }
}
