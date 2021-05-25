package com.bluejamesbond.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.bluejamesbond.text.IDocumentLayout;
public abstract class StringDocumentLayout extends IDocumentLayout {
    public e[] c = new e[0];
    public ConcurrentModifiableLinkedList<String> d = new ConcurrentModifiableLinkedList<>();

    public class a {
        public int a;
        public int b;
        public float c;

        public a(StringDocumentLayout stringDocumentLayout, int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public static class b extends e {
        public b(int i, float f) {
            super(i, f);
        }

        @Override // com.bluejamesbond.text.StringDocumentLayout.e
        public void a(Canvas canvas, float f, Paint paint, IDocumentLayout.LayoutParams layoutParams) {
        }

        public String toString() {
            return "\n";
        }
    }

    public class c extends Exception {
        public c(StringDocumentLayout stringDocumentLayout, String str) {
            super(str);
        }
    }

    public static class d extends f {
        public d(int i, float f, float f2, String str) {
            super(i, f, f2, str);
        }
    }

    public static abstract class e {
        public float a;

        public e(int i, float f) {
            this.a = f;
        }

        public abstract void a(Canvas canvas, float f, Paint paint, IDocumentLayout.LayoutParams layoutParams);
    }

    public StringDocumentLayout(Context context, TextPaint textPaint) {
        super(context, textPaint);
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getLineForToken(int i) {
        throw new RuntimeException("Use SpannableDocumentLayout for now. Method under construction.");
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenAscent(int i) {
        return (-this.paint.ascent()) * this.params.lineHeightMultiplier;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenDescent(int i) {
        return this.paint.descent() * this.params.lineHeightMultiplier;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenEnd(int i) {
        throw new RuntimeException("Use SpannableDocumentLayout for now. Method under construction.");
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenForVertical(float f2, IDocumentLayout.TokenPosition tokenPosition) {
        int i = 0;
        int max = Math.max(0, this.c.length - 1);
        while (i + 1 < max) {
            int i2 = (max + i) / 2;
            if (this.c[i2].a > f2) {
                max = i2;
            } else {
                i = i2;
            }
        }
        if (tokenPosition.ordinal() != 1) {
            int i3 = i;
            while (i > 0 && this.c[i].a >= f2) {
                i3--;
                i--;
            }
            return i3;
        }
        int i4 = max;
        while (true) {
            e[] eVarArr = this.c;
            if (max >= eVarArr.length || eVarArr[max].a > f2) {
                break;
            }
            i4++;
            max++;
        }
        return i4;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public int getTokenStart(int i) {
        throw new RuntimeException("Use SpannableDocumentLayout for now. Method under construction.");
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public CharSequence getTokenTextAt(int i) {
        return this.c[i].toString();
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public float getTokenTopAt(int i) {
        return this.c[i].a;
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
        return this.c != null;
    }

    @Override // com.bluejamesbond.text.IDocumentLayout
    public void onDraw(Canvas canvas, int i, int i2) {
        int i3 = i;
        float f2 = (float) i3;
        int tokenForVertical = getTokenForVertical(f2, IDocumentLayout.TokenPosition.START_OF_LINE);
        int tokenForVertical2 = getTokenForVertical((float) i2, IDocumentLayout.TokenPosition.END_OF_LINE);
        int i4 = 0;
        int max = Math.max(0, tokenForVertical - 25);
        while (max < tokenForVertical2 + 25) {
            e[] eVarArr = this.c;
            if (max < eVarArr.length) {
                e eVar = eVarArr[max];
                eVar.a(canvas, (float) (-i3), this.paint, this.params);
                if (this.params.debugging && (eVar instanceof b)) {
                    int color = this.paint.getColor();
                    boolean isFakeBoldText = this.paint.isFakeBoldText();
                    Paint.Style style = this.paint.getStyle();
                    Paint.Align textAlign = this.paint.getTextAlign();
                    this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
                    this.paint.setStyle(Paint.Style.FILL);
                    float f3 = this.params.insetPaddingLeft;
                    float tokenAscent = (eVar.a - f2) - getTokenAscent(i4);
                    IDocumentLayout.LayoutParams layoutParams = this.params;
                    canvas.drawRect(f3, tokenAscent, layoutParams.parentWidth - layoutParams.insetPaddingRight, getTokenDescent(i4) + (eVar.a - f2), this.paint);
                    this.paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                    this.paint.setFakeBoldText(true);
                    this.paint.setTextAlign(Paint.Align.CENTER);
                    IDocumentLayout.LayoutParams layoutParams2 = this.params;
                    float f4 = layoutParams2.insetPaddingLeft;
                    canvas.drawText("LINEBREAK", (((layoutParams2.parentWidth - layoutParams2.insetPaddingRight) - f4) / 2.0f) + f4, eVar.a - f2, this.paint);
                    this.paint.setStyle(style);
                    this.paint.setColor(color);
                    this.paint.setTextAlign(textAlign);
                    this.paint.setFakeBoldText(isFakeBoldText);
                }
                max++;
                i3 = i;
                i4 = 0;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0331, code lost:
        r3 = r5;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02bb, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02eb A[LOOP:6: B:101:0x02e7->B:103:0x02eb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x030e A[SYNTHETIC] */
    @Override // com.bluejamesbond.text.IDocumentLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onMeasure(com.bluejamesbond.text.IDocumentLayout.IProgress<java.lang.Float> r31, com.bluejamesbond.text.IDocumentLayout.ICancel<java.lang.Boolean> r32) {
        /*
        // Method dump skipped, instructions count: 879
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bluejamesbond.text.StringDocumentLayout.onMeasure(com.bluejamesbond.text.IDocumentLayout$IProgress, com.bluejamesbond.text.IDocumentLayout$ICancel):boolean");
    }

    public static class f extends e {
        public float b;
        public String c;

        public f(String str) {
            super(0, 0.0f);
            this.c = str;
        }

        @Override // com.bluejamesbond.text.StringDocumentLayout.e
        public void a(Canvas canvas, float f, Paint paint, IDocumentLayout.LayoutParams layoutParams) {
            canvas.drawText(this.c, layoutParams.getOffsetX() + this.b, layoutParams.getOffsetY() + this.a + f, paint);
        }

        public String toString() {
            return this.c;
        }

        public f(int i, float f, float f2, String str) {
            super(i, f2);
            this.b = f;
            this.c = str;
        }
    }
}
