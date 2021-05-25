package l6.o.a.a;

import android.view.animation.Interpolator;
public abstract class a implements Interpolator {
    public final float[] a;
    public final float b;

    public a(float[] fArr) {
        this.a = fArr;
        this.b = 1.0f / ((float) (fArr.length - 1));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.a;
        return a2.b.a.a.a.b(fArr2[min + 1], fArr2[min], f3, fArr2[min]);
    }
}
