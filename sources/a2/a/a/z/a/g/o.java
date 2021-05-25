package a2.a.a.z.a.g;

import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.VoxCallClientSession;
import java.util.concurrent.Callable;
public final class o<V> implements Callable<Credentials> {
    public final /* synthetic */ VoxCallClientSession.b a;

    public o(VoxCallClientSession.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Credentials call() {
        return this.a.a.a.getCredentials();
    }
}
