package a2.a.a.d0;

import com.avito.android.certificate_pinning.NetworkState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
public final class b<T, R> implements Function<Response, NetworkState> {
    public final /* synthetic */ NetworkState a;

    public b(NetworkState networkState) {
        this.a = networkState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public NetworkState apply(Response response) {
        Intrinsics.checkNotNullParameter(response, "it");
        return this.a;
    }
}
