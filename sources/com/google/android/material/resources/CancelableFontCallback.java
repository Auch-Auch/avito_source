package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    public final Typeface a;
    public final ApplyFont b;
    public boolean c;

    public interface ApplyFont {
        void apply(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.a = typeface;
        this.b = applyFont;
    }

    public void cancel() {
        this.c = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        Typeface typeface = this.a;
        if (!this.c) {
            this.b.apply(typeface);
        }
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z) {
        if (!this.c) {
            this.b.apply(typeface);
        }
    }
}
