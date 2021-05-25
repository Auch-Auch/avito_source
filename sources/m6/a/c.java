package m6.a;

import android.animation.Animator;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
public class c extends d {
    public final /* synthetic */ double a;
    public final /* synthetic */ CircularProgressIndicator b;

    public c(CircularProgressIndicator circularProgressIndicator, double d) {
        this.b = circularProgressIndicator;
        this.a = d;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        CircularProgressIndicator circularProgressIndicator = this.b;
        circularProgressIndicator.f = (int) this.a;
        circularProgressIndicator.invalidate();
        this.b.r = null;
    }
}
