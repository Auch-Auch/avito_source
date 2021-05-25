package com.avito.android.validation;

import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "", "emptyRequiredParameterErrorMessage", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Ljava/lang/String;", "validation_release"}, k = 1, mv = {1, 4, 2})
public interface ParametersValidatorResourceProvider {
    @NotNull
    String emptyRequiredParameterErrorMessage(@NotNull EditableParameter<?> editableParameter);
}
