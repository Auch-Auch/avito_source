package a2.a.a.f1.f;

import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl;
import com.avito.android.util.rx3.ErrorAndDuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<ErrorAndDuration, Unit> {
    public final /* synthetic */ CallInfoLoaderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CallInfoLoaderImpl.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ErrorAndDuration errorAndDuration) {
        Intrinsics.checkNotNullParameter(errorAndDuration, "it");
        this.a.a.d.track(new StatsdEvent.CountEvent("calls.in.info.retry", 0, 2, null));
        return Unit.INSTANCE;
    }
}
