package a2.j.b.d.v.l;

import android.app.Activity;
import android.transition.Transition;
import android.view.View;
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback;
import java.lang.ref.WeakReference;
public class i extends l {
    public final /* synthetic */ Activity a;

    public i(MaterialContainerTransformSharedElementCallback materialContainerTransformSharedElementCallback, Activity activity) {
        this.a = activity;
    }

    @Override // a2.j.b.d.v.l.l, android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        View view;
        WeakReference<View> weakReference = MaterialContainerTransformSharedElementCallback.f;
        if (!(weakReference == null || (view = weakReference.get()) == null)) {
            view.setAlpha(1.0f);
            MaterialContainerTransformSharedElementCallback.f = null;
        }
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
    }
}
