package com.avito.android.lib.expected.progress_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0002\u0012\b\b\u0002\u0010R\u001a\u00020\u0002¢\u0006\u0004\bS\u0010TJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R*\u00102\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00106\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b3\u0010 \u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R*\u0010:\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b7\u0010 \u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010B\u001a\u00020;8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b?\u0010=\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010\u0018R\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010FR*\u0010I\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006U"}, d2 = {"Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", AuthSource.SEND_ABUSE, "()V", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "fillPath", "", "f", "F", "radius", "value", "j", "I", "getBarHeight", "()I", "setBarHeight", "(I)V", "barHeight", g.a, "Z", "useClipping", "", AuthSource.BOOKING_ORDER, "[F", "radii", AuthSource.OPEN_CHANNEL_LIST, "getProgress", "()F", "setProgress", "(F)V", "progress", "l", "getFillColor", "setFillColor", "fillColor", "k", "getEmptyColor", "setEmptyColor", "emptyColor", "Landroid/graphics/RectF;", "c", "Landroid/graphics/RectF;", "bounds", "h", "getFillBounds$components_release", "()Landroid/graphics/RectF;", "fillBounds", "d", "boundsPath", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "i", "isFairProgress", "()Z", "setFairProgress", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressBar extends View {
    public final Paint a;
    public final float[] b;
    public final RectF c;
    public final Path d;
    public final Path e;
    public float f;
    public boolean g;
    @NotNull
    public final RectF h;
    public boolean i;
    public int j;
    @ColorInt
    public int k;
    @ColorInt
    public int l;
    public float m;

    @JvmOverloads
    public ProgressBar(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public ProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public ProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressBar(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.progressBar : i2, (i4 & 8) != 0 ? R.style.Design_Widget_ProgressBar : i3);
    }

    public final void a() {
        float width = this.c.width() * this.m;
        if (!this.i) {
            if (ProgressBarKt.access$inOpenInterval(width, 0.0f, this.f)) {
                width = this.f;
            } else if (ProgressBarKt.access$inOpenInterval(width, this.c.width() - this.f, this.c.width())) {
                width = this.c.width() - this.f;
            }
        }
        float f2 = this.m == 1.0f ? this.f : 0.0f;
        float[] fArr = this.b;
        float f3 = this.f;
        ProgressBarKt.access$setRadii(fArr, f3, f2, f2, f3);
        RectF rectF = this.h;
        RectF rectF2 = this.c;
        rectF.set(0.0f, rectF2.top, width, rectF2.bottom);
        this.e.reset();
        this.e.addRoundRect(this.h, this.b, Path.Direction.CW);
        float[] fArr2 = this.b;
        float f4 = this.f;
        ProgressBarKt.access$setRadii(fArr2, f4, f4, f4, f4);
        this.d.reset();
        this.d.addRoundRect(this.c, this.b, Path.Direction.CW);
        float f5 = this.h.right;
        float f6 = this.f;
        this.g = !ProgressBarKt.access$inOpenInterval(f5, f6, this.c.right - f6);
    }

    public final int getBarHeight() {
        return this.j;
    }

    public final int getEmptyColor() {
        return this.k;
    }

    @NotNull
    public final RectF getFillBounds$components_release() {
        return this.h;
    }

    public final int getFillColor() {
        return this.l;
    }

    public final float getProgress() {
        return this.m;
    }

    public final boolean isFairProgress() {
        return this.i;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.g) {
            canvas.save();
            canvas.clipPath(this.d);
            RectF rectF = this.c;
            float f2 = this.f;
            Paint paint = this.a;
            paint.setColor(this.k);
            canvas.drawRoundRect(rectF, f2, f2, paint);
            Path path = this.e;
            Paint paint2 = this.a;
            paint2.setColor(this.l);
            canvas.drawPath(path, paint2);
            canvas.restore();
            return;
        }
        RectF rectF2 = this.c;
        float f3 = this.f;
        Paint paint3 = this.a;
        paint3.setColor(this.k);
        canvas.drawRoundRect(rectF2, f3, f3, paint3);
        Path path2 = this.e;
        Paint paint4 = this.a;
        paint4.setColor(this.l);
        canvas.drawPath(path2, paint4);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i3;
        float f2 = ((float) (i6 - this.j)) / 2.0f;
        this.c.set(0.0f, f2, (float) (i4 - i2), ((float) i6) - f2);
        this.f = this.c.height() / ((float) 2);
        a();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int i5 = 0;
        if (mode == Integer.MIN_VALUE) {
            i4 = View.MeasureSpec.getSize(i2);
        } else if (mode == 0) {
            i4 = this.j * 5;
        } else if (mode != 1073741824) {
            i4 = 0;
        } else {
            i4 = View.MeasureSpec.getSize(i2);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE) {
            i5 = Math.min(this.j, View.MeasureSpec.getSize(i3));
        } else if (mode2 == 0) {
            i5 = this.j;
        } else if (mode2 == 1073741824) {
            i5 = View.MeasureSpec.getSize(i3);
        }
        setMeasuredDimension(i4, i5);
    }

    public final void setBarHeight(int i2) {
        this.j = i2;
        requestLayout();
    }

    public final void setEmptyColor(int i2) {
        if (this.k != i2) {
            this.k = i2;
            postInvalidateOnAnimation();
        }
    }

    public final void setFairProgress(boolean z) {
        if (this.i != z) {
            this.i = z;
            a();
            postInvalidateOnAnimation();
        }
    }

    public final void setFillColor(int i2) {
        if (this.l != i2) {
            this.l = i2;
            postInvalidateOnAnimation();
        }
    }

    public final void setProgress(float f2) {
        this.m = e.coerceIn(f2, 0.0f, 1.0f);
        a();
        postInvalidateOnAnimation();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new Paint(1);
        this.b = new float[8];
        this.c = new RectF();
        this.d = new Path();
        this.e = new Path();
        this.h = new RectF();
        this.i = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ProgressBar, i2, i3);
        setEmptyColor(obtainStyledAttributes.getColor(R.styleable.ProgressBar_progressBar_emptyColor, this.k));
        setFillColor(obtainStyledAttributes.getColor(R.styleable.ProgressBar_progressBar_fillColor, this.l));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.ProgressBar_progressBar_progress, this.m));
        setBarHeight(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ProgressBar_progressBar_barHeight, this.j));
        setFairProgress(obtainStyledAttributes.getBoolean(R.styleable.ProgressBar_progressBar_isFairProgress, this.i));
        obtainStyledAttributes.recycle();
        if (isInEditMode()) {
            invalidate();
        }
    }
}
