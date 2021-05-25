package com.avito.android.serp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b.\u00100B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00101\u001a\u00020\r¢\u0006\u0004\b.\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010 ¨\u00063"}, d2 = {"Lcom/avito/android/serp/AdRoundedRatioImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "drawableStateChanged", "()V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Bitmap;", "bm", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setVisibility", "(I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/util/AttributeSet;", "attrs", AuthSource.SEND_ABUSE, "(Landroid/util/AttributeSet;)V", "e", "I", "heightRatio", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "foregroundDrawable", "", "c", "F", "cornerRadius", "d", "widthRatio", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdRoundedRatioImageView extends AppCompatImageView {
    public float c;
    public int d;
    public int e;
    public Drawable f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedRatioImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = 1;
        this.e = 1;
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AdRoundedRatioImageView);
        this.c = obtainStyledAttributes.getDimension(R.styleable.AdRoundedRatioImageView_corner_radius, 0.0f);
        this.d = obtainStyledAttributes.getInt(R.styleable.AdRoundedRatioImageView_width_ratio, 0);
        this.e = obtainStyledAttributes.getInt(R.styleable.AdRoundedRatioImageView_height_ratio, 0);
        this.f = obtainStyledAttributes.getDrawable(R.styleable.AdRoundedRatioImageView_android_foreground);
        obtainStyledAttributes.recycle();
        if (this.d <= 0 || this.e <= 0) {
            throw new IllegalStateException("Need used width_ratio and height_ratio attrs");
        }
    }

    @Override // android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setState(getDrawableState());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (size <= 0 || mode == 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((size * this.e) / this.d, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        if (i != i3 && i > 0 && (drawable instanceof RoundedBitmapDrawable)) {
            setImageBitmap(((RoundedBitmapDrawable) drawable).getBitmap());
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(@Nullable Bitmap bitmap) {
        if (bitmap == null || this.c < ((float) 1)) {
            super.setImageBitmap(bitmap);
            return;
        }
        if (bitmap.getWidth() * this.e > bitmap.getHeight() * this.d) {
            int height = (bitmap.getHeight() * this.d) / this.e;
            bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - height) / 2, 0, height, bitmap.getHeight());
        } else if (bitmap.getWidth() * this.e < bitmap.getHeight() * this.d) {
            int width = (bitmap.getWidth() * this.e) / this.d;
            bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - width) / 2, bitmap.getWidth(), width);
        }
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        Intrinsics.checkNotNullExpressionValue(create, "RoundedBitmapDrawableFac…eate(resources, resizeBm)");
        if (getWidth() > 0) {
            float f2 = this.c;
            Intrinsics.checkNotNullExpressionValue(bitmap, "resizeBm");
            create.setCornerRadius((f2 * ((float) bitmap.getWidth())) / ((float) getWidth()));
            setScaleType(getWidth() > bitmap.getWidth() ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.CENTER_INSIDE);
        } else {
            create.setCornerRadius(this.c);
        }
        super.setImageDrawable(create);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            setImageAlpha(255);
            return;
        }
        setImageAlpha(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedRatioImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRoundedRatioImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }
}
