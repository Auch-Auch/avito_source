package com.avito.android.section;

import a2.g.r.g;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\b\b\u0002\u0010(\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/section/GravitySnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/OrientationHelper;", "f", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Landroidx/recyclerview/widget/OrientationHelper;", "e", "Landroid/view/View;", "targetView", "", "calculateDistanceToFinalSnap", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Landroid/view/View;)[I", "findSnapView", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Landroid/view/View;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "helper", "", "findChildAtStartGravity", "(Landroidx/recyclerview/widget/LinearLayoutManager;Landroidx/recyclerview/widget/OrientationHelper;)I", VKApiUserFull.RelativeType.CHILD, "", "visibleWidthFromStart", "(Landroidx/recyclerview/widget/OrientationHelper;Landroid/view/View;Landroidx/recyclerview/widget/LinearLayoutManager;)F", "", "isStart", g.a, "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Landroidx/recyclerview/widget/OrientationHelper;Z)Landroid/view/View;", "Landroidx/recyclerview/widget/OrientationHelper;", "horizontalHelper", "verticalHelper", "i", "I", "gravity", "h", "[I", VKApiConst.OUT, "j", "getPadding", "()I", "padding", "<init>", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class GravitySnapHelper extends LinearSnapHelper {
    public OrientationHelper f;
    public OrientationHelper g;
    public final int[] h;
    public final int i;
    public final int j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GravitySnapHelper(int i2, int i3, int i4, j jVar) {
        this(i2, (i4 & 2) != 0 ? 0 : i3);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper
    private final OrientationHelper e(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.g;
        if (orientationHelper == null) {
            orientationHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        this.g = orientationHelper;
        Intrinsics.checkNotNullExpressionValue(orientationHelper, "result");
        return orientationHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper
    private final OrientationHelper f(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f;
        if (orientationHelper == null) {
            orientationHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        this.f = orientationHelper;
        Intrinsics.checkNotNullExpressionValue(orientationHelper, "result");
        return orientationHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(view, "targetView");
        int[] iArr = this.h;
        int i7 = 0;
        if (layoutManager.canScrollHorizontally()) {
            if (this.i == 8388611) {
                OrientationHelper e = e(layoutManager);
                i5 = e.getDecoratedStart(view) - e.getStartAfterPadding();
                i6 = getPadding();
            } else {
                OrientationHelper e2 = e(layoutManager);
                i5 = e2.getDecoratedEnd(view) - e2.getEndAfterPadding();
                i6 = getPadding();
            }
            i2 = i5 - i6;
        } else {
            i2 = 0;
        }
        iArr[0] = i2;
        int[] iArr2 = this.h;
        if (layoutManager.canScrollVertically()) {
            if (this.i == 48) {
                OrientationHelper f2 = f(layoutManager);
                i3 = f2.getDecoratedStart(view) - f2.getStartAfterPadding();
                i4 = getPadding();
            } else {
                OrientationHelper f3 = f(layoutManager);
                i3 = f3.getDecoratedEnd(view) - f3.getEndAfterPadding();
                i4 = getPadding();
            }
            i7 = i3 - i4;
        }
        iArr2[1] = i7;
        return this.h;
    }

    public int findChildAtStartGravity(@NotNull LinearLayoutManager linearLayoutManager, @NotNull OrientationHelper orientationHelper) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(orientationHelper, "helper");
        return linearLayoutManager.findFirstVisibleItemPosition();
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        int i2 = this.i;
        if (i2 == 48) {
            return g(layoutManager, f(layoutManager), true);
        }
        if (i2 == 80) {
            return g(layoutManager, f(layoutManager), false);
        }
        if (i2 == 8388611) {
            return g(layoutManager, e(layoutManager), true);
        }
        if (i2 != 8388613) {
            return null;
        }
        return g(layoutManager, e(layoutManager), false);
    }

    public final View g(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, boolean z) {
        float f2;
        View view;
        View view2;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        boolean z2 = false;
        if (z) {
            int findChildAtStartGravity = findChildAtStartGravity((LinearLayoutManager) layoutManager, orientationHelper);
            if (findChildAtStartGravity == -1) {
                return null;
            }
            view2 = layoutManager.findViewByPosition(findChildAtStartGravity);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            f2 = visibleWidthFromStart(orientationHelper, view2, linearLayoutManager);
            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
                z2 = true;
            }
            view = layoutManager.findViewByPosition(findChildAtStartGravity + 1);
        } else {
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            if (findLastVisibleItemPosition == -1) {
                return null;
            }
            view2 = layoutManager.findViewByPosition(findLastVisibleItemPosition);
            f2 = ((float) (orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(view2))) / ((float) orientationHelper.getDecoratedMeasurement(view2));
            if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                z2 = true;
            }
            view = layoutManager.findViewByPosition(findLastVisibleItemPosition - 1);
        }
        if (f2 > 0.5f && !z2) {
            return view2;
        }
        if (z2) {
            return null;
        }
        return view;
    }

    public int getPadding() {
        return this.j;
    }

    public float visibleWidthFromStart(@NotNull OrientationHelper orientationHelper, @Nullable View view, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(orientationHelper, "helper");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        return (((float) orientationHelper.getDecoratedEnd(view)) - ((float) getPadding())) / ((float) orientationHelper.getDecoratedMeasurement(view));
    }

    public GravitySnapHelper(int i2, int i3) {
        this.i = i2;
        this.j = i3;
        this.h = new int[2];
        if (i2 != 8388611 && i2 != 8388613 && i2 != 80 && i2 != 48) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
        }
    }
}
