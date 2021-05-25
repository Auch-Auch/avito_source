package com.avito.android.lib.design.chips;

import a2.b.a.a.a;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/chips/MultilineLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateDefaultLayoutParams", "()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "isAutoMeasureEnabled", "()Z", "", "t", "I", "verticalMargin", "u", "Ljava/lang/Integer;", "lineCountLimit", "s", "horizontalMargin", "<init>", "(IILjava/lang/Integer;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class MultilineLayoutManager extends RecyclerView.LayoutManager {
    public final int s;
    public final int t;
    public final Integer u;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultilineLayoutManager(int i, int i2, Integer num, int i3, j jVar) {
        this(i, i2, (i3 & 4) != 0 ? null : num);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        int height = getHeightMode() == 1073741824 ? getHeight() : Integer.MAX_VALUE;
        int width = getWidthMode() == 1073741824 ? getWidth() : Integer.MAX_VALUE;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            removeAllViews();
            return;
        }
        int i = 0;
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        while (z && i3 < itemCount) {
            View viewForPosition = recycler.getViewForPosition(i3);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(pos)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, i, i);
            if (getPaddingRight() + viewForPosition.getMeasuredWidth() + paddingLeft > width) {
                paddingLeft = getPaddingLeft();
                paddingTop = a.c2(this.t, 2, viewForPosition.getMeasuredHeight(), paddingTop);
                i2++;
            }
            layoutDecorated(viewForPosition, paddingLeft, paddingTop, viewForPosition.getMeasuredWidth() + paddingLeft, viewForPosition.getMeasuredHeight() + paddingTop);
            paddingLeft = a.c2(this.s, 2, viewForPosition.getMeasuredWidth(), paddingLeft);
            Integer num = this.u;
            boolean z2 = num == null || i2 < num.intValue();
            if (!z2) {
                removeView(viewForPosition);
            }
            z = paddingTop <= height && z2;
            i3++;
            i2 = i2;
            paddingTop = paddingTop;
            i = 0;
        }
    }

    public MultilineLayoutManager(int i, int i2, @Nullable Integer num) {
        this.s = i;
        this.t = i2;
        this.u = num;
    }
}
