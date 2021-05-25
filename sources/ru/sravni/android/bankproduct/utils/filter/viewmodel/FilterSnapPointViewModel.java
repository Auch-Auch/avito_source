package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSnapPointInfo;
import t6.n.e;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterSnapPointViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointViewModel;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointUpdate;", "filterUpdate", "", "initFilterSnapPoint", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointUpdate;)V", "", VKApiConst.POSITION, "setNewNumberPickerPosition", "(I)V", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", g.a, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "title", "Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "c", "getInitPeriodList", "initPeriodList", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSnapPointInfo;", "e", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSnapPointInfo;", "snapPointInfo", "f", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSnapPointUpdate;", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSnapPointViewModel extends ViewModel implements IFilterSnapPointViewModel {
    @NotNull
    public final MutableLiveData<InitNumberPicker> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> d = new MutableLiveData<>();
    public FilterSnapPointInfo e;
    public IFilterSnapPointUpdate f;
    public final IPanelButtonsController g;

    public FilterSnapPointViewModel(@NotNull IPanelButtonsController iPanelButtonsController) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        this.g = iPanelButtonsController;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel
    public void initFilterSnapPoint(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterSnapPointUpdate iFilterSnapPointUpdate) {
        T t;
        String str;
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        Intrinsics.checkParameterIsNotNull(iFilterSnapPointUpdate, "filterUpdate");
        List<FilterItem.FilterInfo.DetailFilter> detail = filterInfo.getDetail();
        ArrayList arrayList = new ArrayList();
        for (T t2 : detail) {
            if (Intrinsics.areEqual(t2.getCode(), "pointPeriod")) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FilterItem.FilterInfo.DetailFilter detailFilter = (FilterItem.FilterInfo.DetailFilter) it.next();
            arrayList2.add(new FilterInfo(detailFilter.getTitle(), detailFilter.getValue()));
        }
        Iterator<T> it2 = filterInfo.getDetail().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (Intrinsics.areEqual(t.getCode(), "currentPeriod")) {
                break;
            }
        }
        T t3 = t;
        int i = 0;
        if (t3 == null || (str = t3.getValue()) == null) {
            str = ((FilterInfo) arrayList2.get(0)).getValue();
        }
        Iterator it3 = arrayList2.iterator();
        int i2 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(str, ((FilterInfo) it3.next()).getValue())) {
                break;
            } else {
                i2++;
            }
        }
        String name = filterInfo.getName();
        if (i2 >= 0) {
            i = i2;
        }
        FilterSnapPointInfo filterSnapPointInfo = new FilterSnapPointInfo(name, arrayList2, i, str);
        this.e = filterSnapPointInfo;
        this.f = iFilterSnapPointUpdate;
        getTitle().setValue(filterInfo.getTitleDetail());
        MutableLiveData<InitNumberPicker> initPeriodList = getInitPeriodList();
        List<FilterInfo> listFilterInfo = filterSnapPointInfo.getListFilterInfo();
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(listFilterInfo, 10));
        Iterator<T> it4 = listFilterInfo.iterator();
        while (it4.hasNext()) {
            arrayList3.add(it4.next().getTitle());
        }
        initPeriodList.setValue(new InitNumberPicker(arrayList3, filterSnapPointInfo.getPeriodPosition()));
    }

    @Override // ru.sravni.android.bankproduct.utils.adapter.INumberPickerListenerPosition
    public void setNewNumberPickerPosition(int i) {
        FilterSnapPointInfo filterSnapPointInfo = this.e;
        if (filterSnapPointInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapPointInfo");
        }
        FilterSnapPointInfo copy$default = FilterSnapPointInfo.copy$default(filterSnapPointInfo, null, null, i, null, 11, null);
        this.e = copy$default;
        IPanelButtonsController iPanelButtonsController = this.g;
        if (copy$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapPointInfo");
        }
        iPanelButtonsController.setPanelEnabledAction(copy$default.isNewPeriodValue());
        IFilterSnapPointUpdate iFilterSnapPointUpdate = this.f;
        if (iFilterSnapPointUpdate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterUpdate");
        }
        FilterSnapPointInfo filterSnapPointInfo2 = this.e;
        if (filterSnapPointInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapPointInfo");
        }
        String code = filterSnapPointInfo2.getCode();
        FilterSnapPointInfo filterSnapPointInfo3 = this.e;
        if (filterSnapPointInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapPointInfo");
        }
        Map<String, String> mapOf = q.mapOf(TuplesKt.to(code, filterSnapPointInfo3.getNewPeriod()));
        FilterSnapPointInfo filterSnapPointInfo4 = this.e;
        if (filterSnapPointInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapPointInfo");
        }
        iFilterSnapPointUpdate.updateFilterSnapPoint(mapOf, filterSnapPointInfo4.getCode());
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel
    @NotNull
    public MutableLiveData<InitNumberPicker> getInitPeriodList() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel
    @NotNull
    public MutableLiveData<String> getTitle() {
        return this.d;
    }
}
