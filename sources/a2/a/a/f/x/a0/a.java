package a2.a.a.f.x.a0;

import com.avito.android.remote.messenger.UserOnlineStatus;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<UserOnlineStatus>>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends TypedResult<UserOnlineStatus>> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        Logs.debug("AdvertSellerStatusInteractor", "Online status request failed with exception", th2);
        return Observable.empty();
    }
}
