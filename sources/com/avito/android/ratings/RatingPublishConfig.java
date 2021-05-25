package com.avito.android.ratings;

import a2.b.a.a.a;
import a2.g.r.g;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b$\u0010%R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b\u0013\u0010\bR\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u0010\b¨\u00068"}, d2 = {"Lcom/avito/android/ratings/RatingPublishConfig;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "userKey", "context", "shouldProveDeal", "needBuyerInfo", "isAuto", "itemId", "score", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/ratings/RatingPublishConfig;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserKey", "f", "getItemId", AuthSource.BOOKING_ORDER, "getContext", g.a, "Ljava/lang/Integer;", "getScore", "c", "Z", "getShouldProveDeal", "e", "d", "getNeedBuyerInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/Integer;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishConfig implements Parcelable {
    public static final Parcelable.Creator<RatingPublishConfig> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    @Nullable
    public final String f;
    @Nullable
    public final Integer g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RatingPublishConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RatingPublishConfig(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishConfig[] newArray(int i) {
            return new RatingPublishConfig[i];
        }
    }

    public RatingPublishConfig(@NotNull String str, @Nullable String str2, boolean z, boolean z2, boolean z3, @Nullable String str3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = str3;
        this.g = num;
    }

    public static /* synthetic */ RatingPublishConfig copy$default(RatingPublishConfig ratingPublishConfig, String str, String str2, boolean z, boolean z2, boolean z3, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ratingPublishConfig.a;
        }
        if ((i & 2) != 0) {
            str2 = ratingPublishConfig.b;
        }
        if ((i & 4) != 0) {
            z = ratingPublishConfig.c;
        }
        if ((i & 8) != 0) {
            z2 = ratingPublishConfig.d;
        }
        if ((i & 16) != 0) {
            z3 = ratingPublishConfig.e;
        }
        if ((i & 32) != 0) {
            str3 = ratingPublishConfig.f;
        }
        if ((i & 64) != 0) {
            num = ratingPublishConfig.g;
        }
        return ratingPublishConfig.copy(str, str2, z, z2, z3, str3, num);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final Integer component7() {
        return this.g;
    }

    @NotNull
    public final RatingPublishConfig copy(@NotNull String str, @Nullable String str2, boolean z, boolean z2, boolean z3, @Nullable String str3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return new RatingPublishConfig(str, str2, z, z2, z3, str3, num);
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
        if (!(obj instanceof RatingPublishConfig)) {
            return false;
        }
        RatingPublishConfig ratingPublishConfig = (RatingPublishConfig) obj;
        return Intrinsics.areEqual(this.a, ratingPublishConfig.a) && Intrinsics.areEqual(this.b, ratingPublishConfig.b) && this.c == ratingPublishConfig.c && this.d == ratingPublishConfig.d && this.e == ratingPublishConfig.e && Intrinsics.areEqual(this.f, ratingPublishConfig.f) && Intrinsics.areEqual(this.g, ratingPublishConfig.g);
    }

    @Nullable
    public final String getContext() {
        return this.b;
    }

    @Nullable
    public final String getItemId() {
        return this.f;
    }

    public final boolean getNeedBuyerInfo() {
        return this.d;
    }

    @Nullable
    public final Integer getScore() {
        return this.g;
    }

    public final boolean getShouldProveDeal() {
        return this.c;
    }

    @NotNull
    public final String getUserKey() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.c;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        boolean z2 = this.d;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (i6 + i7) * 31;
        boolean z3 = this.e;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        int i11 = (i10 + i2) * 31;
        String str3 = this.f;
        int hashCode3 = (i11 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.g;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isAuto() {
        return this.e;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RatingPublishConfig(userKey=");
        L.append(this.a);
        L.append(", context=");
        L.append(this.b);
        L.append(", shouldProveDeal=");
        L.append(this.c);
        L.append(", needBuyerInfo=");
        L.append(this.d);
        L.append(", isAuto=");
        L.append(this.e);
        L.append(", itemId=");
        L.append(this.f);
        L.append(", score=");
        return a.p(L, this.g, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeString(this.f);
        Integer num = this.g;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingPublishConfig(String str, String str2, boolean z, boolean z2, boolean z3, String str3, Integer num, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : num);
    }
}
