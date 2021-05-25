package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.VisualVasFragment;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
public final class o0<T> implements Consumer<Throwable> {
    public final /* synthetic */ VisualVasFragment a;

    public o0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        VisualVasFragment.access$getRecyclerView$p(this.a).addItemDecoration(new LastItemDecoration(VisualVasFragment.access$getContinueButton$p(this.a).getHeight()));
    }
}
