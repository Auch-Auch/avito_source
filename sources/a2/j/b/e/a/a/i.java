package a2.j.b.e.a.a;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.aa;
public final class i extends g<AppUpdateInfo> {
    public final String d;
    public final /* synthetic */ j e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(j jVar, com.google.android.play.core.tasks.i<AppUpdateInfo> iVar, String str) {
        super(jVar, new aa("OnRequestInstallCallback"), iVar);
        this.e = jVar;
        this.d = str;
    }

    @Override // a2.j.b.e.a.a.g, com.google.android.play.core.internal.p
    public final void a(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.a.c("onRequestInfo", new Object[0]);
        if (bundle.getInt("error.code", -2) == 0 || bundle.getInt("error.code", -2) == 1) {
            this.b.b((com.google.android.play.core.tasks.i<T>) ((T) AppUpdateInfo.a(this.d, bundle.getInt("version.code", -1), bundle.getInt("update.availability"), bundle.getInt("install.status", 0), bundle.getInt("client.version.staleness", -1) != -1 ? Integer.valueOf(bundle.getInt("client.version.staleness")) : null, bundle.getInt("in.app.update.priority", 0), bundle.getLong("bytes.downloaded"), bundle.getLong("total.bytes.to.download"), bundle.getLong("additional.size.required"), this.e.d.a(), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent"))));
            return;
        }
        this.b.b(new InstallException(bundle.getInt("error.code", -2)));
    }
}
