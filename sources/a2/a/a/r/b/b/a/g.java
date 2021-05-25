package a2.a.a.r.b.b.a;

import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ LegacyPerformanceVasViewModelImpl a;

    public g(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl) {
        this.a = legacyPerformanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        legacyPerformanceVasViewModelImpl.e(list2);
    }
}
