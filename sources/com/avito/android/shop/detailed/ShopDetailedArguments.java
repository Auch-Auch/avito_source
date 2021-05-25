package com.avito.android.shop.detailed;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\fR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010(\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\tR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/SearchParams;", "component4", "()Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component5", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "shopId", "pageFrom", "context", "searchParams", "treeParent", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/shop/detailed/ShopDetailedArguments;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPageFrom", AuthSource.SEND_ABUSE, "getShopId", "d", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "c", "getContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedArguments implements Parcelable {
    public static final Parcelable.Creator<ShopDetailedArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final SearchParams d;
    @Nullable
    public final TreeClickStreamParent e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopDetailedArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopDetailedArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopDetailedArguments(parcel.readString(), parcel.readString(), parcel.readString(), (SearchParams) parcel.readParcelable(ShopDetailedArguments.class.getClassLoader()), (TreeClickStreamParent) parcel.readParcelable(ShopDetailedArguments.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopDetailedArguments[] newArray(int i) {
            return new ShopDetailedArguments[i];
        }
    }

    public ShopDetailedArguments(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull SearchParams searchParams, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = searchParams;
        this.e = treeClickStreamParent;
    }

    public static /* synthetic */ ShopDetailedArguments copy$default(ShopDetailedArguments shopDetailedArguments, String str, String str2, String str3, SearchParams searchParams, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopDetailedArguments.a;
        }
        if ((i & 2) != 0) {
            str2 = shopDetailedArguments.b;
        }
        if ((i & 4) != 0) {
            str3 = shopDetailedArguments.c;
        }
        if ((i & 8) != 0) {
            searchParams = shopDetailedArguments.d;
        }
        if ((i & 16) != 0) {
            treeClickStreamParent = shopDetailedArguments.e;
        }
        return shopDetailedArguments.copy(str, str2, str3, searchParams, treeClickStreamParent);
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
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final SearchParams component4() {
        return this.d;
    }

    @Nullable
    public final TreeClickStreamParent component5() {
        return this.e;
    }

    @NotNull
    public final ShopDetailedArguments copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull SearchParams searchParams, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return new ShopDetailedArguments(str, str2, str3, searchParams, treeClickStreamParent);
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
        if (!(obj instanceof ShopDetailedArguments)) {
            return false;
        }
        ShopDetailedArguments shopDetailedArguments = (ShopDetailedArguments) obj;
        return Intrinsics.areEqual(this.a, shopDetailedArguments.a) && Intrinsics.areEqual(this.b, shopDetailedArguments.b) && Intrinsics.areEqual(this.c, shopDetailedArguments.c) && Intrinsics.areEqual(this.d, shopDetailedArguments.d) && Intrinsics.areEqual(this.e, shopDetailedArguments.e);
    }

    @Nullable
    public final String getContext() {
        return this.c;
    }

    @Nullable
    public final String getPageFrom() {
        return this.b;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.d;
    }

    @NotNull
    public final String getShopId() {
        return this.a;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.e;
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
        SearchParams searchParams = this.d;
        int hashCode4 = (hashCode3 + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.e;
        if (treeClickStreamParent != null) {
            i = treeClickStreamParent.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopDetailedArguments(shopId=");
        L.append(this.a);
        L.append(", pageFrom=");
        L.append(this.b);
        L.append(", context=");
        L.append(this.c);
        L.append(", searchParams=");
        L.append(this.d);
        L.append(", treeParent=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
    }
}
