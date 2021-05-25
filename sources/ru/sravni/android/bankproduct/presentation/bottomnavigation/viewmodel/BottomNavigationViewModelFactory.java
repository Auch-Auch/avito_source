package ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.main.IMainAnalytic;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/BottomNavigationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;", "dashboardAnalytic", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousModuleInfoController", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "c", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "<init>", "(Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BottomNavigationViewModelFactory implements ViewModelProvider.Factory {
    public final IMainAnalytic a;
    public final IPreviousModuleInfoController b;
    public final IFeatureToggleRouterDomain c;

    public BottomNavigationViewModelFactory(@NotNull IMainAnalytic iMainAnalytic, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iMainAnalytic, "dashboardAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousModuleInfoController");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.a = iMainAnalytic;
        this.b = iPreviousModuleInfoController;
        this.c = iFeatureToggleRouterDomain;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new BottomNavigationViewModel(this.a, this.b, this.c);
    }
}
