package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static ResourceManagerInternal i;
    public static final c j = new c(6);
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> a;
    public SimpleArrayMap<String, d> b;
    public SparseArrayCompat<String> c;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);
    public TypedValue e;
    public boolean f;
    public e g;

    @RequiresApi(11)
    public static class a implements d {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.d
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class b implements d {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.d
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class c extends LruCache<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }
    }

    public interface d {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface e {
    }

    public static class f implements d {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.d
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (i == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                i = resourceManagerInternal2;
                if (Build.VERSION.SDK_INT < 24) {
                    resourceManagerInternal2.a("vector", new f());
                    resourceManagerInternal2.a("animated-vector", new b());
                    resourceManagerInternal2.a("animated-selector", new a());
                }
            }
            resourceManagerInternal = i;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            c cVar = j;
            Objects.requireNonNull(cVar);
            int i3 = (i2 + 31) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) cVar.get(Integer.valueOf(mode.hashCode() + i3));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                Objects.requireNonNull(cVar);
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) cVar.put(Integer.valueOf(mode.hashCode() + i3), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public final void a(@NonNull String str, @NonNull d dVar) {
        if (this.b == null) {
            this.b = new SimpleArrayMap<>();
        }
        this.b.put(str, dVar);
    }

    public final synchronized boolean b(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.d.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.d.put(context, longSparseArray);
        }
        longSparseArray.put(j2, new WeakReference<>(constantState));
        return true;
    }

    public final Drawable c(@NonNull Context context, @DrawableRes int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable d2 = d(context, j2);
        if (d2 != null) {
            return d2;
        }
        e eVar = this.g;
        LayerDrawable layerDrawable = null;
        if (eVar != null) {
            AppCompatDrawableManager.a aVar = (AppCompatDrawableManager.a) eVar;
            if (i2 == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R.drawable.abc_cab_background_internal_bg), getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable d(@NonNull Context context, long j2) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j2);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.drawable.Drawable e(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.DrawableRes int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0006
            goto L_0x002a
        L_0x0006:
            r0 = 1
            r4.f = r0     // Catch:{ all -> 0x0047 }
            int r1 = androidx.appcompat.resources.R.drawable.abc_vector_test     // Catch:{ all -> 0x0047 }
            android.graphics.drawable.Drawable r1 = r4.getDrawable(r5, r1)     // Catch:{ all -> 0x0047 }
            r2 = 0
            if (r1 == 0) goto L_0x0049
            boolean r3 = r1 instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat     // Catch:{ all -> 0x0047 }
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0047 }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0049
        L_0x002a:
            android.graphics.drawable.Drawable r0 = r4.g(r5, r6)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0034
            android.graphics.drawable.Drawable r0 = r4.c(r5, r6)     // Catch:{ all -> 0x0047 }
        L_0x0034:
            if (r0 != 0) goto L_0x003a
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r5, r6)     // Catch:{ all -> 0x0047 }
        L_0x003a:
            if (r0 == 0) goto L_0x0040
            android.graphics.drawable.Drawable r0 = r4.h(r5, r6, r7, r0)     // Catch:{ all -> 0x0047 }
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            androidx.appcompat.widget.DrawableUtils.a(r0)     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r4)
            return r0
        L_0x0047:
            r5 = move-exception
            goto L_0x0053
        L_0x0049:
            r4.f = r2
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r5.<init>(r6)
            throw r5
        L_0x0053:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.e(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public synchronized ColorStateList f(@NonNull Context context, @DrawableRes int i2) {
        ColorStateList colorStateList;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.a;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) ? null : sparseArrayCompat.get(i2);
        if (colorStateList == null) {
            e eVar = this.g;
            if (eVar != null) {
                colorStateList2 = ((AppCompatDrawableManager.a) eVar).c(context, i2);
            }
            if (colorStateList2 != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap<>();
                }
                SparseArrayCompat<ColorStateList> sparseArrayCompat2 = this.a.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat<>();
                    this.a.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.append(i2, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    public final Drawable g(@NonNull Context context, @DrawableRes int i2) {
        XmlResourceParser xml;
        int next;
        SimpleArrayMap<String, d> simpleArrayMap = this.b;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.c;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.b.get(str) == null)) {
                return null;
            }
        } else {
            this.c = new SparseArrayCompat<>();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable d2 = d(context, j2);
        if (d2 != null) {
            return d2;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                if (next == 2) {
                    String name = xml.getName();
                    this.c.append(i2, name);
                    d dVar = this.b.get(name);
                    if (dVar != null) {
                        d2 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (d2 != null) {
                        d2.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, j2, d2);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception unused) {
            }
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
        }
        if (d2 == null) {
            this.c.append(i2, "appcompat_skip_skip");
        }
        return d2;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        return e(context, i2, false);
    }

    public final Drawable h(@NonNull Context context, @DrawableRes int i2, boolean z, @NonNull Drawable drawable) {
        ColorStateList f2 = f(context, i2);
        PorterDuff.Mode mode = null;
        if (f2 != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, f2);
            e eVar = this.g;
            if (eVar != null) {
                AppCompatDrawableManager.a aVar = (AppCompatDrawableManager.a) eVar;
                if (i2 == R.drawable.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, mode);
            return wrap;
        }
        e eVar2 = this.g;
        if (eVar2 != null) {
            AppCompatDrawableManager.a aVar2 = (AppCompatDrawableManager.a) eVar2;
            Objects.requireNonNull(aVar2);
            boolean z2 = true;
            if (i2 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i3 = R.attr.colorControlNormal;
                int themeAttrColor = ThemeUtils.getThemeAttrColor(context, i3);
                PorterDuff.Mode mode2 = AppCompatDrawableManager.b;
                aVar2.d(findDrawableByLayerId, themeAttrColor, mode2);
                aVar2.d(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, i3), mode2);
                aVar2.d(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode2);
            } else if (i2 == R.drawable.abc_ratingbar_material || i2 == R.drawable.abc_ratingbar_indicator_material || i2 == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = AppCompatDrawableManager.b;
                aVar2.d(findDrawableByLayerId2, disabledThemeAttrColor, mode3);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i4 = R.attr.colorControlActivated;
                aVar2.d(findDrawableByLayerId3, ThemeUtils.getThemeAttrColor(context, i4), mode3);
                aVar2.d(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, i4), mode3);
            } else {
                z2 = false;
            }
            if (z2) {
                return drawable;
            }
        }
        if (i(context, i2, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.DrawableRes int r9, @androidx.annotation.NonNull android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            androidx.appcompat.widget.ResourceManagerInternal$e r0 = r7.g
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x006e
            androidx.appcompat.widget.AppCompatDrawableManager$a r0 = (androidx.appcompat.widget.AppCompatDrawableManager.a) r0
            java.util.Objects.requireNonNull(r0)
            android.graphics.PorterDuff$Mode r3 = androidx.appcompat.widget.AppCompatDrawableManager.b
            int[] r4 = r0.a
            boolean r4 = r0.a(r4, r9)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            r6 = -1
            if (r4 == 0) goto L_0x001c
            int r5 = androidx.appcompat.R.attr.colorControlNormal
            goto L_0x0045
        L_0x001c:
            int[] r4 = r0.c
            boolean r4 = r0.a(r4, r9)
            if (r4 == 0) goto L_0x0027
            int r5 = androidx.appcompat.R.attr.colorControlActivated
            goto L_0x0045
        L_0x0027:
            int[] r4 = r0.d
            boolean r0 = r0.a(r4, r9)
            if (r0 == 0) goto L_0x0032
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0045
        L_0x0032:
            int r0 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r9 != r0) goto L_0x0041
            r9 = 16842800(0x1010030, float:2.3693693E-38)
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            goto L_0x0047
        L_0x0041:
            int r0 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r9 != r0) goto L_0x0049
        L_0x0045:
            r9 = r5
            r0 = -1
        L_0x0047:
            r4 = 1
            goto L_0x004c
        L_0x0049:
            r9 = 0
            r0 = -1
            r4 = 0
        L_0x004c:
            if (r4 == 0) goto L_0x006a
            boolean r4 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r10)
            if (r4 == 0) goto L_0x0058
            android.graphics.drawable.Drawable r10 = r10.mutate()
        L_0x0058:
            int r8 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r8, r3)
            r10.setColorFilter(r8)
            if (r0 == r6) goto L_0x0068
            r10.setAlpha(r0)
        L_0x0068:
            r8 = 1
            goto L_0x006b
        L_0x006a:
            r8 = 0
        L_0x006b:
            if (r8 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.d.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public synchronized void setHooks(e eVar) {
        this.g = eVar;
    }
}
