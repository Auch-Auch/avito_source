package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.PerformanceVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.tabs.Tab;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class e0<T, R> implements Function<Tab, List<? extends Item>> {
    public final /* synthetic */ PerformanceVasViewModelImpl a;

    public e0(PerformanceVasViewModelImpl performanceVasViewModelImpl) {
        this.a = performanceVasViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(Tab tab) {
        Tab tab2 = tab;
        Intrinsics.checkNotNullParameter(tab2, "it");
        PerformanceVasViewModelImpl performanceVasViewModelImpl = this.a;
        return performanceVasViewModelImpl.c(performanceVasViewModelImpl.j, tab2.getTitle());
    }
}
