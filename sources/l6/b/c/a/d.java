package l6.b.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
public final class d extends c implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    public static final int v = R.layout.abc_popup_menu_item_layout;
    public final Context b;
    public final MenuBuilder c;
    public final MenuAdapter d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final MenuPopupWindow i;
    public final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    public final View.OnAttachStateChangeListener k = new b();
    public PopupWindow.OnDismissListener l;
    public View m;
    public View n;
    public MenuPresenter.Callback o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int s;
    public int t = 0;
    public boolean u;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.isShowing() && !d.this.i.isModal()) {
                View view = d.this.n;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                } else {
                    d.this.i.show();
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
            ViewTreeObserver viewTreeObserver = d.this.p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.p = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.p.removeGlobalOnLayoutListener(dVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public d(Context context, MenuBuilder menuBuilder, View view, int i2, int i3, boolean z) {
        this.b = context;
        this.c = menuBuilder;
        this.e = z;
        this.d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, v);
        this.g = i2;
        this.h = i3;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new MenuPopupWindow(context, null, i2, i3);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // l6.b.c.a.c
    public void a(MenuBuilder menuBuilder) {
    }

    @Override // l6.b.c.a.c
    public void d(View view) {
        this.m = view;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing()) {
            this.i.dismiss();
        }
    }

    @Override // l6.b.c.a.c
    public void e(boolean z) {
        this.d.setForceShowIcon(z);
    }

    @Override // l6.b.c.a.c
    public void f(int i2) {
        this.t = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // l6.b.c.a.c
    public void g(int i2) {
        this.i.setHorizontalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.i.getListView();
    }

    @Override // l6.b.c.a.c
    public void h(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // l6.b.c.a.c
    public void i(boolean z) {
        this.u = z;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.q && this.i.isShowing();
    }

    @Override // l6.b.c.a.c
    public void j(int i2) {
        this.i.setVerticalOffset(i2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.c) {
            dismiss();
            MenuPresenter.Callback callback = this.o;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.c.close();
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.b, subMenuBuilder, this.n, this.e, this.g, this.h);
            menuPopupHelper.setPresenterCallback(this.o);
            menuPopupHelper.setForceShowIcon(c.k(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.l);
            this.l = null;
            this.c.close(false);
            int horizontalOffset = this.i.getHorizontalOffset();
            int verticalOffset = this.i.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.t, ViewCompat.getLayoutDirection(this.m)) & 7) == 5) {
                horizontalOffset += this.m.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.o;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.o = callback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show() {
        /*
            r7 = this;
            boolean r0 = r7.isShowing()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000b
        L_0x0008:
            r1 = 1
            goto L_0x00c4
        L_0x000b:
            boolean r0 = r7.q
            if (r0 != 0) goto L_0x00c4
            android.view.View r0 = r7.m
            if (r0 != 0) goto L_0x0015
            goto L_0x00c4
        L_0x0015:
            r7.n = r0
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r0.setOnDismissListener(r7)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r0.setOnItemClickListener(r7)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r0.setModal(r2)
            android.view.View r0 = r7.n
            android.view.ViewTreeObserver r3 = r7.p
            if (r3 != 0) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            android.view.ViewTreeObserver r4 = r0.getViewTreeObserver()
            r7.p = r4
            if (r3 == 0) goto L_0x003c
            android.view.ViewTreeObserver$OnGlobalLayoutListener r3 = r7.j
            r4.addOnGlobalLayoutListener(r3)
        L_0x003c:
            android.view.View$OnAttachStateChangeListener r3 = r7.k
            r0.addOnAttachStateChangeListener(r3)
            androidx.appcompat.widget.MenuPopupWindow r3 = r7.i
            r3.setAnchorView(r0)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            int r3 = r7.t
            r0.setDropDownGravity(r3)
            boolean r0 = r7.r
            r3 = 0
            if (r0 != 0) goto L_0x0060
            androidx.appcompat.view.menu.MenuAdapter r0 = r7.d
            android.content.Context r4 = r7.b
            int r5 = r7.f
            int r0 = l6.b.c.a.c.c(r0, r3, r4, r5)
            r7.s = r0
            r7.r = r2
        L_0x0060:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            int r4 = r7.s
            r0.setContentWidth(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r4 = 2
            r0.setInputMethodMode(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            android.graphics.Rect r4 = r7.a
            r0.setEpicenterBounds(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r0.show()
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            android.widget.ListView r0 = r0.getListView()
            r0.setOnKeyListener(r7)
            boolean r4 = r7.u
            if (r4 == 0) goto L_0x00b6
            androidx.appcompat.view.menu.MenuBuilder r4 = r7.c
            java.lang.CharSequence r4 = r4.getHeaderTitle()
            if (r4 == 0) goto L_0x00b6
            android.content.Context r4 = r7.b
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r5 = androidx.appcompat.R.layout.abc_popup_menu_header_item_layout
            android.view.View r4 = r4.inflate(r5, r0, r1)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00b0
            androidx.appcompat.view.menu.MenuBuilder r6 = r7.c
            java.lang.CharSequence r6 = r6.getHeaderTitle()
            r5.setText(r6)
        L_0x00b0:
            r4.setEnabled(r1)
            r0.addHeaderView(r4, r3, r1)
        L_0x00b6:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            androidx.appcompat.view.menu.MenuAdapter r1 = r7.d
            r0.setAdapter(r1)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.i
            r0.show()
            goto L_0x0008
        L_0x00c4:
            if (r1 == 0) goto L_0x00c7
            return
        L_0x00c7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "StandardMenuPopup cannot be used without an anchor"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.b.c.a.d.show():void");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.r = false;
        MenuAdapter menuAdapter = this.d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
