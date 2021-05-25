package com.avito.android.util;

import com.avito.android.remote.certificate_pinning.CertificatePinningException;
import com.avito.android.remote.error.ErrorResult;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0013\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"", "", "isNetworkProblem", "(Ljava/lang/Throwable;)Z", "isCertificatePinningError", "isAuthProblem", "isNotFoundError", "isInternalError", "isForbiddenError", "api_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Throwables")
public final class Throwables {
    public static final boolean isAuthProblem(@Nullable Throwable th) {
        if (!(th instanceof UnauthorizedException)) {
            if (th instanceof AvitoResponseException) {
                AvitoResponseException avitoResponseException = (AvitoResponseException) th;
                if (avitoResponseException.getError() == null || avitoResponseException.getError().code != 401) {
                    return false;
                }
            } else if (th instanceof TypedResultException) {
                return ((TypedResultException) th).getErrorResult() instanceof ErrorResult.Unauthorized;
            } else {
                return false;
            }
        }
        return true;
    }

    public static final boolean isCertificatePinningError(@Nullable Throwable th) {
        return (th instanceof CertificatePinningException) || ((th instanceof NetworkException) && (th.getCause() instanceof CertificatePinningException));
    }

    public static final boolean isForbiddenError(@Nullable Throwable th) {
        if (th instanceof AvitoResponseException) {
            if (((AvitoResponseException) th).getError().code == 403) {
                return true;
            }
        } else if (th instanceof ForbiddenException) {
            return true;
        }
        return false;
    }

    public static final boolean isInternalError(@Nullable Throwable th) {
        if (!(th instanceof AvitoResponseException) || ((AvitoResponseException) th).getError().code < 500) {
            return false;
        }
        return true;
    }

    public static final boolean isNetworkProblem(@Nullable Throwable th) {
        return (th instanceof IOException) || ((th instanceof TypedResultException) && (((TypedResultException) th).getErrorResult() instanceof ErrorResult.NetworkIOError));
    }

    public static final boolean isNotFoundError(@Nullable Throwable th) {
        if (th instanceof AvitoResponseException) {
            if (((AvitoResponseException) th).getError().code == 404) {
                return true;
            }
        } else if (th instanceof NotFoundException) {
            return true;
        }
        return false;
    }
}
