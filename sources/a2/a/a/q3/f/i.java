package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public i(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        LegacyPerformanceVasFragment.access$getRecyclerView$p(this.a).addItemDecoration(new LastItemDecoration(LegacyPerformanceVasFragment.access$getSkipButton$p(this.a).getHeight()));
    }
}
