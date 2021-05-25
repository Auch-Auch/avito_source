package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
public final class c<T> implements Observer<String> {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public c(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        ButtonsKt.bindText$default(LegacyPerformanceVasFragment.access$getSkipButton$p(this.a), str, false, 2, null);
    }
}
