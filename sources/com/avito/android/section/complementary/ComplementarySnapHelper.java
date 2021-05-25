package com.avito.android.section.complementary;

import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.section.SectionSnapHelper;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/section/complementary/ComplementarySnapHelper;", "Lcom/avito/android/section/SectionSnapHelper;", "Landroidx/recyclerview/widget/OrientationHelper;", "helper", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "visibleWidthFromStart", "(Landroidx/recyclerview/widget/OrientationHelper;Landroid/view/View;Landroidx/recyclerview/widget/LinearLayoutManager;)F", "", "findChildAtStartGravity", "(Landroidx/recyclerview/widget/LinearLayoutManager;Landroidx/recyclerview/widget/OrientationHelper;)I", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "", "calculateDistanceToFinalSnap", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Landroid/view/View;)[I", "k", "I", "leftDecoration", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ComplementarySnapHelper extends SectionSnapHelper {
    public final int k;

    public ComplementarySnapHelper(int i) {
        super(GravityCompat.START, 0, 2, null);
        this.k = i;
    }

    @Override // com.avito.android.section.GravitySnapHelper, androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View view) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(view, "targetView");
        int[] calculateDistanceToFinalSnap = super.calculateDistanceToFinalSnap(layoutManager, view);
        int leftDecorationWidth = layoutManager.getLeftDecorationWidth(view);
        int i = this.k;
        if (leftDecorationWidth >= i) {
            calculateDistanceToFinalSnap[0] = calculateDistanceToFinalSnap[0] + i;
        }
        return calculateDistanceToFinalSnap;
    }

    @Override // com.avito.android.section.GravitySnapHelper
    public int findChildAtStartGravity(@NotNull LinearLayoutManager linearLayoutManager, @NotNull OrientationHelper orientationHelper) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(orientationHelper, "helper");
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        return (findFirstVisibleItemPosition != -1 && orientationHelper.getDecoratedEnd(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition)) <= this.k) ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : findFirstVisibleItemPosition;
    }

    @Override // com.avito.android.section.GravitySnapHelper
    public float visibleWidthFromStart(@NotNull OrientationHelper orientationHelper, @Nullable View view, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(orientationHelper, "helper");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        float f = 0.0f;
        if (view == null) {
            return 0.0f;
        }
        int leftDecorationWidth = linearLayoutManager.getLeftDecorationWidth(view);
        int decoratedEnd = orientationHelper.getDecoratedEnd(view) - (leftDecorationWidth == 0 ? this.k : 0);
        int startAfterPadding = orientationHelper.getStartAfterPadding();
        float decoratedMeasurement = (float) orientationHelper.getDecoratedMeasurement(view);
        float f2 = (((float) decoratedEnd) - ((float) startAfterPadding)) / decoratedMeasurement;
        float f3 = ((float) leftDecorationWidth) / decoratedMeasurement;
        if (f2 >= 1.0f) {
            return f2;
        }
        if (f3 > 0.0f) {
            f = (-f3) / ((float) 2);
        }
        return f2 + f;
    }
}
