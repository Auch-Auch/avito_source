package u6.a.h0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {989, 990}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
public final class i0 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public ProducerScope b;
    public Object c;
    public Object d;
    public Object e;
    public int f;
    public int g;
    public final /* synthetic */ ReceiveChannel h;
    public final /* synthetic */ int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(ReceiveChannel receiveChannel, int i2, Continuation continuation) {
        super(2, continuation);
        this.h = receiveChannel;
        this.i = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        i0 i0Var = new i0(this.h, this.i, continuation);
        i0Var.b = (ProducerScope) obj;
        return i0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        i0 i0Var = new i0(this.h, this.i, continuation);
        i0Var.b = (ProducerScope) obj;
        return i0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r9.g
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r9.e
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r9.f
            java.lang.Object r5 = r9.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r5
            r5 = r9
            goto L_0x0084
        L_0x001f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0027:
            java.lang.Object r1 = r9.d
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r9.f
            java.lang.Object r5 = r9.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r5
            r5 = r9
            goto L_0x0066
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.ProducerScope r10 = r9.b
            int r1 = r9.i
            if (r1 != 0) goto L_0x0043
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0043:
            if (r1 < 0) goto L_0x0047
            r4 = 1
            goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            if (r4 == 0) goto L_0x0092
            kotlinx.coroutines.channels.ReceiveChannel r4 = r9.h
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r9
        L_0x0051:
            r5.c = r10
            r5.f = r1
            r5.d = r4
            r5.g = r3
            java.lang.Object r6 = r4.hasNext(r5)
            if (r6 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r7 = r6
            r6 = r10
            r10 = r7
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x0066:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x008f
            java.lang.Object r10 = r1.next()
            r5.c = r6
            r5.f = r4
            r5.d = r10
            r5.e = r1
            r5.g = r2
            java.lang.Object r10 = r6.send(r10, r5)
            if (r10 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r10 = r6
        L_0x0084:
            int r4 = r4 + -1
            if (r4 != 0) goto L_0x008b
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x008b:
            r7 = r4
            r4 = r1
            r1 = r7
            goto L_0x0051
        L_0x008f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0092:
            java.lang.String r10 = "Requested element count "
            java.lang.StringBuilder r10 = a2.b.a.a.a.L(r10)
            int r0 = r9.i
            java.lang.String r1 = " is less than zero."
            java.lang.String r10 = a2.b.a.a.a.j(r10, r0, r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.h0.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
