package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J1\u0010\t\u001a\u0018\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/domain/GetApplicantStateUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/sumsub/sns/domain/GetApplicantStateUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/GetApplicantStateUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "c", "Ljava/lang/String;", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Ljava/lang/String;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class GetApplicantStateUseCase extends BaseUseCase<Flow<? extends String>, Params> {
    public final ApplicantRepository b;
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/domain/GetApplicantStateUseCase$Params;", "", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.GetApplicantStateUseCase", f = "GetApplicantStateUseCase.kt", i = {}, l = {22}, m = "run", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetApplicantStateUseCase c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetApplicantStateUseCase getApplicantStateUseCase, Continuation continuation) {
            super(continuation);
            this.c = getApplicantStateUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, ? extends Flow<String>>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetApplicantStateUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull String str) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        this.b = applicantRepository;
        this.c = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Flow<? extends String>>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, ? extends Flow<String>>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetApplicantStateUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository(), serviceLocator.getSession().getAccessToken());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.GetApplicantStateUseCase.Params r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, ? extends kotlinx.coroutines.flow.Flow<java.lang.String>>> r6) {
        /*
            r4 = this;
            boolean r5 = r6 instanceof com.sumsub.sns.domain.GetApplicantStateUseCase.a
            if (r5 == 0) goto L_0x0013
            r5 = r6
            com.sumsub.sns.domain.GetApplicantStateUseCase$a r5 = (com.sumsub.sns.domain.GetApplicantStateUseCase.a) r5
            int r0 = r5.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r5.b = r0
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.domain.GetApplicantStateUseCase$a r5 = new com.sumsub.sns.domain.GetApplicantStateUseCase$a
            r5.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r5.a
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r5.b
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.sumsub.sns.core.domain.model.Either$Right r6 = new com.sumsub.sns.core.domain.model.Either$Right     // Catch:{ Exception -> 0x0042 }
            com.sumsub.sns.core.data.source.applicant.ApplicantRepository r1 = r4.b     // Catch:{ Exception -> 0x0042 }
            java.lang.String r3 = r4.c     // Catch:{ Exception -> 0x0042 }
            kotlinx.coroutines.flow.Flow r1 = r1.applicantState(r3)     // Catch:{ Exception -> 0x0042 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0042 }
            return r6
        L_0x0042:
            r6 = move-exception
            r5.b = r2
            java.lang.Object r6 = r4.onWrapException(r6, r5)
            if (r6 != r0) goto L_0x004c
            return r0
        L_0x004c:
            com.sumsub.sns.core.domain.model.Either$Left r5 = new com.sumsub.sns.core.domain.model.Either$Left
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.GetApplicantStateUseCase.run(com.sumsub.sns.domain.GetApplicantStateUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
