package com.avito.android.remote.model.advert_details;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\b\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "Landroid/os/Parcelable;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "isOnline", "replySpeed", "copy", "(ZLjava/lang/String;)Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getReplySpeed", "Z", "<init>", "(ZLjava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SellerOnlineStatus implements Parcelable {
    public static final Parcelable.Creator<SellerOnlineStatus> CREATOR = new Creator();
    private final boolean isOnline;
    @Nullable
    private final String replySpeed;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellerOnlineStatus> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerOnlineStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SellerOnlineStatus(parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerOnlineStatus[] newArray(int i) {
            return new SellerOnlineStatus[i];
        }
    }

    public SellerOnlineStatus(boolean z, @Nullable String str) {
        this.isOnline = z;
        this.replySpeed = str;
    }

    public static /* synthetic */ SellerOnlineStatus copy$default(SellerOnlineStatus sellerOnlineStatus, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sellerOnlineStatus.isOnline;
        }
        if ((i & 2) != 0) {
            str = sellerOnlineStatus.replySpeed;
        }
        return sellerOnlineStatus.copy(z, str);
    }

    public final boolean component1() {
        return this.isOnline;
    }

    @Nullable
    public final String component2() {
        return this.replySpeed;
    }

    @NotNull
    public final SellerOnlineStatus copy(boolean z, @Nullable String str) {
        return new SellerOnlineStatus(z, str);
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
        if (!(obj instanceof SellerOnlineStatus)) {
            return false;
        }
        SellerOnlineStatus sellerOnlineStatus = (SellerOnlineStatus) obj;
        return this.isOnline == sellerOnlineStatus.isOnline && Intrinsics.areEqual(this.replySpeed, sellerOnlineStatus.replySpeed);
    }

    @Nullable
    public final String getReplySpeed() {
        return this.replySpeed;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.isOnline;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.replySpeed;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SellerOnlineStatus(isOnline=");
        L.append(this.isOnline);
        L.append(", replySpeed=");
        return a.t(L, this.replySpeed, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.isOnline ? 1 : 0);
        parcel.writeString(this.replySpeed);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellerOnlineStatus(boolean z, String str, int i, j jVar) {
        this(z, (i & 2) != 0 ? null : str);
    }
}
