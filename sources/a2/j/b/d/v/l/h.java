package a2.j.b.d.v.l;

import android.transition.Transition;
import android.view.View;
import android.view.Window;
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback;
import java.lang.ref.WeakReference;
public class h extends l {
    public final /* synthetic */ Window a;

    public h(MaterialContainerTransformSharedElementCallback materialContainerTransformSharedElementCallback, Window window) {
        this.a = window;
    }

    @Override // a2.j.b.d.v.l.l, android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Window window = this.a;
        WeakReference<View> weakReference = MaterialContainerTransformSharedElementCallback.f;
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    @Override // a2.j.b.d.v.l.l, android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        MaterialContainerTransformSharedElementCallback.a(this.a);
    }
}
