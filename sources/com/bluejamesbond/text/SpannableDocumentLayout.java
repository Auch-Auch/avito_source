package com.bluejamesbond.text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import com.bluejamesbond.text.IDocumentLayout;
import com.bluejamesbond.text.style.DirectionSpan;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;
public abstract class SpannableDocumentLayout extends IDocumentLayout {
    public TextPaint c;
    public LinkedList<a> d;
    public int[] e = new int[0];

    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public LeadingMarginSpan i;

        public a(SpannableDocumentLayout spannableDocumentLayout, LeadingMarginSpan leadingMarginSpan, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            this.i = leadingMarginSpan;
            this.a = i2;
            this.e = i3;
            this.b = i4;
            this.c = i5;
            this.d = i6;
            this.f = i7;
            this.g = i8;
            this.h = z;
        }
    }

    public SpannableDocumentLayout(Context context, TextPaint textPaint) {
        super(context, textPaint);
        this.c = new TextPaint(textPaint);
    }

    public static int[] b(int[] iArr, int i) {
        if (i < iArr.length) {
            return iArr;
        }
        int[] iArr2 = new int[(iArr.length * 2)];
        Arrays.fill(iArr2, Integer.MAX_VALUE);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static int c(int[] iArr, int i, int i2, int i3, float f, float f2, float f3, float f4, int i4) {
        Assert.assertTrue(i % 7 == 0);
        iArr[i + 0] = i2;
        iArr[i + 1] = i3;
        iArr[i + 2] = (int) f;
        iArr[i + 3] = (int) f2;
        iArr[i + 4] = (int) f3;
        iArr[i + 5] = (int) f4;
        iArr[i + 6] = i4;
        return i + 7;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getLineForToken(int i) {
        return this.e[i + 6];
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenAscent(int i) {
        return (float) this.e[i + 4];
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenDescent(int i) {
        return (float) this.e[i + 5];
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenEnd(int i) {
        return this.e[i + 1];
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenForVertical(float f, IDocumentLayout.TokenPosition tokenPosition) {
        int i = 0;
        int max = Math.max(0, this.e.length - 1);
        while (i + 1 < max) {
            int i2 = (max + i) / 2;
            if (((float) this.e[(i2 - (i2 % 7)) + 3]) > f) {
                max = i2;
            } else {
                i = i2;
            }
        }
        if (tokenPosition.ordinal() != 1) {
            int i3 = i - (i % 7);
            int i4 = i3;
            while (i3 > 0 && ((float) this.e[i3 + 3]) >= f) {
                i4 -= 7;
                i3 -= 7;
            }
            return i4;
        }
        int i5 = max - (max % 7);
        int i6 = i5;
        while (true) {
            int i7 = i5 + 7;
            int[] iArr = this.e;
            if (i7 >= iArr.length || ((float) iArr[i5 + 3]) > f) {
                break;
            }
            i6 += 7;
            i5 = i7;
        }
        return i6;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenStart(int i) {
        return this.e[i + 0];
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public CharSequence getTokenTextAt(int i) {
        CharSequence charSequence = this.text;
        int[] iArr = this.e;
        return charSequence.subSequence(iArr[i + 0], iArr[i + 1]);
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenTopAt(int i) {
        return (float) this.e[i + 3];
    }

    public int getTrimmedLength(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) <= ' ') {
            i++;
        }
        while (i2 > i && charSequence.charAt(i2 - 1) <= ' ') {
            i2--;
        }
        return i2 - i;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public boolean isTokenized() {
        return this.e != null;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public void onDraw(Canvas canvas, int i, int i2) {
        if (this.e.length >= 7) {
            Spannable spannable = (Spannable) this.text;
            int tokenForVertical = getTokenForVertical((float) i, IDocumentLayout.TokenPosition.START_OF_LINE);
            int tokenForVertical2 = getTokenForVertical((float) i2, IDocumentLayout.TokenPosition.END_OF_LINE);
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int i3 = next.b - i;
                int i4 = next.d - i;
                if (i4 >= 0 && i3 <= i2) {
                    next.i.drawLeadingMargin(canvas, this.paint, next.a, next.e, i3, next.c, i4, spannable, next.f, next.g, next.h, null);
                }
            }
            int i5 = this.e[tokenForVertical2 + 3];
            int i6 = 1;
            int i7 = tokenForVertical2;
            int i8 = i7;
            while (i6 > 0) {
                int[] iArr = this.e;
                if (i7 >= iArr.length) {
                    break;
                }
                i8 += 7;
                int i9 = i7 + 3;
                if (i5 != iArr[i9]) {
                    i6--;
                    i5 = iArr[i9];
                }
                i7 += 7;
            }
            int i10 = tokenForVertical;
            while (i10 < i8) {
                int[] iArr2 = this.e;
                int i11 = i10 + 0;
                if (iArr2[i11] != Integer.MAX_VALUE) {
                    int i12 = i10 + 1;
                    DirectionSpan[] directionSpanArr = (DirectionSpan[]) spannable.getSpans(iArr2[i11], iArr2[i12], DirectionSpan.class);
                    int[] iArr3 = this.e;
                    int i13 = iArr3[i11];
                    int i14 = iArr3[i12];
                    boolean isReverse = directionSpanArr.length > 0 ? directionSpanArr[0].isReverse() : false;
                    int[] iArr4 = this.e;
                    int i15 = i10 + 3;
                    Styled.b(canvas, spannable, i13, i14, 1, isReverse, (float) iArr4[i10 + 2], 0, iArr4[i15] - i, 0, this.paint, this.c, false);
                    if (this.params.debugging) {
                        int color = this.paint.getColor();
                        float strokeWidth = this.paint.getStrokeWidth();
                        this.paint.setStrokeWidth(2.0f);
                        this.paint.setColor(-16711936);
                        int[] iArr5 = this.e;
                        int i16 = i10 + 4;
                        canvas.drawLine(0.0f, (float) ((iArr5[i15] - iArr5[i16]) - i), this.params.parentWidth, (float) ((iArr5[i15] - iArr5[i16]) - i), this.paint);
                        this.paint.setColor(-16711681);
                        int[] iArr6 = this.e;
                        int i17 = i10 + 5;
                        canvas.drawLine(0.0f, (float) ((iArr6[i15] + iArr6[i17]) - i), this.params.parentWidth, (float) ((iArr6[i15] + iArr6[i17]) - i), this.paint);
                        this.paint.setColor(color);
                        this.paint.setStrokeWidth(strokeWidth);
                    }
                    i10 += 7;
                    i8 = i8;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:153:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0343  */
    @Override // com.bluejamesbond.text.IDocumentLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onMeasure(com.bluejamesbond.text.IDocumentLayout.IProgress<java.lang.Float> r54, com.bluejamesbond.text.IDocumentLayout.ICancel<java.lang.Boolean> r55) {
        /*
        // Method dump skipped, instructions count: 1431
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bluejamesbond.text.SpannableDocumentLayout.onMeasure(com.bluejamesbond.text.IDocumentLayout$IProgress, com.bluejamesbond.text.IDocumentLayout$ICancel):boolean");
    }
}
