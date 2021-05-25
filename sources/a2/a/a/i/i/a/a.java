package a2.a.a.i.i.a;

import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<Long> {
    public final /* synthetic */ FpsMetricsSupplier.Impl a;

    public a(FpsMetricsSupplier.Impl impl) {
        this.a = impl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Long l) {
        Long l2 = l;
        FpsMetricsSupplier.Impl impl = this.a;
        Intrinsics.checkNotNullExpressionValue(l2, "frameLength");
        FpsMetricsSupplier.Impl.access$report(impl, l2.longValue());
    }
}
