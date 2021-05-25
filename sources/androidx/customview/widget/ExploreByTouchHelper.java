package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> o = new a();
    public static final FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> p = new b();
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    public static class a implements FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.graphics.Rect] */
        @Override // androidx.customview.widget.FocusStrategy$BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    }

    public static class b implements FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.valueAt(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    }

    public class c extends AccessibilityNodeProviderCompat {
        public c() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.e(i));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.k : ExploreByTouchHelper.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.e(i2));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            int i3;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (i == -1) {
                return ViewCompat.performAccessibilityAction(exploreByTouchHelper.i, i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return exploreByTouchHelper.requestKeyboardFocusForVirtualView(i);
            }
            if (i2 == 2) {
                return exploreByTouchHelper.clearKeyboardFocusForVirtualView(i);
            }
            if (i2 == 64) {
                if (!exploreByTouchHelper.h.isEnabled() || !exploreByTouchHelper.h.isTouchExplorationEnabled() || (i3 = exploreByTouchHelper.k) == i) {
                    z = false;
                } else {
                    if (i3 != Integer.MIN_VALUE) {
                        exploreByTouchHelper.a(i3);
                    }
                    exploreByTouchHelper.k = i;
                    exploreByTouchHelper.i.invalidate();
                    exploreByTouchHelper.sendEventForVirtualView(i, 32768);
                }
                return z;
            } else if (i2 != 128) {
                return exploreByTouchHelper.onPerformActionForVirtualView(i, i2, bundle);
            } else {
                return exploreByTouchHelper.a(i);
            }
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.i = view;
            this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final boolean a(int i2) {
        if (this.k != i2) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.i.invalidate();
        sendEventForVirtualView(i2, 65536);
        return true;
    }

    public final AccessibilityEvent b(int i2, int i3) {
        if (i2 != -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
            AccessibilityNodeInfoCompat e2 = e(i2);
            obtain.getText().add(e2.getText());
            obtain.setContentDescription(e2.getContentDescription());
            obtain.setScrollable(e2.isScrollable());
            obtain.setPassword(e2.isPassword());
            obtain.setEnabled(e2.isEnabled());
            obtain.setChecked(e2.isChecked());
            onPopulateEventForVirtualView(i2, obtain);
            if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
                obtain.setClassName(e2.getClassName());
                AccessibilityRecordCompat.setSource(obtain, this.i, i2);
                obtain.setPackageName(this.i.getContext().getPackageName());
                return obtain;
            }
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i3);
        this.i.onInitializeAccessibilityEvent(obtain2);
        return obtain2;
    }

    @NonNull
    public final AccessibilityNodeInfoCompat c(int i2) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        Rect rect = n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.i);
        onPopulateNodeForVirtualView(i2, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.e);
        if (!this.e.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(this.i.getContext().getPackageName());
                obtain.setSource(this.i, i2);
                boolean z = false;
                if (this.k == i2) {
                    obtain.setAccessibilityFocused(true);
                    obtain.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    obtain.addAction(64);
                }
                boolean z2 = this.l == i2;
                if (z2) {
                    obtain.addAction(2);
                } else if (obtain.isFocusable()) {
                    obtain.addAction(1);
                }
                obtain.setFocused(z2);
                this.i.getLocationOnScreen(this.g);
                obtain.getBoundsInScreen(this.d);
                if (this.d.equals(rect)) {
                    obtain.getBoundsInParent(this.d);
                    if (obtain.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                        for (int i3 = obtain.mParentVirtualDescendantId; i3 != -1; i3 = obtain2.mParentVirtualDescendantId) {
                            obtain2.setParent(this.i, -1);
                            obtain2.setBoundsInParent(n);
                            onPopulateNodeForVirtualView(i3, obtain2);
                            obtain2.getBoundsInParent(this.e);
                            Rect rect2 = this.d;
                            Rect rect3 = this.e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        obtain2.recycle();
                    }
                    this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                }
                if (this.i.getLocalVisibleRect(this.f)) {
                    this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                    if (this.d.intersect(this.f)) {
                        obtain.setBoundsInScreen(this.d);
                        Rect rect4 = this.d;
                        if (rect4 != null && !rect4.isEmpty() && this.i.getWindowVisibility() == 0) {
                            ViewParent parent = this.i.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view = (View) parent;
                                    if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view.getParent();
                                } else if (parent != null) {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return obtain;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i2, false);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0123, code lost:
        if (r13 < ((r18 * r18) + ((r17 * 13) * r17))) goto L_0x0125;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(int r21, @androidx.annotation.Nullable android.graphics.Rect r22) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.d(int, android.graphics.Rect):boolean");
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        int i2;
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                int i3 = this.m;
                if (i3 != virtualViewAt) {
                    this.m = virtualViewAt;
                    sendEventForVirtualView(virtualViewAt, 128);
                    sendEventForVirtualView(i3, 256);
                }
                if (virtualViewAt != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || (i2 = this.m) == Integer.MIN_VALUE) {
                return false;
            } else {
                if (i2 != Integer.MIN_VALUE) {
                    this.m = Integer.MIN_VALUE;
                    sendEventForVirtualView(Integer.MIN_VALUE, 128);
                    sendEventForVirtualView(i2, 256);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            int i3 = 66;
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        if (keyCode == 19) {
                            i3 = 33;
                        } else if (keyCode == 21) {
                            i3 = 17;
                        } else if (keyCode != 22) {
                            i3 = 130;
                        }
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && d(i3, null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            int i4 = this.l;
            if (i4 != Integer.MIN_VALUE) {
                onPerformActionForVirtualView(i4, 16, null);
            }
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return d(2, null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return d(1, null);
            }
            return false;
        }
    }

    @NonNull
    public AccessibilityNodeInfoCompat e(int i2) {
        if (i2 != -1) {
            return c(i2);
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.i);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.i, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                obtain.addChild(this.i, ((Integer) arrayList.get(i3)).intValue());
            }
            return obtain;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public final void f(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            sendEventForVirtualView(i2, 128);
            sendEventForVirtualView(i3, 256);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.k;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.l;
    }

    public abstract int getVirtualViewAt(float f2, float f3);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i2) {
        invalidateVirtualView(i2, 0);
    }

    public final void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        int i3 = this.l;
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        if (z) {
            d(i2, rect);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i2, int i3, @Nullable Bundle bundle);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i2, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
    }

    public final boolean requestKeyboardFocusForVirtualView(int i2) {
        int i3;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i3 = this.l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i3);
        }
        this.l = i2;
        onVirtualViewKeyboardFocusChanged(i2, true);
        sendEventForVirtualView(i2, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.i, b(i2, i3));
    }

    public final void invalidateVirtualView(int i2, int i3) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.h.isEnabled() && (parent = this.i.getParent()) != null) {
            AccessibilityEvent b2 = b(i2, 2048);
            AccessibilityEventCompat.setContentChangeTypes(b2, i3);
            ViewParentCompat.requestSendAccessibilityEvent(parent, this.i, b2);
        }
    }
}
