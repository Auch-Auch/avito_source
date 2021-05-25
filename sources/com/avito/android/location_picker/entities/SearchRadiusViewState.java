package com.avito.android.location_picker.entities;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b,\b\b\u0018\u0000 b2\u00020\u0001:\u0001bB\u0001\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u0017\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0017\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u00101\u001a\u00020\u0012\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b_\u0010`B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b_\u0010aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\u0010\u0010\u001e\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0010\u0010\u001f\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b#\u0010\u0014J\u0012\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u000b2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00172\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020\u00122\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b5\u0010\rJ\u0010\u00106\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b6\u0010\nJ\u001a\u00109\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:R\u0019\u0010&\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\rR\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u0011R\u0019\u0010-\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0014R\u0019\u0010(\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010B\u001a\u0004\bE\u0010\u0014R\u0019\u0010)\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010B\u001a\u0004\bG\u0010\u0014R\u0019\u0010.\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010B\u001a\u0004\bI\u0010\u0014R\u0019\u0010*\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010\rR\u001b\u00100\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\"R\u0019\u0010+\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u0019R\u0019\u00101\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010B\u001a\u0004\bS\u0010\u0014R\u0019\u0010V\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010B\u001a\u0004\bU\u0010\u0014R\u001b\u00102\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010%R\u001b\u0010,\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010\u001cR\u0019\u0010/\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010P\u001a\u0004\b^\u0010\u0019¨\u0006c"}, d2 = {"Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/SearchRadius;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "", "component6", "()J", "Lcom/avito/android/avito_map/AvitoMapBounds;", "component7", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "component8", "component9", "component10", "Lcom/avito/android/remote/model/SearchParams;", "component11", "()Lcom/avito/android/remote/model/SearchParams;", "component12", "component13", "()Lcom/avito/android/remote/model/SearchRadius;", "radiusId", "radiusList", "shouldLoadRadiusList", "radiusSelected", "initialRadiusId", "distanceInMeters", "mapBounds", "radiusIsVisible", "loadFailed", "advertsCount", "searchParams", "shouldInvalidateAdvertsCount", "initialRadius", "copy", "(Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;JLcom/avito/android/avito_map/AvitoMapBounds;ZZJLcom/avito/android/remote/model/SearchParams;ZLcom/avito/android/remote/model/SearchRadius;)Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getRadiusId", "c", "Ljava/util/List;", "getRadiusList", "i", "Z", "getRadiusIsVisible", "d", "getShouldLoadRadiusList", "e", "getRadiusSelected", "j", "getLoadFailed", "f", "getInitialRadiusId", "l", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", g.a, "J", "getDistanceInMeters", AuthSource.OPEN_CHANNEL_LIST, "getShouldInvalidateAdvertsCount", AuthSource.SEND_ABUSE, "getNeedToShowWidget", "needToShowWidget", "n", "Lcom/avito/android/remote/model/SearchRadius;", "getInitialRadius", "h", "Lcom/avito/android/avito_map/AvitoMapBounds;", "getMapBounds", "k", "getAdvertsCount", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;JLcom/avito/android/avito_map/AvitoMapBounds;ZZJLcom/avito/android/remote/model/SearchParams;ZLcom/avito/android/remote/model/SearchRadius;)V", "(Landroid/os/Parcel;)V", "Companion", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SearchRadiusViewState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SearchRadiusViewState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean a;
    @NotNull
    public final String b;
    @NotNull
    public final List<SearchRadius> c;
    public final boolean d;
    public final boolean e;
    @NotNull
    public final String f;
    public final long g;
    @Nullable
    public final AvitoMapBounds h;
    public final boolean i;
    public final boolean j;
    public final long k;
    @Nullable
    public final SearchParams l;
    public final boolean m;
    @Nullable
    public final SearchRadius n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/location_picker/entities/SearchRadiusViewState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/location_picker/entities/SearchRadiusViewState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SearchRadiusViewState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SearchRadiusViewState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new SearchRadiusViewState(parcel2);
        }
    }

    public SearchRadiusViewState() {
        this(null, null, false, false, null, 0, null, false, false, 0, null, false, null, 8191, null);
    }

    public SearchRadiusViewState(@NotNull String str, @NotNull List<SearchRadius> list, boolean z, boolean z2, @NotNull String str2, long j2, @Nullable AvitoMapBounds avitoMapBounds, boolean z3, boolean z4, long j3, @Nullable SearchParams searchParams, boolean z5, @Nullable SearchRadius searchRadius) {
        a2.b.a.a.a.d1(str, "radiusId", list, "radiusList", str2, "initialRadiusId");
        this.b = str;
        this.c = list;
        this.d = z;
        this.e = z2;
        this.f = str2;
        this.g = j2;
        this.h = avitoMapBounds;
        this.i = z3;
        this.j = z4;
        this.k = j3;
        this.l = searchParams;
        this.m = z5;
        this.n = searchRadius;
        boolean z7 = true;
        if (!z && !(!list.isEmpty())) {
            z7 = false;
        }
        this.a = z7;
    }

    public static /* synthetic */ SearchRadiusViewState copy$default(SearchRadiusViewState searchRadiusViewState, String str, List list, boolean z, boolean z2, String str2, long j2, AvitoMapBounds avitoMapBounds, boolean z3, boolean z4, long j3, SearchParams searchParams, boolean z5, SearchRadius searchRadius, int i2, Object obj) {
        return searchRadiusViewState.copy((i2 & 1) != 0 ? searchRadiusViewState.b : str, (i2 & 2) != 0 ? searchRadiusViewState.c : list, (i2 & 4) != 0 ? searchRadiusViewState.d : z, (i2 & 8) != 0 ? searchRadiusViewState.e : z2, (i2 & 16) != 0 ? searchRadiusViewState.f : str2, (i2 & 32) != 0 ? searchRadiusViewState.g : j2, (i2 & 64) != 0 ? searchRadiusViewState.h : avitoMapBounds, (i2 & 128) != 0 ? searchRadiusViewState.i : z3, (i2 & 256) != 0 ? searchRadiusViewState.j : z4, (i2 & 512) != 0 ? searchRadiusViewState.k : j3, (i2 & 1024) != 0 ? searchRadiusViewState.l : searchParams, (i2 & 2048) != 0 ? searchRadiusViewState.m : z5, (i2 & 4096) != 0 ? searchRadiusViewState.n : searchRadius);
    }

    @NotNull
    public final String component1() {
        return this.b;
    }

    public final long component10() {
        return this.k;
    }

    @Nullable
    public final SearchParams component11() {
        return this.l;
    }

    public final boolean component12() {
        return this.m;
    }

    @Nullable
    public final SearchRadius component13() {
        return this.n;
    }

    @NotNull
    public final List<SearchRadius> component2() {
        return this.c;
    }

    public final boolean component3() {
        return this.d;
    }

    public final boolean component4() {
        return this.e;
    }

    @NotNull
    public final String component5() {
        return this.f;
    }

    public final long component6() {
        return this.g;
    }

    @Nullable
    public final AvitoMapBounds component7() {
        return this.h;
    }

    public final boolean component8() {
        return this.i;
    }

    public final boolean component9() {
        return this.j;
    }

    @NotNull
    public final SearchRadiusViewState copy(@NotNull String str, @NotNull List<SearchRadius> list, boolean z, boolean z2, @NotNull String str2, long j2, @Nullable AvitoMapBounds avitoMapBounds, boolean z3, boolean z4, long j3, @Nullable SearchParams searchParams, boolean z5, @Nullable SearchRadius searchRadius) {
        Intrinsics.checkNotNullParameter(str, "radiusId");
        Intrinsics.checkNotNullParameter(list, "radiusList");
        Intrinsics.checkNotNullParameter(str2, "initialRadiusId");
        return new SearchRadiusViewState(str, list, z, z2, str2, j2, avitoMapBounds, z3, z4, j3, searchParams, z5, searchRadius);
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
        if (!(obj instanceof SearchRadiusViewState)) {
            return false;
        }
        SearchRadiusViewState searchRadiusViewState = (SearchRadiusViewState) obj;
        return Intrinsics.areEqual(this.b, searchRadiusViewState.b) && Intrinsics.areEqual(this.c, searchRadiusViewState.c) && this.d == searchRadiusViewState.d && this.e == searchRadiusViewState.e && Intrinsics.areEqual(this.f, searchRadiusViewState.f) && this.g == searchRadiusViewState.g && Intrinsics.areEqual(this.h, searchRadiusViewState.h) && this.i == searchRadiusViewState.i && this.j == searchRadiusViewState.j && this.k == searchRadiusViewState.k && Intrinsics.areEqual(this.l, searchRadiusViewState.l) && this.m == searchRadiusViewState.m && Intrinsics.areEqual(this.n, searchRadiusViewState.n);
    }

    public final long getAdvertsCount() {
        return this.k;
    }

    public final long getDistanceInMeters() {
        return this.g;
    }

    @Nullable
    public final SearchRadius getInitialRadius() {
        return this.n;
    }

    @NotNull
    public final String getInitialRadiusId() {
        return this.f;
    }

    public final boolean getLoadFailed() {
        return this.j;
    }

    @Nullable
    public final AvitoMapBounds getMapBounds() {
        return this.h;
    }

    public final boolean getNeedToShowWidget() {
        return this.a;
    }

    @NotNull
    public final String getRadiusId() {
        return this.b;
    }

    public final boolean getRadiusIsVisible() {
        return this.i;
    }

    @NotNull
    public final List<SearchRadius> getRadiusList() {
        return this.c;
    }

    public final boolean getRadiusSelected() {
        return this.e;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.l;
    }

    public final boolean getShouldInvalidateAdvertsCount() {
        return this.m;
    }

    public final boolean getShouldLoadRadiusList() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<SearchRadius> list = this.c;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode2 + i4) * 31;
        boolean z2 = this.e;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        String str2 = this.f;
        int hashCode3 = (((i11 + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.g)) * 31;
        AvitoMapBounds avitoMapBounds = this.h;
        int hashCode4 = (hashCode3 + (avitoMapBounds != null ? avitoMapBounds.hashCode() : 0)) * 31;
        boolean z3 = this.i;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (hashCode4 + i12) * 31;
        boolean z4 = this.j;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int a3 = (((i15 + i16) * 31) + c.a(this.k)) * 31;
        SearchParams searchParams = this.l;
        int hashCode5 = (a3 + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        boolean z5 = this.m;
        if (!z5) {
            i3 = z5 ? 1 : 0;
        }
        int i19 = (hashCode5 + i3) * 31;
        SearchRadius searchRadius = this.n;
        if (searchRadius != null) {
            i2 = searchRadius.hashCode();
        }
        return i19 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SearchRadiusViewState(radiusId=");
        L.append(this.b);
        L.append(", radiusList=");
        L.append(this.c);
        L.append(", shouldLoadRadiusList=");
        L.append(this.d);
        L.append(", radiusSelected=");
        L.append(this.e);
        L.append(", initialRadiusId=");
        L.append(this.f);
        L.append(", distanceInMeters=");
        L.append(this.g);
        L.append(", mapBounds=");
        L.append(this.h);
        L.append(", radiusIsVisible=");
        L.append(this.i);
        L.append(", loadFailed=");
        L.append(this.j);
        L.append(", advertsCount=");
        L.append(this.k);
        L.append(", searchParams=");
        L.append(this.l);
        L.append(", shouldInvalidateAdvertsCount=");
        L.append(this.m);
        L.append(", initialRadius=");
        L.append(this.n);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
        ParcelsKt.writeBool(parcel, this.d);
        ParcelsKt.writeBool(parcel, this.e);
        parcel.writeString(this.f);
        parcel.writeLong(this.g);
        ParcelsKt.writeNullableValue(parcel, this.h);
        ParcelsKt.writeBool(parcel, this.i);
        ParcelsKt.writeBool(parcel, this.j);
        parcel.writeLong(this.k);
        ParcelsKt.writeNullableValue(parcel, this.l);
        ParcelsKt.writeBool(parcel, this.m);
        ParcelsKt.writeNullableValue(parcel, this.n);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SearchRadiusViewState(java.lang.String r17, java.util.List r18, boolean r19, boolean r20, java.lang.String r21, long r22, com.avito.android.avito_map.AvitoMapBounds r24, boolean r25, boolean r26, long r27, com.avito.android.remote.model.SearchParams r29, boolean r30, com.avito.android.remote.model.SearchRadius r31, int r32, t6.r.a.j r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r17
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0017
        L_0x0015:
            r3 = r18
        L_0x0017:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001e
            r4 = 0
            goto L_0x0020
        L_0x001e:
            r4 = r19
        L_0x0020:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0026
            r6 = 0
            goto L_0x0028
        L_0x0026:
            r6 = r20
        L_0x0028:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r2 = r21
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0036
            r7 = 0
            goto L_0x0038
        L_0x0036:
            r7 = r22
        L_0x0038:
            r9 = r0 & 64
            r10 = 0
            if (r9 == 0) goto L_0x003f
            r9 = r10
            goto L_0x0041
        L_0x003f:
            r9 = r24
        L_0x0041:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0047
            r11 = 0
            goto L_0x0049
        L_0x0047:
            r11 = r25
        L_0x0049:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r5 = r26
        L_0x0050:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0057
            r12 = -1
            goto L_0x0059
        L_0x0057:
            r12 = r27
        L_0x0059:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005f
            r14 = r10
            goto L_0x0061
        L_0x005f:
            r14 = r29
        L_0x0061:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 1
            goto L_0x0069
        L_0x0067:
            r15 = r30
        L_0x0069:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r10 = r31
        L_0x0070:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r6
            r22 = r2
            r23 = r7
            r25 = r9
            r26 = r11
            r27 = r5
            r28 = r12
            r30 = r14
            r31 = r15
            r32 = r10
            r17.<init>(r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_picker.entities.SearchRadiusViewState.<init>(java.lang.String, java.util.List, boolean, boolean, java.lang.String, long, com.avito.android.avito_map.AvitoMapBounds, boolean, boolean, long, com.avito.android.remote.model.SearchParams, boolean, com.avito.android.remote.model.SearchRadius, int, t6.r.a.j):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchRadiusViewState(@org.jetbrains.annotations.NotNull android.os.Parcel r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r3 = r19.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.os.Parcelable$Creator<com.avito.android.remote.model.SearchRadius> r2 = com.avito.android.remote.model.SearchRadius.CREATOR
            java.util.ArrayList r2 = r0.createTypedArrayList(r2)
            if (r2 == 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0020:
            r4 = r2
            boolean r5 = com.avito.android.util.ParcelsKt.readBool(r19)
            boolean r6 = com.avito.android.util.ParcelsKt.readBool(r19)
            java.lang.String r7 = a2.b.a.a.a.u2(r0, r1)
            long r8 = r19.readLong()
            java.lang.Class<com.avito.android.avito_map.AvitoMapBounds> r1 = com.avito.android.avito_map.AvitoMapBounds.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r2 = r1 instanceof com.avito.android.avito_map.AvitoMapBounds
            if (r2 != 0) goto L_0x0040
            r1 = 0
        L_0x0040:
            r10 = r1
            com.avito.android.avito_map.AvitoMapBounds r10 = (com.avito.android.avito_map.AvitoMapBounds) r10
            boolean r11 = com.avito.android.util.ParcelsKt.readBool(r19)
            boolean r12 = com.avito.android.util.ParcelsKt.readBool(r19)
            long r13 = r19.readLong()
            java.lang.Class<com.avito.android.remote.model.SearchParams> r1 = com.avito.android.remote.model.SearchParams.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r0.readParcelable(r1)
            r15 = r1
            com.avito.android.remote.model.SearchParams r15 = (com.avito.android.remote.model.SearchParams) r15
            boolean r16 = com.avito.android.util.ParcelsKt.readBool(r19)
            java.lang.Class<com.avito.android.remote.model.SearchRadius> r1 = com.avito.android.remote.model.SearchRadius.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r0 = r0.readParcelable(r1)
            r17 = r0
            com.avito.android.remote.model.SearchRadius r17 = (com.avito.android.remote.model.SearchRadius) r17
            r2 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.location_picker.entities.SearchRadiusViewState.<init>(android.os.Parcel):void");
    }
}
