package com.avito.android.remote.interceptor;

import com.avito.android.certificate_pinning.CertificatePinningErrorRouter;
import com.avito.android.certificate_pinning.Pin;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.certificate_pinning.CertificatePinningException;
import com.avito.android.server_time.TimeSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/interceptor/CertificatePinningInterceptorImpl;", "Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", OkListener.KEY_EXCEPTION, AuthSource.SEND_ABUSE, "(Ljava/lang/Throwable;)Lokhttp3/Response;", "", "d", "Z", "showErrorScreen", "", "Lcom/avito/android/certificate_pinning/Pin;", "c", "Ljava/util/List;", "pins", "Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;", "pinningRouter", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;Ljava/util/List;Z)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public class CertificatePinningInterceptorImpl implements CertificatePinningInterceptor {
    public final TimeSource a;
    public final CertificatePinningErrorRouter b;
    public final List<Pin> c;
    public final boolean d;

    @Inject
    public CertificatePinningInterceptorImpl(@NotNull TimeSource timeSource, @NotNull CertificatePinningErrorRouter certificatePinningErrorRouter, @NotNull List<Pin> list, boolean z) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(certificatePinningErrorRouter, "pinningRouter");
        Intrinsics.checkNotNullParameter(list, "pins");
        this.a = timeSource;
        this.b = certificatePinningErrorRouter;
        this.c = list;
        this.d = z;
    }

    public final Response a(Throwable th) {
        boolean z;
        if (this.d) {
            List<Pin> list = this.c;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (this.a.now() < TimeUnit.SECONDS.toMillis(it.next().getValidThroughTimestamp())) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (!z) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z2) {
                this.b.openCertificateSpoofingScreen();
            } else {
                this.b.openCertificateExpiredScreen();
            }
        }
        throw new CertificatePinningException(th);
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            return chain.proceed(chain.request());
        } catch (SSLPeerUnverifiedException e) {
            a(e);
            throw null;
        } catch (SSLHandshakeException e2) {
            a(e2);
            throw null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinningInterceptorImpl(TimeSource timeSource, CertificatePinningErrorRouter certificatePinningErrorRouter, List list, boolean z, int i, j jVar) {
        this(timeSource, certificatePinningErrorRouter, list, (i & 8) != 0 ? true : z);
    }
}
