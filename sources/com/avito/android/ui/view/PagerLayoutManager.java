package com.avito.android.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002-.B\u0019\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0007R\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\b\u001a\u00060\u0007R\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0012R$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0018¨\u0006/"}, d2 = {"Lcom/avito/android/ui/view/PagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "view", "", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "recycler", "onDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$Recycler;)V", "", "dx", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "scrollHorizontallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I", "onScrollStateChanged", "(I)V", "pos", "Q", "P", "()I", "J", "I", "flingThreshold", "L", "mostVisiblePage", "M", "getPadding", "setPadding", "padding", "Lcom/avito/android/ui/view/PagerLayoutManager$OnPageScrollListener;", "Lcom/avito/android/ui/view/PagerLayoutManager$OnPageScrollListener;", "getPageListener", "()Lcom/avito/android/ui/view/PagerLayoutManager$OnPageScrollListener;", "setPageListener", "(Lcom/avito/android/ui/view/PagerLayoutManager$OnPageScrollListener;)V", "pageListener", "K", "scrollState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "OnPageScrollListener", AuthSource.SEND_ABUSE, "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PagerLayoutManager extends LinearLayoutManager {
    @Nullable
    public OnPageScrollListener I;
    public final int J;
    public int K;
    public int L;
    public int M;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/ui/view/PagerLayoutManager$OnPageScrollListener;", "", "", "newMostVisiblePos", "", "onPageChanged", "(I)V", "pagePosition", "onPageScrollFinished", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface OnPageScrollListener {
        void onPageChanged(int i);

        void onPageScrollFinished(int i);
    }

    public static final class a extends RecyclerView.SmoothScroller {
        public final Interpolator i = animation.InterpolatorC0163a.a;
        public final int j;

        /* renamed from: com.avito.android.ui.view.PagerLayoutManager$a$a  reason: collision with other inner class name */
        public static final class animation.InterpolatorC0163a implements Interpolator {
            public static final animation.InterpolatorC0163a a = new animation.InterpolatorC0163a();

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public a(int i2, int i3) {
            this.j = i3;
            setTargetPosition(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onSeekTargetStep(int i2, int i3, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStart() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(@NotNull View view, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
            Intrinsics.checkNotNullParameter(view, "targetView");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            int decoratedLeft = layoutManager != null ? layoutManager.getDecoratedLeft(view) : 0;
            if (decoratedLeft != 0) {
                action.update(decoratedLeft - this.j, 0, 600, this.i);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerLayoutManager(Context context, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    public final int P() {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition != null) {
            return Math.abs(getDecoratedLeft(findViewByPosition)) <= Math.abs(getDecoratedRight(findViewByPosition)) / 2 ? findFirstVisibleItemPosition : findFirstVisibleItemPosition + 1;
        }
        return -1;
    }

    public final void Q(int i) {
        startSmoothScroll(new a(i, this.M));
    }

    public final int getPadding() {
        return this.M;
    }

    @Nullable
    public final OnPageScrollListener getPageListener() {
        return this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "view");
        super.onAttachedToWindow(recyclerView);
        recyclerView.setScrollingTouchSlop(1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(recyclerView, "view");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.setScrollingTouchSlop(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        int P;
        View findViewByPosition;
        this.K = i;
        if (!isSmoothScrolling() && i == 0 && (P = P()) != -1 && (findViewByPosition = findViewByPosition(P)) != null) {
            int decoratedLeft = getDecoratedLeft(findViewByPosition);
            int decoratedRight = getDecoratedRight(findViewByPosition);
            if (P == getItemCount() - 1 && getWidth() != decoratedRight) {
                Q(P);
            } else if (decoratedLeft != this.M) {
                Q(P);
            } else {
                OnPageScrollListener onPageScrollListener = this.I;
                if (onPageScrollListener != null) {
                    onPageScrollListener.onPageScrollFinished(P);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.K == 2 && !isSmoothScrolling()) {
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            if (i > 0) {
                if (i > this.J) {
                    Q(findFirstVisibleItemPosition + 1);
                }
            } else if (i >= 0) {
                int P = P();
                if (P != -1) {
                    Q(P);
                }
            } else if (i < (-this.J)) {
                Q(findFirstVisibleItemPosition);
            }
        }
        int P2 = P();
        if (!(P2 == this.L || P2 == -1)) {
            this.L = P2;
            OnPageScrollListener onPageScrollListener = this.I;
            if (onPageScrollListener != null) {
                onPageScrollListener.onPageChanged(P2);
            }
        }
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public final void setPadding(int i) {
        this.M = i;
    }

    public final void setPageListener(@Nullable OnPageScrollListener onPageScrollListener) {
        this.I = onPageScrollListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(@NotNull Context context, int i) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.M = i;
        this.L = -1;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.J = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
    }
}
