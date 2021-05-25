package a2.e.a;

import a2.e.a.b;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import androidx.core.view.ViewCompat;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGExternalFileResolver;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
public class e {
    public static HashSet<String> i;
    public Canvas a;
    public float b;
    public SVG c;
    public h d;
    public Stack<h> e;
    public Stack<SVG.h0> f;
    public Stack<Matrix> g;
    public b.q h = null;

    public class b implements SVG.w {
        public List<c> a = new ArrayList();
        public float b;
        public float c;
        public c d = null;
        public boolean e = false;
        public boolean f = true;
        public int g = -1;
        public boolean h;

        public b(SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
                if (this.h) {
                    this.d.b(this.a.get(this.g));
                    this.a.set(this.g, this.d);
                    this.h = false;
                }
                c cVar = this.d;
                if (cVar != null) {
                    this.a.add(cVar);
                }
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
            this.b = f2;
            this.c = f3;
            this.d = new c(e.this, f2, f3, 0.0f, 0.0f);
            this.g = this.a.size();
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            this.d.a(f2, f3);
            this.a.add(this.d);
            e eVar = e.this;
            c cVar = this.d;
            this.d = new c(eVar, f2, f3, f2 - cVar.a, f3 - cVar.b);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            this.d.a(f2, f3);
            this.a.add(this.d);
            this.d = new c(e.this, f4, f5, f4 - f2, f5 - f3);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            this.a.add(this.d);
            b(this.b, this.c);
            this.h = true;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            if (this.f || this.e) {
                this.d.a(f2, f3);
                this.a.add(this.d);
                this.e = false;
            }
            this.d = new c(e.this, f6, f7, f6 - f4, f7 - f5);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            this.e = true;
            this.f = false;
            c cVar = this.d;
            e.a(cVar.a, cVar.b, f2, f3, f4, z, z2, f5, f6, this);
            this.f = true;
            this.h = false;
        }
    }

    public class c {
        public float a;
        public float b;
        public float c = 0.0f;
        public float d = 0.0f;
        public boolean e = false;

        public c(e eVar, float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            double sqrt = Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
            if (sqrt != 0.0d) {
                this.c = (float) (((double) f3) / sqrt);
                this.d = (float) (((double) f4) / sqrt);
            }
        }

        public void a(float f, float f2) {
            float f3 = f - this.a;
            float f4 = f2 - this.b;
            double sqrt = Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
            if (sqrt != 0.0d) {
                f3 = (float) (((double) f3) / sqrt);
                f4 = (float) (((double) f4) / sqrt);
            }
            float f5 = this.c;
            if (f3 == (-f5) && f4 == (-this.d)) {
                this.e = true;
                this.c = -f4;
                this.d = f3;
                return;
            }
            this.c = f5 + f3;
            this.d += f4;
        }

        public void b(c cVar) {
            float f = cVar.c;
            float f2 = this.c;
            if (f == (-f2)) {
                float f3 = cVar.d;
                if (f3 == (-this.d)) {
                    this.e = true;
                    this.c = -f3;
                    this.d = cVar.c;
                    return;
                }
            }
            this.c = f2 + f;
            this.d += cVar.d;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("(");
            L.append(this.a);
            L.append(",");
            L.append(this.b);
            L.append(" ");
            L.append(this.c);
            L.append(",");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    public class d implements SVG.w {
        public Path a = new Path();
        public float b;
        public float c;

        public d(e eVar, SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            this.a.moveTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            this.a.lineTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            this.a.quadTo(f, f2, f3, f4);
            this.b = f3;
            this.c = f4;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            this.a.close();
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            this.a.cubicTo(f, f2, f3, f4, f5, f6);
            this.b = f5;
            this.c = f6;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            e.a(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
            this.b = f4;
            this.c = f5;
        }
    }

    /* renamed from: a2.e.a.e$e  reason: collision with other inner class name */
    public class C0021e extends f {
        public Path d;

        public C0021e(Path path, float f, float f2) {
            super(f, f2);
            this.d = path;
        }

        @Override // a2.e.a.e.f, a2.e.a.e.j
        public void b(String str) {
            if (e.this.Y()) {
                e eVar = e.this;
                h hVar = eVar.d;
                if (hVar.b) {
                    eVar.a.drawTextOnPath(str, this.d, this.a, this.b, hVar.d);
                }
                e eVar2 = e.this;
                h hVar2 = eVar2.d;
                if (hVar2.c) {
                    eVar2.a.drawTextOnPath(str, this.d, this.a, this.b, hVar2.e);
                }
            }
            this.a = e.this.d.d.measureText(str) + this.a;
        }
    }

    public class f extends j {
        public float a;
        public float b;

        public f(float f, float f2) {
            super(e.this, null);
            this.a = f;
            this.b = f2;
        }

        @Override // a2.e.a.e.j
        public void b(String str) {
            if (e.this.Y()) {
                e eVar = e.this;
                h hVar = eVar.d;
                if (hVar.b) {
                    eVar.a.drawText(str, this.a, this.b, hVar.d);
                }
                e eVar2 = e.this;
                h hVar2 = eVar2.d;
                if (hVar2.c) {
                    eVar2.a.drawText(str, this.a, this.b, hVar2.e);
                }
            }
            this.a = e.this.d.d.measureText(str) + this.a;
        }
    }

    public class g extends j {
        public float a;
        public float b;
        public Path c;

        public g(float f, float f2, Path path) {
            super(e.this, null);
            this.a = f;
            this.b = f2;
            this.c = path;
        }

        @Override // a2.e.a.e.j
        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            String.format("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // a2.e.a.e.j
        public void b(String str) {
            if (e.this.Y()) {
                Path path = new Path();
                e.this.d.d.getTextPath(str, 0, str.length(), this.a, this.b, path);
                this.c.addPath(path);
            }
            this.a = e.this.d.d.measureText(str) + this.a;
        }
    }

    public class i extends j {
        public float a;
        public float b;
        public RectF c = new RectF();

        public i(float f, float f2) {
            super(e.this, null);
            this.a = f;
            this.b = f2;
        }

        @Override // a2.e.a.e.j
        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            SVG.x0 x0Var = (SVG.x0) w0Var;
            SVG.l0 e = w0Var.a.e(x0Var.n);
            if (e == null) {
                String.format("TextPath path reference '%s' not found", x0Var.n);
                return false;
            }
            SVG.u uVar = (SVG.u) e;
            Path path = new d(e.this, uVar.o).a;
            Matrix matrix = uVar.n;
            if (matrix != null) {
                path.transform(matrix);
            }
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            this.c.union(rectF);
            return false;
        }

        @Override // a2.e.a.e.j
        public void b(String str) {
            if (e.this.Y()) {
                Rect rect = new Rect();
                e.this.d.d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.a, this.b);
                this.c.union(rectF);
            }
            this.a = e.this.d.d.measureText(str) + this.a;
        }
    }

    public abstract class j {
        public j(e eVar, a aVar) {
        }

        public boolean a(SVG.w0 w0Var) {
            return true;
        }

        public abstract void b(String str);
    }

    public class k extends j {
        public float a = 0.0f;

        public k(a aVar) {
            super(e.this, null);
        }

        @Override // a2.e.a.e.j
        public void b(String str) {
            this.a = e.this.d.d.measureText(str) + this.a;
        }
    }

    public e(Canvas canvas, float f2) {
        this.a = canvas;
        this.b = f2;
    }

    public static void a(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        SVG.w wVar2;
        float f9;
        float f10;
        double d2;
        if (!(f2 == f7 && f3 == f8)) {
            if (f4 == 0.0f) {
                f9 = f7;
                wVar2 = wVar;
            } else if (f5 == 0.0f) {
                wVar2 = wVar;
                f9 = f7;
            } else {
                float abs = Math.abs(f4);
                float abs2 = Math.abs(f5);
                double radians = (double) ((float) Math.toRadians(((double) f6) % 360.0d));
                float cos = (float) Math.cos(radians);
                float sin = (float) Math.sin(radians);
                float f11 = (f2 - f7) / 2.0f;
                float f12 = (f3 - f8) / 2.0f;
                float f13 = (sin * f12) + (cos * f11);
                float f14 = (f12 * cos) + ((-sin) * f11);
                float f15 = abs * abs;
                float f16 = abs2 * abs2;
                float f17 = f13 * f13;
                float f18 = f14 * f14;
                float f19 = (f18 / f16) + (f17 / f15);
                if (f19 > 1.0f) {
                    double d3 = (double) f19;
                    f10 = cos;
                    abs *= (float) Math.sqrt(d3);
                    abs2 *= (float) Math.sqrt(d3);
                    f15 = abs * abs;
                    f16 = abs2 * abs2;
                } else {
                    f10 = cos;
                }
                float f20 = z == z2 ? -1.0f : 1.0f;
                float f21 = f15 * f16;
                float f22 = f15 * f18;
                float f23 = f16 * f17;
                float f24 = ((f21 - f22) - f23) / (f22 + f23);
                if (f24 < 0.0f) {
                    f24 = 0.0f;
                }
                float sqrt = (float) (Math.sqrt((double) f24) * ((double) f20));
                float f25 = ((abs * f14) / abs2) * sqrt;
                float f26 = sqrt * (-((abs2 * f13) / abs));
                float f27 = ((f10 * f25) - (sin * f26)) + ((f2 + f7) / 2.0f);
                float f28 = (f10 * f26) + (sin * f25) + ((f3 + f8) / 2.0f);
                float f29 = (f13 - f25) / abs;
                float f30 = (f14 - f26) / abs2;
                float f31 = ((-f13) - f25) / abs;
                float f32 = ((-f14) - f26) / abs2;
                float f33 = (f30 * f30) + (f29 * f29);
                float degrees = (float) Math.toDegrees(Math.acos((double) (f29 / ((float) Math.sqrt((double) f33)))) * ((double) (f30 < 0.0f ? -1.0f : 1.0f)));
                double degrees2 = Math.toDegrees(Math.acos((double) (((f30 * f32) + (f29 * f31)) / ((float) Math.sqrt((double) (((f32 * f32) + (f31 * f31)) * f33))))) * ((double) ((f29 * f32) - (f30 * f31) < 0.0f ? -1.0f : 1.0f)));
                if (z2 || degrees2 <= 0.0d) {
                    d2 = 360.0d;
                    if (z2 && degrees2 < 0.0d) {
                        degrees2 += 360.0d;
                    }
                } else {
                    d2 = 360.0d;
                    degrees2 -= 360.0d;
                }
                double d4 = degrees2 % d2;
                int ceil = (int) Math.ceil(Math.abs(d4) / 90.0d);
                double radians2 = Math.toRadians((double) (degrees % 360.0f));
                float radians3 = (float) (Math.toRadians(d4) / ((double) ceil));
                double d5 = (double) radians3;
                double d6 = d5 / 2.0d;
                double sin2 = (Math.sin(d6) * 1.3333333333333333d) / (Math.cos(d6) + 1.0d);
                int i2 = ceil * 6;
                float[] fArr = new float[i2];
                int i3 = 0;
                int i4 = 0;
                while (i3 < ceil) {
                    double d7 = ((double) (((float) i3) * radians3)) + radians2;
                    double cos2 = Math.cos(d7);
                    double sin3 = Math.sin(d7);
                    int i5 = i4 + 1;
                    fArr[i4] = (float) (cos2 - (sin2 * sin3));
                    int i6 = i5 + 1;
                    fArr[i5] = (float) ((cos2 * sin2) + sin3);
                    double d8 = d7 + d5;
                    double cos3 = Math.cos(d8);
                    double sin4 = Math.sin(d8);
                    int i7 = i6 + 1;
                    fArr[i6] = (float) ((sin2 * sin4) + cos3);
                    int i8 = i7 + 1;
                    fArr[i7] = (float) (sin4 - (sin2 * cos3));
                    int i9 = i8 + 1;
                    fArr[i8] = (float) cos3;
                    fArr[i9] = (float) sin4;
                    i3++;
                    f27 = f27;
                    i2 = i2;
                    radians3 = radians3;
                    ceil = ceil;
                    d5 = d5;
                    i4 = i9 + 1;
                    radians2 = radians2;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(abs, abs2);
                matrix.postRotate(f6);
                matrix.postTranslate(f27, f28);
                matrix.mapPoints(fArr);
                fArr[i2 - 2] = f7;
                fArr[i2 - 1] = f8;
                for (int i10 = 0; i10 < i2; i10 += 6) {
                    wVar.d(fArr[i10], fArr[i10 + 1], fArr[i10 + 2], fArr[i10 + 3], fArr[i10 + 4], fArr[i10 + 5]);
                }
                return;
            }
            wVar2.b(f9, f8);
        }
    }

    public static int j(float f2) {
        int i2 = (int) (f2 * 256.0f);
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    public static int k(int i2, float f2) {
        int i3 = 255;
        int round = Math.round(((float) ((i2 >> 24) & 255)) * f2);
        if (round < 0) {
            i3 = 0;
        } else if (round <= 255) {
            i3 = round;
        }
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | (i3 << 24);
    }

    public final Path A(SVG.c cVar) {
        SVG.o oVar = cVar.o;
        float f2 = 0.0f;
        float d2 = oVar != null ? oVar.d(this) : 0.0f;
        SVG.o oVar2 = cVar.p;
        if (oVar2 != null) {
            f2 = oVar2.e(this);
        }
        float b2 = cVar.q.b(this);
        float f3 = d2 - b2;
        float f4 = f2 - b2;
        float f5 = d2 + b2;
        float f6 = f2 + b2;
        if (cVar.h == null) {
            float f7 = 2.0f * b2;
            cVar.h = new SVG.a(f3, f4, f7, f7);
        }
        float f8 = 0.5522848f * b2;
        Path path = new Path();
        path.moveTo(d2, f4);
        float f9 = d2 + f8;
        float f10 = f2 - f8;
        path.cubicTo(f9, f4, f5, f10, f5, f2);
        float f11 = f2 + f8;
        path.cubicTo(f5, f11, f9, f6, d2, f6);
        float f12 = d2 - f8;
        path.cubicTo(f12, f6, f3, f11, f3, f2);
        path.cubicTo(f3, f10, f12, f4, d2, f4);
        path.close();
        return path;
    }

    public final Path B(SVG.h hVar) {
        SVG.o oVar = hVar.o;
        float f2 = 0.0f;
        float d2 = oVar != null ? oVar.d(this) : 0.0f;
        SVG.o oVar2 = hVar.p;
        if (oVar2 != null) {
            f2 = oVar2.e(this);
        }
        float d3 = hVar.q.d(this);
        float e2 = hVar.r.e(this);
        float f3 = d2 - d3;
        float f4 = f2 - e2;
        float f5 = d2 + d3;
        float f6 = f2 + e2;
        if (hVar.h == null) {
            hVar.h = new SVG.a(f3, f4, d3 * 2.0f, 2.0f * e2);
        }
        float f7 = d3 * 0.5522848f;
        float f8 = 0.5522848f * e2;
        Path path = new Path();
        path.moveTo(d2, f4);
        float f9 = d2 + f7;
        float f10 = f2 - f8;
        path.cubicTo(f9, f4, f5, f10, f5, f2);
        float f11 = f8 + f2;
        path.cubicTo(f5, f11, f9, f6, d2, f6);
        float f12 = d2 - f7;
        path.cubicTo(f12, f6, f3, f11, f3, f2);
        path.cubicTo(f3, f10, f12, f4, d2, f4);
        path.close();
        return path;
    }

    public final Path C(SVG.y yVar) {
        Path path = new Path();
        float[] fArr = yVar.o;
        path.moveTo(fArr[0], fArr[1]);
        int i2 = 2;
        while (true) {
            float[] fArr2 = yVar.o;
            if (i2 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
            i2 += 2;
        }
        if (yVar instanceof SVG.z) {
            path.close();
        }
        if (yVar.h == null) {
            yVar.h = c(path);
        }
        return path;
    }

    public final Path D(SVG.a0 a0Var) {
        float f2;
        float f3;
        Path path;
        SVG.o oVar = a0Var.s;
        if (oVar == null && a0Var.t == null) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            if (oVar == null) {
                f3 = a0Var.t.e(this);
            } else if (a0Var.t == null) {
                f3 = oVar.d(this);
            } else {
                f3 = oVar.d(this);
                f2 = a0Var.t.e(this);
            }
            f2 = f3;
        }
        float min = Math.min(f3, a0Var.q.d(this) / 2.0f);
        float min2 = Math.min(f2, a0Var.r.e(this) / 2.0f);
        SVG.o oVar2 = a0Var.o;
        float d2 = oVar2 != null ? oVar2.d(this) : 0.0f;
        SVG.o oVar3 = a0Var.p;
        float e2 = oVar3 != null ? oVar3.e(this) : 0.0f;
        float d3 = a0Var.q.d(this);
        float e3 = a0Var.r.e(this);
        if (a0Var.h == null) {
            a0Var.h = new SVG.a(d2, e2, d3, e3);
        }
        float f4 = d2 + d3;
        float f5 = e2 + e3;
        Path path2 = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path = path2;
            path.moveTo(d2, e2);
            path.lineTo(f4, e2);
            path.lineTo(f4, f5);
            path.lineTo(d2, f5);
            path.lineTo(d2, e2);
        } else {
            float f6 = min * 0.5522848f;
            float f7 = 0.5522848f * min2;
            float f8 = e2 + min2;
            path2.moveTo(d2, f8);
            float f9 = f8 - f7;
            float f10 = d2 + min;
            float f11 = f10 - f6;
            path2.cubicTo(d2, f9, f11, e2, f10, e2);
            float f12 = f4 - min;
            path2.lineTo(f12, e2);
            float f13 = f12 + f6;
            path2.cubicTo(f13, e2, f4, f9, f4, f8);
            float f14 = f5 - min2;
            path2.lineTo(f4, f14);
            float f15 = f14 + f7;
            path = path2;
            path2.cubicTo(f4, f15, f13, f5, f12, f5);
            path.lineTo(f10, f5);
            path.cubicTo(f11, f5, d2, f15, d2, f14);
            path.lineTo(d2, f8);
        }
        path.close();
        return path;
    }

    public final SVG.a E(SVG.o oVar, SVG.o oVar2, SVG.o oVar3, SVG.o oVar4) {
        float f2 = 0.0f;
        float d2 = oVar != null ? oVar.d(this) : 0.0f;
        if (oVar2 != null) {
            f2 = oVar2.e(this);
        }
        SVG.a y = y();
        return new SVG.a(d2, f2, oVar3 != null ? oVar3.d(this) : y.c, oVar4 != null ? oVar4.e(this) : y.d);
    }

    @TargetApi(19)
    public final Path F(SVG.i0 i0Var, boolean z) {
        Path path;
        Path b2;
        this.e.push(this.d);
        h hVar = new h(this, this.d);
        this.d = hVar;
        W(hVar, i0Var);
        if (!m() || !Y()) {
            this.d = this.e.pop();
            return null;
        }
        if (i0Var instanceof SVG.c1) {
            if (!z) {
                String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.c1 c1Var = (SVG.c1) i0Var;
            SVG.l0 e2 = i0Var.a.e(c1Var.o);
            if (e2 == null) {
                String.format("Use reference '%s' not found", c1Var.o);
                this.d = this.e.pop();
                return null;
            } else if (!(e2 instanceof SVG.i0)) {
                this.d = this.e.pop();
                return null;
            } else {
                path = F((SVG.i0) e2, false);
                if (path == null) {
                    return null;
                }
                if (c1Var.h == null) {
                    c1Var.h = c(path);
                }
                Matrix matrix = c1Var.n;
                if (matrix != null) {
                    path.transform(matrix);
                }
            }
        } else if (i0Var instanceof SVG.k) {
            SVG.k kVar = (SVG.k) i0Var;
            if (i0Var instanceof SVG.u) {
                path = new d(this, ((SVG.u) i0Var).o).a;
                if (i0Var.h == null) {
                    i0Var.h = c(path);
                }
            } else {
                path = i0Var instanceof SVG.a0 ? D((SVG.a0) i0Var) : i0Var instanceof SVG.c ? A((SVG.c) i0Var) : i0Var instanceof SVG.h ? B((SVG.h) i0Var) : i0Var instanceof SVG.y ? C((SVG.y) i0Var) : null;
            }
            if (path == null) {
                return null;
            }
            if (kVar.h == null) {
                kVar.h = c(path);
            }
            Matrix matrix2 = kVar.n;
            if (matrix2 != null) {
                path.transform(matrix2);
            }
            path.setFillType(x());
        } else if (i0Var instanceof SVG.u0) {
            SVG.u0 u0Var = (SVG.u0) i0Var;
            List<SVG.o> list = u0Var.n;
            float f2 = 0.0f;
            float d2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).d(this);
            List<SVG.o> list2 = u0Var.o;
            float e3 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).e(this);
            List<SVG.o> list3 = u0Var.p;
            float d3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).d(this);
            List<SVG.o> list4 = u0Var.q;
            if (!(list4 == null || list4.size() == 0)) {
                f2 = u0Var.q.get(0).e(this);
            }
            if (this.d.a.u != SVG.Style.TextAnchor.Start) {
                k kVar2 = new k(null);
                p(u0Var, kVar2);
                float f3 = kVar2.a;
                if (this.d.a.u == SVG.Style.TextAnchor.Middle) {
                    f3 /= 2.0f;
                }
                d2 -= f3;
            }
            if (u0Var.h == null) {
                i iVar = new i(d2, e3);
                p(u0Var, iVar);
                RectF rectF = iVar.c;
                u0Var.h = new SVG.a(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            Path path2 = new Path();
            p(u0Var, new g(d2 + d3, e3 + f2, path2));
            Matrix matrix3 = u0Var.r;
            if (matrix3 != null) {
                path2.transform(matrix3);
            }
            path2.setFillType(x());
            path = path2;
        } else {
            String.format("Invalid %s element found in clipPath definition", i0Var.getClass().getSimpleName());
            return null;
        }
        if (!(this.d.a.E == null || (b2 = b(i0Var, i0Var.h)) == null)) {
            path.op(b2, Path.Op.INTERSECT);
        }
        this.d = this.e.pop();
        return path;
    }

    public final void G(SVG.i0 i0Var) {
        if (this.d.a.G != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.a.saveLayer(null, paint2, 31);
            SVG.r rVar = (SVG.r) this.c.e(this.d.a.G);
            O(rVar, i0Var);
            this.a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint3, 31);
            O(rVar, i0Var);
            this.a.restore();
            this.a.restore();
        }
        R();
    }

    public final boolean H() {
        SVG.l0 e2;
        if (!(this.d.a.m.floatValue() < 1.0f || this.d.a.G != null)) {
            return false;
        }
        this.a.saveLayerAlpha(null, j(this.d.a.m.floatValue()), 31);
        this.e.push(this.d);
        h hVar = new h(this, this.d);
        this.d = hVar;
        String str = hVar.a.G;
        if (str != null && ((e2 = this.c.e(str)) == null || !(e2 instanceof SVG.r))) {
            String.format("Mask reference '%s' not found", this.d.a.G);
            this.d.a.G = null;
        }
        return true;
    }

    public final void I(SVG.d0 d0Var, SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        if (aVar.c != 0.0f && aVar.d != 0.0f) {
            if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
            }
            W(this.d, d0Var);
            if (m()) {
                h hVar = this.d;
                hVar.f = aVar;
                if (!hVar.a.v.booleanValue()) {
                    SVG.a aVar3 = this.d.f;
                    P(aVar3.a, aVar3.b, aVar3.c, aVar3.d);
                }
                f(d0Var, this.d.f);
                if (aVar2 != null) {
                    this.a.concat(e(this.d.f, aVar2, preserveAspectRatio));
                    this.d.g = d0Var.o;
                } else {
                    Canvas canvas = this.a;
                    SVG.a aVar4 = this.d.f;
                    canvas.translate(aVar4.a, aVar4.b);
                }
                boolean H = H();
                X();
                K(d0Var, true);
                if (H) {
                    G(d0Var);
                }
                U(d0Var);
            }
        }
    }

    public final void J(SVG.l0 l0Var) {
        Path.FillType fillType;
        Path.FillType fillType2;
        SVG.o oVar;
        String str;
        int indexOf;
        SVG.l0 next;
        Set<String> f2;
        SVG.o oVar2;
        if (!(l0Var instanceof SVG.s)) {
            S();
            i(l0Var);
            if (l0Var instanceof SVG.d0) {
                SVG.d0 d0Var = (SVG.d0) l0Var;
                I(d0Var, E(d0Var.p, d0Var.q, d0Var.r, d0Var.s), d0Var.o, d0Var.n);
            } else {
                Bitmap bitmap = null;
                int i2 = 0;
                float f3 = 0.0f;
                if (l0Var instanceof SVG.c1) {
                    SVG.c1 c1Var = (SVG.c1) l0Var;
                    SVG.b1 b1Var = SVG.b1.percent;
                    SVG.o oVar3 = c1Var.r;
                    if ((oVar3 == null || !oVar3.g()) && ((oVar2 = c1Var.s) == null || !oVar2.g())) {
                        W(this.d, c1Var);
                        if (m()) {
                            SVG.l0 e2 = c1Var.a.e(c1Var.o);
                            if (e2 == null) {
                                String.format("Use reference '%s' not found", c1Var.o);
                            } else {
                                Matrix matrix = c1Var.n;
                                if (matrix != null) {
                                    this.a.concat(matrix);
                                }
                                SVG.o oVar4 = c1Var.p;
                                float d2 = oVar4 != null ? oVar4.d(this) : 0.0f;
                                SVG.o oVar5 = c1Var.q;
                                this.a.translate(d2, oVar5 != null ? oVar5.e(this) : 0.0f);
                                f(c1Var, c1Var.h);
                                boolean H = H();
                                this.f.push(c1Var);
                                this.g.push(this.a.getMatrix());
                                if (e2 instanceof SVG.d0) {
                                    SVG.d0 d0Var2 = (SVG.d0) e2;
                                    SVG.a E = E(null, null, c1Var.r, c1Var.s);
                                    S();
                                    I(d0Var2, E, d0Var2.o, d0Var2.n);
                                    R();
                                } else if (e2 instanceof SVG.r0) {
                                    SVG.o oVar6 = c1Var.r;
                                    if (oVar6 == null) {
                                        oVar6 = new SVG.o(100.0f, b1Var);
                                    }
                                    SVG.o oVar7 = c1Var.s;
                                    if (oVar7 == null) {
                                        oVar7 = new SVG.o(100.0f, b1Var);
                                    }
                                    SVG.a E2 = E(null, null, oVar6, oVar7);
                                    S();
                                    SVG.r0 r0Var = (SVG.r0) e2;
                                    if (!(E2.c == 0.0f || E2.d == 0.0f)) {
                                        PreserveAspectRatio preserveAspectRatio = r0Var.n;
                                        if (preserveAspectRatio == null) {
                                            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                                        }
                                        W(this.d, r0Var);
                                        h hVar = this.d;
                                        hVar.f = E2;
                                        if (!hVar.a.v.booleanValue()) {
                                            SVG.a aVar = this.d.f;
                                            P(aVar.a, aVar.b, aVar.c, aVar.d);
                                        }
                                        SVG.a aVar2 = r0Var.o;
                                        if (aVar2 != null) {
                                            this.a.concat(e(this.d.f, aVar2, preserveAspectRatio));
                                            this.d.g = r0Var.o;
                                        } else {
                                            Canvas canvas = this.a;
                                            SVG.a aVar3 = this.d.f;
                                            canvas.translate(aVar3.a, aVar3.b);
                                        }
                                        boolean H2 = H();
                                        K(r0Var, true);
                                        if (H2) {
                                            G(r0Var);
                                        }
                                        U(r0Var);
                                    }
                                    R();
                                } else {
                                    J(e2);
                                }
                                this.f.pop();
                                this.g.pop();
                                if (H) {
                                    G(c1Var);
                                }
                                U(c1Var);
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.q0) {
                    SVG.q0 q0Var = (SVG.q0) l0Var;
                    W(this.d, q0Var);
                    if (m()) {
                        Matrix matrix2 = q0Var.n;
                        if (matrix2 != null) {
                            this.a.concat(matrix2);
                        }
                        f(q0Var, q0Var.h);
                        boolean H3 = H();
                        String language = Locale.getDefault().getLanguage();
                        SVGExternalFileResolver sVGExternalFileResolver = SVG.g;
                        Iterator<SVG.l0> it = q0Var.i.iterator();
                        loop0:
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            next = it.next();
                            if (next instanceof SVG.e0) {
                                SVG.e0 e0Var = (SVG.e0) next;
                                if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                                    Set<String> requiredFeatures = e0Var.getRequiredFeatures();
                                    if (requiredFeatures != null) {
                                        if (i == null) {
                                            synchronized (e.class) {
                                                HashSet<String> hashSet = new HashSet<>();
                                                i = hashSet;
                                                hashSet.add("Structure");
                                                i.add("BasicStructure");
                                                i.add("ConditionalProcessing");
                                                i.add("Image");
                                                i.add("Style");
                                                i.add("ViewportAttribute");
                                                i.add("Shape");
                                                i.add("BasicText");
                                                i.add("PaintAttribute");
                                                i.add("BasicPaintAttribute");
                                                i.add("OpacityAttribute");
                                                i.add("BasicGraphicsAttribute");
                                                i.add("Marker");
                                                i.add("Gradient");
                                                i.add("Pattern");
                                                i.add("Clip");
                                                i.add("BasicClip");
                                                i.add("Mask");
                                                i.add("View");
                                            }
                                        }
                                        if (!requiredFeatures.isEmpty() && i.containsAll(requiredFeatures)) {
                                        }
                                    }
                                    Set<String> e3 = e0Var.e();
                                    if (e3 != null) {
                                        if (!e3.isEmpty() && sVGExternalFileResolver != null) {
                                            Iterator<String> it2 = e3.iterator();
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    if (!sVGExternalFileResolver.isFormatSupported(it2.next())) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    Set<String> l = e0Var.l();
                                    if (l == null) {
                                        break;
                                    } else if (!l.isEmpty() && sVGExternalFileResolver != null) {
                                        for (String str2 : l) {
                                            if (sVGExternalFileResolver.resolveFont(str2, this.d.a.q.intValue(), String.valueOf(this.d.a.r)) == null) {
                                            }
                                        }
                                        break loop0;
                                    }
                                }
                            }
                        }
                        J(next);
                        if (H3) {
                            G(q0Var);
                        }
                        U(q0Var);
                    }
                } else if (l0Var instanceof SVG.l) {
                    SVG.l lVar = (SVG.l) l0Var;
                    W(this.d, lVar);
                    if (m()) {
                        Matrix matrix3 = lVar.n;
                        if (matrix3 != null) {
                            this.a.concat(matrix3);
                        }
                        f(lVar, lVar.h);
                        boolean H4 = H();
                        K(lVar, true);
                        if (H4) {
                            G(lVar);
                        }
                        U(lVar);
                    }
                } else if (l0Var instanceof SVG.n) {
                    SVG.n nVar = (SVG.n) l0Var;
                    SVG.o oVar8 = nVar.r;
                    if (!(oVar8 == null || oVar8.g() || (oVar = nVar.s) == null || oVar.g() || (str = nVar.o) == null)) {
                        PreserveAspectRatio preserveAspectRatio2 = nVar.n;
                        if (preserveAspectRatio2 == null) {
                            preserveAspectRatio2 = PreserveAspectRatio.LETTERBOX;
                        }
                        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
                            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                            bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                        }
                        if (bitmap == null) {
                            SVGExternalFileResolver sVGExternalFileResolver2 = SVG.g;
                            if (sVGExternalFileResolver2 != null) {
                                bitmap = sVGExternalFileResolver2.resolveImage(nVar.o);
                            }
                        }
                        if (bitmap == null) {
                            String.format("Could not locate image '%s'", nVar.o);
                        } else {
                            SVG.a aVar4 = new SVG.a(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
                            W(this.d, nVar);
                            if (m() && Y()) {
                                Matrix matrix4 = nVar.t;
                                if (matrix4 != null) {
                                    this.a.concat(matrix4);
                                }
                                SVG.o oVar9 = nVar.p;
                                float d3 = oVar9 != null ? oVar9.d(this) : 0.0f;
                                SVG.o oVar10 = nVar.q;
                                float e4 = oVar10 != null ? oVar10.e(this) : 0.0f;
                                float d4 = nVar.r.d(this);
                                float d5 = nVar.s.d(this);
                                h hVar2 = this.d;
                                hVar2.f = new SVG.a(d3, e4, d4, d5);
                                if (!hVar2.a.v.booleanValue()) {
                                    SVG.a aVar5 = this.d.f;
                                    P(aVar5.a, aVar5.b, aVar5.c, aVar5.d);
                                }
                                nVar.h = this.d.f;
                                U(nVar);
                                f(nVar, nVar.h);
                                boolean H5 = H();
                                X();
                                this.a.save();
                                this.a.concat(e(this.d.f, aVar4, preserveAspectRatio2));
                                if (this.d.a.M != SVG.Style.RenderQuality.optimizeSpeed) {
                                    i2 = 2;
                                }
                                this.a.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(i2));
                                this.a.restore();
                                if (H5) {
                                    G(nVar);
                                }
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.u) {
                    SVG.u uVar = (SVG.u) l0Var;
                    if (uVar.o != null) {
                        W(this.d, uVar);
                        if (m() && Y()) {
                            h hVar3 = this.d;
                            if (hVar3.c || hVar3.b) {
                                Matrix matrix5 = uVar.n;
                                if (matrix5 != null) {
                                    this.a.concat(matrix5);
                                }
                                Path path = new d(this, uVar.o).a;
                                if (uVar.h == null) {
                                    uVar.h = c(path);
                                }
                                U(uVar);
                                g(uVar);
                                f(uVar, uVar.h);
                                boolean H6 = H();
                                h hVar4 = this.d;
                                if (hVar4.b) {
                                    SVG.Style.FillRule fillRule = hVar4.a.c;
                                    if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
                                        fillType2 = Path.FillType.WINDING;
                                    } else {
                                        fillType2 = Path.FillType.EVEN_ODD;
                                    }
                                    path.setFillType(fillType2);
                                    n(uVar, path);
                                }
                                if (this.d.c) {
                                    o(path);
                                }
                                N(uVar);
                                if (H6) {
                                    G(uVar);
                                }
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.a0) {
                    SVG.a0 a0Var = (SVG.a0) l0Var;
                    SVG.o oVar11 = a0Var.q;
                    if (oVar11 != null && a0Var.r != null && !oVar11.g() && !a0Var.r.g()) {
                        W(this.d, a0Var);
                        if (m() && Y()) {
                            Matrix matrix6 = a0Var.n;
                            if (matrix6 != null) {
                                this.a.concat(matrix6);
                            }
                            Path D = D(a0Var);
                            U(a0Var);
                            g(a0Var);
                            f(a0Var, a0Var.h);
                            boolean H7 = H();
                            if (this.d.b) {
                                n(a0Var, D);
                            }
                            if (this.d.c) {
                                o(D);
                            }
                            if (H7) {
                                G(a0Var);
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.c) {
                    SVG.c cVar = (SVG.c) l0Var;
                    SVG.o oVar12 = cVar.q;
                    if (oVar12 != null && !oVar12.g()) {
                        W(this.d, cVar);
                        if (m() && Y()) {
                            Matrix matrix7 = cVar.n;
                            if (matrix7 != null) {
                                this.a.concat(matrix7);
                            }
                            Path A = A(cVar);
                            U(cVar);
                            g(cVar);
                            f(cVar, cVar.h);
                            boolean H8 = H();
                            if (this.d.b) {
                                n(cVar, A);
                            }
                            if (this.d.c) {
                                o(A);
                            }
                            if (H8) {
                                G(cVar);
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.h) {
                    SVG.h hVar5 = (SVG.h) l0Var;
                    SVG.o oVar13 = hVar5.q;
                    if (oVar13 != null && hVar5.r != null && !oVar13.g() && !hVar5.r.g()) {
                        W(this.d, hVar5);
                        if (m() && Y()) {
                            Matrix matrix8 = hVar5.n;
                            if (matrix8 != null) {
                                this.a.concat(matrix8);
                            }
                            Path B = B(hVar5);
                            U(hVar5);
                            g(hVar5);
                            f(hVar5, hVar5.h);
                            boolean H9 = H();
                            if (this.d.b) {
                                n(hVar5, B);
                            }
                            if (this.d.c) {
                                o(B);
                            }
                            if (H9) {
                                G(hVar5);
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.p) {
                    SVG.p pVar = (SVG.p) l0Var;
                    W(this.d, pVar);
                    if (m() && Y() && this.d.c) {
                        Matrix matrix9 = pVar.n;
                        if (matrix9 != null) {
                            this.a.concat(matrix9);
                        }
                        SVG.o oVar14 = pVar.o;
                        float d6 = oVar14 == null ? 0.0f : oVar14.d(this);
                        SVG.o oVar15 = pVar.p;
                        float e5 = oVar15 == null ? 0.0f : oVar15.e(this);
                        SVG.o oVar16 = pVar.q;
                        float d7 = oVar16 == null ? 0.0f : oVar16.d(this);
                        SVG.o oVar17 = pVar.r;
                        if (oVar17 != null) {
                            f3 = oVar17.e(this);
                        }
                        if (pVar.h == null) {
                            pVar.h = new SVG.a(Math.min(d6, d7), Math.min(e5, f3), Math.abs(d7 - d6), Math.abs(f3 - e5));
                        }
                        Path path2 = new Path();
                        path2.moveTo(d6, e5);
                        path2.lineTo(d7, f3);
                        U(pVar);
                        g(pVar);
                        f(pVar, pVar.h);
                        boolean H10 = H();
                        o(path2);
                        N(pVar);
                        if (H10) {
                            G(pVar);
                        }
                    }
                } else if (l0Var instanceof SVG.z) {
                    SVG.y yVar = (SVG.z) l0Var;
                    W(this.d, yVar);
                    if (m() && Y()) {
                        h hVar6 = this.d;
                        if (hVar6.c || hVar6.b) {
                            Matrix matrix10 = yVar.n;
                            if (matrix10 != null) {
                                this.a.concat(matrix10);
                            }
                            if (yVar.o.length >= 2) {
                                Path C = C(yVar);
                                U(yVar);
                                g(yVar);
                                f(yVar, yVar.h);
                                boolean H11 = H();
                                if (this.d.b) {
                                    n(yVar, C);
                                }
                                if (this.d.c) {
                                    o(C);
                                }
                                N(yVar);
                                if (H11) {
                                    G(yVar);
                                }
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.y) {
                    SVG.y yVar2 = (SVG.y) l0Var;
                    W(this.d, yVar2);
                    if (m() && Y()) {
                        h hVar7 = this.d;
                        if (hVar7.c || hVar7.b) {
                            Matrix matrix11 = yVar2.n;
                            if (matrix11 != null) {
                                this.a.concat(matrix11);
                            }
                            if (yVar2.o.length >= 2) {
                                Path C2 = C(yVar2);
                                U(yVar2);
                                SVG.Style.FillRule fillRule2 = this.d.a.c;
                                if (fillRule2 == null || fillRule2 != SVG.Style.FillRule.EvenOdd) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                C2.setFillType(fillType);
                                g(yVar2);
                                f(yVar2, yVar2.h);
                                boolean H12 = H();
                                if (this.d.b) {
                                    n(yVar2, C2);
                                }
                                if (this.d.c) {
                                    o(C2);
                                }
                                N(yVar2);
                                if (H12) {
                                    G(yVar2);
                                }
                            }
                        }
                    }
                } else if (l0Var instanceof SVG.u0) {
                    SVG.u0 u0Var = (SVG.u0) l0Var;
                    W(this.d, u0Var);
                    if (m()) {
                        Matrix matrix12 = u0Var.r;
                        if (matrix12 != null) {
                            this.a.concat(matrix12);
                        }
                        List<SVG.o> list = u0Var.n;
                        float d8 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).d(this);
                        List<SVG.o> list2 = u0Var.o;
                        float e6 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).e(this);
                        List<SVG.o> list3 = u0Var.p;
                        float d9 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).d(this);
                        List<SVG.o> list4 = u0Var.q;
                        if (!(list4 == null || list4.size() == 0)) {
                            f3 = u0Var.q.get(0).e(this);
                        }
                        SVG.Style.TextAnchor w = w();
                        if (w != SVG.Style.TextAnchor.Start) {
                            float d10 = d(u0Var);
                            if (w == SVG.Style.TextAnchor.Middle) {
                                d10 /= 2.0f;
                            }
                            d8 -= d10;
                        }
                        if (u0Var.h == null) {
                            i iVar = new i(d8, e6);
                            p(u0Var, iVar);
                            RectF rectF = iVar.c;
                            u0Var.h = new SVG.a(rectF.left, rectF.top, rectF.width(), iVar.c.height());
                        }
                        U(u0Var);
                        g(u0Var);
                        f(u0Var, u0Var.h);
                        boolean H13 = H();
                        p(u0Var, new f(d8 + d9, e6 + f3));
                        if (H13) {
                            G(u0Var);
                        }
                    }
                }
            }
            R();
        }
    }

    public final void K(SVG.h0 h0Var, boolean z) {
        if (z) {
            this.f.push(h0Var);
            this.g.push(this.a.getMatrix());
        }
        for (SVG.l0 l0Var : ((SVG.f0) h0Var).i) {
            J(l0Var);
        }
        if (z) {
            this.f.pop();
            this.g.pop();
        }
    }

    public void L(SVG svg, RenderOptions renderOptions) {
        SVG.a aVar;
        PreserveAspectRatio preserveAspectRatio;
        this.c = svg;
        SVG.d0 d0Var = svg.a;
        if (d0Var == null) {
            String.format("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.hasView()) {
            SVG.j0 c2 = this.c.c(renderOptions.e);
            if (c2 == null || !(c2 instanceof SVG.d1)) {
                String.format("View element with id \"%s\" not found.", renderOptions.e);
                return;
            }
            SVG.d1 d1Var = (SVG.d1) c2;
            aVar = d1Var.o;
            if (aVar == null) {
                String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.e);
                return;
            }
            preserveAspectRatio = d1Var.n;
        } else {
            aVar = renderOptions.hasViewBox() ? renderOptions.d : d0Var.o;
            preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.b : d0Var.n;
        }
        if (renderOptions.hasCss()) {
            svg.e.b(renderOptions.a);
        }
        if (renderOptions.hasTarget()) {
            b.q qVar = new b.q();
            this.h = qVar;
            qVar.a = svg.c(renderOptions.c);
        }
        this.d = new h(this);
        this.e = new Stack<>();
        V(this.d, SVG.Style.a());
        h hVar = this.d;
        hVar.f = null;
        hVar.h = false;
        this.e.push(new h(this, hVar));
        this.g = new Stack<>();
        this.f = new Stack<>();
        i(d0Var);
        S();
        SVG.a aVar2 = new SVG.a(renderOptions.f);
        SVG.o oVar = d0Var.r;
        if (oVar != null) {
            aVar2.c = oVar.c(this, aVar2.c);
        }
        SVG.o oVar2 = d0Var.s;
        if (oVar2 != null) {
            aVar2.d = oVar2.c(this, aVar2.d);
        }
        I(d0Var, aVar2, aVar, preserveAspectRatio);
        R();
        if (renderOptions.hasCss()) {
            b.r rVar = svg.e;
            b.u uVar = b.u.RenderOptions;
            List<b.p> list = rVar.a;
            if (list != null) {
                Iterator<b.p> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().c == uVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(com.caverock.androidsvg.SVG.q r12, a2.e.a.e.c r13) {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.e.M(com.caverock.androidsvg.SVG$q, a2.e.a.e$c):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0181 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N(com.caverock.androidsvg.SVG.k r23) {
        /*
        // Method dump skipped, instructions count: 537
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.e.N(com.caverock.androidsvg.SVG$k):void");
    }

    public final void O(SVG.r rVar, SVG.i0 i0Var) {
        float f2;
        float f3;
        Boolean bool = rVar.n;
        boolean z = true;
        if (bool != null && bool.booleanValue()) {
            SVG.o oVar = rVar.p;
            f3 = oVar != null ? oVar.d(this) : i0Var.h.c;
            SVG.o oVar2 = rVar.q;
            f2 = oVar2 != null ? oVar2.e(this) : i0Var.h.d;
        } else {
            SVG.o oVar3 = rVar.p;
            float f4 = 1.2f;
            float c2 = oVar3 != null ? oVar3.c(this, 1.0f) : 1.2f;
            SVG.o oVar4 = rVar.q;
            if (oVar4 != null) {
                f4 = oVar4.c(this, 1.0f);
            }
            SVG.a aVar = i0Var.h;
            f3 = c2 * aVar.c;
            f2 = f4 * aVar.d;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            S();
            h u = u(rVar);
            this.d = u;
            u.a.m = Float.valueOf(1.0f);
            Boolean bool2 = rVar.o;
            if (bool2 != null && !bool2.booleanValue()) {
                z = false;
            }
            if (!z) {
                Canvas canvas = this.a;
                SVG.a aVar2 = i0Var.h;
                canvas.translate(aVar2.a, aVar2.b);
                Canvas canvas2 = this.a;
                SVG.a aVar3 = i0Var.h;
                canvas2.scale(aVar3.c, aVar3.d);
            }
            K(rVar, false);
            R();
        }
    }

    public final void P(float f2, float f3, float f4, float f5) {
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        SVG.b bVar = this.d.a.w;
        if (bVar != null) {
            f2 += bVar.d.d(this);
            f3 += this.d.a.w.a.e(this);
            f6 -= this.d.a.w.b.d(this);
            f7 -= this.d.a.w.c.e(this);
        }
        this.a.clipRect(f2, f3, f6, f7);
    }

    public final void Q(h hVar, boolean z, SVG.m0 m0Var) {
        int i2;
        SVG.Style style = hVar.a;
        float floatValue = (z ? style.d : style.f).floatValue();
        if (m0Var instanceof SVG.e) {
            i2 = ((SVG.e) m0Var).a;
        } else if (m0Var instanceof SVG.f) {
            i2 = hVar.a.n.a;
        } else {
            return;
        }
        int k2 = k(i2, floatValue);
        if (z) {
            hVar.d.setColor(k2);
        } else {
            hVar.e.setColor(k2);
        }
    }

    public final void R() {
        this.a.restore();
        this.d = this.e.pop();
    }

    public final void S() {
        this.a.save();
        this.e.push(this.d);
        this.d = new h(this, this.d);
    }

    public final String T(String str, boolean z, boolean z2) {
        if (this.d.h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    public final void U(SVG.i0 i0Var) {
        if (!(i0Var.b == null || i0Var.h == null)) {
            Matrix matrix = new Matrix();
            if (this.g.peek().invert(matrix)) {
                SVG.a aVar = i0Var.h;
                SVG.a aVar2 = i0Var.h;
                SVG.a aVar3 = i0Var.h;
                float[] fArr = {aVar.a, aVar.b, aVar.a(), aVar2.b, aVar2.a(), i0Var.h.b(), aVar3.a, aVar3.b()};
                matrix.preConcat(this.a.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    int i3 = i2 + 1;
                    if (fArr[i3] < rectF.top) {
                        rectF.top = fArr[i3];
                    }
                    if (fArr[i3] > rectF.bottom) {
                        rectF.bottom = fArr[i3];
                    }
                }
                SVG.i0 i0Var2 = (SVG.i0) this.f.peek();
                SVG.a aVar4 = i0Var2.h;
                if (aVar4 == null) {
                    float f2 = rectF.left;
                    float f3 = rectF.top;
                    i0Var2.h = new SVG.a(f2, f3, rectF.right - f2, rectF.bottom - f3);
                    return;
                }
                float f4 = rectF.left;
                float f5 = rectF.top;
                float f6 = rectF.right - f4;
                float f7 = rectF.bottom - f5;
                if (f4 < aVar4.a) {
                    aVar4.a = f4;
                }
                if (f5 < aVar4.b) {
                    aVar4.b = f5;
                }
                float f8 = f4 + f6;
                if (f8 > aVar4.a()) {
                    aVar4.c = f8 - aVar4.a;
                }
                float f9 = f5 + f7;
                if (f9 > aVar4.b()) {
                    aVar4.d = f9 - aVar4.b;
                }
            }
        }
    }

    public final void V(h hVar, SVG.Style style) {
        if (z(style, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
            hVar.a.n = style.n;
        }
        if (z(style, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) {
            hVar.a.m = style.m;
        }
        boolean z = false;
        if (z(style, 1)) {
            hVar.a.b = style.b;
            SVG.m0 m0Var = style.b;
            hVar.b = (m0Var == null || m0Var == SVG.e.c) ? false : true;
        }
        if (z(style, 4)) {
            hVar.a.d = style.d;
        }
        if (z(style, 6149)) {
            Q(hVar, true, hVar.a.b);
        }
        if (z(style, 2)) {
            hVar.a.c = style.c;
        }
        if (z(style, 8)) {
            hVar.a.e = style.e;
            SVG.m0 m0Var2 = style.e;
            hVar.c = (m0Var2 == null || m0Var2 == SVG.e.c) ? false : true;
        }
        if (z(style, 16)) {
            hVar.a.f = style.f;
        }
        if (z(style, 6168)) {
            Q(hVar, false, hVar.a.e);
        }
        if (z(style, 34359738368L)) {
            hVar.a.L = style.L;
        }
        if (z(style, 32)) {
            SVG.Style style2 = hVar.a;
            SVG.o oVar = style.g;
            style2.g = oVar;
            hVar.e.setStrokeWidth(oVar.b(this));
        }
        if (z(style, 64)) {
            hVar.a.h = style.h;
            int ordinal = style.h.ordinal();
            if (ordinal == 0) {
                hVar.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (ordinal == 1) {
                hVar.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (ordinal == 2) {
                hVar.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (z(style, 128)) {
            hVar.a.i = style.i;
            int ordinal2 = style.i.ordinal();
            if (ordinal2 == 0) {
                hVar.e.setStrokeJoin(Paint.Join.MITER);
            } else if (ordinal2 == 1) {
                hVar.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (ordinal2 == 2) {
                hVar.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (z(style, 256)) {
            hVar.a.j = style.j;
            hVar.e.setStrokeMiter(style.j.floatValue());
        }
        if (z(style, 512)) {
            hVar.a.k = style.k;
        }
        if (z(style, 1024)) {
            hVar.a.l = style.l;
        }
        Typeface typeface = null;
        if (z(style, 1536)) {
            SVG.o[] oVarArr = hVar.a.k;
            if (oVarArr == null) {
                hVar.e.setPathEffect(null);
            } else {
                int length = oVarArr.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = hVar.a.k[i3 % length].b(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    hVar.e.setPathEffect(null);
                } else {
                    float b2 = hVar.a.l.b(this);
                    if (b2 < 0.0f) {
                        b2 = (b2 % f2) + f2;
                    }
                    hVar.e.setPathEffect(new DashPathEffect(fArr, b2));
                }
            }
        }
        if (z(style, 16384)) {
            float textSize = this.d.d.getTextSize();
            hVar.a.p = style.p;
            hVar.d.setTextSize(style.p.c(this, textSize));
            hVar.e.setTextSize(style.p.c(this, textSize));
        }
        if (z(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            hVar.a.o = style.o;
        }
        if (z(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.q.intValue() == -1 && hVar.a.q.intValue() > 100) {
                SVG.Style style3 = hVar.a;
                style3.q = Integer.valueOf(style3.q.intValue() - 100);
            } else if (style.q.intValue() != 1 || hVar.a.q.intValue() >= 900) {
                hVar.a.q = style.q;
            } else {
                SVG.Style style4 = hVar.a;
                style4.q = Integer.valueOf(style4.q.intValue() + 100);
            }
        }
        if (z(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            hVar.a.r = style.r;
        }
        if (z(style, 106496)) {
            List<String> list = hVar.a.o;
            if (list != null && this.c != null) {
                SVGExternalFileResolver sVGExternalFileResolver = SVG.g;
                for (String str : list) {
                    SVG.Style style5 = hVar.a;
                    Typeface h2 = h(str, style5.q, style5.r);
                    if (h2 != null || sVGExternalFileResolver == null) {
                        typeface = h2;
                        continue;
                    } else {
                        typeface = sVGExternalFileResolver.resolveFont(str, hVar.a.q.intValue(), String.valueOf(hVar.a.r));
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.a;
                typeface = h(C.SERIF_NAME, style6.q, style6.r);
            }
            hVar.d.setTypeface(typeface);
            hVar.e.setTypeface(typeface);
        }
        if (z(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            hVar.a.s = style.s;
            Paint paint = hVar.d;
            SVG.Style.TextDecoration textDecoration = style.s;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = hVar.d;
            SVG.Style.TextDecoration textDecoration3 = style.s;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            hVar.e.setStrikeThruText(style.s == textDecoration2);
            Paint paint3 = hVar.e;
            if (style.s == textDecoration4) {
                z = true;
            }
            paint3.setUnderlineText(z);
        }
        if (z(style, 68719476736L)) {
            hVar.a.t = style.t;
        }
        if (z(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            hVar.a.u = style.u;
        }
        if (z(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            hVar.a.v = style.v;
        }
        if (z(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            hVar.a.x = style.x;
        }
        if (z(style, 4194304)) {
            hVar.a.y = style.y;
        }
        if (z(style, 8388608)) {
            hVar.a.z = style.z;
        }
        if (z(style, 16777216)) {
            hVar.a.A = style.A;
        }
        if (z(style, 33554432)) {
            hVar.a.B = style.B;
        }
        if (z(style, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
            hVar.a.w = style.w;
        }
        if (z(style, 268435456)) {
            hVar.a.E = style.E;
        }
        if (z(style, 536870912)) {
            hVar.a.F = style.F;
        }
        if (z(style, 1073741824)) {
            hVar.a.G = style.G;
        }
        if (z(style, 67108864)) {
            hVar.a.C = style.C;
        }
        if (z(style, 134217728)) {
            hVar.a.D = style.D;
        }
        if (z(style, 8589934592L)) {
            hVar.a.J = style.J;
        }
        if (z(style, 17179869184L)) {
            hVar.a.K = style.K;
        }
        if (z(style, 137438953472L)) {
            hVar.a.M = style.M;
        }
    }

    public final void W(h hVar, SVG.j0 j0Var) {
        boolean z = false;
        boolean z2 = j0Var.b == null;
        SVG.Style style = hVar.a;
        Boolean bool = Boolean.TRUE;
        style.A = bool;
        if (!z2) {
            bool = Boolean.FALSE;
        }
        style.v = bool;
        style.w = null;
        style.E = null;
        style.m = Float.valueOf(1.0f);
        style.C = SVG.e.b;
        style.D = Float.valueOf(1.0f);
        style.G = null;
        style.H = null;
        style.I = Float.valueOf(1.0f);
        style.J = null;
        style.K = Float.valueOf(1.0f);
        style.L = SVG.Style.VectorEffect.None;
        SVG.Style style2 = j0Var.e;
        if (style2 != null) {
            V(hVar, style2);
        }
        List<b.p> list = this.c.e.a;
        if (list == null || list.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (b.p pVar : this.c.e.a) {
                if (b.i(this.h, pVar.a, j0Var)) {
                    V(hVar, pVar.b);
                }
            }
        }
        SVG.Style style3 = j0Var.f;
        if (style3 != null) {
            V(hVar, style3);
        }
    }

    public final void X() {
        int i2;
        SVG.Style style = this.d.a;
        SVG.m0 m0Var = style.J;
        if (m0Var instanceof SVG.e) {
            i2 = ((SVG.e) m0Var).a;
        } else if (m0Var instanceof SVG.f) {
            i2 = style.n.a;
        } else {
            return;
        }
        Float f2 = style.K;
        if (f2 != null) {
            i2 = k(i2, f2.floatValue());
        }
        this.a.drawColor(i2);
    }

    public final boolean Y() {
        Boolean bool = this.d.a.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @TargetApi(19)
    public final Path b(SVG.i0 i0Var, SVG.a aVar) {
        Path F;
        SVG.l0 e2 = i0Var.a.e(this.d.a.E);
        boolean z = false;
        if (e2 == null) {
            String.format("ClipPath reference '%s' not found", this.d.a.E);
            return null;
        }
        SVG.d dVar = (SVG.d) e2;
        this.e.push(this.d);
        this.d = u(dVar);
        Boolean bool = dVar.o;
        if (bool == null || bool.booleanValue()) {
            z = true;
        }
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(aVar.a, aVar.b);
            matrix.preScale(aVar.c, aVar.d);
        }
        Matrix matrix2 = dVar.n;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.l0 l0Var : dVar.i) {
            if ((l0Var instanceof SVG.i0) && (F = F((SVG.i0) l0Var, true)) != null) {
                path.op(F, Path.Op.UNION);
            }
        }
        if (this.d.a.E != null) {
            if (dVar.h == null) {
                dVar.h = c(path);
            }
            Path b2 = b(dVar, dVar.h);
            if (b2 != null) {
                path.op(b2, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.d = this.e.pop();
        return path;
    }

    public final SVG.a c(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.a(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public final float d(SVG.w0 w0Var) {
        k kVar = new k(null);
        p(w0Var, kVar);
        return kVar.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (r6 != 9) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[PHI: r4 
      PHI: (r4v2 float) = (r4v1 float), (r4v3 float) binds: [B:28:0x007c, B:31:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Matrix e(com.caverock.androidsvg.SVG.a r10, com.caverock.androidsvg.SVG.a r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L_0x0096
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.getAlignment()
            if (r1 != 0) goto L_0x000f
            goto L_0x0096
        L_0x000f:
            float r1 = r10.c
            float r2 = r11.c
            float r1 = r1 / r2
            float r2 = r10.d
            float r3 = r11.d
            float r2 = r2 / r3
            float r3 = r11.a
            float r3 = -r3
            float r4 = r11.b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0035
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L_0x0035:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.getScale()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L_0x0042
            float r1 = java.lang.Math.max(r1, r2)
            goto L_0x0046
        L_0x0042:
            float r1 = java.lang.Math.min(r1, r2)
        L_0x0046:
            float r2 = r10.c
            float r2 = r2 / r1
            float r5 = r10.d
            float r5 = r5 / r1
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r6 = r12.getAlignment()
            int r6 = r6.ordinal()
            r7 = 2
            r8 = 1073741824(0x40000000, float:2.0)
            if (r6 == r7) goto L_0x006f
            r7 = 3
            if (r6 == r7) goto L_0x006b
            r7 = 5
            if (r6 == r7) goto L_0x006f
            r7 = 6
            if (r6 == r7) goto L_0x006b
            r7 = 8
            if (r6 == r7) goto L_0x006f
            r7 = 9
            if (r6 == r7) goto L_0x006b
            goto L_0x0074
        L_0x006b:
            float r6 = r11.c
            float r6 = r6 - r2
            goto L_0x0073
        L_0x006f:
            float r6 = r11.c
            float r6 = r6 - r2
            float r6 = r6 / r8
        L_0x0073:
            float r3 = r3 - r6
        L_0x0074:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.getAlignment()
            int r12 = r12.ordinal()
            switch(r12) {
                case 4: goto L_0x0084;
                case 5: goto L_0x0084;
                case 6: goto L_0x0084;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0089
        L_0x0080:
            float r11 = r11.d
            float r11 = r11 - r5
            goto L_0x0088
        L_0x0084:
            float r11 = r11.d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L_0x0088:
            float r4 = r4 - r11
        L_0x0089:
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L_0x0096:
            return r0
            switch-data {4->0x0084, 5->0x0084, 6->0x0084, 7->0x0080, 8->0x0080, 9->0x0080, }
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.e.e(com.caverock.androidsvg.SVG$a, com.caverock.androidsvg.SVG$a, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    public final void f(SVG.i0 i0Var, SVG.a aVar) {
        Path b2;
        if (this.d.a.E != null && (b2 = b(i0Var, aVar)) != null) {
            this.a.clipPath(b2);
        }
    }

    public final void g(SVG.i0 i0Var) {
        SVG.m0 m0Var = this.d.a.b;
        if (m0Var instanceof SVG.t) {
            l(true, i0Var.h, (SVG.t) m0Var);
        }
        SVG.m0 m0Var2 = this.d.a.e;
        if (m0Var2 instanceof SVG.t) {
            l(false, i0Var.h, (SVG.t) m0Var2);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r6.equals("monospace") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Typeface h(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.SVG.Style.FontStyle r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r0 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L_0x0008
            r8 = 1
            goto L_0x0009
        L_0x0008:
            r8 = 0
        L_0x0009:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L_0x0019
            if (r8 == 0) goto L_0x0017
            r7 = 3
            goto L_0x001e
        L_0x0017:
            r7 = 1
            goto L_0x001e
        L_0x0019:
            if (r8 == 0) goto L_0x001d
            r7 = 2
            goto L_0x001e
        L_0x001d:
            r7 = 0
        L_0x001e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L_0x0055;
                case -1431958525: goto L_0x004c;
                case -1081737434: goto L_0x0041;
                case 109326717: goto L_0x0036;
                case 1126973893: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r1 = -1
            goto L_0x005f
        L_0x002b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r1 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r1 = 3
            goto L_0x005f
        L_0x0041:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r1 = 2
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r1 = 0
        L_0x005f:
            switch(r1) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0079;
                case 2: goto L_0x0072;
                case 3: goto L_0x006b;
                case 4: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6 = 0
            goto L_0x0086
        L_0x0064:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x006b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0072:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0079:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0080:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L_0x0086:
            return r6
            switch-data {-1536685117->0x0055, -1431958525->0x004c, -1081737434->0x0041, 109326717->0x0036, 1126973893->0x002b, }
            switch-data {0->0x0080, 1->0x0079, 2->0x0072, 3->0x006b, 4->0x0064, }
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.e.h(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    public final void i(SVG.l0 l0Var) {
        Boolean bool;
        if ((l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0022: APUT  (r2v28 java.lang.Object[]), (0 ??[int, short, byte, char]), (r4v10 java.lang.String) */
    public final void l(boolean z, SVG.a aVar, SVG.t tVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        SVG.j jVar = SVG.j.repeat;
        SVG.j jVar2 = SVG.j.reflect;
        SVG.l0 e2 = this.c.e(tVar.a);
        boolean z2 = true;
        int i2 = 0;
        if (e2 == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = tVar.a;
            String.format("%s reference '%s' not found", objArr);
            SVG.m0 m0Var = tVar.b;
            if (m0Var != null) {
                Q(this.d, z, m0Var);
            } else if (z) {
                this.d.b = false;
            } else {
                this.d.c = false;
            }
        } else if (e2 instanceof SVG.k0) {
            SVG.k0 k0Var = (SVG.k0) e2;
            String str = k0Var.l;
            if (str != null) {
                r(k0Var, str);
            }
            Boolean bool = k0Var.i;
            boolean z3 = bool != null && bool.booleanValue();
            h hVar = this.d;
            Paint paint = z ? hVar.d : hVar.e;
            if (z3) {
                SVG.a y = y();
                SVG.o oVar = k0Var.m;
                float d2 = oVar != null ? oVar.d(this) : 0.0f;
                SVG.o oVar2 = k0Var.n;
                float e3 = oVar2 != null ? oVar2.e(this) : 0.0f;
                SVG.o oVar3 = k0Var.o;
                float d3 = oVar3 != null ? oVar3.d(this) : y.c;
                SVG.o oVar4 = k0Var.p;
                f6 = d3;
                f8 = d2;
                f7 = e3;
                f5 = oVar4 != null ? oVar4.e(this) : 0.0f;
            } else {
                SVG.o oVar5 = k0Var.m;
                float c2 = oVar5 != null ? oVar5.c(this, 1.0f) : 0.0f;
                SVG.o oVar6 = k0Var.n;
                float c3 = oVar6 != null ? oVar6.c(this, 1.0f) : 0.0f;
                SVG.o oVar7 = k0Var.o;
                float c4 = oVar7 != null ? oVar7.c(this, 1.0f) : 1.0f;
                SVG.o oVar8 = k0Var.p;
                f5 = oVar8 != null ? oVar8.c(this, 1.0f) : 0.0f;
                f8 = c2;
                f7 = c3;
                f6 = c4;
            }
            S();
            this.d = u(k0Var);
            Matrix matrix = new Matrix();
            if (!z3) {
                matrix.preTranslate(aVar.a, aVar.b);
                matrix.preScale(aVar.c, aVar.d);
            }
            Matrix matrix2 = k0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = k0Var.h.size();
            if (size == 0) {
                R();
                if (z) {
                    this.d.b = false;
                } else {
                    this.d.c = false;
                }
            } else {
                int[] iArr = new int[size];
                float[] fArr = new float[size];
                Iterator<SVG.l0> it = k0Var.h.iterator();
                float f9 = -1.0f;
                while (it.hasNext()) {
                    SVG.c0 c0Var = (SVG.c0) it.next();
                    Float f10 = c0Var.h;
                    float floatValue = f10 != null ? f10.floatValue() : 0.0f;
                    if (i2 == 0 || floatValue >= f9) {
                        fArr[i2] = floatValue;
                        f9 = floatValue;
                    } else {
                        fArr[i2] = f9;
                    }
                    S();
                    W(this.d, c0Var);
                    SVG.Style style = this.d.a;
                    SVG.e eVar = (SVG.e) style.C;
                    if (eVar == null) {
                        eVar = SVG.e.b;
                    }
                    iArr[i2] = k(eVar.a, style.D.floatValue());
                    i2++;
                    R();
                }
                if ((f8 == f6 && f7 == f5) || size == 1) {
                    R();
                    paint.setColor(iArr[size - 1]);
                    return;
                }
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                SVG.j jVar3 = k0Var.k;
                if (jVar3 != null) {
                    if (jVar3 == jVar2) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (jVar3 == jVar) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                R();
                LinearGradient linearGradient = new LinearGradient(f8, f7, f6, f5, iArr, fArr, tileMode);
                linearGradient.setLocalMatrix(matrix);
                paint.setShader(linearGradient);
                paint.setAlpha(j(this.d.a.d.floatValue()));
            }
        } else if (e2 instanceof SVG.o0) {
            SVG.o0 o0Var = (SVG.o0) e2;
            String str2 = o0Var.l;
            if (str2 != null) {
                r(o0Var, str2);
            }
            Boolean bool2 = o0Var.i;
            boolean z4 = bool2 != null && bool2.booleanValue();
            h hVar2 = this.d;
            Paint paint2 = z ? hVar2.d : hVar2.e;
            if (z4) {
                SVG.o oVar9 = new SVG.o(50.0f, SVG.b1.percent);
                SVG.o oVar10 = o0Var.m;
                float d4 = oVar10 != null ? oVar10.d(this) : oVar9.d(this);
                SVG.o oVar11 = o0Var.n;
                float e4 = oVar11 != null ? oVar11.e(this) : oVar9.e(this);
                SVG.o oVar12 = o0Var.o;
                f2 = oVar12 != null ? oVar12.b(this) : oVar9.b(this);
                f4 = d4;
                f3 = e4;
            } else {
                SVG.o oVar13 = o0Var.m;
                float c5 = oVar13 != null ? oVar13.c(this, 1.0f) : 0.5f;
                SVG.o oVar14 = o0Var.n;
                float c6 = oVar14 != null ? oVar14.c(this, 1.0f) : 0.5f;
                SVG.o oVar15 = o0Var.o;
                f2 = oVar15 != null ? oVar15.c(this, 1.0f) : 0.5f;
                f4 = c5;
                f3 = c6;
            }
            S();
            this.d = u(o0Var);
            Matrix matrix3 = new Matrix();
            if (!z4) {
                matrix3.preTranslate(aVar.a, aVar.b);
                matrix3.preScale(aVar.c, aVar.d);
            }
            Matrix matrix4 = o0Var.j;
            if (matrix4 != null) {
                matrix3.preConcat(matrix4);
            }
            int size2 = o0Var.h.size();
            if (size2 == 0) {
                R();
                if (z) {
                    this.d.b = false;
                } else {
                    this.d.c = false;
                }
            } else {
                int[] iArr2 = new int[size2];
                float[] fArr2 = new float[size2];
                Iterator<SVG.l0> it2 = o0Var.h.iterator();
                float f11 = -1.0f;
                while (it2.hasNext()) {
                    SVG.c0 c0Var2 = (SVG.c0) it2.next();
                    Float f12 = c0Var2.h;
                    float floatValue2 = f12 != null ? f12.floatValue() : 0.0f;
                    if (i2 == 0 || floatValue2 >= f11) {
                        fArr2[i2] = floatValue2;
                        f11 = floatValue2;
                    } else {
                        fArr2[i2] = f11;
                    }
                    S();
                    W(this.d, c0Var2);
                    SVG.Style style2 = this.d.a;
                    SVG.e eVar2 = (SVG.e) style2.C;
                    if (eVar2 == null) {
                        eVar2 = SVG.e.b;
                    }
                    iArr2[i2] = k(eVar2.a, style2.D.floatValue());
                    i2++;
                    R();
                }
                if (f2 == 0.0f || size2 == 1) {
                    R();
                    paint2.setColor(iArr2[size2 - 1]);
                    return;
                }
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                SVG.j jVar4 = o0Var.k;
                if (jVar4 != null) {
                    if (jVar4 == jVar2) {
                        tileMode2 = Shader.TileMode.MIRROR;
                    } else if (jVar4 == jVar) {
                        tileMode2 = Shader.TileMode.REPEAT;
                    }
                }
                R();
                RadialGradient radialGradient = new RadialGradient(f4, f3, f2, iArr2, fArr2, tileMode2);
                radialGradient.setLocalMatrix(matrix3);
                paint2.setShader(radialGradient);
                paint2.setAlpha(j(this.d.a.d.floatValue()));
            }
        } else if (e2 instanceof SVG.b0) {
            SVG.b0 b0Var = (SVG.b0) e2;
            if (z) {
                if (z(b0Var.e, 2147483648L)) {
                    h hVar3 = this.d;
                    SVG.Style style3 = hVar3.a;
                    SVG.m0 m0Var2 = b0Var.e.H;
                    style3.b = m0Var2;
                    if (m0Var2 == null) {
                        z2 = false;
                    }
                    hVar3.b = z2;
                }
                if (z(b0Var.e, 4294967296L)) {
                    this.d.a.d = b0Var.e.I;
                }
                if (z(b0Var.e, 6442450944L)) {
                    h hVar4 = this.d;
                    Q(hVar4, z, hVar4.a.b);
                    return;
                }
                return;
            }
            if (z(b0Var.e, 2147483648L)) {
                h hVar5 = this.d;
                SVG.Style style4 = hVar5.a;
                SVG.m0 m0Var3 = b0Var.e.H;
                style4.e = m0Var3;
                if (m0Var3 == null) {
                    z2 = false;
                }
                hVar5.c = z2;
            }
            if (z(b0Var.e, 4294967296L)) {
                this.d.a.f = b0Var.e.I;
            }
            if (z(b0Var.e, 6442450944L)) {
                h hVar6 = this.d;
                Q(hVar6, z, hVar6.a.e);
            }
        }
    }

    public final boolean m() {
        Boolean bool = this.d.a.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void n(SVG.i0 i0Var, Path path) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        SVG.m0 m0Var = this.d.a.b;
        if (m0Var instanceof SVG.t) {
            SVG.l0 e2 = this.c.e(((SVG.t) m0Var).a);
            if (e2 instanceof SVG.x) {
                SVG.x xVar = (SVG.x) e2;
                Boolean bool = xVar.p;
                boolean z = bool != null && bool.booleanValue();
                String str = xVar.w;
                if (str != null) {
                    t(xVar, str);
                }
                if (z) {
                    SVG.o oVar = xVar.s;
                    f5 = oVar != null ? oVar.d(this) : 0.0f;
                    SVG.o oVar2 = xVar.t;
                    f4 = oVar2 != null ? oVar2.e(this) : 0.0f;
                    SVG.o oVar3 = xVar.u;
                    f3 = oVar3 != null ? oVar3.d(this) : 0.0f;
                    SVG.o oVar4 = xVar.v;
                    f2 = oVar4 != null ? oVar4.e(this) : 0.0f;
                } else {
                    SVG.o oVar5 = xVar.s;
                    float c2 = oVar5 != null ? oVar5.c(this, 1.0f) : 0.0f;
                    SVG.o oVar6 = xVar.t;
                    float c3 = oVar6 != null ? oVar6.c(this, 1.0f) : 0.0f;
                    SVG.o oVar7 = xVar.u;
                    float c4 = oVar7 != null ? oVar7.c(this, 1.0f) : 0.0f;
                    SVG.o oVar8 = xVar.v;
                    float c5 = oVar8 != null ? oVar8.c(this, 1.0f) : 0.0f;
                    SVG.a aVar = i0Var.h;
                    float f7 = aVar.a;
                    float f8 = aVar.c;
                    f5 = (c2 * f8) + f7;
                    float f9 = aVar.b;
                    float f10 = aVar.d;
                    float f11 = c4 * f8;
                    f2 = c5 * f10;
                    f4 = (c3 * f10) + f9;
                    f3 = f11;
                }
                if (!(f3 == 0.0f || f2 == 0.0f)) {
                    PreserveAspectRatio preserveAspectRatio = xVar.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                    }
                    S();
                    this.a.clipPath(path);
                    h hVar = new h(this);
                    V(hVar, SVG.Style.a());
                    hVar.a.v = Boolean.FALSE;
                    v(xVar, hVar);
                    this.d = hVar;
                    SVG.a aVar2 = i0Var.h;
                    Matrix matrix = xVar.r;
                    if (matrix != null) {
                        this.a.concat(matrix);
                        Matrix matrix2 = new Matrix();
                        if (xVar.r.invert(matrix2)) {
                            SVG.a aVar3 = i0Var.h;
                            SVG.a aVar4 = i0Var.h;
                            SVG.a aVar5 = i0Var.h;
                            float[] fArr = {aVar3.a, aVar3.b, aVar3.a(), aVar4.b, aVar4.a(), i0Var.h.b(), aVar5.a, aVar5.b()};
                            matrix2.mapPoints(fArr);
                            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                            for (int i2 = 2; i2 <= 6; i2 += 2) {
                                if (fArr[i2] < rectF.left) {
                                    rectF.left = fArr[i2];
                                }
                                if (fArr[i2] > rectF.right) {
                                    rectF.right = fArr[i2];
                                }
                                int i3 = i2 + 1;
                                if (fArr[i3] < rectF.top) {
                                    rectF.top = fArr[i3];
                                }
                                if (fArr[i3] > rectF.bottom) {
                                    rectF.bottom = fArr[i3];
                                }
                            }
                            float f12 = rectF.left;
                            float f13 = rectF.top;
                            aVar2 = new SVG.a(f12, f13, rectF.right - f12, rectF.bottom - f13);
                        }
                    }
                    float floor = (((float) Math.floor((double) ((aVar2.a - f5) / f3))) * f3) + f5;
                    float a3 = aVar2.a();
                    float b2 = aVar2.b();
                    SVG.a aVar6 = new SVG.a(0.0f, 0.0f, f3, f2);
                    boolean H = H();
                    for (float floor2 = (((float) Math.floor((double) ((aVar2.b - f4) / f2))) * f2) + f4; floor2 < b2; floor2 += f2) {
                        float f14 = floor;
                        while (f14 < a3) {
                            aVar6.a = f14;
                            aVar6.b = floor2;
                            S();
                            if (!this.d.a.v.booleanValue()) {
                                f6 = b2;
                                P(aVar6.a, aVar6.b, aVar6.c, aVar6.d);
                            } else {
                                f6 = b2;
                            }
                            SVG.a aVar7 = xVar.o;
                            if (aVar7 != null) {
                                this.a.concat(e(aVar6, aVar7, preserveAspectRatio));
                            } else {
                                Boolean bool2 = xVar.q;
                                boolean z2 = bool2 == null || bool2.booleanValue();
                                this.a.translate(f14, floor2);
                                if (!z2) {
                                    Canvas canvas = this.a;
                                    SVG.a aVar8 = i0Var.h;
                                    canvas.scale(aVar8.c, aVar8.d);
                                }
                            }
                            for (SVG.l0 l0Var : xVar.i) {
                                J(l0Var);
                            }
                            R();
                            f14 += f3;
                            b2 = f6;
                        }
                    }
                    if (H) {
                        G(xVar);
                    }
                    R();
                    return;
                }
                return;
            }
        }
        this.a.drawPath(path, this.d.d);
    }

    public final void o(Path path) {
        h hVar = this.d;
        if (hVar.a.L == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.a.setMatrix(new Matrix());
            Shader shader = this.d.e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.a.drawPath(path2, this.d.e);
            this.a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.a.drawPath(path, hVar.e);
    }

    public final void p(SVG.w0 w0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        SVG.Style.TextAnchor w;
        if (m()) {
            Iterator<SVG.l0> it = w0Var.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(T(((SVG.a1) next).c, z, !it.hasNext()));
                } else if (jVar.a((SVG.w0) next)) {
                    float f5 = 0.0f;
                    if (next instanceof SVG.x0) {
                        S();
                        SVG.x0 x0Var = (SVG.x0) next;
                        W(this.d, x0Var);
                        if (m() && Y()) {
                            SVG.l0 e2 = x0Var.a.e(x0Var.n);
                            if (e2 == null) {
                                String.format("TextPath reference '%s' not found", x0Var.n);
                            } else {
                                SVG.u uVar = (SVG.u) e2;
                                Path path = new d(this, uVar.o).a;
                                Matrix matrix = uVar.n;
                                if (matrix != null) {
                                    path.transform(matrix);
                                }
                                PathMeasure pathMeasure = new PathMeasure(path, false);
                                SVG.o oVar = x0Var.o;
                                float c2 = oVar != null ? oVar.c(this, pathMeasure.getLength()) : 0.0f;
                                SVG.Style.TextAnchor w2 = w();
                                if (w2 != SVG.Style.TextAnchor.Start) {
                                    k kVar = new k(null);
                                    p(x0Var, kVar);
                                    float f6 = kVar.a;
                                    if (w2 == SVG.Style.TextAnchor.Middle) {
                                        f6 /= 2.0f;
                                    }
                                    c2 -= f6;
                                }
                                g((SVG.i0) x0Var.p);
                                boolean H = H();
                                p(x0Var, new C0021e(path, c2, 0.0f));
                                if (H) {
                                    G(x0Var);
                                }
                            }
                        }
                        R();
                    } else if (next instanceof SVG.t0) {
                        S();
                        SVG.t0 t0Var = (SVG.t0) next;
                        W(this.d, t0Var);
                        if (m()) {
                            List<SVG.o> list = t0Var.n;
                            boolean z2 = list != null && list.size() > 0;
                            boolean z3 = jVar instanceof f;
                            if (z3) {
                                f4 = !z2 ? ((f) jVar).a : t0Var.n.get(0).d(this);
                                List<SVG.o> list2 = t0Var.o;
                                f3 = (list2 == null || list2.size() == 0) ? ((f) jVar).b : t0Var.o.get(0).e(this);
                                List<SVG.o> list3 = t0Var.p;
                                f2 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.p.get(0).d(this);
                                List<SVG.o> list4 = t0Var.q;
                                if (!(list4 == null || list4.size() == 0)) {
                                    f5 = t0Var.q.get(0).e(this);
                                }
                            } else {
                                f4 = 0.0f;
                                f3 = 0.0f;
                                f2 = 0.0f;
                            }
                            if (z2 && (w = w()) != SVG.Style.TextAnchor.Start) {
                                k kVar2 = new k(null);
                                p(t0Var, kVar2);
                                float f7 = kVar2.a;
                                if (w == SVG.Style.TextAnchor.Middle) {
                                    f7 /= 2.0f;
                                }
                                f4 -= f7;
                            }
                            g((SVG.i0) t0Var.r);
                            if (z3) {
                                f fVar = (f) jVar;
                                fVar.a = f4 + f2;
                                fVar.b = f3 + f5;
                            }
                            boolean H2 = H();
                            p(t0Var, jVar);
                            if (H2) {
                                G(t0Var);
                            }
                        }
                        R();
                    } else if (next instanceof SVG.s0) {
                        S();
                        SVG.s0 s0Var = (SVG.s0) next;
                        W(this.d, s0Var);
                        if (m()) {
                            g((SVG.i0) s0Var.o);
                            SVG.l0 e3 = next.a.e(s0Var.n);
                            if (e3 == null || !(e3 instanceof SVG.w0)) {
                                String.format("Tref reference '%s' not found", s0Var.n);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                q((SVG.w0) e3, sb);
                                if (sb.length() > 0) {
                                    jVar.b(sb.toString());
                                }
                            }
                        }
                        R();
                    }
                }
                z = false;
            }
        }
    }

    public final void q(SVG.w0 w0Var, StringBuilder sb) {
        Iterator<SVG.l0> it = w0Var.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.l0 next = it.next();
            if (next instanceof SVG.w0) {
                q((SVG.w0) next, sb);
            } else if (next instanceof SVG.a1) {
                sb.append(T(((SVG.a1) next).c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    public final void r(SVG.i iVar, String str) {
        SVG.l0 e2 = iVar.a.e(str);
        if (e2 == null) {
            String.format("Gradient reference '%s' not found", str);
        } else if (!(e2 instanceof SVG.i)) {
            String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (e2 == iVar) {
            String.format("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) e2;
            if (iVar.i == null) {
                iVar.i = iVar2.i;
            }
            if (iVar.j == null) {
                iVar.j = iVar2.j;
            }
            if (iVar.k == null) {
                iVar.k = iVar2.k;
            }
            if (iVar.h.isEmpty()) {
                iVar.h = iVar2.h;
            }
            try {
                if (iVar instanceof SVG.k0) {
                    SVG.k0 k0Var = (SVG.k0) iVar;
                    SVG.k0 k0Var2 = (SVG.k0) e2;
                    if (k0Var.m == null) {
                        k0Var.m = k0Var2.m;
                    }
                    if (k0Var.n == null) {
                        k0Var.n = k0Var2.n;
                    }
                    if (k0Var.o == null) {
                        k0Var.o = k0Var2.o;
                    }
                    if (k0Var.p == null) {
                        k0Var.p = k0Var2.p;
                    }
                } else {
                    s((SVG.o0) iVar, (SVG.o0) e2);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = iVar2.l;
            if (str2 != null) {
                r(iVar, str2);
            }
        }
    }

    public final void s(SVG.o0 o0Var, SVG.o0 o0Var2) {
        if (o0Var.m == null) {
            o0Var.m = o0Var2.m;
        }
        if (o0Var.n == null) {
            o0Var.n = o0Var2.n;
        }
        if (o0Var.o == null) {
            o0Var.o = o0Var2.o;
        }
        if (o0Var.p == null) {
            o0Var.p = o0Var2.p;
        }
        if (o0Var.q == null) {
            o0Var.q = o0Var2.q;
        }
    }

    public final void t(SVG.x xVar, String str) {
        SVG.l0 e2 = xVar.a.e(str);
        if (e2 == null) {
            String.format("Pattern reference '%s' not found", str);
        } else if (!(e2 instanceof SVG.x)) {
            String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (e2 == xVar) {
            String.format("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.x xVar2 = (SVG.x) e2;
            if (xVar.p == null) {
                xVar.p = xVar2.p;
            }
            if (xVar.q == null) {
                xVar.q = xVar2.q;
            }
            if (xVar.r == null) {
                xVar.r = xVar2.r;
            }
            if (xVar.s == null) {
                xVar.s = xVar2.s;
            }
            if (xVar.t == null) {
                xVar.t = xVar2.t;
            }
            if (xVar.u == null) {
                xVar.u = xVar2.u;
            }
            if (xVar.v == null) {
                xVar.v = xVar2.v;
            }
            if (xVar.i.isEmpty()) {
                xVar.i = xVar2.i;
            }
            if (xVar.o == null) {
                xVar.o = xVar2.o;
            }
            if (xVar.n == null) {
                xVar.n = xVar2.n;
            }
            String str2 = xVar2.w;
            if (str2 != null) {
                t(xVar, str2);
            }
        }
    }

    public final h u(SVG.l0 l0Var) {
        h hVar = new h(this);
        V(hVar, SVG.Style.a());
        v(l0Var, hVar);
        return hVar;
    }

    public final h v(SVG.l0 l0Var, h hVar) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (l0Var instanceof SVG.j0) {
                arrayList.add(0, (SVG.j0) l0Var);
            }
            SVG.h0 h0Var = l0Var.b;
            if (h0Var == null) {
                break;
            }
            l0Var = (SVG.l0) h0Var;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            W(hVar, (SVG.j0) it.next());
        }
        h hVar2 = this.d;
        hVar.g = hVar2.g;
        hVar.f = hVar2.f;
        return hVar;
    }

    public final SVG.Style.TextAnchor w() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.d.a;
        if (style.t == SVG.Style.TextDirection.LTR || (textAnchor = style.u) == SVG.Style.TextAnchor.Middle) {
            return style.u;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
    }

    public final Path.FillType x() {
        SVG.Style.FillRule fillRule = this.d.a.F;
        if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    public SVG.a y() {
        h hVar = this.d;
        SVG.a aVar = hVar.g;
        if (aVar != null) {
            return aVar;
        }
        return hVar.f;
    }

    public final boolean z(SVG.Style style, long j2) {
        return (style.a & j2) != 0;
    }

    public class h {
        public SVG.Style a;
        public boolean b;
        public boolean c;
        public Paint d;
        public Paint e;
        public SVG.a f;
        public SVG.a g;
        public boolean h;

        public h(e eVar) {
            Paint paint = new Paint();
            this.d = paint;
            paint.setFlags(385);
            this.d.setStyle(Paint.Style.FILL);
            this.d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setFlags(385);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.a();
        }

        public h(e eVar, h hVar) {
            this.b = hVar.b;
            this.c = hVar.c;
            this.d = new Paint(hVar.d);
            this.e = new Paint(hVar.e);
            SVG.a aVar = hVar.f;
            if (aVar != null) {
                this.f = new SVG.a(aVar);
            }
            SVG.a aVar2 = hVar.g;
            if (aVar2 != null) {
                this.g = new SVG.a(aVar2);
            }
            this.h = hVar.h;
            try {
                this.a = (SVG.Style) hVar.a.clone();
            } catch (CloneNotSupportedException unused) {
                this.a = SVG.Style.a();
            }
        }
    }
}
