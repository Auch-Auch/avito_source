package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
public final class u<T> implements Observer<String> {
    public final /* synthetic */ PerformanceVasFragment a;

    public u(PerformanceVasFragment performanceVasFragment) {
        this.a = performanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(String str) {
        ButtonsKt.bindText$default(PerformanceVasFragment.access$getSkipButton$p(this.a), str, false, 2, null);
    }
}
