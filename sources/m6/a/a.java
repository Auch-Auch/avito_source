package m6.a;

import android.animation.TypeEvaluator;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
public class a implements TypeEvaluator<Double> {
    public a(CircularProgressIndicator circularProgressIndicator) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public Double evaluate(float f, Double d, Double d2) {
        Double d3 = d;
        return Double.valueOf(((d2.doubleValue() - d3.doubleValue()) * ((double) f)) + d3.doubleValue());
    }
}
