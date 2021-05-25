package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/domain/SetSdkStateUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "", "Lcom/sumsub/sns/core/domain/SetSdkStateUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/core/domain/SetSdkStateUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SetSdkStateUseCase extends BaseUseCase<Unit, Params> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/domain/SetSdkStateUseCase$Params;", "", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "component1", "()Lcom/sumsub/sns/core/data/model/SNSSDKState;", "state", "copy", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;)Lcom/sumsub/sns/core/domain/SetSdkStateUseCase$Params;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "getState", "<init>", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final SNSSDKState a;

        public Params(@NotNull SNSSDKState sNSSDKState) {
            Intrinsics.checkNotNullParameter(sNSSDKState, "state");
            this.a = sNSSDKState;
        }

        public static /* synthetic */ Params copy$default(Params params, SNSSDKState sNSSDKState, int i, Object obj) {
            if ((i & 1) != 0) {
                sNSSDKState = params.a;
            }
            return params.copy(sNSSDKState);
        }

        @NotNull
        public final SNSSDKState component1() {
            return this.a;
        }

        @NotNull
        public final Params copy(@NotNull SNSSDKState sNSSDKState) {
            Intrinsics.checkNotNullParameter(sNSSDKState, "state");
            return new Params(sNSSDKState);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Params) && Intrinsics.areEqual(this.a, ((Params) obj).a);
            }
            return true;
        }

        @NotNull
        public final SNSSDKState getState() {
            return this.a;
        }

        public int hashCode() {
            SNSSDKState sNSSDKState = this.a;
            if (sNSSDKState != null) {
                return sNSSDKState.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(state=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.domain.SetSdkStateUseCase", f = "SetSdkStateUseCase.kt", i = {0}, l = {15, 18}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SetSdkStateUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SetSdkStateUseCase setSdkStateUseCase, Continuation continuation) {
            super(continuation);
            this.c = setSdkStateUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, Unit>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetSdkStateUseCase(@NotNull CommonRepository commonRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Unit>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, Unit>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SetSdkStateUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.core.domain.SetSdkStateUseCase.Params r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, kotlin.Unit>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.domain.SetSdkStateUseCase.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.domain.SetSdkStateUseCase$a r0 = (com.sumsub.sns.core.domain.SetSdkStateUseCase.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.domain.SetSdkStateUseCase$a r0 = new com.sumsub.sns.core.domain.SetSdkStateUseCase$a
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
            goto L_0x006b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.domain.SetSdkStateUseCase r6 = (com.sumsub.sns.core.domain.SetSdkStateUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x003c }
            goto L_0x0055
        L_0x003c:
            r7 = move-exception
            goto L_0x005f
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.sumsub.sns.core.data.source.common.CommonRepository r7 = r5.getCommonRepository()     // Catch:{ Exception -> 0x005d }
            com.sumsub.sns.core.data.model.SNSSDKState r6 = r6.getState()     // Catch:{ Exception -> 0x005d }
            r0.d = r5     // Catch:{ Exception -> 0x005d }
            r0.b = r4     // Catch:{ Exception -> 0x005d }
            java.lang.Object r6 = r7.setSDKState(r6, r0)     // Catch:{ Exception -> 0x005d }
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r5
        L_0x0055:
            com.sumsub.sns.core.domain.model.Either$Right r7 = new com.sumsub.sns.core.domain.model.Either$Right
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r7.<init>(r2)
            return r7
        L_0x005d:
            r7 = move-exception
            r6 = r5
        L_0x005f:
            r2 = 0
            r0.d = r2
            r0.b = r3
            java.lang.Object r7 = r6.onWrapException(r7, r0)
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            com.sumsub.sns.core.domain.model.Either$Left r6 = new com.sumsub.sns.core.domain.model.Either$Left
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.domain.SetSdkStateUseCase.run(com.sumsub.sns.core.domain.SetSdkStateUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
