package antonkozyriatskyi.circularprogressindicator;

import android.support.annotation.NonNull;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
public final class PatternProgressTextAdapter implements CircularProgressIndicator.ProgressTextAdapter {
    public String a;

    public PatternProgressTextAdapter(String str) {
        this.a = str;
    }

    @Override // antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator.ProgressTextAdapter
    @NonNull
    public String formatText(double d) {
        return String.format(this.a, Double.valueOf(d));
    }
}
