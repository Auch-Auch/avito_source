package com.avito.android.remote.model.category_parameters.base;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/HasError;", "", "", "hasError", "()Z", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "error", "models_release"}, k = 1, mv = {1, 4, 2})
public interface HasError {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static boolean hasError(@NotNull HasError hasError) {
            String error = hasError.getError();
            return !(error == null || error.length() == 0);
        }
    }

    @Nullable
    String getError();

    boolean hasError();

    void setError(@Nullable String str);
}
