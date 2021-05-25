package com.avito.android.search.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.Sublocation;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import com.avito.android.remote.model.category_parameters.DirectionParameter;
import com.avito.android.remote.model.category_parameters.DistrictParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ParametersTreeIterator;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.ParcelsKt;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u0001CB/\u0012\u0006\u00104\u001a\u00020\u0001\u0012\u0006\u0010=\u001a\u00020;\u0012\u0016\b\u0002\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000208\u0018\u00010\u001b¢\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020\t¢\u0006\u0004\b?\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001f\u001a\u00020\u001e2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$H\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u001eH\u0001¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J?\u00100\u001a\u00020/\"\b\b\u0000\u0010\u0016*\u00020,*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0-2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002¢\u0006\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00028\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b5\u0010\u0004R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000208078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010<¨\u0006D"}, d2 = {"Lcom/avito/android/search/filter/ReplaceLocationParametersTree;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "", "describeContents", "()I", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "iterator", "()Ljava/util/Iterator;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "id", "findParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "T", "Ljava/lang/Class;", "type", "getFirstParameterOfType", "(Ljava/lang/Class;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "pretendResult", "", "applyPretendResult", "(Ljava/util/Map;)Z", "Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "findAdditionalParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AdditionalCategoryParameter;", "", "getParametersExceptOwnedBySlots", "()Ljava/util/List;", "isEmpty", "()Z", "parameter", AuthSource.SEND_ABUSE, "(ILcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/remote/model/Sublocation;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "sublocations", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;", "c", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;ILjava/util/List;)Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "tree", "getCount", "count", "", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Ljava/util/Map;", "replacements", "Lcom/avito/android/search/filter/LocationInfo;", "Lcom/avito/android/search/filter/LocationInfo;", "locationInfo", ResidentialComplexModuleKt.VALUES, "<init>", "(Lcom/avito/android/search/filter/ParametersTreeWithAdditional;Lcom/avito/android/search/filter/LocationInfo;Ljava/util/Map;)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ReplaceLocationParametersTree implements ParametersTreeWithAdditional {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final Map<Integer, CategoryParameter> a;
    public final ParametersTreeWithAdditional b;
    public final LocationInfo c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/filter/ReplaceLocationParametersTree$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/search/filter/ReplaceLocationParametersTree;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/search/filter/ReplaceLocationParametersTree;", "", "size", "", "newArray", "(I)[Lcom/avito/android/search/filter/ReplaceLocationParametersTree;", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<ReplaceLocationParametersTree> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReplaceLocationParametersTree createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ReplaceLocationParametersTree(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReplaceLocationParametersTree[] newArray(int i) {
            return new ReplaceLocationParametersTree[i];
        }
    }

    public ReplaceLocationParametersTree(@NotNull ParametersTreeWithAdditional parametersTreeWithAdditional, @NotNull LocationInfo locationInfo, @Nullable Map<Integer, ? extends CategoryParameter> map) {
        Map<Integer, CategoryParameter> linkedHashMap;
        Intrinsics.checkNotNullParameter(parametersTreeWithAdditional, "tree");
        Intrinsics.checkNotNullParameter(locationInfo, "locationInfo");
        this.b = parametersTreeWithAdditional;
        this.c = locationInfo;
        this.a = (map == null || (linkedHashMap = r.toMutableMap(map)) == null) ? new LinkedHashMap<>() : linkedHashMap;
    }

    public final ParameterSlot a(int i, ParameterSlot parameterSlot) {
        CategoryParameter categoryParameter = this.a.get(Integer.valueOf(i));
        if (categoryParameter != null) {
            if (!Intrinsics.areEqual(categoryParameter.getId(), parameterSlot.getId())) {
                this.a.remove(Integer.valueOf(i));
                categoryParameter = null;
            }
            if (categoryParameter != null) {
                return categoryParameter;
            }
        }
        if (parameterSlot instanceof MetroParameter) {
            ((MetroParameter) parameterSlot).setValues(this.c.getMetro());
            return parameterSlot;
        } else if (parameterSlot instanceof DistrictParameter) {
            return c((EditableParameter) parameterSlot, i, this.c.getDistricts());
        } else {
            if (parameterSlot instanceof DirectionParameter) {
                return c((EditableParameter) parameterSlot, i, this.c.getDirections());
            }
            if (!(parameterSlot instanceof LocationParameter)) {
                return parameterSlot;
            }
            LocationParameter locationParameter = (LocationParameter) parameterSlot;
            LocationParameter locationParameter2 = new LocationParameter(locationParameter.getId(), locationParameter.getTitle(), locationParameter.getMotivation(), locationParameter.getUpdatesForm(), Intrinsics.areEqual((Location) locationParameter.getValue(), this.c.getTopLocation()) && !this.c.getRenamed(), (Location) locationParameter.getValue());
            this.a.put(Integer.valueOf(i), locationParameter2);
            return locationParameter2;
        }
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    public boolean applyPretendResult(@Nullable Map<String, ? extends PretendErrorValue> map) {
        return this.b.applyPretendResult(map);
    }

    public final <T extends Sublocation> MultiselectParameter c(EditableParameter<List<T>> editableParameter, int i, List<? extends T> list) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String str = (String) t.getId();
            String name = t.getName();
            if (name == null) {
                name = "";
            }
            arrayList2.add(new MultiselectParameter.Value(str, name, null));
        }
        List<T> value = editableParameter.getValue();
        if (value != null) {
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(value, 10));
            for (T t2 : value) {
                arrayList3.add((String) t2.getId());
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        MultiselectParameter multiselectParameter = new MultiselectParameter(editableParameter.getId(), editableParameter.getTitle(), editableParameter.getRequired(), editableParameter.getImmutable(), editableParameter.getMotivation(), editableParameter.getUpdatesForm(), arrayList, null, arrayList2, null, null, null, null, null, 15872, null);
        this.a.put(Integer.valueOf(i), multiselectParameter);
        return multiselectParameter;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.search.filter.AdditionalParameterProvider
    @Nullable
    public AdditionalCategoryParameter findAdditionalParameter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.b.findAdditionalParameter(str);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public ParameterSlot findParameter(@NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = this.a.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getId(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2;
        }
        ParameterSlot findParameter = this.b.findParameter(str);
        if (findParameter != null) {
            return a(CollectionsKt___CollectionsKt.indexOf(this.b, findParameter), findParameter);
        }
        return null;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.b.getCount();
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @Nullable
    public <T extends ParameterSlot> T getFirstParameterOfType(@NotNull Class<T> cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "type");
        Iterator it = iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (cls.isInstance((ParameterSlot) obj)) {
                break;
            }
        }
        return (T) ((ParameterSlot) obj);
    }

    @Override // com.avito.android.remote.model.category_parameters.ParametersTree
    @NotNull
    public List<ParameterSlot> getParametersExceptOwnedBySlots() {
        return this.b.getParametersExceptOwnedBySlots();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<ParameterSlot> iterator() {
        return new ParametersTreeIterator(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        ParcelsKt.writeValueMap(parcel, this.a);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public ParameterSlot getItem(int i) {
        return a(i, (ParameterSlot) this.b.getItem(i));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReplaceLocationParametersTree(ParametersTreeWithAdditional parametersTreeWithAdditional, LocationInfo locationInfo, Map map, int i, j jVar) {
        this(parametersTreeWithAdditional, locationInfo, (i & 4) != 0 ? null : map);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReplaceLocationParametersTree(@org.jetbrains.annotations.NotNull android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Class<com.avito.android.search.filter.ParametersTreeWithAdditional> r0 = com.avito.android.search.filter.ParametersTreeWithAdditional.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r5.readParcelable(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.avito.android.search.filter.ParametersTreeWithAdditional r0 = (com.avito.android.search.filter.ParametersTreeWithAdditional) r0
            java.lang.Class<com.avito.android.search.filter.LocationInfo> r1 = com.avito.android.search.filter.LocationInfo.class
            android.os.Parcelable r1 = a2.b.a.a.a.z1(r1, r5)
            com.avito.android.search.filter.LocationInfo r1 = (com.avito.android.search.filter.LocationInfo) r1
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            java.lang.Class<com.avito.android.remote.model.category_parameters.base.CategoryParameter> r3 = com.avito.android.remote.model.category_parameters.base.CategoryParameter.class
            java.util.Map r5 = com.avito.android.util.ParcelUtils.createValueMap(r5, r2, r3)
            if (r5 == 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            java.util.Map r5 = t6.n.r.emptyMap()
        L_0x002b:
            r4.<init>(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.ReplaceLocationParametersTree.<init>(android.os.Parcel):void");
    }
}
