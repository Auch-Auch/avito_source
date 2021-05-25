package com.avito.android.validation;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/validation/ParametersValidator;", "", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/validation/ValidationResult;", "validate", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/validation/ValidationResult;", "", "validateWithDependentParameters", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/List;", "validation_release"}, k = 1, mv = {1, 4, 2})
public interface ParametersValidator {
    @NotNull
    ValidationResult validate(@NotNull EditableParameter<?> editableParameter, @NotNull ParametersTree parametersTree);

    @NotNull
    List<ValidationResult> validateWithDependentParameters(@NotNull EditableParameter<?> editableParameter, @NotNull ParametersTree parametersTree);
}
