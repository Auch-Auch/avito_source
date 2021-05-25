package com.avito.android.safedeal.delivery_courier.order_update;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJY\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "", "", AnalyticFieldsName.orderId, "source", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "getCourierOrderUpdateParams", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "submitCourierOrderUpdate", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)Lio/reactivex/Observable;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierOrderUpdateInteractor {
    @NotNull
    Observable<LoadingState<DeliveryCourierOrderParams>> getCourierOrderUpdateParams(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<Map<String, String>>> submitCourierOrderUpdate(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map, @NotNull List<? extends ParametersTree> list);
}
