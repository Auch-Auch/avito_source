package androidx.core.view;

import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class KeyEventDispatcher {
    public static boolean a = false;
    public static Method b = null;
    public static boolean c = false;
    public static Field d;

    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean dispatchBeforeHierarchy(@NonNull View view, @NonNull KeyEvent keyEvent) {
        int indexOfKey;
        int i = ViewCompat.OVER_SCROLL_ALWAYS;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = ViewCompat.e.d;
        int i2 = R.id.tag_unhandled_key_event_manager;
        ViewCompat.e eVar = (ViewCompat.e) view.getTag(i2);
        if (eVar == null) {
            eVar = new ViewCompat.e();
            view.setTag(i2, eVar);
        }
        WeakReference<KeyEvent> weakReference = eVar.c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        eVar.c = new WeakReference<>(keyEvent);
        WeakReference<View> weakReference2 = null;
        if (eVar.b == null) {
            eVar.b = new SparseArray<>();
        }
        SparseArray<WeakReference<View>> sparseArray = eVar.b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference2 = sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference2 == null) {
            weakReference2 = sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference2 == null) {
            return false;
        }
        View view2 = weakReference2.get();
        if (view2 != null && ViewCompat.isAttachedToWindow(view2)) {
            eVar.b(view2, keyEvent);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dispatchKeyEvent(@androidx.annotation.NonNull androidx.core.view.KeyEventDispatcher.Component r7, @androidx.annotation.Nullable android.view.View r8, @androidx.annotation.Nullable android.view.Window.Callback r9, @androidx.annotation.NonNull android.view.KeyEvent r10) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x000f
            boolean r7 = r7.superDispatchKeyEvent(r10)
            return r7
        L_0x000f:
            boolean r1 = r9 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0080
            android.app.Activity r9 = (android.app.Activity) r9
            r9.onUserInteraction()
            android.view.Window r7 = r9.getWindow()
            r8 = 8
            boolean r8 = r7.hasFeature(r8)
            if (r8 == 0) goto L_0x0063
            android.app.ActionBar r8 = r9.getActionBar()
            int r1 = r10.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L_0x0063
            if (r8 == 0) goto L_0x0063
            boolean r1 = androidx.core.view.KeyEventDispatcher.a
            if (r1 != 0) goto L_0x004c
            java.lang.Class r1 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x004a }
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x004a }
            java.lang.Class<android.view.KeyEvent> r6 = android.view.KeyEvent.class
            r5[r0] = r6     // Catch:{ NoSuchMethodException -> 0x004a }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x004a }
            androidx.core.view.KeyEventDispatcher.b = r1     // Catch:{ NoSuchMethodException -> 0x004a }
        L_0x004a:
            androidx.core.view.KeyEventDispatcher.a = r3
        L_0x004c:
            java.lang.reflect.Method r1 = androidx.core.view.KeyEventDispatcher.b
            if (r1 == 0) goto L_0x0060
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005f }
            r4[r0] = r10     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005f }
            java.lang.Object r8 = r1.invoke(r8, r4)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005f }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005f }
            boolean r0 = r8.booleanValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x005f }
            goto L_0x0060
        L_0x005f:
        L_0x0060:
            if (r0 == 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto L_0x006a
            goto L_0x007f
        L_0x006a:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = androidx.core.view.ViewCompat.d(r7, r10)
            if (r8 == 0) goto L_0x0075
            goto L_0x007f
        L_0x0075:
            if (r7 == 0) goto L_0x007b
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        L_0x007b:
            boolean r3 = r10.dispatch(r9, r2, r9)
        L_0x007f:
            return r3
        L_0x0080:
            boolean r1 = r9 instanceof android.app.Dialog
            if (r1 == 0) goto L_0x00d3
            android.app.Dialog r9 = (android.app.Dialog) r9
            boolean r7 = androidx.core.view.KeyEventDispatcher.c
            if (r7 != 0) goto L_0x0099
            java.lang.Class<android.app.Dialog> r7 = android.app.Dialog.class
            java.lang.String r8 = "mOnKeyListener"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x0097 }
            androidx.core.view.KeyEventDispatcher.d = r7     // Catch:{ NoSuchFieldException -> 0x0097 }
            r7.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x0097 }
        L_0x0097:
            androidx.core.view.KeyEventDispatcher.c = r3
        L_0x0099:
            java.lang.reflect.Field r7 = androidx.core.view.KeyEventDispatcher.d
            if (r7 == 0) goto L_0x00a4
            java.lang.Object r7 = r7.get(r9)     // Catch:{ IllegalAccessException -> 0x00a4 }
            android.content.DialogInterface$OnKeyListener r7 = (android.content.DialogInterface.OnKeyListener) r7     // Catch:{ IllegalAccessException -> 0x00a4 }
            goto L_0x00a5
        L_0x00a4:
            r7 = r2
        L_0x00a5:
            if (r7 == 0) goto L_0x00b2
            int r8 = r10.getKeyCode()
            boolean r7 = r7.onKey(r9, r8, r10)
            if (r7 == 0) goto L_0x00b2
            goto L_0x00d2
        L_0x00b2:
            android.view.Window r7 = r9.getWindow()
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto L_0x00bd
            goto L_0x00d2
        L_0x00bd:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = androidx.core.view.ViewCompat.d(r7, r10)
            if (r8 == 0) goto L_0x00c8
            goto L_0x00d2
        L_0x00c8:
            if (r7 == 0) goto L_0x00ce
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        L_0x00ce:
            boolean r3 = r10.dispatch(r9, r2, r9)
        L_0x00d2:
            return r3
        L_0x00d3:
            if (r8 == 0) goto L_0x00db
            boolean r8 = androidx.core.view.ViewCompat.d(r8, r10)
            if (r8 != 0) goto L_0x00e1
        L_0x00db:
            boolean r7 = r7.superDispatchKeyEvent(r10)
            if (r7 == 0) goto L_0x00e2
        L_0x00e1:
            r0 = 1
        L_0x00e2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.KeyEventDispatcher.dispatchKeyEvent(androidx.core.view.KeyEventDispatcher$Component, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }
}
