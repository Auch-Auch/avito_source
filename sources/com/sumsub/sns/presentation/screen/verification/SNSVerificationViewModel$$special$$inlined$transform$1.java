package com.sumsub.sns.presentation.screen.verification;

import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel$$special$$inlined$transform$1", f = "SNSVerificationViewModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
public final class SNSVerificationViewModel$$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Event<? extends SNSVerificationViewModel.Params>>, Continuation<? super Unit>, Object> {
    public FlowCollector b;
    public int c;
    public final /* synthetic */ Flow d;
    public final /* synthetic */ SNSVerificationViewModel e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVerificationViewModel$$special$$inlined$transform$1(Flow flow, Continuation continuation, SNSVerificationViewModel sNSVerificationViewModel) {
        super(2, continuation);
        this.d = flow;
        this.e = sNSVerificationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SNSVerificationViewModel$$special$$inlined$transform$1 sNSVerificationViewModel$$special$$inlined$transform$1 = new SNSVerificationViewModel$$special$$inlined$transform$1(this.d, continuation, this.e);
        sNSVerificationViewModel$$special$$inlined$transform$1.b = (FlowCollector) obj;
        return sNSVerificationViewModel$$special$$inlined$transform$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Event<? extends SNSVerificationViewModel.Params>> flowCollector, Continuation<? super Unit> continuation) {
        return ((SNSVerificationViewModel$$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = this.b;
            Flow flow = this.d;
            AnonymousClass1 r3 = new FlowCollector<String>(this) { // from class: com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel$$special$$inlined$transform$1.1
                public final /* synthetic */ SNSVerificationViewModel$$special$$inlined$transform$1 a;

                {
                    this.a = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x00ab A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac  */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r10) {
                    /*
                    // Method dump skipped, instructions count: 286
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel$$special$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.c = 1;
            if (flow.collect(r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
