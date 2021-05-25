package com.avito.android.delivery.summary.common;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "fields", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/rxjava3/core/Observable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsContactsFieldsInteractor {
    @NotNull
    Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree);
}
