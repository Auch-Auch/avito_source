package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;
public class WindowInsetsCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    public final h a;

    public static class c {
        public final WindowInsetsCompat a = new WindowInsetsCompat((WindowInsetsCompat) null);

        @NonNull
        public WindowInsetsCompat a() {
            throw null;
        }

        public void b(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        public void c(@NonNull Insets insets) {
        }

        public void d(@NonNull Insets insets) {
        }

        public void e(@NonNull Insets insets) {
        }

        public void f(@NonNull Insets insets) {
            throw null;
        }

        public void g(@NonNull Insets insets) {
        }
    }

    @RequiresApi(28)
    public static class f extends e {
        public f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @Nullable
        public DisplayCutoutCompat d() {
            DisplayCutout displayCutout = this.b.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new DisplayCutoutCompat(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            return Objects.equals(this.b, ((f) obj).b);
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        public int hashCode() {
            return this.b.hashCode();
        }

        public f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            super(windowInsetsCompat, fVar);
        }
    }

    public static class h {
        public final WindowInsetsCompat a;

        public h(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.a = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.a;
        }

        @NonNull
        public WindowInsetsCompat b() {
            return this.a;
        }

        @NonNull
        public WindowInsetsCompat c() {
            return this.a;
        }

        @Nullable
        public DisplayCutoutCompat d() {
            return null;
        }

        @NonNull
        public Insets e() {
            return h();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (l() != hVar.l() || k() != hVar.k() || !ObjectsCompat.equals(h(), hVar.h()) || !ObjectsCompat.equals(f(), hVar.f()) || !ObjectsCompat.equals(d(), hVar.d())) {
                return false;
            }
            return true;
        }

        @NonNull
        public Insets f() {
            return Insets.NONE;
        }

        @NonNull
        public Insets g() {
            return h();
        }

        @NonNull
        public Insets h() {
            return Insets.NONE;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(l()), Boolean.valueOf(k()), h(), f(), d());
        }

        @NonNull
        public Insets i() {
            return h();
        }

        @NonNull
        public WindowInsetsCompat j(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.CONSUMED;
        }

        public boolean k() {
            return false;
        }

        public boolean l() {
            return false;
        }
    }

    @RequiresApi(20)
    public WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.a = new g(this, windowInsets);
        } else if (i >= 28) {
            this.a = new f(this, windowInsets);
        } else {
            this.a = new e(this, windowInsets);
        }
    }

    public static Insets a(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.left - i);
        int max2 = Math.max(0, insets.top - i2);
        int max3 = Math.max(0, insets.right - i3);
        int max4 = Math.max(0, insets.bottom - i4);
        if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.a.a();
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        return this.a.b();
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.a.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.a, ((WindowInsetsCompat) obj).a);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.a.d();
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        return this.a.e();
    }

    public int getStableInsetBottom() {
        return getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return getStableInsets().left;
    }

    public int getStableInsetRight() {
        return getStableInsets().right;
    }

    public int getStableInsetTop() {
        return getStableInsets().top;
    }

    @NonNull
    public Insets getStableInsets() {
        return this.a.f();
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        return this.a.g();
    }

    public int getSystemWindowInsetBottom() {
        return getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return getSystemWindowInsets().top;
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        return this.a.h();
    }

    @NonNull
    public Insets getTappableElementInsets() {
        return this.a.i();
    }

    public boolean hasInsets() {
        if (!hasSystemWindowInsets() && !hasStableInsets() && getDisplayCutout() == null) {
            Insets systemGestureInsets = getSystemGestureInsets();
            Insets insets = Insets.NONE;
            if (systemGestureInsets.equals(insets) && getMandatorySystemGestureInsets().equals(insets) && getTappableElementInsets().equals(insets)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasStableInsets() {
        return !getStableInsets().equals(Insets.NONE);
    }

    public boolean hasSystemWindowInsets() {
        return !getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        h hVar = this.a;
        if (hVar == null) {
            return 0;
        }
        return hVar.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.a.k();
    }

    public boolean isRound() {
        return this.a.l();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i, i2, i3, i4)).build();
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        h hVar = this.a;
        if (hVar instanceof d) {
            return ((d) hVar).b;
        }
        return null;
    }

    @RequiresApi(api = 29)
    public static class b extends c {
        public final WindowInsets.Builder b;

        public b() {
            this.b = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b.build());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void b(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.b.setDisplayCutout(displayCutoutCompat != null ? (DisplayCutout) displayCutoutCompat.a : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void c(@NonNull Insets insets) {
            this.b.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void d(@NonNull Insets insets) {
            this.b.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void e(@NonNull Insets insets) {
            this.b.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void f(@NonNull Insets insets) {
            this.b.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void g(@NonNull Insets insets) {
            this.b.setTappableElementInsets(insets.toPlatformInsets());
        }

        public b(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.b = builder;
        }
    }

    @RequiresApi(21)
    public static class e extends d {
        public Insets d = null;

        public e(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public final Insets f() {
            if (this.d == null) {
                this.d = Insets.of(this.b.getStableInsetLeft(), this.b.getStableInsetTop(), this.b.getStableInsetRight(), this.b.getStableInsetBottom());
            }
            return this.d;
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        public boolean k() {
            return this.b.isConsumed();
        }

        public e(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull e eVar) {
            super(windowInsetsCompat, eVar);
        }
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return this.a.j(i, i2, i3, i4);
    }

    @RequiresApi(20)
    public static class d extends h {
        @NonNull
        public final WindowInsets b;
        public Insets c = null;

        public d(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.b = windowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public final Insets h() {
            if (this.c == null) {
                this.c = Insets.of(this.b.getSystemWindowInsetLeft(), this.b.getSystemWindowInsetTop(), this.b.getSystemWindowInsetRight(), this.b.getSystemWindowInsetBottom());
            }
            return this.c;
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public WindowInsetsCompat j(int i, int i2, int i3, int i4) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.b));
            builder.setSystemWindowInsets(WindowInsetsCompat.a(h(), i, i2, i3, i4));
            builder.setStableInsets(WindowInsetsCompat.a(f(), i, i2, i3, i4));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        public boolean l() {
            return this.b.isRound();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull d dVar) {
            super(windowInsetsCompat);
            WindowInsets windowInsets = new WindowInsets(dVar.b);
            this.b = windowInsets;
        }
    }

    public static final class Builder {
        public final c a;

        public Builder() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.a = new b();
            } else {
                this.a = new a();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.a.a();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.a.b(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.a.c(insets);
            return this;
        }

        @NonNull
        public Builder setStableInsets(@NonNull Insets insets) {
            this.a.d(insets);
            return this;
        }

        @NonNull
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.a.e(insets);
            return this;
        }

        @NonNull
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.a.f(insets);
            return this;
        }

        @NonNull
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.a.g(insets);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.a = new b(windowInsetsCompat);
            } else {
                this.a = new a(windowInsetsCompat);
            }
        }
    }

    @RequiresApi(29)
    public static class g extends f {
        public Insets e = null;
        public Insets f = null;
        public Insets g = null;

        public g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public Insets e() {
            if (this.f == null) {
                this.f = Insets.toCompatInsets(this.b.getMandatorySystemGestureInsets());
            }
            return this.f;
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public Insets g() {
            if (this.e == null) {
                this.e = Insets.toCompatInsets(this.b.getSystemGestureInsets());
            }
            return this.e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public Insets i() {
            if (this.g == null) {
                this.g = Insets.toCompatInsets(this.b.getTappableElementInsets());
            }
            return this.g;
        }

        @Override // androidx.core.view.WindowInsetsCompat.d, androidx.core.view.WindowInsetsCompat.h
        @NonNull
        public WindowInsetsCompat j(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b.inset(i, i2, i3, i4));
        }

        public g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull g gVar) {
            super(windowInsetsCompat, gVar);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            h hVar = windowInsetsCompat.a;
            int i = Build.VERSION.SDK_INT;
            if (i >= 29 && (hVar instanceof g)) {
                this.a = new g(this, (g) hVar);
            } else if (i >= 28 && (hVar instanceof f)) {
                this.a = new f(this, (f) hVar);
            } else if (hVar instanceof e) {
                this.a = new e(this, (e) hVar);
            } else if (hVar instanceof d) {
                this.a = new d(this, (d) hVar);
            } else {
                this.a = new h(this);
            }
        } else {
            this.a = new h(this);
        }
    }

    @RequiresApi(api = 20)
    public static class a extends c {
        public static Field c = null;
        public static boolean d = false;
        public static Constructor<WindowInsets> e = null;
        public static boolean f = false;
        public WindowInsets b;

        public a() {
            if (!d) {
                try {
                    c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                d = true;
            }
            Field field = c;
            WindowInsets windowInsets = null;
            if (field != null) {
                try {
                    WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                    if (windowInsets2 != null) {
                        windowInsets = new WindowInsets(windowInsets2);
                        this.b = windowInsets;
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f) {
                try {
                    e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f = true;
            }
            Constructor<WindowInsets> constructor = e;
            if (constructor != null) {
                try {
                    windowInsets = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            this.b = windowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.b);
        }

        @Override // androidx.core.view.WindowInsetsCompat.c
        public void f(@NonNull Insets insets) {
            WindowInsets windowInsets = this.b;
            if (windowInsets != null) {
                this.b = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public a(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.b = windowInsetsCompat.toWindowInsets();
        }
    }
}
