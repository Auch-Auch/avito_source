package com.avito.android.lib.design.photo_uploader_image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u000bR*\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u000b¨\u0006\""}, d2 = {"Lcom/avito/android/lib/design/photo_uploader_image/PhotoUploaderLayout;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "(I)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "value", "I", "getRatioWidth", "()I", "setRatioWidth", "ratioWidth", AuthSource.BOOKING_ORDER, "getRatioHeight", "setRatioHeight", "ratioHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploaderLayout extends FrameLayout implements AppearanceChangeableView {
    public int a;
    public int b;

    @JvmOverloads
    public PhotoUploaderLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public PhotoUploaderLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public PhotoUploaderLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploaderLayout(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.photoUploaderLayout : i, (i3 & 8) != 0 ? R.style.Design_Widget_PhotoUploaderLayout : i2);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(TypedArray typedArray) {
        setRatioWidth(typedArray.getInt(R.styleable.PhotoUploaderLayout_photoUploaderLayout_ratioWidth, this.a));
        setRatioHeight(typedArray.getInt(R.styleable.PhotoUploaderLayout_photoUploaderLayout_ratioHeight, this.b));
    }

    public final int getRatioHeight() {
        return this.b;
    }

    public final int getRatioWidth() {
        return this.a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (size <= 0 || mode == 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((size * this.b) / this.a, 1073741824));
        }
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.PhotoUploaderLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setRatioHeight(int i) {
        this.b = e.coerceAtLeast(i, 1);
        requestLayout();
    }

    public final void setRatioWidth(int i) {
        this.a = e.coerceAtLeast(i, 1);
        requestLayout();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoUploaderLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 1;
        this.b = 1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhotoUploaderLayout, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
