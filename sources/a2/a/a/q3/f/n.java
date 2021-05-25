package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.vas_performance.VasCompletionListener;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import kotlin.Unit;
public final class n<T> implements Observer<Unit> {
    public final /* synthetic */ LegacyVisualVasFragment a;

    public n(LegacyVisualVasFragment legacyVisualVasFragment) {
        this.a = legacyVisualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        VasCompletionListener vasCompletionListener;
        if (unit != null && (vasCompletionListener = this.a.d) != null) {
            vasCompletionListener.onVisualVasCompleted();
        }
    }
}
