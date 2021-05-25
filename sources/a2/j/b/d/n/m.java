package a2.j.b.d.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class m extends AnimatorListenerAdapter {
    public final /* synthetic */ n a;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        n nVar = this.a;
        if (nVar.j) {
            nVar.d.setRepeatCount(-1);
            n nVar2 = this.a;
            nVar2.k.onAnimationEnd(nVar2.a);
            this.a.j = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        n nVar = this.a;
        nVar.g = (nVar.g + 1) % nVar.f.indicatorColors.length;
        nVar.h = true;
    }
}
