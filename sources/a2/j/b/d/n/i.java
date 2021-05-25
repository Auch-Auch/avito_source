package a2.j.b.d.n;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.IndeterminateDrawable;
public abstract class i<T extends Animator> {
    public IndeterminateDrawable a;
    public final float[] b;
    public final int[] c;

    public i(int i) {
        this.b = new float[(i * 2)];
        this.c = new int[i];
    }

    public abstract void a();

    public float b(int i, int i2, int i3) {
        return ((float) (i - i2)) / ((float) i3);
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
