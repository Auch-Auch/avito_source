package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.adapter.INumberPickerListenerPosition;
import ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayViewModel;", "Lru/sravni/android/bankproduct/utils/adapter/INumberPickerListenerPosition;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;", "filterUpdate", "", "initFilterBarrelDay", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterBarrelDayUpdate;)V", "Landroidx/lifecycle/LiveData;", "", "getTitle", "()Landroidx/lifecycle/LiveData;", "title", "Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "getInitDateList", "initDateList", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IFilterBarrelDayViewModel extends INumberPickerListenerPosition {
    @NotNull
    LiveData<InitNumberPicker> getInitDateList();

    @NotNull
    LiveData<String> getTitle();

    void initFilterBarrelDay(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterBarrelDayUpdate iFilterBarrelDayUpdate);
}
