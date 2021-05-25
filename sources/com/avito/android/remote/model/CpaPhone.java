package com.avito.android.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\n\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/CpaPhone;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "phone", "isDefault", "isConfirmed", "copy", "(Ljava/lang/String;ZZ)Lcom/avito/android/remote/model/CpaPhone;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "Ljava/lang/String;", "getPhone", "<init>", "(Ljava/lang/String;ZZ)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaPhone implements Parcelable {
    public static final Parcelable.Creator<CpaPhone> CREATOR = new Creator();
    @SerializedName("isConfirmed")
    private final boolean isConfirmed;
    @SerializedName("isDefault")
    private final boolean isDefault;
    @SerializedName("phone")
    @NotNull
    private final String phone;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CpaPhone> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpaPhone createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new CpaPhone(readString, z2, z);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpaPhone[] newArray(int i) {
            return new CpaPhone[i];
        }
    }

    public CpaPhone(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.phone = str;
        this.isDefault = z;
        this.isConfirmed = z2;
    }

    public static /* synthetic */ CpaPhone copy$default(CpaPhone cpaPhone, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cpaPhone.phone;
        }
        if ((i & 2) != 0) {
            z = cpaPhone.isDefault;
        }
        if ((i & 4) != 0) {
            z2 = cpaPhone.isConfirmed;
        }
        return cpaPhone.copy(str, z, z2);
    }

    @NotNull
    public final String component1() {
        return this.phone;
    }

    public final boolean component2() {
        return this.isDefault;
    }

    public final boolean component3() {
        return this.isConfirmed;
    }

    @NotNull
    public final CpaPhone copy(@NotNull String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        return new CpaPhone(str, z, z2);
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
        if (!(obj instanceof CpaPhone)) {
            return false;
        }
        CpaPhone cpaPhone = (CpaPhone) obj;
        return Intrinsics.areEqual(this.phone, cpaPhone.phone) && this.isDefault == cpaPhone.isDefault && this.isConfirmed == cpaPhone.isConfirmed;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.phone;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isDefault;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        boolean z2 = this.isConfirmed;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        return i5 + i;
    }

    public final boolean isConfirmed() {
        return this.isConfirmed;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CpaPhone(phone=");
        L.append(this.phone);
        L.append(", isDefault=");
        L.append(this.isDefault);
        L.append(", isConfirmed=");
        return a.B(L, this.isConfirmed, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.phone);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.isConfirmed ? 1 : 0);
    }
}
