package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g;

import com.sumsub.sns.core.domain.FaceDetector;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$enqueueSegment$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
public final class djGN3DbfslkNo4T0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int Cwa7EHp4RmMFhwpOCPWojiqbo;
    public final /* synthetic */ String aDBqOnRnCJ0gWECtZQu;
    public final /* synthetic */ FaceDetector.Size ejVYvrSYmsA1fCSIPxDrI;
    public final /* synthetic */ FaceDetector.RawImage lk42nG4RRcMiHe8r6w;
    public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo oVTxbCNkVuXyP468Xhsl9qtSE9v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public djGN3DbfslkNo4T0(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko, FaceDetector.RawImage rawImage, FaceDetector.Size size, String str, Continuation continuation) {
        super(2, continuation);
        this.oVTxbCNkVuXyP468Xhsl9qtSE9v = tjrpi83q5sk1imexpz1hko;
        this.lk42nG4RRcMiHe8r6w = rawImage;
        this.ejVYvrSYmsA1fCSIPxDrI = size;
        this.aDBqOnRnCJ0gWECtZQu = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new djGN3DbfslkNo4T0(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, this.lk42nG4RRcMiHe8r6w, this.ejVYvrSYmsA1fCSIPxDrI, this.aDBqOnRnCJ0gWECtZQu, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new djGN3DbfslkNo4T0(this.oVTxbCNkVuXyP468Xhsl9qtSE9v, this.lk42nG4RRcMiHe8r6w, this.ejVYvrSYmsA1fCSIPxDrI, this.aDBqOnRnCJ0gWECtZQu, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow<Triple<FaceDetector.RawImage, FaceDetector.Size, String>> mutableSharedFlow = this.oVTxbCNkVuXyP468Xhsl9qtSE9v.J3eZRYS4AnxhOKbC2x2nQNPT;
            Triple<FaceDetector.RawImage, FaceDetector.Size, String> triple = new Triple<>(this.lk42nG4RRcMiHe8r6w, this.ejVYvrSYmsA1fCSIPxDrI, this.aDBqOnRnCJ0gWECtZQu);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = 1;
            if (mutableSharedFlow.emit(triple, this) == coroutine_suspended) {
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
