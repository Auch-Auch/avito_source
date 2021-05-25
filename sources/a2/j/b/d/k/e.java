package a2.j.b.d.k;

import a2.j.b.d.k.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class e extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ g.f c;
    public final /* synthetic */ g d;

    public e(g gVar, boolean z, g.f fVar) {
        this.d = gVar;
        this.b = z;
        this.c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        g gVar = this.d;
        gVar.u = 0;
        gVar.o = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = gVar.y;
            boolean z = this.b;
            floatingActionButton.internalSetVisibility(z ? 8 : 4, z);
            g.f fVar = this.c;
            if (fVar != null) {
                d dVar = (d) fVar;
                dVar.a.onHidden(dVar.b);
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.y.internalSetVisibility(0, this.b);
        g gVar = this.d;
        gVar.u = 1;
        gVar.o = animator;
        this.a = false;
    }
}
