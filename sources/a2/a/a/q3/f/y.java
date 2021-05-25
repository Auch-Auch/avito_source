package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.PerformanceVasFragment;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
public final class y<T> implements Consumer<Throwable> {
    public final /* synthetic */ PerformanceVasFragment a;

    public y(PerformanceVasFragment performanceVasFragment) {
        this.a = performanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        PerformanceVasFragment.access$getRecyclerView$p(this.a).addItemDecoration(new LastItemDecoration(PerformanceVasFragment.access$getSkipButton$p(this.a).getHeight()));
    }
}
