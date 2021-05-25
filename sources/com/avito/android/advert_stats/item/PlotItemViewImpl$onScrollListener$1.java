package com.avito.android.advert_stats.item;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/avito/android/advert_stats/item/PlotItemViewImpl$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "dx", "dy", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class PlotItemViewImpl$onScrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ PlotItemViewImpl a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PlotItemViewImpl$onScrollListener$1(PlotItemViewImpl plotItemViewImpl) {
        this.a = plotItemViewImpl;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a.C = i;
        boolean z = this.a.v.findFirstCompletelyVisibleItemPosition() == 0 || this.a.v.findFirstCompletelyVisibleItemPosition() == this.a.v.getItemCount() - 1;
        if (i == 0) {
            if (!(this.a.B) && (function1 = this.a.x) != null) {
                Unit unit = (Unit) function1.invoke(Boolean.TRUE);
            }
            PlotItemViewImpl plotItemViewImpl = this.a;
            PlotItemViewImpl.access$notifyWeekSelected(plotItemViewImpl, PlotItemViewImpl.access$findNextIndex(plotItemViewImpl));
            this.a.B = true;
            this.a.z = 0;
        } else if (i == 1) {
            if (!z || !(this.a.B)) {
                Function1 function12 = this.a.x;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke(Boolean.FALSE);
                }
                this.a.D = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        this.a.z = i;
        View findViewByPosition = this.a.v.findViewByPosition(this.a.v.findFirstVisibleItemPosition());
        if (findViewByPosition != null) {
            Intrinsics.checkNotNullExpressionValue(findViewByPosition, "layoutManager.findViewBy…tion(weekIndex) ?: return");
            int left = findViewByPosition.getLeft();
            boolean z = left != this.a.A && this.a.A >= 0;
            if (z && this.a.C == 1) {
                Function1 function1 = this.a.x;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Boolean.FALSE);
                }
                this.a.D = false;
            }
            this.a.A = left;
            this.a.B = !z;
        }
    }
}
