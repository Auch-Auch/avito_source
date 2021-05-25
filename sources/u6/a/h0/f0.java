package u6.a.h0;

import com.avito.android.lib.design.input.FormatterType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$requireNoNulls$1", f = "Channels.common.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f0 extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    public Object b;
    public final /* synthetic */ ReceiveChannel c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.c = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        f0 f0Var = new f0(this.c, continuation);
        f0Var.b = obj;
        return f0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        f0 f0Var = new f0(this.c, (Continuation) obj2);
        f0Var.b = obj;
        return f0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Object obj2 = this.b;
        if (obj2 != null) {
            return obj2;
        }
        StringBuilder L = a2.b.a.a.a.L("null element found in ");
        L.append(this.c);
        L.append(FormatterType.defaultDecimalSeparator);
        throw new IllegalArgumentException(L.toString());
    }
}
