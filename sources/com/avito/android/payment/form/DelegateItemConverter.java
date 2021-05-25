package com.avito.android.payment.form;

import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/form/DelegateItemConverter;", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Ljava/util/List;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface DelegateItemConverter {
    @NotNull
    List<Item> convert(@NotNull ParameterSlot parameterSlot);
}
