package l6.n.a;

import android.animation.Animator;
import android.view.animation.Animation;
public class f {
    public final Animation a;
    public final Animator b;

    public f(Animation animation) {
        this.a = animation;
        this.b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    public f(Animator animator) {
        this.a = null;
        this.b = animator;
    }
}
