package a2.j.b.d.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a();
        d dVar = this.a;
        dVar.k.onAnimationEnd(dVar.a);
    }
}
