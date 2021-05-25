package a2.q.a.b;

import com.sumsub.sns.camera.SNSCameraPhotoViewModel;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.domain.SendLogUseCase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "com.sumsub.sns.camera.SNSCameraPhotoViewModel$sendLog$1", f = "SNSCameraPhotoViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int b;
    public final /* synthetic */ SNSCameraPhotoViewModel c;
    public final /* synthetic */ Exception d;
    public final /* synthetic */ String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SNSCameraPhotoViewModel sNSCameraPhotoViewModel, Exception exc, String str, Continuation continuation) {
        super(2, continuation);
        this.c = sNSCameraPhotoViewModel;
        this.d = exc;
        this.e = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new b(this.c, this.d, this.e, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        return new b(this.c, this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SendLogUseCase sendLogUseCase = this.c.w;
            SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Error, this.d, this.e);
            this.b = 1;
            if (sendLogUseCase.invoke(params, this) == coroutine_suspended) {
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
