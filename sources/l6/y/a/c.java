package l6.y.a;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
public class c implements Animator.AnimatorListener {
    public final /* synthetic */ CircularProgressDrawable.a a;
    public final /* synthetic */ CircularProgressDrawable b;

    public c(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable.a aVar) {
        this.b = circularProgressDrawable;
        this.a = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.b.a(1.0f, this.a, true);
        CircularProgressDrawable.a aVar = this.a;
        aVar.k = aVar.e;
        aVar.l = aVar.f;
        aVar.m = aVar.g;
        aVar.a((aVar.j + 1) % aVar.i.length);
        CircularProgressDrawable circularProgressDrawable = this.b;
        if (circularProgressDrawable.f) {
            circularProgressDrawable.f = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.a.b(false);
            return;
        }
        circularProgressDrawable.e += 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.b.e = 0.0f;
    }
}
