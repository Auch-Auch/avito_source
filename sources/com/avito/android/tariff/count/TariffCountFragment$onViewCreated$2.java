package com.avito.android.tariff.count;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/avito/android/tariff/count/TariffCountFragment$onViewCreated$2", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", VKApiConst.POSITION, "", "smoothScrollToPosition", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountFragment$onViewCreated$2 extends LinearLayoutManager {
    public final /* synthetic */ TariffCountFragment I;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TariffCountFragment$onViewCreated$2(TariffCountFragment tariffCountFragment, Context context) {
        super(context);
        this.I = tariffCountFragment;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@Nullable RecyclerView recyclerView, @Nullable RecyclerView.State state, int i) {
        TariffCountFragment$onViewCreated$2$smoothScrollToPosition$smoothScroller$1 tariffCountFragment$onViewCreated$2$smoothScrollToPosition$smoothScroller$1 = new LinearSmoothScroller(this, this.I.requireContext()) { // from class: com.avito.android.tariff.count.TariffCountFragment$onViewCreated$2$smoothScrollToPosition$smoothScroller$1
            public final /* synthetic */ TariffCountFragment$onViewCreated$2 l;

            {
                this.l = r1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
                return super.calculateDtToFit(i2, i3, i4, i5 - this.l.I.i, i6);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
                Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
        tariffCountFragment$onViewCreated$2$smoothScrollToPosition$smoothScroller$1.setTargetPosition(i);
        startSmoothScroll(tariffCountFragment$onViewCreated$2$smoothScrollToPosition$smoothScroller$1);
    }
}
