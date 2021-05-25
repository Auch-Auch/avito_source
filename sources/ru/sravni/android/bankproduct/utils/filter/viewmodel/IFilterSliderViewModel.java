package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.adapter.ISliderPositionListener;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "Lru/sravni/android/bankproduct/utils/adapter/ISliderPositionListener;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;", "filterUpdate", "", "initFilterSlider", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderUpdate;)V", "", "newValue", "onSliderValueChanged", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "getTitle", "()Landroidx/lifecycle/LiveData;", "title", "getMaxSliderValue", "maxSliderValue", "", "getProgressPointsCount", "progressPointsCount", "getProgressPositionSignal", "progressPositionSignal", "getMinSliderValue", "minSliderValue", "getSliderStringSignal", "sliderStringSignal", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IFilterSliderViewModel extends ISliderPositionListener {
    @NotNull
    LiveData<String> getMaxSliderValue();

    @NotNull
    LiveData<String> getMinSliderValue();

    @NotNull
    LiveData<Integer> getProgressPointsCount();

    @NotNull
    LiveData<Integer> getProgressPositionSignal();

    @NotNull
    LiveData<String> getSliderStringSignal();

    @NotNull
    LiveData<String> getTitle();

    void initFilterSlider(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterSliderUpdate iFilterSliderUpdate);

    void onSliderValueChanged(@NotNull String str);
}
