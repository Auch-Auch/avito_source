package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/Applicant;", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/core/domain/GetApplicantUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class GetApplicantUseCase extends BaseUseCase<Applicant, Params> {
    public final SettingsRepository b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/domain/GetApplicantUseCase$Params;", "", "", AuthSource.SEND_ABUSE, "Z", "getForce", "()Z", "force", "<init>", "(Z)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        public final boolean a;

        public Params() {
            this(false, 1, null);
        }

        public Params(boolean z) {
            this.a = z;
        }

        public final boolean getForce() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(boolean z, int i, j jVar) {
            this((i & 1) != 0 ? false : z);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.GetApplicantUseCase", f = "GetApplicantUseCase.kt", i = {0}, l = {20, 23}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetApplicantUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetApplicantUseCase getApplicantUseCase, Continuation continuation) {
            super(continuation);
            this.c = getApplicantUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, Applicant>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetApplicantUseCase(@NotNull CommonRepository commonRepository, @NotNull SettingsRepository settingsRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.b = settingsRepository;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Applicant>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, Applicant>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetApplicantUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getSettingsRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.sumsub.sns.core.domain.base.BaseUseCase] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.domain.GetApplicantUseCase.Params r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.Applicant>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.domain.GetApplicantUseCase.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.domain.GetApplicantUseCase$a r0 = (com.sumsub.sns.core.domain.GetApplicantUseCase.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.GetApplicantUseCase$a r0 = new com.sumsub.sns.core.domain.GetApplicantUseCase$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0071
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.domain.GetApplicantUseCase r6 = (com.sumsub.sns.core.domain.GetApplicantUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x003c }
            goto L_0x005b
        L_0x003c:
            r7 = move-exception
            goto L_0x0065
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.sumsub.sns.core.data.source.settings.SettingsRepository r7 = r5.b     // Catch:{ Exception -> 0x0063 }
            java.lang.String r7 = r7.getApplicantId()     // Catch:{ Exception -> 0x0063 }
            com.sumsub.sns.core.data.source.common.CommonRepository r2 = r5.getCommonRepository()     // Catch:{ Exception -> 0x0063 }
            boolean r6 = r6.getForce()     // Catch:{ Exception -> 0x0063 }
            r0.d = r5     // Catch:{ Exception -> 0x0063 }
            r0.b = r4     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r7 = r2.getApplicantById(r7, r6, r0)     // Catch:{ Exception -> 0x0063 }
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r6 = r5
        L_0x005b:
            com.sumsub.sns.core.data.model.Applicant r7 = (com.sumsub.sns.core.data.model.Applicant) r7
            com.sumsub.sns.core.domain.model.Either$Right r2 = new com.sumsub.sns.core.domain.model.Either$Right
            r2.<init>(r7)
            return r2
        L_0x0063:
            r7 = move-exception
            r6 = r5
        L_0x0065:
            r2 = 0
            r0.d = r2
            r0.b = r3
            java.lang.Object r7 = r6.onWrapException(r7, r0)
            if (r7 != r1) goto L_0x0071
            return r1
        L_0x0071:
            com.sumsub.sns.core.domain.model.Either$Left r6 = new com.sumsub.sns.core.domain.model.Either$Left
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.GetApplicantUseCase.run(com.sumsub.sns.core.domain.GetApplicantUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
