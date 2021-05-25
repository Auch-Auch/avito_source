package a2.a.a.f1.h.d;

import com.avito.android.in_app_calls.ui.call.CallViewImpl;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Long, String> {
    public final /* synthetic */ CallViewImpl a;
    public final /* synthetic */ Long b;

    public c(CallViewImpl callViewImpl, Long l) {
        this.a = callViewImpl;
        this.b = l;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public String apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        CallViewImpl callViewImpl = this.a;
        return callViewImpl.a(callViewImpl.K.now() - this.b.longValue());
    }
}
