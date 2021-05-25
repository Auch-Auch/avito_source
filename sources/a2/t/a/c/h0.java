package a2.t.a.c;

import a2.b.a.a.a;
import com.voximplant.sdk.internal.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ScheduledFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
public class h0 implements Callback {
    public final /* synthetic */ j0 a;

    public h0(j0 j0Var) {
        this.a = j0Var;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.a.d.smRun(new Runnable(iOException) { // from class: a2.t.a.c.a
            public final /* synthetic */ IOException b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h0 h0Var = h0.this;
                IOException iOException2 = this.b;
                j0 j0Var = h0Var.a;
                if (j0Var.m || j0Var.b == k0.a) {
                    Logger.w(h0Var.a.a() + "onFailure while disconnecting or in disconnected state, ignoring");
                    return;
                }
                ScheduledFuture scheduledFuture = j0Var.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    h0Var.a.e = null;
                }
                Logger.e(h0Var.a.a() + "request to balancer is failed:" + iOException2);
                h0Var.a.b("http request is failed");
            }
        });
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        this.a.d.smRun(new Runnable(response) { // from class: a2.t.a.c.b
            public final /* synthetic */ Response b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h0 h0Var = h0.this;
                Response response2 = this.b;
                Logger.i(h0Var.a.a() + "onResponse");
                j0 j0Var = h0Var.a;
                if (j0Var.m || j0Var.b == k0.a) {
                    Logger.w(h0Var.a.a() + "onResponse while disconnecting or in disconnected state, ignoring");
                    return;
                }
                ScheduledFuture scheduledFuture = j0Var.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    h0Var.a.e = null;
                }
                if (!response2.isSuccessful()) {
                    Logger.e(h0Var.a.a() + "Unexpected code: " + response2);
                    h0Var.a.b(response2.message());
                }
                if (response2.code() == 200) {
                    Logger.i(h0Var.a.a() + "onResponse: response code is successful");
                    try {
                        ResponseBody body = response2.body();
                        if (body != null) {
                            h0Var.a.l = Arrays.asList(body.string().split(";"));
                            h0Var.a.c();
                            return;
                        }
                        response2.close();
                        Logger.e(h0Var.a.a() + "Failed to get servers, response is empty");
                        h0Var.a.b("Not able to connect to any servers");
                    } catch (IOException unused) {
                        a.N0(h0Var.a, new StringBuilder(), "Failed to get servers");
                        h0Var.a.b("Not able to connect to any servers");
                    }
                } else {
                    a.N0(h0Var.a, new StringBuilder(), "onResponse: response code is not successful");
                    h0Var.a.b(response2.message());
                }
            }
        });
    }
}
