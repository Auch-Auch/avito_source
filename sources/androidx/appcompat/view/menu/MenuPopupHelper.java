package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import l6.b.c.a.c;
import l6.b.c.a.d;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper {
    public final Context a;
    public final MenuBuilder b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public MenuPresenter.Callback i;
    public c j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    public final void a(int i2, int i3, boolean z, boolean z2) {
        c popup = getPopup();
        popup.i(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.g, ViewCompat.getLayoutDirection(this.f)) & 7) == 5) {
                i2 -= this.f.getWidth();
            }
            popup.g(i2);
            popup.j(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.a = new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4);
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.j.dismiss();
        }
    }

    public int getGravity() {
        return this.g;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    public c getPopup() {
        c cVar;
        if (this.j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                cVar = new CascadingMenuPopup(this.a, this.f, this.d, this.e, this.c);
            } else {
                cVar = new d(this.a, this.b, this.f, this.d, this.e, this.c);
            }
            cVar.a(this.b);
            cVar.h(this.l);
            cVar.d(this.f);
            cVar.setCallback(this.i);
            cVar.e(this.h);
            cVar.f(this.g);
            this.j = cVar;
        }
        return this.j;
    }

    public boolean isShowing() {
        c cVar = this.j;
        return cVar != null && cVar.isShowing();
    }

    public void onDismiss() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@NonNull View view) {
        this.f = view;
    }

    public void setForceShowIcon(boolean z) {
        this.h = z;
        c cVar = this.j;
        if (cVar != null) {
            cVar.e(z);
        }
    }

    public void setGravity(int i2) {
        this.g = i2;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.i = callback;
        c cVar = this.j;
        if (cVar != null) {
            cVar.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2) {
        this(context, menuBuilder, view, z, i2, 0);
    }

    public void show(int i2, int i3) {
        if (!tryShow(i2, i3)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i2, @StyleRes int i3) {
        this.g = GravityCompat.START;
        this.l = new a();
        this.a = context;
        this.b = menuBuilder;
        this.f = view;
        this.c = z;
        this.d = i2;
        this.e = i3;
    }

    public boolean tryShow(int i2, int i3) {
        if (isShowing()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i2, i3, true, true);
        return true;
    }
}
