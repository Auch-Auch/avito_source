package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.PerformanceVasViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f0<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ PerformanceVasViewModelImpl a;

    public f0(PerformanceVasViewModelImpl performanceVasViewModelImpl) {
        this.a = performanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        PerformanceVasViewModelImpl performanceVasViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        performanceVasViewModelImpl.e(list2);
    }
}
