package com.avito.android.design.widget.recommendation_graph;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.Contexts;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/avito/android/design/widget/recommendation_graph/VerticalDottedLine;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", AuthSource.SEND_ABUSE, "F", "getRadius", "()F", "radius", AuthSource.BOOKING_ORDER, "getDistance", "setDistance", "(F)V", Sort.DISTANCE, "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalDottedLine extends View {
    public final float a;
    public float b;
    @NotNull
    public final Paint c;

    @JvmOverloads
    public VerticalDottedLine(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public VerticalDottedLine(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalDottedLine(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float getDistance() {
        return this.b;
    }

    @NotNull
    public final Paint getPaint() {
        return this.c;
    }

    public final float getRadius() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float height = (float) ((canvas.getHeight() - getPaddingTop()) - getPaddingBottom());
        float f = ((float) 2) * this.a;
        int floor = (int) Math.floor((double) ((height - f) / (this.b + f)));
        float f2 = (height - (((float) (floor + 1)) * f)) / ((float) floor);
        if (floor >= 0) {
            int i = 0;
            while (true) {
                float f3 = this.a;
                canvas.drawCircle(((float) getPaddingLeft()) + this.a, ((f + f2) * ((float) i)) + ((float) getPaddingTop()) + f3, f3, this.c);
                if (i != floor) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize((int) ((((float) 2) * this.a) + ((float) (getPaddingRight() + getPaddingLeft()))), i), View.resolveSize(getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight(), i2));
    }

    public final void setDistance(float f) {
        this.b = f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VerticalDottedLine(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.c = paint;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float applyDimension = TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
        int colorByAttr = Contexts.getColorByAttr(context, R.attr.black);
        if (attributeSet != null) {
            Resources.Theme theme = context.getTheme();
            TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, com.avito.android.ui_components.R.styleable.VerticalDottedLine, i, 0) : null;
            this.a = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.avito.android.ui_components.R.styleable.VerticalDottedLine_vdl_dot_radius, applyDimension) : applyDimension;
            this.b = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.avito.android.ui_components.R.styleable.VerticalDottedLine_vdl_gap, applyDimension) : applyDimension;
            paint.setColor(obtainStyledAttributes != null ? obtainStyledAttributes.getColor(com.avito.android.ui_components.R.styleable.VerticalDottedLine_vdl_color, colorByAttr) : colorByAttr);
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.a = applyDimension;
            this.b = applyDimension;
            paint.setColor(colorByAttr);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setFlags(1);
    }
}
