package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.remote.model.delivery.DeliverySpecificQuantityState;
import com.avito.android.util.rx3.Maybies;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class r<T, R> implements Function<DeliverySpecificQuantityState, MaybeSource<? extends Unit>> {
    public final /* synthetic */ s a;

    public r(s sVar) {
        this.a = sVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends Unit> apply(DeliverySpecificQuantityState deliverySpecificQuantityState) {
        DeliverySpecificQuantityState deliverySpecificQuantityState2 = deliverySpecificQuantityState;
        DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(deliverySpecificQuantityState2, "state");
        DeliveryRdsSummaryViewModelImpl.access$applyCheckQuantityResult(deliveryRdsSummaryViewModelImpl, deliverySpecificQuantityState2);
        Unit unit = Unit.INSTANCE;
        String tooltipMessage = deliverySpecificQuantityState2.getTooltipMessage();
        if (!(tooltipMessage == null || tooltipMessage.length() == 0)) {
            unit = null;
        }
        return Maybies.toMaybe(unit);
    }
}
