package com.avito.android.remote.model.vertical_main;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/vertical_main/Form;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/search/Filter;", "filters", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "action", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "getAction", "()Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", "submitParams", "getSubmitParams", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Form implements Parcelable {
    public static final Parcelable.Creator<Form> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final SearchFormWidgetAction action;
    @SerializedName("filters")
    @NotNull
    private final List<Filter> filters;
    @SerializedName("submitParams")
    @NotNull
    private final List<SearchFormWidgetSubmitParam> submitParams;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Form> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Form createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Filter.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            SearchFormWidgetAction createFromParcel = SearchFormWidgetAction.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(SearchFormWidgetSubmitParam.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new Form(arrayList, createFromParcel, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Form[] newArray(int i) {
            return new Form[i];
        }
    }

    public Form(@NotNull List<Filter> list, @NotNull SearchFormWidgetAction searchFormWidgetAction, @NotNull List<SearchFormWidgetSubmitParam> list2) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(searchFormWidgetAction, "action");
        Intrinsics.checkNotNullParameter(list2, "submitParams");
        this.filters = list;
        this.action = searchFormWidgetAction;
        this.submitParams = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final SearchFormWidgetAction getAction() {
        return this.action;
    }

    @NotNull
    public final List<Filter> getFilters() {
        return this.filters;
    }

    @NotNull
    public final List<SearchFormWidgetSubmitParam> getSubmitParams() {
        return this.submitParams;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.filters, parcel);
        while (n0.hasNext()) {
            ((Filter) n0.next()).writeToParcel(parcel, 0);
        }
        this.action.writeToParcel(parcel, 0);
        Iterator n02 = a.n0(this.submitParams, parcel);
        while (n02.hasNext()) {
            ((SearchFormWidgetSubmitParam) n02.next()).writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Form(List list, SearchFormWidgetAction searchFormWidgetAction, List list2, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, searchFormWidgetAction, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
