package a2.j.b.d.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        l lVar = this.a;
        lVar.g = (lVar.g + 1) % lVar.f.indicatorColors.length;
        lVar.h = true;
    }
}
