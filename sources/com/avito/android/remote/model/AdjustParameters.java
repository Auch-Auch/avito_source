package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/AdjustParameters;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "microCategoryId", "Ljava/lang/String;", "getMicroCategoryId", "()Ljava/lang/String;", "categoryId", "getCategoryId", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "verticalAlias", "Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "getVerticalAlias", "()Lcom/avito/android/remote/model/AdvertisementVerticalAlias;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertisementVerticalAlias;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdjustParameters implements Parcelable {
    public static final Parcelable.Creator<AdjustParameters> CREATOR = new Creator();
    @SerializedName("categoryId")
    @Nullable
    private final String categoryId;
    @SerializedName("microCategoryId")
    @Nullable
    private final String microCategoryId;
    @SerializedName("vertical")
    @Nullable
    private final AdvertisementVerticalAlias verticalAlias;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdjustParameters> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdjustParameters createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdjustParameters(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (AdvertisementVerticalAlias) Enum.valueOf(AdvertisementVerticalAlias.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdjustParameters[] newArray(int i) {
            return new AdjustParameters[i];
        }
    }

    public AdjustParameters(@Nullable String str, @Nullable String str2, @Nullable AdvertisementVerticalAlias advertisementVerticalAlias) {
        this.categoryId = str;
        this.microCategoryId = str2;
        this.verticalAlias = advertisementVerticalAlias;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getMicroCategoryId() {
        return this.microCategoryId;
    }

    @Nullable
    public final AdvertisementVerticalAlias getVerticalAlias() {
        return this.verticalAlias;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.categoryId);
        parcel.writeString(this.microCategoryId);
        AdvertisementVerticalAlias advertisementVerticalAlias = this.verticalAlias;
        if (advertisementVerticalAlias != null) {
            parcel.writeInt(1);
            parcel.writeString(advertisementVerticalAlias.name());
            return;
        }
        parcel.writeInt(0);
    }
}
