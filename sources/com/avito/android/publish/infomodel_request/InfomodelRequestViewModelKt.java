package com.avito.android.publish.infomodel_request;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.UnauthorizedException;
import java.io.IOException;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class InfomodelRequestViewModelKt {
    public static final ErrorResult access$toErrorResult(Throwable th) {
        if (th instanceof TypedResultException) {
            TypedResultException typedResultException = (TypedResultException) th;
            TypedError errorResult = typedResultException.getErrorResult();
            if (errorResult instanceof ErrorResult) {
                return (ErrorResult) errorResult;
            }
            if (errorResult instanceof ErrorWithMessage.NetworkError) {
                return new ErrorResult.NetworkIOError(typedResultException.getMessage());
            }
            if (errorResult instanceof TypedError.UnauthorizedError) {
                return new ErrorResult.Unauthorized(typedResultException.getMessage());
            }
            return new ErrorResult.UnknownError("", null, th, 2, null);
        }
        String str = "";
        if (th instanceof IOException) {
            return new ErrorResult.NetworkIOError(str);
        }
        if (!(th instanceof UnauthorizedException)) {
            return new ErrorResult.UnknownError("", null, th, 2, null);
        }
        Throwable cause = th.getCause();
        String message = cause != null ? cause.getMessage() : null;
        if (message != null) {
            str = message;
        }
        return new ErrorResult.Unauthorized(str);
    }
}
