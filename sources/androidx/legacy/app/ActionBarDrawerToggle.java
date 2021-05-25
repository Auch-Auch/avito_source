package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public static final int[] l = {16843531};
    public final Activity a;
    public final Delegate b;
    public final DrawerLayout c;
    public boolean d;
    public boolean e;
    public Drawable f;
    public Drawable g;
    public a h;
    public final int i;
    public final int j;
    public final int k;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public class a extends InsetDrawable implements Drawable.Callback {
        public final boolean a = true;
        public final Rect b = new Rect();
        public float c;
        public float d;

        public a(Drawable drawable) {
            super(drawable, 0);
        }

        @Override // android.graphics.drawable.Drawable, android.graphics.drawable.DrawableWrapper
        public void draw(@NonNull Canvas canvas) {
            copyBounds(this.b);
            canvas.save();
            int i = 1;
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.a.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            float width = (float) this.b.width();
            canvas.translate((-this.d) * width * this.c * ((float) i), 0.0f);
            if (z && !this.a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this(activity, drawerLayout, !(activity.getApplicationInfo().targetSdkVersion >= 21), i2, i3, i4);
    }

    public final Drawable a() {
        Context context;
        Delegate delegate = this.b;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = this.a;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, l, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public final void b(Drawable drawable, int i2) {
        Delegate delegate = this.b;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i2);
            return;
        }
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i2);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.e) {
            this.f = a();
        }
        this.g = ContextCompat.getDrawable(this.a, this.i);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        a aVar = this.h;
        aVar.c = 0.0f;
        aVar.invalidateSelf();
        if (this.d) {
            int i2 = this.j;
            Delegate delegate = this.b;
            if (delegate != null) {
                delegate.setActionBarDescription(i2);
                return;
            }
            ActionBar actionBar = this.a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        a aVar = this.h;
        aVar.c = 1.0f;
        aVar.invalidateSelf();
        if (this.d) {
            int i2 = this.k;
            Delegate delegate = this.b;
            if (delegate != null) {
                delegate.setActionBarDescription(i2);
                return;
            }
            ActionBar actionBar = this.a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        float f3;
        float f4 = this.h.c;
        if (f2 > 0.5f) {
            f3 = Math.max(f4, Math.max(0.0f, f2 - 0.5f) * 2.0f);
        } else {
            f3 = Math.min(f4, f2 * 2.0f);
        }
        a aVar = this.h;
        aVar.c = f3;
        aVar.invalidateSelf();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.d) {
            return false;
        }
        if (this.c.isDrawerVisible(GravityCompat.START)) {
            this.c.closeDrawer(GravityCompat.START);
            return true;
        }
        this.c.openDrawer(GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.d) {
            if (z) {
                b(this.h, this.c.isDrawerOpen(GravityCompat.START) ? this.k : this.j);
            } else {
                b(this.f, 0);
            }
            this.d = z;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f = a();
            this.e = false;
        } else {
            this.f = drawable;
            this.e = true;
        }
        if (!this.d) {
            b(this.f, 0);
        }
    }

    public void syncState() {
        if (this.c.isDrawerOpen(GravityCompat.START)) {
            a aVar = this.h;
            aVar.c = 1.0f;
            aVar.invalidateSelf();
        } else {
            a aVar2 = this.h;
            aVar2.c = 0.0f;
            aVar2.invalidateSelf();
        }
        if (this.d) {
            b(this.h, this.c.isDrawerOpen(GravityCompat.START) ? this.k : this.j);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this.d = true;
        this.a = activity;
        if (activity instanceof DelegateProvider) {
            this.b = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.b = null;
        }
        this.c = drawerLayout;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        this.f = a();
        this.g = ContextCompat.getDrawable(activity, i2);
        a aVar = new a(this.g);
        this.h = aVar;
        aVar.d = z ? 0.33333334f : 0.0f;
        aVar.invalidateSelf();
    }

    public void setHomeAsUpIndicator(int i2) {
        setHomeAsUpIndicator(i2 != 0 ? ContextCompat.getDrawable(this.a, i2) : null);
    }
}
