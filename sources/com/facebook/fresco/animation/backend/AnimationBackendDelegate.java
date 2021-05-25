package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.backend.AnimationBackend;
import javax.annotation.Nullable;
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    @Nullable
    public T a;
    @IntRange(from = -1, to = 255)
    public int b = -1;
    @Nullable
    public ColorFilter c;
    @Nullable
    public Rect d;

    public AnimationBackendDelegate(@Nullable T t) {
        this.a = t;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this.a;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        T t = this.a;
        return t != null && t.drawFrame(drawable, canvas, i);
    }

    @Nullable
    public T getAnimationBackend() {
        return this.a;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        T t = this.a;
        if (t != null) {
            t.setAlpha(i);
        }
        this.b = i;
    }

    public void setAnimationBackend(@Nullable T t) {
        this.a = t;
        if (t != null) {
            Rect rect = this.d;
            if (rect != null) {
                t.setBounds(rect);
            }
            int i = this.b;
            if (i >= 0 && i <= 255) {
                t.setAlpha(i);
            }
            ColorFilter colorFilter = this.c;
            if (colorFilter != null) {
                t.setColorFilter(colorFilter);
            }
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        T t = this.a;
        if (t != null) {
            t.setBounds(rect);
        }
        this.d = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        T t = this.a;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.c = colorFilter;
    }
}
