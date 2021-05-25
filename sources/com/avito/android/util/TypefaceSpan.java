package com.avito.android.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/TypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "drawState", "", "updateDrawState", "(Landroid/text/TextPaint;)V", "paint", "updateMeasureState", "Landroid/graphics/Paint;", AuthSource.SEND_ABUSE, "(Landroid/graphics/Paint;)V", "Landroid/graphics/Typeface;", "Landroid/graphics/Typeface;", "typeface", "<init>", "(Landroid/graphics/Typeface;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public class TypefaceSpan extends MetricAffectingSpan {
    public final Typeface a;

    public TypefaceSpan(@Nullable Typeface typeface) {
        this.a = typeface;
        if (typeface == null) {
            throw new IllegalArgumentException("typeface is null");
        }
    }

    public final void a(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = typeface != null ? typeface.getStyle() : 0;
        Typeface typeface2 = this.a;
        Intrinsics.checkNotNull(typeface2);
        int i = style & (~typeface2.getStyle());
        if ((i & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.a);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "drawState");
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        a(textPaint);
    }
}
