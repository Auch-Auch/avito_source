package butterknife;

import a2.b.a.a.a;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
public final class ButterKnife {
    public static boolean a = false;
    @VisibleForTesting
    public static final Map<Class<?>, Constructor<? extends Unbinder>> b = new LinkedHashMap();

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @Nullable
    @CheckResult
    @UiThread
    public static Constructor<? extends Unbinder> a(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Map<Class<?>, Constructor<? extends Unbinder>> map = b;
        Constructor<? extends Unbinder> constructor2 = map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
        } catch (ClassNotFoundException unused) {
            if (a) {
                cls.getSuperclass().getName();
            }
            constructor = a(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(a.c3("Unable to find binding constructor for ", name), e);
        }
        b.put(cls, constructor);
        return constructor;
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Activity activity) {
        return bind(activity, activity.getWindow().getDecorView());
    }

    public static void setDebug(boolean z) {
        a = z;
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull View view) {
        return bind(view, view);
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Dialog dialog) {
        return bind(dialog, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    @NonNull
    @UiThread
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (a) {
            cls.getName();
        }
        Constructor<? extends Unbinder> a3 = a(cls);
        if (a3 == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) a3.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + a3, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + a3, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }
}
