package com.avito.android.payment.form;

import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/form/DefaultItemConverter;", "Lcom/avito/android/payment/form/DelegateItemConverter;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", "", "Lcom/avito/konveyor/blueprint/Item;", "convert", "(Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Ljava/util/List;", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "delegate", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultItemConverter implements DelegateItemConverter {
    public final CategoryParametersElementConverter a;

    public DefaultItemConverter(@NotNull CategoryParametersElementConverter categoryParametersElementConverter) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "delegate");
        this.a = categoryParametersElementConverter;
    }

    @Override // com.avito.android.payment.form.DelegateItemConverter
    @NotNull
    public List<Item> convert(@NotNull ParameterSlot parameterSlot) {
        Intrinsics.checkNotNullParameter(parameterSlot, "parameter");
        return CategoryParametersElementConverter.convert$default(this.a, new ListDataSource(d.listOf(parameterSlot)), null, null, 6, null);
    }
}
