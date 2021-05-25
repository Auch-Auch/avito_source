package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonsController;", "", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;", "panelSetupInfo", "", "setPanelSetupInfo", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;)V", "", "count", "setCountForPanel", "(I)V", "", "wait", "setWaitCountForPanel", "(Z)V", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "buttonActions", "setPanelClickedActions", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;)V", "enabled", "setPanelEnabledAction", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IPanelButtonsController {
    void setCountForPanel(int i);

    void setPanelClickedActions(@Nullable IPanelButtonActions iPanelButtonActions);

    void setPanelEnabledAction(boolean z);

    void setPanelSetupInfo(@NotNull SlidingUpPanelSetupInfo slidingUpPanelSetupInfo);

    void setWaitCountForPanel(boolean z);
}
