package u6.a.h0;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {1653, 1654}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX, "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
public final class n0 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    public ProducerScope b;
    public Object c;
    public Object d;
    public Object e;
    public int f;
    public int g;
    public final /* synthetic */ ReceiveChannel h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.h = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        n0 n0Var = new n0(this.h, continuation);
        n0Var.b = (ProducerScope) obj;
        return n0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        n0 n0Var = new n0(this.h, continuation);
        n0Var.b = (ProducerScope) obj;
        return n0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r11.g
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            java.lang.Object r1 = r11.e
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r11.f
            java.lang.Object r5 = r11.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r5
            r5 = r11
            r9 = r4
            r4 = r1
            r1 = r9
            goto L_0x0045
        L_0x0021:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0029:
            java.lang.Object r1 = r11.d
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r11.f
            java.lang.Object r5 = r11.c
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r6 = r11
            goto L_0x005b
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.channels.ProducerScope r12 = r11.b
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel r4 = r11.h
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r11
        L_0x0045:
            r5.c = r12
            r5.f = r1
            r5.d = r4
            r5.g = r3
            java.lang.Object r6 = r4.hasNext(r5)
            if (r6 != r0) goto L_0x0054
            return r0
        L_0x0054:
            r9 = r5
            r5 = r12
            r12 = r6
            r6 = r9
            r10 = r4
            r4 = r1
            r1 = r10
        L_0x005b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0084
            java.lang.Object r12 = r1.next()
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
            int r8 = r4 + 1
            r7.<init>(r4, r12)
            r6.c = r5
            r6.f = r8
            r6.d = r12
            r6.e = r1
            r6.g = r2
            java.lang.Object r12 = r5.send(r7, r6)
            if (r12 != r0) goto L_0x007f
            return r0
        L_0x007f:
            r4 = r1
            r12 = r5
            r5 = r6
            r1 = r8
            goto L_0x0045
        L_0x0084:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.h0.n0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
