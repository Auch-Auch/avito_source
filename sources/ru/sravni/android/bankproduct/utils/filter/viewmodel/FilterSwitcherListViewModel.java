package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
import t6.n.e;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0 0\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterSwitcherListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;", "filterUpdate", "", "initFilterSwitcherList", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "switcherInfo", "", "newVal", "onSwitcherChanged", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;Z)V", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "title", g.a, "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "h", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "e", "Ljava/lang/String;", "codeName", "", "d", "getListSwitcherInfo", "listSwitcherInfo", "f", "Ljava/util/List;", "defaultListActiveSwitcher", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSwitcherListViewModel extends ViewModel implements IFilterSwitcherListViewModel {
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<FilterSwitcherInfo>> d = new MutableLiveData<>();
    public String e;
    public List<Boolean> f = CollectionsKt__CollectionsKt.emptyList();
    public IFilterSwitcherListUpdate g;
    public final IPanelButtonsController h;

    public FilterSwitcherListViewModel(@NotNull IPanelButtonsController iPanelButtonsController) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        this.h = iPanelButtonsController;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel
    public void initFilterSwitcherList(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterSwitcherListUpdate iFilterSwitcherListUpdate) {
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        Intrinsics.checkParameterIsNotNull(iFilterSwitcherListUpdate, "filterUpdate");
        boolean z = filterInfo.getEditable() && filterInfo.getDetail().size() > 1;
        List<FilterItem.FilterInfo.DetailFilter> detail = filterInfo.getDetail();
        ArrayList arrayList = new ArrayList();
        for (T t : detail) {
            if (Intrinsics.areEqual(t.getCode(), "active")) {
                arrayList.add(t);
            }
        }
        List<FilterItem.FilterInfo.DetailFilter> detail2 = filterInfo.getDetail();
        ArrayList<FilterSwitcherInfo> arrayList2 = new ArrayList(e.collectionSizeOrDefault(detail2, 10));
        for (T t2 : detail2) {
            arrayList2.add(new FilterSwitcherInfo(t2.getTitle(), Intrinsics.areEqual(t2.getCode(), "active"), z, !Intrinsics.areEqual(t2.getCode(), "active") || arrayList.size() >= 2, t2.getValue()));
        }
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(arrayList2, 10));
        for (FilterSwitcherInfo filterSwitcherInfo : arrayList2) {
            arrayList3.add(Boolean.valueOf(filterSwitcherInfo.getActive()));
        }
        this.f = arrayList3;
        this.e = filterInfo.getName();
        this.g = iFilterSwitcherListUpdate;
        getTitle().setValue(filterInfo.getTitleDetail());
        getListSwitcherInfo().setValue(arrayList2);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel
    public void onSwitcherChanged(@NotNull FilterSwitcherInfo filterSwitcherInfo, boolean z) {
        Intrinsics.checkParameterIsNotNull(filterSwitcherInfo, "switcherInfo");
        List<FilterSwitcherInfo> value = getListSwitcherInfo().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkExpressionValueIsNotNull(value, "listSwitcherInfo.value ?: listOf()");
        Iterator<FilterSwitcherInfo> it = value.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getValue(), filterSwitcherInfo.getValue())) {
                break;
            } else {
                i++;
            }
        }
        value.get(i).setActive(z);
        ArrayList arrayList = new ArrayList();
        for (T t : value) {
            if (t.getActive()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(value, 10));
        for (T t2 : value) {
            arrayList2.add(FilterSwitcherInfo.copy$default(t2, null, false, false, !t2.getActive() || arrayList.size() >= 2, null, 23, null));
        }
        getListSwitcherInfo().setValue(arrayList2);
        IPanelButtonsController iPanelButtonsController = this.h;
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (this.f.get(i2).booleanValue() != ((FilterSwitcherInfo) next).getActive()) {
                arrayList3.add(next);
            }
            i2 = i3;
        }
        iPanelButtonsController.setPanelEnabledAction(!arrayList3.isEmpty());
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Object next2 = it3.next();
            if (((FilterSwitcherInfo) next2).getActive()) {
                arrayList4.add(next2);
            }
        }
        ArrayList arrayList5 = new ArrayList(e.collectionSizeOrDefault(arrayList4, 10));
        Iterator it4 = arrayList4.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((FilterSwitcherInfo) it4.next()).getValue());
        }
        IFilterSwitcherListUpdate iFilterSwitcherListUpdate = this.g;
        if (iFilterSwitcherListUpdate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterUpdate");
        }
        String str = this.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeName");
        }
        Map<String, ? extends List<String>> mapOf = q.mapOf(TuplesKt.to(str, arrayList5));
        String str2 = this.e;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeName");
        }
        iFilterSwitcherListUpdate.updateFilterSwitcherList(mapOf, str2);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel
    @NotNull
    public MutableLiveData<List<FilterSwitcherInfo>> getListSwitcherInfo() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel
    @NotNull
    public MutableLiveData<String> getTitle() {
        return this.c;
    }
}
