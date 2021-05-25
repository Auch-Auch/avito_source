package u6.a.h0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinct$1", f = "Channels.common.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    public Object b;

    public h(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        h hVar = new h(continuation);
        hVar.b = obj;
        return hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        h hVar = new h((Continuation) obj2);
        hVar.b = obj;
        Unit unit = Unit.INSTANCE;
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(unit);
        return hVar.b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return this.b;
    }
}
