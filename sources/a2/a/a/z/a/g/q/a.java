package a2.a.a.z.a.g.q;

import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<Credentials> {
    public final /* synthetic */ VoxSessionManager a;

    public a(VoxSessionManager voxSessionManager) {
        this.a = voxSessionManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Credentials call() {
        this.a.d.clearAccessToken();
        return this.a.d.getCredentials();
    }
}
