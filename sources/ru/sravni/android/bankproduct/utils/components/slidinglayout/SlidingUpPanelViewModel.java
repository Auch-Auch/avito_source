package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelViewModel;", "", "showPanel", "()V", "closePanel", "Lcom/sothree/slidinguppanel/SlidingUpPanelLayout$PanelState;", "panelState", "setPanelState", "(Lcom/sothree/slidinguppanel/SlidingUpPanelLayout$PanelState;)V", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "getPanelStateSignal", "()Landroidx/lifecycle/MutableLiveData;", "panelStateSignal", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "d", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "<init>", "(Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SlidingUpPanelViewModel extends ViewModel implements ISlidingUpPanelViewModel {
    @NotNull
    public final MutableLiveData<SlidingUpPanelLayout.PanelState> c = new MutableLiveData<>();
    public final IKeyboardHider d;

    public SlidingUpPanelViewModel(@NotNull IKeyboardHider iKeyboardHider) {
        Intrinsics.checkParameterIsNotNull(iKeyboardHider, "keyboardHider");
        this.d = iKeyboardHider;
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController
    public void closePanel() {
        getPanelStateSignal().setValue(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel
    public void setPanelState(@NotNull SlidingUpPanelLayout.PanelState panelState) {
        Intrinsics.checkParameterIsNotNull(panelState, "panelState");
        if (panelState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            this.d.hideKeyboard();
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelController
    public void showPanel() {
        getPanelStateSignal().setValue(SlidingUpPanelLayout.PanelState.EXPANDED);
    }

    @Override // ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel
    @NotNull
    public MutableLiveData<SlidingUpPanelLayout.PanelState> getPanelStateSignal() {
        return this.c;
    }
}
