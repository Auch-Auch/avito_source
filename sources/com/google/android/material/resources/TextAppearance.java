package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    @FontRes
    public final int a;
    public boolean b = false;
    public Typeface c;
    @Nullable
    public final String fontFamily;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    @Nullable
    public final ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    public class a extends ResourcesCompat.FontCallback {
        public final /* synthetic */ TextAppearanceFontCallback a;

        public a(TextAppearanceFontCallback textAppearanceFontCallback) {
            this.a = textAppearanceFontCallback;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
            TextAppearance.this.b = true;
            this.a.onFontRetrievalFailed(i);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            TextAppearance textAppearance = TextAppearance.this;
            textAppearance.c = Typeface.create(typeface, textAppearance.textStyle);
            TextAppearance textAppearance2 = TextAppearance.this;
            textAppearance2.b = true;
            this.a.onFontRetrieved(textAppearance2.c, false);
        }
    }

    public class b extends TextAppearanceFontCallback {
        public final /* synthetic */ TextPaint a;
        public final /* synthetic */ TextAppearanceFontCallback b;

        public b(TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
            this.a = textPaint;
            this.b = textAppearanceFontCallback;
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            this.b.onFontRetrievalFailed(i);
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(@NonNull Typeface typeface, boolean z) {
            TextAppearance.this.updateTextPaintMeasureState(this.a, typeface);
            this.b.onFontRetrieved(typeface, z);
        }
    }

    public TextAppearance(@NonNull Context context, @StyleRes int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i2 = R.styleable.TextAppearance_fontFamily;
        i2 = !obtainStyledAttributes.hasValue(i2) ? R.styleable.TextAppearance_android_fontFamily : i2;
        this.a = obtainStyledAttributes.getResourceId(i2, 0);
        this.fontFamily = obtainStyledAttributes.getString(i2);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R.styleable.MaterialTextAppearance);
        int i3 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(i3);
        this.letterSpacing = obtainStyledAttributes2.getFloat(i3, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.c == null && (str = this.fontFamily) != null) {
            this.c = Typeface.create(str, this.textStyle);
        }
        if (this.c == null) {
            int i = this.typeface;
            if (i == 1) {
                this.c = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.c = Typeface.SERIF;
            } else if (i != 3) {
                this.c = Typeface.DEFAULT;
            } else {
                this.c = Typeface.MONOSPACE;
            }
            this.c = Typeface.create(this.c, this.textStyle);
        }
    }

    public final boolean b() {
        return TextAppearanceConfig.shouldLoadFontSynchronously();
    }

    public Typeface getFallbackFont() {
        a();
        return this.c;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context context) {
        if (this.b) {
            return this.c;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.a);
                this.c = font;
                if (font != null) {
                    this.c = Typeface.create(font, this.textStyle);
                }
            } catch (Resources.NotFoundException | Exception | UnsupportedOperationException unused) {
            }
        }
        a();
        this.b = true;
        return this.c;
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (b()) {
            getFont(context);
        } else {
            a();
        }
        int i = this.a;
        if (i == 0) {
            this.b = true;
        }
        if (this.b) {
            textAppearanceFontCallback.onFontRetrieved(this.c, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i, new a(textAppearanceFontCallback), null);
        } catch (Resources.NotFoundException unused) {
            this.b = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception unused2) {
            this.b = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (b()) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int i = (~typeface2.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new b(textPaint, textAppearanceFontCallback));
    }
}
