package a2.a.a.f1.f;

import arrow.core.Option;
import com.avito.android.calls_shared.tracker.errors.CallApiRequestException;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl;
import com.avito.android.remote.CallInfo;
import io.reactivex.rxjava3.functions.Function;
public final class c<T, R> implements Function<Throwable, Option<? extends CallInfo>> {
    public final /* synthetic */ CallInfoLoaderImpl.a a;

    public c(CallInfoLoaderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Option<? extends CallInfo> apply(Throwable th) {
        ErrorTracker.DefaultImpls.track$default(this.a.a.f, new CallApiRequestException("Can't load call info", th), null, null, 6, null);
        return Option.Companion.empty();
    }
}
