package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongProgression;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterBarrelDayInfo;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import t6.n.q;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterBarrelDayViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;", "filterUpdate", "", "initFilterBarrelDay", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;)V", "", VKApiConst.POSITION, "setNewNumberPickerPosition", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "title", "Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "c", "getInitDateList", "initDateList", "f", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterBarrelDayInfo;", "e", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterBarrelDayInfo;", "barrelDayInfo", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", g.a, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterBarrelDayViewModel extends ViewModel implements IFilterBarrelDayViewModel {
    @NotNull
    public final MutableLiveData<InitNumberPicker> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> d = new MutableLiveData<>();
    public FilterBarrelDayInfo e;
    public IFilterBarrelDayUpdate f;
    public final IPanelButtonsController g;

    public FilterBarrelDayViewModel(@NotNull IPanelButtonsController iPanelButtonsController) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        this.g = iPanelButtonsController;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel
    public void initFilterBarrelDay(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterBarrelDayUpdate iFilterBarrelDayUpdate) {
        Object obj;
        T t;
        T t2;
        T t3;
        boolean z;
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        Intrinsics.checkParameterIsNotNull(iFilterBarrelDayUpdate, "filterUpdate");
        try {
            Iterator<T> it = filterInfo.getDetail().iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getCode(), "minValue")) {
                    break;
                }
            }
            T t4 = t;
            String value = t4 != null ? t4.getValue() : null;
            Iterator<T> it2 = filterInfo.getDetail().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it2.next();
                if (Intrinsics.areEqual(t2.getCode(), "maxValue")) {
                    break;
                }
            }
            T t5 = t2;
            String value2 = t5 != null ? t5.getValue() : null;
            Iterator<T> it3 = filterInfo.getDetail().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it3.next();
                if (Intrinsics.areEqual(t3.getCode(), "recommendedValue")) {
                    break;
                }
            }
            T t7 = t3;
            String value3 = t7 != null ? t7.getValue() : null;
            Date parseDate = DateUtilKt.getParseDate(DateUtilKt.serverFormat, value);
            Date parseDate2 = DateUtilKt.getParseDate(DateUtilKt.serverFormat, value2);
            Date parseDate3 = DateUtilKt.getParseDate(DateUtilKt.serverFormat, value3);
            long time = parseDate.getTime();
            long time2 = parseDate2.getTime();
            long time3 = parseDate3.getTime();
            if (time > time3 || time2 < time3) {
                throw new RecommendedFilterBarrelDayException(filterInfo);
            }
            LongProgression step = e.step(new LongRange(parseDate.getTime(), parseDate2.getTime()), DateUtilKt.getOneDayToMillis());
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(step, 10));
            Iterator it4 = step.iterator();
            while (it4.hasNext()) {
                arrayList.add(Long.valueOf(((LongIterator) it4).nextLong()));
            }
            String name = filterInfo.getName();
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((Number) next).longValue() == parseDate3.getTime()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            FilterBarrelDayInfo filterBarrelDayInfo = new FilterBarrelDayInfo(name, arrayList, CollectionsKt___CollectionsKt.indexOf((List<? extends Object>) arrayList, obj), parseDate3.getTime());
            this.e = filterBarrelDayInfo;
            this.f = iFilterBarrelDayUpdate;
            getTitle().setValue(filterInfo.getTitleDetail());
            MutableLiveData<InitNumberPicker> initDateList = getInitDateList();
            List<Long> listDate = filterBarrelDayInfo.getListDate();
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(listDate, 10));
            Iterator<T> it6 = listDate.iterator();
            while (it6.hasNext()) {
                arrayList2.add(DateUtilKt.getFormatDate(DateUtilKt.viewFormat, it6.next().longValue()));
            }
            initDateList.setValue(new InitNumberPicker(arrayList2, filterBarrelDayInfo.getDatePosition()));
        } catch (Exception unused) {
            throw new ParseFilterBarrelDayException(filterInfo);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.adapter.INumberPickerListenerPosition
    public void setNewNumberPickerPosition(int i) {
        FilterBarrelDayInfo filterBarrelDayInfo = this.e;
        if (filterBarrelDayInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrelDayInfo");
        }
        FilterBarrelDayInfo copy$default = FilterBarrelDayInfo.copy$default(filterBarrelDayInfo, null, null, i, 0, 11, null);
        this.e = copy$default;
        IPanelButtonsController iPanelButtonsController = this.g;
        if (copy$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrelDayInfo");
        }
        iPanelButtonsController.setPanelEnabledAction(copy$default.isNewDateValue());
        FilterBarrelDayInfo filterBarrelDayInfo2 = this.e;
        if (filterBarrelDayInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrelDayInfo");
        }
        String formatDate = DateUtilKt.getFormatDate(DateUtilKt.serverFormat, filterBarrelDayInfo2.getNewDate());
        IFilterBarrelDayUpdate iFilterBarrelDayUpdate = this.f;
        if (iFilterBarrelDayUpdate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterUpdate");
        }
        FilterBarrelDayInfo filterBarrelDayInfo3 = this.e;
        if (filterBarrelDayInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrelDayInfo");
        }
        Map<String, String> mapOf = q.mapOf(TuplesKt.to(filterBarrelDayInfo3.getCode(), formatDate));
        FilterBarrelDayInfo filterBarrelDayInfo4 = this.e;
        if (filterBarrelDayInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrelDayInfo");
        }
        iFilterBarrelDayUpdate.updateFilterBarrelDay(mapOf, filterBarrelDayInfo4.getCode());
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel
    @NotNull
    public MutableLiveData<InitNumberPicker> getInitDateList() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterBarrelDayViewModel
    @NotNull
    public MutableLiveData<String> getTitle() {
        return this.d;
    }
}
