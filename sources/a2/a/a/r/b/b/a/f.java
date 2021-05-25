package a2.a.a.r.b.b.a;

import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.tabs.Tab;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Tab, List<? extends Item>> {
    public final /* synthetic */ LegacyPerformanceVasViewModelImpl a;

    public f(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl) {
        this.a = legacyPerformanceVasViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(Tab tab) {
        Tab tab2 = tab;
        Intrinsics.checkNotNullParameter(tab2, "it");
        LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl = this.a;
        return legacyPerformanceVasViewModelImpl.c(legacyPerformanceVasViewModelImpl.j, tab2.getTitle());
    }
}
