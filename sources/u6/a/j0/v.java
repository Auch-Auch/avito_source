package u6.a.j0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class v extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    public FlowCollector b;
    public Throwable c;
    public long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Function1 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(int i, Function1 function1, Continuation continuation) {
        super(4, continuation);
        this.e = i;
        this.f = function1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        long longValue = l.longValue();
        v vVar = new v(this.e, this.f, continuation);
        vVar.b = (FlowCollector) obj;
        vVar.c = th;
        vVar.d = longValue;
        return vVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(((Boolean) this.f.invoke(this.c)).booleanValue() && this.d < ((long) this.e));
    }
}
