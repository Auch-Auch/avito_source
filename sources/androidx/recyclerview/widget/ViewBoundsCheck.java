package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class ViewBoundsCheck {
    public final b a;
    public a b = new a();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public static class a {
        public int a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public boolean a() {
            int i = this.a;
            if ((i & 7) != 0 && (i & (b(this.d, this.b) << 0)) == 0) {
                return false;
            }
            int i2 = this.a;
            if ((i2 & 112) != 0 && (i2 & (b(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.a;
            if ((i4 & 28672) == 0 || (i4 & (b(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    public interface b {
        View a(int i);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    public ViewBoundsCheck(b bVar) {
        this.a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.a.b();
        int c = this.a.c();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.a.a(i);
            int d = this.a.d(a3);
            int e = this.a.e(a3);
            a aVar = this.b;
            aVar.b = b2;
            aVar.c = c;
            aVar.d = d;
            aVar.e = e;
            if (i3 != 0) {
                aVar.a = 0;
                aVar.a = i3 | 0;
                if (aVar.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.b;
                aVar2.a = 0;
                aVar2.a = i4 | 0;
                if (aVar2.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.b;
        int b2 = this.a.b();
        int c = this.a.c();
        int d = this.a.d(view);
        int e = this.a.e(view);
        aVar.b = b2;
        aVar.c = c;
        aVar.d = d;
        aVar.e = e;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.b;
        aVar2.a = 0;
        aVar2.a = 0 | i;
        return aVar2.a();
    }
}
