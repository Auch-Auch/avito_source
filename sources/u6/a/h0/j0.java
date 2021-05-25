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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$takeWhile$1", f = "Channels.common.kt", i = {0, 1, 1, 2, 2}, l = {1012, 1013, 1014}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
public final class j0 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    public ProducerScope b;
    public Object c;
    public Object d;
    public Object e;
    public int f;
    public final /* synthetic */ ReceiveChannel g;
    public final /* synthetic */ Function2 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.g = receiveChannel;
        this.h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        j0 j0Var = new j0(this.g, this.h, continuation);
        j0Var.b = (ProducerScope) obj;
        return j0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        j0 j0Var = new j0(this.g, this.h, continuation);
        j0Var.b = (ProducerScope) obj;
        return j0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r9.f
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0047
            if (r1 == r4) goto L_0x0037
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r9.e
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0053
        L_0x001d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0025:
            java.lang.Object r1 = r9.e
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.d
            java.lang.Object r6 = r9.c
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0087
        L_0x0037:
            java.lang.Object r1 = r9.d
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0067
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.ProducerScope r10 = r9.b
            kotlinx.coroutines.channels.ReceiveChannel r1 = r9.g
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L_0x0053:
            r10 = r9
        L_0x0054:
            r10.c = r5
            r10.d = r1
            r10.f = r4
            java.lang.Object r6 = r1.hasNext(r10)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x0067:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00a6
            java.lang.Object r10 = r5.next()
            kotlin.jvm.functions.Function2 r7 = r0.h
            r0.c = r6
            r0.d = r10
            r0.e = r5
            r0.f = r3
            java.lang.Object r7 = r7.invoke(r10, r0)
            if (r7 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r8 = r7
            r7 = r10
            r10 = r8
        L_0x0087:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0092
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0092:
            r0.c = r6
            r0.d = r7
            r0.e = r5
            r0.f = r2
            java.lang.Object r10 = r6.send(r7, r0)
            if (r10 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L_0x0054
        L_0x00a6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.h0.j0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
