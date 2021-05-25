package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
public final class zae extends Drawable implements Drawable.Callback {
    private int zaa;
    private long zab;
    private int zac;
    private int zad;
    private int zae;
    private int zaf;
    private int zag;
    private boolean zah;
    private boolean zai;
    private zah zaj;
    private Drawable zak;
    private Drawable zal;
    private boolean zam;
    private boolean zan;
    private boolean zao;
    private int zap;

    public zae(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zaf.zaa() : drawable;
        this.zak = drawable;
        drawable.setCallback(this);
        zah zah2 = this.zaj;
        zah2.zab = drawable.getChangingConfigurations() | zah2.zab;
        drawable2 = drawable2 == null ? zaf.zaa() : drawable2;
        this.zal = drawable2;
        drawable2.setCallback(this);
        zah zah3 = this.zaj;
        zah3.zab = drawable2.getChangingConfigurations() | zah3.zab;
    }

    private final boolean zab() {
        if (!this.zam) {
            this.zan = (this.zak.getConstantState() == null || this.zal.getConstantState() == null) ? false : true;
            this.zam = true;
        }
        return this.zan;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i = this.zaa;
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            this.zab = SystemClock.uptimeMillis();
            this.zaa = 2;
        } else if (i == 2 && this.zab >= 0) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zab)) / ((float) this.zaf);
            if (uptimeMillis < 1.0f) {
                z2 = false;
            }
            if (z2) {
                this.zaa = 0;
            }
            this.zag = (int) ((((float) this.zad) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
            z = z2;
        } else {
            z = true;
        }
        int i2 = this.zag;
        boolean z3 = this.zah;
        Drawable drawable = this.zak;
        Drawable drawable2 = this.zal;
        if (z) {
            if (!z3 || i2 == 0) {
                drawable.draw(canvas);
            }
            int i3 = this.zae;
            if (i2 == i3) {
                drawable2.setAlpha(i3);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zae - i2);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zae);
        }
        if (i2 > 0) {
            drawable2.setAlpha(i2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zae);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zah zah2 = this.zaj;
        return changingConfigurations | zah2.zaa | zah2.zab;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public final Drawable.ConstantState getConstantState() {
        if (!zab()) {
            return null;
        }
        this.zaj.zaa = getChangingConfigurations();
        return this.zaj;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.zak.getIntrinsicHeight(), this.zal.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.zak.getIntrinsicWidth(), this.zal.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.zao) {
            this.zap = Drawable.resolveOpacity(this.zak.getOpacity(), this.zal.getOpacity());
            this.zao = true;
        }
        return this.zap;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.zai && super.mutate() == this) {
            if (zab()) {
                this.zak.mutate();
                this.zal.mutate();
                this.zai = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.zak.setBounds(rect);
        this.zal.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.zag == this.zae) {
            this.zag = i;
        }
        this.zae = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.zak.setColorFilter(colorFilter);
        this.zal.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.zal;
    }

    public final void zaa(int i) {
        this.zac = 0;
        this.zad = this.zae;
        this.zag = 0;
        this.zaf = 250;
        this.zaa = 1;
        invalidateSelf();
    }

    public zae(@Nullable zah zah2) {
        this.zaa = 0;
        this.zae = 255;
        this.zag = 0;
        this.zah = true;
        this.zaj = new zah(zah2);
    }
}
