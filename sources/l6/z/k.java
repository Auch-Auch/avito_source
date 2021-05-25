package l6.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.ArrayMap;
import androidx.transition.Transition;
public class k extends AnimatorListenerAdapter {
    public final /* synthetic */ ArrayMap a;
    public final /* synthetic */ Transition b;

    public k(Transition transition, ArrayMap arrayMap) {
        this.b = transition;
        this.a = arrayMap;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.remove(animator);
        this.b.x.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.b.x.add(animator);
    }
}
