package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.avito.android.remote.model.Navigation;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public class VectorDrawableCompat extends l6.a0.a.a.c {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;
    public h b;
    public PorterDuffColorFilter c;
    public ColorFilter d;
    public boolean e;
    public boolean f;
    public final float[] g;
    public final Matrix h;
    public final Rect i;

    public static class b extends f {
        public b() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.f
        public boolean c() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }

        public e(a aVar) {
        }
    }

    public static class h extends Drawable.ConstantState {
        public int a;
        public g b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h(h hVar) {
            this.c = null;
            this.d = VectorDrawableCompat.j;
            if (hVar != null) {
                this.a = hVar.a;
                g gVar = new g(hVar.b);
                this.b = gVar;
                if (hVar.b.e != null) {
                    gVar.e = new Paint(hVar.b.e);
                }
                if (hVar.b.d != null) {
                    this.b.d = new Paint(hVar.b.d);
                }
                this.c = hVar.c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public boolean a() {
            g gVar = this.b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.h.a());
            }
            return gVar.o.booleanValue();
        }

        public void b(int i2, int i3) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            g gVar = this.b;
            gVar.a(gVar.h, g.q, canvas, i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public h() {
            this.c = null;
            this.d = VectorDrawableCompat.j;
            this.b = new g();
        }
    }

    public VectorDrawableCompat() {
        this.f = true;
        this.g = new float[9];
        this.h = new Matrix();
        this.i = new Rect();
        this.b = new h();
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        XmlResourceParser xml;
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.a = ResourcesCompat.getDrawable(resources, i2, theme);
            new i(vectorDrawableCompat.a.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
        while (true) {
            next = xml.next();
            if (next == 2 || next == 1) {
                break;
            }
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    public PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f.getHeight()) == false) goto L_0x00d5;
     */
    @Override // android.graphics.drawable.Drawable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.b.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.a.getConstantState());
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.b.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.b.b.i;
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        g gVar;
        h hVar = this.b;
        if (hVar == null || (gVar = hVar.b) == null) {
            return 1.0f;
        }
        float f2 = gVar.i;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f3 = gVar.j;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        float f4 = gVar.l;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        float f5 = gVar.k;
        if (f5 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f5 / f2, f4 / f3);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.b) != null && (hVar.a() || ((colorStateList = this.b.c) != null && colorStateList.isStateful())));
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.b = new h(this.b);
            this.e = true;
        }
        return this;
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.b;
        ColorStateList colorStateList = hVar.c;
        if (!(colorStateList == null || (mode = hVar.d) == null)) {
            this.c = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.b.h.b(iArr);
            hVar.k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.b.b.getRootAlpha() != i2) {
            this.b.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.b.e = z;
        }
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // l6.a0.a.a.c, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        h hVar = this.b;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.c = a(colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        h hVar = this.b;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.c = a(hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi(24)
    public static class i extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.a = (VectorDrawable) this.a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.a = (VectorDrawable) this.a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.a = (VectorDrawable) this.a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.d = colorFilter;
        invalidateSelf();
    }

    public static abstract class f extends e {
        public PathParser.PathDataNode[] a = null;
        public String b;
        public int c = 0;
        public int d;

        public f() {
            super(null);
        }

        public boolean c() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.a, pathDataNodeArr)) {
                this.a = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.a, pathDataNodeArr);
            }
        }

        public f(f fVar) {
            super(null);
            this.b = fVar.b;
            this.d = fVar.d;
            this.a = PathParser.deepCopyNodes(fVar.a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i2;
        ArrayDeque arrayDeque;
        g gVar;
        g gVar2;
        ArrayDeque arrayDeque2;
        c cVar;
        TypedArray typedArray;
        int i3;
        Drawable drawable = this.a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.b;
        hVar.b = new g();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, l6.a0.a.a.a.a);
        h hVar2 = this.b;
        g gVar3 = hVar2.b;
        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i4 = 3;
        if (namedInt == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (namedInt != 5) {
            if (namedInt != 9) {
                switch (namedInt) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        hVar2.d = mode;
        int i5 = 1;
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(obtainAttributes, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            hVar2.c = namedColorStateList;
        }
        hVar2.e = TypedArrayUtils.getNamedBoolean(obtainAttributes, xmlPullParser, "autoMirrored", 5, hVar2.e);
        gVar3.k = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "viewportWidth", 7, gVar3.k);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "viewportHeight", 8, gVar3.l);
        gVar3.l = namedFloat;
        if (gVar3.k <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (namedFloat > 0.0f) {
            gVar3.i = obtainAttributes.getDimension(3, gVar3.i);
            int i6 = 2;
            float dimension = obtainAttributes.getDimension(2, gVar3.j);
            gVar3.j = dimension;
            if (gVar3.i <= 0.0f) {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar3.setAlpha(TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "alpha", 4, gVar3.getAlpha()));
                String string = obtainAttributes.getString(0);
                if (string != null) {
                    gVar3.n = string;
                    gVar3.p.put(string, gVar3);
                }
                obtainAttributes.recycle();
                hVar.a = getChangingConfigurations();
                hVar.k = true;
                h hVar3 = this.b;
                g gVar4 = hVar3.b;
                ArrayDeque arrayDeque3 = new ArrayDeque();
                arrayDeque3.push(gVar4.h);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z = true;
                while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                    if (eventType == i6) {
                        String name = xmlPullParser.getName();
                        d dVar = (d) arrayDeque3.peek();
                        if (MessageMetaInfo.COLUMN_PATH.equals(name)) {
                            c cVar2 = new c();
                            TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, l6.a0.a.a.a.c);
                            cVar2.e = null;
                            if (!TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                                typedArray = obtainAttributes2;
                                arrayDeque2 = arrayDeque3;
                                gVar2 = gVar4;
                                cVar = cVar2;
                                i2 = depth;
                            } else {
                                String string2 = obtainAttributes2.getString(0);
                                if (string2 != null) {
                                    cVar2.b = string2;
                                }
                                String string3 = obtainAttributes2.getString(2);
                                if (string3 != null) {
                                    cVar2.a = PathParser.createNodesFromPathData(string3);
                                }
                                arrayDeque2 = arrayDeque3;
                                gVar2 = gVar4;
                                i2 = depth;
                                cVar = cVar2;
                                cVar.h = TypedArrayUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "fillColor", 1, 0);
                                cVar.j = TypedArrayUtils.getNamedFloat(obtainAttributes2, xmlPullParser, "fillAlpha", 12, cVar.j);
                                int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes2, xmlPullParser, "strokeLineCap", 8, -1);
                                Paint.Cap cap = cVar.n;
                                if (namedInt2 == 0) {
                                    i3 = 2;
                                    cap = Paint.Cap.BUTT;
                                } else if (namedInt2 != 1) {
                                    i3 = 2;
                                    if (namedInt2 == 2) {
                                        cap = Paint.Cap.SQUARE;
                                    }
                                } else {
                                    i3 = 2;
                                    cap = Paint.Cap.ROUND;
                                }
                                cVar.n = cap;
                                int namedInt3 = TypedArrayUtils.getNamedInt(obtainAttributes2, xmlPullParser, "strokeLineJoin", 9, -1);
                                Paint.Join join = cVar.o;
                                if (namedInt3 == 0) {
                                    join = Paint.Join.MITER;
                                } else if (namedInt3 == 1) {
                                    join = Paint.Join.ROUND;
                                } else if (namedInt3 == i3) {
                                    join = Paint.Join.BEVEL;
                                }
                                cVar.o = join;
                                cVar.p = TypedArrayUtils.getNamedFloat(obtainAttributes2, xmlPullParser, "strokeMiterLimit", 10, cVar.p);
                                typedArray = obtainAttributes2;
                                cVar.f = TypedArrayUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "strokeColor", 3, 0);
                                cVar.i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, cVar.i);
                                cVar.g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, cVar.g);
                                cVar.l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, cVar.l);
                                cVar.m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, cVar.m);
                                cVar.k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, cVar.k);
                                cVar.c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, cVar.c);
                            }
                            typedArray.recycle();
                            dVar.b.add(cVar);
                            if (cVar.getPathName() != null) {
                                gVar = gVar2;
                                gVar.p.put(cVar.getPathName(), cVar);
                            } else {
                                gVar = gVar2;
                            }
                            hVar3.a |= cVar.d;
                            arrayDeque = arrayDeque2;
                            i5 = 1;
                            z = false;
                        } else {
                            gVar = gVar4;
                            i2 = depth;
                            if ("clip-path".equals(name)) {
                                b bVar = new b();
                                if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                                    TypedArray obtainAttributes3 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, l6.a0.a.a.a.d);
                                    String string4 = obtainAttributes3.getString(0);
                                    if (string4 != null) {
                                        bVar.b = string4;
                                    }
                                    String string5 = obtainAttributes3.getString(1);
                                    if (string5 != null) {
                                        bVar.a = PathParser.createNodesFromPathData(string5);
                                    }
                                    bVar.c = TypedArrayUtils.getNamedInt(obtainAttributes3, xmlPullParser, "fillType", 2, 0);
                                    obtainAttributes3.recycle();
                                }
                                dVar.b.add(bVar);
                                if (bVar.getPathName() != null) {
                                    gVar.p.put(bVar.getPathName(), bVar);
                                }
                                hVar3.a = bVar.d | hVar3.a;
                            } else if (Navigation.GROUP.equals(name)) {
                                d dVar2 = new d();
                                TypedArray obtainAttributes4 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, l6.a0.a.a.a.b);
                                dVar2.l = null;
                                dVar2.c = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "rotation", 5, dVar2.c);
                                i5 = 1;
                                dVar2.d = obtainAttributes4.getFloat(1, dVar2.d);
                                dVar2.e = obtainAttributes4.getFloat(2, dVar2.e);
                                dVar2.f = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "scaleX", 3, dVar2.f);
                                dVar2.g = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "scaleY", 4, dVar2.g);
                                dVar2.h = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "translateX", 6, dVar2.h);
                                dVar2.i = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "translateY", 7, dVar2.i);
                                String string6 = obtainAttributes4.getString(0);
                                if (string6 != null) {
                                    dVar2.m = string6;
                                }
                                dVar2.c();
                                obtainAttributes4.recycle();
                                dVar.b.add(dVar2);
                                arrayDeque = arrayDeque3;
                                arrayDeque.push(dVar2);
                                if (dVar2.getGroupName() != null) {
                                    gVar.p.put(dVar2.getGroupName(), dVar2);
                                }
                                hVar3.a = dVar2.k | hVar3.a;
                            }
                            arrayDeque = arrayDeque3;
                            i5 = 1;
                        }
                    } else {
                        arrayDeque = arrayDeque3;
                        gVar = gVar4;
                        i2 = depth;
                        i5 = 1;
                        if (eventType == 3 && Navigation.GROUP.equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i6 = 2;
                    i4 = 3;
                    gVar4 = gVar;
                    arrayDeque3 = arrayDeque;
                    depth = i2;
                }
                if (!z) {
                    this.c = a(hVar.c, hVar.d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            } else {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public VectorDrawableCompat(@NonNull h hVar) {
        this.f = true;
        this.g = new float[9];
        this.h = new Matrix();
        this.i = new Rect();
        this.b = hVar;
        this.c = a(hVar.c, hVar.d);
    }

    public static class c extends f {
        public int[] e;
        public ComplexColorCompat f;
        public float g = 0.0f;
        public ComplexColorCompat h;
        public float i = 1.0f;
        public float j = 1.0f;
        public float k = 0.0f;
        public float l = 1.0f;
        public float m = 0.0f;
        public Paint.Cap n = Paint.Cap.BUTT;
        public Paint.Join o = Paint.Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e
        public boolean a() {
            return this.h.isStateful() || this.f.isStateful();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e
        public boolean b(int[] iArr) {
            return this.f.onStateChanged(iArr) | this.h.onStateChanged(iArr);
        }

        public float getFillAlpha() {
            return this.j;
        }

        @ColorInt
        public int getFillColor() {
            return this.h.getColor();
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        @ColorInt
        public int getStrokeColor() {
            return this.f.getColor();
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.h.setColor(i2);
        }

        public void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f.setColor(i2);
        }

        public void setStrokeWidth(float f2) {
            this.g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public c(c cVar) {
            super(cVar);
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.c = cVar.c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    public static class g {
        public static final Matrix q = new Matrix();
        public final Path a;
        public final Path b;
        public final Matrix c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public int g;
        public final d h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final ArrayMap<String, Object> p;

        public g() {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new ArrayMap<>();
            this.h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v11, resolved type: android.graphics.PathMeasure */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.d r18, android.graphics.Matrix r19, android.graphics.Canvas r20, int r21, int r22, android.graphics.ColorFilter r23) {
            /*
            // Method dump skipped, instructions count: 594
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.g.a(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$d, android.graphics.Matrix, android.graphics.Canvas, int, int, android.graphics.ColorFilter):void");
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public g(g gVar) {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.p = arrayMap;
            this.h = new d(gVar.h, arrayMap);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.o = gVar.o;
        }
    }

    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d(d dVar, ArrayMap<String, Object> arrayMap) {
            super(null);
            f fVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.b.add(new d((d) eVar, arrayMap));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(fVar);
                    String str2 = fVar.b;
                    if (str2 != null) {
                        arrayMap.put(str2, fVar);
                    }
                }
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e
        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                z |= this.b.get(i2).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                c();
            }
        }

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
