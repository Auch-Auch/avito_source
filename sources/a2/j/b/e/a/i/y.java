package a2.j.b.e.a.i;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bq;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.tasks.i;
import java.util.List;
public class y<T> extends bq {
    public final i<T> a;
    public final /* synthetic */ z b;

    public y(z zVar, i<T> iVar) {
        this.b = zVar;
        this.a = iVar;
    }

    @Override // com.google.android.play.core.internal.br
    public final void a() throws RemoteException {
        this.b.b.a();
        z.c.c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public final void b() throws RemoteException {
        this.b.b.a();
        z.c.c("onGetSplitsForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public void c(int i, Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onStartInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.br
    public void d(Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public final void e(Bundle bundle) throws RemoteException {
        this.b.b.a();
        int i = bundle.getInt("error_code");
        z.c.b("onError(%d)", Integer.valueOf(i));
        this.a.b(new SplitInstallException(i));
    }

    @Override // com.google.android.play.core.internal.br
    public final void a(int i) throws RemoteException {
        this.b.b.a();
        z.c.c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.br
    public void b(int i, Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.br
    public void c(Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onDeferredLanguageUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public void a(int i, Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.br
    public void b(Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onDeferredLanguageInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public void a(Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onDeferredInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.br
    public void a(List<Bundle> list) throws RemoteException {
        this.b.b.a();
        z.c.c("onGetSessionStates", new Object[0]);
    }
}
