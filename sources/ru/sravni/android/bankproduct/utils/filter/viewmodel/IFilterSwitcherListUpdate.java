package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00072\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListUpdate;", "", "", "", "", "switcherValue", "updatedField", "", "updateFilterSwitcherList", "(Ljava/util/Map;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IFilterSwitcherListUpdate {
    void updateFilterSwitcherList(@NotNull Map<String, ? extends List<String>> map, @NotNull String str);
}
