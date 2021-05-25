package com.avito.android.tariff.count;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/avito/android/tariff/count/TariffCountFragment$onViewCreated$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "(II)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountFragment$onViewCreated$3 extends RecyclerView.AdapterDataObserver {
    public final /* synthetic */ TariffCountFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ TariffCountFragment$onViewCreated$3 a;
        public final /* synthetic */ int b;

        public a(TariffCountFragment$onViewCreated$3 tariffCountFragment$onViewCreated$3, int i) {
            this.a = tariffCountFragment$onViewCreated$3;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.b().smoothScrollToPosition(this.b);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public TariffCountFragment$onViewCreated$3(TariffCountFragment tariffCountFragment) {
        this.a = tariffCountFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.a.b().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int i3 = i - 1;
            boolean z = i >= findLastCompletelyVisibleItemPosition || i3 <= findFirstCompletelyVisibleItemPosition;
            if (i < findLastCompletelyVisibleItemPosition) {
                i = i3;
            }
            if (z && i >= 0 && i2 == 1) {
                this.a.b().post(new a(this, i));
            }
        }
    }
}
