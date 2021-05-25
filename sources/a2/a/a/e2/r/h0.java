package a2.a.a.e2.r;

import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h0 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Function0 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(Function0 function0) {
        super(1);
        this.a = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        this.a.invoke();
        Logs.error("PublishDetailsPresenter", "Failed to observe suggest by photo", th2);
        return Unit.INSTANCE;
    }
}
