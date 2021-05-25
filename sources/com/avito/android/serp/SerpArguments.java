package com.avito.android.serp;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJV\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/avito/android/serp/SerpArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SearchParams;", "component2", "()Lcom/avito/android/remote/model/SearchParams;", "component3", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component4", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component5", "", "component6", "()Z", "subscriptionId", "searchParams", "context", "treeParent", "fromPage", "isVerticalMain", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Z)Lcom/avito/android/serp/SerpArguments;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", "f", "Z", "e", "Ljava/lang/String;", "getFromPage", AuthSource.SEND_ABUSE, "getSubscriptionId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "c", "getContext", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpArguments implements Parcelable {
    public static final Parcelable.Creator<SerpArguments> CREATOR = new Creator();
    @Nullable
    public final String a;
    @Nullable
    public final SearchParams b;
    @Nullable
    public final String c;
    @Nullable
    public final TreeClickStreamParent d;
    @Nullable
    public final String e;
    public final boolean f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SerpArguments(parcel.readString(), (SearchParams) parcel.readParcelable(SerpArguments.class.getClassLoader()), parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(SerpArguments.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpArguments[] newArray(int i) {
            return new SerpArguments[i];
        }
    }

    public SerpArguments() {
        this(null, null, null, null, null, false, 63, null);
    }

    public SerpArguments(@Nullable String str, @Nullable SearchParams searchParams, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str3, boolean z) {
        this.a = str;
        this.b = searchParams;
        this.c = str2;
        this.d = treeClickStreamParent;
        this.e = str3;
        this.f = z;
    }

    public static /* synthetic */ SerpArguments copy$default(SerpArguments serpArguments, String str, SearchParams searchParams, String str2, TreeClickStreamParent treeClickStreamParent, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serpArguments.a;
        }
        if ((i & 2) != 0) {
            searchParams = serpArguments.b;
        }
        if ((i & 4) != 0) {
            str2 = serpArguments.c;
        }
        if ((i & 8) != 0) {
            treeClickStreamParent = serpArguments.d;
        }
        if ((i & 16) != 0) {
            str3 = serpArguments.e;
        }
        if ((i & 32) != 0) {
            z = serpArguments.f;
        }
        return serpArguments.copy(str, searchParams, str2, treeClickStreamParent, str3, z);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final SearchParams component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final TreeClickStreamParent component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final SerpArguments copy(@Nullable String str, @Nullable SearchParams searchParams, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str3, boolean z) {
        return new SerpArguments(str, searchParams, str2, treeClickStreamParent, str3, z);
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
        if (!(obj instanceof SerpArguments)) {
            return false;
        }
        SerpArguments serpArguments = (SerpArguments) obj;
        return Intrinsics.areEqual(this.a, serpArguments.a) && Intrinsics.areEqual(this.b, serpArguments.b) && Intrinsics.areEqual(this.c, serpArguments.c) && Intrinsics.areEqual(this.d, serpArguments.d) && Intrinsics.areEqual(this.e, serpArguments.e) && this.f == serpArguments.f;
    }

    @Nullable
    public final String getContext() {
        return this.c;
    }

    @Nullable
    public final String getFromPage() {
        return this.e;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.b;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.a;
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
        SearchParams searchParams = this.b;
        int hashCode2 = (hashCode + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.d;
        int hashCode4 = (hashCode3 + (treeClickStreamParent != null ? treeClickStreamParent.hashCode() : 0)) * 31;
        String str3 = this.e;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isVerticalMain() {
        return this.f;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpArguments(subscriptionId=");
        L.append(this.a);
        L.append(", searchParams=");
        L.append(this.b);
        L.append(", context=");
        L.append(this.c);
        L.append(", treeParent=");
        L.append(this.d);
        L.append(", fromPage=");
        L.append(this.e);
        L.append(", isVerticalMain=");
        return a.B(L, this.f, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeInt(this.f ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpArguments(String str, SearchParams searchParams, String str2, TreeClickStreamParent treeClickStreamParent, String str3, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : searchParams, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : treeClickStreamParent, (i & 16) == 0 ? str3 : null, (i & 32) != 0 ? false : z);
    }
}
