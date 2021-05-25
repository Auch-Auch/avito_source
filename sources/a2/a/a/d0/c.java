package a2.a.a.d0;

import com.avito.android.certificate_pinning.NetworkState;
import com.avito.android.remote.certificate_pinning.CertificatePinningException;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import ru.ok.android.sdk.OkListener;
public final class c<T, R> implements Function<Throwable, NetworkState> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public NetworkState apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, OkListener.KEY_EXCEPTION);
        if (th2 instanceof CertificatePinningException) {
            return new NetworkState(2, null, 2, null);
        }
        if (th2 instanceof IOException) {
            return new NetworkState(3, null, 2, null);
        }
        return new NetworkState(4, null, 2, null);
    }
}
