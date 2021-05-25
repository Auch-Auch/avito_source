package com.sumsub.sns.actions.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Action;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/Action;", "Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
public final class GetActionByIdUseCase extends BaseUseCase<Action, Params> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "id", "force", "copy", "(Ljava/lang/String;Z)Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase$Params;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Z", "getForce", "<init>", "(Ljava/lang/String;Z)V", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final String a;
        public final boolean b;

        public Params(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.a = str;
            this.b = z;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.a;
            }
            if ((i & 2) != 0) {
                z = params.b;
            }
            return params.copy(str, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final Params copy(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Params(str, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && this.b == params.b;
        }

        public final boolean getForce() {
            return this.b;
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(id=");
            L.append(this.a);
            L.append(", force=");
            return a2.b.a.a.a.B(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(String str, boolean z, int i, j jVar) {
            this(str, (i & 2) != 0 ? false : z);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.actions.domain.GetActionByIdUseCase", f = "GetActionByIdUseCase.kt", i = {0}, l = {15, 18}, m = "run", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetActionByIdUseCase c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetActionByIdUseCase getActionByIdUseCase, Continuation continuation) {
            super(continuation);
            this.c = getActionByIdUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, Action>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetActionByIdUseCase(@NotNull CommonRepository commonRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Action>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, Action>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetActionByIdUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.sumsub.sns.core.domain.base.BaseUseCase] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.actions.domain.GetActionByIdUseCase.Params r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.Action>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.actions.domain.GetActionByIdUseCase.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.actions.domain.GetActionByIdUseCase$a r0 = (com.sumsub.sns.actions.domain.GetActionByIdUseCase.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.actions.domain.GetActionByIdUseCase$a r0 = new com.sumsub.sns.actions.domain.GetActionByIdUseCase$a
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
            goto L_0x006f
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.d
            com.sumsub.sns.actions.domain.GetActionByIdUseCase r6 = (com.sumsub.sns.actions.domain.GetActionByIdUseCase) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x003c }
            goto L_0x0059
        L_0x003c:
            r7 = move-exception
            goto L_0x0063
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.sumsub.sns.core.data.source.common.CommonRepository r7 = r5.getCommonRepository()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = r6.getId()     // Catch:{ Exception -> 0x0061 }
            boolean r6 = r6.getForce()     // Catch:{ Exception -> 0x0061 }
            r0.d = r5     // Catch:{ Exception -> 0x0061 }
            r0.b = r4     // Catch:{ Exception -> 0x0061 }
            java.lang.Object r7 = r7.getActionById(r2, r6, r0)     // Catch:{ Exception -> 0x0061 }
            if (r7 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r6 = r5
        L_0x0059:
            com.sumsub.sns.core.data.model.Action r7 = (com.sumsub.sns.core.data.model.Action) r7
            com.sumsub.sns.core.domain.model.Either$Right r2 = new com.sumsub.sns.core.domain.model.Either$Right
            r2.<init>(r7)
            goto L_0x0074
        L_0x0061:
            r7 = move-exception
            r6 = r5
        L_0x0063:
            r2 = 0
            r0.d = r2
            r0.b = r3
            java.lang.Object r7 = r6.onWrapException(r7, r0)
            if (r7 != r1) goto L_0x006f
            return r1
        L_0x006f:
            com.sumsub.sns.core.domain.model.Either$Left r2 = new com.sumsub.sns.core.domain.model.Either$Left
            r2.<init>(r7)
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.actions.domain.GetActionByIdUseCase.run(com.sumsub.sns.actions.domain.GetActionByIdUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
