package u6.a.h0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterNot$1", f = "Channels.common.kt", i = {0}, l = {832}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
public final class p extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
    public Object b;
    public Object c;
    public int d;
    public final /* synthetic */ Function2 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.e = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        p pVar = new p(this.e, continuation);
        pVar.b = obj;
        return pVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        p pVar = new p(this.e, continuation);
        pVar.b = obj;
        return pVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.d;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.b;
            Function2 function2 = this.e;
            this.c = obj2;
            this.d = 1;
            obj = function2.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(!((Boolean) obj).booleanValue());
    }
}
