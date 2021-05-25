package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.internal.ab;
import com.google.android.play.core.tasks.i;
public final class g extends ab {
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ i d;
    public final /* synthetic */ int e;
    public final /* synthetic */ r f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(r rVar, i iVar, int i, String str, i iVar2, int i2) {
        super(iVar);
        this.f = rVar;
        this.b = i;
        this.c = str;
        this.d = iVar2;
        this.e = i2;
    }

    @Override // com.google.android.play.core.internal.ab
    public final void a() {
        try {
            String str = this.f.a;
            int i = this.b;
            String str2 = this.c;
            Bundle bundle = new Bundle();
            bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, i);
            bundle.putString("module_name", str2);
            this.f.c.b().b(str, bundle, r.g(), new o(this.f, this.d, this.b, this.c, this.e));
        } catch (RemoteException e2) {
            r.f.a(e2, "notifyModuleCompleted", new Object[0]);
        }
    }
}
