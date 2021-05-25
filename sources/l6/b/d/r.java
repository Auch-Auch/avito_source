package l6.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class r implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static r j;
    public static r k;
    public final View a;
    public final CharSequence b;
    public final int c;
    public final Runnable d = new a();
    public final Runnable e = new b();
    public int f;
    public int g;
    public s h;
    public boolean i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.d(false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.b();
        }
    }

    public r(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        a();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void c(r rVar) {
        r rVar2 = j;
        if (rVar2 != null) {
            rVar2.a.removeCallbacks(rVar2.d);
        }
        j = rVar;
        if (rVar != null) {
            rVar.a.postDelayed(rVar.d, (long) ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }

    public void b() {
        if (k == this) {
            k = null;
            s sVar = this.h;
            if (sVar != null) {
                sVar.a();
                this.h = null;
                a();
                this.a.removeOnAttachStateChangeListener(this);
            }
        }
        if (j == this) {
            c(null);
        }
        this.a.removeCallbacks(this.e);
    }

    public void d(boolean z) {
        int i2;
        int i3;
        long j2;
        int i4;
        long j3;
        if (ViewCompat.isAttachedToWindow(this.a)) {
            c(null);
            r rVar = k;
            if (rVar != null) {
                rVar.b();
            }
            k = this;
            this.i = z;
            s sVar = new s(this.a.getContext());
            this.h = sVar;
            View view = this.a;
            int i5 = this.f;
            int i6 = this.g;
            boolean z2 = this.i;
            CharSequence charSequence = this.b;
            if (sVar.b.getParent() != null) {
                sVar.a();
            }
            sVar.c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = sVar.d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = sVar.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i5 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = sVar.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                i2 = i6 + dimensionPixelOffset2;
                i3 = i6 - dimensionPixelOffset2;
            } else {
                i2 = view.getHeight();
                i3 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = sVar.a.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context = view.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Activity) {
                        rootView = ((Activity) context).getWindow().getDecorView();
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
            }
            if (rootView != null) {
                rootView.getWindowVisibleDisplayFrame(sVar.e);
                Rect rect = sVar.e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = sVar.a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    sVar.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(sVar.g);
                view.getLocationOnScreen(sVar.f);
                int[] iArr = sVar.f;
                int i7 = iArr[0];
                int[] iArr2 = sVar.g;
                iArr[0] = i7 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i5) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                sVar.b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = sVar.b.getMeasuredHeight();
                int[] iArr3 = sVar.f;
                int i8 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
                int i9 = iArr3[1] + i2 + dimensionPixelOffset3;
                if (z2) {
                    if (i8 >= 0) {
                        layoutParams.y = i8;
                    } else {
                        layoutParams.y = i9;
                    }
                } else if (measuredHeight + i9 <= sVar.e.height()) {
                    layoutParams.y = i9;
                } else {
                    layoutParams.y = i8;
                }
            }
            ((WindowManager) sVar.a.getSystemService("window")).addView(sVar.b, sVar.d);
            this.a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.a) & 1) == 1) {
                    j3 = 3000;
                    i4 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i4 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i4);
            }
            this.a.removeCallbacks(this.e);
            this.a.postDelayed(this.e, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                a();
                b();
            }
        } else if (this.a.isEnabled() && this.h == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.f) > this.c || Math.abs(y - this.g) > this.c) {
                this.f = x;
                this.g = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c(this);
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        d(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
