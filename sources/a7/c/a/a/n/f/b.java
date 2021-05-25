package a7.c.a.a.n.f;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.profile.ProfileWebClient;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileV2Repo;
public final class b<T, R> implements Function<Throwable, ObservableSource<? extends ProfileV2Repo>> {
    public final /* synthetic */ ProfileWebClient.a a;

    public b(ProfileWebClient.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends ProfileV2Repo> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "throwable");
        return Observable.error(this.a.a.b.wrap(th2));
    }
}
