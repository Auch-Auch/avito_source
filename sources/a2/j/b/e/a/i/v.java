package a2.j.b.e.a.i;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.tasks.i;
public final class v extends y<SplitInstallSessionState> {
    public v(z zVar, i<SplitInstallSessionState> iVar) {
        super(zVar, iVar);
    }

    @Override // a2.j.b.e.a.i.y, com.google.android.play.core.internal.br
    public final void b(int i, Bundle bundle) throws RemoteException {
        super.b(i, bundle);
        this.a.b((i<T>) ((T) SplitInstallSessionState.a(bundle)));
    }
}
