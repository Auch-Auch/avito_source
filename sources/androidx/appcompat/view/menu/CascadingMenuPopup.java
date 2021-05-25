package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
public final class CascadingMenuPopup extends l6.b.c.a.c implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = R.layout.abc_cascading_menu_item_layout;
    public boolean A;
    public final Context b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Handler g;
    public final List<MenuBuilder> h = new ArrayList();
    public final List<d> i = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public final MenuItemHoverListener l = new c();
    public int m;
    public int n;
    public View o;
    public View p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public MenuPresenter.Callback x;
    public ViewTreeObserver y;
    public PopupWindow.OnDismissListener z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.i.size() > 0 && !CascadingMenuPopup.this.i.get(0).a.isModal()) {
                View view = CascadingMenuPopup.this.p;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (d dVar : CascadingMenuPopup.this.i) {
                    dVar.a.show();
                }
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.y = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.y.removeGlobalOnLayoutListener(cascadingMenuPopup.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements MenuItemHoverListener {

        public class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ MenuItem b;
            public final /* synthetic */ MenuBuilder c;

            public a(d dVar, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.a = dVar;
                this.b = menuItem;
                this.c = menuBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.a;
                if (dVar != null) {
                    CascadingMenuPopup.this.A = true;
                    dVar.b.close(false);
                    CascadingMenuPopup.this.A = false;
                }
                if (this.b.isEnabled() && this.b.hasSubMenu()) {
                    this.c.performItemAction(this.b, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            d dVar = null;
            CascadingMenuPopup.this.g.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.i.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < CascadingMenuPopup.this.i.size()) {
                    dVar = CascadingMenuPopup.this.i.get(i2);
                }
                CascadingMenuPopup.this.g.postAtTime(new a(dVar, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.g.removeCallbacksAndMessages(menuBuilder);
        }
    }

    public static class d {
        public final MenuPopupWindow a;
        public final MenuBuilder b;
        public final int c;

        public d(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i) {
            this.a = menuPopupWindow;
            this.b = menuBuilder;
            this.c = i;
        }

        public ListView a() {
            return this.a.getListView();
        }
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i2, @StyleRes int i3, boolean z2) {
        int i4 = 0;
        this.m = 0;
        this.n = 0;
        this.b = context;
        this.o = view;
        this.d = i2;
        this.e = i3;
        this.f = z2;
        this.v = false;
        this.q = ViewCompat.getLayoutDirection(view) != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.g = new Handler();
    }

    @Override // l6.b.c.a.c
    public void a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.b);
        if (isShowing()) {
            l(menuBuilder);
        } else {
            this.h.add(menuBuilder);
        }
    }

    @Override // l6.b.c.a.c
    public boolean b() {
        return false;
    }

    @Override // l6.b.c.a.c
    public void d(@NonNull View view) {
        if (this.o != view) {
            this.o = view;
            this.n = GravityCompat.getAbsoluteGravity(this.m, ViewCompat.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.i.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.a.isShowing()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    @Override // l6.b.c.a.c
    public void e(boolean z2) {
        this.v = z2;
    }

    @Override // l6.b.c.a.c
    public void f(int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.n = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this.o));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // l6.b.c.a.c
    public void g(int i2) {
        this.r = true;
        this.t = i2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.i.isEmpty()) {
            return null;
        }
        List<d> list = this.i;
        return list.get(list.size() - 1).a();
    }

    @Override // l6.b.c.a.c
    public void h(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // l6.b.c.a.c
    public void i(boolean z2) {
        this.w = z2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.i.size() > 0 && this.i.get(0).a.isShowing();
    }

    @Override // l6.b.c.a.c
    public void j(int i2) {
        this.s = true;
        this.u = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0115, code lost:
        if (((r7.getWidth() + r9[0]) + r2) > r10.right) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011b, code lost:
        if ((r9[0] - r2) < 0) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011f, code lost:
        r7 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder r15) {
        /*
        // Method dump skipped, instructions count: 484
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.l(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
        int size = this.i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (menuBuilder == this.i.get(i2).b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < this.i.size()) {
                this.i.get(i3).b.close(false);
            }
            d remove = this.i.remove(i2);
            remove.b.removeMenuPresenter(this);
            if (this.A) {
                remove.a.setExitTransition(null);
                remove.a.setAnimationStyle(0);
            }
            remove.a.dismiss();
            int size2 = this.i.size();
            if (size2 > 0) {
                this.q = this.i.get(size2 - 1).c;
            } else {
                this.q = ViewCompat.getLayoutDirection(this.o) == 1 ? 0 : 1;
            }
            if (size2 == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.x;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.j);
                    }
                    this.y = null;
                }
                this.p.removeOnAttachStateChangeListener(this.k);
                this.z.onDismiss();
            } else if (z2) {
                this.i.get(0).b.close(false);
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.i.get(i2);
            if (!dVar.a.isShowing()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.b.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (d dVar : this.i) {
            if (subMenuBuilder == dVar.b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        subMenuBuilder.addMenuPresenter(this, this.b);
        if (isShowing()) {
            l(subMenuBuilder);
        } else {
            this.h.add(subMenuBuilder);
        }
        MenuPresenter.Callback callback = this.x;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.x = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (!isShowing()) {
            for (MenuBuilder menuBuilder : this.h) {
                l(menuBuilder);
            }
            this.h.clear();
            View view = this.o;
            this.p = view;
            if (view != null) {
                boolean z2 = this.y == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.y = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.j);
                }
                this.p.addOnAttachStateChangeListener(this.k);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        for (d dVar : this.i) {
            ListAdapter adapter = dVar.a().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
