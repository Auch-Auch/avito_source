package a2.a.a.r.b.b.a;

import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItem;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<PerformanceVasItem, VasService> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public VasService apply(PerformanceVasItem performanceVasItem) {
        PerformanceVasItem performanceVasItem2 = performanceVasItem;
        Intrinsics.checkNotNullParameter(performanceVasItem2, "it");
        return new VasService(performanceVasItem2.getStringId(), performanceVasItem2.getName(), performanceVasItem2.getPrice(), performanceVasItem2.getOldPrice(), performanceVasItem2.getIcon(), performanceVasItem2.getPriceValue(), VasType.PERFORMANCE);
    }
}
