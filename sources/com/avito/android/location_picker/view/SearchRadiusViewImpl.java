package com.avito.android.location_picker.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.location_picker.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001bB!\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u0019\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/avito/android/location_picker/view/SearchRadiusViewImpl;", "Landroid/view/View;", "Lcom/avito/android/location_picker/view/SearchRadiusView;", "", "radius", "", "setRadius", "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/util/AttributeSet;)V", "Landroid/graphics/Paint;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "fillPaint", "c", "strokePaint", "F", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SearchRadiusViewImpl extends View implements SearchRadiusView {
    public float a = 400.0f;
    public final Paint b = new Paint(1);
    public final Paint c = new Paint(1);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchRadiusViewImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SearchRadiusViewImpl);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SearchRadiusViewImpl_fillColor);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.SearchRadiusViewImpl_strokeColor);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SearchRadiusViewImpl_strokeWidth, 2.0f);
        obtainStyledAttributes.recycle();
        if (colorStateList != null) {
            this.b.setColor(colorStateList.getDefaultColor());
        }
        this.b.setStyle(Paint.Style.FILL);
        if (colorStateList2 != null) {
            this.c.setColor(colorStateList2.getDefaultColor());
        }
        Paint paint = this.c;
        paint.setStrokeWidth(dimension);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        Rect clipBounds;
        Rect clipBounds2;
        super.onDraw(canvas);
        int i = 0;
        int width = (canvas == null || (clipBounds2 = canvas.getClipBounds()) == null) ? 0 : clipBounds2.width();
        if (!(canvas == null || (clipBounds = canvas.getClipBounds()) == null)) {
            i = clipBounds.height();
        }
        if (canvas != null) {
            canvas.drawCircle(((float) width) / 2.0f, ((float) i) / 2.0f, this.a, this.b);
        }
        if (canvas != null) {
            canvas.drawCircle(((float) width) / 2.0f, ((float) i) / 2.0f, this.a, this.c);
        }
    }

    @Override // com.avito.android.location_picker.view.SearchRadiusView
    public void setRadius(float f) {
        this.a = f;
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchRadiusViewImpl(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchRadiusViewImpl(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(attributeSet);
    }
}
