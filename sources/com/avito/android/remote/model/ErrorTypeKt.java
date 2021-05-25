package com.avito.android.remote.model;

import com.avito.android.remote.model.ErrorType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00008\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00008\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"", "code", "Lcom/avito/android/remote/model/ErrorType;", "findErrorByCode", "(I)Lcom/avito/android/remote/model/ErrorType;", "RESTORABLE_ERROR_CODE", "I", "NON_RESTORABLE_ERROR_CODE", "NO_ERROR_CODE", "models_release"}, k = 2, mv = {1, 4, 2})
public final class ErrorTypeKt {
    private static final int NON_RESTORABLE_ERROR_CODE = 2;
    private static final int NO_ERROR_CODE = 0;
    private static final int RESTORABLE_ERROR_CODE = 1;

    @NotNull
    public static final ErrorType findErrorByCode(int i) {
        if (i == RESTORABLE_ERROR_CODE) {
            return ErrorType.RestorableError.INSTANCE;
        }
        if (i == NON_RESTORABLE_ERROR_CODE) {
            return ErrorType.NonRestorableError.INSTANCE;
        }
        return ErrorType.NoError.INSTANCE;
    }
}
