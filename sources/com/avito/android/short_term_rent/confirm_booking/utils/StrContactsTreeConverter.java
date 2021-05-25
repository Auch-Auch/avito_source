package com.avito.android.short_term_rent.confirm_booking.utils;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "tree", "", "", "convertToMap", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Map;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrContactsTreeConverter {
    @NotNull
    Map<String, String> convertToMap(@NotNull ParametersTree parametersTree);
}
