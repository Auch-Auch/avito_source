package com.my.target;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicInteger;
public class io {
    @NonNull
    public static final AtomicInteger b = new AtomicInteger(1);
    @NonNull
    public final Context a;

    public static class a extends View.AccessibilityDelegate {
        @NonNull
        public final String a;

        public a(@NonNull String str) {
            this.a = str;
        }

        @Override // android.view.View.AccessibilityDelegate
        @TargetApi(18)
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setViewIdResourceName(this.a);
        }
    }

    public io(@NonNull Context context) {
        this.a = context;
    }

    @NonNull
    public static Point G(@NonNull Context context) {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return point;
        }
        windowManager.getDefaultDisplay().getSize(point);
        return point;
    }

    public static int K(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * 0.7f;
        return Color.HSVToColor(fArr);
    }

    public static int a(@NonNull Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i = activity.getResources().getConfiguration().orientation;
        if (1 == i) {
            return (rotation == 1 || rotation == 2) ? 9 : 1;
        }
        if (2 == i) {
            return (rotation == 2 || rotation == 3) ? 8 : 0;
        }
        ae.a("Unknown screen orientation. Defaulting to portrait.");
        return 9;
    }

    public static void a(int i, int i2, int i3, int i4, @NonNull View... viewArr) {
        int i5 = i3 - i;
        for (View view : viewArr) {
            if (view.getVisibility() != 8) {
                b(view, ((i5 - view.getMeasuredHeight()) / 2) + i, i2);
                if (view.getMeasuredWidth() > 0) {
                    i2 = view.getMeasuredWidth() + i4 + i2;
                }
            }
        }
    }

    public static void a(@NonNull View view, int i, int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        ColorDrawable colorDrawable2 = new ColorDrawable(i2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, colorDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, colorDrawable);
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{16842919}, StateSet.WILD_CARD}, new int[]{K(i2), K(i)}), stateListDrawable, null));
    }

    public static void a(@NonNull View view, int i, int i2, int i3) {
        a(view, i, i2, 0, 0, i3);
    }

    public static void a(@Nullable View view, int i, int i2, int i3, int i4) {
        if (view != null && view.getVisibility() != 8) {
            int measuredWidth = (((i3 - i) - view.getMeasuredWidth()) / 2) + i;
            int measuredHeight = (((i4 - i2) - view.getMeasuredHeight()) / 2) + i2;
            view.layout(measuredWidth, measuredHeight, view.getMeasuredWidth() + measuredWidth, view.getMeasuredHeight() + measuredHeight);
        }
    }

    public static void a(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i});
        float f = (float) i5;
        gradientDrawable.setCornerRadius(f);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i2, i2});
        gradientDrawable2.setCornerRadius(f);
        if (i3 != 0) {
            gradientDrawable.setStroke(i4, i3);
            gradientDrawable2.setStroke(i4, i3);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{16842919}, StateSet.WILD_CARD}, new int[]{K(i2), K(i)}), stateListDrawable, null));
    }

    public static void a(@NonNull View view, @NonNull String str) {
        view.setAccessibilityDelegate(new a(str));
    }

    public static boolean a(@NonNull Activity activity, @NonNull View view) {
        while (view.isHardwareAccelerated() && (view.getLayerType() & 1) == 0) {
            if (!(view.getParent() instanceof View)) {
                Window window = activity.getWindow();
                return (window == null || (window.getAttributes().flags & 16777216) == 0) ? false : true;
            }
            view = (View) view.getParent();
        }
        return false;
    }

    @NonNull
    public static io af(@NonNull Context context) {
        return new io(context);
    }

    public static void b(@Nullable View view, int i, int i2) {
        if (view != null && view.getVisibility() != 8) {
            view.layout(i2, i, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + i);
        }
    }

    public static void b(@Nullable View view, int i, int i2, int i3) {
        if (view != null && view.getVisibility() != 8) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i, i3), View.MeasureSpec.makeMeasureSpec(i2, i3));
        }
    }

    public static void b(@NonNull View view, @NonNull String str) {
        view.setContentDescription(str);
        a(view, str);
    }

    public static int c(int i, @NonNull Context context) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static int c(int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i = Math.max(i2, i);
        }
        return i;
    }

    public static void c(@NonNull View view, int i, int i2) {
        if (view.getVisibility() != 8) {
            view.layout(i2 - view.getMeasuredWidth(), i, i2, view.getMeasuredHeight() + i);
        }
    }

    public static void d(@Nullable View view, int i, int i2) {
        if (view != null && view.getVisibility() != 8) {
            view.layout(i2, i - view.getMeasuredHeight(), view.getMeasuredWidth() + i2, i);
        }
    }

    public static int e(int i, int i2, int i3) {
        return i3 <= i ? i : i3 > i2 ? i2 : i3;
    }

    public static void e(@NonNull View view, int i, int i2) {
        if (view.getVisibility() != 8) {
            view.layout(i2 - view.getMeasuredWidth(), i - view.getMeasuredHeight(), i2, i);
        }
    }

    public static int fh() {
        return View.generateViewId();
    }

    public static boolean fi() {
        try {
            Class.forName(RecyclerView.class.getName());
            return true;
        } catch (Throwable unused) {
            ae.a("RecyclerView doesn't exist, add RecyclerView dependency to show cards");
            return false;
        }
    }

    public static boolean k(@NonNull View view) {
        Window window;
        View view2 = view;
        while (view2.isHardwareAccelerated() && (view2.getLayerType() & 1) == 0) {
            if (!(view2.getParent() instanceof View)) {
                Context context = view.getContext();
                return !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (window.getAttributes().flags & 16777216) != 0;
            }
            view2 = (View) view2.getParent();
        }
        return false;
    }

    public int L(int i) {
        return o((float) i);
    }

    public int M(int i) {
        return (int) TypedValue.applyDimension(2, (float) i, this.a.getResources().getDisplayMetrics());
    }

    public int N(int i) {
        return Math.round(((float) i) / (((float) this.a.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public int o(float f) {
        return (int) TypedValue.applyDimension(1, f, this.a.getResources().getDisplayMetrics());
    }
}
