package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "T", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getFirstParameterOfType", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "api_release"}, k = 2, mv = {1, 4, 2})
public final class ParametersTreeKt {
    public static final /* synthetic */ <T extends ParameterSlot> T getFirstParameterOfType(ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "$this$getFirstParameterOfType");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) parametersTree.getFirstParameterOfType(ParameterSlot.class);
    }
}
