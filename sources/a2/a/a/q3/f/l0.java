package a2.a.a.q3.f;

import com.avito.android.util.Views;
import com.avito.android.vas_performance.ui.VisualVasFragment;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l0<T, R> implements Function<Unit, Integer> {
    public final /* synthetic */ VisualVasFragment a;

    public l0(VisualVasFragment visualVasFragment) {
        this.a = visualVasFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Integer apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return Integer.valueOf(Views.heightWithMargins(VisualVasFragment.access$getContinueButton$p(this.a)));
    }
}
