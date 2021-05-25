package a2.j.b.d.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.a.setEndIconVisible(true);
    }
}
