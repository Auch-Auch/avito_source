package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAction;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAnalyticParams;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetSubmitParam;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010,\u001a\u00020\u0019\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0012\b\u00102\u001a\u0004\u0018\u00010-\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u001f\u0012\b\u00108\u001a\u0004\u0018\u000103¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00038\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010%\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u0019\u0010,\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001dR\u001b\u00102\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00108\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "()V", "viewType", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "getSpanCount$annotations", "spanCount", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/remote/model/search/Filter;", "e", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "filters", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", g.a, "getSubmitParams", "submitParams", "d", "getTitle", "title", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "f", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "getAction", "()Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "action", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "h", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "getAnalyticParams", "()Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "analyticParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItem implements ViewTypeSerpItem, Parcelable {
    public static final Parcelable.Creator<VerticalFilterItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final List<Filter> e;
    @Nullable
    public final SearchFormWidgetAction f;
    @NotNull
    public final List<SearchFormWidgetSubmitParam> g;
    @Nullable
    public final SearchFormWidgetAnalyticParams h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerticalFilterItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Filter) parcel.readParcelable(VerticalFilterItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            SearchFormWidgetAction searchFormWidgetAction = (SearchFormWidgetAction) parcel.readParcelable(VerticalFilterItem.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((SearchFormWidgetSubmitParam) parcel.readParcelable(VerticalFilterItem.class.getClassLoader()));
                readInt2--;
            }
            return new VerticalFilterItem(readString, readString2, arrayList, searchFormWidgetAction, arrayList2, (SearchFormWidgetAnalyticParams) parcel.readParcelable(VerticalFilterItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerticalFilterItem[] newArray(int i) {
            return new VerticalFilterItem[i];
        }
    }

    public VerticalFilterItem(@NotNull String str, @NotNull String str2, @Nullable List<Filter> list, @Nullable SearchFormWidgetAction searchFormWidgetAction, @NotNull List<SearchFormWidgetSubmitParam> list2, @Nullable SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams) {
        a.c1(str, "stringId", str2, "title", list2, "submitParams");
        this.c = str;
        this.d = str2;
        this.e = list;
        this.f = searchFormWidgetAction;
        this.g = list2;
        this.h = searchFormWidgetAnalyticParams;
        this.a = SerpViewType.SINGLE;
        this.b = 6;
    }

    public static /* synthetic */ void getSpanCount$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final SearchFormWidgetAction getAction() {
        return this.f;
    }

    @Nullable
    public final SearchFormWidgetAnalyticParams getAnalyticParams() {
        return this.h;
    }

    @Nullable
    public final List<Filter> getFilters() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ViewTypeSerpItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final List<SearchFormWidgetSubmitParam> getSubmitParams() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        List<Filter> list = this.e;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Filter) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f, i);
        Iterator n0 = a.n0(this.g, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((SearchFormWidgetSubmitParam) n0.next(), i);
        }
        parcel.writeParcelable(this.h, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalFilterItem(String str, String str2, List list, SearchFormWidgetAction searchFormWidgetAction, List list2, SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, searchFormWidgetAction, list2, searchFormWidgetAnalyticParams);
    }
}
