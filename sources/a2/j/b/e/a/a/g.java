package a2.j.b.e.a.a;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.o;
import com.google.android.play.core.tasks.i;
public class g<T> extends o {
    public final aa a;
    public final i<T> b;
    public final /* synthetic */ j c;

    public g(j jVar, aa aaVar, i<T> iVar) {
        this.c = jVar;
        this.a = aaVar;
        this.b = iVar;
    }

    @Override // com.google.android.play.core.internal.p
    public void a(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.a.c("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.p
    public void b(Bundle bundle) throws RemoteException {
        this.c.a.a();
        this.a.c("onCompleteUpdate", new Object[0]);
    }
}
