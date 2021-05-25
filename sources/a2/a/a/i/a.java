package a2.a.a.i;

import com.avito.android.analytics.AnalyticsImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ AnalyticsImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AnalyticsImpl analyticsImpl) {
        super(1);
        this.a = analyticsImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        AnalyticsImpl.access$logExceptionToAnalytics(this.a, th2);
        return Unit.INSTANCE;
    }
}
