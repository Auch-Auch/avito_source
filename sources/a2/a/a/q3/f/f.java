package a2.a.a.q3.f;

import com.avito.android.util.Views;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Unit, Integer> {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public f(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Integer apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return Integer.valueOf(Views.heightWithMargins(LegacyPerformanceVasFragment.access$getSkipButton$p(this.a)));
    }
}
