package l6.z;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
public class p {
    public static final v a;
    public static final Property<View, Float> b = new a(Float.class, "translationAlpha");
    public static final Property<View, Rect> c = new b(Rect.class, "clipBounds");

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(p.a(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            p.a.f(view, floatValue);
        }
    }

    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new u();
        } else if (i >= 23) {
            a = new t();
        } else if (i >= 22) {
            a = new s();
        } else {
            a = new r();
        }
    }

    public static float a(@NonNull View view) {
        return a.b(view);
    }

    public static void b(@NonNull View view, int i, int i2, int i3, int i4) {
        a.e(view, i, i2, i3, i4);
    }
}
