package androidx.databinding;

import a2.b.a.a.a;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class DataBindingUtil {
    public static DataBinderMapper a = new DataBinderMapperImpl();
    public static DataBindingComponent b = null;

    public static <T extends ViewDataBinding> T a(DataBindingComponent dataBindingComponent, View view, int i) {
        return (T) a.getDataBinder(dataBindingComponent, view, i);
    }

    public static <T extends ViewDataBinding> T b(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) a(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) a.getDataBinder(dataBindingComponent, viewArr, i2);
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view) {
        return (T) bind(view, b);
    }

    @Nullable
    public static String convertBrIdToString(int i) {
        return a.convertBrIdToString(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r3 == -1) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r1.indexOf(47, r3 + 1) == -1) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends androidx.databinding.ViewDataBinding> T findBinding(@androidx.annotation.NonNull android.view.View r9) {
        /*
        L_0x0000:
            r0 = 0
            if (r9 == 0) goto L_0x005a
            androidx.databinding.ViewDataBinding r1 = androidx.databinding.ViewDataBinding.d(r9)
            if (r1 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Object r1 = r9.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x004d
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "layout"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = "_0"
            boolean r2 = r1.endsWith(r2)
            if (r2 == 0) goto L_0x004d
            r2 = 6
            char r2 = r1.charAt(r2)
            r3 = 7
            r4 = 47
            int r3 = r1.indexOf(r4, r3)
            r5 = 1
            r6 = -1
            r7 = 0
            if (r2 != r4) goto L_0x003b
            if (r3 != r6) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            r7 = r5
            goto L_0x004a
        L_0x003b:
            r8 = 45
            if (r2 != r8) goto L_0x004a
            if (r3 == r6) goto L_0x004a
            int r3 = r3 + 1
            int r1 = r1.indexOf(r4, r3)
            if (r1 != r6) goto L_0x0038
            goto L_0x0039
        L_0x004a:
            if (r7 == 0) goto L_0x004d
            return r0
        L_0x004d:
            android.view.ViewParent r9 = r9.getParent()
            boolean r1 = r9 instanceof android.view.View
            if (r1 == 0) goto L_0x0058
            android.view.View r9 = (android.view.View) r9
            goto L_0x0000
        L_0x0058:
            r9 = r0
            goto L_0x0000
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.DataBindingUtil.findBinding(android.view.View):androidx.databinding.ViewDataBinding");
    }

    @Nullable
    public static <T extends ViewDataBinding> T getBinding(@NonNull View view) {
        return (T) ViewDataBinding.d(view);
    }

    @Nullable
    public static DataBindingComponent getDefaultComponent() {
        return b;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z) {
        return (T) inflate(layoutInflater, i, viewGroup, z, b);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i) {
        return (T) setContentView(activity, i, b);
    }

    public static void setDefaultComponent(@Nullable DataBindingComponent dataBindingComponent) {
        b = dataBindingComponent;
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view, DataBindingComponent dataBindingComponent) {
        T t = (T) getBinding(view);
        if (t != null) {
            return t;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int layoutId = a.getLayoutId((String) tag);
            if (layoutId != 0) {
                return (T) a.getDataBinder(dataBindingComponent, view, layoutId);
            }
            throw new IllegalArgumentException(a.b3("View is not a binding layout. Tag: ", tag));
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        int i2 = 0;
        boolean z2 = viewGroup != null && z;
        if (z2) {
            i2 = viewGroup.getChildCount();
        }
        return z2 ? (T) b(dataBindingComponent, viewGroup, i2, i) : (T) a(dataBindingComponent, layoutInflater.inflate(i, viewGroup, z), i);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i, @Nullable DataBindingComponent dataBindingComponent) {
        activity.setContentView(i);
        return (T) b(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i);
    }
}
