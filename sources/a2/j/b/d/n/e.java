package a2.j.b.d.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.List;
public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        g gVar = this.a;
        List<Animatable2Compat.AnimationCallback> list = gVar.f;
        if (!(list == null || gVar.g)) {
            for (Animatable2Compat.AnimationCallback animationCallback : list) {
                animationCallback.onAnimationStart(gVar);
            }
        }
    }
}
