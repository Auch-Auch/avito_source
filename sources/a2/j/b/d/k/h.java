package a2.j.b.d.k;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
public class h implements TypeEvaluator<Float> {
    public FloatEvaluator a = new FloatEvaluator();

    public h(g gVar) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float floatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
