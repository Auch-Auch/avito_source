package com.avito.android.safedeal.delivery_courier.summary;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderPayment;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n0\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", "getOrderSummary", "(Ljava/lang/String;)Lio/reactivex/Observable;", "providerKey", "", "parametersMap", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderPayment;", "createOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierSummaryInteractor {
    @NotNull
    Observable<LoadingState<DeliveryCourierOrderPayment>> createOrder(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    @NotNull
    Observable<LoadingState<DeliveryCourierSummary>> getOrderSummary(@NotNull String str);

    @NotNull
    Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree);
}
