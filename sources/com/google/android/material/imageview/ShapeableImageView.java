package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    public static final int u = R.style.Widget_MaterialComponents_ShapeableImageView;
    public final ShapeAppearancePathProvider c;
    public final RectF d;
    public final RectF e;
    public final Paint f;
    public final Paint g;
    public final Path h;
    @Nullable
    public ColorStateList i;
    @Nullable
    public MaterialShapeDrawable j;
    public ShapeAppearanceModel k;
    @Dimension
    public float l;
    public Path m;
    @Dimension
    public int n;
    @Dimension
    public int o;
    @Dimension
    public int p;
    @Dimension
    public int q;
    @Dimension
    public int r;
    @Dimension
    public int s;
    public boolean t;

    @TargetApi(21)
    public class a extends ViewOutlineProvider {
        public final Rect a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            ShapeableImageView shapeableImageView = ShapeableImageView.this;
            if (shapeableImageView.k != null) {
                if (shapeableImageView.j == null) {
                    shapeableImageView.j = new MaterialShapeDrawable(ShapeableImageView.this.k);
                }
                ShapeableImageView.this.d.round(this.a);
                ShapeableImageView.this.j.setBounds(this.a);
                ShapeableImageView.this.j.getOutline(outline);
            }
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public final boolean a() {
        return (this.r == Integer.MIN_VALUE && this.s == Integer.MIN_VALUE) ? false : true;
    }

    public final boolean b() {
        return getLayoutDirection() == 1;
    }

    public final void c(int i2, int i3) {
        this.d.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.c.calculatePath(this.k, 1.0f, this.d, this.h);
        this.m.rewind();
        this.m.addPath(this.h);
        this.e.set(0.0f, 0.0f, (float) i2, (float) i3);
        this.m.addRect(this.e, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.q;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i2 = this.s;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return b() ? this.n : this.p;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.s) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.r) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.n;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.r) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.s) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.p;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i2 = this.r;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        return b() ? this.p : this.n;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.o;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.k;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.i;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.l;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.m, this.g);
        if (this.i != null) {
            this.f.setStrokeWidth(this.l);
            int colorForState = this.i.getColorForState(getDrawableState(), this.i.getDefaultColor());
            if (this.l > 0.0f && colorForState != 0) {
                this.f.setColor(colorForState);
                canvas.drawPath(this.h, this.f);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!this.t && isLayoutDirectionResolved()) {
            this.t = true;
            if (isPaddingRelative() || a()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c(i2, i3);
    }

    public void setContentPadding(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.n) + i2, (super.getPaddingTop() - this.o) + i3, (super.getPaddingRight() - this.p) + i4, (super.getPaddingBottom() - this.q) + i5);
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = i5;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i2, (super.getPaddingTop() - this.o) + i3, (super.getPaddingEnd() - getContentPaddingEnd()) + i4, (super.getPaddingBottom() - this.q) + i5);
        this.n = b() ? i4 : i2;
        this.o = i3;
        if (!b()) {
            i2 = i4;
        }
        this.p = i2;
        this.q = i5;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPadding(getContentPaddingLeft() + i2, getContentPaddingTop() + i3, getContentPaddingRight() + i4, getContentPaddingBottom() + i5);
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPaddingRelative(getContentPaddingStart() + i2, getContentPaddingTop() + i3, getContentPaddingEnd() + i4, getContentPaddingBottom() + i5);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.k = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.j;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        c(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.i = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.l != f2) {
            this.l = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.u
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            com.google.android.material.shape.ShapeAppearancePathProvider r7 = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance()
            r6.c = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.h = r7
            r7 = 0
            r6.t = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.g = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.d = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.e = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.m = r2
            int[] r2 = com.google.android.material.R.styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList(r1, r2, r4)
            r6.i = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.l = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.n = r7
            r6.o = r7
            r6.p = r7
            r6.q = r7
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.n = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.o = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.p = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.q = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.r = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.s = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.builder(r1, r8, r9, r0)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.build()
            r6.k = r7
            com.google.android.material.imageview.ShapeableImageView$a r7 = new com.google.android.material.imageview.ShapeableImageView$a
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
