package a2.j.b.d.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
import java.util.Objects;
public class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ ActionMenuView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public b(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.b = actionMenuView;
        this.c = i;
        this.d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomAppBar bottomAppBar = this.e;
            int i = bottomAppBar.d0;
            boolean z = i != 0;
            bottomAppBar.replaceMenu(i);
            BottomAppBar bottomAppBar2 = this.e;
            ActionMenuView actionMenuView = this.b;
            int i2 = this.c;
            boolean z2 = this.d;
            Objects.requireNonNull(bottomAppBar2);
            c cVar = new c(bottomAppBar2, actionMenuView, i2, z2);
            if (z) {
                actionMenuView.post(cVar);
            } else {
                cVar.run();
            }
        }
    }
}
