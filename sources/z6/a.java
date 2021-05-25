package z6;

import retrofit2.Callback;
import retrofit2.DefaultCallAdapterFactory;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 a;
    public final /* synthetic */ Callback b;
    public final /* synthetic */ Throwable c;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Throwable th) {
        this.a = r1;
        this.b = callback;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r0 = this.a;
        this.b.onFailure(DefaultCallAdapterFactory.ExecutorCallbackCall.this, this.c);
    }
}
