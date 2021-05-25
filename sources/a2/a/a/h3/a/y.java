package a2.a.a.h3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class y extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ DeepLink a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(DeepLink deepLink) {
        super(1);
        this.a = deepLink;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Logs.error$default("Failed to handle action " + this.a, null, 2, null);
        return Unit.INSTANCE;
    }
}
