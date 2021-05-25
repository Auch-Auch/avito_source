package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class h extends ab {
    public final /* synthetic */ int b;
    public final /* synthetic */ i c;
    public final /* synthetic */ r d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(r rVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.d = rVar;
        this.b = i;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            String str = this.d.a;
            int i = this.b;
            Bundle bundle = new Bundle();
            bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, i);
            this.d.c.b().c(str, bundle, r.g(), new k(this.d, this.c, (int[]) null));
        } catch (RemoteException e) {
            r.f.a(e, "notifySessionFailed", new Object[0]);
        }
    }
}
