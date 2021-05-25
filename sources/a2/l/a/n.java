package a2.l.a;

import android.animation.Animator;
import com.my.target.gt;
public class n implements Animator.AnimatorListener {
    public final /* synthetic */ gt a;

    public n(gt gtVar) {
        this.a = gtVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a.d.isEnabled()) {
            this.a.d.setVisibility(8);
        }
        if (this.a.g.isEnabled()) {
            this.a.g.setVisibility(8);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
