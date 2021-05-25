package com.avito.android.hints;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/avito/android/hints/HintsDialogFragment$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "hints_release"}, k = 1, mv = {1, 4, 2})
public final class HintsDialogFragment$scrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ HintsDialogFragment a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public HintsDialogFragment$scrollListener$1(HintsDialogFragment hintsDialogFragment) {
        this.a = hintsDialogFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        int findFirstCompletelyVisibleItemPosition;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.a.l == -1) {
            HintsDialogFragment hintsDialogFragment = this.a;
            hintsDialogFragment.l = HintsDialogFragment.access$getLayoutManager$p(hintsDialogFragment).findFirstCompletelyVisibleItemPosition();
        }
        if (i == 0 && (findFirstCompletelyVisibleItemPosition = HintsDialogFragment.access$getLayoutManager$p(this.a).findFirstCompletelyVisibleItemPosition()) != -1) {
            this.a.k[0] = -1;
            this.a.k[1] = -1;
            if (findFirstCompletelyVisibleItemPosition == this.a.l) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.requestLayout();
                    return;
                }
                return;
            }
            this.a.l = findFirstCompletelyVisibleItemPosition;
            this.a.m = true;
            HintsDialogFragment.access$getNestedScrollView$p(this.a).scrollTo(0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int findLastVisibleItemPosition = HintsDialogFragment.access$getLayoutManager$p(this.a).findLastVisibleItemPosition();
        int findFirstVisibleItemPosition = HintsDialogFragment.access$getLayoutManager$p(this.a).findFirstVisibleItemPosition();
        if (findLastVisibleItemPosition != findFirstVisibleItemPosition) {
            if (findFirstVisibleItemPosition != ArraysKt___ArraysKt.first(this.a.k) || findLastVisibleItemPosition != ArraysKt___ArraysKt.last(this.a.k)) {
                this.a.k[0] = findFirstVisibleItemPosition;
                this.a.k[1] = findLastVisibleItemPosition;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.requestLayout();
                }
            }
        }
    }
}
