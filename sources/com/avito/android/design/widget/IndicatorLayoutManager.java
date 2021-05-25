package com.avito.android.design.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004R\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/avito/android/design/widget/IndicatorLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "dx", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "scrollHorizontallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I", "Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;", "I", "Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;", "getPageListener", "()Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;", "setPageListener", "(Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;)V", "pageListener", "J", "mostVisiblePage", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "OnPageChangeListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class IndicatorLayoutManager extends LinearLayoutManager {
    @Nullable
    public OnPageChangeListener I;
    public int J = -1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/design/widget/IndicatorLayoutManager$OnPageChangeListener;", "", "", "newMostVisiblePos", "", "onPageChanged", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnPageChangeListener {
        void onPageChanged(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndicatorLayoutManager(@NotNull Context context) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final OnPageChangeListener getPageListener() {
        return this.I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            findFirstVisibleItemPosition = -1;
        } else if (Math.abs(getDecoratedLeft(findViewByPosition)) > Math.abs(getDecoratedRight(findViewByPosition)) / 2) {
            findFirstVisibleItemPosition++;
        }
        if (!(findFirstVisibleItemPosition == this.J || findFirstVisibleItemPosition == -1)) {
            this.J = findFirstVisibleItemPosition;
            OnPageChangeListener onPageChangeListener = this.I;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageChanged(findFirstVisibleItemPosition);
            }
        }
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public final void setPageListener(@Nullable OnPageChangeListener onPageChangeListener) {
        this.I = onPageChangeListener;
    }
}
