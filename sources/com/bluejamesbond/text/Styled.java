package com.bluejamesbond.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
public class Styled {
    public static float a(Canvas canvas, CharSequence charSequence, int i, int i2, int i3, boolean z, float f, int i4, int i5, int i6, Paint.FontMetricsInt fontMetricsInt, TextPaint textPaint, TextPaint textPaint2, boolean z2) {
        Class cls;
        int i7;
        int i8;
        int i9;
        Spanned spanned;
        Class cls2;
        TextPaint textPaint3;
        Paint.FontMetricsInt fontMetricsInt2;
        int i10;
        float f2;
        float f3;
        Spanned spanned2;
        int i11;
        int i12;
        float f4;
        int i13;
        CharSequence charSequence2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i2;
        int i19 = i4;
        Paint.FontMetricsInt fontMetricsInt3 = fontMetricsInt;
        TextPaint textPaint4 = textPaint;
        TextPaint textPaint5 = textPaint2;
        float f5 = 0.0f;
        if (!(charSequence instanceof Spanned)) {
            if (z) {
                CharSequence reverse = TextUtils.getReverse(charSequence, i, i2);
                int i20 = i18 - i;
                if (canvas != null || z2) {
                    f5 = textPaint4.measureText(reverse, 0, i20);
                }
                if (canvas != null) {
                    canvas.drawText(reverse, 0, i20, f - f5, (float) i5, textPaint);
                }
            } else {
                if (z2) {
                    f5 = textPaint4.measureText(charSequence, i, i18);
                }
                if (canvas != null) {
                    canvas.drawText(charSequence, i, i2, f, (float) i5, textPaint);
                }
            }
            if (fontMetricsInt3 != null) {
                textPaint4.getFontMetricsInt(fontMetricsInt3);
            }
            return f5 * ((float) i3);
        }
        Spanned spanned3 = (Spanned) charSequence;
        if (canvas == null) {
            cls = MetricAffectingSpan.class;
        } else {
            cls = CharacterStyle.class;
        }
        Class cls3 = cls;
        float f6 = f;
        int i21 = i;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i21 < i18) {
            int nextSpanTransition = spanned3.nextSpanTransition(i21, i18, cls3);
            boolean z3 = true;
            boolean z4 = z2 || nextSpanTransition != i18;
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned3.getSpans(i21, nextSpanTransition, CharacterStyle.class);
            textPaint4.bgColor = 0;
            textPaint4.baselineShift = 0;
            textPaint5.set(textPaint4);
            ReplacementSpan replacementSpan = null;
            if (characterStyleArr.length > 0) {
                int length = characterStyleArr.length;
                i8 = i23;
                int i26 = 0;
                while (true) {
                    i7 = i24;
                    if (i26 >= length) {
                        break;
                    }
                    CharacterStyle characterStyle = characterStyleArr[i26];
                    if (characterStyle instanceof ReplacementSpan) {
                        replacementSpan = (ReplacementSpan) characterStyle;
                    } else {
                        characterStyle.updateDrawState(textPaint5);
                    }
                    i26++;
                    i24 = i7;
                    characterStyleArr = characterStyleArr;
                }
            } else {
                i8 = i23;
                i7 = i24;
            }
            if (replacementSpan == null) {
                if (z) {
                    i12 = nextSpanTransition - i21;
                    spanned2 = TextUtils.getReverse(spanned3, i21, nextSpanTransition);
                    i11 = 0;
                } else {
                    i11 = i21;
                    spanned2 = spanned3;
                    i12 = nextSpanTransition;
                }
                if (fontMetricsInt3 != null) {
                    textPaint5.getFontMetricsInt(fontMetricsInt3);
                }
                if (canvas != null) {
                    if (textPaint5.bgColor != 0) {
                        int color = textPaint2.getColor();
                        Paint.Style style = textPaint2.getStyle();
                        textPaint5.setColor(textPaint5.bgColor);
                        textPaint5.setStyle(Paint.Style.FILL);
                        f4 = textPaint5.measureText(spanned2, i11, i12);
                        if (i3 == -1) {
                            i13 = nextSpanTransition;
                            i17 = color;
                            i15 = i12;
                            i9 = i22;
                            i14 = i11;
                            charSequence2 = spanned2;
                            cls2 = cls3;
                            spanned = spanned3;
                            canvas.drawRect(f6 - f4, (float) i19, f6, (float) i6, textPaint2);
                        } else {
                            i9 = i22;
                            i15 = i12;
                            i14 = i11;
                            charSequence2 = spanned2;
                            cls2 = cls3;
                            spanned = spanned3;
                            i13 = nextSpanTransition;
                            i17 = color;
                            canvas.drawRect(f6, (float) i19, f6 + f4, (float) i6, textPaint2);
                        }
                        textPaint5.setStyle(style);
                        textPaint5.setColor(i17);
                        i16 = -1;
                    } else {
                        i9 = i22;
                        i15 = i12;
                        i14 = i11;
                        charSequence2 = spanned2;
                        cls2 = cls3;
                        spanned = spanned3;
                        i13 = nextSpanTransition;
                        i16 = -1;
                        z3 = false;
                        f4 = 0.0f;
                    }
                    if (i3 == i16) {
                        if (!z3) {
                            f4 = textPaint5.measureText(charSequence2, i14, i15);
                        }
                        i10 = i13;
                        canvas.drawText(charSequence2, i14, i15, f6 - f4, (float) (textPaint5.baselineShift + i5), textPaint2);
                    } else {
                        i10 = i13;
                        if (z4 && !z3) {
                            f4 = textPaint5.measureText(charSequence2, i14, i15);
                        }
                        canvas.drawText(charSequence2, i14, i15, f6, (float) (textPaint5.baselineShift + i5), textPaint2);
                    }
                } else {
                    i9 = i22;
                    cls2 = cls3;
                    spanned = spanned3;
                    i10 = nextSpanTransition;
                    if (z4) {
                        f4 = textPaint5.measureText(spanned2, i11, i12);
                    } else {
                        fontMetricsInt2 = fontMetricsInt;
                        textPaint3 = textPaint;
                        f2 = 0.0f;
                    }
                }
                fontMetricsInt2 = fontMetricsInt;
                textPaint3 = textPaint;
                f2 = f4;
            } else {
                i9 = i22;
                cls2 = cls3;
                spanned = spanned3;
                i10 = nextSpanTransition;
                float size = (float) replacementSpan.getSize(textPaint2, spanned, i21, i10, fontMetricsInt);
                if (canvas == null) {
                    textPaint3 = textPaint;
                    f3 = size;
                    fontMetricsInt2 = fontMetricsInt;
                } else if (i3 == -1) {
                    float f7 = f6 - size;
                    textPaint3 = textPaint;
                    f3 = size;
                    fontMetricsInt2 = fontMetricsInt;
                    replacementSpan.draw(canvas, spanned, i21, i10, f7, i4, i5, i6, textPaint2);
                } else {
                    textPaint3 = textPaint;
                    f3 = size;
                    fontMetricsInt2 = fontMetricsInt;
                    replacementSpan.draw(canvas, spanned, i21, i10, f6, i4, i5, i6, textPaint2);
                }
                f2 = f3;
            }
            if (i3 == -1) {
                f2 = -f2;
            }
            f6 += f2;
            if (fontMetricsInt2 != null) {
                i24 = fontMetricsInt2.ascent;
                if (i24 >= i7) {
                    i24 = i7;
                }
                i23 = fontMetricsInt2.descent;
                if (i23 <= i8) {
                    i23 = i8;
                }
                i22 = fontMetricsInt2.top;
                if (i22 >= i9) {
                    i22 = i9;
                }
                int i27 = fontMetricsInt2.bottom;
                i25 = i27 > i25 ? i27 : i25;
            } else {
                i23 = i8;
                i22 = i9;
                i24 = i7;
            }
            textPaint5 = textPaint2;
            i21 = i10;
            fontMetricsInt3 = fontMetricsInt2;
            textPaint4 = textPaint3;
            cls3 = cls2;
            spanned3 = spanned;
            i18 = i2;
            i19 = i4;
        }
        if (fontMetricsInt3 != null) {
            if (i == i2) {
                textPaint4.getFontMetricsInt(fontMetricsInt3);
            } else {
                fontMetricsInt3.ascent = i24;
                fontMetricsInt3.descent = i23;
                fontMetricsInt3.top = i22;
                fontMetricsInt3.bottom = i25;
            }
        }
        return f6 - f;
    }

    public static float b(Canvas canvas, CharSequence charSequence, int i, int i2, int i3, boolean z, float f, int i4, int i5, int i6, TextPaint textPaint, TextPaint textPaint2, boolean z2) {
        if ((i3 != -1 || z) && (!z || i3 != 1)) {
            return a(canvas, charSequence, i, i2, i3, z, f, i4, i5, i6, null, textPaint, textPaint2, z2);
        }
        float a = a(null, charSequence, i, i2, 1, false, 0.0f, 0, 0, 0, null, textPaint, textPaint2, true) * ((float) i3);
        a(canvas, charSequence, i, i2, -i3, z, f + a, i4, i5, i6, null, textPaint, textPaint2, true);
        return a;
    }

    public static float drawText(Canvas canvas, CharSequence charSequence, int i, int i2, int i3, float f, int i4, int i5, int i6, TextPaint textPaint, TextPaint textPaint2, boolean z) {
        return b(canvas, charSequence, i, i2, i3 >= 0 ? 1 : -1, false, f, i4, i5, i6, textPaint, textPaint2, z);
    }

    public static int getTextWidths(TextPaint textPaint, TextPaint textPaint2, Spanned spanned, int i, int i2, float[] fArr, Paint.FontMetricsInt fontMetricsInt) {
        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i, i2, MetricAffectingSpan.class);
        textPaint2.set(textPaint);
        ReplacementSpan replacementSpan = null;
        for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
            if (metricAffectingSpan instanceof ReplacementSpan) {
                replacementSpan = (ReplacementSpan) metricAffectingSpan;
            } else {
                metricAffectingSpan.updateMeasureState(textPaint2);
            }
        }
        if (replacementSpan == null) {
            textPaint2.getFontMetricsInt(fontMetricsInt);
            textPaint2.getTextWidths(spanned, i, i2, fArr);
        } else {
            int size = replacementSpan.getSize(textPaint2, spanned, i, i2, fontMetricsInt);
            if (i2 > i) {
                fArr[0] = (float) size;
                for (int i3 = i + 1; i3 < i2; i3++) {
                    fArr[i3 - i] = 0.0f;
                }
            }
        }
        return i2 - i;
    }

    public static float measureText(TextPaint textPaint, TextPaint textPaint2, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return a(null, charSequence, i, i2, 1, false, 0.0f, 0, 0, 0, fontMetricsInt, textPaint, textPaint2, true);
    }
}
