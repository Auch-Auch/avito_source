package com.avito.android.search.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B%\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150 \u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010 ¢\u0006\u0004\b2\u00103J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ&\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0018*\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000fH\u0001¢\u0006\u0004\b#\u0010$J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%H\u0003¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u0014\u001a\u00020\fH\u0001¢\u0006\u0004\b)\u0010*R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\u0013R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010,¨\u00065"}, d2 = {"Lcom/avito/android/search/filter/ParametersTreeWithAdditionalImpl;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/search/filter/AdditionalParameterProvider;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "pretendResult", "", "applyPretendResult", "(Ljava/util/Map;)Z", "describeContents", "()I", "id", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "findParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "T", "Ljava/lang/Class;", "type", "getFirstParameterOfType", "(Ljava/lang/Class;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "getParametersExceptOwnedBySlots", "()Ljava/util/List;", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "findAdditionalParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "additionalParameters", "getCount", "count", AuthSource.SEND_ABUSE, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersTreeWithAdditionalImpl implements ParametersTreeWithAdditional, ParametersTree, AdditionalParameterProvider {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ParametersTreeWithAdditionalImpl> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final List<ParameterSlot> a;
    public final List<AdditionalCategoryParameter> b;
    public final /* synthetic */ SimpleParametersTree c;
    public final /* synthetic */ SimpleAdditionalParameterProvider d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/search/filter/ParametersTreeWithAdditionalImpl$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditionalImpl;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ParametersTreeWithAdditionalImpl> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ParametersTreeWithAdditionalImpl invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, ParameterSlot.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            List createParcelableList2 = ParcelsKt.createParcelableList(parcel2, AdditionalCategoryParameter.class);
            if (createParcelableList2 == null) {
                createParcelableList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            return new ParametersTreeWithAdditionalImpl(createParcelableList, createParcelableList2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter> */
    /* JADX WARN: Multi-variable type inference failed */
    public ParametersTreeWithAdditionalImpl(@NotNull List<? extends ParameterSlot> list, @Nullable List<? extends AdditionalCategoryParameter> list2) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.c = new SimpleParametersTree(list, null, 2, null);
        this.d = new SimpleAdditionalParameterProvider(list2 != 0 ? list2 : CollectionsKt__CollectionsKt.emptyList());
        this.a = list;
        this.b = list2;
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    public boolean applyPretendResult(@Nullable Map<String, ? extends PretendErrorValue> map) {
        return this.c.applyPretendResult(map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.c.describeContents();
    }

    @Override // com.avito.android.search.filter.AdditionalParameterProvider
    @Nullable
    public AdditionalCategoryParameter findAdditionalParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.d.findAdditionalParameter(str);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public ParameterSlot findParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.c.findParameter(str);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.c.getCount();
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public <T extends ParameterSlot> T getFirstParameterOfType(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) this.c.getFirstParameterOfType(cls);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public ParameterSlot getItem(int i) {
        return this.c.getItem(i);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @NotNull
    public List<ParameterSlot> getParametersExceptOwnedBySlots() {
        return this.c.getParametersExceptOwnedBySlots();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<ParameterSlot> iterator() {
        return this.c.iterator();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            ParcelsKt.writeOptimizedParcelableList(parcel, this.a, i);
        }
        if (parcel != null) {
            ParcelsKt.writeOptimizedParcelableList(parcel, this.b, i);
        }
    }
}
