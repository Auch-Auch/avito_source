package u6.a.j0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {0, 0}, l = {306}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
public final class c0 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public Throwable c;
    public Object d;
    public Object e;
    public int f;
    public final /* synthetic */ Function1 g;
    public final /* synthetic */ Object h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(Function1 function1, Object obj, Continuation continuation) {
        super(3, continuation);
        this.g = function1;
        this.h = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        c0 c0Var = new c0(this.g, this.h, continuation);
        c0Var.b = (FlowCollector) obj;
        c0Var.c = th;
        return c0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.b;
            Throwable th = this.c;
            if (((Boolean) this.g.invoke(th)).booleanValue()) {
                Object obj2 = this.h;
                this.d = flowCollector;
                this.e = th;
                this.f = 1;
                if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i == 1) {
            Throwable th2 = (Throwable) this.e;
            FlowCollector flowCollector2 = (FlowCollector) this.d;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
