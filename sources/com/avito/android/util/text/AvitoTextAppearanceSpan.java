package com.avito.android.util.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.text_formatters.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/avito/android/util/text/AvitoTextAppearanceSpan;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "(Landroid/text/TextPaint;)V", "updateMeasureState", "Landroid/content/res/ColorStateList;", "c", "Landroid/content/res/ColorStateList;", "textColorLink", AuthSource.BOOKING_ORDER, "textColor", "Landroid/graphics/Typeface;", AuthSource.SEND_ABUSE, "Landroid/graphics/Typeface;", "typeface", "", "d", "Ljava/lang/Float;", "textSize", "Landroid/content/Context;", "context", "", "appearance", "<init>", "(Landroid/content/Context;I)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoTextAppearanceSpan extends MetricAffectingSpan {
    public Typeface a;
    public ColorStateList b;
    public ColorStateList c;
    public Float d;

    public AvitoTextAppearanceSpan(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.AvitoTextAppearance);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
        int i2 = R.styleable.AvitoTextAppearance_android_fontFamily;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.a = ResourcesCompat.getFont(context, obtainStyledAttributes.getResourceId(i2, 0));
        }
        if (this.a == null) {
            int i3 = R.styleable.AvitoTextAppearance_fontFamily;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.a = ResourcesCompat.getFont(context, obtainStyledAttributes.getResourceId(i3, 0));
            }
        }
        int i4 = R.styleable.AvitoTextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.b = obtainStyledAttributes.getColorStateList(i4);
        }
        int i5 = R.styleable.AvitoTextAppearance_android_textColorLink;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.c = obtainStyledAttributes.getColorStateList(i5);
        }
        int i6 = R.styleable.AvitoTextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.d = Float.valueOf((float) obtainStyledAttributes.getDimensionPixelSize(i6, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        updateMeasureState(textPaint);
        ColorStateList colorStateList = this.b;
        if (colorStateList != null) {
            textPaint.setColor(colorStateList.getColorForState(textPaint.drawableState, 0));
        }
        ColorStateList colorStateList2 = this.c;
        if (colorStateList2 != null) {
            textPaint.linkColor = colorStateList2.getColorForState(textPaint.drawableState, 0);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        Typeface typeface = this.a;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        Float f = this.d;
        if (f != null) {
            textPaint.setTextSize(f.floatValue());
        }
    }
}
