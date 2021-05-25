package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterListInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterListInfoViewModel;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "", "initFilterListInfo", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;)V", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "title", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterInfo;", "d", "getListInfo", "listInfo", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterListInfoViewModel extends ViewModel implements IFilterListInfoViewModel {
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<FilterInfo>> d = new MutableLiveData<>();

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel
    public void initFilterListInfo(@NotNull FilterItem.FilterInfo filterInfo) {
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        getTitle().setValue(filterInfo.getTitleDetail());
        MutableLiveData<List<FilterInfo>> listInfo = getListInfo();
        List<FilterItem.FilterInfo.DetailFilter> detail = filterInfo.getDetail();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(detail, 10));
        for (T t : detail) {
            arrayList.add(new FilterInfo(t.getTitle(), t.getValue()));
        }
        listInfo.setValue(arrayList);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel
    @NotNull
    public MutableLiveData<List<FilterInfo>> getListInfo() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel
    @NotNull
    public MutableLiveData<String> getTitle() {
        return this.c;
    }
}
