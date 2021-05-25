package a2.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
public class b {
    public final ValueAnimator a;
    public AbstractC0029b b;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.b.a();
        }
    }

    /* renamed from: a2.h.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0029b {
        void a();
    }

    public interface c {
        void a(float f);
    }

    public b(boolean z) {
        if (z) {
            this.a = ValueAnimator.ofFloat(1.0f, 0.0f);
        } else {
            this.a = ValueAnimator.ofFloat(0.0f, 1.0f);
        }
    }

    public ValueAnimator a() {
        if (this.b != null) {
            this.a.addListener(new a());
        }
        return this.a;
    }
}
