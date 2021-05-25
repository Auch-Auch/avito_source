package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public final Delegate a;
    public final DrawerLayout b;
    public DrawerArrowDrawable c;
    public boolean d;
    public Drawable e;
    public boolean f;
    public boolean g;
    public final int h;
    public final int i;
    public View.OnClickListener j;
    public boolean k;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
            if (actionBarDrawerToggle.f) {
                actionBarDrawerToggle.d();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public static class b implements Delegate {
        public final Activity a;

        public b(Activity activity) {
            this.a = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.a;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar actionBar = this.a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            ActionBar actionBar = this.a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar actionBar = this.a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    public static class c implements Delegate {
        public final Toolbar a;
        public final Drawable b;
        public final CharSequence c;

        public c(Toolbar toolbar) {
            this.a = toolbar;
            this.b = toolbar.getNavigationIcon();
            this.c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.a.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.b;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@StringRes int i) {
            if (i == 0) {
                this.a.setNavigationContentDescription(this.c);
            } else {
                this.a.setNavigationContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
            this.a.setNavigationIcon(drawable);
            if (i == 0) {
                this.a.setNavigationContentDescription(this.c);
            } else {
                this.a.setNavigationContentDescription(i);
            }
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i2, @StringRes int i3) {
        this(activity, null, drawerLayout, null, i2, i3);
    }

    public Drawable a() {
        return this.a.getThemeUpIndicator();
    }

    public void b(Drawable drawable, int i2) {
        if (!this.k && !this.a.isNavigationVisible()) {
            this.k = true;
        }
        this.a.setActionBarUpIndicator(drawable, i2);
    }

    public final void c(float f2) {
        if (f2 == 1.0f) {
            this.c.setVerticalMirror(true);
        } else if (f2 == 0.0f) {
            this.c.setVerticalMirror(false);
        }
        this.c.setProgress(f2);
    }

    public void d() {
        int drawerLockMode = this.b.getDrawerLockMode(GravityCompat.START);
        if (this.b.isDrawerVisible(GravityCompat.START) && drawerLockMode != 2) {
            this.b.closeDrawer(GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.b.openDrawer(GravityCompat.START);
        }
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.c;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.j;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.g) {
            this.e = a();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        c(0.0f);
        if (this.f) {
            this.a.setActionBarDescription(this.h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        c(1.0f);
        if (this.f) {
            this.a.setActionBarDescription(this.i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        if (this.d) {
            c(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            c(0.0f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f) {
            return false;
        }
        d();
        return true;
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.c = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f) {
            if (z) {
                b(this.c, this.b.isDrawerOpen(GravityCompat.START) ? this.i : this.h);
            } else {
                b(this.e, 0);
            }
            this.f = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.d = z;
        if (!z) {
            c(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.e = a();
            this.g = false;
        } else {
            this.e = drawable;
            this.g = true;
        }
        if (!this.f) {
            b(this.e, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void syncState() {
        if (this.b.isDrawerOpen(GravityCompat.START)) {
            c(1.0f);
        } else {
            c(0.0f);
        }
        if (this.f) {
            b(this.c, this.b.isDrawerOpen(GravityCompat.START) ? this.i : this.h);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i2, @StringRes int i3) {
        this(activity, toolbar, drawerLayout, null, i2, i3);
    }

    public ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i2, @StringRes int i3) {
        this.d = true;
        this.f = true;
        this.k = false;
        if (toolbar != null) {
            this.a = new c(toolbar);
            toolbar.setNavigationOnClickListener(new a());
        } else if (activity instanceof DelegateProvider) {
            this.a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.a = new b(activity);
        }
        this.b = drawerLayout;
        this.h = i2;
        this.i = i3;
        this.c = new DrawerArrowDrawable(this.a.getActionBarThemedContext());
        this.e = a();
    }

    public void setHomeAsUpIndicator(int i2) {
        setHomeAsUpIndicator(i2 != 0 ? this.b.getResources().getDrawable(i2) : null);
    }
}
