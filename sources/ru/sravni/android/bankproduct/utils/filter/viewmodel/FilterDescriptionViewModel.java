package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterDescriptionViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterDescriptionViewModel;", "", "description", "", "initFilterDescription", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "getDescriptionSignal", "()Landroidx/lifecycle/MutableLiveData;", "descriptionSignal", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterDescriptionViewModel extends ViewModel implements IFilterDescriptionViewModel {
    @NotNull
    public final MutableLiveData<String> c = new MutableLiveData<>();

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel
    public void initFilterDescription(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "description");
        getDescriptionSignal().setValue(str);
    }

    @Override // ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel
    @NotNull
    public MutableLiveData<String> getDescriptionSignal() {
        return this.c;
    }
}
