package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class a extends ab {
    public final /* synthetic */ String b;
    public final /* synthetic */ i c;
    public final /* synthetic */ r d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(r rVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.d = rVar;
        this.b = str;
        this.c = iVar2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            String str = this.d.a;
            String str2 = this.b;
            Bundle bundle = new Bundle();
            bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0);
            bundle.putString("module_name", str2);
            this.d.c.b().e(str, bundle, r.g(), new k(this.d, this.c, (short[]) null));
        } catch (RemoteException e) {
            r.f.a(e, "removePack(%s)", this.b);
        }
    }
}
