package l6.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
public class j extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Fragment c;

    public j(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
        this.a = viewGroup;
        this.b = view;
        this.c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        animator.removeListener(this);
        Fragment fragment = this.c;
        View view = fragment.mView;
        if (view != null && fragment.mHidden) {
            view.setVisibility(8);
        }
    }
}
