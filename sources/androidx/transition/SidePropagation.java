package androidx.transition;
public class SidePropagation extends VisibilityPropagation {
    public float b = 3.0f;
    public int c = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (r5 != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        if (r5 != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        r5 = 3;
        r15 = 5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd  */
    @Override // androidx.transition.TransitionPropagation
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getStartDelay(android.view.ViewGroup r18, androidx.transition.Transition r19, androidx.transition.TransitionValues r20, androidx.transition.TransitionValues r21) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.getStartDelay(android.view.ViewGroup, androidx.transition.Transition, androidx.transition.TransitionValues, androidx.transition.TransitionValues):long");
    }

    public void setPropagationSpeed(float f) {
        if (f != 0.0f) {
            this.b = f;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int i) {
        this.c = i;
    }
}
