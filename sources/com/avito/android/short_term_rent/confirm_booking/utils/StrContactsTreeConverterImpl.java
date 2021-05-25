package com.avito.android.short_term_rent.confirm_booking.utils;

import a2.b.a.a.a;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverterImpl;", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "tree", "", "", "convertToMap", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Map;", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrContactsTreeConverterImpl implements StrContactsTreeConverter {
    @Override // com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverter
    @NotNull
    public Map<String, String> convertToMap(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "tree");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = parametersTree.iterator();
        while (it.hasNext()) {
            ParameterSlot parameterSlot = (ParameterSlot) it.next();
            if ((parameterSlot instanceof EditableParameter) && (((EditableParameter) parameterSlot).getValue() instanceof String)) {
                StringBuilder L = a.L("contact[");
                L.append(parameterSlot.getId());
                L.append("]");
                String sb = L.toString();
                Object value = ((EditableParameter) parameterSlot).getValue();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put(sb, (String) value);
            }
        }
        return linkedHashMap;
    }
}
