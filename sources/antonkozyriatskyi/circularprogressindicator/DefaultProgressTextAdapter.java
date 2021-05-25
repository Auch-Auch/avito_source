package antonkozyriatskyi.circularprogressindicator;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
public final class DefaultProgressTextAdapter implements CircularProgressIndicator.ProgressTextAdapter {
    @Override // antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator.ProgressTextAdapter
    public String formatText(double d) {
        return String.valueOf((int) d);
    }
}
