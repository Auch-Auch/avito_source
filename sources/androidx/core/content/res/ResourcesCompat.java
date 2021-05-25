package androidx.core.content.res;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
public final class ResourcesCompat {
    @AnyRes
    public static final int ID_NULL = 0;

    public static abstract class FontCallback {

        public class a implements Runnable {
            public final /* synthetic */ Typeface a;

            public a(Typeface typeface) {
                this.a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                FontCallback.this.onFontRetrieved(this.a);
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                FontCallback.this.onFontRetrievalFailed(this.a);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new b(i));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(Typeface typeface, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new a(typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        public static class a {
            public static final Object a = new Object();
            public static Method b;
            public static boolean c;
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                theme.rebase();
            } else if (i >= 23) {
                synchronized (a.a) {
                    if (!a.c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            a.b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        a.c = true;
                    }
                    Method method = a.b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            a.b = null;
                        }
                    }
                }
            }
        }
    }

    public static Typeface a(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface findFromCache = TypefaceCompat.findFromCache(resources, i, i2);
                if (findFromCache != null) {
                    if (fontCallback != null) {
                        fontCallback.callbackSuccessAsync(findFromCache, handler);
                    }
                    typeface = findFromCache;
                } else {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i), resources);
                            if (parse != null) {
                                typeface = TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                            } else if (fontCallback != null) {
                                fontCallback.callbackFailAsync(-3, handler);
                            }
                        } else {
                            Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i, charSequence2, i2);
                            if (fontCallback != null) {
                                if (createFromResourcesFontFile != null) {
                                    fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                                } else {
                                    fontCallback.callbackFailAsync(-3, handler);
                                }
                            }
                            typeface = createFromResourcesFontFile;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(-3, handler);
                        }
                    }
                }
            } else if (fontCallback != null) {
                fontCallback.callbackFailAsync(-3, handler);
            }
            if (typeface != null || fontCallback != null) {
                return typeface;
            }
            StringBuilder L = a.L("Font resource ID #0x");
            L.append(Integer.toHexString(i));
            L.append(" could not be retrieved.");
            throw new Resources.NotFoundException(L.toString());
        }
        StringBuilder L2 = a.L("Resource \"");
        L2.append(resources.getResourceName(i));
        L2.append("\" (");
        L2.append(Integer.toHexString(i));
        L2.append(") is not a Font: ");
        L2.append(typedValue);
        throw new Resources.NotFoundException(L2.toString());
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i, theme);
        }
        return resources.getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        return resources.getColorStateList(i);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawable(i, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawableForDensity(i, i2, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
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

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, new TypedValue(), 0, null, null, false);
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            a(context, i, new TypedValue(), 0, fontCallback, handler, false);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, fontCallback, null, true);
    }
}
