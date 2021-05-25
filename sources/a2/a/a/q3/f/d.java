package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.vas_performance.VasCompletionListener;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import kotlin.Unit;
public final class d<T> implements Observer<Unit> {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public d(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Unit unit) {
        VasCompletionListener vasCompletionListener;
        if (unit != null && (vasCompletionListener = this.a.d) != null) {
            vasCompletionListener.onPerformanceVasCompleted();
        }
    }
}
