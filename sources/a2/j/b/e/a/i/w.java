package a2.j.b.e.a.i;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;
public final class w extends y<List<SplitInstallSessionState>> {
    public w(z zVar, i<List<SplitInstallSessionState>> iVar) {
        super(zVar, iVar);
    }

    @Override // a2.j.b.e.a.i.y, com.google.android.play.core.internal.br
    public final void a(List<Bundle> list) throws RemoteException {
        this.b.b.a();
        z.c.c("onGetSessionStates", new Object[0]);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(SplitInstallSessionState.a(list.get(i)));
        }
        this.a.b((i<T>) arrayList);
    }
}
