package a2.a.a.z.a.g.q;

import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Credentials, CompletableSource> {
    public final /* synthetic */ VoxSessionManager a;

    public g(VoxSessionManager voxSessionManager) {
        this.a = voxSessionManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Credentials credentials) {
        Credentials credentials2 = credentials;
        VoxSessionManager voxSessionManager = this.a;
        Intrinsics.checkNotNullExpressionValue(credentials2, "it");
        return voxSessionManager.a(credentials2);
    }
}
