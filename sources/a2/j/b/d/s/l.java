package a2.j.b.d.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class l extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public l(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        h hVar = this.a;
        hVar.c.setChecked(hVar.j);
        this.a.p.start();
    }
}
