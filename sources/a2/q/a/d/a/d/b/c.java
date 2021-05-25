package a2.q.a.d.a.d.b;

import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$showPhoto$1", f = "SNSPreviewPhotoDocumentViewModel.kt", i = {0, 0}, l = {188}, m = "invokeSuspend", n = {"bm", "canRotate"}, s = {"L$0", "I$0"})
public final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int b;
    public Object c;
    public Object d;
    public int e;
    public final /* synthetic */ SNSPreviewPhotoDocumentViewModel f;
    public final /* synthetic */ DocumentPickerResult g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, DocumentPickerResult documentPickerResult, Continuation continuation) {
        super(2, continuation);
        this.f = sNSPreviewPhotoDocumentViewModel;
        this.g = documentPickerResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new c(this.f, this.g, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        return new c(this.f, this.g, continuation2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.q.a.d.a.d.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
