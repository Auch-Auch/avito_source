package com.avito.android.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/avito/android/ui/widget/ScrollDirectionAwareRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "slopConstant", "", "setScrollingTouchSlop", "(I)V", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", "H0", "I", "touchSlop", "G0", "initialTouchY", "E0", "scrollPointerId", "F0", "initialTouchX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ScrollDirectionAwareRecyclerView extends RecyclerView {
    public int E0;
    public int F0;
    public int G0;
    public int H0;

    @JvmOverloads
    public ScrollDirectionAwareRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ScrollDirectionAwareRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollDirectionAwareRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.E0 = motionEvent.getPointerId(0);
            this.F0 = (int) (motionEvent.getX() + 0.5f);
            this.G0 = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.E0);
            if (findPointerIndex < 0) {
                return false;
            }
            int x = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (getScrollState() == 1) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int i = x - this.F0;
            int i2 = y - this.G0;
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            boolean canScrollHorizontally = layoutManager != null ? layoutManager.canScrollHorizontally() : false;
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            boolean canScrollVertically = layoutManager2 != null ? layoutManager2.canScrollVertically() : false;
            boolean z = canScrollHorizontally && Math.abs(i) > this.H0 && (Math.abs(i) >= Math.abs(i2) || canScrollVertically);
            if (canScrollVertically && Math.abs(i2) > this.H0 && (Math.abs(i2) >= Math.abs(i) || canScrollHorizontally)) {
                z = true;
            }
            if (!z || !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        } else if (actionMasked != 5) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            this.E0 = motionEvent.getPointerId(actionIndex);
            this.F0 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.G0 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i) {
        super.setScrollingTouchSlop(i);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i == 0) {
            Intrinsics.checkNotNullExpressionValue(viewConfiguration, "vc");
            this.H0 = viewConfiguration.getScaledTouchSlop();
        } else if (i == 1) {
            this.H0 = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScrollDirectionAwareRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.E0 = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "vc");
        this.H0 = viewConfiguration.getScaledTouchSlop();
    }
}
