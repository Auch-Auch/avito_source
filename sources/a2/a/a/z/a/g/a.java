package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Boolean, CompletableSource> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Boolean bool) {
        Boolean bool2 = bool;
        Logs.debug$default(LogTagsKt.TAG_IAC, "Check network available=[" + bool2 + ']', null, 4, null);
        Intrinsics.checkNotNullExpressionValue(bool2, "isNetworkAvailable");
        if (bool2.booleanValue()) {
            return Completable.complete();
        }
        return Completable.error(new CallClientException.ConnectionException.NoInternetConnectionException());
    }
}
