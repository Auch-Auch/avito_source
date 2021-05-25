package a2.j.b.d.k;

import android.view.ViewTreeObserver;
public class i implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ g a;

    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        g gVar = this.a;
        float rotation = gVar.y.getRotation();
        if (gVar.r == rotation) {
            return true;
        }
        gVar.r = rotation;
        gVar.v();
        return true;
    }
}
