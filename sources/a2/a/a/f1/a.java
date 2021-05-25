package a2.a.a.f1;

import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.CallManagerImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Long, SingleSource<? extends CallManager.State>> {
    public final /* synthetic */ CallManagerImpl.b a;

    public a(CallManagerImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: io.reactivex.Observable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends CallManager.State> apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return this.a.a.getStateObservable().first(CallManagerImpl.access$getDefaultState$p(this.a.a));
    }
}
