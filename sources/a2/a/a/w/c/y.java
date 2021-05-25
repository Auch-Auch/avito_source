package a2.a.a.w.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.util.ViewGroupsKt;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class y extends LinearLayoutManager {
    public RecyclerView.Recycler I;
    public int J = Integer.MIN_VALUE;
    @Nullable
    public final RecyclerView.LayoutManager K;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(@NotNull Context context, @Nullable RecyclerView.LayoutManager layoutManager) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.K = layoutManager;
    }

    public final void P(View view) {
        Iterator<View> children;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.dispatchOnPreDraw();
        viewTreeObserver.dispatchOnDraw();
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null && (children = ViewGroupsKt.getChildren(viewGroup)) != null) {
            while (children.hasNext()) {
                P(children.next());
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams generateDefaultLayoutParams;
        RecyclerView.LayoutManager layoutManager = this.K;
        if (layoutManager != null && (generateDefaultLayoutParams = layoutManager.generateDefaultLayoutParams()) != null) {
            return generateDefaultLayoutParams;
        }
        RecyclerView.LayoutParams generateDefaultLayoutParams2 = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNullExpressionValue(generateDefaultLayoutParams2, "super.generateDefaultLayoutParams()");
        return generateDefaultLayoutParams2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        RecyclerView.LayoutParams generateLayoutParams;
        RecyclerView.LayoutManager layoutManager = this.K;
        if (layoutManager != null && (generateLayoutParams = layoutManager.generateLayoutParams(layoutParams)) != null) {
            return generateLayoutParams;
        }
        RecyclerView.LayoutParams generateLayoutParams2 = super.generateLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams2, "super.generateLayoutParams(lp)");
        return generateLayoutParams2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedMeasuredWidth(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void layoutDecoratedWithMargins(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        P(view);
        RecyclerView.Recycler recycler = this.I;
        if (recycler != null) {
            removeAndRecycleView(view, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
        super.measureChildWithMargins(view, i, i2);
        this.J = Math.max(this.J, view.getMeasuredHeight());
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@Nullable RecyclerView.Recycler recycler, @Nullable RecyclerView.State state) {
        this.I = recycler;
        super.onLayoutChildren(recycler, state);
        this.I = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateLayoutParams(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        RecyclerView.LayoutParams generateLayoutParams;
        RecyclerView.LayoutManager layoutManager = this.K;
        if (layoutManager != null && (generateLayoutParams = layoutManager.generateLayoutParams(context, attributeSet)) != null) {
            return generateLayoutParams;
        }
        RecyclerView.LayoutParams generateLayoutParams2 = super.generateLayoutParams(context, attributeSet);
        Intrinsics.checkNotNullExpressionValue(generateLayoutParams2, "super.generateLayoutParams(c, attrs)");
        return generateLayoutParams2;
    }
}
