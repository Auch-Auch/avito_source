package l6.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import l6.n.a.w;
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ w.a d;
    public final /* synthetic */ CancellationSignal e;

    public e(ViewGroup viewGroup, View view, Fragment fragment, w.a aVar, CancellationSignal cancellationSignal) {
        this.a = viewGroup;
        this.b = view;
        this.c = fragment;
        this.d = aVar;
        this.e = cancellationSignal;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        Animator animator2 = this.c.getAnimator();
        this.c.setAnimator(null);
        if (animator2 != null && this.a.indexOfChild(this.b) < 0) {
            ((FragmentManager.b) this.d).a(this.c, this.e);
        }
    }
}
