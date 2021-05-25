package a2.a.a.q3.f;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import com.avito.android.vas_performance.ui.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class q<T> implements Consumer<Integer> {
    public final /* synthetic */ LegacyVisualVasFragment a;

    public q(LegacyVisualVasFragment legacyVisualVasFragment) {
        this.a = legacyVisualVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        RecyclerView access$getRecyclerView$p = LegacyVisualVasFragment.access$getRecyclerView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        access$getRecyclerView$p.addItemDecoration(new LastItemDecoration(num2.intValue()));
    }
}
