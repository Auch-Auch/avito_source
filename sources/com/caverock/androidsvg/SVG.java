package com.caverock.androidsvg;

import a2.e.a.b;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.model.Navigation;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public class SVG {
    public static SVGExternalFileResolver g = null;
    public static boolean h = true;
    public d0 a = null;
    public String b = "";
    public String c = "";
    public float d = 96.0f;
    public b.r e = new b.r();
    public Map<String, j0> f = new HashMap();

    public static class Style implements Cloneable {
        public Boolean A;
        public Boolean B;
        public m0 C;
        public Float D;
        public String E;
        public FillRule F;
        public String G;
        public m0 H;
        public Float I;
        public m0 J;
        public Float K;
        public VectorEffect L;
        public RenderQuality M;
        public long a = 0;
        public m0 b;
        public FillRule c;
        public Float d;
        public m0 e;
        public Float f;
        public o g;
        public LineCap h;
        public LineJoin i;
        public Float j;
        public o[] k;
        public o l;
        public Float m;
        public e n;
        public List<String> o;
        public o p;
        public Integer q;
        public FontStyle r;
        public TextDecoration s;
        public TextDirection t;
        public TextAnchor u;
        public Boolean v;
        public b w;
        public String x;
        public String y;
        public String z;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCap {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style a() {
            Style style = new Style();
            style.a = -1;
            e eVar = e.b;
            style.b = eVar;
            FillRule fillRule = FillRule.NonZero;
            style.c = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.d = valueOf;
            style.e = null;
            style.f = valueOf;
            style.g = new o(1.0f);
            style.h = LineCap.Butt;
            style.i = LineJoin.Miter;
            style.j = Float.valueOf(4.0f);
            style.k = null;
            style.l = new o(0.0f);
            style.m = valueOf;
            style.n = eVar;
            style.o = null;
            style.p = new o(12.0f, b1.pt);
            style.q = 400;
            style.r = FontStyle.Normal;
            style.s = TextDecoration.None;
            style.t = TextDirection.LTR;
            style.u = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.v = bool;
            style.w = null;
            style.x = null;
            style.y = null;
            style.z = null;
            style.A = bool;
            style.B = bool;
            style.C = eVar;
            style.D = valueOf;
            style.E = null;
            style.F = fillRule;
            style.G = null;
            style.H = null;
            style.I = valueOf;
            style.J = null;
            style.K = valueOf;
            style.L = VectorEffect.None;
            style.M = RenderQuality.auto;
            return style;
        }

        @Override // java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            o[] oVarArr = this.k;
            if (oVarArr != null) {
                style.k = (o[]) oVarArr.clone();
            }
            return style;
        }
    }

    public static class a0 extends k {
        public o o;
        public o p;
        public o q;
        public o r;
        public o s;
        public o t;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "rect";
        }
    }

    public static class a1 extends l0 implements v0 {
        public String c;

        public a1(String str) {
            this.c = str;
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(a1.class.getSimpleName());
            sb.append(" '");
            return a2.b.a.a.a.t(sb, this.c, "'");
        }
    }

    public static class b {
        public o a;
        public o b;
        public o c;
        public o d;

        public b(o oVar, o oVar2, o oVar3, o oVar4) {
            this.a = oVar;
            this.b = oVar2;
            this.c = oVar3;
            this.d = oVar4;
        }
    }

    public static class b0 extends j0 implements h0 {
        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void h(l0 l0Var) throws SVGParseException {
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "solidColor";
        }
    }

    public enum b1 {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    public static class c extends k {
        public o o;
        public o p;
        public o q;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "circle";
        }
    }

    public static class c0 extends j0 implements h0 {
        public Float h;

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void h(l0 l0Var) throws SVGParseException {
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "stop";
        }
    }

    public static class c1 extends l {
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.j0
        public String m() {
            return "use";
        }
    }

    public static class d extends l implements s {
        public Boolean o;

        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.j0
        public String m() {
            return "clipPath";
        }
    }

    public static class d0 extends p0 {
        public o p;
        public o q;
        public o r;
        public o s;
        public String t;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "svg";
        }
    }

    public static class d1 extends p0 implements s {
        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "view";
        }
    }

    public static class e extends m0 {
        public static final e b = new e(ViewCompat.MEASURED_STATE_MASK);
        public static final e c = new e(0);
        public int a;

        public e(int i) {
            this.a = i;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.a));
        }
    }

    public interface e0 {
        String a();

        void b(Set<String> set);

        void d(Set<String> set);

        Set<String> e();

        Set<String> f();

        void g(Set<String> set);

        Set<String> getRequiredFeatures();

        void i(Set<String> set);

        void j(String str);

        Set<String> l();
    }

    public static class f extends m0 {
        public static f a = new f();
    }

    public static abstract class f0 extends i0 implements h0, e0 {
        public List<l0> i = new ArrayList();
        public Set<String> j = null;
        public String k = null;
        public Set<String> l = null;
        public Set<String> m = null;

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            this.j = set;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> getRequiredFeatures() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void h(l0 l0Var) throws SVGParseException {
            this.i.add(l0Var);
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void i(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(String str) {
            this.k = str;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> l() {
            return this.m;
        }
    }

    public static class g extends l implements s {
        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.j0
        public String m() {
            return "defs";
        }
    }

    public static abstract class g0 extends i0 implements e0 {
        public Set<String> i = null;
        public String j = null;
        public Set<String> k = null;
        public Set<String> l = null;
        public Set<String> m = null;

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
            this.k = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            this.i = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> getRequiredFeatures() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void i(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(String str) {
            this.j = str;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> l() {
            return this.m;
        }
    }

    public static class h extends k {
        public o o;
        public o p;
        public o q;
        public o r;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "ellipse";
        }
    }

    public interface h0 {
        List<l0> getChildren();

        void h(l0 l0Var) throws SVGParseException;
    }

    public static abstract class i extends j0 implements h0 {
        public List<l0> h = new ArrayList();
        public Boolean i;
        public Matrix j;
        public j k;
        public String l;

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return this.h;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof c0) {
                this.h.add(l0Var);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + l0Var + " elements.");
        }
    }

    public static abstract class i0 extends j0 {
        public a h = null;
    }

    public enum j {
        pad,
        reflect,
        repeat
    }

    public static abstract class j0 extends l0 {
        public String c = null;
        public Boolean d = null;
        public Style e = null;
        public Style f = null;
        public List<String> g = null;

        public abstract String m();
    }

    public static abstract class k extends g0 implements m {
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.m
        public void k(Matrix matrix) {
            this.n = matrix;
        }
    }

    public static class k0 extends i {
        public o m;
        public o n;
        public o o;
        public o p;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "linearGradient";
        }
    }

    public static class l extends f0 implements m {
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.m
        public void k(Matrix matrix) {
            this.n = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return Navigation.GROUP;
        }
    }

    public static class l0 {
        public SVG a;
        public h0 b;

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    public interface m {
        void k(Matrix matrix);
    }

    public static abstract class m0 implements Cloneable {
    }

    public static class n extends n0 implements m {
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;
        public Matrix t;

        @Override // com.caverock.androidsvg.SVG.m
        public void k(Matrix matrix) {
            this.t = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "image";
        }
    }

    public static abstract class n0 extends f0 {
        public PreserveAspectRatio n = null;
    }

    public static class o0 extends i {
        public o m;
        public o n;
        public o o;
        public o p;
        public o q;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "radialGradient";
        }
    }

    public static class p extends k {
        public o o;
        public o p;
        public o q;
        public o r;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "line";
        }
    }

    public static abstract class p0 extends n0 {
        public a o;
    }

    public static class q extends p0 implements s {
        public boolean p;
        public o q;
        public o r;
        public o s;
        public o t;
        public Float u;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "marker";
        }
    }

    public static class q0 extends l {
        @Override // com.caverock.androidsvg.SVG.l, com.caverock.androidsvg.SVG.j0
        public String m() {
            return "switch";
        }
    }

    public static class r extends f0 implements s {
        public Boolean n;
        public Boolean o;
        public o p;
        public o q;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "mask";
        }
    }

    public static class r0 extends p0 implements s {
        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "symbol";
        }
    }

    public interface s {
    }

    public static class s0 extends w0 implements v0 {
        public String n;
        public z0 o;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.o;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "tref";
        }
    }

    public static class t extends m0 {
        public String a;
        public m0 b;

        public t(String str, m0 m0Var) {
            this.a = str;
            this.b = m0Var;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.a + " " + this.b;
        }
    }

    public static class t0 extends y0 implements v0 {
        public z0 r;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.r;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "tspan";
        }
    }

    public static class u extends k {
        public v o;
        public Float p;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return MessageMetaInfo.COLUMN_PATH;
        }
    }

    public static class u0 extends y0 implements z0, m {
        public Matrix r;

        @Override // com.caverock.androidsvg.SVG.m
        public void k(Matrix matrix) {
            this.r = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "text";
        }
    }

    public static class v implements w {
        public byte[] a;
        public int b;
        public float[] c;
        public int d;

        public v() {
            this.a = null;
            this.b = 0;
            this.c = null;
            this.d = 0;
            this.a = new byte[8];
            this.c = new float[16];
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            f((byte) 0);
            g(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            f((byte) 1);
            g(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            f((byte) 3);
            g(4);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            this.d = i4 + 1;
            fArr[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            f((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            f((byte) 2);
            g(6);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            this.d = i6;
            fArr[i5] = f5;
            this.d = i6 + 1;
            fArr[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            f((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            g(5);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            this.d = i5 + 1;
            fArr[i5] = f5;
        }

        public final void f(byte b2) {
            int i = this.b;
            byte[] bArr = this.a;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 2)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.a = bArr2;
            }
            byte[] bArr3 = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr3[i2] = b2;
        }

        public final void g(int i) {
            float[] fArr = this.c;
            if (fArr.length < this.d + i) {
                float[] fArr2 = new float[(fArr.length * 2)];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.c = fArr2;
            }
        }

        public void h(w wVar) {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.b; i3++) {
                byte b2 = this.a[i3];
                if (b2 == 0) {
                    float[] fArr = this.c;
                    int i4 = i2 + 1;
                    i = i4 + 1;
                    wVar.a(fArr[i2], fArr[i4]);
                } else if (b2 != 1) {
                    if (b2 == 2) {
                        float[] fArr2 = this.c;
                        int i5 = i2 + 1;
                        float f = fArr2[i2];
                        int i6 = i5 + 1;
                        float f2 = fArr2[i5];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        i2 = i9 + 1;
                        wVar.d(f, f2, f3, f4, f5, fArr2[i9]);
                    } else if (b2 == 3) {
                        float[] fArr3 = this.c;
                        int i10 = i2 + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        wVar.c(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                        i2 = i12 + 1;
                    } else if (b2 != 8) {
                        boolean z = (b2 & 2) != 0;
                        boolean z2 = (b2 & 1) != 0;
                        float[] fArr4 = this.c;
                        int i13 = i2 + 1;
                        float f6 = fArr4[i2];
                        int i14 = i13 + 1;
                        float f7 = fArr4[i13];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        wVar.e(f6, f7, f8, z, z2, fArr4[i15], fArr4[i16]);
                        i2 = i16 + 1;
                    } else {
                        wVar.close();
                    }
                } else {
                    float[] fArr5 = this.c;
                    int i17 = i2 + 1;
                    i = i17 + 1;
                    wVar.b(fArr5[i2], fArr5[i17]);
                }
                i2 = i;
            }
        }
    }

    public interface v0 {
        z0 c();
    }

    public interface w {
        void a(float f, float f2);

        void b(float f, float f2);

        void c(float f, float f2, float f3, float f4);

        void close();

        void d(float f, float f2, float f3, float f4, float f5, float f6);

        void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);
    }

    public static abstract class w0 extends f0 {
        @Override // com.caverock.androidsvg.SVG.f0, com.caverock.androidsvg.SVG.h0
        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof v0) {
                this.i.add(l0Var);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + l0Var + " elements.");
        }
    }

    public static class x extends p0 implements s {
        public Boolean p;
        public Boolean q;
        public Matrix r;
        public o s;
        public o t;
        public o u;
        public o v;
        public String w;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "pattern";
        }
    }

    public static class x0 extends w0 implements v0 {
        public String n;
        public o o;
        public z0 p;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.p;
        }

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "textPath";
        }
    }

    public static class y extends k {
        public float[] o;

        @Override // com.caverock.androidsvg.SVG.j0
        public String m() {
            return "polyline";
        }
    }

    public static abstract class y0 extends w0 {
        public List<o> n;
        public List<o> o;
        public List<o> p;
        public List<o> q;
    }

    public static class z extends y {
        @Override // com.caverock.androidsvg.SVG.y, com.caverock.androidsvg.SVG.j0
        public String m() {
            return "polygon";
        }
    }

    public interface z0 {
    }

    public static void deregisterExternalFileResolver() {
        g = null;
    }

    public static SVG getFromAsset(AssetManager assetManager, String str) throws SVGParseException, IOException {
        a2.e.a.f fVar = new a2.e.a.f();
        InputStream open = assetManager.open(str);
        try {
            return fVar.h(open, h);
        } finally {
            try {
                open.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new a2.e.a.f().h(inputStream, h);
    }

    public static SVG getFromResource(Context context, int i2) throws SVGParseException {
        return getFromResource(context.getResources(), i2);
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new a2.e.a.f().h(new ByteArrayInputStream(str.getBytes()), h);
    }

    public static String getVersion() {
        return "1.3";
    }

    public static boolean isInternalEntitiesEnabled() {
        return h;
    }

    public static void registerExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        g = sVGExternalFileResolver;
    }

    public static void setInternalEntitiesEnabled(boolean z2) {
        h = z2;
    }

    public final a a(float f2) {
        b1 b1Var;
        b1 b1Var2;
        b1 b1Var3;
        b1 b1Var4;
        float f3;
        b1 b1Var5;
        d0 d0Var = this.a;
        o oVar = d0Var.r;
        o oVar2 = d0Var.s;
        if (oVar == null || oVar.g() || (b1Var = oVar.b) == (b1Var2 = b1.percent) || b1Var == (b1Var3 = b1.em) || b1Var == (b1Var4 = b1.ex)) {
            return new a(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float a3 = oVar.a(f2);
        if (oVar2 == null) {
            a aVar = this.a.o;
            f3 = aVar != null ? (aVar.d * a3) / aVar.c : a3;
        } else if (oVar2.g() || (b1Var5 = oVar2.b) == b1Var2 || b1Var5 == b1Var3 || b1Var5 == b1Var4) {
            return new a(-1.0f, -1.0f, -1.0f, -1.0f);
        } else {
            f3 = oVar2.a(f2);
        }
        return new a(0.0f, 0.0f, a3, f3);
    }

    public final j0 b(h0 h0Var, String str) {
        j0 b2;
        j0 j0Var = (j0) h0Var;
        if (str.equals(j0Var.c)) {
            return j0Var;
        }
        for (l0 l0Var : h0Var.getChildren()) {
            if (l0Var instanceof j0) {
                j0 j0Var2 = (j0) l0Var;
                if (str.equals(j0Var2.c)) {
                    return j0Var2;
                }
                if ((l0Var instanceof h0) && (b2 = b((h0) l0Var, str)) != null) {
                    return b2;
                }
            }
        }
        return null;
    }

    public j0 c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.a.c)) {
            return this.a;
        }
        if (this.f.containsKey(str)) {
            return this.f.get(str);
        }
        j0 b2 = b(this.a, str);
        this.f.put(str, b2);
        return b2;
    }

    public final List<l0> d(h0 h0Var, Class cls) {
        ArrayList arrayList = new ArrayList();
        if (h0Var.getClass() == cls) {
            arrayList.add((l0) h0Var);
        }
        for (l0 l0Var : h0Var.getChildren()) {
            if (l0Var.getClass() == cls) {
                arrayList.add(l0Var);
            }
            if (l0Var instanceof h0) {
                d((h0) l0Var, cls);
            }
        }
        return arrayList;
    }

    public l0 e(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        String replace = str.replace("\\\n", "").replace("\\A", "\n");
        if (replace.length() <= 1 || !replace.startsWith("#")) {
            return null;
        }
        return c(replace.substring(1));
    }

    public float getDocumentAspectRatio() {
        b1 b1Var;
        d0 d0Var = this.a;
        if (d0Var != null) {
            o oVar = d0Var.r;
            o oVar2 = d0Var.s;
            if (oVar == null || oVar2 == null || oVar.b == (b1Var = b1.percent) || oVar2.b == b1Var) {
                a aVar = d0Var.o;
                if (aVar != null) {
                    float f2 = aVar.c;
                    if (f2 != 0.0f) {
                        float f3 = aVar.d;
                        if (f3 != 0.0f) {
                            return f2 / f3;
                        }
                    }
                }
                return -1.0f;
            } else if (oVar.g() || oVar2.g()) {
                return -1.0f;
            } else {
                return oVar.a(this.d) / oVar2.a(this.d);
            }
        } else {
            throw new IllegalArgumentException("SVG document is empty");
        }
    }

    public String getDocumentDescription() {
        if (this.a != null) {
            return this.c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentHeight() {
        if (this.a != null) {
            return a(this.d).d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        d0 d0Var = this.a;
        if (d0Var != null) {
            PreserveAspectRatio preserveAspectRatio = d0Var.n;
            if (preserveAspectRatio == null) {
                return null;
            }
            return preserveAspectRatio;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentSVGVersion() {
        d0 d0Var = this.a;
        if (d0Var != null) {
            return d0Var.t;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentTitle() {
        if (this.a != null) {
            return this.b;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF getDocumentViewBox() {
        d0 d0Var = this.a;
        if (d0Var != null) {
            a aVar = d0Var.o;
            if (aVar == null) {
                return null;
            }
            Objects.requireNonNull(aVar);
            return new RectF(aVar.a, aVar.b, aVar.a(), aVar.b());
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentWidth() {
        if (this.a != null) {
            return a(this.d).c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getRenderDPI() {
        return this.d;
    }

    public Set<String> getViewList() {
        d0 d0Var = this.a;
        if (d0Var != null) {
            ArrayList arrayList = (ArrayList) d(d0Var, d1.class);
            HashSet hashSet = new HashSet(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = ((d1) ((l0) it.next())).c;
                if (str != null) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void renderToCanvas(Canvas canvas) {
        renderToCanvas(canvas, (RenderOptions) null);
    }

    public Picture renderToPicture() {
        return renderToPicture(null);
    }

    public void renderViewToCanvas(String str, Canvas canvas) {
        renderToCanvas(canvas, RenderOptions.create().view(str));
    }

    public Picture renderViewToPicture(String str, int i2, int i3) {
        RenderOptions renderOptions = new RenderOptions();
        renderOptions.view(str).viewPort(0.0f, 0.0f, (float) i2, (float) i3);
        Picture picture = new Picture();
        new a2.e.a.e(picture.beginRecording(i2, i3), this.d).L(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public void setDocumentHeight(float f2) {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.s = new o(f2);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.n = preserveAspectRatio;
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentViewBox(float f2, float f3, float f4, float f5) {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.o = new a(f2, f3, f4, f5);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(float f2) {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.r = new o(f2);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setRenderDPI(float f2) {
        this.d = f2;
    }

    public static SVG getFromResource(Resources resources, int i2) throws SVGParseException {
        a2.e.a.f fVar = new a2.e.a.f();
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            return fVar.h(openRawResource, h);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public void renderToCanvas(Canvas canvas, RectF rectF) {
        RenderOptions renderOptions = new RenderOptions();
        if (rectF != null) {
            renderOptions.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        } else {
            renderOptions.viewPort(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        new a2.e.a.e(canvas, this.d).L(this, renderOptions);
    }

    public Picture renderToPicture(int i2, int i3) {
        return renderToPicture(i2, i3, null);
    }

    public void renderViewToCanvas(String str, Canvas canvas, RectF rectF) {
        RenderOptions view = RenderOptions.create().view(str);
        if (rectF != null) {
            view.viewPort(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        renderToCanvas(canvas, view);
    }

    public Picture renderToPicture(RenderOptions renderOptions) {
        b1 b1Var;
        o oVar;
        a aVar = (renderOptions == null || !renderOptions.hasViewBox()) ? this.a.o : renderOptions.d;
        if (renderOptions != null && renderOptions.hasViewPort()) {
            return renderToPicture((int) Math.ceil((double) renderOptions.f.a()), (int) Math.ceil((double) renderOptions.f.b()), renderOptions);
        }
        d0 d0Var = this.a;
        o oVar2 = d0Var.r;
        if (oVar2 != null && oVar2.b != (b1Var = b1.percent) && (oVar = d0Var.s) != null && oVar.b != b1Var) {
            return renderToPicture((int) Math.ceil((double) oVar2.a(this.d)), (int) Math.ceil((double) this.a.s.a(this.d)), renderOptions);
        }
        if (oVar2 == null || aVar == null) {
            o oVar3 = d0Var.s;
            if (oVar3 == null || aVar == null) {
                return renderToPicture(512, 512, renderOptions);
            }
            float a3 = oVar3.a(this.d);
            return renderToPicture((int) Math.ceil((double) ((aVar.c * a3) / aVar.d)), (int) Math.ceil((double) a3), renderOptions);
        }
        float a4 = oVar2.a(this.d);
        return renderToPicture((int) Math.ceil((double) a4), (int) Math.ceil((double) ((aVar.d * a4) / aVar.c)), renderOptions);
    }

    public void setDocumentHeight(String str) throws SVGParseException {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.s = a2.e.a.f.y(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(String str) throws SVGParseException {
        d0 d0Var = this.a;
        if (d0Var != null) {
            d0Var.r = a2.e.a.f.y(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public static class a {
        public float a;
        public float b;
        public float c;
        public float d;

        public a(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        public float a() {
            return this.a + this.c;
        }

        public float b() {
            return this.b + this.d;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("[");
            L.append(this.a);
            L.append(" ");
            L.append(this.b);
            L.append(" ");
            L.append(this.c);
            L.append(" ");
            L.append(this.d);
            L.append("]");
            return L.toString();
        }

        public a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
        }
    }

    public static class o implements Cloneable {
        public float a;
        public b1 b;

        public o(float f, b1 b1Var) {
            this.a = 0.0f;
            this.b = b1.px;
            this.a = f;
            this.b = b1Var;
        }

        public float a(float f) {
            int ordinal = this.b.ordinal();
            if (ordinal == 0) {
                return this.a;
            }
            if (ordinal == 3) {
                return this.a * f;
            }
            if (ordinal == 4) {
                return (this.a * f) / 2.54f;
            }
            if (ordinal == 5) {
                return (this.a * f) / 25.4f;
            }
            if (ordinal == 6) {
                return (this.a * f) / 72.0f;
            }
            if (ordinal != 7) {
                return this.a;
            }
            return (this.a * f) / 6.0f;
        }

        public float b(a2.e.a.e eVar) {
            if (this.b != b1.percent) {
                return d(eVar);
            }
            a y = eVar.y();
            if (y == null) {
                return this.a;
            }
            float f = y.c;
            float f2 = y.d;
            if (f == f2) {
                return (this.a * f) / 100.0f;
            }
            float f3 = f2 * f2;
            return (this.a * ((float) (Math.sqrt((double) (f3 + (f * f))) / 1.414213562373095d))) / 100.0f;
        }

        public float c(a2.e.a.e eVar, float f) {
            if (this.b == b1.percent) {
                return (this.a * f) / 100.0f;
            }
            return d(eVar);
        }

        public float d(a2.e.a.e eVar) {
            float f;
            float textSize;
            float f2;
            float f3;
            switch (this.b.ordinal()) {
                case 0:
                    return this.a;
                case 1:
                    f = this.a;
                    textSize = eVar.d.d.getTextSize();
                    return f * textSize;
                case 2:
                    f = this.a;
                    textSize = eVar.d.d.getTextSize() / 2.0f;
                    return f * textSize;
                case 3:
                    f = this.a;
                    textSize = eVar.b;
                    return f * textSize;
                case 4:
                    f3 = this.a * eVar.b;
                    f2 = 2.54f;
                    return f3 / f2;
                case 5:
                    f3 = this.a * eVar.b;
                    f2 = 25.4f;
                    return f3 / f2;
                case 6:
                    f3 = this.a * eVar.b;
                    f2 = 72.0f;
                    return f3 / f2;
                case 7:
                    f3 = this.a * eVar.b;
                    f2 = 6.0f;
                    return f3 / f2;
                case 8:
                    a y = eVar.y();
                    if (y == null) {
                        return this.a;
                    }
                    f3 = this.a * y.c;
                    f2 = 100.0f;
                    return f3 / f2;
                default:
                    return this.a;
            }
        }

        public float e(a2.e.a.e eVar) {
            if (this.b != b1.percent) {
                return d(eVar);
            }
            a y = eVar.y();
            if (y == null) {
                return this.a;
            }
            return (this.a * y.d) / 100.0f;
        }

        public boolean f() {
            return this.a < 0.0f;
        }

        public boolean g() {
            return this.a == 0.0f;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.valueOf(this.a) + this.b;
        }

        public o(float f) {
            this.a = 0.0f;
            b1 b1Var = b1.px;
            this.b = b1Var;
            this.a = f;
            this.b = b1Var;
        }
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        new a2.e.a.e(canvas, this.d).L(this, renderOptions);
    }

    public Picture renderToPicture(int i2, int i3, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i2, i3);
        if (renderOptions == null || renderOptions.f == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.viewPort(0.0f, 0.0f, (float) i2, (float) i3);
        }
        new a2.e.a.e(beginRecording, this.d).L(this, renderOptions);
        picture.endRecording();
        return picture;
    }
}
