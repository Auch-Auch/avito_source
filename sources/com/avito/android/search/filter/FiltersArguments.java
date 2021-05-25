package com.avito.android.search.filter;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.FilterAnalyticsData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJP\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\"\u0010\u001dJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b'\u0010(R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\nR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0010¨\u0006;"}, d2 = {"Lcom/avito/android/search/filter/FiltersArguments;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SearchParams;", "component1", "()Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/remote/model/search/map/Area;", "component2", "()Lcom/avito/android/remote/model/search/map/Area;", "", "component3", "()Ljava/lang/String;", "", "component4", "()Z", "Lcom/avito/android/FilterAnalyticsData;", "component5", "()Lcom/avito/android/FilterAnalyticsData;", "component6", "searchParams", "searchArea", "mapSerpState", "isOnlySortShown", "analyticsData", UrlParams.SIMPLE_MAP, "copy", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/FilterAnalyticsData;Z)Lcom/avito/android/search/filter/FiltersArguments;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/search/map/Area;", "getSearchArea", "f", "Z", "getShowSimpleMap", "c", "Ljava/lang/String;", "getMapSerpState", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "d", "e", "Lcom/avito/android/FilterAnalyticsData;", "getAnalyticsData", "<init>", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/FilterAnalyticsData;Z)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersArguments implements Parcelable {
    public static final Parcelable.Creator<FiltersArguments> CREATOR = new Creator();
    @NotNull
    public final SearchParams a;
    @Nullable
    public final Area b;
    @Nullable
    public final String c;
    public final boolean d;
    @NotNull
    public final FilterAnalyticsData e;
    public final boolean f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FiltersArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FiltersArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FiltersArguments((SearchParams) parcel.readParcelable(FiltersArguments.class.getClassLoader()), (Area) parcel.readParcelable(FiltersArguments.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, (FilterAnalyticsData) parcel.readParcelable(FiltersArguments.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FiltersArguments[] newArray(int i) {
            return new FiltersArguments[i];
        }
    }

    public FiltersArguments(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, boolean z, @NotNull FilterAnalyticsData filterAnalyticsData, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(filterAnalyticsData, "analyticsData");
        this.a = searchParams;
        this.b = area;
        this.c = str;
        this.d = z;
        this.e = filterAnalyticsData;
        this.f = z2;
    }

    public static /* synthetic */ FiltersArguments copy$default(FiltersArguments filtersArguments, SearchParams searchParams, Area area, String str, boolean z, FilterAnalyticsData filterAnalyticsData, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            searchParams = filtersArguments.a;
        }
        if ((i & 2) != 0) {
            area = filtersArguments.b;
        }
        if ((i & 4) != 0) {
            str = filtersArguments.c;
        }
        if ((i & 8) != 0) {
            z = filtersArguments.d;
        }
        if ((i & 16) != 0) {
            filterAnalyticsData = filtersArguments.e;
        }
        if ((i & 32) != 0) {
            z2 = filtersArguments.f;
        }
        return filtersArguments.copy(searchParams, area, str, z, filterAnalyticsData, z2);
    }

    @NotNull
    public final SearchParams component1() {
        return this.a;
    }

    @Nullable
    public final Area component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final FilterAnalyticsData component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final FiltersArguments copy(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, boolean z, @NotNull FilterAnalyticsData filterAnalyticsData, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(filterAnalyticsData, "analyticsData");
        return new FiltersArguments(searchParams, area, str, z, filterAnalyticsData, z2);
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
        if (!(obj instanceof FiltersArguments)) {
            return false;
        }
        FiltersArguments filtersArguments = (FiltersArguments) obj;
        return Intrinsics.areEqual(this.a, filtersArguments.a) && Intrinsics.areEqual(this.b, filtersArguments.b) && Intrinsics.areEqual(this.c, filtersArguments.c) && this.d == filtersArguments.d && Intrinsics.areEqual(this.e, filtersArguments.e) && this.f == filtersArguments.f;
    }

    @NotNull
    public final FilterAnalyticsData getAnalyticsData() {
        return this.e;
    }

    @Nullable
    public final String getMapSerpState() {
        return this.c;
    }

    @Nullable
    public final Area getSearchArea() {
        return this.b;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.a;
    }

    public final boolean getShowSimpleMap() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        SearchParams searchParams = this.a;
        int i = 0;
        int hashCode = (searchParams != null ? searchParams.hashCode() : 0) * 31;
        Area area = this.b;
        int hashCode2 = (hashCode + (area != null ? area.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        FilterAnalyticsData filterAnalyticsData = this.e;
        if (filterAnalyticsData != null) {
            i = filterAnalyticsData.hashCode();
        }
        int i7 = (i6 + i) * 31;
        boolean z2 = this.f;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        return i7 + i2;
    }

    public final boolean isOnlySortShown() {
        return this.d;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("FiltersArguments(searchParams=");
        L.append(this.a);
        L.append(", searchArea=");
        L.append(this.b);
        L.append(", mapSerpState=");
        L.append(this.c);
        L.append(", isOnlySortShown=");
        L.append(this.d);
        L.append(", analyticsData=");
        L.append(this.e);
        L.append(", showSimpleMap=");
        return a.B(L, this.f, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(this.f ? 1 : 0);
    }
}
