package com.avito.android.error_helper;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.TypedResultException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/error_helper/ErrorHelperImpl;", "Lcom/avito/android/error_helper/ErrorHelper;", "", "error", "Lcom/avito/android/remote/error/TypedError;", "handle", "(Ljava/lang/Throwable;)Lcom/avito/android/remote/error/TypedError;", "errorResult", "", "recycle", "(Lcom/avito/android/remote/error/TypedError;)Ljava/lang/String;", "(Ljava/lang/Throwable;)Ljava/lang/String;", "Lcom/avito/android/util/ErrorFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "<init>", "(Lcom/avito/android/util/ErrorFormatter;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorHelperImpl implements ErrorHelper {
    public final ErrorFormatter a;

    @Inject
    public ErrorHelperImpl(@NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.a = errorFormatter;
    }

    @Override // com.avito.android.error_helper.ErrorHelper
    @NotNull
    public TypedError handle(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        if (th instanceof TypedResultException) {
            return ((TypedResultException) th).getErrorResult();
        }
        return new ErrorWithMessage.SimpleMessageError(this.a.format(th));
    }

    @Override // com.avito.android.error_helper.ErrorHelper
    @NotNull
    public String recycle(@NotNull TypedError typedError) {
        Intrinsics.checkNotNullParameter(typedError, "errorResult");
        return recycle(new TypedResultException(typedError));
    }

    @Override // com.avito.android.error_helper.ErrorHelper
    @NotNull
    public String recycle(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        return this.a.format(th);
    }
}
