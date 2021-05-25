package com.avito.android.remote.certificate_pinning;

import com.avito.android.util.NetworkException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/certificate_pinning/CertificatePinningException;", "Lcom/avito/android/util/NetworkException;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class CertificatePinningException extends NetworkException {
    public CertificatePinningException() {
        this(null, 1, null);
    }

    public CertificatePinningException(@Nullable Throwable th) {
        super(th);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinningException(Throwable th, int i, j jVar) {
        this((i & 1) != 0 ? null : th);
    }
}
