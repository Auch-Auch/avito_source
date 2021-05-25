package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
public final class EdgeEffectCompat {
    public EdgeEffect a;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.a = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.a.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.a.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.a.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.a.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.a.onRelease();
        return this.a.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.a.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.a, f, f2);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        edgeEffect.onPull(f, f2);
    }
}
