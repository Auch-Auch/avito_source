package com.avito.android.remote.model.vertical_main;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.search.Filter;
import com.google.gson.annotations.SerializedName;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010$\u001a\u00020#8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b$\u0010%\u0012\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/vertical_main/SearchFormWidget;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "action", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "getAction", "()Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", "submitParams", "Ljava/util/List;", "getSubmitParams", "()Ljava/util/List;", "Lcom/avito/android/remote/model/search/Filter;", "filters", "getFilters", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "analyticParams", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "getAnalyticParams", "()Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchFormWidget implements SerpElement {
    public static final Parcelable.Creator<SearchFormWidget> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final SearchFormWidgetAction action;
    @SerializedName("analyticParams")
    @Nullable
    private final SearchFormWidgetAnalyticParams analyticParams;
    @SerializedName("filters")
    @NotNull
    private final List<Filter> filters;
    @SerializedName("submitParams")
    @NotNull
    private final List<SearchFormWidgetSubmitParam> submitParams;
    @SerializedName("title")
    @NotNull
    private final String title;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SearchFormWidget> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchFormWidget createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Filter.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            SearchFormWidgetAction createFromParcel = parcel.readInt() != 0 ? SearchFormWidgetAction.CREATOR.createFromParcel(parcel) : null;
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(SearchFormWidgetSubmitParam.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new SearchFormWidget(readString, arrayList, createFromParcel, arrayList2, parcel.readInt() != 0 ? SearchFormWidgetAnalyticParams.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchFormWidget[] newArray(int i) {
            return new SearchFormWidget[i];
        }
    }

    public SearchFormWidget(@NotNull String str, @NotNull List<Filter> list, @Nullable SearchFormWidgetAction searchFormWidgetAction, @NotNull List<SearchFormWidgetSubmitParam> list2, @Nullable SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(list2, "submitParams");
        this.title = str;
        this.filters = list;
        this.action = searchFormWidgetAction;
        this.submitParams = list2;
        this.analyticParams = searchFormWidgetAnalyticParams;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final SearchFormWidgetAction getAction() {
        return this.action;
    }

    @Nullable
    public final SearchFormWidgetAnalyticParams getAnalyticParams() {
        return this.analyticParams;
    }

    @NotNull
    public final List<Filter> getFilters() {
        return this.filters;
    }

    @NotNull
    public final List<SearchFormWidgetSubmitParam> getSubmitParams() {
        return this.submitParams;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.filters, parcel);
        while (n0.hasNext()) {
            ((Filter) n0.next()).writeToParcel(parcel, 0);
        }
        SearchFormWidgetAction searchFormWidgetAction = this.action;
        if (searchFormWidgetAction != null) {
            parcel.writeInt(1);
            searchFormWidgetAction.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n02 = a.n0(this.submitParams, parcel);
        while (n02.hasNext()) {
            ((SearchFormWidgetSubmitParam) n02.next()).writeToParcel(parcel, 0);
        }
        SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams = this.analyticParams;
        if (searchFormWidgetAnalyticParams != null) {
            parcel.writeInt(1);
            searchFormWidgetAnalyticParams.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchFormWidget(String str, List list, SearchFormWidgetAction searchFormWidgetAction, List list2, SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams, int i, j jVar) {
        this(str, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, searchFormWidgetAction, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, searchFormWidgetAnalyticParams);
    }
}
