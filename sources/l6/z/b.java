package l6.z;

import a2.b.a.a.a;
import android.animation.TypeEvaluator;
public class b implements TypeEvaluator<float[]> {
    public float[] a;

    public b(float[] fArr) {
        this.a = fArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float[] fArr5 = this.a;
        if (fArr5 == null) {
            fArr5 = new float[fArr3.length];
        }
        for (int i = 0; i < fArr5.length; i++) {
            float f2 = fArr3[i];
            fArr5[i] = a.b(fArr4[i], f2, f, f2);
        }
        return fArr5;
    }
}
