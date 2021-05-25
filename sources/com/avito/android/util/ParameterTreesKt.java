package com.avito.android.util;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "", "", "convertToMap", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Map;", "payment-core_release"}, k = 2, mv = {1, 4, 2})
public final class ParameterTreesKt {
    @NotNull
    public static final Map<String, String> convertToMap(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "$this$convertToMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = parametersTree.iterator();
        while (it.hasNext()) {
            ParameterSlot parameterSlot = (ParameterSlot) it.next();
            if (parameterSlot instanceof EditableParameter) {
                String id = parameterSlot.getId();
                Object value = ((EditableParameter) parameterSlot).getValue();
                String obj = value != null ? value.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                linkedHashMap.put(id, obj);
            }
        }
        return linkedHashMap;
    }
}
