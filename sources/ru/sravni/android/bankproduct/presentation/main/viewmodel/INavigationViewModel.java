package ru.sravni.android.bankproduct.presentation.main.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.navigation.DataForNavigation;
import ru.sravni.android.bankproduct.utils.navigation.DataForPopBack;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.DataForOpenWeb;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/presentation/main/viewmodel/INavigationViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/utils/navigation/entity/DataForOpenWeb;", "getOpenWebData", "()Landroidx/lifecycle/LiveData;", "openWebData", "", "getBackSignal", "backSignal", "Lru/sravni/android/bankproduct/utils/navigation/DataForNavigation;", "getMainNavigationData", "mainNavigationData", "", "getExitFromProfile", "exitFromProfile", "Lru/sravni/android/bankproduct/utils/navigation/DataForPopBack;", "getPopBackStackData", "popBackStackData", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface INavigationViewModel extends INavigator {
    @NotNull
    LiveData<Unit> getBackSignal();

    @NotNull
    LiveData<Integer> getExitFromProfile();

    @NotNull
    LiveData<DataForNavigation> getMainNavigationData();

    @NotNull
    LiveData<DataForOpenWeb> getOpenWebData();

    @NotNull
    LiveData<DataForPopBack> getPopBackStackData();
}
