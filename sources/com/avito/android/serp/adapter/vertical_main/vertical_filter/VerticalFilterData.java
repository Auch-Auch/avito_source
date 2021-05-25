package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetSubmitParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001BS\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b;\u0010<J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\\\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010\u001eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b(\u0010)R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0005R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000bR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010\u0005R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\bR\u0019\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0010¨\u0006="}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", "component4", "", "component5", "()Z", "component6", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;", "filters", "buttonTitle", "buttonLink", "submitParams", "submitEnabled", "openedFilter", "copy", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;ZLcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFilters", "f", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;", "getOpenedFilter", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getButtonLink", "d", "getSubmitParams", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getButtonTitle", "e", "Z", "getSubmitEnabled", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;ZLcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterData implements Parcelable {
    public static final Parcelable.Creator<VerticalFilterData> CREATOR = new Creator();
    @NotNull
    public final List<FilterData> a;
    @Nullable
    public final String b;
    @NotNull
    public final DeepLink c;
    @NotNull
    public final List<SearchFormWidgetSubmitParam> d;
    public final boolean e;
    @Nullable
    public final FilterData f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerticalFilterData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(FilterData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            String readString = parcel.readString();
            DeepLink deepLink = (DeepLink) parcel.readParcelable(VerticalFilterData.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((SearchFormWidgetSubmitParam) parcel.readParcelable(VerticalFilterData.class.getClassLoader()));
                readInt2--;
            }
            return new VerticalFilterData(arrayList, readString, deepLink, arrayList2, parcel.readInt() != 0, parcel.readInt() != 0 ? FilterData.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterData[] newArray(int i) {
            return new VerticalFilterData[i];
        }
    }

    public VerticalFilterData() {
        this(null, null, null, null, false, null, 63, null);
    }

    public VerticalFilterData(@NotNull List<FilterData> list, @Nullable String str, @NotNull DeepLink deepLink, @NotNull List<SearchFormWidgetSubmitParam> list2, boolean z, @Nullable FilterData filterData) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(deepLink, "buttonLink");
        Intrinsics.checkNotNullParameter(list2, "submitParams");
        this.a = list;
        this.b = str;
        this.c = deepLink;
        this.d = list2;
        this.e = z;
        this.f = filterData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerticalFilterData copy$default(VerticalFilterData verticalFilterData, List list, String str, DeepLink deepLink, List list2, boolean z, FilterData filterData, int i, Object obj) {
        if ((i & 1) != 0) {
            list = verticalFilterData.a;
        }
        if ((i & 2) != 0) {
            str = verticalFilterData.b;
        }
        if ((i & 4) != 0) {
            deepLink = verticalFilterData.c;
        }
        if ((i & 8) != 0) {
            list2 = verticalFilterData.d;
        }
        if ((i & 16) != 0) {
            z = verticalFilterData.e;
        }
        if ((i & 32) != 0) {
            filterData = verticalFilterData.f;
        }
        return verticalFilterData.copy(list, str, deepLink, list2, z, filterData);
    }

    @NotNull
    public final List<FilterData> component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final DeepLink component3() {
        return this.c;
    }

    @NotNull
    public final List<SearchFormWidgetSubmitParam> component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final FilterData component6() {
        return this.f;
    }

    @NotNull
    public final VerticalFilterData copy(@NotNull List<FilterData> list, @Nullable String str, @NotNull DeepLink deepLink, @NotNull List<SearchFormWidgetSubmitParam> list2, boolean z, @Nullable FilterData filterData) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(deepLink, "buttonLink");
        Intrinsics.checkNotNullParameter(list2, "submitParams");
        return new VerticalFilterData(list, str, deepLink, list2, z, filterData);
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
        if (!(obj instanceof VerticalFilterData)) {
            return false;
        }
        VerticalFilterData verticalFilterData = (VerticalFilterData) obj;
        return Intrinsics.areEqual(this.a, verticalFilterData.a) && Intrinsics.areEqual(this.b, verticalFilterData.b) && Intrinsics.areEqual(this.c, verticalFilterData.c) && Intrinsics.areEqual(this.d, verticalFilterData.d) && this.e == verticalFilterData.e && Intrinsics.areEqual(this.f, verticalFilterData.f);
    }

    @NotNull
    public final DeepLink getButtonLink() {
        return this.c;
    }

    @Nullable
    public final String getButtonTitle() {
        return this.b;
    }

    @NotNull
    public final List<FilterData> getFilters() {
        return this.a;
    }

    @Nullable
    public final FilterData getOpenedFilter() {
        return this.f;
    }

    public final boolean getSubmitEnabled() {
        return this.e;
    }

    @NotNull
    public final List<SearchFormWidgetSubmitParam> getSubmitParams() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<FilterData> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        DeepLink deepLink = this.c;
        int hashCode3 = (hashCode2 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        List<SearchFormWidgetSubmitParam> list2 = this.d;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode4 + i2) * 31;
        FilterData filterData = this.f;
        if (filterData != null) {
            i = filterData.hashCode();
        }
        return i5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerticalFilterData(filters=");
        L.append(this.a);
        L.append(", buttonTitle=");
        L.append(this.b);
        L.append(", buttonLink=");
        L.append(this.c);
        L.append(", submitParams=");
        L.append(this.d);
        L.append(", submitEnabled=");
        L.append(this.e);
        L.append(", openedFilter=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.a, parcel);
        while (n0.hasNext()) {
            ((FilterData) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        Iterator n02 = a.n0(this.d, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((SearchFormWidgetSubmitParam) n02.next(), i);
        }
        parcel.writeInt(this.e ? 1 : 0);
        FilterData filterData = this.f;
        if (filterData != null) {
            parcel.writeInt(1);
            filterData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalFilterData(List list, String str, DeepLink deepLink, List list2, boolean z, FilterData filterData, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new NoMatchLink() : deepLink, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 16) != 0 ? true : z, (i & 32) == 0 ? filterData : null);
    }
}
