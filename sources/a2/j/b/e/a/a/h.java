package a2.j.b.e.a.a;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.tasks.i;
public final class h extends g<Void> {
    public h(j jVar, i<Void> iVar) {
        super(jVar, new aa("OnCompleteUpdateCallback"), iVar);
    }

    @Override // a2.j.b.e.a.a.g, com.google.android.play.core.internal.p
    public final void b(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.a.c("onCompleteUpdate", new Object[0]);
        if (bundle.getInt("error.code", -2) != 0) {
            this.b.b(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.b.b((i<T>) null);
        }
    }
}
