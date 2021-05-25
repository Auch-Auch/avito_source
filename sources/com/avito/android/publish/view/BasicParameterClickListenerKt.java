package com.avito.android.publish.view;

import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "", "clearError", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)V", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class BasicParameterClickListenerKt {
    public static final void clearError(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "$this$clearError");
        if (categoryParameter instanceof EditableParameter) {
            ((EditableParameter) categoryParameter).setError(null);
        }
    }
}
