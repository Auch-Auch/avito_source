package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/AppConfig;", "Lcom/sumsub/sns/core/domain/GetConfigUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/core/domain/GetConfigUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "flowName", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Ljava/lang/String;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class GetConfigUseCase extends BaseUseCase<AppConfig, Params> {
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/domain/GetConfigUseCase$Params;", "", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.GetConfigUseCase", f = "GetConfigUseCase.kt", i = {0}, l = {18, 21}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetConfigUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetConfigUseCase getConfigUseCase, Continuation continuation) {
            super(continuation);
            this.c = getConfigUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, AppConfig>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetConfigUseCase(@NotNull CommonRepository commonRepository, @NotNull String str) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(str, "flowName");
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends AppConfig>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, AppConfig>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetConfigUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getSession().getFlowName());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.domain.GetConfigUseCase.Params r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.AppConfig>> r10) {
        /*
            r8 = this;
            boolean r9 = r10 instanceof com.sumsub.sns.core.domain.GetConfigUseCase.a
            if (r9 == 0) goto L_0x0013
            r9 = r10
            com.sumsub.sns.core.domain.GetConfigUseCase$a r9 = (com.sumsub.sns.core.domain.GetConfigUseCase.a) r9
            int r0 = r9.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r9.b = r0
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.GetConfigUseCase$a r9 = new com.sumsub.sns.core.domain.GetConfigUseCase$a
            r9.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r9.a
            java.lang.Object r6 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r0 = r9.b
            r7 = 2
            r1 = 1
            if (r0 == 0) goto L_0x003e
            if (r0 == r1) goto L_0x0034
            if (r0 != r7) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006e
        L_0x002c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0034:
            java.lang.Object r0 = r9.d
            com.sumsub.sns.core.domain.GetConfigUseCase r0 = (com.sumsub.sns.core.domain.GetConfigUseCase) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x003c }
            goto L_0x0058
        L_0x003c:
            r10 = move-exception
            goto L_0x0062
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.sumsub.sns.core.data.source.common.CommonRepository r0 = r8.getCommonRepository()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r10 = r8.b     // Catch:{ Exception -> 0x0060 }
            r2 = 0
            r4 = 2
            r5 = 0
            r9.d = r8     // Catch:{ Exception -> 0x0060 }
            r9.b = r1     // Catch:{ Exception -> 0x0060 }
            r1 = r10
            r3 = r9
            java.lang.Object r10 = com.sumsub.sns.core.data.source.common.CommonRepository.DefaultImpls.getConfig$default(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0060 }
            if (r10 != r6) goto L_0x0057
            return r6
        L_0x0057:
            r0 = r8
        L_0x0058:
            com.sumsub.sns.core.data.model.AppConfig r10 = (com.sumsub.sns.core.data.model.AppConfig) r10
            com.sumsub.sns.core.domain.model.Either$Right r1 = new com.sumsub.sns.core.domain.model.Either$Right
            r1.<init>(r10)
            return r1
        L_0x0060:
            r10 = move-exception
            r0 = r8
        L_0x0062:
            r1 = 0
            r9.d = r1
            r9.b = r7
            java.lang.Object r10 = r0.onWrapException(r10, r9)
            if (r10 != r6) goto L_0x006e
            return r6
        L_0x006e:
            com.sumsub.sns.core.domain.model.Either$Left r9 = new com.sumsub.sns.core.domain.model.Either$Left
            r9.<init>(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.GetConfigUseCase.run(com.sumsub.sns.core.domain.GetConfigUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
