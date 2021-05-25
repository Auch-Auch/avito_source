package a2.j.b.d.v.l;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public class e {
    public static final d a = new a();
    public static final d b = new b();

    public static class a implements d {
        @Override // a2.j.b.d.v.l.d
        public f a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = n.f(f4, f6, f2, f3, f, true);
            float f9 = f8 / f4;
            float f10 = f8 / f6;
            return new f(f9, f10, f8, f5 * f9, f8, f7 * f10);
        }

        @Override // a2.j.b.d.v.l.d
        public boolean b(f fVar) {
            return fVar.d > fVar.f;
        }

        @Override // a2.j.b.d.v.l.d
        public void c(RectF rectF, float f, f fVar) {
            rectF.bottom -= Math.abs(fVar.f - fVar.d) * f;
        }
    }

    public static class b implements d {
        @Override // a2.j.b.d.v.l.d
        public f a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = n.f(f5, f7, f2, f3, f, true);
            float f9 = f8 / f5;
            float f10 = f8 / f7;
            return new f(f9, f10, f4 * f9, f8, f6 * f10, f8);
        }

        @Override // a2.j.b.d.v.l.d
        public boolean b(f fVar) {
            return fVar.c > fVar.e;
        }

        @Override // a2.j.b.d.v.l.d
        public void c(RectF rectF, float f, f fVar) {
            float abs = (Math.abs(fVar.e - fVar.c) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }
    }
}
