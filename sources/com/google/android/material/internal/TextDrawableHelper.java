package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper {
    public final TextPaint a = new TextPaint(1);
    public final TextAppearanceFontCallback b = new a();
    public float c;
    public boolean d = true;
    @Nullable
    public WeakReference<TextDrawableDelegate> e = new WeakReference<>(null);
    @Nullable
    public TextAppearance f;

    public interface TextDrawableDelegate {
        @NonNull
        int[] getState();

        @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public class a extends TextAppearanceFontCallback {
        public a() {
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.d = true;
            TextDrawableDelegate textDrawableDelegate = textDrawableHelper.e.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(@NonNull Typeface typeface, boolean z) {
            if (!z) {
                TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
                textDrawableHelper.d = true;
                TextDrawableDelegate textDrawableDelegate = textDrawableHelper.e.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.onTextSizeChange();
                }
            }
        }
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate textDrawableDelegate) {
        setDelegate(textDrawableDelegate);
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.f;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.a;
    }

    public float getTextWidth(String str) {
        float f2;
        if (!this.d) {
            return this.c;
        }
        if (str == null) {
            f2 = 0.0f;
        } else {
            f2 = this.a.measureText((CharSequence) str, 0, str.length());
        }
        this.c = f2;
        this.d = false;
        return f2;
    }

    public boolean isTextWidthDirty() {
        return this.d;
    }

    public void setDelegate(@Nullable TextDrawableDelegate textDrawableDelegate) {
        this.e = new WeakReference<>(textDrawableDelegate);
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance, Context context) {
        if (this.f != textAppearance) {
            this.f = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.a, this.b);
                TextDrawableDelegate textDrawableDelegate = this.e.get();
                if (textDrawableDelegate != null) {
                    this.a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.a, this.b);
                this.d = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.e.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void setTextWidthDirty(boolean z) {
        this.d = z;
    }

    public void updateTextPaintDrawState(Context context) {
        this.f.updateDrawState(context, this.a, this.b);
    }
}
