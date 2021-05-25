package u6.a.i0.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
public final class b extends Lambda implements Function0<Unit> {
    public static final b a = new b();

    public b() {
        super(0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.INSTANCE;
        DebugProbesImpl.j.runWeakRefQueueCleaningLoopUntilInterrupted();
        return Unit.INSTANCE;
    }
}
