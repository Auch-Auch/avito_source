package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    public ViewDragHelper a;
    public OnDismissListener b;
    public boolean c;
    public float d = 0.0f;
    public boolean e;
    public int f = 2;
    public float g = 0.5f;
    public float h = 0.0f;
    public float i = 0.5f;
    public final ViewDragHelper.Callback j = new a();

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    public class a extends ViewDragHelper.Callback {
        public int a;
        public int b = -1;

        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            int i3;
            int i4;
            int width;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i5 = SwipeDismissBehavior.this.f;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.a - view.getWidth();
                    i4 = view.getWidth() + this.a;
                } else if (z) {
                    i3 = this.a;
                    width = view.getWidth();
                } else {
                    i3 = this.a - view.getWidth();
                    i4 = this.a;
                }
                return Math.min(Math.max(i3, i), i4);
            } else if (z) {
                i3 = this.a - view.getWidth();
                i4 = this.a;
                return Math.min(Math.max(i3, i), i4);
            } else {
                i3 = this.a;
                width = view.getWidth();
            }
            i4 = width + i3;
            return Math.min(Math.max(i3, i), i4);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.b;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.h) + ((float) this.a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.i) + ((float) this.a);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.a) >= java.lang.Math.round(((float) r8.getWidth()) * r7.c.g)) goto L_0x002a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r10 = -1
                r7.b = r10
                int r10 = r8.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x003a
                int r4 = androidx.core.view.ViewCompat.getLayoutDirection(r8)
                if (r4 != r2) goto L_0x0016
                r4 = 1
                goto L_0x0017
            L_0x0016:
                r4 = 0
            L_0x0017:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f
                r6 = 2
                if (r5 != r6) goto L_0x001f
                goto L_0x002a
            L_0x001f:
                if (r5 != 0) goto L_0x002e
                if (r4 == 0) goto L_0x0028
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x002c
                goto L_0x002a
            L_0x0028:
                if (r3 <= 0) goto L_0x002c
            L_0x002a:
                r9 = 1
                goto L_0x0057
            L_0x002c:
                r9 = 0
                goto L_0x0057
            L_0x002e:
                if (r5 != r2) goto L_0x002c
                if (r4 == 0) goto L_0x0035
                if (r3 <= 0) goto L_0x002c
                goto L_0x0039
            L_0x0035:
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x002c
            L_0x0039:
                goto L_0x002a
            L_0x003a:
                int r9 = r8.getLeft()
                int r0 = r7.a
                int r9 = r9 - r0
                int r0 = r8.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.g
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r9 = java.lang.Math.abs(r9)
                if (r9 < r0) goto L_0x002c
                goto L_0x002a
            L_0x0057:
                if (r9 == 0) goto L_0x0066
                int r9 = r8.getLeft()
                int r0 = r7.a
                if (r9 >= r0) goto L_0x0063
                int r0 = r0 - r10
                goto L_0x0064
            L_0x0063:
                int r0 = r0 + r10
            L_0x0064:
                r1 = 1
                goto L_0x0068
            L_0x0066:
                int r0 = r7.a
            L_0x0068:
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r9 = r9.a
                int r10 = r8.getTop()
                boolean r9 = r9.settleCapturedViewAt(r0, r10)
                if (r9 == 0) goto L_0x0081
                com.google.android.material.behavior.SwipeDismissBehavior$b r9 = new com.google.android.material.behavior.SwipeDismissBehavior$b
                com.google.android.material.behavior.SwipeDismissBehavior r10 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r9.<init>(r8, r1)
                androidx.core.view.ViewCompat.postOnAnimation(r8, r9)
                goto L_0x008c
            L_0x0081:
                if (r1 == 0) goto L_0x008c
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r9 = r9.b
                if (r9 == 0) goto L_0x008c
                r9.onDismiss(r8)
            L_0x008c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    }

    public class b implements Runnable {
        public final View a;
        public final boolean b;

        public b(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else if (this.b && (onDismissListener = SwipeDismissBehavior.this.b) != null) {
                onDismissListener.onDismiss(this.a);
            }
        }
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper != null) {
            return viewDragHelper.getViewDragState();
        }
        return 0;
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        return this.b;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        boolean z = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!z) {
            return false;
        }
        if (this.a == null) {
            if (this.e) {
                viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.d, this.j);
            } else {
                viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.j);
            }
            this.a = viewDragHelper;
        }
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
        if (ViewCompat.getImportantForAccessibility(v) == 0) {
            ViewCompat.setImportantForAccessibility(v, 1);
            ViewCompat.removeAccessibilityAction(v, 1048576);
            if (canSwipeDismissView(v)) {
                ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new a2.j.b.d.c.a(this));
            }
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f2) {
        this.g = a(0.0f, f2, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f2) {
        this.i = a(0.0f, f2, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        this.b = onDismissListener;
    }

    public void setSensitivity(float f2) {
        this.d = f2;
        this.e = true;
    }

    public void setStartAlphaSwipeDistance(float f2) {
        this.h = a(0.0f, f2, 1.0f);
    }

    public void setSwipeDirection(int i2) {
        this.f = i2;
    }
}
