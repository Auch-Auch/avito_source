package com.avito.android.lib.design.spinner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001d\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eB%\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010 B-\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/avito/android/lib/design/spinner/Spinner;", "Landroid/widget/ProgressBar;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "(I)V", "Landroid/content/res/ColorStateList;", "tint", "setTintColor", "(Landroid/content/res/ColorStateList;)V", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "I", "customMinHeight", AuthSource.BOOKING_ORDER, "customMinWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Spinner extends ProgressBar implements AppearanceChangeableView {
    public int a;
    public int b;

    public Spinner(@Nullable Context context) {
        super(context);
        b(this, null, 0, 0, 6);
    }

    public static void b(Spinner spinner, AttributeSet attributeSet, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        TypedArray obtainStyledAttributes = spinner.getContext().obtainStyledAttributes(attributeSet, R.styleable.DesignSpinner, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
        spinner.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public final void a(TypedArray typedArray) {
        int i = R.styleable.DesignSpinner_spinner_tintColor;
        if (typedArray.hasValue(i)) {
            setTintColor(typedArray.getColorStateList(i));
        }
        int i2 = R.styleable.DesignSpinner_android_minWidth;
        if (typedArray.hasValue(i2)) {
            this.b = typedArray.getDimensionPixelSize(i2, 0);
        }
        int i3 = R.styleable.DesignSpinner_android_minHeight;
        if (typedArray.hasValue(i3)) {
            this.a = typedArray.getDimensionPixelSize(i3, 0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.b, this.a);
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.DesignSpinner);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setTintColor(@Nullable ColorStateList colorStateList) {
        Drawable mutate;
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (mutate = indeterminateDrawable.mutate()) != null) {
            mutate.setColorFilter(colorStateList != null ? colorStateList.getDefaultColor() : 0, PorterDuff.Mode.MULTIPLY);
        }
    }

    public Spinner(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(this, attributeSet, 0, 0, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Spinner(@org.jetbrains.annotations.Nullable android.content.Context r4, @org.jetbrains.annotations.Nullable android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            int r1 = r0.intValue()
            r2 = 0
            if (r1 <= 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0019
            int r0 = r0.intValue()
            goto L_0x001b
        L_0x0019:
            int r0 = com.avito.android.lib.design.R.attr.spinner
        L_0x001b:
            r3.<init>(r4, r5, r0)
            r4 = 4
            b(r3, r5, r6, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.spinner.Spinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Spinner(@org.jetbrains.annotations.Nullable android.content.Context r3, @org.jetbrains.annotations.Nullable android.util.AttributeSet r4, int r5, int r6) {
        /*
            r2 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            int r1 = r0.intValue()
            if (r1 <= 0) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            if (r1 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0018
            int r0 = r0.intValue()
            goto L_0x001a
        L_0x0018:
            int r0 = com.avito.android.lib.design.R.attr.spinner
        L_0x001a:
            r2.<init>(r3, r4, r0)
            android.content.Context r3 = r2.getContext()
            int[] r0 = com.avito.android.lib.design.R.styleable.DesignSpinner
            android.content.res.TypedArray r3 = r3.obtainStyledAttributes(r4, r0, r5, r6)
            java.lang.String r4 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.a(r3)
            r3.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.spinner.Spinner.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
