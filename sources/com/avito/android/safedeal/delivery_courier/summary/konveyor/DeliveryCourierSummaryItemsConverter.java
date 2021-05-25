package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010'\u001a\u0004\u0018\u00010\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", ErrorBundle.SUMMARY_ENTRY, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Ljava/util/List;", "oldItems", "", "paramId", "newValue", "applyParameterValue", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "", "errorsMap", "applyErrors", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "items", "", "getFirstErrorPosition", "(Ljava/util/List;)Ljava/lang/Integer;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "selectedCourierService", "updateCost", "(Ljava/util/List;Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;)Ljava/util/List;", "getParametersMap", "()Ljava/util/Map;", "parametersMap", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "parametersTree", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierSummaryItemsConverter {
    @NotNull
    List<Item> applyErrors(@NotNull Map<String, String> map, @NotNull List<? extends Item> list);

    @NotNull
    List<Item> applyParameterValue(@NotNull List<? extends Item> list, @NotNull String str, @NotNull String str2);

    @NotNull
    List<Item> convert(@NotNull DeliveryCourierSummary deliveryCourierSummary, @NotNull OnDeepLinkClickListener onDeepLinkClickListener);

    @Nullable
    Integer getFirstErrorPosition(@NotNull List<? extends Item> list);

    @NotNull
    Map<String, String> getParametersMap();

    @Nullable
    ParametersTree getParametersTree();

    void onParameterValueChanged(@NotNull String str, @NotNull String str2);

    void setParametersTree(@Nullable ParametersTree parametersTree);

    @NotNull
    List<Item> updateCost(@NotNull List<? extends Item> list, @NotNull BaseCourierServiceItem baseCourierServiceItem);
}
