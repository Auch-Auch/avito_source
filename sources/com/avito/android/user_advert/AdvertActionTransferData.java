package com.avito.android.user_advert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0001,B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\tR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/user_advert/AdvertActionTransferData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/user_advert/AdvertActionTransferData$Type;", "component4", "()Lcom/avito/android/user_advert/AdvertActionTransferData$Type;", "soaAdvertId", "message", "categoryId", "actionType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData$Type;)Lcom/avito/android/user_advert/AdvertActionTransferData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/user_advert/AdvertActionTransferData$Type;", "getActionType", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", AuthSource.SEND_ABUSE, "getSoaAdvertId", "c", "getCategoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData$Type;)V", "Type", "core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertActionTransferData implements Parcelable {
    public static final Parcelable.Creator<AdvertActionTransferData> CREATOR = new Creator();
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Type d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertActionTransferData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertActionTransferData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertActionTransferData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Type) Enum.valueOf(Type.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertActionTransferData[] newArray(int i) {
            return new AdvertActionTransferData[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/user_advert/AdvertActionTransferData$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVATE", "UNKNOWN", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        ACTIVATE,
        UNKNOWN
    }

    public AdvertActionTransferData() {
        this(null, null, null, null, 15, null);
    }

    public AdvertActionTransferData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Type type) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = type;
    }

    public static /* synthetic */ AdvertActionTransferData copy$default(AdvertActionTransferData advertActionTransferData, String str, String str2, String str3, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advertActionTransferData.a;
        }
        if ((i & 2) != 0) {
            str2 = advertActionTransferData.b;
        }
        if ((i & 4) != 0) {
            str3 = advertActionTransferData.c;
        }
        if ((i & 8) != 0) {
            type = advertActionTransferData.d;
        }
        return advertActionTransferData.copy(str, str2, str3, type);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final Type component4() {
        return this.d;
    }

    @NotNull
    public final AdvertActionTransferData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Type type) {
        return new AdvertActionTransferData(str, str2, str3, type);
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
        if (!(obj instanceof AdvertActionTransferData)) {
            return false;
        }
        AdvertActionTransferData advertActionTransferData = (AdvertActionTransferData) obj;
        return Intrinsics.areEqual(this.a, advertActionTransferData.a) && Intrinsics.areEqual(this.b, advertActionTransferData.b) && Intrinsics.areEqual(this.c, advertActionTransferData.c) && Intrinsics.areEqual(this.d, advertActionTransferData.d);
    }

    @Nullable
    public final Type getActionType() {
        return this.d;
    }

    @Nullable
    public final String getCategoryId() {
        return this.c;
    }

    @Nullable
    public final String getMessage() {
        return this.b;
    }

    @Nullable
    public final String getSoaAdvertId() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Type type = this.d;
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertActionTransferData(soaAdvertId=");
        L.append(this.a);
        L.append(", message=");
        L.append(this.b);
        L.append(", categoryId=");
        L.append(this.c);
        L.append(", actionType=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        Type type = this.d;
        if (type != null) {
            parcel.writeInt(1);
            parcel.writeString(type.name());
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertActionTransferData(String str, String str2, String str3, Type type, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? Type.UNKNOWN : type);
    }
}
