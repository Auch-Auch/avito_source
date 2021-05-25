package a2.a.a.j.a;

import com.avito.android.util.Logs;
import com.avito.android.util.rx.ErrorAndDuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class l0 extends Lambda implements Function1<ErrorAndDuration, Unit> {
    public static final l0 a = new l0();

    public l0() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ErrorAndDuration errorAndDuration) {
        Intrinsics.checkNotNullParameter(errorAndDuration, "it");
        Logs.debug$default("PublishDraftsSyncTask", "Sync draft failed, retrying", null, 4, null);
        return Unit.INSTANCE;
    }
}
