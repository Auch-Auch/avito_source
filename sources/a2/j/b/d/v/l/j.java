package a2.j.b.d.v.l;

import android.transition.Transition;
import android.view.Window;
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback;
public class j extends l {
    public final /* synthetic */ Window a;

    public j(MaterialContainerTransformSharedElementCallback materialContainerTransformSharedElementCallback, Window window) {
        this.a = window;
    }

    @Override // a2.j.b.d.v.l.l, android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        MaterialContainerTransformSharedElementCallback.a(this.a);
    }
}
