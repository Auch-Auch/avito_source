package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    public static boolean b = false;
    public final WeakReference<Context> a;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return b;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        b = z;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable h;
        Context context = this.a.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        ResourceManagerInternal resourceManagerInternal = ResourceManagerInternal.get();
        synchronized (resourceManagerInternal) {
            Drawable g = resourceManagerInternal.g(context, i);
            if (g == null) {
                g = a(i);
            }
            h = g != null ? resourceManagerInternal.h(context, i, false, g) : null;
        }
        return h;
    }
}
