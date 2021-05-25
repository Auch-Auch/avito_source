package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo;
import ru.sravni.android.bankproduct.utils.string.StringUtilKt;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b+\u0010\u001eR\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterSliderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;", "filterUpdate", "", "initFilterSlider", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;)V", "", "newValue", "onSliderValueChanged", "(Ljava/lang/String;)V", "", VKApiConst.POSITION, "onSliderPositionChanged", "(F)V", "", "value", "c", "(I)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo;", "i", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo;", "sliderInfo", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getProgressPointsCount", "()Landroidx/lifecycle/MutableLiveData;", "progressPointsCount", "h", "getSliderStringSignal", "sliderStringSignal", g.a, "getMaxSliderValue", "maxSliderValue", "j", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;", "e", "getTitle", "title", "getProgressPositionSignal", "progressPositionSignal", "f", "getMinSliderValue", "minSliderValue", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "k", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSliderViewModel extends ViewModel implements IFilterSliderViewModel {
    @NotNull
    public final MutableLiveData<Integer> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> h = new MutableLiveData<>();
    public FilterSliderInfo i;
    public IFilterSliderUpdate j;
    public final IPanelButtonsController k;

    public FilterSliderViewModel(@NotNull IPanelButtonsController iPanelButtonsController) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        this.k = iPanelButtonsController;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r11) {
        /*
            r10 = this;
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r0 = r10.i
            java.lang.String r9 = "sliderInfo"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0009:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 47
            r8 = 0
            r5 = r11
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r0 = ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo.copy$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r10.i = r0
            androidx.lifecycle.MutableLiveData r0 = r10.getProgressPositionSignal()
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r1 = r10.i
            if (r1 != 0) goto L_0x0023
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0023:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo$SliderParam r1 = r1.getMinSliderParam()
            int r1 = r1.getValue()
            r2 = 0
            if (r11 > r1) goto L_0x0030
            r1 = 0
            goto L_0x006d
        L_0x0030:
            float r1 = (float) r11
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r3 = r10.i
            if (r3 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0038:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo$SliderParam r3 = r3.getMaxSliderParam()
            int r3 = r3.getValue()
            float r3 = (float) r3
            float r1 = r1 / r3
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r3 = r10.i
            if (r3 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0049:
            int r3 = r3.getProgressPoints()
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r3 = r10.i
            if (r3 != 0) goto L_0x0058
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0058:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo$SliderParam r3 = r3.getMaxSliderParam()
            int r3 = r3.getValue()
            if (r11 < r3) goto L_0x006d
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r1 = r10.i
            if (r1 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0069:
            int r1 = r1.getProgressPoints()
        L_0x006d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.setValue(r1)
            androidx.lifecycle.MutableLiveData r0 = r10.getSliderStringSignal()
            java.lang.String r1 = java.lang.String.valueOf(r11)
            java.lang.String r1 = ru.sravni.android.bankproduct.utils.string.StringUtilKt.textWithThousandSpace(r1)
            r0.setValue(r1)
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r0 = r10.i
            if (r0 != 0) goto L_0x008a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x008a:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo$SliderParam r0 = r0.getMinSliderParam()
            int r0 = r0.getValue()
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r1 = r10.i
            if (r1 != 0) goto L_0x0099
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0099:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo$SliderParam r1 = r1.getMaxSliderParam()
            int r1 = r1.getValue()
            if (r0 <= r11) goto L_0x00a4
            goto L_0x00ba
        L_0x00a4:
            if (r1 < r11) goto L_0x00ba
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r0 = r10.i
            if (r0 != 0) goto L_0x00ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x00ad:
            int r0 = r0.getDefaultValue()
            if (r11 == r0) goto L_0x00ba
            ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController r0 = r10.k
            r1 = 1
            r0.setPanelEnabledAction(r1)
            goto L_0x00bf
        L_0x00ba:
            ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController r0 = r10.k
            r0.setPanelEnabledAction(r2)
        L_0x00bf:
            ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderUpdate r0 = r10.j
            if (r0 != 0) goto L_0x00c8
            java.lang.String r1 = "filterUpdate"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00c8:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r1 = r10.i
            if (r1 != 0) goto L_0x00cf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x00cf:
            java.lang.String r1 = r1.getCode()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            kotlin.Pair r11 = kotlin.TuplesKt.to(r1, r11)
            java.util.Map r11 = t6.n.q.mapOf(r11)
            ru.sravni.android.bankproduct.utils.filter.entity.FilterSliderInfo r1 = r10.i
            if (r1 != 0) goto L_0x00e6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x00e6:
            java.lang.String r1 = r1.getCode()
            r0.updateFilterSlider(r11, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.utils.filter.viewmodel.FilterSliderViewModel.c(int):void");
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    public void initFilterSlider(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterSliderUpdate iFilterSliderUpdate) {
        FilterSliderInfo.SliderParam sliderParam;
        T t;
        T t2;
        T t3;
        FilterSliderInfo.SliderParam sliderParam2;
        FilterSliderInfo.SliderParam sliderParam3;
        T t4;
        FilterSliderInfo.SliderParam sliderParam4;
        String value;
        String value2;
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        Intrinsics.checkParameterIsNotNull(iFilterSliderUpdate, "filterUpdate");
        Iterator<T> it = filterInfo.getDetail().iterator();
        while (true) {
            sliderParam = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getCode(), "currentValue")) {
                break;
            }
        }
        T t5 = t;
        int parseInt = (t5 == null || (value2 = t5.getValue()) == null) ? 10000 : Integer.parseInt(value2);
        Iterator<T> it2 = filterInfo.getDetail().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (Intrinsics.areEqual(t2.getCode(), AnalyticFieldsName.step)) {
                break;
            }
        }
        T t7 = t2;
        int parseInt2 = (t7 == null || (value = t7.getValue()) == null) ? 50000 : Integer.parseInt(value);
        Iterator<T> it3 = filterInfo.getDetail().iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            if (Intrinsics.areEqual(t3.getCode(), "maxValue")) {
                break;
            }
        }
        T t8 = t3;
        if (t8 != null) {
            Integer intOrNull = l.toIntOrNull(t8.getValue());
            sliderParam2 = new FilterSliderInfo.SliderParam(t8.getTitle(), intOrNull != null ? intOrNull.intValue() : 10000000);
        } else {
            sliderParam2 = null;
        }
        if (sliderParam2 != null) {
            sliderParam3 = sliderParam2;
        } else {
            sliderParam3 = new FilterSliderInfo.SliderParam(String.valueOf(10000000), 10000000);
        }
        Iterator<T> it4 = filterInfo.getDetail().iterator();
        while (true) {
            if (!it4.hasNext()) {
                t4 = null;
                break;
            }
            t4 = it4.next();
            if (Intrinsics.areEqual(t4.getCode(), "minValue")) {
                break;
            }
        }
        T t9 = t4;
        if (t9 != null) {
            Integer intOrNull2 = l.toIntOrNull(t9.getValue());
            sliderParam = new FilterSliderInfo.SliderParam(t9.getTitle(), intOrNull2 != null ? intOrNull2.intValue() : 10000);
        }
        if (sliderParam != null) {
            sliderParam4 = sliderParam;
        } else {
            sliderParam4 = new FilterSliderInfo.SliderParam(String.valueOf(10000), 10000);
        }
        FilterSliderInfo filterSliderInfo = new FilterSliderInfo(filterInfo.getName(), parseInt2, sliderParam4, sliderParam3, parseInt, parseInt);
        this.i = filterSliderInfo;
        this.j = iFilterSliderUpdate;
        getTitle().setValue(filterInfo.getTitleDetail());
        getProgressPointsCount().setValue(Integer.valueOf(filterSliderInfo.getProgressPoints()));
        getMinSliderValue().setValue(filterSliderInfo.getMinSliderParam().getValueText());
        getMaxSliderValue().setValue(filterSliderInfo.getMaxSliderParam().getValueText());
        c(filterSliderInfo.getSliderValue());
    }

    @Override // ru.sravni.android.bankproduct.utils.adapter.ISliderPositionListener
    public void onSliderPositionChanged(float f2) {
        int i2;
        int i3 = (int) f2;
        Integer value = getProgressPositionSignal().getValue();
        if (value == null || i3 != value.intValue()) {
            if (i3 == 0) {
                FilterSliderInfo filterSliderInfo = this.i;
                if (filterSliderInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
                }
                i2 = filterSliderInfo.getMinSliderParam().getValue();
            } else {
                FilterSliderInfo filterSliderInfo2 = this.i;
                if (filterSliderInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
                }
                int value2 = filterSliderInfo2.getMaxSliderParam().getValue();
                FilterSliderInfo filterSliderInfo3 = this.i;
                if (filterSliderInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
                }
                i2 = i3 * (value2 / filterSliderInfo3.getProgressPoints());
            }
            c(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    public void onSliderValueChanged(@NotNull String str) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(str, "newValue");
        Integer intOrNull = l.toIntOrNull(StringUtilKt.textWithoutSpace(str));
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            FilterSliderInfo filterSliderInfo = this.i;
            if (filterSliderInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
            }
            if (intValue != filterSliderInfo.getSliderValue()) {
                FilterSliderInfo filterSliderInfo2 = this.i;
                if (filterSliderInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
                }
                if (intValue > filterSliderInfo2.getMaxSliderParam().getValue()) {
                    FilterSliderInfo filterSliderInfo3 = this.i;
                    if (filterSliderInfo3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sliderInfo");
                    }
                    intValue = filterSliderInfo3.getMaxSliderParam().getValue();
                }
                c(intValue);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.k.setPanelEnabledAction(false);
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<String> getMaxSliderValue() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<String> getMinSliderValue() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<Integer> getProgressPointsCount() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<Integer> getProgressPositionSignal() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<String> getSliderStringSignal() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel
    @NotNull
    public MutableLiveData<String> getTitle() {
        return this.e;
    }
}
