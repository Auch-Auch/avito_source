package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingPanelButtonViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingPanelButtonViewModel;", "", "applyClicked", "()V", "closeClicked", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;", "panelSetupInfo", "setPanelSetupInfo", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;)V", "", "count", "setCountForPanel", "(I)V", "", "wait", "setWaitCountForPanel", "(Z)V", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "buttonActions", "setPanelClickedActions", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;)V", "enabled", "setPanelEnabledAction", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "h", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;", "slidingPanelController", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getCountForButton", "()Landroidx/lifecycle/MutableLiveData;", "countForButton", g.a, "Lru/sravni/android/bankproduct/utils/components/slidinglayout/IPanelButtonActions;", "f", "getPanelEnabledApply", "panelEnabledApply", "e", "getWaitCount", "waitCount", "c", "getPanelSetupInfo", "<init>", "(Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SlidingPanelButtonViewModel extends ViewModel implements ISlidingPanelButtonViewModel {
    @NotNull
    public final MutableLiveData<SlidingUpPanelSetupInfo> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> f = new MutableLiveData<>();
    public IPanelButtonActions g;
    public final ISlidingUpPanelController h;

    public SlidingPanelButtonViewModel(@NotNull ISlidingUpPanelController iSlidingUpPanelController) {
        Intrinsics.checkParameterIsNotNull(iSlidingUpPanelController, "slidingPanelController");
        this.h = iSlidingUpPanelController;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void applyClicked() {
        IPanelButtonActions iPanelButtonActions = this.g;
        if (iPanelButtonActions != null) {
            iPanelButtonActions.applyClicked();
        }
        this.h.closePanel();
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonActions
    public void closeClicked() {
        IPanelButtonActions iPanelButtonActions = this.g;
        if (iPanelButtonActions != null) {
            iPanelButtonActions.closeClicked();
        }
        this.h.closePanel();
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController
    public void setCountForPanel(int i) {
        getCountForButton().setValue(Integer.valueOf(i));
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController
    public void setPanelClickedActions(@Nullable IPanelButtonActions iPanelButtonActions) {
        this.g = iPanelButtonActions;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController
    public void setPanelEnabledAction(boolean z) {
        getPanelEnabledApply().setValue(Boolean.valueOf(z));
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController
    public void setPanelSetupInfo(@NotNull SlidingUpPanelSetupInfo slidingUpPanelSetupInfo) {
        Intrinsics.checkParameterIsNotNull(slidingUpPanelSetupInfo, "panelSetupInfo");
        getPanelSetupInfo().setValue(slidingUpPanelSetupInfo);
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.IPanelButtonsController
    public void setWaitCountForPanel(boolean z) {
        getWaitCount().postValue(Boolean.valueOf(z));
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel
    @NotNull
    public MutableLiveData<Integer> getCountForButton() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel
    @NotNull
    public MutableLiveData<Boolean> getPanelEnabledApply() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel
    @NotNull
    public MutableLiveData<SlidingUpPanelSetupInfo> getPanelSetupInfo() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel
    @NotNull
    public MutableLiveData<Boolean> getWaitCount() {
        return this.e;
    }
}
