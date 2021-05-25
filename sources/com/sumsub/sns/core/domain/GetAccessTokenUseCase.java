package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/domain/GetAccessTokenUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "", "Lcom/sumsub/sns/core/domain/GetAccessTokenUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/core/domain/GetAccessTokenUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "repository", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/common/CommonRepository;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class GetAccessTokenUseCase extends BaseUseCase<String, Params> {
    public final CommonRepository b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/domain/GetAccessTokenUseCase$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "applicantId", ChannelContext.Item.USER_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/domain/GetAccessTokenUseCase$Params;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getApplicantId", AuthSource.BOOKING_ORDER, "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        public Params(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "applicantId");
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.a;
            }
            if ((i & 2) != 0) {
                str2 = params.b;
            }
            return params.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Params copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "applicantId");
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            return new Params(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && Intrinsics.areEqual(this.b, params.b);
        }

        @NotNull
        public final String getApplicantId() {
            return this.a;
        }

        @NotNull
        public final String getUserId() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(applicantId=");
            L.append(this.a);
            L.append(", userId=");
            return a2.b.a.a.a.t(L, this.b, ")");
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.GetAccessTokenUseCase", f = "GetAccessTokenUseCase.kt", i = {0}, l = {14, 17}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetAccessTokenUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetAccessTokenUseCase getAccessTokenUseCase, Continuation continuation) {
            super(continuation);
            this.c = getAccessTokenUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, String>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAccessTokenUseCase(@NotNull CommonRepository commonRepository, @NotNull CommonRepository commonRepository2) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(commonRepository2, "repository");
        this.b = commonRepository2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends String>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, String>>) continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.sumsub.sns.core.domain.base.BaseUseCase] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.domain.GetAccessTokenUseCase.Params r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, java.lang.String>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.domain.GetAccessTokenUseCase.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.domain.GetAccessTokenUseCase$a r0 = (com.sumsub.sns.core.domain.GetAccessTokenUseCase.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.GetAccessTokenUseCase$a r0 = new com.sumsub.sns.core.domain.GetAccessTokenUseCase$a
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
            goto L_0x0072
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.domain.GetAccessTokenUseCase r6 = (com.sumsub.sns.core.domain.GetAccessTokenUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x003c }
            goto L_0x0057
        L_0x003c:
            r7 = move-exception
            goto L_0x0066
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.sumsub.sns.core.data.source.common.CommonRepository r7 = r5.b     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = r6.getApplicantId()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r6.getUserId()     // Catch:{ Exception -> 0x0064 }
            r0.d = r5     // Catch:{ Exception -> 0x0064 }
            r0.b = r4     // Catch:{ Exception -> 0x0064 }
            java.lang.Object r7 = r7.getAccessToken(r2, r6, r0)     // Catch:{ Exception -> 0x0064 }
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r6 = r5
        L_0x0057:
            java.lang.String r7 = (java.lang.String) r7
            com.sumsub.sns.core.domain.model.Either$Right r2 = new com.sumsub.sns.core.domain.model.Either$Right
            if (r7 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            java.lang.String r7 = ""
        L_0x0060:
            r2.<init>(r7)
            return r2
        L_0x0064:
            r7 = move-exception
            r6 = r5
        L_0x0066:
            r2 = 0
            r0.d = r2
            r0.b = r3
            java.lang.Object r7 = r6.onWrapException(r7, r0)
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            com.sumsub.sns.core.domain.model.Either$Left r6 = new com.sumsub.sns.core.domain.model.Either$Left
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.GetAccessTokenUseCase.run(com.sumsub.sns.core.domain.GetAccessTokenUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
