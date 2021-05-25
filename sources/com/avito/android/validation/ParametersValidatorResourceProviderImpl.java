package com.avito.android.validation;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/validation/ParametersValidatorResourceProviderImpl;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "", "emptyRequiredParameterErrorMessage", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "validation_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersValidatorResourceProviderImpl implements ParametersValidatorResourceProvider {
    public final Resources a;

    public ParametersValidatorResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.validation.ParametersValidatorResourceProvider
    @NotNull
    public String emptyRequiredParameterErrorMessage(@NotNull EditableParameter<?> editableParameter) {
        Intrinsics.checkNotNullParameter(editableParameter, "parameter");
        if (editableParameter instanceof SelectParameter) {
            String string = this.a.getString(R.string.empty_required_select_error);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ty_required_select_error)");
            return string;
        }
        String string2 = this.a.getString(R.string.empty_required_parameter_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…required_parameter_error)");
        return string2;
    }
}
