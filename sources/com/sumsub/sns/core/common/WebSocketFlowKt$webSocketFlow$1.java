package com.sumsub.sns.core.common;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "com.sumsub.sns.core.common.WebSocketFlowKt$webSocketFlow$1", f = "WebSocketFlow.kt", i = {0, 0, 0, 1, 1, 1}, l = {58, 47}, m = "invokeSuspend", n = {"failureContinuation", "socket", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "failureContinuation", "socket", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class WebSocketFlowKt$webSocketFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super String>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object b;
    public Object c;
    public Object d;
    public Object e;
    public int f;
    public final /* synthetic */ String g;
    public final /* synthetic */ OkHttpClient h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebSocketFlowKt$webSocketFlow$1(String str, OkHttpClient okHttpClient, Continuation continuation) {
        super(2, continuation);
        this.g = str;
        this.h = okHttpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        WebSocketFlowKt$webSocketFlow$1 webSocketFlowKt$webSocketFlow$1 = new WebSocketFlowKt$webSocketFlow$1(this.g, this.h, continuation);
        webSocketFlowKt$webSocketFlow$1.b = obj;
        return webSocketFlowKt$webSocketFlow$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super String> producerScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        WebSocketFlowKt$webSocketFlow$1 webSocketFlowKt$webSocketFlow$1 = new WebSocketFlowKt$webSocketFlow$1(this.g, this.h, continuation2);
        webSocketFlowKt$webSocketFlow$1.b = producerScope;
        return webSocketFlowKt$webSocketFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00da  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.common.WebSocketFlowKt$webSocketFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
