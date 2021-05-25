package a2.j.b.d.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public d(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.k0.onAnimationStart(animator);
        FloatingActionButton x = this.a.x();
        if (x != null) {
            x.setTranslationX(this.a.getFabTranslationX());
        }
    }
}
