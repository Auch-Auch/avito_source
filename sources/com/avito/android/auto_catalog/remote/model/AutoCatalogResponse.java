package com.avito.android.auto_catalog.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b%\u0010&R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u000bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b-\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b.\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u0010\b¨\u00063"}, d2 = {"Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/auto_catalog/remote/model/AutoModifications;", "component3", "()Lcom/avito/android/auto_catalog/remote/model/AutoModifications;", "", "component4", "()Ljava/lang/Integer;", "component5", "Lcom/avito/android/auto_catalog/remote/model/Additional;", "component6", "()Lcom/avito/android/auto_catalog/remote/model/Additional;", "title", "image", "modifications", "defaultModificationId", "share", "additional", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/auto_catalog/remote/model/AutoModifications;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/auto_catalog/remote/model/Additional;)Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getDefaultModificationId", "Ljava/lang/String;", "getShare", "Lcom/avito/android/auto_catalog/remote/model/Additional;", "getAdditional", "getTitle", "getImage", "Lcom/avito/android/auto_catalog/remote/model/AutoModifications;", "getModifications", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/auto_catalog/remote/model/AutoModifications;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/auto_catalog/remote/model/Additional;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogResponse implements Parcelable {
    public static final Parcelable.Creator<AutoCatalogResponse> CREATOR = new Creator();
    @SerializedName("additional")
    @Nullable
    private final Additional additional;
    @SerializedName("defaultModificationId")
    @Nullable
    private final Integer defaultModificationId;
    @SerializedName("image")
    @Nullable
    private final String image;
    @SerializedName("modifications")
    @Nullable
    private final AutoModifications modifications;
    @SerializedName("share")
    @Nullable
    private final String share;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutoCatalogResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoCatalogResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AutoCatalogResponse(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? AutoModifications.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt() != 0 ? Additional.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoCatalogResponse[] newArray(int i) {
            return new AutoCatalogResponse[i];
        }
    }

    public AutoCatalogResponse(@Nullable String str, @Nullable String str2, @Nullable AutoModifications autoModifications, @Nullable Integer num, @Nullable String str3, @Nullable Additional additional2) {
        this.title = str;
        this.image = str2;
        this.modifications = autoModifications;
        this.defaultModificationId = num;
        this.share = str3;
        this.additional = additional2;
    }

    public static /* synthetic */ AutoCatalogResponse copy$default(AutoCatalogResponse autoCatalogResponse, String str, String str2, AutoModifications autoModifications, Integer num, String str3, Additional additional2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autoCatalogResponse.title;
        }
        if ((i & 2) != 0) {
            str2 = autoCatalogResponse.image;
        }
        if ((i & 4) != 0) {
            autoModifications = autoCatalogResponse.modifications;
        }
        if ((i & 8) != 0) {
            num = autoCatalogResponse.defaultModificationId;
        }
        if ((i & 16) != 0) {
            str3 = autoCatalogResponse.share;
        }
        if ((i & 32) != 0) {
            additional2 = autoCatalogResponse.additional;
        }
        return autoCatalogResponse.copy(str, str2, autoModifications, num, str3, additional2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.image;
    }

    @Nullable
    public final AutoModifications component3() {
        return this.modifications;
    }

    @Nullable
    public final Integer component4() {
        return this.defaultModificationId;
    }

    @Nullable
    public final String component5() {
        return this.share;
    }

    @Nullable
    public final Additional component6() {
        return this.additional;
    }

    @NotNull
    public final AutoCatalogResponse copy(@Nullable String str, @Nullable String str2, @Nullable AutoModifications autoModifications, @Nullable Integer num, @Nullable String str3, @Nullable Additional additional2) {
        return new AutoCatalogResponse(str, str2, autoModifications, num, str3, additional2);
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
        if (!(obj instanceof AutoCatalogResponse)) {
            return false;
        }
        AutoCatalogResponse autoCatalogResponse = (AutoCatalogResponse) obj;
        return Intrinsics.areEqual(this.title, autoCatalogResponse.title) && Intrinsics.areEqual(this.image, autoCatalogResponse.image) && Intrinsics.areEqual(this.modifications, autoCatalogResponse.modifications) && Intrinsics.areEqual(this.defaultModificationId, autoCatalogResponse.defaultModificationId) && Intrinsics.areEqual(this.share, autoCatalogResponse.share) && Intrinsics.areEqual(this.additional, autoCatalogResponse.additional);
    }

    @Nullable
    public final Additional getAdditional() {
        return this.additional;
    }

    @Nullable
    public final Integer getDefaultModificationId() {
        return this.defaultModificationId;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final AutoModifications getModifications() {
        return this.modifications;
    }

    @Nullable
    public final String getShare() {
        return this.share;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        AutoModifications autoModifications = this.modifications;
        int hashCode3 = (hashCode2 + (autoModifications != null ? autoModifications.hashCode() : 0)) * 31;
        Integer num = this.defaultModificationId;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.share;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Additional additional2 = this.additional;
        if (additional2 != null) {
            i = additional2.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutoCatalogResponse(title=");
        L.append(this.title);
        L.append(", image=");
        L.append(this.image);
        L.append(", modifications=");
        L.append(this.modifications);
        L.append(", defaultModificationId=");
        L.append(this.defaultModificationId);
        L.append(", share=");
        L.append(this.share);
        L.append(", additional=");
        L.append(this.additional);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.image);
        AutoModifications autoModifications = this.modifications;
        if (autoModifications != null) {
            parcel.writeInt(1);
            autoModifications.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.defaultModificationId;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.share);
        Additional additional2 = this.additional;
        if (additional2 != null) {
            parcel.writeInt(1);
            additional2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
