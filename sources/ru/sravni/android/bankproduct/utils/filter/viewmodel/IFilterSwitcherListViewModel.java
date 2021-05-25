package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;", "filterUpdate", "", "initFilterSwitcherList", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "switcherInfo", "", "newVal", "onSwitcherChanged", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;Z)V", "Landroidx/lifecycle/LiveData;", "", "getTitle", "()Landroidx/lifecycle/LiveData;", "title", "", "getListSwitcherInfo", "listSwitcherInfo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IFilterSwitcherListViewModel {
    @NotNull
    LiveData<List<FilterSwitcherInfo>> getListSwitcherInfo();

    @NotNull
    LiveData<String> getTitle();

    void initFilterSwitcherList(@NotNull FilterItem.FilterInfo filterInfo, @NotNull IFilterSwitcherListUpdate iFilterSwitcherListUpdate);

    void onSwitcherChanged(@NotNull FilterSwitcherInfo filterSwitcherInfo, boolean z);
}
