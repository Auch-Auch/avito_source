package z6;

import java.io.IOException;
import retrofit2.Callback;
import retrofit2.DefaultCallAdapterFactory;
import retrofit2.Response;
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 a;
    public final /* synthetic */ Callback b;
    public final /* synthetic */ Response c;

    public /* synthetic */ b(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Response response) {
        this.a = r1;
        this.b = callback;
        this.c = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r0 = this.a;
        Callback callback = this.b;
        Response response = this.c;
        if (DefaultCallAdapterFactory.ExecutorCallbackCall.this.delegate.isCanceled()) {
            callback.onFailure(DefaultCallAdapterFactory.ExecutorCallbackCall.this, new IOException("Canceled"));
        } else {
            callback.onResponse(DefaultCallAdapterFactory.ExecutorCallbackCall.this, response);
        }
    }
}
