package ru.sravni.android.bankproduct.utils.adapter;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingUpPanelViewKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sothree/slidinguppanel/SlidingUpPanelLayout;", "view", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelViewModel;", "slideUpPanelViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "bindStateToSlidingUpPanel", "(Lcom/sothree/slidinguppanel/SlidingUpPanelLayout;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingSlidingUpPanelKt {

    public static final class a<T> implements Observer<SlidingUpPanelLayout.PanelState> {
        public final /* synthetic */ SlidingUpPanelLayout a;

        public a(SlidingUpPanelLayout slidingUpPanelLayout) {
            this.a = slidingUpPanelLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(SlidingUpPanelLayout.PanelState panelState) {
            this.a.setPanelState(panelState);
        }
    }

    @BindingAdapter({"viewModel", "lifecycleOwner"})
    public static final void bindStateToSlidingUpPanel(@NotNull SlidingUpPanelLayout slidingUpPanelLayout, @NotNull ISlidingUpPanelViewModel iSlidingUpPanelViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkParameterIsNotNull(slidingUpPanelLayout, "view");
        Intrinsics.checkParameterIsNotNull(iSlidingUpPanelViewModel, "slideUpPanelViewModel");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "lifecycleOwner");
        SlidingUpPanelViewKt.setup(slidingUpPanelLayout, iSlidingUpPanelViewModel, lifecycleOwner);
        iSlidingUpPanelViewModel.getPanelStateSignal().observe(lifecycleOwner, new a(slidingUpPanelLayout));
    }
}
