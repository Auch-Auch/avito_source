package com.avito.android.ui.snap_helper;

import a2.g.r.g;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0018J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/ui/snap_helper/PagingSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "", "velocityX", "velocityY", "findTargetSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;II)I", "Landroid/view/View;", "findSnapView", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Landroid/view/View;", "targetView", "", "calculateDistanceToFinalSnap", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Landroid/view/View;)[I", "f", "[I", "distanceToSnap", g.a, "I", "getPadding", "()I", "setPadding", "(I)V", "padding", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class PagingSnapHelper extends LinearSnapHelper {
    public final int[] f;
    public int g;

    public PagingSnapHelper() {
        this(0, 1, null);
    }

    public PagingSnapHelper(int i) {
        this.g = i;
        this.f = new int[2];
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View view) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(view, "targetView");
        this.f[0] = layoutManager.getDecoratedLeft(view) - this.g;
        return this.f;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NotNull RecyclerView.LayoutManager layoutManager) {
        View findViewByPosition;
        int i;
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition == -1) {
            findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        }
        if (findFirstCompletelyVisibleItemPosition == -1 || (findViewByPosition = layoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition)) == null) {
            return null;
        }
        return (Math.abs(layoutManager.getDecoratedRight(findViewByPosition)) >= Math.abs(layoutManager.getDecoratedLeft(findViewByPosition)) || (i = findFirstCompletelyVisibleItemPosition + 1) == ((LinearLayoutManager) layoutManager).getItemCount()) ? findViewByPosition : layoutManager.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@NotNull RecyclerView.LayoutManager layoutManager, int i, int i2) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (!linearLayoutManager.getReverseLayout() ? i >= 0 : i <= 0) {
            findFirstVisibleItemPosition++;
        }
        return Math.min(linearLayoutManager.getItemCount() - 1, Math.max(findFirstVisibleItemPosition, 0));
    }

    public final int getPadding() {
        return this.g;
    }

    public final void setPadding(int i) {
        this.g = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingSnapHelper(int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
