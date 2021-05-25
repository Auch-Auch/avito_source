package com.avito.android.publish.pretend;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.util.UnauthorizedException;
import java.io.IOException;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class PretendViewModelKt {
    public static final ErrorResult access$toErrorResult(Throwable th) {
        ErrorResult errorResult;
        String str = "";
        if (th instanceof IOException) {
            return new ErrorResult.NetworkIOError(str);
        }
        if (th instanceof UnauthorizedException) {
            Throwable cause = th.getCause();
            String message = cause != null ? cause.getMessage() : null;
            if (message != null) {
                str = message;
            }
            errorResult = new ErrorResult.Unauthorized(str);
        } else {
            errorResult = new ErrorResult.UnknownError("", null, th, 2, null);
        }
        return errorResult;
    }
}
