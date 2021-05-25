package a2.q.a.d.a.d.b;

import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import java.util.List;
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
@DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDocumentsUploadedSuccess$1", f = "SNSPreviewPhotoDocumentViewModel.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
public final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int b;
    public final /* synthetic */ SNSPreviewPhotoDocumentViewModel c;
    public final /* synthetic */ List d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, List list, Continuation continuation) {
        super(2, continuation);
        this.c = sNSPreviewPhotoDocumentViewModel;
        this.d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new b(this.c, this.d, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        return new b(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = "Got warnings: " + this.d + " for " + this.c.getDocument().getType().getValue();
            SendLogUseCase sendLogUseCase = this.c.G;
            SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Warn, new IllegalArgumentException(str), str);
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
