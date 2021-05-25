package com.avito.android.serp;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b \b\b\u0018\u0000 N2\u00020\u0001:\u0001NBi\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0004\bL\u0010MJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0010J\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u001a2\b\b\u0002\u0010)\u001a\u00020\u000e2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b-\u0010\rJ\u0010\u0010.\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b.\u0010\nJ\u001a\u00101\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u0019\u0010'\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0019R\u0019\u0010%\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0015R\u0019\u0010)\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0010R\u0019\u0010&\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010\u0015R'\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010 R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\rR\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010B\u001a\u0004\bE\u0010\rR\u0019\u0010(\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u001cR\u0019\u0010\"\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\b\"\u0010\u0010R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010B\u001a\u0004\bK\u0010\r¨\u0006O"}, d2 = {"Lcom/avito/android/serp/SerpValues;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "", "component5", "()J", "component6", "Lcom/avito/android/remote/model/SearchParams;", "component7", "()Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/remote/model/SerpDisplayType;", "component8", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component9", "", "component10", "()Ljava/util/Map;", "searchHint", "isSubscribed", "subscriptionId", "context", UrlParams.LAST_STAMP, "count", "searchParams", "displayType", "hasMorePages", "firebaseParams", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JJLcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SerpDisplayType;ZLjava/util/Map;)Lcom/avito/android/serp/SerpValues;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", g.a, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "e", "J", "getLastStamp", "i", "Z", "getHasMorePages", "f", "getCount", "j", "Ljava/util/Map;", "getFirebaseParams", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSearchHint", "d", "getContext", "h", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", AuthSource.BOOKING_ORDER, "c", "getSubscriptionId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JJLcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/SerpDisplayType;ZLjava/util/Map;)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpValues implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpValues> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final boolean b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    public final long e;
    public final long f;
    @NotNull
    public final SearchParams g;
    @NotNull
    public final SerpDisplayType h;
    public final boolean i;
    @Nullable
    public final Map<String, String> j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/SerpValues$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/SerpValues;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SerpValues> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SerpValues invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new SerpValues(a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2), parcel2.readString(), parcel2.readString(), parcel2.readLong(), parcel2.readLong(), (SearchParams) a2.b.a.a.a.z1(SearchParams.class, parcel2), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()), ParcelsKt.readBool(parcel2), ParcelUtils.createValueMap(parcel2, String.class, String.class));
        }
    }

    public SerpValues(@NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, long j2, long j3, @NotNull SearchParams searchParams, @NotNull SerpDisplayType serpDisplayType, boolean z2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "searchHint");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = str3;
        this.e = j2;
        this.f = j3;
        this.g = searchParams;
        this.h = serpDisplayType;
        this.i = z2;
        this.j = map;
    }

    public static /* synthetic */ SerpValues copy$default(SerpValues serpValues, String str, boolean z, String str2, String str3, long j2, long j3, SearchParams searchParams, SerpDisplayType serpDisplayType, boolean z2, Map map, int i2, Object obj) {
        return serpValues.copy((i2 & 1) != 0 ? serpValues.a : str, (i2 & 2) != 0 ? serpValues.b : z, (i2 & 4) != 0 ? serpValues.c : str2, (i2 & 8) != 0 ? serpValues.d : str3, (i2 & 16) != 0 ? serpValues.e : j2, (i2 & 32) != 0 ? serpValues.f : j3, (i2 & 64) != 0 ? serpValues.g : searchParams, (i2 & 128) != 0 ? serpValues.h : serpDisplayType, (i2 & 256) != 0 ? serpValues.i : z2, (i2 & 512) != 0 ? serpValues.j : map);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Map<String, String> component10() {
        return this.j;
    }

    public final boolean component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    public final long component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    @NotNull
    public final SearchParams component7() {
        return this.g;
    }

    @NotNull
    public final SerpDisplayType component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final SerpValues copy(@NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, long j2, long j3, @NotNull SearchParams searchParams, @NotNull SerpDisplayType serpDisplayType, boolean z2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "searchHint");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        return new SerpValues(str, z, str2, str3, j2, j3, searchParams, serpDisplayType, z2, map);
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
        if (!(obj instanceof SerpValues)) {
            return false;
        }
        SerpValues serpValues = (SerpValues) obj;
        return Intrinsics.areEqual(this.a, serpValues.a) && this.b == serpValues.b && Intrinsics.areEqual(this.c, serpValues.c) && Intrinsics.areEqual(this.d, serpValues.d) && this.e == serpValues.e && this.f == serpValues.f && Intrinsics.areEqual(this.g, serpValues.g) && Intrinsics.areEqual(this.h, serpValues.h) && this.i == serpValues.i && Intrinsics.areEqual(this.j, serpValues.j);
    }

    @Nullable
    public final String getContext() {
        return this.d;
    }

    public final long getCount() {
        return this.f;
    }

    @NotNull
    public final SerpDisplayType getDisplayType() {
        return this.h;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.j;
    }

    public final boolean getHasMorePages() {
        return this.i;
    }

    public final long getLastStamp() {
        return this.e;
    }

    @NotNull
    public final String getSearchHint() {
        return this.a;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.g;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode + i4) * 31;
        String str2 = this.c;
        int hashCode2 = (i7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.e)) * 31) + c.a(this.f)) * 31;
        SearchParams searchParams = this.g;
        int hashCode4 = (hashCode3 + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        SerpDisplayType serpDisplayType = this.h;
        int hashCode5 = (hashCode4 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
        boolean z2 = this.i;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        int i8 = (hashCode5 + i3) * 31;
        Map<String, String> map = this.j;
        if (map != null) {
            i2 = map.hashCode();
        }
        return i8 + i2;
    }

    public final boolean isSubscribed() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SerpValues(searchHint=");
        L.append(this.a);
        L.append(", isSubscribed=");
        L.append(this.b);
        L.append(", subscriptionId=");
        L.append(this.c);
        L.append(", context=");
        L.append(this.d);
        L.append(", lastStamp=");
        L.append(this.e);
        L.append(", count=");
        L.append(this.f);
        L.append(", searchParams=");
        L.append(this.g);
        L.append(", displayType=");
        L.append(this.h);
        L.append(", hasMorePages=");
        L.append(this.i);
        L.append(", firebaseParams=");
        return a2.b.a.a.a.x(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        ParcelsKt.writeBool(parcel, this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeParcelable(this.g, i2);
        ParcelsKt.writeEnum(parcel, this.h);
        ParcelsKt.writeBool(parcel, this.i);
        ParcelsKt.writeValueMap(parcel, this.j);
    }
}
