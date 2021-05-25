package ru.avito.component.serp;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.util.Contexts;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u00109\u001a\u000208\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00103\u001a\n 0*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u001bR\u0016\u00107\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\u001b¨\u0006<"}, d2 = {"Lru/avito/component/serp/MetroLinesDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Rect;", "getDirtyBounds", "()Landroid/graphics/Rect;", "", "getIntrinsicWidth", "()I", "getIntrinsicHeight", "alpha", "setAlpha", "(I)V", "getOpacity", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "d", "Landroid/graphics/Rect;", "sizeRect", "", g.a, "F", "strokeRadius", "h", "offset", "f", "dotRadius", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "circlePaint", "c", "strokePaint", "k", "I", "strokeColor", "", "Lcom/avito/android/remote/model/Color;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "colors", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "e", "Landroid/content/res/Resources;", "resources", "i", "stroke", "j", "bottomTranslation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MetroLinesDrawable extends Drawable {
    public final List<Color> a;
    public final Paint b;
    public final Paint c;
    public final Rect d;
    public final Resources e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final int k;

    public MetroLinesDrawable(@NotNull Context context, @NotNull List<Color> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "colors");
        this.a = CollectionsKt___CollectionsKt.reversed(list);
        Paint paint = new Paint();
        this.b = paint;
        Paint paint2 = new Paint();
        this.c = paint2;
        Rect rect = new Rect();
        this.d = rect;
        Resources resources = context.getResources();
        this.e = resources;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f2 = ((float) 3) * resources.getDisplayMetrics().density;
        this.f = f2;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f3 = resources.getDisplayMetrics().density * 3.5f;
        this.g = f3;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f4 = ((float) 5) * resources.getDisplayMetrics().density;
        this.h = f4;
        float f5 = (float) 1;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f6 = resources.getDisplayMetrics().density * f5;
        this.i = f6;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.j = f5 * resources.getDisplayMetrics().density;
        int colorByAttr = Contexts.getColorByAttr(context, R.attr.white);
        this.k = colorByAttr;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f6);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setColor(colorByAttr);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        float f7 = (float) 2;
        rect.bottom = c.roundToInt(f3 * f7);
        rect.right = c.roundToInt((((float) CollectionsKt__CollectionsKt.getLastIndex(list)) * f4) + (f2 * f7));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        canvas.translate(0.0f, this.j);
        int i2 = 0;
        for (T t : this.a) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            this.b.setColor(t.getValue());
            float lastIndex = ((float) (CollectionsKt__CollectionsKt.getLastIndex(this.a) - i2)) * this.h;
            float f2 = this.f;
            float f3 = lastIndex + f2;
            canvas.drawCircle(f3, this.g, f2, this.b);
            float f4 = this.g;
            canvas.drawCircle(f3, f4, f4, this.c);
            i2 = i3;
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public Rect getDirtyBounds() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d.bottom;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d.right;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
