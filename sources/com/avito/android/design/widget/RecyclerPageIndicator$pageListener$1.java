package com.avito.android.design.widget;

import com.avito.android.design.widget.IndicatorLayoutManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/design/widget/RecyclerPageIndicator$pageListener$1", "Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;", "", "newMostVisiblePos", "", "onPageChanged", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerPageIndicator$pageListener$1 implements IndicatorLayoutManager.OnPageChangeListener {
    public final /* synthetic */ RecyclerPageIndicator a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public RecyclerPageIndicator$pageListener$1(RecyclerPageIndicator recyclerPageIndicator) {
        this.a = recyclerPageIndicator;
    }

    @Override // com.avito.android.design.widget.IndicatorLayoutManager.OnPageChangeListener
    public void onPageChanged(int i) {
        if (i <= RecyclerPageIndicator.access$getItemCount$p(this.a) && i >= 0) {
            RecyclerPageIndicator.access$selectCurrentItem(this.a, i);
        }
    }
}
