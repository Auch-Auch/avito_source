package u6.a.i0.a;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import kotlinx.coroutines.debug.internal.StackTraceFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class a extends RestrictedSuspendLambda implements Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> {
    public SequenceScope b;
    public Object c;
    public int d;
    public final /* synthetic */ DebugCoroutineInfoImpl e;
    public final /* synthetic */ StackTraceFrame f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(DebugCoroutineInfoImpl debugCoroutineInfoImpl, StackTraceFrame stackTraceFrame, Continuation continuation) {
        super(2, continuation);
        this.e = debugCoroutineInfoImpl;
        this.f = stackTraceFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        a aVar = new a(this.e, this.f, continuation);
        aVar.b = (SequenceScope) obj;
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super StackTraceElement> sequenceScope, Continuation<? super Unit> continuation) {
        a aVar = new a(this.e, this.f, continuation);
        aVar.b = sequenceScope;
        return aVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        int i = this.d;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope<? super StackTraceElement> sequenceScope = this.b;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = this.e;
            CoroutineStackFrame callerFrame = this.f.getCallerFrame();
            this.c = sequenceScope;
            this.d = 1;
            if (debugCoroutineInfoImpl.a(sequenceScope, callerFrame, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            SequenceScope sequenceScope2 = (SequenceScope) this.c;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
