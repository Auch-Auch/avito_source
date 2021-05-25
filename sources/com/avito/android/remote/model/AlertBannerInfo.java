package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/AlertBannerInfo;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/BannerType;", "component1", "()Lcom/avito/android/remote/model/BannerType;", "", "component2", "()Ljava/lang/String;", "component3", "type", TariffPackageInfoConverterKt.HEADER_STRING_ID, "text", "copy", "(Lcom/avito/android/remote/model/BannerType;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/AlertBannerInfo;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/BannerType;", "getType", "Ljava/lang/String;", "getText", "getHeader", "<init>", "(Lcom/avito/android/remote/model/BannerType;Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AlertBannerInfo implements Parcelable {
    public static final Parcelable.Creator<AlertBannerInfo> CREATOR = new Creator();
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @NotNull
    private final String header;
    @SerializedName("text")
    @Nullable
    private final String text;
    @SerializedName("type")
    @NotNull
    private final BannerType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AlertBannerInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AlertBannerInfo((BannerType) Enum.valueOf(BannerType.class, parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerInfo[] newArray(int i) {
            return new AlertBannerInfo[i];
        }
    }

    public AlertBannerInfo(@NotNull BannerType bannerType, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(bannerType, "type");
        Intrinsics.checkNotNullParameter(str, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        this.type = bannerType;
        this.header = str;
        this.text = str2;
    }

    public static /* synthetic */ AlertBannerInfo copy$default(AlertBannerInfo alertBannerInfo, BannerType bannerType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bannerType = alertBannerInfo.type;
        }
        if ((i & 2) != 0) {
            str = alertBannerInfo.header;
        }
        if ((i & 4) != 0) {
            str2 = alertBannerInfo.text;
        }
        return alertBannerInfo.copy(bannerType, str, str2);
    }

    @NotNull
    public final BannerType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.header;
    }

    @Nullable
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final AlertBannerInfo copy(@NotNull BannerType bannerType, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(bannerType, "type");
        Intrinsics.checkNotNullParameter(str, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        return new AlertBannerInfo(bannerType, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertBannerInfo)) {
            return false;
        }
        AlertBannerInfo alertBannerInfo = (AlertBannerInfo) obj;
        return Intrinsics.areEqual(this.type, alertBannerInfo.type) && Intrinsics.areEqual(this.header, alertBannerInfo.header) && Intrinsics.areEqual(this.text, alertBannerInfo.text);
    }

    @NotNull
    public final String getHeader() {
        return this.header;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final BannerType getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BannerType bannerType = this.type;
        int i = 0;
        int hashCode = (bannerType != null ? bannerType.hashCode() : 0) * 31;
        String str = this.header;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AlertBannerInfo(type=");
        L.append(this.type);
        L.append(", header=");
        L.append(this.header);
        L.append(", text=");
        return a.t(L, this.text, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type.name());
        parcel.writeString(this.header);
        parcel.writeString(this.text);
    }
}
