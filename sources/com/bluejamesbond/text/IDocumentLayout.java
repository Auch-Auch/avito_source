package com.bluejamesbond.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.bluejamesbond.text.hyphen.IHyphenator;
import com.bluejamesbond.text.style.TextAlignment;
public abstract class IDocumentLayout {
    public Toast a;
    public DisplayMetrics b;
    public int lineCount = 0;
    public int measuredHeight = 0;
    public TextPaint paint;
    public LayoutParams params;
    public CharSequence text = "";
    public boolean textChange = false;

    public interface ICancel<T> {
        T isCancelled();
    }

    public interface IProgress<T> {
        void onUpdate(T t);
    }

    public enum TokenPosition {
        START_OF_LINE,
        END_OF_LINE
    }

    @SuppressLint({"ShowToast"})
    public IDocumentLayout(Context context, TextPaint textPaint) {
        this.paint = textPaint;
        this.b = context.getResources().getDisplayMetrics();
        this.a = Toast.makeText(context, "", 0);
        LayoutParams layoutParams = new LayoutParams();
        this.params = layoutParams;
        layoutParams.setLineHeightMultiplier(1.0f);
        this.params.setLineSpacingExtra(0.0f);
        this.params.setHyphenated(false);
        this.params.setReverse(false);
    }

    public static boolean a(float f, float f2) {
        return Float.floatToIntBits(f) == Float.floatToIntBits(f2);
    }

    public void draw(Canvas canvas, int i, int i2) {
        this.params.loadToPaint(this.paint);
        onDraw(canvas, i, i2);
    }

    public LayoutParams getLayoutParams() {
        return this.params;
    }

    public int getLineCount() {
        return this.lineCount;
    }

    public abstract int getLineForToken(int i);

    public int getMeasuredHeight() {
        return this.measuredHeight;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public CharSequence getText() {
        return this.text;
    }

    public abstract float getTokenAscent(int i);

    public abstract float getTokenDescent(int i);

    public abstract int getTokenEnd(int i);

    public abstract int getTokenForVertical(float f, TokenPosition tokenPosition);

    public abstract int getTokenStart(int i);

    public abstract CharSequence getTokenTextAt(int i);

    public abstract float getTokenTopAt(int i);

    public abstract boolean isTokenized();

    public boolean measure(IProgress<Float> iProgress, ICancel<Boolean> iCancel) {
        LayoutParams layoutParams = this.params;
        if (!layoutParams.changed && !this.textChange) {
            return true;
        }
        layoutParams.loadToPaint(this.paint);
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            this.text = new SpannableString("");
        } else if (!(charSequence instanceof Spannable)) {
            this.text = new SpannableString(this.text);
        }
        return onMeasure(iProgress, iCancel);
    }

    public abstract void onDraw(Canvas canvas, int i, int i2);

    public abstract void onLayoutParamsChange();

    public abstract boolean onMeasure(IProgress<Float> iProgress, ICancel<Boolean> iCancel);

    public abstract void onTextChange();

    public void onTextNull() {
        LayoutParams layoutParams = this.params;
        layoutParams.changed = false;
        this.measuredHeight = (int) (layoutParams.insetPaddingTop + layoutParams.insetPaddingBottom);
    }

    public void setText(CharSequence charSequence) {
        SpannableString spannableString = charSequence == null ? new SpannableString("") : new SpannableString(charSequence);
        if (!this.text.equals(spannableString)) {
            this.text = spannableString;
            this.textChange = true;
            onTextChange();
        }
    }

    public void showToast(String str) {
        this.a.setText(str);
        this.a.show();
    }

    public class LayoutParams {
        public boolean antialias = false;
        public boolean changed;
        public boolean debugging = false;
        public String hyphen = "-";
        public boolean hyphenated = false;
        public IHyphenator hyphenator = null;
        public float insetPaddingBottom = 0.0f;
        public float insetPaddingLeft = 0.0f;
        public float insetPaddingRight = 0.0f;
        public float insetPaddingTop = 0.0f;
        public float lineHeightMultiplier = 0.0f;
        public float lineSpacingExtra = 0.0f;
        public int maxLines = Integer.MAX_VALUE;
        public float offsetX = 0.0f;
        public float offsetY = 0.0f;
        public float parentWidth = 800.0f;
        public float rawTextSize;
        public boolean reverse = false;
        public boolean subpixelText = false;
        public TextAlignment textAlignment = TextAlignment.LEFT;
        public int textColor;
        public boolean textFakeBold = false;
        public int textLinkColor;
        public boolean textStrikeThru = false;
        public Typeface textTypeface = Typeface.DEFAULT;
        public boolean textUnderline = false;
        public float wordSpacingMultiplier = 1.0f;

        public LayoutParams() {
            this.rawTextSize = TypedValue.applyDimension(2, 14.0f, IDocumentLayout.this.b);
            this.textColor = ViewCompat.MEASURED_STATE_MASK;
            this.textLinkColor = Color.parseColor("#ff05c5cf");
            this.changed = false;
        }

        public String getHyphen() {
            return this.hyphen;
        }

        public IHyphenator getHyphenator() {
            return this.hyphenator;
        }

        public float getInsetPaddingBottom() {
            return this.insetPaddingBottom;
        }

        public float getInsetPaddingLeft() {
            return this.insetPaddingLeft;
        }

        public float getInsetPaddingRight() {
            return this.insetPaddingRight;
        }

        public float getInsetPaddingTop() {
            return this.insetPaddingTop;
        }

        public float getLineHeightMultiplier() {
            return this.lineHeightMultiplier;
        }

        public float getLineSpacingExtra() {
            return this.lineSpacingExtra;
        }

        public int getMaxLines() {
            return this.maxLines;
        }

        public float getOffsetX() {
            return this.offsetX;
        }

        public float getOffsetY() {
            return this.offsetY;
        }

        public float getParentWidth() {
            return this.parentWidth;
        }

        public TextAlignment getTextAlignment() {
            return this.textAlignment;
        }

        public int getTextColor() {
            return this.textColor;
        }

        public Integer getTextLinkColor() {
            return Integer.valueOf(this.textLinkColor);
        }

        public float getTextSize() {
            return this.rawTextSize;
        }

        public Typeface getTextTypeface() {
            return this.textTypeface;
        }

        public Float getWordSpacingMultiplier() {
            return Float.valueOf(this.wordSpacingMultiplier);
        }

        public boolean hasChanged() {
            return this.changed;
        }

        public void invalidate() {
            this.changed = true;
            IDocumentLayout.this.onLayoutParamsChange();
        }

        public boolean isAntiAlias() {
            return this.antialias;
        }

        public boolean isDebugging() {
            return this.debugging;
        }

        public boolean isHyphenated() {
            return this.hyphenated;
        }

        public boolean isReverse() {
            return this.reverse;
        }

        public boolean isTextFakeBold() {
            return this.textFakeBold;
        }

        public boolean isTextStrikeThru() {
            return this.textStrikeThru;
        }

        public boolean isTextSubPixel() {
            return this.subpixelText;
        }

        public boolean isTextUnderline() {
            return this.textUnderline;
        }

        public void loadToPaint(Paint paint) {
            paint.setTextSize(this.rawTextSize);
            paint.setFakeBoldText(this.textFakeBold);
            paint.setStrikeThruText(this.textStrikeThru);
            paint.setColor(this.textColor);
            paint.setTypeface(this.textTypeface);
            paint.setUnderlineText(this.textUnderline);
            paint.setAntiAlias(this.antialias);
            paint.setSubpixelText(this.subpixelText);
        }

        public void setAntialias(boolean z) {
            if (this.antialias != z) {
                this.antialias = z;
            }
        }

        public void setDebugging(Boolean bool) {
            if (this.debugging != bool.booleanValue()) {
                this.debugging = bool.booleanValue();
                IDocumentLayout.this.onLayoutParamsChange();
            }
        }

        public void setHyphen(String str) {
            if (!this.hyphen.equals(str)) {
                this.hyphen = str;
                invalidate();
            }
        }

        public void setHyphenated(boolean z) {
            if (this.hyphenated != z) {
                this.hyphenated = z && this.hyphenator != null;
                invalidate();
            }
        }

        public void setHyphenator(IHyphenator iHyphenator) {
            if (iHyphenator != null) {
                IHyphenator iHyphenator2 = this.hyphenator;
                if (iHyphenator2 == null || !iHyphenator2.equals(iHyphenator)) {
                    this.hyphenator = iHyphenator;
                    invalidate();
                }
            }
        }

        public void setInsetPaddingBottom(float f) {
            if (!IDocumentLayout.a(this.insetPaddingBottom, f)) {
                this.insetPaddingBottom = f;
                invalidate();
            }
        }

        public void setInsetPaddingLeft(float f) {
            if (!IDocumentLayout.a(this.insetPaddingLeft, f)) {
                this.insetPaddingLeft = f;
                invalidate();
            }
        }

        public void setInsetPaddingRight(float f) {
            if (!IDocumentLayout.a(this.insetPaddingRight, f)) {
                this.insetPaddingRight = f;
                invalidate();
            }
        }

        public void setInsetPaddingTop(float f) {
            if (!IDocumentLayout.a(this.insetPaddingTop, f)) {
                this.insetPaddingTop = f;
                invalidate();
            }
        }

        public void setLineHeightMultiplier(float f) {
            if (!IDocumentLayout.a(this.lineHeightMultiplier, f)) {
                this.lineHeightMultiplier = f;
                invalidate();
            }
        }

        public void setLineSpacingExtra(float f) {
            if (!IDocumentLayout.a(this.lineSpacingExtra, f)) {
                this.lineSpacingExtra = f;
                invalidate();
            }
        }

        public void setMaxLines(int i) {
            if (this.maxLines != i) {
                this.maxLines = i;
                invalidate();
            }
        }

        public void setOffsetX(float f) {
            this.offsetX = f;
        }

        public void setOffsetY(float f) {
            this.offsetY = f;
        }

        public void setParentWidth(float f) {
            if (!IDocumentLayout.a(this.parentWidth, f)) {
                this.parentWidth = f;
                invalidate();
            }
        }

        public void setRawTextSize(float f) {
            if (!IDocumentLayout.a(this.rawTextSize, f)) {
                this.rawTextSize = f;
                invalidate();
            }
        }

        public void setReverse(boolean z) {
            if (this.reverse != z) {
                this.reverse = z;
                invalidate();
            }
        }

        public void setTextAlignment(TextAlignment textAlignment2) {
            if (this.textAlignment != textAlignment2) {
                this.textAlignment = textAlignment2;
                invalidate();
            }
        }

        public void setTextColor(int i) {
            if (this.textColor != i) {
                this.textColor = i;
                IDocumentLayout.this.onLayoutParamsChange();
            }
        }

        public void setTextFakeBold(boolean z) {
            if (this.textFakeBold != z) {
                this.textFakeBold = z;
                invalidate();
            }
        }

        public void setTextLinkColor(Integer num) {
            this.textLinkColor = num.intValue();
        }

        public void setTextSize(int i, float f) {
            setRawTextSize(TypedValue.applyDimension(i, f, IDocumentLayout.this.b));
        }

        public void setTextStrikeThru(boolean z) {
            if (this.textStrikeThru != z) {
                this.textStrikeThru = z;
                IDocumentLayout.this.onLayoutParamsChange();
            }
        }

        public void setTextSubPixel(boolean z) {
            if (this.subpixelText != z) {
                this.subpixelText = z;
            }
        }

        public void setTextTypeface(Typeface typeface) {
            if (!this.textTypeface.equals(typeface)) {
                this.textTypeface = typeface;
                invalidate();
            }
        }

        public void setTextUnderline(boolean z) {
            if (this.textUnderline != z) {
                this.textUnderline = z;
                IDocumentLayout.this.onLayoutParamsChange();
            }
        }

        public void setWordSpacingMultiplier(float f) {
            if (!IDocumentLayout.a(this.wordSpacingMultiplier, f)) {
                this.wordSpacingMultiplier = f;
                invalidate();
            }
        }

        public void setTextSize(float f) {
            setTextSize(2, f);
        }
    }
}
