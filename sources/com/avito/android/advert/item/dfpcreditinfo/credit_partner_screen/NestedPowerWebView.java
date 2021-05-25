package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import a2.g.r.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.yatatsu.powerwebview.PowerWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:B\u001b\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b9\u0010=J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\rJ9\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010.R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00101¨\u0006>"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/NestedPowerWebView;", "Lcom/yatatsu/powerwebview/PowerWebView;", "Landroidx/core/view/NestedScrollingChild;", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "enabled", "", "setNestedScrollingEnabled", "(Z)V", "isNestedScrollingEnabled", "()Z", "", "axes", "startNestedScroll", "(I)Z", "stopNestedScroll", "()V", "hasNestedScrollingParent", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "offsetInWindow", "dispatchNestedScroll", "(IIII[I)Z", "dx", "dy", "consumed", "dispatchNestedPreScroll", "(II[I[I)Z", "", "velocityX", "velocityY", "dispatchNestedFling", "(FFZ)Z", "dispatchNestedPreFling", "(FF)Z", "Landroidx/core/view/NestedScrollingChildHelper;", "j", "Landroidx/core/view/NestedScrollingChildHelper;", "mChildHelper", "h", "[I", "mScrollConsumed", "i", "I", "mNestedOffsetY", g.a, "mScrollOffset", "k", "mLastY", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class NestedPowerWebView extends PowerWebView implements NestedScrollingChild {
    public final int[] g;
    public final int[] h;
    public int i;
    public final NestedScrollingChildHelper j;
    public int k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedPowerWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.g = new int[2];
        this.h = new int[2];
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.j.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.j.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable int[] iArr) {
        return this.j.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(obtain);
        if (actionMasked == 0) {
            this.i = 0;
        }
        Intrinsics.checkNotNullExpressionValue(obtain, "event");
        int y = (int) obtain.getY();
        obtain.offsetLocation(0.0f, (float) this.i);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.k - y;
                    if (dispatchNestedPreScroll(0, i2, this.h, this.g)) {
                        i2 -= this.h[1];
                        int[] iArr = this.g;
                        this.k = y - iArr[1];
                        obtain.offsetLocation(0.0f, (float) (-iArr[1]));
                        this.i = this.g[1];
                    }
                    boolean onTouchEvent = super.onTouchEvent(obtain);
                    if (!dispatchNestedScroll(0, this.h[1], 0, i2, this.g)) {
                        return onTouchEvent;
                    }
                    obtain.offsetLocation(0.0f, (float) this.g[1]);
                    this.i = this.g[1];
                    this.k -= i2;
                    return onTouchEvent;
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            boolean onTouchEvent2 = super.onTouchEvent(obtain);
            stopNestedScroll();
            return onTouchEvent2;
        }
        boolean onTouchEvent3 = super.onTouchEvent(obtain);
        this.k = y;
        startNestedScroll(2);
        return onTouchEvent3;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.j.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.j.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedPowerWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.g = new int[2];
        this.h = new int[2];
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
}
