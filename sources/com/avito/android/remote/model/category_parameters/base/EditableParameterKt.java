package com.avito.android.remote.model.category_parameters.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u001aE\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\f\u0010\u000b\u001a-\u0010\u000e\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"T", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "newValue", "Lkotlin/Function1;", "parser", "", "applyParsedValue", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "value", "applyValue", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/lang/Object;)V", "applyPureValue", "parameter", "copyValueAndError", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)V", "models_release"}, k = 2, mv = {1, 4, 2})
public final class EditableParameterKt {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.category_parameters.base.EditableParameter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void applyParsedValue(@NotNull EditableParameter<T> editableParameter, @Nullable String str, @NotNull Function1<? super String, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(editableParameter, "$this$applyParsedValue");
        Intrinsics.checkNotNullParameter(function1, "parser");
        if (str != null) {
            if (!(str.length() == 0)) {
                try {
                    Object invoke = function1.invoke(str);
                    if (!Intrinsics.areEqual(editableParameter.getValue(), invoke)) {
                        editableParameter.setValue(invoke);
                        editableParameter.setError(null);
                        return;
                    }
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            }
        }
        if (!Intrinsics.areEqual(editableParameter.getValue(), (Object) null)) {
            editableParameter.setValue(null);
            editableParameter.setError(null);
        }
    }

    public static final <T> void applyPureValue(@NotNull EditableParameter<T> editableParameter, @Nullable T t) {
        Intrinsics.checkNotNullParameter(editableParameter, "$this$applyPureValue");
        if (!Intrinsics.areEqual((Object) editableParameter.get_value(), (Object) t)) {
            editableParameter.set_value(t);
            editableParameter.setError(null);
        }
    }

    public static final <T> void applyValue(@NotNull EditableParameter<T> editableParameter, @Nullable T t) {
        Intrinsics.checkNotNullParameter(editableParameter, "$this$applyValue");
        if (!Intrinsics.areEqual((Object) editableParameter.getValue(), (Object) t)) {
            editableParameter.setValue(t);
            editableParameter.setError(null);
        }
    }

    public static final <T> void copyValueAndError(@NotNull EditableParameter<T> editableParameter, @Nullable EditableParameter<T> editableParameter2) {
        Intrinsics.checkNotNullParameter(editableParameter, "$this$copyValueAndError");
        T t = null;
        editableParameter.setError(editableParameter2 != null ? editableParameter2.getError() : null);
        if (editableParameter2 != null) {
            t = editableParameter2.getValue();
        }
        editableParameter.setValue(t);
    }
}
