package com.avito.android.advert.item;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\bE\u0010FJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jf\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b#\u0010\u0011J\u001a\u0010&\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010\u0011J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b-\u0010.R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u000eR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0004R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b\u001f\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\bR\u0019\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0011R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u0014¨\u0006G"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "component3", "()Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component4", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "", "component5", "()J", "", "component6", "()I", "Lcom/avito/android/rec/ScreenSource;", "component7", "()Lcom/avito/android/rec/ScreenSource;", "", "component8", "()Z", "itemId", "context", "fastOpenParams", "treeParent", "clickTime", "galleryPosition", "screenSource", "isMarketplace", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;JILcom/avito/android/rec/ScreenSource;Z)Lcom/avito/android/advert/item/AdvertDetailsArguments;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "J", "getClickTime", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContext", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", AuthSource.SEND_ABUSE, "getItemId", "h", "Z", "c", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "getFastOpenParams", "f", "I", "getGalleryPosition", g.a, "Lcom/avito/android/rec/ScreenSource;", "getScreenSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;JILcom/avito/android/rec/ScreenSource;Z)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsArguments implements Parcelable {
    public static final Parcelable.Creator<AdvertDetailsArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final AdvertDetailsFastOpenParams c;
    @Nullable
    public final TreeClickStreamParent d;
    public final long e;
    public final int f;
    @NotNull
    public final ScreenSource g;
    public final boolean h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsArguments(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? AdvertDetailsFastOpenParams.CREATOR.createFromParcel(parcel) : null, (TreeClickStreamParent) parcel.readParcelable(AdvertDetailsArguments.class.getClassLoader()), parcel.readLong(), parcel.readInt(), (ScreenSource) parcel.readParcelable(AdvertDetailsArguments.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsArguments[] newArray(int i) {
            return new AdvertDetailsArguments[i];
        }
    }

    public AdvertDetailsArguments(@NotNull String str, @Nullable String str2, @Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams, @Nullable TreeClickStreamParent treeClickStreamParent, long j, int i, @NotNull ScreenSource screenSource, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        this.a = str;
        this.b = str2;
        this.c = advertDetailsFastOpenParams;
        this.d = treeClickStreamParent;
        this.e = j;
        this.f = i;
        this.g = screenSource;
        this.h = z;
    }

    public static /* synthetic */ AdvertDetailsArguments copy$default(AdvertDetailsArguments advertDetailsArguments, String str, String str2, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, TreeClickStreamParent treeClickStreamParent, long j, int i, ScreenSource screenSource, boolean z, int i2, Object obj) {
        return advertDetailsArguments.copy((i2 & 1) != 0 ? advertDetailsArguments.a : str, (i2 & 2) != 0 ? advertDetailsArguments.b : str2, (i2 & 4) != 0 ? advertDetailsArguments.c : advertDetailsFastOpenParams, (i2 & 8) != 0 ? advertDetailsArguments.d : treeClickStreamParent, (i2 & 16) != 0 ? advertDetailsArguments.e : j, (i2 & 32) != 0 ? advertDetailsArguments.f : i, (i2 & 64) != 0 ? advertDetailsArguments.g : screenSource, (i2 & 128) != 0 ? advertDetailsArguments.h : z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final AdvertDetailsFastOpenParams component3() {
        return this.c;
    }

    @Nullable
    public final TreeClickStreamParent component4() {
        return this.d;
    }

    public final long component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    @NotNull
    public final ScreenSource component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    @NotNull
    public final AdvertDetailsArguments copy(@NotNull String str, @Nullable String str2, @Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams, @Nullable TreeClickStreamParent treeClickStreamParent, long j, int i, @NotNull ScreenSource screenSource, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        return new AdvertDetailsArguments(str, str2, advertDetailsFastOpenParams, treeClickStreamParent, j, i, screenSource, z);
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
        if (!(obj instanceof AdvertDetailsArguments)) {
            return false;
        }
        AdvertDetailsArguments advertDetailsArguments = (AdvertDetailsArguments) obj;
        return Intrinsics.areEqual(this.a, advertDetailsArguments.a) && Intrinsics.areEqual(this.b, advertDetailsArguments.b) && Intrinsics.areEqual(this.c, advertDetailsArguments.c) && Intrinsics.areEqual(this.d, advertDetailsArguments.d) && this.e == advertDetailsArguments.e && this.f == advertDetailsArguments.f && Intrinsics.areEqual(this.g, advertDetailsArguments.g) && this.h == advertDetailsArguments.h;
    }

    public final long getClickTime() {
        return this.e;
    }

    @Nullable
    public final String getContext() {
        return this.b;
    }

    @Nullable
    public final AdvertDetailsFastOpenParams getFastOpenParams() {
        return this.c;
    }

    public final int getGalleryPosition() {
        return this.f;
    }

    @NotNull
    public final String getItemId() {
        return this.a;
    }

    @NotNull
    public final ScreenSource getScreenSource() {
        return this.g;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        AdvertDetailsFastOpenParams advertDetailsFastOpenParams = this.c;
        int hashCode3 = (hashCode2 + (advertDetailsFastOpenParams != null ? advertDetailsFastOpenParams.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.d;
        int hashCode4 = (((((hashCode3 + (treeClickStreamParent != null ? treeClickStreamParent.hashCode() : 0)) * 31) + c.a(this.e)) * 31) + this.f) * 31;
        ScreenSource screenSource = this.g;
        if (screenSource != null) {
            i = screenSource.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.h;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isMarketplace() {
        return this.h;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertDetailsArguments(itemId=");
        L.append(this.a);
        L.append(", context=");
        L.append(this.b);
        L.append(", fastOpenParams=");
        L.append(this.c);
        L.append(", treeParent=");
        L.append(this.d);
        L.append(", clickTime=");
        L.append(this.e);
        L.append(", galleryPosition=");
        L.append(this.f);
        L.append(", screenSource=");
        L.append(this.g);
        L.append(", isMarketplace=");
        return a.B(L, this.h, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        AdvertDetailsFastOpenParams advertDetailsFastOpenParams = this.c;
        if (advertDetailsFastOpenParams != null) {
            parcel.writeInt(1);
            advertDetailsFastOpenParams.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.d, i);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeParcelable(this.g, i);
        parcel.writeInt(this.h ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsArguments(String str, String str2, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, TreeClickStreamParent treeClickStreamParent, long j, int i, ScreenSource screenSource, boolean z, int i2, j jVar) {
        this(str, str2, advertDetailsFastOpenParams, treeClickStreamParent, (i2 & 16) != 0 ? 0 : j, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? ScreenSource.EMPTY.INSTANCE : screenSource, (i2 & 128) != 0 ? false : z);
    }
}
