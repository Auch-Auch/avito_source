package a2.a.a.k0.e;

import com.avito.android.SummaryState;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class s<T, R> implements Function<Boolean, MaybeSource<? extends Unit>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public s(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends Unit> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "shouldCheckQuantity");
        if (!bool2.booleanValue()) {
            return Maybe.just(Unit.INSTANCE);
        }
        DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor = this.a.T;
        SummaryState summaryState = this.a.Q;
        String str = null;
        String advertId = summaryState != null ? summaryState.getAdvertId() : null;
        SummaryState summaryState2 = this.a.Q;
        String fiasGuid = summaryState2 != null ? summaryState2.getFiasGuid() : null;
        SummaryState summaryState3 = this.a.Q;
        if (summaryState3 != null) {
            str = summaryState3.getServiceId();
        }
        return deliveryRdsSummaryInteractor.checkQuantity(advertId, fiasGuid, str, this.a.l).observeOn(this.a.V.mainThread()).flatMapMaybe(new r(this));
    }
}
