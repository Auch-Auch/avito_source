package a2.j.b.d.n;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
public abstract class h<S extends BaseProgressIndicatorSpec> {
    public S a;
    public g b;

    public h(S s) {
        this.a = s;
    }

    public abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f);

    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @ColorInt int i);

    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    public abstract int d();

    public abstract int e();
}
