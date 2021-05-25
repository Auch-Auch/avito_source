package com.avito.android.advert_stats.item;

import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_stats/item/StatSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "", "velocityX", "velocityY", "findTargetSnapPosition", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;II)I", "Lcom/avito/android/advert_stats/item/SnappingListener;", "f", "Lcom/avito/android/advert_stats/item/SnappingListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/advert_stats/item/SnappingListener;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatSnapHelper extends PagerSnapHelper {
    public final SnappingListener f;

    public StatSnapHelper(@NotNull SnappingListener snappingListener) {
        Intrinsics.checkNotNullParameter(snappingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f = snappingListener;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
        this.f.onTargetPositionFound(findTargetSnapPosition);
        return findTargetSnapPosition;
    }
}
