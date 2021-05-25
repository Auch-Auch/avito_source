package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b \u0010\u000e¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/SearchParameters;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "component2", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "additionalParameters", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/model/SearchParameters;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getParameters", "getAdditionalParameters", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "search_release"}, k = 1, mv = {1, 4, 2})
public final class SearchParameters implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SearchParameters> CREATOR = Parcels.creator(SearchParameters$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("additionalParams")
    @Nullable
    private final List<AdditionalCategoryParameter> additionalParameters;
    @SerializedName("params")
    @NotNull
    private final List<ParameterSlot> parameters;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchParameters$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchParameters;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchParameters(@NotNull List<? extends ParameterSlot> list, @Nullable List<? extends AdditionalCategoryParameter> list2) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.parameters = list;
        this.additionalParameters = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.SearchParameters */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchParameters copy$default(SearchParameters searchParameters, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchParameters.parameters;
        }
        if ((i & 2) != 0) {
            list2 = searchParameters.additionalParameters;
        }
        return searchParameters.copy(list, list2);
    }

    @NotNull
    public final List<ParameterSlot> component1() {
        return this.parameters;
    }

    @Nullable
    public final List<AdditionalCategoryParameter> component2() {
        return this.additionalParameters;
    }

    @NotNull
    public final SearchParameters copy(@NotNull List<? extends ParameterSlot> list, @Nullable List<? extends AdditionalCategoryParameter> list2) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return new SearchParameters(list, list2);
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
        if (!(obj instanceof SearchParameters)) {
            return false;
        }
        SearchParameters searchParameters = (SearchParameters) obj;
        return Intrinsics.areEqual(this.parameters, searchParameters.parameters) && Intrinsics.areEqual(this.additionalParameters, searchParameters.additionalParameters);
    }

    @Nullable
    public final List<AdditionalCategoryParameter> getAdditionalParameters() {
        return this.additionalParameters;
    }

    @NotNull
    public final List<ParameterSlot> getParameters() {
        return this.parameters;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<ParameterSlot> list = this.parameters;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<AdditionalCategoryParameter> list2 = this.additionalParameters;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchParameters(parameters=");
        L.append(this.parameters);
        L.append(", additionalParameters=");
        return a.w(L, this.additionalParameters, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList(parcel, this.parameters, i);
        List<AdditionalCategoryParameter> list = this.additionalParameters;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ParcelsKt.writeOptimizedParcelableList(parcel, list, i);
    }
}
