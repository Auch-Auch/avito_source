package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingPanelButtonViewModel;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;", "getPanelSetupInfo", "()Landroidx/lifecycle/LiveData;", "panelSetupInfo", "", "getWaitCount", "waitCount", "getPanelEnabledApply", "panelEnabledApply", "", "getCountForButton", "countForButton", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISlidingPanelButtonViewModel extends IPanelButtonActions, IPanelButtonsController {
    @NotNull
    LiveData<Integer> getCountForButton();

    @NotNull
    LiveData<Boolean> getPanelEnabledApply();

    @NotNull
    LiveData<SlidingUpPanelSetupInfo> getPanelSetupInfo();

    @NotNull
    LiveData<Boolean> getWaitCount();
}
