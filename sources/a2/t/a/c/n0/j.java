package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
import java.util.concurrent.ScheduledFuture;
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ Call.b a;

    public /* synthetic */ j(Call.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.b bVar = this.a;
        ScheduledFuture scheduledFuture = Call.this.z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            Call.this.z = null;
        }
        Call.this.y = false;
        bVar.h();
        Call.this.d(bVar.d.description);
        Call.this.b.setRemoteDescription(bVar.d, false, new s1(bVar));
    }
}
