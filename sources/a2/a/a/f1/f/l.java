package a2.a.a.f1.f;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import t6.v.e;
public final class l<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ CallReconnectHandlerImpl.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ AppCallInfo d;

    public l(CallReconnectHandlerImpl.a aVar, String str, String str2, AppCallInfo appCallInfo) {
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = appCallInfo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Boolean bool) {
        Completable completable;
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "connected");
        if (bool2.booleanValue()) {
            completable = CallReconnectHandlerImpl.access$requestReconnectWithRetry(this.a.a, this.b, this.c);
        } else {
            completable = Completable.never();
        }
        CallReconnectHandlerImpl callReconnectHandlerImpl = this.a.a;
        Long endTimestamp = this.d.getEndTimestamp();
        return completable.timeout(e.coerceIn(55000 - (callReconnectHandlerImpl.d.now() - (endTimestamp != null ? endTimestamp.longValue() : 0)), 0L, 55000L), TimeUnit.MILLISECONDS, this.a.a.e.computation());
    }
}
