package com.avito.android.safedeal.delivery_courier.order_update.konveyor;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierOrderParams;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "params", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;)Ljava/util/List;", "oldItems", "", "paramId", "newValue", "applyParameterValue", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "errorsMap", "applyErrors", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "getSubmitParametersMap", "(Lcom/avito/android/remote/model/delivery_courier/TimeInterval;)Ljava/util/Map;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTrees", "()Ljava/util/List;", "parametersTrees", "getParametersMap", "()Ljava/util/Map;", "parametersMap", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierItemsConverter {
    @NotNull
    List<Item> applyErrors(@NotNull List<? extends Item> list, @NotNull Map<String, String> map);

    @NotNull
    List<Item> applyParameterValue(@NotNull List<? extends Item> list, @NotNull String str, @NotNull String str2);

    @NotNull
    List<Item> convert(@NotNull DeliveryCourierOrderParams deliveryCourierOrderParams);

    @NotNull
    Map<String, String> getParametersMap();

    @NotNull
    List<ParametersTree> getParametersTrees();

    @NotNull
    Map<String, String> getSubmitParametersMap(@Nullable TimeInterval timeInterval);
}
