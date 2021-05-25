package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW;

import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.common.ParamValidationKt;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
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
import timber.log.Timber;
@DebugMetadata(c = "com.sumsub.sns.prooface.network.Liveness3dFaceRepository$updateToken$1$1", f = "Liveness3dFaceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class alNh9hLeM39 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BYfFGQyI88 Cwa7EHp4RmMFhwpOCPWojiqbo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public alNh9hLeM39(Continuation continuation, BYfFGQyI88 bYfFGQyI88) {
        super(2, continuation);
        this.Cwa7EHp4RmMFhwpOCPWojiqbo = bYfFGQyI88;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new alNh9hLeM39(continuation, this.Cwa7EHp4RmMFhwpOCPWojiqbo);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new alNh9hLeM39(continuation, this.Cwa7EHp4RmMFhwpOCPWojiqbo).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        String str = null;
        try {
            TokenExpirationHandler tokenExpirationHandler = SNSMobileSDK.INSTANCE.getTokenExpirationHandler();
            if (tokenExpirationHandler != null) {
                str = tokenExpirationHandler.onTokenExpired();
            }
        } catch (Exception e) {
            Timber.e(e);
        }
        if (str != null && ParamValidationKt.isValidToken(str)) {
            Timber.d(a2.b.a.a.a.c3("Liveness3dFaceRepository.New token is available. Token is ", str), new Object[0]);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.Ku863HM4m4Edc3Ql5I.put(str);
            this.Cwa7EHp4RmMFhwpOCPWojiqbo.Cwa7EHp4RmMFhwpOCPWojiqbo();
        }
        return Unit.INSTANCE;
    }
}
