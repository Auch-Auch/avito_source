package com.avito.android.delivery.summary.konveyor;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\b\u0010\u0017J9\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u0019\u0010\u0014J\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006H&¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001e\u0010)\u001a\u0004\u0018\u00010$8&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", ErrorBundle.SUMMARY_ENTRY, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Ljava/util/List;", "", "paramId", "newValue", "", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "", "errorsMap", "oldItems", "applyErrors", "(Ljava/util/Map;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;)Ljava/util/List;", "valuesMap", "applyValues", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "formSections", "Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "createParametersTree", "(Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/SimpleParametersTree;", "getParametersMap", "()Ljava/util/Map;", "parametersMap", "getFieldsMap", "fieldsMap", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "parametersTree", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsSummaryItemsConverter {
    @NotNull
    List<Item> applyErrors(@NotNull Map<String, String> map, @NotNull List<? extends Item> list);

    @NotNull
    List<Item> applyValues(@NotNull Map<String, String> map, @NotNull List<? extends Item> list);

    @NotNull
    List<Item> convert(@NotNull DeliverySummaryRds.ContactsGroup contactsGroup);

    @NotNull
    List<Item> convert(@NotNull DeliverySummaryRds deliverySummaryRds, @NotNull OnDeepLinkClickListener onDeepLinkClickListener);

    @NotNull
    SimpleParametersTree createParametersTree(@NotNull List<? extends ParameterSlot> list);

    @NotNull
    Map<String, String> getFieldsMap();

    @NotNull
    Map<String, String> getParametersMap();

    @Nullable
    ParametersTree getParametersTree();

    void onParameterValueChanged(@NotNull String str, @NotNull String str2);

    void setParametersTree(@Nullable ParametersTree parametersTree);
}
