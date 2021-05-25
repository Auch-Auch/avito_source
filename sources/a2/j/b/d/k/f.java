package a2.j.b.d.k;

import a2.j.b.d.k.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ g.f b;
    public final /* synthetic */ g c;

    public f(g gVar, boolean z, g.f fVar) {
        this.c = gVar;
        this.a = z;
        this.b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        g gVar = this.c;
        gVar.u = 0;
        gVar.o = null;
        g.f fVar = this.b;
        if (fVar != null) {
            d dVar = (d) fVar;
            dVar.a.onShown(dVar.b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.y.internalSetVisibility(0, this.a);
        g gVar = this.c;
        gVar.u = 2;
        gVar.o = animator;
    }
}
