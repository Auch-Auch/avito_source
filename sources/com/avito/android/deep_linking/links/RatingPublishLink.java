package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u001a\b\b\u0018\u0000 :2\u00020\u0001:\u0001:BK\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\\\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000bR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0013R\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b/\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010\u000bR\u0019\u0010\u0017\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010\u000fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u0010\u000b¨\u0006;"}, d2 = {"Lcom/avito/android/deep_linking/links/RatingPublishLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "component6", "()Ljava/lang/Integer;", "component7", "userKey", "context", "dealProof", "buyerInfo", "itemId", "score", "isAuto", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Z)Lcom/avito/android/deep_linking/links/RatingPublishLink;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "i", "Ljava/lang/Integer;", "getScore", "j", "Z", "e", "getContext", g.a, "getBuyerInfo", "d", "getUserKey", "f", "getDealProof", "h", "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<RatingPublishLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/rating/publish";
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    public final boolean f;
    public final boolean g;
    @Nullable
    public final String h;
    @Nullable
    public final Integer i;
    public final boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/RatingPublishLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/RatingPublishLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, RatingPublishLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public RatingPublishLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString = parcel2.readString();
            boolean readBool = ParcelsKt.readBool(parcel2);
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            String readString2 = parcel2.readString();
            Object readValue = parcel2.readValue(Integer.class.getClassLoader());
            if (!(readValue instanceof Integer)) {
                readValue = null;
            }
            return new RatingPublishLink(u2, readString, readBool, readBool2, readString2, (Integer) readValue, ParcelsKt.readBool(parcel2));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingPublishLink(String str, String str2, boolean z, boolean z2, String str3, Integer num, boolean z3, int i2, j jVar) {
        this(str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, str3, num, (i2 & 64) != 0 ? false : z3);
    }

    public static /* synthetic */ RatingPublishLink copy$default(RatingPublishLink ratingPublishLink, String str, String str2, boolean z, boolean z2, String str3, Integer num, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ratingPublishLink.d;
        }
        if ((i2 & 2) != 0) {
            str2 = ratingPublishLink.e;
        }
        if ((i2 & 4) != 0) {
            z = ratingPublishLink.f;
        }
        if ((i2 & 8) != 0) {
            z2 = ratingPublishLink.g;
        }
        if ((i2 & 16) != 0) {
            str3 = ratingPublishLink.h;
        }
        if ((i2 & 32) != 0) {
            num = ratingPublishLink.i;
        }
        if ((i2 & 64) != 0) {
            z3 = ratingPublishLink.j;
        }
        return ratingPublishLink.copy(str, str2, z, z2, str3, num, z3);
    }

    @NotNull
    public final String component1() {
        return this.d;
    }

    @Nullable
    public final String component2() {
        return this.e;
    }

    public final boolean component3() {
        return this.f;
    }

    public final boolean component4() {
        return this.g;
    }

    @Nullable
    public final String component5() {
        return this.h;
    }

    @Nullable
    public final Integer component6() {
        return this.i;
    }

    public final boolean component7() {
        return this.j;
    }

    @NotNull
    public final RatingPublishLink copy(@NotNull String str, @Nullable String str2, boolean z, boolean z2, @Nullable String str3, @Nullable Integer num, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return new RatingPublishLink(str, str2, z, z2, str3, num, z3);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingPublishLink)) {
            return false;
        }
        RatingPublishLink ratingPublishLink = (RatingPublishLink) obj;
        return Intrinsics.areEqual(this.d, ratingPublishLink.d) && Intrinsics.areEqual(this.e, ratingPublishLink.e) && this.f == ratingPublishLink.f && this.g == ratingPublishLink.g && Intrinsics.areEqual(this.h, ratingPublishLink.h) && Intrinsics.areEqual(this.i, ratingPublishLink.i) && this.j == ratingPublishLink.j;
    }

    public final boolean getBuyerInfo() {
        return this.g;
    }

    @Nullable
    public final String getContext() {
        return this.e;
    }

    public final boolean getDealProof() {
        return this.f;
    }

    @Nullable
    public final String getItemId() {
        return this.h;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final Integer getScore() {
        return this.i;
    }

    @NotNull
    public final String getUserKey() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.f;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode2 + i4) * 31;
        boolean z2 = this.g;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        String str3 = this.h;
        int hashCode3 = (i11 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.i;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i12 = (hashCode3 + i2) * 31;
        boolean z3 = this.j;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        return i12 + i3;
    }

    public final boolean isAuto() {
        return this.j;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("RatingPublishLink(userKey=");
        L.append(this.d);
        L.append(", context=");
        L.append(this.e);
        L.append(", dealProof=");
        L.append(this.f);
        L.append(", buyerInfo=");
        L.append(this.g);
        L.append(", itemId=");
        L.append(this.h);
        L.append(", score=");
        L.append(this.i);
        L.append(", isAuto=");
        return a2.b.a.a.a.B(L, this.j, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        ParcelsKt.writeBool(parcel, this.f);
        ParcelsKt.writeBool(parcel, this.g);
        parcel.writeString(this.h);
        ParcelsKt.writeNullableValue(parcel, this.i);
        ParcelsKt.writeBool(parcel, this.j);
    }

    public RatingPublishLink(@NotNull String str, @Nullable String str2, boolean z, boolean z2, @Nullable String str3, @Nullable Integer num, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = z2;
        this.h = str3;
        this.i = num;
        this.j = z3;
        this.c = PATH;
    }
}
