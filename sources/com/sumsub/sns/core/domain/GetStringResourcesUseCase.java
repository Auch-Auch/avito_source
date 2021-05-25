package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J7\u0010\t\u001a\u001e\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "", "", "Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "language", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Ljava/lang/String;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class GetStringResourcesUseCase extends BaseUseCase<Map<String, ? extends String>, Params> {
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase$Params;", "", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.GetStringResourcesUseCase", f = "GetStringResourcesUseCase.kt", i = {0}, l = {17, 20}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetStringResourcesUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetStringResourcesUseCase getStringResourcesUseCase, Continuation continuation) {
            super(continuation);
            this.c = getStringResourcesUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, ? extends Map<String, String>>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetStringResourcesUseCase(@NotNull CommonRepository commonRepository, @NotNull String str) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(str, "language");
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Map<String, ? extends String>>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, ? extends Map<String, String>>>) continuation);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GetStringResourcesUseCase(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.ServiceLocator r3) {
        /*
            r2 = this;
            java.lang.String r0 = "serviceLocator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.sumsub.sns.core.data.source.common.CommonRepository r0 = r3.getCommonRepository()
            com.sumsub.sns.core.common.SNSSession r3 = r3.getSession()
            java.util.Locale r3 = r3.getLocale()
            java.lang.String r3 = r3.getLanguage()
            java.lang.String r1 = "serviceLocator.session.locale.language"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.GetStringResourcesUseCase.<init>(com.sumsub.sns.core.ServiceLocator):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.domain.GetStringResourcesUseCase.Params r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, ? extends java.util.Map<java.lang.String, java.lang.String>>> r8) {
        /*
            r6 = this;
            boolean r7 = r8 instanceof com.sumsub.sns.core.domain.GetStringResourcesUseCase.a
            if (r7 == 0) goto L_0x0013
            r7 = r8
            com.sumsub.sns.core.domain.GetStringResourcesUseCase$a r7 = (com.sumsub.sns.core.domain.GetStringResourcesUseCase.a) r7
            int r0 = r7.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r7.b = r0
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.GetStringResourcesUseCase$a r7 = new com.sumsub.sns.core.domain.GetStringResourcesUseCase$a
            r7.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r7.a
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r7.b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00dd
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r1 = r7.d
            com.sumsub.sns.core.domain.GetStringResourcesUseCase r1 = (com.sumsub.sns.core.domain.GetStringResourcesUseCase) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x003d }
            goto L_0x0055
        L_0x003d:
            r8 = move-exception
            goto L_0x00d1
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            com.sumsub.sns.core.data.source.common.CommonRepository r8 = r6.getCommonRepository()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r6.b     // Catch:{ Exception -> 0x00cf }
            r7.d = r6     // Catch:{ Exception -> 0x00cf }
            r7.b = r3     // Catch:{ Exception -> 0x00cf }
            java.lang.Object r8 = r8.getStringResources(r1, r7)     // Catch:{ Exception -> 0x00cf }
            if (r8 != r0) goto L_0x0054
            return r0
        L_0x0054:
            r1 = r6
        L_0x0055:
            java.util.Map r8 = (java.util.Map) r8
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0064:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            boolean r5 = r5 instanceof java.lang.String
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0064
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x0064
        L_0x008c:
            java.util.ArrayList r8 = new java.util.ArrayList
            int r4 = r3.size()
            r8.<init>(r4)
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x009d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00c5
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r4 == 0) goto L_0x00bd
            java.lang.String r4 = (java.lang.String) r4
            kotlin.Pair r4 = kotlin.TuplesKt.to(r5, r4)
            r8.add(r4)
            goto L_0x009d
        L_0x00bd:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.String"
            r8.<init>(r3)
            throw r8
        L_0x00c5:
            java.util.Map r8 = t6.n.r.toMap(r8)
            com.sumsub.sns.core.domain.model.Either$Right r3 = new com.sumsub.sns.core.domain.model.Either$Right
            r3.<init>(r8)
            return r3
        L_0x00cf:
            r8 = move-exception
            r1 = r6
        L_0x00d1:
            r3 = 0
            r7.d = r3
            r7.b = r2
            java.lang.Object r8 = r1.onWrapException(r8, r7)
            if (r8 != r0) goto L_0x00dd
            return r0
        L_0x00dd:
            com.sumsub.sns.core.domain.model.Either$Left r7 = new com.sumsub.sns.core.domain.model.Either$Left
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.GetStringResourcesUseCase.run(com.sumsub.sns.core.domain.GetStringResourcesUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
