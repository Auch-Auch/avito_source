package a2.a.a.z.a.g;

import com.avito.android.calls.Credentials;
import com.avito.android.calls.voximplant.rx.VoxCallClientSession;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class p<T, R> implements Function<Credentials, CompletableSource> {
    public final /* synthetic */ VoxCallClientSession.b a;

    public p(VoxCallClientSession.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Credentials credentials) {
        Credentials credentials2 = credentials;
        VoxSessionManager voxSessionManager = this.a.a.c;
        Intrinsics.checkNotNullExpressionValue(credentials2, "it");
        return voxSessionManager.login(credentials2);
    }
}
