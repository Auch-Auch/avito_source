package a2.a.a.e2.r;

import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class s extends Lambda implements Function1<Throwable, Unit> {
    public static final s a = new s();

    public s() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        Logs.error("Failed to update upload info with message " + th2.getMessage(), th2);
        return Unit.INSTANCE;
    }
}
