package a2.j.b.e.a.i;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
public final class r extends y<Void> {
    public r(z zVar, i<Void> iVar) {
        super(zVar, iVar);
    }

    @Override // a2.j.b.e.a.i.y, com.google.android.play.core.internal.br
    public final void a(Bundle bundle) throws RemoteException {
        this.b.b.a();
        z.c.c("onDeferredInstall", new Object[0]);
        this.a.b((i<T>) null);
    }
}
