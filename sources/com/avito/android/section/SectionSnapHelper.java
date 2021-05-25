package com.avito.android.section;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/section/SectionSnapHelper;", "Lcom/avito/android/section/GravitySnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "", "velocityX", "velocityY", "findTargetSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;II)I", "Landroidx/recyclerview/widget/LinearLayoutManager;", "findFirstVisiblePosition", "(ILandroidx/recyclerview/widget/LinearLayoutManager;)I", "findLastVisiblePosition", "(Landroidx/recyclerview/widget/LinearLayoutManager;)I", "gravity", "padding", "<init>", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class SectionSnapHelper extends GravitySnapHelper {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionSnapHelper(int i, int i2, int i3, j jVar) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public int findFirstVisiblePosition(int i, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        if (i > 0) {
            return linearLayoutManager.findFirstVisibleItemPosition();
        }
        return linearLayoutManager.findFirstCompletelyVisibleItemPosition();
    }

    public int findLastVisiblePosition(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        return linearLayoutManager.findLastCompletelyVisibleItemPosition();
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@NotNull RecyclerView.LayoutManager layoutManager, int i, int i2) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) (!(layoutManager instanceof LinearLayoutManager) ? null : layoutManager);
        if (linearLayoutManager == null) {
            return findTargetSnapPosition;
        }
        int findFirstVisiblePosition = findFirstVisiblePosition(i, linearLayoutManager);
        int findLastVisiblePosition = findLastVisiblePosition(linearLayoutManager);
        if (!((findFirstVisiblePosition == -1 || findLastVisiblePosition == -1) ? false : true)) {
            return findTargetSnapPosition;
        }
        int max = Math.max(findLastVisiblePosition - findFirstVisiblePosition, 1);
        if (i > 0) {
            return Math.min(findTargetSnapPosition, Math.min(findFirstVisiblePosition + max, ((LinearLayoutManager) layoutManager).getItemCount() - 1));
        }
        return Math.max(findTargetSnapPosition, Math.max(findFirstVisiblePosition - max, 0));
    }

    public SectionSnapHelper(int i, int i2) {
        super(i, i2);
    }
}
