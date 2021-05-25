package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sothree/slidinguppanel/SlidingUpPanelLayout;", "Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelViewModel;", "panelViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "setup", "(Lcom/sothree/slidinguppanel/SlidingUpPanelLayout;Lru/sravni/android/bankproduct/utils/components/slidinglayout/ISlidingUpPanelViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class SlidingUpPanelViewKt {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ISlidingUpPanelViewModel a;

        public a(ISlidingUpPanelViewModel iSlidingUpPanelViewModel) {
            this.a = iSlidingUpPanelViewModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.closePanel();
        }
    }

    public static final void setup(@NotNull SlidingUpPanelLayout slidingUpPanelLayout, @NotNull ISlidingUpPanelViewModel iSlidingUpPanelViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkParameterIsNotNull(slidingUpPanelLayout, "$this$setup");
        Intrinsics.checkParameterIsNotNull(iSlidingUpPanelViewModel, "panelViewModel");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "lifecycleOwner");
        ((FrameLayout) slidingUpPanelLayout.findViewById(R.id.flPanelFadeLayout)).setOnClickListener(new a(iSlidingUpPanelViewModel));
        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener(iSlidingUpPanelViewModel) { // from class: ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingUpPanelViewKt$setup$2
            public final /* synthetic */ ISlidingUpPanelViewModel a;

            {
                this.a = r1;
            }

            @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
            public void onPanelSlide(@Nullable View view, float f) {
            }

            @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
            public void onPanelStateChanged(@Nullable View view, @Nullable SlidingUpPanelLayout.PanelState panelState, @Nullable SlidingUpPanelLayout.PanelState panelState2) {
                if (panelState2 != null) {
                    this.a.setPanelState(panelState2);
                }
            }
        });
        AppCompatActivity appCompatActivity = (AppCompatActivity) slidingUpPanelLayout.getContext();
        if (appCompatActivity != null && (onBackPressedDispatcher = appCompatActivity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, new OnBackPressedCallback(slidingUpPanelLayout, iSlidingUpPanelViewModel, appCompatActivity, true) { // from class: ru.sravni.android.bankproduct.utils.components.slidinglayout.SlidingUpPanelViewKt$setup$3
                public final /* synthetic */ SlidingUpPanelLayout c;
                public final /* synthetic */ ISlidingUpPanelViewModel d;
                public final /* synthetic */ AppCompatActivity e;

                {
                    this.c = r1;
                    this.d = r2;
                    this.e = r3;
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    setEnabled(false);
                    if (this.c.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED) {
                        this.d.closePanel();
                    } else {
                        this.e.onBackPressed();
                    }
                }
            });
        }
    }
}
