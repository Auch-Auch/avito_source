package ru.sravni.android.bankproduct.utils.filter.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/viewmodel/FilterBarrelDayViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "panelViewModel", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterBarrelDayViewModelFactory implements ViewModelProvider.Factory {
    public final IPanelButtonsController a;

    public FilterBarrelDayViewModelFactory(@NotNull IPanelButtonsController iPanelButtonsController) {
        Intrinsics.checkParameterIsNotNull(iPanelButtonsController, "panelViewModel");
        this.a = iPanelButtonsController;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new FilterBarrelDayViewModel(this.a);
    }
}
