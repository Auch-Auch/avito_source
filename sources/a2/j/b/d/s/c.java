package a2.j.b.d.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.a.setEndIconVisible(false);
    }
}
