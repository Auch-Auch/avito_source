package a2.a.a.z.a.g.q;

import a2.b.a.a.a;
import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<Credentials, CompletableSource> {
    public final /* synthetic */ VoxSessionManager a;

    public b(VoxSessionManager voxSessionManager) {
        this.a = voxSessionManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Credentials credentials) {
        Credentials credentials2 = credentials;
        if (credentials2 instanceof Credentials.AccessToken) {
            return this.a.b((Credentials.AccessToken) credentials2);
        }
        StringBuilder L = a.L("Invalid credentials type, [");
        L.append(credentials2.getClass().getSimpleName());
        L.append(']');
        return Completable.error(new CallClientException.InternalException(L.toString()));
    }
}
