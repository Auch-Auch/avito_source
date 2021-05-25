package l6.z;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class v {
    public static Method a;
    public static boolean b;
    public static Field c;
    public static boolean d;

    public void a(@NonNull View view) {
        throw null;
    }

    public float b(@NonNull View view) {
        throw null;
    }

    public void c(@NonNull View view) {
        throw null;
    }

    public void d(@NonNull View view, @Nullable Matrix matrix) {
        throw null;
    }

    public void e(@NonNull View view, int i, int i2, int i3, int i4) {
        if (!b) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            b = true;
        }
        Method method = a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void f(@NonNull View view, float f) {
        throw null;
    }

    public void g(@NonNull View view, int i) {
        if (!d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            d = true;
        }
        Field field = c;
        if (field != null) {
            try {
                c.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }

    public void i(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }
}
