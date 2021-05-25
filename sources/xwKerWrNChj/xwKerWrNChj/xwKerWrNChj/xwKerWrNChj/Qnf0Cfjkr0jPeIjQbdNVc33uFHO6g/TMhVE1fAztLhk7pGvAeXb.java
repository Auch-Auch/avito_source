package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.Qnf0Cfjkr0jPeIjQbdNVc33uFHO6g;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceViewModel$refuseShowSettingsDialog$1", f = "SNSLiveness3dFaceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TMhVE1fAztLhk7pGvAeXb extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ tjrpI83q5sk1iMEXPz1hKo Cwa7EHp4RmMFhwpOCPWojiqbo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMhVE1fAztLhk7pGvAeXb(tjrpI83q5sk1iMEXPz1hKo tjrpi83q5sk1imexpz1hko, Continuation continuation) {
        super(2, continuation);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = tjrpi83q5sk1imexpz1hko;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMhVE1fAztLhk7pGvAeXb(this.Cwa7EHp4RmMFhwpOCPWojiqbo, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new TMhVE1fAztLhk7pGvAeXb(this.Cwa7EHp4RmMFhwpOCPWojiqbo, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo.xXAwgfSH699GDAm5vBCX.setDontShowSettingsDialog();
        return Unit.INSTANCE;
    }
}
