package com.sumsub.sns.core.domain.base;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001HBø\u0001\u0000¢\u0006\u0004\b\n\u0010\tJ#\u0010\f\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Type", "Params", "", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", OkListener.KEY_EXCEPTION, "onWrapException", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "getCommonRepository", "()Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseUseCase<Type, Params> {
    @NotNull
    public final CommonRepository a;

    @DebugMetadata(c = "com.sumsub.sns.core.domain.base.BaseUseCase", f = "BaseUseCase.kt", i = {0}, l = {19, 21}, m = "invoke$suspendImpl", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ BaseUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BaseUseCase baseUseCase, Continuation continuation) {
            super(continuation);
            this.c = baseUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return BaseUseCase.a(this.c, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.base.BaseUseCase", f = "BaseUseCase.kt", i = {0, 1, 2, 3, 4}, l = {35, 37, 38, 47, 48}, m = "onWrapException", n = {OkListener.KEY_EXCEPTION, OkListener.KEY_EXCEPTION, OkListener.KEY_EXCEPTION, OkListener.KEY_EXCEPTION, OkListener.KEY_EXCEPTION}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ BaseUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BaseUseCase baseUseCase, Continuation continuation) {
            super(continuation);
            this.c = baseUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.onWrapException(null, this);
        }
    }

    public BaseUseCase(@NotNull CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.a = commonRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.core.domain.base.BaseUseCase r5, java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof com.sumsub.sns.core.domain.base.BaseUseCase.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.domain.base.BaseUseCase$a r0 = (com.sumsub.sns.core.domain.base.BaseUseCase.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.base.BaseUseCase$a r0 = new com.sumsub.sns.core.domain.base.BaseUseCase$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.d
            com.sumsub.sns.core.domain.base.BaseUseCase r5 = (com.sumsub.sns.core.domain.base.BaseUseCase) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x004d }
            goto L_0x004a
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.d = r5
            r0.b = r4
            java.lang.Object r7 = r5.run(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.sumsub.sns.core.domain.model.Either r7 = (com.sumsub.sns.core.domain.model.Either) r7
            goto L_0x0060
        L_0x004d:
            r6 = move-exception
            r7 = 0
            r0.d = r7
            r0.b = r3
            java.lang.Object r7 = r5.onWrapException(r6, r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            com.sumsub.sns.core.domain.model.Either$Left r5 = new com.sumsub.sns.core.domain.model.Either$Left
            r5.<init>(r7)
            r7 = r5
        L_0x0060:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.base.BaseUseCase.a(com.sumsub.sns.core.domain.base.BaseUseCase, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final CommonRepository getCommonRepository() {
        return this.a;
    }

    @Nullable
    public Object invoke(Params params, @NotNull Continuation<? super Either<? extends Exception, ? extends Type>> continuation) {
        return a(this, params, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onWrapException(@org.jetbrains.annotations.NotNull java.lang.Exception r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Exception> r10) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.base.BaseUseCase.onWrapException(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public abstract Object run(Params params, @NotNull Continuation<? super Either<? extends Exception, ? extends Type>> continuation);
}
