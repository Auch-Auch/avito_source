package a2.q.a.a.a;

import com.sumsub.sns.actions.presentation.SNSActionsViewModel;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.domain.SetSdkStateUseCase;
import com.sumsub.sns.core.presentation.base.Event;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "com.sumsub.sns.actions.presentation.SNSActionsViewModel$closeWithState$1", f = "SNSActionsViewModel.kt", i = {}, l = {176, 178}, m = "invokeSuspend", n = {}, s = {})
public final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int b;
    public final /* synthetic */ SNSActionsViewModel c;
    public final /* synthetic */ SNSSDKState d;
    public final /* synthetic */ long e;
    public final /* synthetic */ SNSCompletionResult f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SNSActionsViewModel sNSActionsViewModel, SNSSDKState sNSSDKState, long j, SNSCompletionResult sNSCompletionResult, Continuation continuation) {
        super(2, continuation);
        this.c = sNSActionsViewModel;
        this.d = sNSSDKState;
        this.e = j;
        this.f = sNSCompletionResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new a(this.c, this.d, this.e, this.f, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SetSdkStateUseCase setSdkStateUseCase = this.c.o;
            SetSdkStateUseCase.Params params = new SetSdkStateUseCase.Params(this.d);
            this.b = 1;
            if (setSdkStateUseCase.invoke(params, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.c.get_finishActionLiveData().setValue(new Event(this.f));
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j = this.e;
        this.b = 2;
        if (DelayKt.delay(j, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.c.get_finishActionLiveData().setValue(new Event(this.f));
        return Unit.INSTANCE;
    }
}
