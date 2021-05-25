package l6.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
import androidx.transition.R;
public class a extends AnimatorListenerAdapter {
    public boolean a;
    public Matrix b = new Matrix();
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Matrix d;
    public final /* synthetic */ View e;
    public final /* synthetic */ ChangeTransform.e f;
    public final /* synthetic */ ChangeTransform.d g;
    public final /* synthetic */ ChangeTransform h;

    public a(ChangeTransform changeTransform, boolean z, Matrix matrix, View view, ChangeTransform.e eVar, ChangeTransform.d dVar) {
        this.h = changeTransform;
        this.c = z;
        this.d = matrix;
        this.e = view;
        this.f = eVar;
        this.g = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            if (!this.c || !this.h.J) {
                this.e.setTag(R.id.transition_transform, null);
                this.e.setTag(R.id.parent_matrix, null);
            } else {
                this.b.set(this.d);
                this.e.setTag(R.id.transition_transform, this.b);
                this.f.a(this.e);
            }
        }
        p.a.d(this.e, null);
        this.f.a(this.e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        this.b.set(this.g.a);
        this.e.setTag(R.id.transition_transform, this.b);
        this.f.a(this.e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        ChangeTransform.p(this.e);
    }
}
