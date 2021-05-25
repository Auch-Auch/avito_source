package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import l6.b.d.q;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintContextWrapper extends ContextWrapper {
    public static final Object c = new Object();
    public static ArrayList<WeakReference<TintContextWrapper>> d;
    public final Resources a;
    public final Resources.Theme b;

    public TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.a = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.a = new q(this, context.getResources());
        this.b = null;
    }

    public static Context wrap(@NonNull Context context) {
        boolean z = false;
        if (!(context instanceof TintContextWrapper) && !(context.getResources() instanceof q) && !(context.getResources() instanceof VectorEnabledTintResources) && VectorEnabledTintResources.shouldBeUsed()) {
            z = true;
        }
        if (!z) {
            return context;
        }
        synchronized (c) {
            ArrayList<WeakReference<TintContextWrapper>> arrayList = d;
            if (arrayList == null) {
                d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<TintContextWrapper> weakReference = d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        d.remove(size);
                    }
                }
                for (int size2 = d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<TintContextWrapper> weakReference2 = d.get(size2);
                    TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            d.add(new WeakReference<>(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
