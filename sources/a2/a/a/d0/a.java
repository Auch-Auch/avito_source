package a2.a.a.d0;

import com.avito.android.certificate_pinning.UnsafeNetworkInteractorImpl;
import java.util.concurrent.Callable;
import okhttp3.Response;
public final class a<V> implements Callable<Response> {
    public final /* synthetic */ UnsafeNetworkInteractorImpl.d a;

    public a(UnsafeNetworkInteractorImpl.d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Response call() {
        return this.a.a.a.newCall(this.a.a.a(false)).execute();
    }
}
