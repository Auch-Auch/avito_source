package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
public final class r<T> implements Consumer<Throwable> {
    public final /* synthetic */ LegacyVisualVasFragment a;

    public r(LegacyVisualVasFragment legacyVisualVasFragment) {
        this.a = legacyVisualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        LegacyVisualVasFragment.access$getRecyclerView$p(this.a).addItemDecoration(new LastItemDecoration(LegacyVisualVasFragment.access$getContinueButton$p(this.a).getHeight()));
    }
}
