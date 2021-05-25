package a2.a.a.z.a.g.q;

import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import java.util.concurrent.Callable;
public final class f<V> implements Callable<Credentials> {
    public final /* synthetic */ VoxSessionManager a;

    public f(VoxSessionManager voxSessionManager) {
        this.a = voxSessionManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Credentials call() {
        return this.a.d.getCredentials();
    }
}
