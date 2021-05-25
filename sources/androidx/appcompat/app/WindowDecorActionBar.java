package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import l6.b.a.m;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final Interpolator F = new AccelerateInterpolator();
    public static final Interpolator G = new DecelerateInterpolator();
    public boolean A;
    public boolean B;
    public final ViewPropertyAnimatorListener C = new a();
    public final ViewPropertyAnimatorListener D = new b();
    public final ViewPropertyAnimatorUpdateListener E = new c();
    public Context a;
    public Context b;
    public Activity c;
    public ActionBarOverlayLayout d;
    public ActionBarContainer e;
    public DecorToolbar f;
    public ActionBarContextView g;
    public View h;
    public ScrollingTabContainerView i;
    public ArrayList<TabImpl> j = new ArrayList<>();
    public TabImpl k;
    public int l = -1;
    public boolean m;
    public ActionModeImpl n;
    public ActionMode o;
    public ActionMode.Callback p;
    public boolean q;
    public ArrayList<ActionBar.OnMenuVisibilityListener> r = new ArrayList<>();
    public boolean s;
    public int t = 0;
    public boolean u = true;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y = true;
    public ViewPropertyAnimatorCompatSet z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context c;
        public final MenuBuilder d;
        public ActionMode.Callback e;
        public WeakReference<View> f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.c = context;
            this.e = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.d.stopDispatchingItemsChanged();
            try {
                return this.e.onCreateActionMode(this, this.d);
            } finally {
                this.d.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.n == this) {
                boolean z = windowDecorActionBar.v;
                boolean z2 = windowDecorActionBar.w;
                boolean z3 = true;
                if (z || z2) {
                    z3 = false;
                }
                if (!z3) {
                    windowDecorActionBar.o = this;
                    windowDecorActionBar.p = this.e;
                } else {
                    this.e.onDestroyActionMode(this);
                }
                this.e = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.g.closeMode();
                WindowDecorActionBar.this.f.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.d.setHideOnContentScrollEnabled(windowDecorActionBar2.B);
                WindowDecorActionBar.this.n = null;
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> weakReference = this.f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            return this.d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.g.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.g.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.n == this) {
                this.d.stopDispatchingItemsChanged();
                try {
                    this.e.onPrepareActionMode(this, this.d);
                } finally {
                    this.d.startDispatchingItemsChanged();
                }
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.g.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.e;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.e != null) {
                invalidate();
                WindowDecorActionBar.this.g.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.e == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.g.setCustomView(view);
            this.f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.g.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.a.getResources().getString(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {
        public ActionBar.TabListener a;
        public Object b;
        public Drawable c;
        public CharSequence d;
        public CharSequence e;
        public int f = -1;
        public View g;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.a;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.e;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            return this.g;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.c;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            return this.f;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            return this.b;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            return this.d;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.a.getResources().getText(i));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.g = view;
            int i = this.f;
            if (i >= 0) {
                WindowDecorActionBar.this.i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.c = drawable;
            int i = this.f;
            if (i >= 0) {
                WindowDecorActionBar.this.i.updateTab(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.f = i;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.a = tabListener;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.b = obj;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.d = charSequence;
            int i = this.f;
            if (i >= 0) {
                WindowDecorActionBar.this.i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.e = charSequence;
            int i = this.f;
            if (i >= 0) {
                WindowDecorActionBar.this.i.updateTab(i);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.a, i));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.a.getResources().getText(i));
        }
    }

    public class a extends ViewPropertyAnimatorListenerAdapter {
        public a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.u && (view2 = windowDecorActionBar.h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.e.setVisibility(8);
            WindowDecorActionBar.this.e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.z = null;
            ActionMode.Callback callback = windowDecorActionBar2.p;
            if (callback != null) {
                callback.onDestroyActionMode(windowDecorActionBar2.o);
                windowDecorActionBar2.o = null;
                windowDecorActionBar2.p = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    public class b extends ViewPropertyAnimatorListenerAdapter {
        public b() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.z = null;
            windowDecorActionBar.e.requestLayout();
        }
    }

    public class c implements ViewPropertyAnimatorUpdateListener {
        public c() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.e.getParent()).invalidate();
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        this.c = activity;
        View decorView = activity.getWindow().getDecorView();
        d(decorView);
        if (!z2) {
            this.h = decorView.findViewById(16908290);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.r.add(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.j.isEmpty());
    }

    public void animateToMode(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z2) {
            if (!this.x) {
                this.x = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.x) {
            this.x = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.d;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        if (ViewCompat.isLaidOut(this.e)) {
            if (z2) {
                viewPropertyAnimatorCompat = this.f.setupAnimatorToVisibility(4, 100);
                viewPropertyAnimatorCompat2 = this.g.setupAnimatorToVisibility(0, 200);
            } else {
                viewPropertyAnimatorCompat2 = this.f.setupAnimatorToVisibility(0, 200);
                viewPropertyAnimatorCompat = this.g.setupAnimatorToVisibility(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.start();
        } else if (z2) {
            this.f.setVisibility(4);
            this.g.setVisibility(0);
        } else {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
        }
    }

    public final void b(ActionBar.Tab tab, int i2) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i2);
            this.j.add(i2, tabImpl);
            int size = this.j.size();
            while (true) {
                i2++;
                if (i2 < size) {
                    this.j.get(i2).setPosition(i2);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    public final void c() {
        if (this.i == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.a);
            if (this.s) {
                scrollingTabContainerView.setVisibility(0);
                this.f.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.e.setTabContainer(scrollingTabContainerView);
            }
            this.i = scrollingTabContainerView;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.f;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.f.collapseActionView();
        return true;
    }

    public final void d(View view) {
        DecorToolbar decorToolbar;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder L = a2.b.a.a.a.L("Can't make a decor toolbar out of ");
            L.append(findViewById != null ? findViewById.getClass().getSimpleName() : BuildConfig.ADJUST_DEFAULT_TRACKER);
            throw new IllegalStateException(L.toString());
        }
        this.f = decorToolbar;
        this.g = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.e = actionBarContainer;
        DecorToolbar decorToolbar2 = this.f;
        if (decorToolbar2 == null || this.g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = decorToolbar2.getContext();
        boolean z2 = (this.f.getDisplayOptions() & 4) != 0;
        if (z2) {
            this.m = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.a);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z2);
        e(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z2) {
        if (z2 != this.q) {
            this.q = z2;
            int size = this.r.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.r.get(i2).onMenuVisibilityChanged(z2);
            }
        }
    }

    public void doHide(boolean z2) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.t != 0 || (!this.A && !z2)) {
            this.C.onAnimationEnd(null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f2 = (float) (-this.e.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.e.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.e).translationY(f2);
        translationY.setUpdateListener(this.E);
        viewPropertyAnimatorCompatSet2.play(translationY);
        if (this.u && (view = this.h) != null) {
            viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f2));
        }
        viewPropertyAnimatorCompatSet2.setInterpolator(F);
        viewPropertyAnimatorCompatSet2.setDuration(250);
        viewPropertyAnimatorCompatSet2.setListener(this.C);
        this.z = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.start();
    }

    public void doShow(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.e.setVisibility(0);
        if (this.t != 0 || (!this.A && !z2)) {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.u && (view = this.h) != null) {
                view.setTranslationY(0.0f);
            }
            this.D.onAnimationEnd(null);
        } else {
            this.e.setTranslationY(0.0f);
            float f2 = (float) (-this.e.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.e.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.e.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.e).translationY(0.0f);
            translationY.setUpdateListener(this.E);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.u && (view2 = this.h) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.h).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(G);
            viewPropertyAnimatorCompatSet2.setDuration(250);
            viewPropertyAnimatorCompatSet2.setListener(this.D);
            this.z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public final void e(boolean z2) {
        this.s = z2;
        if (!z2) {
            this.f.setEmbeddedTabView(null);
            this.e.setTabContainer(this.i);
        } else {
            this.e.setTabContainer(null);
            this.f.setEmbeddedTabView(this.i);
        }
        boolean z3 = true;
        boolean z4 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.i;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f.setCollapsible(!this.s && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.d;
        if (this.s || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z2) {
        this.u = z2;
    }

    public final void f(boolean z2) {
        if (this.x || (!this.v && !this.w)) {
            if (!this.y) {
                this.y = true;
                doShow(z2);
            }
        } else if (this.y) {
            this.y = false;
            doHide(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.f.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.f.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.e);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.e.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        return this.d.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        int navigationMode = this.f.getNavigationMode();
        if (navigationMode == 1) {
            return this.f.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.j.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return this.f.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.f.getNavigationMode();
        if (navigationMode == 1) {
            return this.f.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.k) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.k;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.f.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i2) {
        return this.j.get(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.j.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.a, i2);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.f.getTitle();
    }

    public boolean hasIcon() {
        return this.f.hasIcon();
    }

    public boolean hasLogo() {
        return this.f.hasLogo();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        if (!this.v) {
            this.v = true;
            f(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.w) {
            this.w = true;
            f(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.d.isHideOnContentScrollEnabled();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.y && (height == 0 || getHideOffset() < height);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.f;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        e(ActionBarPolicy.get(this.a).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.z = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        Menu menu;
        ActionModeImpl actionModeImpl = this.n;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        menu.setQwertyMode(z2);
        return menu.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i2) {
        this.t = i2;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        if (this.k != null) {
            selectTab(null);
        }
        this.j.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.i;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.l = -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.r.remove(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i2) {
        if (this.i != null) {
            TabImpl tabImpl = this.k;
            int position = tabImpl != null ? tabImpl.getPosition() : this.l;
            this.i.removeTabAt(i2);
            TabImpl remove = this.j.remove(i2);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.j.size();
            for (int i3 = i2; i3 < size; i3++) {
                this.j.get(i3).setPosition(i3);
            }
            if (position == i2) {
                selectTab(this.j.isEmpty() ? null : this.j.get(Math.max(0, i2 - 1)));
            }
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        int i2 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i2 = tab.getPosition();
            }
            this.l = i2;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.c instanceof FragmentActivity) || this.f.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.c).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        TabImpl tabImpl = this.k;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.i;
            if (tab != null) {
                i2 = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i2);
            TabImpl tabImpl2 = this.k;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.k, disallowAddToBackStack);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.k = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.k, disallowAddToBackStack);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.k, disallowAddToBackStack);
            this.i.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
            disallowAddToBackStack.commit();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.e.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i2) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i2, this.f.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z2) {
        if (!this.m) {
            setDisplayHomeAsUpEnabled(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z2) {
        setDisplayOptions(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i2) {
        if ((i2 & 4) != 0) {
            this.m = true;
        }
        this.f.setDisplayOptions(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z2) {
        setDisplayOptions(z2 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z2) {
        setDisplayOptions(z2 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z2) {
        setDisplayOptions(z2 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z2) {
        setDisplayOptions(z2 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f2) {
        ViewCompat.setElevation(this.e, f2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i2) {
        if (i2 == 0 || this.d.isInOverlayMode()) {
            this.d.setActionBarHideOffset(i2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z2) {
        if (!z2 || this.d.isInOverlayMode()) {
            this.B = z2;
            this.d.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f.setNavigationContentDescription(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z2) {
        this.f.setHomeButtonEnabled(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i2) {
        this.f.setIcon(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f.setDropdownParams(spinnerAdapter, new m(onNavigationListener));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i2) {
        this.f.setLogo(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i2) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.f.getNavigationMode();
        if (navigationMode == 2) {
            this.l = getSelectedNavigationIndex();
            selectTab(null);
            this.i.setVisibility(8);
        }
        if (!(navigationMode == i2 || this.s || (actionBarOverlayLayout = this.d) == null)) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.f.setNavigationMode(i2);
        boolean z2 = false;
        if (i2 == 2) {
            c();
            this.i.setVisibility(0);
            int i3 = this.l;
            if (i3 != -1) {
                setSelectedNavigationItem(i3);
                this.l = -1;
            }
        }
        this.f.setCollapsible(i2 == 2 && !this.s);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.d;
        if (i2 == 2 && !this.s) {
            z2 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i2) {
        int navigationMode = this.f.getNavigationMode();
        if (navigationMode == 1) {
            this.f.setDropdownSelectedPosition(i2);
        } else if (navigationMode == 2) {
            selectTab(this.j.get(i2));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.A = z2;
        if (!z2 && (viewPropertyAnimatorCompatSet = this.z) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.e.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i2) {
        setSubtitle(this.a.getString(i2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i2) {
        setTitle(this.a.getString(i2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        if (this.v) {
            this.v = false;
            f(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.w) {
            this.w = false;
            f(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.n;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.g.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.n = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.g.initForMode(actionModeImpl2);
        animateToMode(true);
        this.g.sendAccessibilityEvent(32);
        return actionModeImpl2;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2) {
        addTab(tab, i2, this.j.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i2) {
        this.f.setNavigationContentDescription(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i2) {
        this.f.setNavigationIcon(i2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.f.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.f.setLogo(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.f.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z2) {
        c();
        this.i.addTab(tab, z2);
        b(tab, this.j.size());
        if (z2) {
            selectTab(tab);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i2, int i3) {
        int displayOptions = this.f.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.m = true;
        }
        this.f.setDisplayOptions((i2 & i3) | ((~i3) & displayOptions));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view) {
        this.f.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i2, boolean z2) {
        c();
        this.i.addTab(tab, i2, z2);
        b(tab, i2);
        if (z2) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        d(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        d(view);
    }
}
