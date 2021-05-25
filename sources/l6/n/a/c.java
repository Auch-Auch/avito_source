package l6.n.a;

import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
public final class c implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ Fragment a;

    public c(Fragment fragment) {
        this.a = fragment;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        if (this.a.getAnimatingAway() != null) {
            View animatingAway = this.a.getAnimatingAway();
            this.a.setAnimatingAway(null);
            animatingAway.clearAnimation();
        }
        this.a.setAnimator(null);
    }
}
