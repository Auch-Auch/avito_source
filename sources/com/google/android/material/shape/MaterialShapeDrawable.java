package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.BitSet;
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    public static final String w = MaterialShapeDrawable.class.getSimpleName();
    public static final Paint x = new Paint(1);
    public b a;
    public final ShapePath.c[] b;
    public final ShapePath.c[] c;
    public final BitSet d;
    public boolean e;
    public final Matrix f;
    public final Path g;
    public final Path h;
    public final RectF i;
    public final RectF j;
    public final Region k;
    public final Region l;
    public ShapeAppearanceModel m;
    public final Paint n;
    public final Paint o;
    public final ShadowRenderer p;
    @NonNull
    public final ShapeAppearancePathProvider.PathListener q;
    public final ShapeAppearancePathProvider r;
    @Nullable
    public PorterDuffColorFilter s;
    @Nullable
    public PorterDuffColorFilter t;
    @NonNull
    public final RectF u;
    public boolean v;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public class a implements ShapeAppearancePathProvider.PathListener {
        public a() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.this.d.set(i, shapePath.c);
            ShapePath.c[] cVarArr = MaterialShapeDrawable.this.b;
            shapePath.a(shapePath.endShadowAngle);
            cVarArr[i] = new a2.j.b.d.o.b(shapePath, new ArrayList(shapePath.b), new Matrix(matrix));
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.this.d.set(i + 4, shapePath.c);
            ShapePath.c[] cVarArr = MaterialShapeDrawable.this.c;
            shapePath.a(shapePath.endShadowAngle);
            cVarArr[i] = new a2.j.b.d.o.b(shapePath, new ArrayList(shapePath.b), new Matrix(matrix));
        }
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    public final void a(@NonNull RectF rectF, @NonNull Path path) {
        calculatePathForSize(rectF, path);
        if (this.a.j != 1.0f) {
            this.f.reset();
            Matrix matrix = this.f;
            float f2 = this.a.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f);
        }
        path.computeBounds(this.u, true);
    }

    @NonNull
    public final PorterDuffColorFilter b(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        int color;
        int compositeElevationOverlayIfNeeded;
        if (colorStateList == null || mode == null) {
            return (!z || (compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final void c(@NonNull Canvas canvas) {
        this.d.cardinality();
        if (this.a.s != 0) {
            canvas.drawPath(this.g, this.p.getShadowPaint());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            ShapePath.c cVar = this.b[i2];
            ShadowRenderer shadowRenderer = this.p;
            int i3 = this.a.r;
            Matrix matrix = ShapePath.c.a;
            cVar.a(matrix, shadowRenderer, i3, canvas);
            this.c[i2].a(matrix, this.p, this.a.r, canvas);
        }
        if (this.v) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.g, x);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.r;
        b bVar = this.a;
        shapeAppearancePathProvider.calculatePath(bVar.a, bVar.k, rectF, this.q, path);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int i2) {
        float parentAbsoluteElevation = getParentAbsoluteElevation() + getZ();
        ElevationOverlayProvider elevationOverlayProvider = this.a.b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i2, parentAbsoluteElevation) : i2;
    }

    public final void d(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (shapeAppearanceModel.isRoundRect(rectF)) {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.a.k;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        Paint paint = this.n;
        int i2 = this.a.m;
        paint.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.a.l);
        int alpha2 = this.o.getAlpha();
        Paint paint2 = this.o;
        int i3 = this.a.m;
        paint2.setAlpha(((i3 + (i3 >>> 7)) * alpha2) >>> 8);
        boolean z = false;
        if (this.e) {
            ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new a2.j.b.d.o.a(this, -e()));
            this.m = withTransformedCornerSizes;
            ShapeAppearancePathProvider shapeAppearancePathProvider = this.r;
            float f2 = this.a.k;
            this.j.set(getBoundsAsRectF());
            float e2 = e();
            this.j.inset(e2, e2);
            shapeAppearancePathProvider.calculatePath(withTransformedCornerSizes, f2, this.j, this.h);
            a(getBoundsAsRectF(), this.g);
            this.e = false;
        }
        b bVar = this.a;
        int i4 = bVar.q;
        if (i4 != 1 && bVar.r > 0 && (i4 == 2 || requiresCompatShadow())) {
            canvas.save();
            canvas.translate((float) getShadowOffsetX(), (float) getShadowOffsetY());
            if (!this.v) {
                c(canvas);
                canvas.restore();
            } else {
                int width = (int) (this.u.width() - ((float) getBounds().width()));
                int height = (int) (this.u.height() - ((float) getBounds().height()));
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(a2.b.a.a.a.c2(this.a.r, 2, (int) this.u.width(), width), a2.b.a.a.a.c2(this.a.r, 2, (int) this.u.height(), height), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f3 = (float) ((getBounds().left - this.a.r) - width);
                float f4 = (float) ((getBounds().top - this.a.r) - height);
                canvas2.translate(-f3, -f4);
                c(canvas2);
                canvas.drawBitmap(createBitmap, f3, f4, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
            }
        }
        b bVar2 = this.a;
        Paint.Style style = bVar2.v;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            z = true;
        }
        if (z) {
            d(canvas, this.n, this.g, bVar2.a, getBoundsAsRectF());
        }
        if (f()) {
            Paint paint3 = this.o;
            Path path = this.h;
            ShapeAppearanceModel shapeAppearanceModel = this.m;
            this.j.set(getBoundsAsRectF());
            float e3 = e();
            this.j.inset(e3, e3);
            d(canvas, paint3, path, shapeAppearanceModel, this.j);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        d(canvas, paint, path, this.a.a, rectF);
    }

    public final float e() {
        if (f()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final boolean f() {
        Paint.Style style = this.a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    public final boolean g(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.a.d == null || color2 == (colorForState2 = this.a.d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.a.e == null || color == (colorForState = this.a.e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.a.a.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.a.a.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.i.set(getBounds());
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    public float getElevation() {
        return this.a.o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.a.d;
    }

    public float getInterpolation() {
        return this.a.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.a.q != 2) {
            if (isRoundRect()) {
                outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.a.k);
                return;
            }
            a(getBoundsAsRectF(), this.g);
            if (this.g.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.g);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.a.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.a.v;
    }

    public float getParentAbsoluteElevation() {
        return this.a.n;
    }

    @Deprecated
    public void getPathForSize(int i2, int i3, @NonNull Path path) {
        calculatePathForSize(new RectF(0.0f, 0.0f, (float) i2, (float) i3), path);
    }

    public float getScale() {
        return this.a.j;
    }

    public int getShadowCompatRotation() {
        return this.a.t;
    }

    public int getShadowCompatibilityMode() {
        return this.a.q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        b bVar = this.a;
        return (int) (Math.sin(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public int getShadowOffsetY() {
        b bVar = this.a;
        return (int) (Math.cos(Math.toRadians((double) bVar.t)) * ((double) bVar.s));
    }

    public int getShadowRadius() {
        return this.a.r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.a.s;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.a.a;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.a.e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.a.f;
    }

    public float getStrokeWidth() {
        return this.a.l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.a.g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.a.a.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.a.a.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        a(getBoundsAsRectF(), this.g);
        this.l.setPath(this.g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    public float getZ() {
        return getTranslationZ() + getElevation();
    }

    public final boolean h() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        b bVar = this.a;
        this.s = b(bVar.g, bVar.h, this.n, true);
        b bVar2 = this.a;
        this.t = b(bVar2.f, bVar2.h, this.o, false);
        b bVar3 = this.a;
        if (bVar3.u) {
            this.p.setShadowColor(bVar3.g.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(porterDuffColorFilter, this.s) || !ObjectsCompat.equals(porterDuffColorFilter2, this.t)) {
            return true;
        }
        return false;
    }

    public final void i() {
        float z = getZ();
        this.a.r = (int) Math.ceil((double) (0.75f * z));
        this.a.s = (int) Math.ceil((double) (z * 0.25f));
        h();
        super.invalidateSelf();
    }

    public void initializeElevationOverlay(Context context) {
        this.a.b = new ElevationOverlayProvider(context);
        i();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.a.b;
        return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.a.b != null;
    }

    public boolean isPointInTransparentRegion(int i2, int i3) {
        return getTransparentRegion().contains(i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.a.a.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i2 = this.a.q;
        return i2 == 0 || i2 == 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.a.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.a.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.a.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.a.d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.a = new b(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z = g(iArr) || h();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public boolean requiresCompatShadow() {
        return !isRoundRect() && !this.g.isConvex() && Build.VERSION.SDK_INT < 29;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        b bVar = this.a;
        if (bVar.m != i2) {
            bVar.m = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.c = colorFilter;
        super.invalidateSelf();
    }

    public void setCornerSize(float f2) {
        setShapeAppearanceModel(this.a.a.withCornerSize(f2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z) {
        this.r.l = z;
    }

    public void setElevation(float f2) {
        b bVar = this.a;
        if (bVar.o != f2) {
            bVar.o = f2;
            i();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        b bVar = this.a;
        if (bVar.d != colorStateList) {
            bVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f2) {
        b bVar = this.a;
        if (bVar.k != f2) {
            bVar.k = f2;
            this.e = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        b bVar = this.a;
        if (bVar.i == null) {
            bVar.i = new Rect();
        }
        this.a.i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.a.v = style;
        super.invalidateSelf();
    }

    public void setParentAbsoluteElevation(float f2) {
        b bVar = this.a;
        if (bVar.n != f2) {
            bVar.n = f2;
            i();
        }
    }

    public void setScale(float f2) {
        b bVar = this.a;
        if (bVar.j != f2) {
            bVar.j = f2;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z) {
        this.v = z;
    }

    public void setShadowColor(int i2) {
        this.p.setShadowColor(i2);
        this.a.u = false;
        super.invalidateSelf();
    }

    public void setShadowCompatRotation(int i2) {
        b bVar = this.a;
        if (bVar.t != i2) {
            bVar.t = i2;
            super.invalidateSelf();
        }
    }

    public void setShadowCompatibilityMode(int i2) {
        b bVar = this.a;
        if (bVar.q != i2) {
            bVar.q = i2;
            super.invalidateSelf();
        }
    }

    @Deprecated
    public void setShadowElevation(int i2) {
        setElevation((float) i2);
    }

    @Deprecated
    public void setShadowEnabled(boolean z) {
        setShadowCompatibilityMode(!z ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i2) {
        this.a.r = i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i2) {
        b bVar = this.a;
        if (bVar.s != i2) {
            bVar.s = i2;
            super.invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.a.a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f2, @ColorInt int i2) {
        setStrokeWidth(f2);
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        b bVar = this.a;
        if (bVar.e != colorStateList) {
            bVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.a.f = colorStateList;
        h();
        super.invalidateSelf();
    }

    public void setStrokeWidth(float f2) {
        this.a.l = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.a.g = colorStateList;
        h();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        b bVar = this.a;
        if (bVar.h != mode) {
            bVar.h = mode;
            h();
            super.invalidateSelf();
        }
    }

    public void setTranslationZ(float f2) {
        b bVar = this.a;
        if (bVar.p != f2) {
            bVar.p = f2;
            i();
        }
    }

    public void setUseTintColorForShadow(boolean z) {
        b bVar = this.a;
        if (bVar.u != z) {
            bVar.u = z;
            invalidateSelf();
        }
    }

    public void setZ(float f2) {
        setTranslationZ(f2 - getElevation());
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i2, i3).build());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f2) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f2);
        return materialShapeDrawable;
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.a.a.withCornerSize(cornerSize));
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStroke(float f2, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f2);
        setStrokeColor(colorStateList);
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new b(shapeAppearanceModel, null));
    }

    public void setStrokeTint(@ColorInt int i2) {
        setStrokeTint(ColorStateList.valueOf(i2));
    }

    public MaterialShapeDrawable(@NonNull b bVar) {
        this.b = new ShapePath.c[4];
        this.c = new ShapePath.c[4];
        this.d = new BitSet(8);
        this.f = new Matrix();
        this.g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        Paint paint = new Paint(1);
        this.n = paint;
        Paint paint2 = new Paint(1);
        this.o = paint2;
        this.p = new ShadowRenderer();
        this.r = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.u = new RectF();
        this.v = true;
        this.a = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = x;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        h();
        g(getState());
        this.q = new a();
    }

    public static final class b extends Drawable.ConstantState {
        @NonNull
        public ShapeAppearanceModel a;
        @Nullable
        public ElevationOverlayProvider b;
        @Nullable
        public ColorFilter c;
        @Nullable
        public ColorStateList d = null;
        @Nullable
        public ColorStateList e = null;
        @Nullable
        public ColorStateList f = null;
        @Nullable
        public ColorStateList g = null;
        @Nullable
        public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
        @Nullable
        public Rect i = null;
        public float j = 1.0f;
        public float k = 1.0f;
        public float l;
        public int m = 255;
        public float n = 0.0f;
        public float o = 0.0f;
        public float p = 0.0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public b(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.a = shapeAppearanceModel;
            this.b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.e = true;
            return materialShapeDrawable;
        }

        public b(@NonNull b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
            this.l = bVar.l;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.h = bVar.h;
            this.g = bVar.g;
            this.m = bVar.m;
            this.j = bVar.j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f = bVar.f;
            this.v = bVar.v;
            if (bVar.i != null) {
                this.i = new Rect(bVar.i);
            }
        }
    }
}
