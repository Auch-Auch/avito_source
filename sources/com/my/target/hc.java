package com.my.target;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
public class hc extends LinearSnapHelper {
    @NonNull
    public final DecelerateInterpolator f;
    public int g;
    public float h = 60.0f;
    public int i = -1;
    public float j = -1.0f;
    @Nullable
    public OrientationHelper k;
    @Nullable
    public OrientationHelper l;
    @Nullable
    public RecyclerView m;

    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return hc.this.h / ((float) displayMetrics.densityDpi);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int i) {
            return (int) Math.ceil(((double) calculateTimeForScrolling(i)) / 0.3d);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            RecyclerView recyclerView = hc.this.m;
            if (recyclerView != null && recyclerView.getLayoutManager() != null) {
                hc hcVar = hc.this;
                int[] calculateDistanceToFinalSnap = hcVar.calculateDistanceToFinalSnap(hcVar.m.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, hc.this.f);
                }
            }
        }
    }

    public hc(int i2) {
        this.g = i2;
        this.f = new DecelerateInterpolator(1.7f);
    }

    public void a(int i2, Boolean bool) {
        RecyclerView.LayoutManager layoutManager;
        View h2;
        if (this.g != i2) {
            this.g = i2;
            RecyclerView recyclerView = this.m;
            if (recyclerView != null && recyclerView.getLayoutManager() != null && (h2 = h((layoutManager = this.m.getLayoutManager()), false)) != null) {
                int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, h2);
                if (bool.booleanValue()) {
                    this.m.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                } else {
                    this.m.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            this.m = recyclerView;
        } else {
            this.m = null;
        }
        try {
            super.attachToRecyclerView(recyclerView);
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int i2 = this.g;
        if (i2 == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        OrientationHelper i3 = i((LinearLayoutManager) layoutManager);
        if (i2 == 8388611) {
            int decoratedStart = i3.getDecoratedStart(view);
            if (decoratedStart >= i3.getStartAfterPadding() / 2) {
                decoratedStart -= i3.getStartAfterPadding();
            }
            iArr[0] = decoratedStart;
        } else {
            int decoratedEnd = i3.getDecoratedEnd(view);
            iArr[0] = decoratedEnd >= i3.getEnd() - ((i3.getEnd() - i3.getEndAfterPadding()) / 2) ? i3.getDecoratedEnd(view) - i3.getEnd() : decoratedEnd - i3.getEndAfterPadding();
        }
        return iArr;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006b: APUT  
      (r0v4 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x0067: INVOKE  (r15v1 int) = (r12v0 android.widget.Scroller) type: VIRTUAL call: android.widget.Scroller.getFinalX():int)
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r1 != -1) goto L_0x005a;
     */
    @Override // androidx.recyclerview.widget.SnapHelper
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] calculateScrollDistance(int r14, int r15) {
        /*
            r13 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r13.m
            if (r0 == 0) goto L_0x0075
            androidx.recyclerview.widget.OrientationHelper r0 = r13.k
            if (r0 != 0) goto L_0x000c
            androidx.recyclerview.widget.OrientationHelper r0 = r13.l
            if (r0 == 0) goto L_0x0075
        L_0x000c:
            int r0 = r13.i
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1
            if (r0 != r2) goto L_0x001a
            float r0 = r13.j
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x001a
            goto L_0x0075
        L_0x001a:
            r0 = 2
            int[] r0 = new int[r0]
            android.widget.Scroller r12 = new android.widget.Scroller
            androidx.recyclerview.widget.RecyclerView r3 = r13.m
            android.content.Context r3 = r3.getContext()
            android.view.animation.DecelerateInterpolator r4 = new android.view.animation.DecelerateInterpolator
            r4.<init>()
            r12.<init>(r3, r4)
            androidx.recyclerview.widget.RecyclerView r3 = r13.m
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 != 0) goto L_0x0038
        L_0x0034:
            r11 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x005b
        L_0x0038:
            float r5 = r13.j
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            androidx.recyclerview.widget.OrientationHelper r1 = r13.k
            if (r1 == 0) goto L_0x0047
            int r1 = r3.getHeight()
            goto L_0x004f
        L_0x0047:
            androidx.recyclerview.widget.OrientationHelper r1 = r13.l
            if (r1 == 0) goto L_0x0034
            int r1 = r3.getWidth()
        L_0x004f:
            float r1 = (float) r1
            float r2 = r13.j
            float r1 = r1 * r2
            int r1 = (int) r1
            goto L_0x005a
        L_0x0056:
            int r1 = r13.i
            if (r1 == r2) goto L_0x0034
        L_0x005a:
            r11 = r1
        L_0x005b:
            r4 = 0
            r5 = 0
            int r10 = -r11
            r3 = r12
            r6 = r14
            r7 = r15
            r8 = r10
            r9 = r11
            r3.fling(r4, r5, r6, r7, r8, r9, r10, r11)
            r14 = 0
            int r15 = r12.getFinalX()
            r0[r14] = r15
            r14 = 1
            int r15 = r12.getFinalY()
            r0[r14] = r15
            return r0
        L_0x0075:
            int[] r14 = super.calculateScrollDistance(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hc.calculateScrollDistance(int, int):int[]");
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.m) == null) {
            return null;
        }
        return new a(recyclerView.getContext());
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NonNull RecyclerView.LayoutManager layoutManager) {
        return h(layoutManager, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r10 = true;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View g(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.LayoutManager r7, @androidx.annotation.NonNull androidx.recyclerview.widget.OrientationHelper r8, int r9, boolean r10) {
        /*
            r6 = this;
            int r0 = r7.getChildCount()
            r1 = 0
            if (r0 == 0) goto L_0x00be
            boolean r0 = r7 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 != 0) goto L_0x000d
            goto L_0x00be
        L_0x000d:
            r0 = r7
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            r2 = 8388611(0x800003, float:1.1754948E-38)
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0077
            boolean r10 = r0.getReverseLayout()
            if (r10 != 0) goto L_0x0021
            int r10 = r6.g
            if (r10 == r2) goto L_0x0046
        L_0x0021:
            boolean r10 = r0.getReverseLayout()
            if (r10 == 0) goto L_0x002e
            int r10 = r6.g
            r5 = 8388613(0x800005, float:1.175495E-38)
            if (r10 == r5) goto L_0x0046
        L_0x002e:
            boolean r10 = r0.getReverseLayout()
            if (r10 != 0) goto L_0x003a
            int r10 = r6.g
            r5 = 48
            if (r10 == r5) goto L_0x0046
        L_0x003a:
            boolean r10 = r0.getReverseLayout()
            if (r10 == 0) goto L_0x0055
            int r10 = r6.g
            r5 = 80
            if (r10 != r5) goto L_0x0055
        L_0x0046:
            int r10 = r0.findLastCompletelyVisibleItemPosition()
            int r5 = r0.getItemCount()
            int r5 = r5 - r4
            if (r10 != r5) goto L_0x0053
        L_0x0051:
            r10 = 1
            goto L_0x0074
        L_0x0053:
            r10 = 0
            goto L_0x0074
        L_0x0055:
            int r10 = r6.g
            r5 = 17
            if (r10 != r5) goto L_0x006d
            int r10 = r0.findFirstCompletelyVisibleItemPosition()
            if (r10 == 0) goto L_0x0051
            int r10 = r0.findLastCompletelyVisibleItemPosition()
            int r5 = r0.getItemCount()
            int r5 = r5 - r4
            if (r10 != r5) goto L_0x0053
            goto L_0x0051
        L_0x006d:
            int r10 = r0.findFirstCompletelyVisibleItemPosition()
            if (r10 != 0) goto L_0x0053
            goto L_0x0051
        L_0x0074:
            if (r10 == 0) goto L_0x0077
            return r1
        L_0x0077:
            r10 = 2147483647(0x7fffffff, float:NaN)
            boolean r7 = r7.getClipToPadding()
            if (r7 == 0) goto L_0x008c
            int r7 = r8.getStartAfterPadding()
            int r5 = r8.getTotalSpace()
            int r5 = r5 / 2
            int r5 = r5 + r7
            goto L_0x0092
        L_0x008c:
            int r7 = r8.getEnd()
            int r5 = r7 / 2
        L_0x0092:
            if (r9 != r2) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r4 = 0
        L_0x0096:
            int r7 = r0.getChildCount()
            if (r3 >= r7) goto L_0x00be
            android.view.View r7 = r0.getChildAt(r3)
            int r9 = r8.getDecoratedStart(r7)
            if (r4 == 0) goto L_0x00ab
            int r9 = java.lang.Math.abs(r9)
            goto L_0x00b7
        L_0x00ab:
            int r2 = r8.getDecoratedMeasurement(r7)
            int r2 = r2 / 2
            int r2 = r2 + r9
            int r2 = r2 - r5
            int r9 = java.lang.Math.abs(r2)
        L_0x00b7:
            if (r9 >= r10) goto L_0x00bb
            r1 = r7
            r10 = r9
        L_0x00bb:
            int r3 = r3 + 1
            goto L_0x0096
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hc.g(androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.OrientationHelper, int, boolean):android.view.View");
    }

    @Nullable
    public final View h(@NonNull RecyclerView.LayoutManager layoutManager, boolean z) {
        OrientationHelper orientationHelper;
        OrientationHelper orientationHelper2;
        int i2 = this.g;
        if (i2 == 17) {
            return g(layoutManager, i(layoutManager), 17, z);
        }
        if (i2 != 48) {
            if (i2 == 80) {
                OrientationHelper orientationHelper3 = this.k;
                if (orientationHelper3 == null || orientationHelper3.getLayoutManager() != layoutManager) {
                    this.k = OrientationHelper.createVerticalHelper(layoutManager);
                }
                orientationHelper2 = this.k;
            } else if (i2 == 8388611) {
                orientationHelper = i(layoutManager);
            } else if (i2 != 8388613) {
                return null;
            } else {
                orientationHelper2 = i(layoutManager);
            }
            return g(layoutManager, orientationHelper2, GravityCompat.END, z);
        }
        OrientationHelper orientationHelper4 = this.k;
        if (orientationHelper4 == null || orientationHelper4.getLayoutManager() != layoutManager) {
            this.k = OrientationHelper.createVerticalHelper(layoutManager);
        }
        orientationHelper = this.k;
        return g(layoutManager, orientationHelper, GravityCompat.START, z);
    }

    public final OrientationHelper i(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.l;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.l = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.l;
    }

    public void setGravity(int i2) {
        a(i2, Boolean.TRUE);
    }

    public void smoothScrollToPosition(int i2) {
        RecyclerView recyclerView;
        RecyclerView.SmoothScroller createScroller;
        if (i2 != -1 && (recyclerView = this.m) != null && recyclerView.getLayoutManager() != null && (createScroller = createScroller(this.m.getLayoutManager())) != null) {
            createScroller.setTargetPosition(i2);
            this.m.getLayoutManager().startSmoothScroll(createScroller);
        }
    }
}
