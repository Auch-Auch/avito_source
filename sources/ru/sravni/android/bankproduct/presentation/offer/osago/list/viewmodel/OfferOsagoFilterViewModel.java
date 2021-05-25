package ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.result.IResultAnalytic;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import t6.n.d;
import t6.n.e;
import t6.n.r;
import t6.n.s;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b.\u0010/J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0010\u001a\u00020\u00062\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0014R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0014R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/OfferOsagoFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/IOfferOsagoFilterViewModel;", "", "savedSearchID", AnalyticFieldsName.productName, "", "initFilterViewModel", "(Ljava/lang/String;Ljava/lang/String;)V", "", "barrelDayValue", "updatedField", "updateFilterBarrelDay", "(Ljava/util/Map;Ljava/lang/String;)V", "", "switcherValue", "updateFilterSwitcherList", "applyFilters", "()V", "c", "Ljava/lang/String;", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "j", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousInfo", "", g.a, "Ljava/util/Map;", "appliedFilterMaps", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "i", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "f", "filterMaps", "e", "lastUpdatedField", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "h", "Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "resultAnalytic", "d", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "getFilterToServer", "()Ljava/util/List;", "filterToServer", "<init>", "(Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoFilterViewModel extends ViewModel implements IOfferOsagoFilterViewModel {
    public String c = "";
    public String d;
    public String e;
    public final Map<String, List<String>> f = new LinkedHashMap();
    public final Map<String, List<String>> g = new LinkedHashMap();
    public final IResultAnalytic h;
    public final IProductNameDictionary i;
    public final IPreviousModuleInfo j;

    public OfferOsagoFilterViewModel(@NotNull IResultAnalytic iResultAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IPreviousModuleInfo iPreviousModuleInfo) {
        Intrinsics.checkParameterIsNotNull(iResultAnalytic, "resultAnalytic");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousInfo");
        this.h = iResultAnalytic;
        this.i = iProductNameDictionary;
        this.j = iPreviousModuleInfo;
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoFilterViewModel
    public void applyFilters() {
        this.g.putAll(this.f);
        String str = this.e;
        String str2 = BaseAnalyticKt.ANALYTIC_EMPTY_MODULE_ERROR;
        if (str == null) {
            str = str2;
        }
        IResultAnalytic iResultAnalytic = this.h;
        String str3 = this.c;
        String str4 = this.d;
        if (str4 != null) {
            str2 = str4;
        }
        iResultAnalytic.sendResultEditEvent(str3, str2, str, this.j.getPreviousModuleName());
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoFilterViewModel
    @NotNull
    public List<OfferFilterInfoDomain> getFilterToServer() {
        Map<String, List<String>> map = this.f;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList2.add(new OfferFilterInfoDomain(key, it.next()));
            }
            arrayList.add(arrayList2);
        }
        return e.flatten(arrayList);
    }

    @Override // ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoFilterViewModel
    public void initFilterViewModel(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "";
        }
        this.c = str;
        this.d = str2;
        this.f.clear();
        this.f.putAll(this.g);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayUpdate
    public void updateFilterBarrelDay(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(map, "barrelDayValue");
        Intrinsics.checkParameterIsNotNull(str, "updatedField");
        this.e = str;
        Map<String, List<String>> map2 = this.f;
        List<Pair> list = s.toList(map);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (Pair pair : list) {
            arrayList.add(TuplesKt.to(pair.getFirst(), d.listOf(pair.getSecond())));
        }
        map2.putAll(r.toMap(arrayList));
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListUpdate
    public void updateFilterSwitcherList(@NotNull Map<String, ? extends List<String>> map, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(map, "switcherValue");
        Intrinsics.checkParameterIsNotNull(str, "updatedField");
        this.e = str;
        this.f.putAll(map);
    }
}
