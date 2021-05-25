package butterknife.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import java.util.List;
import p6.b.b;
public final class Utils {
    public static final TypedValue a = new TypedValue();

    public Utils() {
        throw new AssertionError("No instances.");
    }

    public static String a(View view, @IdRes int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int length = tArr.length;
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                tArr[i] = t;
                i++;
            }
        }
        return i == length ? tArr : (T[]) Arrays.copyOf(tArr, i);
    }

    public static <T> T castParam(Object obj, String str, int i, String str2, int i2, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            StringBuilder L = a.L("Parameter #");
            L.append(i + 1);
            L.append(" of method '");
            L.append(str);
            L.append("' was of the wrong type for parameter #");
            L.append(i2 + 1);
            L.append(" of method '");
            throw new IllegalStateException(a.t(L, str2, "'. See cause for more info."), e);
        }
    }

    public static <T> T castView(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            throw new IllegalStateException(a.t(a.S("View '", a(view, i), "' with ID ", i, " for "), str, " was of the wrong type. See cause for more info."), e);
        }
    }

    public static <T> T findOptionalViewAsType(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) castView(view.findViewById(i), i, str, cls);
    }

    public static View findRequiredView(View view, @IdRes int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalStateException(a.t(a.S("Required view '", a(view, i), "' with ID ", i, " for "), str, " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."));
    }

    public static <T> T findRequiredViewAsType(View view, @IdRes int i, String str, Class<T> cls) {
        return (T) castView(findRequiredView(view, i, str), i, str, cls);
    }

    @UiThread
    public static float getFloat(Context context, @DimenRes int i) {
        TypedValue typedValue = a;
        context.getResources().getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        StringBuilder L = a.L("Resource ID #0x");
        L.append(Integer.toHexString(i));
        L.append(" type #0x");
        L.append(Integer.toHexString(typedValue.type));
        L.append(" is not valid");
        throw new Resources.NotFoundException(L.toString());
    }

    @UiThread
    public static Drawable getTintedDrawable(Context context, @DrawableRes int i, @AttrRes int i2) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = a;
        if (theme.resolveAttribute(i2, typedValue, true)) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i).mutate());
            DrawableCompat.setTint(wrap, ContextCompat.getColor(context, typedValue.resourceId));
            return wrap;
        }
        StringBuilder L = a.L("Required tint color attribute with name ");
        L.append(context.getResources().getResourceEntryName(i2));
        L.append(" and attribute ID ");
        L.append(i2);
        L.append(" was not found.");
        throw new Resources.NotFoundException(L.toString());
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new b(arrayFilteringNull(tArr));
    }
}
