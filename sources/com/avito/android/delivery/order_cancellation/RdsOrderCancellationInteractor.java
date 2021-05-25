package com.avito.android.delivery.order_cancellation;

import com.avito.android.remote.model.OrderCancellationReasons;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJG\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "", "", AnalyticFieldsName.orderId, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/OrderCancellationReasons;", "getReasons", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "reasonId", "title", "reasonText", "", "sendReasonAndCancelOrder", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface RdsOrderCancellationInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable sendReasonAndCancelOrder$default(RdsOrderCancellationInteractor rdsOrderCancellationInteractor, String str, Integer num, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    str3 = null;
                }
                return rdsOrderCancellationInteractor.sendReasonAndCancelOrder(str, num, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendReasonAndCancelOrder");
        }
    }

    @NotNull
    Observable<LoadingState<OrderCancellationReasons>> getReasons(@NotNull String str);

    @NotNull
    Observable<LoadingState<Unit>> sendReasonAndCancelOrder(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3);
}
