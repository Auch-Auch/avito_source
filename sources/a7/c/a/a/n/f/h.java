package a7.c.a.a.n.f;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
import ru.sravni.android.bankproduct.network.profile.ProfileWebClient;
public final class h<T, R> implements Function<Throwable, ObservableSource<? extends UpdateFieldAccount>> {
    public final /* synthetic */ ProfileWebClient.g a;

    public h(ProfileWebClient.g gVar) {
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends UpdateFieldAccount> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkParameterIsNotNull(th2, "throwable");
        return Observable.error(this.a.a.b.wrap(th2));
    }
}
